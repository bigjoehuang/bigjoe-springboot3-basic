package org.bigjoe.demo.dao;

import java.util.Collection;
import java.util.List;

import org.bigjoe.demo.entity.Account;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.annotation.Nullable;

//Repository：最顶层的接口，是一个空的接口，目的是为了统一所有Repository的类型，且能让组件扫描的时候自动识别。
//|--CrudRepository：是Repository的子接口，提供CRUD的功能。
//|--|--PagingAndSortingRepository ：是CrudRepository的子接口，添加分页和排序的功能。
//|--|--|--JpaRepository ：是PagingAndSortingRepository的子接口，增加了批量操作等功能。

public interface AccountDao extends JpaRepository<Account, Integer> {

//	strongly advise following standard Java naming conventions 
//	(that is, not using underscores in property names but using camel case instead).
	@Cacheable(value = "olympic_match_new_action", key = "'get_relate_news_'+#orgId")
	List<Account> findByOrgId(int orgId);

	List<Account> findByIdIn(@Param("id") Collection<Integer> idList);

	Page<Account> findByOrgId(int orgId, Pageable pageable);

//	nativeQuery: 为 true 开启。开启之后字段则需要对应的数据库中的表名和字段。
	@Query("SELECT id, accountId, name FROM account WHERE name = :name ")
	Account findFirstByName(@Param("name") String name);

	List<Account> findAll(@Nullable Specification var1);

	@Query(value = "UPDATE account SET name=:name WHERE id=:id")
	@Modifying
	int updateName(Long id, String name);
}