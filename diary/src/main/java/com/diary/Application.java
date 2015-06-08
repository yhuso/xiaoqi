package com.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.diary.configuration.TomcatPoolDataSourceProperties;
import com.diary.util.image.OSSObjectUtilBase;
import com.diary.util.image.OSSObjectUtilOriginal;
import com.diary.util.test.FatherBase;
import com.diary.util.test.FatherImpl;
import com.diary.util.test.SimpileComponent;
//@SpringBootApplication // = @Configuration + @EnableAutoConfiguration + @ComponentScan

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(new Object[] { Application.class }, args);
		Object testBean = ctx.getBean(OSSObjectUtilOriginal.class);
		OSSObjectUtilBase oss;
		if(testBean!=null){
			oss = (OSSObjectUtilBase)testBean;
			String fileName = "C:/abcjjj.jpg";
			oss.uploadFile("xiaoqi20150609first", fileName);
			System.out.println("上传完毕");
		}
		
	}
	
}
