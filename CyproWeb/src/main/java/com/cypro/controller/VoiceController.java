package com.cypro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cypro.service.CommonService;

@Controller
public class VoiceController {

	@Autowired
	CommonService commonService = new CommonService();
	
}
