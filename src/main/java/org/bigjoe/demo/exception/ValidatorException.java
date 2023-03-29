package org.bigjoe.demo.exception;

public class ValidatorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String error = null;

	public ValidatorException(String msg) {
		this.setError(msg);
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
