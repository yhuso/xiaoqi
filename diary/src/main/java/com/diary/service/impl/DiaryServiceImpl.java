package com.diary.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.diary.constantEnum.AppConstant;
import com.diary.dao.DiaryMapper;
import com.diary.dao.MsgGroupMapper;
import com.diary.domain.Diary;
import com.diary.domain.MsgGroup;
import com.diary.domain.WeChatReqBean;
import com.diary.domain.stateBean.Session;
import com.diary.service.DiaryService;
import com.diary.task.DownloadImgFromWechat;
import com.diary.util.WechatUtil;
import com.diary.util.image.OSSObjectUtilBase;
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
		
//		String accessToken = "aetvHlrHcBHigB9axIbxDifUSWalyrTPd7n31Bys9WJJHM3sZbXBNqxqZlb2wY3AJ_e2EHZXc2nrEjKe7nNBcnnITaA6HnhsJ0CTGw-eif8";
		String accessToken = WechatUtil.getAccessTokenBean(AppConstant.APPID, AppConstant.APPSECRET).getAccess_token();
		if("image".equals(msgType)){
			String mediaId = req.getMediaId();
			diary.setPicUrl(req.getPicUrl());
			ByteArrayOutputStream imgByteArray = DownloadImgFromWechat.getImgFromWechat(accessToken, req.getMediaId());//下载临时图片保存至本地
			//将图片字节数组上传至OSS
			logger.info("从微信服务器下载图片,mediaId={},byte's length={}",mediaId,imgByteArray.size());
			oSSObjectUtilOriginal.uploadFile_stream(mediaId, imgByteArray.toByteArray());
			logger.info("上传成功");
			diary.setMediaId("http://xqpublicread.oss-cn-shenzhen.aliyuncs.com/"+mediaId);
		}
		diaryMapper.insertSelective(diary);
		return "";
	}

	@Override
	public List<Diary> queryTest() {
		return diaryMapper.selectyByGroupId(msgGroupMapper.getMaxGroupId());
	}

}
