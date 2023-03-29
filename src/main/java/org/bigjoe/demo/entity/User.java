package org.bigjoe.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "user") // 实体类和数据表的对应关系
@Data // 不用写get set方法了
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增长
	private Integer id;// 主键

	private String username;// 用户名
	private String password;// 密码
	private String telephone;// 手机号
}