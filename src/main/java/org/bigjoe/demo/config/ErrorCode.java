package org.bigjoe.demo.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
	AUTH_ERROR(-2, "授权异常"),
	UNKONW_ERROR(-100, "未知异常"),
	PARAM_ERROR(-3, "请求参数有误，请重试"),
	SERVICE_TIME_OUT(-4, "服务调用超时！");
	 
    private final int code;
    private final String msg;

}
