package com.diary.domain.stateBean;

import lombok.Data;

@Data
public class UserState {
	private String userName;
	private Integer mode;//当前模式 
	private Integer groupId;//当前信息所属组
}
