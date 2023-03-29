package org.bigjoe.demo.controller;

import org.bigjoe.demo.entity.DeveloperProperty;
import org.bigjoe.demo.service.AdminApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor // 代替 @Value
public class TestController {

	final DeveloperProperty developerProperty;
	
	@Autowired AdminApiService apiService;

	@GetMapping("/property")
	public Object index() {
		return developerProperty.getName();
	}
	
	@GetMapping("/ad")
	public Object ad(@RequestParam("token") String token) {
		return apiService.getXmpAuth(token);
	}

}
