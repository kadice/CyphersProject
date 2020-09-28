package com.cypro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cypro.service.CommonService;

@Controller
public class CommonController {

	@Autowired
	CommonService commonService = new CommonService();

	// ==============================================================================================
	// COMMON
	@RequestMapping("/")
	public String to_slash(Model model) throws SQLException, IOException, ServletException {
		//getUserName();
		return "index";
	}

	@RequestMapping("charaSelBox")
	public String to_charaSelBox(Model model) throws SQLException, IOException, ServletException {
		List<Map<String, String>> charaList = commonService.getAllChara();
		model.addAttribute("charaList", charaList);
		return "charaSelBox";
	}

	@RequestMapping("login")
	public String to_login(Model model, HttpServletRequest request) throws SQLException, IOException, ServletException {
		
		
		String referer = request.getHeader("referer");
		if (referer.isEmpty())
			return "index";
		else
			return "redirect:" + referer;
	}

	// ==============================================================================================
	// 舊版特殊頁面
	@RequestMapping("hidden")
	public String to_hidden(Model model) throws SQLException, IOException, ServletException {
		model.addAttribute("questName", "不知名的能力者");
		// CHARA
		List<Map<String, String>> charaList = commonService.getAllChara();
		model.addAttribute("charaList", charaList);
		// STORY
		// List<String> chapterList = commonService.getChapters();
		// model.addAttribute("chapterList", chapterList);

		return "hidden";
	}

	@RequestMapping("process")
	public String to_process(Model model) throws SQLException, IOException {
		return "process";
	}
}
