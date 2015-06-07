package com.diary.util.image;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties
public class Global {
	/************************************** 阿里云 存储 ***********************************************/
	// 原图
	private final String ACCESSKEYID_ORIGINAL;
	private final String ACCESSKEYSECRET_ORIGINAL;
	private final String BUCKETNAME_ORIGINAL;

	// 水印
	private final String ACCESSKEYID_WATER;
	private final String ACCESSKEYSECRET_WATER;
	private final String BUCKETNAME_WATER;

	private final int ALIYUN_ECS;
	private final String ALIYUN_INTERNAL;

}
