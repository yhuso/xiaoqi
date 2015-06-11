package com.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.diary.util.image.OSSObjectUtilBase;
import com.diary.util.image.OSSObjectUtilOriginal;
//@SpringBootApplication // = @Configuration + @EnableAutoConfiguration + @ComponentScan

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(new Object[] { Application.class }, args);
//		Object testBean = ctx.getBean(OSSObjectUtilOriginal.class);
//		if(testBean!=null){
//			System.out.println("testBean'name="+testBean.getClass().getName());
//		}
//		OSSObjectUtilBase oss;
//		if(testBean!=null){
//			oss = (OSSObjectUtilBase)testBean;
//			String fileName = "C:/thumb.jpg";
//			oss.uploadFile("thumb20150609", fileName);
//			System.out.println("上传完毕");
//		}
		
	}
	
}
