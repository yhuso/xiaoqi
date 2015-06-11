package com.diary.web.browser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diary.domain.response.Post;
import com.diary.service.DiaryService;

@Controller
public class PageController {
	@Autowired
	DiaryService diaryService;
	
	@RequestMapping("/index.action")
    private String login(ModelMap map){
		List<Post> posts = diaryService.queryAllPost();
		map.put("posts", posts);
		String targetJsp = "timelineindex";
        return targetJsp;
    }
}
