package com.diary.yahoo.weather.yweather;

import javax.xml.bind.annotation.XmlAttribute;

public class Location {
	private String city;
	private String region;
	private String country;

	@XmlAttribute
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@XmlAttribute
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@XmlAttribute
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
