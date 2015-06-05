package com.diary.yahoo.weather.yweather;

import javax.xml.bind.annotation.XmlAttribute;

public class Astronomy {
	private String sunrise;
	private String sunset;

	@XmlAttribute
	public String getSunrise() {
		return sunrise;
	}

	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	@XmlAttribute
	public String getSunset() {
		return sunset;
	}

	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

}
