package com.diary.service;

import java.util.List;

import com.diary.domain.Diary;
import com.diary.domain.WeChatReqBean;
import com.diary.domain.response.Post;

public interface DiaryService {
	String writeMsg(WeChatReqBean req);
	
	List<Diary> queryTest();
	
	List<Post> queryAllPost();
}
