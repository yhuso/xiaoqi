package com.diary.yahoo.geocode;

import javax.xml.bind.annotation.XmlElement;

public class Result {
	private String quality;
	private String latitude;
	private String longitude;
	private String offsetlat;
	private String offsetlon;
	private String radius;
	private String name;
	private String line1;
	private String line2;
	private String line3;
	private String line4;
	private String house;
	private String street;
	private String xstreet;
	private String unittype;
	private String unit;
	private String postal;
	private String neighborhood;
	private String city;
	private String county;
	private String state;
	private String country;
	private String countrycode;
	private String statecode;
	private String countycode;
	private String uzip;
	private String hash;
	private String woeid;
	private String woetype;

	public Result() {
	}

	public String getQuality() {
		return quality;
	}
	
	@XmlElement
	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getLatitude() {
		return latitude;
	}

	@XmlElement
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	@XmlElement
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getOffsetlat() {
		return offsetlat;
	}

	@XmlElement
	public void setOffsetlat(String offsetlat) {
		this.offsetlat = offsetlat;
	}

	public String getOffsetlon() {
		return offsetlon;
	}

	@XmlElement
	public void setOffsetlon(String offsetlon) {
		this.offsetlon = offsetlon;
	}

	public String getRadius() {
		return radius;
	}

	@XmlElement
	public void setRadius(String radius) {
		this.radius = radius;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getLine1() {
		return line1;
	}

	@XmlElement
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	@XmlElement
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return line3;
	}

	@XmlElement
	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public String getLine4() {
		return line4;
	}

	@XmlElement
	public void setLine4(String line4) {
		this.line4 = line4;
	}

	public String getHouse() {
		return house;
	}

	@XmlElement
	public void setHouse(String house) {
		this.house = house;
	}

	public String getStreet() {
		return street;
	}

	@XmlElement
	public void setStreet(String street) {
		this.street = street;
	}

	public String getXstreet() {
		return xstreet;
	}

	@XmlElement
	public void setXstreet(String xstreet) {
		this.xstreet = xstreet;
	}

	public String getUnittype() {
		return unittype;
	}

	@XmlElement
	public void setUnittype(String unittype) {
		this.unittype = unittype;
	}

	public String getUnit() {
		return unit;
	}

	@XmlElement
	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPostal() {
		return postal;
	}

	@XmlElement
	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	@XmlElement
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	@XmlElement
	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	@XmlElement
	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	@XmlElement
	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountrycode() {
		return countrycode;
	}

	@XmlElement
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getStatecode() {
		return statecode;
	}

	@XmlElement
	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}

	public String getCountycode() {
		return countycode;
	}

	@XmlElement
	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public String getUzip() {
		return uzip;
	}

	@XmlElement
	public void setUzip(String uzip) {
		this.uzip = uzip;
	}

	public String getHash() {
		return hash;
	}

	@XmlElement
	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getWoeid() {
		return woeid;
	}

	@XmlElement
	public void setWoeid(String woeid) {
		this.woeid = woeid;
	}

	public String getWoetype() {
		return woetype;
	}

	@XmlElement
	public void setWoetype(String woetype) {
		this.woetype = woetype;
	}

}
