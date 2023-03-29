package org.bigjoe.demo.controller;

import org.bigjoe.demo.dto.StudentDto;
import org.bigjoe.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hello")
@Validated
public class HelloController {
	@Autowired
	private RedisTemplate redisTemplate;

	@PostMapping("/post")
	public String post(@RequestBody @Valid StudentDto student) {
		return String.format("pong");
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/redis")
	public void redis() throws Exception {
		User user = new User();
		user.setPassword("123456");

		ValueOperations<String, User> operations = redisTemplate.opsForValue();
		operations.set("fdd2", user);

		boolean exists = redisTemplate.hasKey("fdd2");
		System.out.println("redis是否存在相应的key" + exists);

		User getUser = (User) redisTemplate.opsForValue().get("fdd2");
		System.out.println("从redis数据库获取的user:" + getUser.toString());

	}
}
