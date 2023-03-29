package org.bigjoe.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.bigjoe.demo.dto.AccountDto;
import org.bigjoe.demo.entity.PageVo;
import org.bigjoe.demo.filter.JpaLogAspect;
import org.bigjoe.demo.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson2.JSON;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {

	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#preface

	private static final Logger log = LoggerFactory.getLogger(JpaLogAspect.class);

	@Autowired
	AccountService accountService;

	@PostMapping("/add")
	public Object add(@RequestBody @Valid AccountDto accountDto) {
		log.debug(JSON.toJSONString(accountDto));

		return 1;
	}

	@GetMapping("/list")
	public PageVo list(
			@PageableDefault(page = 0, size = 10, sort = { "id" }, direction = Sort.Direction.ASC) Pageable pageable) {
		return null;
//		return accountService.pageable(pageable);
	}

	@GetMapping("/list2")
	public PageVo list2(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
			@RequestParam(value = "orgId", defaultValue = "0") int orgId) {

		PageRequest pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

		return accountService.pageable(orgId, pageable);
	}

	@GetMapping("/detail")
	public Object detail(@RequestParam(value = "name", defaultValue = "") String name) {

		return accountService.findByName(name);
	}

	@GetMapping("/search")
	public Object search(@RequestParam(value = "keyword", defaultValue = "") String keyword) {

		return accountService.search(keyword);
	}

	@GetMapping("/byIds")
	public Object byIds() {
		List<Integer> intList = Stream.of(3, 4, 5).collect(Collectors.toList());

		return accountService.byIds(intList);
	}

}
