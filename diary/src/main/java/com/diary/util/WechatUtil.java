package com.diary.util;

import java.awt.Button;
import java.awt.Menu;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.diary.constantEnum.AppConstant;
import com.diary.domain.AccessTokenBean;

public class WechatUtil {
	private static final Log logger = LogFactory.getLog(WechatUtil.class);

	/**
	 * @param appid
	 * @param appsecret
	 * @return 返回access_token,若获取失败则返回null
	 */
	public static AccessTokenBean getAccessTokenBean(String appid,
			String appsecret) {
		AccessTokenBean AccessTokenBean = null;

		String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+ appid + "&secret=" + appsecret;
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		logger.info(jsonObject);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				AccessTokenBean = AccessTokenBean.getInstance();
				AccessTokenBean.setAccess_token(jsonObject
						.getString("access_token"));
				AccessTokenBean.setExpires_in(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				AccessTokenBean = null;
				// 获取token失败
				logger.error("获取token失败:" + jsonObject);
			}
		}
		return AccessTokenBean;
	}

	public static JSONObject httpRequest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			logger.error("Weixin server connection timed out.");
		} catch (Exception e) {
			logger.error("https request error:{}", e);
		}
		return jsonObject;
	}

	public static int createMenu(Menu menu, String access_token) {
		int result = 0;
		// 拼装创建菜单的url
		String url = AppConstant.MENU_CREATE_URL.replace("ACCESS_TOKEN",
				access_token);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		System.out.println(jsonMenu);
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
		if (jsonObject != null) {
			result = jsonObject.getInt("errcode");
			if (result != 0) {
				logger.error("创建菜单失败:" + jsonObject);
			}
		} else {
			logger.error("微信服务器返回为null");
		}
		System.out.println("菜单:" + jsonObject);
		return result;
	}

//	public static void main(String[] args) {
//		String test_access_token = getAccessTokenBean(AppConstant.APPID,
//				AppConstant.APPSECRET).getAccess_token();
//		// System.out.println("access_token="+test_access_token);
//		// String test_access_token =
//		createMenu(getMenu(), test_access_token);
//	}

//	public static Menu getMenu() {
//		ViewButton vb1 = new ViewButton();
//		vb1.setName("公司主页");
//		vb1.setType("view");
//		vb1.setUrl("http://www.zevun.cn");
//
//		ClickButton cb2 = new ClickButton();
//		cb2.setName("家电控制");
//		cb2.setType("click");
//		cb2.setKey("11");
//
//		ClickButton cb3 = new ClickButton();
//		cb3.setName("个人资料");
//		cb3.setType("click");
//		cb3.setKey("12");
//
//		ViewButton vb4 = new ViewButton();
//		vb4.setName("搜索网站");
//		vb4.setType("view");
//		vb4.setUrl("http://www.baidu.com");
//
//		ComplexButton complexButton = new ComplexButton();
//		complexButton.setName("个人中心");
//		complexButton.setSub_button(new Button[] { cb3, vb4 });
//
//		Menu menu = new Menu();
//		menu.setButton(new Button[] { vb1, cb2, complexButton });
//
//		return menu;
//	}


	public static InputStream httpsRequestPublicPart(String requestUrl,String requestMethod) {
		try{
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
	
			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
	
			httpUrlConn.setDoOutput(false);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);
	
			if ("GET".equalsIgnoreCase(requestMethod)) {
				httpUrlConn.connect();
			}
			// 将返回的输入流转换成字符串
			return httpUrlConn.getInputStream();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
