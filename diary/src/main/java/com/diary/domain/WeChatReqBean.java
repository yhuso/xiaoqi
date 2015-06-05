package com.diary.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class WeChatReqBean {
	private String toUserName;
	private String fromUserName;
	private Long createTime;
	private String msgType;
	private Long msgId;

	//1.text专有属性
	private String content;
	
	//image,voice,video共有属性
	private String mediaId;
	
	//2.image专有属性
	private String picUrl;

	//3.voice专有属性
	private String format;	//语音格式
	
	//4.video专有属性
	private String thumbMediaId;
	
	//5.location专有属性
	private Double location_X;
	private Double location_Y;
	private Integer scale;
	private String label;
	
	//6.link专有属性
	private String title;
	private String description;
	private String url;
	
	public String getMediaId() {
		return mediaId;
	}

	//@XmlCDATA
	@XmlElement(name = "MediaId")
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	//@XmlCDATA
	@XmlElement(name = "PicUrl")
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getFormat() {
		return format;
	}

	//@XmlCDATA
	@XmlElement(name = "Format")
	public void setFormat(String format) {
		this.format = format;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	//@XmlCDATA
	@XmlElement(name = "ThumbMediaId")
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getTitle() {
		return title;
	}

	//@XmlCDATA
	@XmlElement(name = "Title")
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	//@XmlCDATA
	@XmlElement(name = "Description")
	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	//@XmlCDATA
	@XmlElement(name = "Url")
	public void setUrl(String url) {
		this.url = url;
	}

	public String getToUserName() {
		return toUserName;
	}
	
	//@XmlCDATA
	@XmlElement(name = "ToUserName")
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}
	
	//@XmlCDATA
	@XmlElement(name = "FromUserName")
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	@XmlElement(name = "CreateTime")
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	//@XmlCDATA
	@XmlElement(name = "MsgType")
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	//@XmlCDATA
	@XmlElement(name = "Content")
	public void setContent(String content) {
		this.content = content;
	}

	public Double getLocation_X() {
		return location_X;
	}
	
	@XmlElement(name = "Location_X")
	public void setLocation_X(Double location_X) {
		this.location_X = location_X;
	}

	public Double getLocation_Y() {
		return location_Y;
	}

	@XmlElement(name = "Location_Y")
	public void setLocation_Y(Double location_Y) {
		this.location_Y = location_Y;
	}

	public Integer getScale() {
		return scale;
	}

	@XmlElement(name = "Scale")
	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	//@XmlCDATA
	@XmlElement(name = "Label")
	public void setLabel(String label) {
		this.label = label;
	}

	public Long getMsgId() {
		return msgId;
	}

	@XmlElement(name = "MsgId")
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	
}
