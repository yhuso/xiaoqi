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
	
	/**
	 * 返回从微信服务器上下载下来的图片流
	 * @param accessToken
	 * @param mediaId
	 * @return
	 */
	public static ByteArrayOutputStream getImgFromWechat(String accessToken,String mediaId) {
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
//			FileOutputStream fos = new FileOutputStream("E://diaryimg//"+mediaId+".jpg");
//			fos.write(out.toByteArray());
//			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	
	public static void main(String[] args) {
		
	}
	
}
