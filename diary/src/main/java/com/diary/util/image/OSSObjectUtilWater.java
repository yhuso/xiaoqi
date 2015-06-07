package com.diary.util.image;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;

/**
 * @author Administrator
 * 水印    阿里云OSS工具类
 */
//@Component
public class OSSObjectUtilWater extends OSSObjectUtilBase {
	protected String accessKeyID = global.getACCESSKEYID_WATER();
	protected String accessKeySecret = global.getACCESSKEYSECRET_WATER();
	protected String bucketName = global.getBUCKETNAME_WATER();

	private final static long cacheTime = 360 * 24 * 60 * 60 * 1000L;
	
	@Override
	protected void uploadFile(OSSClient client, String bucketName, String key, String filename) throws OSSException, ClientException, IOException {
        File file = new File(filename);

        ObjectMetadata objectMeta = new ObjectMetadata();
        long now = new Date().getTime();
		objectMeta.setContentLength(file.length());
		objectMeta.setCacheControl("max-age=" + (cacheTime / 1000));
		objectMeta.setLastModified(new Date(now));
		objectMeta.setExpirationTime(new Date(now + cacheTime));
		
        // 可以在metadata中标记文件类型
        objectMeta.setContentType("image/jpeg");

        InputStream input = new FileInputStream(file);
        client.putObject(bucketName, key, input, objectMeta);
        input.close();
	}
	
	@Override
	protected void uploadFile_stream(OSSClient client, String bucketName, String key, byte[] filebytes) throws OSSException, ClientException, IOException {

        ObjectMetadata objectMeta = new ObjectMetadata();
        long now = new Date().getTime();
		objectMeta.setContentLength(filebytes.length);
		objectMeta.setCacheControl("max-age=" + (cacheTime / 1000));
		objectMeta.setLastModified(new Date(now));
		objectMeta.setExpirationTime(new Date(now + cacheTime));
		
        // 可以在metadata中标记文件类型
        objectMeta.setContentType("image/jpeg");

        InputStream input = new ByteArrayInputStream(filebytes);
        client.putObject(bucketName, key, input, objectMeta);
        input.close();
	}
}
