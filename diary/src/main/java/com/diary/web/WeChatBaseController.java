package com.diary.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diary.constantEnum.AppConstant;
import com.diary.constantEnum.Constants;
import com.diary.domain.SignatureVerifyRequest;
import com.diary.domain.WeChatReqBean;
import com.diary.domain.WeChatRespBean;
import com.diary.domain.stateBean.Session;
import com.diary.service.DiaryService;
import com.diary.util.BeanUtils;
import com.diary.util.Md5AndShaUtil;
import com.diary.yahoo.geocode.Query;
import com.diary.yahoo.weather.YahooWeather;
import com.diary.yahoo.weather.yweather.Forecast;

@Controller
public class WeChatBaseController {
	private Logger logger = LoggerFactory.getLogger(WeChatBaseController.class);
	
	@Autowired
	private DiaryService diaryService;
	
	@RequestMapping(value="/", method=RequestMethod.GET,produces={"application/xml", "application/json"})
	@ResponseBody
	public String checkSignature(SignatureVerifyRequest request){
		String signature = request.getSignature();
		String timestamp = request.getTimestamp();
		String nonce = request.getNonce();
		logger.info(AppConstant.TOKEN+"|"+timestamp+"|"+nonce);
		String[] params = new String[]{AppConstant.TOKEN,timestamp,nonce};
		if(params.length==0){
			return null;
		}
		Arrays.sort(params);//升序
		String joinStr = "";
		for(int i=0;i<params.length;i++){
			joinStr += params[i];
		}
		if(signature.equals(Md5AndShaUtil.makesha1(joinStr))){
			return request.getEchostr();
		}
		return null;
	}

	@RequestMapping(value="/",method=RequestMethod.POST,produces={"application/xml"})
	@ResponseBody
	public void doPost(@RequestBody WeChatReqBean reqBean,HttpServletResponse resp) throws IOException {
		logger.info(BeanUtils.printAllProperties(reqBean));
		
		Date d = new Date(reqBean.getCreateTime());
		logger.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d));
		
		resp.setContentType("application/xml");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		try {
			// 3、判定用户是否发的是地理位置的PO，并查询天气
			String content = getContent(reqBean);
			if("".equals(content) || "success".equals(content)){
				out.write(content);
			}else{
				// 4、创建一个回复消息
				JAXBContext jc = JAXBContext.newInstance(WeChatRespBean.class);
				Marshaller m = jc.createMarshaller();		//打包，序列化
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
				WeChatRespBean respBean = createRespBean(reqBean, content);
				FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\项目相关笔记\\respons_msg.txt"), true);
	//			m.marshal(respBean, fos);
				m.marshal(respBean, out);
			}
			out.flush();
		} catch (JAXBException e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		} finally {
			if (out != null) {
				out.close();
				out = null;
			}
		}
	}
	
	/**
	 * @param reqBean
	 * @param content
	 * @return
	 */
	private WeChatRespBean createRespBean(WeChatReqBean reqBean, String content) {
		WeChatRespBean respBean = new WeChatRespBean();
		respBean.setFromUserName(reqBean.getToUserName());
		respBean.setToUserName(reqBean.getFromUserName());
		respBean.setMsgType("text");
		respBean.setCreateTime(new Date().getTime());
		respBean.setContent(content);
		return respBean;
	}
	
	
	/**
	 * @param reqBean
	 * @throws JAXBException
	 * @throws IOException 
	 */
	private String getContent(WeChatReqBean reqBean) throws JAXBException, IOException {
		String userName = reqBean.getFromUserName();
		StringBuffer content = new StringBuffer("老婆，");
		String msgType = reqBean.getMsgType();
		if (Constants.MSGTYPE_TEXT.equals(msgType) || Constants.MSGTYPE_IMAGE.equals(msgType)) {
			String reqContent = reqBean.getContent();
			if("模式".equals(reqContent)){
				String catalog = "1.写日记\n2.查看日记";
				return catalog;
			}
			if("1".equals(reqContent)){
				Session.setCurMode(Integer.parseInt(reqContent), userName);
				return "写模式开启,开始写日记吧";
			}
			if(Session.getCurMode(userName) == 1){//写模式
				if("么么哒".equals(reqContent)){
					Session.setGroupEmpty(userName);
					System.out.println("writeMsg152row.groupId = "+Session.getCurGroupId(userName));
					return "保存成功";
				}else{
					diaryService.writeMsg(reqBean);//写入日记
					return "success";
				}
			}else{
				return "当前模式，mode="+Session.getCurMode(userName)+"，如果不为1，可以输入1进入写模式写日记";
			}
		}else if(Constants.MSGTYPE_LOCATION.equals(msgType)){
			// 此处先调用Yahoo的PlaceFinder服务，获取用户当前所在地的woeid。
			// 再调用Yahoo的Weather服务获取天气情况。
			// 如果用兴趣，可以尝试做一个小黄鸡的服务。<a href="http://developer.simsimi.com/api">小黄鸡</a>
//			String placeUrl = "http://where.yahooapis.com/geocode?location=" + reqBean.getLocation_X() + "+" + reqBean.getLocation_Y() + "&gflags=R";
	        String placeUrl = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20geo.placefinder%20where%20text=%22" + 
	        		reqBean.getLocation_X() + "," + reqBean.getLocation_Y() + "%22%20and%20gflags=%22R%22";
//			String placeUrl = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20geo.placefinder%20where%20text=%2229.35,106.33%22%20and%20gflags=%22R%22";
			
	        
			JAXBContext jc = JAXBContext.newInstance(Query.class);
			Unmarshaller u = jc.createUnmarshaller();
			URL url = new URL(placeUrl);
			Query resultSet = (Query) u.unmarshal(url);	//读入此url的xml文件
			content.append(resultSet.getResults().getResult().getCity() + "：");
			
			String weatherUrl = String.format("http://weather.yahooapis.com/forecastrss?w=%s&u=c", resultSet.getResults().getResult().getWoeid());
//			String weatherUrl = String.format("http://weather.yahooapis.com/forecastrss?w=%s&u=c", "2158434");
			jc = JAXBContext.newInstance(YahooWeather.class);
			u = jc.createUnmarshaller();
			url = new URL(weatherUrl);
			YahooWeather weather = (YahooWeather) u.unmarshal(url);
			List<Forecast> list = weather.getChannel().getItem().getForecasts();
			content.append("今天最低温度" + list.get(0).getLow() + "℃，最高温度" + list.get(0).getHigh() + "℃；");
			content.append("明天最低温度" + list.get(1).getLow() + "℃，最高温度" + list.get(1).getHigh() + "℃。");
			if (list.get(0).getHigh() <= 15 || list.get(1).getHigh() <= 15) {
				content.append("天凉，注意保暖哦。");
			} else if(list.get(0).getHigh() <= 25 || list.get(1).getHigh() <= 25) {
				if (list.get(0).getCode() >= 26 && list.get(0).getCode() <= 32) {
					content.append("晴空万里，出去走走吧。");
				}
			} else {
				content.append("出去看看大街上的黑丝吧。");
			}
		}else if(Constants.MSGTYPE_VOICE.equals(msgType)){
//			//下载音频文件
//			String mediaId = reqBean.getMediaId();
//			AccessTokenBean accessTokenBean = AccessTokenBean.getInstance();
//			String urlPath = AppConstant.MEDIA_DOWNLOAD_URL.replace("ACCESS_TOKEN", accessTokenBean.getAccess_token())
//					.replace("MEDIA_ID", mediaId);
//			String filePath = "C:\\Users\\Administrator\\Desktop\\项目相关笔记\\wx\\myvoice."+reqBean.getFormat();
//			DownloadFileFromServer.downloadFile(urlPath, filePath);
		}else{
			content.append("想查天气，请给我发一个地理位置的PO。");
		}
		return content.toString();
	}
	
	@RequestMapping(value = "/queryDiary.action")
	public String agentAnalysisIndex(Map<String, Object> model){
		model.put("content", diaryService.queryTest());
		return "diary";
	}
	
	
	@RequestMapping(value = "/image/get/{mediaId}")
	public void getImage(@PathVariable String mediaId,HttpServletResponse response) {
	    FileInputStream fis = null;
	    response.setContentType("image/gif");
	    try {
	        OutputStream out = response.getOutputStream();
	        File file = new File("E://diaryimg//"+mediaId+".jpg");
	        fis = new FileInputStream(file);
	        byte[] b = new byte[fis.available()];
	        fis.read(b);
	        out.write(b);
	        out.flush();
	    } catch (Exception e) {
	         e.printStackTrace();
	    } finally {
	        if (fis != null) {
	            try {
	               fis.close();
	            } catch (IOException e) {
	            e.printStackTrace();
	        }   
	          }
	    }
	}
	
	public static void main(String[] args) {
		String s = "http://mmbiz.qpic.cn/mmbiz/ibsPSfMyaqA4Y3vNVUFGyDQlAgUJdyaZr7qfia1nRQibDZFpfc19Dn5rrBJnasic7InW7iaDKtgbGPkHsBHPAjaUOrQ/0";
		String mediaId = "-BZoC-UbUq1HZsXv7RzPpv1EAEkc6IvchVzjBmzZyoyliI7IwQWAq5g0HbpMCbtG";
		System.out.println(mediaId.length());
	}
}
