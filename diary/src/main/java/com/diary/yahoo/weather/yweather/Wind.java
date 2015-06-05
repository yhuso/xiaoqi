package com.diary.yahoo.weather.yweather;

import javax.xml.bind.annotation.XmlAttribute;

public class Wind {
	private int chill;
	private int direction;
	private double speed;

	@XmlAttribute
	public int getChill() {
		return chill;
	}

	public void setChill(int chill) {
		this.chill = chill;
	}

	@XmlAttribute
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	@XmlAttribute
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

}
