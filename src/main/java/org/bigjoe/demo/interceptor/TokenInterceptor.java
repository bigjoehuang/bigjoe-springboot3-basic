package org.bigjoe.demo.interceptor;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

	Logger log = LoggerFactory.getLogger(TokenInterceptor.class);

//	@Value("${server.appEnv}")
//	private String appEnv;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String method = request.getMethod();
		String requestURL = request.getRequestURI();
		String token = request.getHeader("token");
		
		String requestNo = System.currentTimeMillis() + "-" + RandomStringUtils.randomAlphabetic(8);
		MDC.put("requestNo", requestNo);

		log.debug("----------------{}:{}----------------", method, requestURL);

		if (token == null) {
			token = request.getParameter("token");
		}
//		if (Strings.isBlank(token)) {
//			throw new AppException("当前用户未登录");
//		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
