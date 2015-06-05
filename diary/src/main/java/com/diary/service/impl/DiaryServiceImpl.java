package com.diary.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


@Service
public class DiaryServiceImpl implements DiaryService {
	@Autowired
	private DiaryMapper diaryMapper;
	
	@Autowired
	private MsgGroupMapper msgGroupMapper;
	
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
			diary.setMediaId(req.getMediaId());
			diary.setPicUrl(req.getPicUrl());
			DownloadImgFromWechat.getImgFromWechat(accessToken, req.getMediaId());//下载临时图片保存至本地
		}
		diaryMapper.insertSelective(diary);
		return "";
	}

	@Override
	public List<Diary> queryTest() {
		return diaryMapper.selectyByGroupId(msgGroupMapper.getMaxGroupId());
	}

}
