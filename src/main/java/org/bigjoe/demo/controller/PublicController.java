package org.bigjoe.demo.controller;

import org.bigjoe.demo.dto.StudentDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/public")
public class PublicController {

	@PostMapping("/post")
	public String post(@RequestBody @Valid StudentDto student) {
		return String.format("pong");
	}
	
}
