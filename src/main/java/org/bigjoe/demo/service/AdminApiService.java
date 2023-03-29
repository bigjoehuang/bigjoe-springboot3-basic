package org.bigjoe.demo.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "/user", accept = MediaType.APPLICATION_JSON_VALUE, contentType = MediaType.APPLICATION_JSON_VALUE)
public interface AdminApiService {

	@GetExchange("/getXmpAuth")
	Object getXmpAuth(@RequestHeader("token") String token);

}

//https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#rest-http-interface
