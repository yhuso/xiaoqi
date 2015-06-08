package com.diary.util.image;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CopyObjectResult;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.diary.aop.BusinessException;
import com.diary.aop.ErrorEnum;


public abstract class OSSObjectUtilBase {
	private static Logger logger = LoggerFactory.getLogger(OSSObjectUtilBase.class);
	
	@Autowired
	protected Global global;
	@Autowired
	protected OSSClient client;
	
	public String bucketName;
	
	/**
	 * 批量上传文件
	 * @param map
	 */
	public final void uploadFile(Map<String, String> map) {
		try {
			int i = 1;
			int n = map.size();
			for (Map.Entry<String, String> entry : map.entrySet()) {
				logger.info("正在上传..bucketName={},..{}/{}..{}", bucketName, i++, n, entry.getKey());
				uploadFileSon(entry.getKey(), entry.getValue());
				logger.info("上传成功..");
			}

		} catch (Exception e) {
			logger.error("上传错误：", e);
			e.printStackTrace();
			throw new BusinessException(ErrorEnum.SOA_ERROR_100002);
		}
	}
	
	/**
	 * 批量以字节流的形式上传
	 * @param map
	 */
	public void uploadFile_stream(Map<String, byte[]> map) {
		try {
			int i = 1;
			int n = map.size();
			for (Map.Entry<String, byte[]> entry : map.entrySet()) {
				
				logger.info("正在上传..bucketName={},..{}/{}..{}", bucketName, i++, n, entry.getKey());
				uploadFile_streamSon(entry.getKey(), entry.getValue());
				logger.info("上传成功..");
			}

		} catch (Exception e) {
			logger.error("上传错误：", e);
			e.printStackTrace();
			throw new BusinessException(ErrorEnum.SOA_ERROR_100002);
		}
	}
	
    /**
     * 上传单个文件
     * @param key
     * @param fileName
     */
	public final void uploadFile(String key, String fileName) {
		try {
			
			logger.info("正在上传..key={},...bucketName={},...{}", key, bucketName, fileName);
			uploadFileSon(key, fileName);
			logger.info("上传成功..");

		} catch (Exception e) {
			logger.error("上传错误：", e);
			e.printStackTrace();
			throw new BusinessException(ErrorEnum.SOA_ERROR_100002);
		}
	}
	
	public void uploadFile_stream(String key, byte[] filebytes) {
		try {
			
			logger.info("正在上传..key={},...bucketName={},...", key, bucketName);
			uploadFile_streamSon(key, filebytes);
			logger.info("上传成功..");

		} catch (Exception e) {
			logger.error("上传错误：", e);
			e.printStackTrace();
			throw new BusinessException(ErrorEnum.SOA_ERROR_100002);
		}
	}
    
    
	public File downloadFile(String key, String fileName) {
		File file = null;

		try {

			logger.info("正在下载..key={},...bucketName={},...{}", key, bucketName, fileName);
			file = downloadFile(client, bucketName, key, fileName);
			logger.info("下载成功.." + fileName);

		} catch (Exception e) {
			logger.error("下载错误：", e);
			e.printStackTrace();
		}
		return file;

	}
    
    /**
     * 根据key删除文件
     */
    public void deleteFile(String key) {
        logger.info("正在删除..bucketName={},key={}", bucketName, key);
        client.deleteObject(bucketName, key);
    	logger.info("删除成功..");
	}
    
    
    /**
     * 根据给定前坠 删除文件
     */
    public void deleteFile4prefix(String prefix) {
    	// 构造ListObjectsRequest请求
    	ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);

    	// 递归列出fun目录下的所有文件
    	listObjectsRequest.setPrefix(prefix);

    	ObjectListing listing = client.listObjects(listObjectsRequest);

    	// 遍历所有Object
    	for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
    		deleteFile(objectSummary.getKey());
    	}
	}
    
    protected abstract void uploadFileSon(String key, String filename) throws OSSException, ClientException, IOException;
    protected abstract void uploadFile_streamSon(String key, byte[] filebytes) throws OSSException, ClientException, IOException;
    

    // 下载文件
    private File downloadFile(OSSClient client, String bucketName, String key, String filename) throws OSSException, ClientException {
    	File file = new File(filename);
        client.getObject(new GetObjectRequest(bucketName, key), file);
        return file;
    }
    
    //获得对象返回流
    public InputStream getObject(String key) throws IOException {

        // 获取Object的输入流
        return client.getObject(bucketName, key).getObjectContent();
    }
    
    //拷贝Object
    public void copyObject(String srcKey, String destKey) {
        // 拷贝Object
        CopyObjectResult result = client.copyObject(bucketName, srcKey, bucketName, destKey);

        // 打印结果
        // System.out.println("ETag: " + result.getETag() + " LastModified: " + result.getLastModified());
    }
    
    //剪切Object
    public void cutObject(String srcKey, String destKey) {
        // 拷贝Object
        logger.info("正在剪切..bucketName={},srcKey={},destKey={}", bucketName, srcKey, destKey);

        CopyObjectResult result = client.copyObject(bucketName, srcKey, bucketName, destKey);
        client.deleteObject(bucketName, srcKey);
       
        logger.info("剪切成功..");
    }
    
    //动态地生成一个经过签名的URL
    public String getUrl(String key, int timeout) {

        // 设置URL过期时间
//    	Date expiration = new Date(new Date().getTime() + 120 * 1000);
    	
        // 生成URL
        return client.generatePresignedUrl(bucketName, key, new Date(new Date().getTime() + timeout)).toString();

	}
    

	/**
	 * 得到暂时的http链接
	 * @param key
	 * @return
	 */
	public String getUrl(String key) {
		return getUrl(key, 60000);
	}
}
