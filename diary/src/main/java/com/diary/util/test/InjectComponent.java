package com.diary.util.test;

import org.springframework.stereotype.Component;

@Component
public class InjectComponent {
	public void hello(){
		System.out.println("hello,我是注入组件执行结果");
	}
}
