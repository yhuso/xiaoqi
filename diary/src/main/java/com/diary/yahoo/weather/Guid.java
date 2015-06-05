package com.diary.yahoo.weather;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Guid {
	private boolean isPermaLink;
	private String value;
	
	@XmlAttribute
	public boolean isPermaLink() {
		return isPermaLink;
	}

	public void setPermaLink(boolean isPermaLink) {
		this.isPermaLink = isPermaLink;
	}

	@XmlValue
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
