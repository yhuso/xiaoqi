package com.diary.yahoo.weather;

import javax.xml.bind.annotation.XmlElement;

import com.diary.yahoo.weather.yweather.Astronomy;
import com.diary.yahoo.weather.yweather.Atmosphere;
import com.diary.yahoo.weather.yweather.Location;
import com.diary.yahoo.weather.yweather.Units;
import com.diary.yahoo.weather.yweather.Wind;

public class Channel {
	private String title;
	private String link;
	private String description;
	private String language;
	private String lastBuildDate;
	private int ttl;
	private Location location;
	private Units units;
	private Wind wind;
	private Atmosphere atmosphere;
	private Astronomy astronomy;
	private Image image;
	private Item item;

	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@XmlElement
	public String getLastBuildDate() {
		return lastBuildDate;
	}

	public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	@XmlElement
	public int getTtl() {
		return ttl;
	}

	public void setTtl(int ttl) {
		this.ttl = ttl;
	}

	@XmlElement(namespace = "http://xml.weather.yahoo.com/ns/rss/1.0")
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	@XmlElement(namespace = "http://xml.weather.yahoo.com/ns/rss/1.0")
	public Units getUnits() {
		return units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	@XmlElement(namespace = "http://xml.weather.yahoo.com/ns/rss/1.0")
	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	@XmlElement(namespace = "http://xml.weather.yahoo.com/ns/rss/1.0")
	public Atmosphere getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(Atmosphere atmosphere) {
		this.atmosphere = atmosphere;
	}

	@XmlElement(namespace = "http://xml.weather.yahoo.com/ns/rss/1.0")
	public Astronomy getAstronomy() {
		return astronomy;
	}

	public void setAstronomy(Astronomy astronomy) {
		this.astronomy = astronomy;
	}

	@XmlElement
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@XmlElement
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
