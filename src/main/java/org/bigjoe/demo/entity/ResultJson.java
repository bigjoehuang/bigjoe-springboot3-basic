package org.bigjoe.demo.entity;

import lombok.Data;

@Data
public class ResultJson {
	private static final int SUCCESS_CODE = 0;

	private int code = 0;
	private String msg;

	private Object data;

	public ResultJson() {
		this.code = SUCCESS_CODE;
		this.msg = "";
	}

	public ResultJson(Object data) {
		this.code = SUCCESS_CODE;
		this.msg = "";
		this.data = data;
	}

	public ResultJson(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ResultJson(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
}
