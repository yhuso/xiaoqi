package com.diary.domain.stateBean;

import lombok.Data;

@Data
public class UserState {
	private String userName;
	private Integer mode;//当前模式 
	private Integer groupId;//当前信息所属组
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
}
