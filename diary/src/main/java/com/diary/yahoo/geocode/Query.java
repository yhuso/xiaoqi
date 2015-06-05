package com.diary.yahoo.geocode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "query")
public class Query {
//	private Integer error;
//	private String errorMessage;
//	private String locale;
//	private Integer found;
//	private Integer quality;
	private Results results;

	public Query() {
	}

//	public Integer getError() {
//		return error;
//	}
//
//	@XmlElement(name = "Error")
//	public void setError(Integer error) {
//		this.error = error;
//	}
//
//	public String getErrorMessage() {
//		return errorMessage;
//	}
//
//	@XmlElement(name = "ErrorMessage")
//	public void setErrorMessage(String errorMessage) {
//		this.errorMessage = errorMessage;
//	}
//
//	public String getLocale() {
//		return locale;
//	}
//
//	@XmlElement(name = "Locale")
//	public void setLocale(String locale) {
//		this.locale = locale;
//	}
//
//	public Integer getFound() {
//		return found;
//	}
//
//	@XmlElement(name = "Found")
//	public void setFound(Integer found) {
//		this.found = found;
//	}
//
//	public Integer getQuality() {
//		return quality;
//	}
//
//	@XmlElement(name = "Quality")
//	public void setQuality(Integer quality) {
//		this.quality = quality;
//	}

	public Results getResults() {
		return results;
	}

	@XmlElement(name = "results")
	public void setResult(Results results) {
		this.results = results;
	}

}
