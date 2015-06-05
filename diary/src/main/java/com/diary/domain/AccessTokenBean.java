package com.diary.domain;

public class AccessTokenBean {
	private static AccessTokenBean accessTokenBean = new AccessTokenBean();
	
	private String access_token;
	private int expires_in;
	
	private AccessTokenBean(){
		
	}
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	
	public static AccessTokenBean getInstance(){
		return accessTokenBean;
	}
}
