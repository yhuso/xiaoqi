package com.diary.aop;



public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = -7392788576659453070L;
	private int status = 0;
	private String message;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BusinessException(ErrorEnum errorEnum) {
		super(errorEnum.getMessage());
		this.status = errorEnum.getStatus();
		this.message = errorEnum.getMessage();
	}

	public BusinessException(int status, String message) {
		super(message);
		this.status = status;
		this.message = message;
	}

}
