package com.cypro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cypro.model.*;
import com.cypro.service.*;

@Controller
public class SkillController {

	@Autowired
	CommonService commonService = new CommonService();
	@Autowired
	SkillService skillService = new SkillService();
	
	/**
	 * 顯示技能呈現的FRAME (內嵌影片版備份)
	 */
	@RequestMapping("skills")
	public String to_skills(Model model) throws SQLException, IOException {
		return "skills";
	}
	
	/**
	 * (FRAME=CONTENT) - 技能呈現頁面 (內嵌影片版備份)
	 */
	@RequestMapping("skillPage/{charaId}")
	public String to_skillPage(@PathVariable("charaId") String charaId, Model model) throws SQLException, IOException {
		// 取得working中的技能資料
		List<SkillDto> skillList = skillService.getWorkingSkillList(charaId);
		for(SkillDto skillDto : skillList){
			if("-1".equals(skillDto.getDistance())){
				skillDto.setDistance("自身");
			}
		}
		
		// 取得中文角色名
		String charaName = commonService.getCharaName(charaId);
		
		// 取得擴充技能表的狀態描述
		String extSkillDesc = skillService.getExtSkillDesc(charaId);
		
		model.addAttribute("skillList", skillList);
		model.addAttribute("charaName", charaName);
		model.addAttribute("extSkillDesc", extSkillDesc);
		return "skillPage";
	}
}
