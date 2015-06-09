package com.diary.configuration;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "tomcat.datasource", ignoreUnknownFields = false)
public class TomcatPoolDataSourceProperties {

	private String driverClassName; 
	private String url; 
	private String username; 
	private String password;
	private int maxActive = 100;
	private int maxIdle = 8;
	private int minIdle = 8;
	private int initialSize = 1;//10->1
	private String validationQuery;

	

	private boolean testOnBorrow = false;

	private boolean testOnReturn = false;

}