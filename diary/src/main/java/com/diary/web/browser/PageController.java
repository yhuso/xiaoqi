package com.diary.web.browser;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping(value = "/index.action")
	public String agentAnalysisIndex(Map<String, Object> model){
		model.put("content", diaryService.queryTest());
		return "index";
	}
}
