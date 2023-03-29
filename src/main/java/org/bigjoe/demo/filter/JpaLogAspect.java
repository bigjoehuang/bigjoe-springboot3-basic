package org.bigjoe.demo.filter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSON;

/**
 * 用于JPA的日志服务类
 *
 * @author zetor
 */
@Aspect
@Component
public class JpaLogAspect {

	private static final Logger log = LoggerFactory.getLogger(JpaLogAspect.class);

	@Pointcut("execution(* org.bigjoe.demo.dao.*.*(..))")
	public void getPointcut() {
	}

	@Around("getPointcut()")
	public Object logAround(ProceedingJoinPoint point) throws Throwable {
		if (!log.isDebugEnabled()) {
			return point.proceed();
		}

		long beginTime = System.currentTimeMillis();
		Object result = point.proceed();
		long time = System.currentTimeMillis() - beginTime;
		printLog(point, time);
		return result;
	}

	private void printLog(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		// 请求的 类名、方法名
		String clazz = signature.getDeclaringTypeName();
		String method = joinPoint.getSignature().getName();
		// 请求的参数
		Object[] args = joinPoint.getArgs();
		log.debug("JPA_LOG - {}:{}(), param:{}, costTime:{}", clazz, method, JSON.toJSONString(args), time);
	}

}