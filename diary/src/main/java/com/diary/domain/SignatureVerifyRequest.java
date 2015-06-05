package com.diary.domain;

import lombok.Data;


@Data
public class SignatureVerifyRequest {
	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;
}
