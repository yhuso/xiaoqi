package com.diary.util.test;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class FatherBase {
	@Autowired
	protected InjectComponent injectComponent;
	
	public abstract void helloToFather();
}
