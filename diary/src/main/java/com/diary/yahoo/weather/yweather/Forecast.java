package com.diary.yahoo.weather.yweather;

import javax.xml.bind.annotation.XmlAttribute;

public class Forecast {
	private String day;
	private String date;
	private int low;
	private int high;
	private String text;
	private int code;

	@XmlAttribute
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@XmlAttribute
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@XmlAttribute
	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	@XmlAttribute
	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

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

}
