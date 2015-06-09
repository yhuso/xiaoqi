package com.diary.util.image;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aliyun.oss.OSSClient;

@Data
@Configuration
@ConfigurationProperties(prefix="S_constants",locations = "classpath:oss.properties")
public class ImageConfig {
	/************************************** 阿里云 存储 ***********************************************/
	// 原图
	private String ACCESSKEYID_ORIGINAL;
	private String ACCESSKEYSECRET_ORIGINAL;
	private String BUCKETNAME_ORIGINAL;

	// 水印
	private String ACCESSKEYID_WATER;
	private String ACCESSKEYSECRET_WATER;
	private String BUCKETNAME_WATER;

	private int ALIYUN_ECS;
	private String ALIYUN_INTERNAL;
	private String ALIYUN_EXTERNAL;

	/**
	 * 配置文件读入以后，才执行此方法生成bean
	 * @return
	 */
	@Bean(name="originalClient")
	public OSSClient originalClient(){
		OSSClient client = null;
		if (ALIYUN_ECS == 1) {
			//client 阿里云内网
			client = new OSSClient(ALIYUN_INTERNAL, ACCESSKEYID_ORIGINAL, ACCESSKEYSECRET_ORIGINAL);
		} else {
			//client 阿里云外网
			client = new OSSClient(ALIYUN_EXTERNAL,ACCESSKEYID_ORIGINAL, ACCESSKEYSECRET_ORIGINAL);
		}
		return client;
	}
	
	/**
	 * 配置文件读入以后，才执行此方法生成bean
	 * @return
	 */
	@Bean(name="waterClient")
	public OSSClient waterClient(){
		OSSClient client = null;
		if (ALIYUN_ECS == 1) {
			//client 阿里云内网
			client = new OSSClient(ALIYUN_INTERNAL, ACCESSKEYID_WATER, ACCESSKEYSECRET_WATER);
		} else {
			//client 阿里云外网
			client = new OSSClient(ALIYUN_EXTERNAL,ACCESSKEYID_WATER, ACCESSKEYSECRET_WATER);
		}
		return client;
	}
}
