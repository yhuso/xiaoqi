package com.diary.yahoo.weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.annotation.XmlElement;

import com.diary.yahoo.weather.yweather.Condition;
import com.diary.yahoo.weather.yweather.Forecast;

public class Item {
	private String title;
	private double lat;
	private double lon;
	private String link;
	private String pubDate;
	private Condition condition;
	private String description;
	private List<Forecast> forecasts;
	private Guid guid;

	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(namespace = "http://www.w3.org/2003/01/geo/wgs84_pos#")
	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	@XmlElement(name = "long", namespace = "http://www.w3.org/2003/01/geo/wgs84_pos#")
	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	@XmlElement
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@XmlElement
	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	@XmlElement(namespace = "http://xml.weather.yahoo.com/ns/rss/1.0")
	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@XmlElement(name = "forecast", namespace = "http://xml.weather.yahoo.com/ns/rss/1.0")
	public List<Forecast> getForecasts() {
		if (forecasts != null) {
			Collections.sort(forecasts, new Comparator<Forecast>() {
				SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy", Locale.US);
				
				@Override
				public int compare(Forecast today, Forecast tomorrow) {
					Date todayDate = new Date();
					Date tomorrowDate = new Date();
					try {
						todayDate = formatter.parse(today.getDate());
						tomorrowDate = formatter.parse(tomorrow.getDate());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return todayDate.compareTo(tomorrowDate);
				}
			});
		}
		return forecasts;
	}

	public void setForecasts(List<Forecast> forecasts) {
		this.forecasts = forecasts;
	}

	@XmlElement
	public Guid getGuid() {
		return guid;
	}

	public void setGuid(Guid guid) {
		this.guid = guid;
	}

}
