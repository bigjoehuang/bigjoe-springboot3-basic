package org.bigjoe.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.bigjoe.demo.dao.AccountDao;
import org.bigjoe.demo.entity.Account;
import org.bigjoe.demo.entity.PageVo;
import org.bigjoe.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class AccountService {

	@Autowired
	AccountDao dao;
	
	public Object byIds(List<Integer> ids) {
		
		return dao.findByIdIn(ids);
	}

	public List<Account> findAll() {
		return dao.findAll();
	}

	public List<Account> findByOrgId(int orgId) {
		return dao.findByOrgId(orgId);
	}

	public Object findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	public PageVo pageable(int orgId, Pageable pageable) {
		Page<Account> pg = dao.findByOrgId(orgId, pageable);

		PageVo pageVo = new PageVo();
		pageVo.setPageCount(pg.getTotalPages());
		pageVo.setRecordCount(pg.getTotalElements());
		pageVo.setList(pg.getContent());

		return pageVo;
	}

	public Object findByName(String name) {
		return dao.findFirstByName(name);
	}

	public Object search(String keyword) {
		int page = 0;
		int size = 10;
		Pageable pageable = PageRequest.of(page, size);
		Account account = new Account();

		Specification<Account> s1 = new Specification<Account>() {
			@Override
			public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();

				if (!"".equals(keyword)) {
					predicates.add(cb.like(root.get("name"), "%" + keyword + "%"));
					
					if (isInteger(keyword)) {
						predicates.add(cb.equal(root.get("accountId"), keyword));
					}
				}

				return cb.or(predicates.toArray(new Predicate[predicates.size()]));
			}
		};

		return dao.findAll(s1);
	}

	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

}