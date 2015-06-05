package com.diary.yahoo.weather.yweather;

import javax.xml.bind.annotation.XmlAttribute;

public class Atmosphere {
	private int humidity;
	private String visibility;
	private double pressure;
	private int rising;

	@XmlAttribute
	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	@XmlAttribute
	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	@XmlAttribute
	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	@XmlAttribute
	public int getRising() {
		return rising;
	}

	public void setRising(int rising) {
		this.rising = rising;
	}

}
