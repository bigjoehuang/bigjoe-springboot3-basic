package org.bigjoe.demo.dao;

import org.bigjoe.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByUsernameAndPassword(String userName, String password);
}