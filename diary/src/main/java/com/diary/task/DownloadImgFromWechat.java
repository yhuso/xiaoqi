package com.diary.task;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.diary.util.WechatUtil;

public class DownloadImgFromWechat {
	private static Logger logger = LoggerFactory.getLogger(DownloadImgFromWechat.class);
	// https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID
	public static void getImgFromWechat(String accessToken,String mediaId) {
		String access_token = "1AB0cyXIyZl_foa0vb4ER9vZd7iDym1KDmITFnApzl3hUSjs0ZUk3B_wO-K6ca7wQqYWKIdhTNRP_sZW18l1S3-pKpXXzz4gPl1vVXN4ygo";
		String media_id = "t0RoPgbcB5maaVFRw-PwyK1ZFdcUumHkACzp090y_tbA-BTHi5fR2m0Qs75M_P8q";
		String url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token="+accessToken+"&media_id="+mediaId;
		InputStream in = WechatUtil.httpsRequestPublicPart(url, "GET"); 
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int n = 0;
		try {
			while (-1 != (n = in.read(buf))) {
				out.write(buf, 0, n);
			}
			out.close();
			in.close();
			FileOutputStream fos = new FileOutputStream("E://diaryimg//"+mediaId+".jpg");
			fos.write(out.toByteArray());
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
