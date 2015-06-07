package com.diary.aop;



public class BusinessException extends RuntimeException {

	private int status = 0;
	private String message;
	
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
