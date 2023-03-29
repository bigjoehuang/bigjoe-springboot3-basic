package org.bigjoe.demo.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.bigjoe.demo.config.ErrorCode;
import org.bigjoe.demo.entity.ResultJson;
import org.bigjoe.demo.interceptor.TokenInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

	Logger log = LoggerFactory.getLogger(TokenInterceptor.class);

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(AppException.class)
	@ResponseBody
	public ResultJson appExcetionHandler(AppException e) {
		
		log.error("ex={}", e.getError());

		return new ResultJson(ErrorCode.AUTH_ERROR.getCode(), e.getError());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResultJson validatorExcetionHandler(MethodArgumentNotValidException e) {
		
		List<String> errors = e.getBindingResult().getAllErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

		return new ResultJson(ErrorCode.PARAM_ERROR.getCode(), errors.toString());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResultJson excetionHandler(Exception e) {
		e.printStackTrace();

		return new ResultJson(ErrorCode.UNKONW_ERROR.getCode(), e.getLocalizedMessage());
	}
}


