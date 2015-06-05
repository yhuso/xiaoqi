package com.diary.domain.stateBean;

import java.util.HashMap;
import java.util.Map;

public class Session {
	private static Map<String,UserState> session = new HashMap<String, UserState>();
	
	public static Integer getCurGroupId(String userName){
		return getUserState(userName).getGroupId();
	}
	
	public static Integer getCurMode(String userName){
		return getUserState(userName).getMode();
	}
	
	public static void setCurGoupId(Integer groupId,String userName){
		getUserState(userName).setGroupId(groupId);
	}
	
	public static void setCurMode(Integer mode,String userName){
		getUserState(userName).setMode(mode);
	}
	
	/**
	 * 
	 * 功能描述:设置当前组号为null，写入日记完毕调用
	 *
	 * <pre>
	 * Modify Reason:(修改原因,不需覆盖，直接追加.)
	 *     bianjie:   2015年6月4日      新建
	 * </pre>
	 *
	 * @param userName
	 */
	public static void setGroupEmpty(String userName){
		getUserState(userName).setGroupId(null);
	}
	
	private synchronized static UserState getUserState(String userName){
		UserState userState = session.get(userName);
		if(userState==null){
			userState = new UserState();
			session.put(userName, userState);
		}
		return userState;
	}
}
