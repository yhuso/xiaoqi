package com.diary.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.dao.DiaryMapper;
import com.diary.dao.MsgGroupMapper;
import com.diary.domain.Diary;
import com.diary.domain.MsgGroup;
import com.diary.domain.WeChatReqBean;
import com.diary.domain.response.Post;
import com.diary.domain.stateBean.Session;
import com.diary.service.DiaryService;
import com.diary.task.DownloadImgFromWechat;
import com.diary.util.DateUtil;
import com.diary.util.image.OSSObjectUtilOriginal;


@Service
public class DiaryServiceImpl implements DiaryService {
	private Logger logger = LoggerFactory.getLogger(DiaryServiceImpl.class);
	
	@Autowired
	private DiaryMapper diaryMapper;
	
	@Autowired
	private MsgGroupMapper msgGroupMapper;
	
	@Autowired
	private OSSObjectUtilOriginal oSSObjectUtilOriginal;
	
	@Override
	public String writeMsg(WeChatReqBean req) {
		String userName = req.getFromUserName();
		Date createTime = new Date(req.getCreateTime()*1000L);
		Integer groupId = Session.getCurGroupId(userName);
		System.out.println("writeMsg31row.groupId = "+groupId);
		if(groupId==null){
			MsgGroup msgGroup = new MsgGroup();
			msgGroup.setCreateTime(createTime);
			msgGroupMapper.insertSelective(msgGroup);
			Session.setCurGoupId(msgGroup.getId(), userName);
		}
		System.out.println("writeMsg38row.groupId = "+Session.getCurGroupId(userName));
		Diary diary = new Diary();
		diary.setContent(req.getContent());
		diary.setCreateTime(createTime);//秒换算为毫秒
		diary.setFromUserName(req.getFromUserName());
		diary.setMsgId(req.getMsgId());
		diary.setToUserName(req.getToUserName());
		diary.setMsgGroupId(Session.getCurGroupId(userName));
		String msgType = req.getMsgType();
		diary.setMsgType(msgType);
		
		String accessToken = "4jJB-Dl7RS4kjnXAaVKnlOu8PVERZkglxeU7AlrlGynURCasC52isEwrbG-WrdvTNC4TgUapK8TC_FLMHdYCCbZCMD5tP4GdMCUSR5oYTTY";
//		String accessToken = WechatUtil.getAccessTokenBean(AppConstant.APPID, AppConstant.APPSECRET).getAccess_token();
		if("image".equals(msgType)){
			String mediaId = req.getMediaId();
			diary.setMediaId(mediaId);
			ByteArrayOutputStream imgByteArray = DownloadImgFromWechat.getImgFromWechat(accessToken, req.getMediaId());//下载临时图片保存至本地
			//将图片字节数组上传至OSS
			logger.info("从微信服务器下载图片,mediaId={},byte's length={}",mediaId,imgByteArray.size());
			oSSObjectUtilOriginal.uploadFile_stream(mediaId, imgByteArray.toByteArray());
			logger.info("上传成功");
			diary.setPicUrl("http://xqpublicread.oss-cn-shenzhen.aliyuncs.com/"+mediaId);
		}
		diaryMapper.insertSelective(diary);
		return "";
	}

	@Override
	public List<Diary> queryTest() {
		return diaryMapper.selectyByGroupId(msgGroupMapper.getMaxGroupId());
	}

	@Override
	public List<Post> queryAllPost() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("start", 0);
		map.put("end", 10);
		List<MsgGroup> groups = msgGroupMapper.getAllGroup(map);//最新的十组(十条)
		List<Post> posts = new ArrayList<Post>();
		Post post;//一条完整的微博，文本+图片
		List<Diary> diarys;
		for(MsgGroup group:groups){
			post = new Post();
			diarys = diaryMapper.selectyByGroupId(group.getId());
			if(diarys==null || diarys.size()==0){
				logger.info("groupId={},diarys={}",group.getId(),diarys.toString());
				continue;
			}
			Date date = group.getCreateTime();
			
			post.setDate(DateUtil.convertDateToString(date,DateUtil.sdf_date_format));
			post.setTime(DateUtil.convertDateToString(date,DateUtil.sdf_hourmin_format));
			for(Diary diary:diarys){
				if("text".equals(diary.getMsgType())){
					post.getTexts().add(diary.getContent());
				}else if("image".equals(diary.getMsgType())){
					post.getImages().add(diary.getPicUrl());
				}
			}
			
			posts.add(post);
		}
		return posts;
	}

}
