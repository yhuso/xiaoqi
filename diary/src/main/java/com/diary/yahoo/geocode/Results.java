package com.diary.yahoo.geocode;

import javax.xml.bind.annotation.XmlElement;


public class Results {
	private Result result;

	public Result getResult() {
		return result;
	}

	@XmlElement(name = "Result")
	public void setResult(Result result) {
		this.result = result;
	}
}
