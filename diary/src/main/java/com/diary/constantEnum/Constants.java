package com.diary.constantEnum;

public class Constants {
	public final static String MSGTYPE_TEXT = "text";
	public final static String MSGTYPE_LOCATION = "location";
	public final static String MSGTYPE_IMAGE = "image";
	public final static String MSGTYPE_VIDEO = "video";
	public final static String MSGTYPE_VOICE = "voice";
	public final static String MSGTYPE_LINK = "link";
	public final static String MSGTYPE_EVENT = "event";
	
	public final static String EVENTTYPE_SUBSCRIBE = "subscribe";//订阅
	public final static String EVENTTYPE_UNSUBSCRIBE = "unsubscribe";//取消订阅
	//扫描带参数二维码事件，事件类型包括subscribe和SCAN两种
	public final static String EVENTTYPE_SCAN = "SCAN";//已关注时的事件推送
	public final static String EVENTTYPE_LOCATION = "LOCATION";//上传地理位置事件
	public final static String EVENTTYPE_CLICK = "CLICK";//自定义菜单点击事件
	public final static String EVENTTYPE_VIEW = "VIEW";//自定义菜单跳转链接事件
}
