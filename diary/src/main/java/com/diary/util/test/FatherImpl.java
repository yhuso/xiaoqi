package com.diary.util.test;

import org.springframework.stereotype.Component;

@Component
public class FatherImpl extends FatherBase {

	@Override
	public void helloToFather() {
		injectComponent.hello();
	}

}
