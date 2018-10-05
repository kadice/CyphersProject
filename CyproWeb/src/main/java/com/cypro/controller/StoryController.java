package com.cypro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cypro.model.StoryDto;
import com.cypro.service.CommonService;
import com.cypro.service.StoryService;

@Controller
public class StoryController {

	@Autowired
	StoryService storyService = new StoryService();

	@RequestMapping("story")
	public String to_story(Model model) throws SQLException, IOException {
		return "story";
	}

	@RequestMapping("story/{chapter}")
	public String to_storyChapter(@PathVariable("chapter") String chapter, Model model)
			throws SQLException, IOException {
		List<StoryDto> storyDtoList = storyService.getStoryListByChapter(chapter);
		model.addAttribute("storyDtoList", storyDtoList);
		return "story/" + chapter.toUpperCase();
	}
}
