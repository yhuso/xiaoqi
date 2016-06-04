package com.diary.util.image;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;

/**
 * @author Administrator 原图 阿里云OSS工具类
 */
@Component
public class OSSObjectUtilOriginal extends OSSObjectUtilBase {
	
	protected OSSClient originalClient;
	
	@Autowired//@Qualifier
	public OSSObjectUtilOriginal(ImageConfig global,OSSClient originalClient){
		bucketName = global.getBUCKETNAME_ORIGINAL();
		this.client = originalClient;
	}

	@Override
	protected void uploadFileSon(String key, String filename) throws OSSException, ClientException, IOException {
        File file = new File(filename);

        ObjectMetadata objectMeta = new ObjectMetadata();
		
        // 可以在metadata中标记文件类型
        objectMeta.setContentType("image/jpeg");
		objectMeta.setContentLength(file.length());


        InputStream input = new FileInputStream(file);
        client.putObject(bucketName, key, input, objectMeta);
        input.close();
	}
	
	@Override
	public void uploadFile_streamSon(String key, byte[] filebytes) throws OSSException, ClientException, IOException {

        ObjectMetadata objectMeta = new ObjectMetadata();
		
        // 可以在metadata中标记文件类型
        objectMeta.setContentType("image/jpeg");
		objectMeta.setContentLength(filebytes.length);


        InputStream input = new ByteArrayInputStream(filebytes);
        client.putObject(bucketName, key, input, objectMeta);
        input.close();
	}
}