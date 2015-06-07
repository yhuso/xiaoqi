package com.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.diary.configuration.TomcatPoolDataSourceProperties;
import com.diary.util.image.OSSObjectUtilOriginal;
//@SpringBootApplication // = @Configuration + @EnableAutoConfiguration + @ComponentScan

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(new Object[] { Application.class }, args);
		Object testBean = ctx.getBean(OSSObjectUtilOriginal.class);
		OSSObjectUtilOriginal oss;
		if(testBean!=null){
			oss = (OSSObjectUtilOriginal)testBean;
		}
		
	}
	
}
