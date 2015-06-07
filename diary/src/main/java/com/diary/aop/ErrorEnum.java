package com.diary.aop;

import lombok.Getter;
import lombok.Setter;

public enum ErrorEnum {
	
	
	SOA_ERROR_100000(100000, "系统异常，请联系管理员"),
	SOA_ERROR_100001(100001, "系统异常，请检查数据"),
	SOA_ERROR_100002(100002, "上传图片错误，请稍后再试"),
	SOA_ERROR_100003(100003, "网络不稳定,图片上传失败"),
	NULL(-1, ""),
	;
	
	
	
	
	
	@Setter @Getter
	private int status;
	
	@Setter @Getter
	private String message;

	private ErrorEnum(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
}
