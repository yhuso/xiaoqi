package com.diary.yahoo.weather.yweather;

import javax.xml.bind.annotation.XmlAttribute;

public class Condition {
	private String text;
	private int code;
	private int temp;
	private String date;

	@XmlAttribute
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@XmlAttribute
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@XmlAttribute
	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	@XmlAttribute
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
