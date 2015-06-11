package com.diary.domain.response;

import java.util.ArrayList;
import java.util.List;

public class Post {
	private List<String> texts = new ArrayList<String>();//一条Post包含的文本
	private List<String> images = new ArrayList<String>();//一条Post包含的图片
	private String date;
	private String time;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<String> getTexts() {
		return texts;
	}
	public List<String> getImages() {
		return images;
	}
}
