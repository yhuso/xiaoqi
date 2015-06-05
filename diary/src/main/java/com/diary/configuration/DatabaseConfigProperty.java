package com.diary.configuration;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "local.datasource", ignoreUnknownFields = false)
@Data
public class DatabaseConfigProperty {

	private String driverClassName; 
	private String url; 
	private String username; 
	private String password;
	private int maxActive = 100;
	private int maxIdle = 8;
	private int minIdle = 8;
	private int initialSize = 10;
	private String validationQuery;
}
