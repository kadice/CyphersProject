package com.cypro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cypro.model.*;
import com.cypro.service.*;

@Controller
public class CharacterController {

	@Autowired
	CommonService commonService = new CommonService();
	@Autowired
	CharacterService characterService = new CharacterService();
	@Autowired
	SkillService skillService = new SkillService();
	@Autowired
	EquipService equipService = new EquipService();
	
	/**
	 * 顯示能力者檔案的FRAME
	 */
	@RequestMapping("characters")
	public String to_characters(Model model) throws SQLException, IOException {
		return "characters";
	}
	
	/**
	 * (FRAME=CONTENT) - 能力者檔案頁面
	 */
	@RequestMapping("charaPage/{charaId}")
	public String to_charaPage(@PathVariable("charaId") String charaId, Model model) throws SQLException, IOException {
		// 圖片、基本資料
		CharaDataDto charaDataDto = characterService.getCharaData(charaId);
		// 技能列表
		List<SkillDto> tempSkillList = skillService.getWorkingSkillList(charaId);// 取得working中的技能資料
		List<SkillDto> skillList = new ArrayList<SkillDto>();		// 基本技能表
		List<SkillDto> extSkillList = new ArrayList<SkillDto>();	// 擴充技能表
		for(SkillDto skillDto : tempSkillList){
			if(Integer.parseInt(skillDto.getSkillSeq()) <= 9){		//00~09為基本技能
					skillList.add(skillDto);
			} else{
					extSkillList.add(skillDto);
			}
		}
		// 粉裝列表
		List<EquipDto> allEquipList = equipService.getUniqueEquips(charaId);
		List<EquipDto> equipList_E = new ArrayList<EquipDto>();
		List<EquipDto> equipList_S = new ArrayList<EquipDto>();
		for(EquipDto equipDto : allEquipList){
			if(equipDto.getSeason().equals("1 : Eclipse")){
				equipList_E.add(equipDto);
			} else if (equipDto.getSeason().equals("2 : SuperMoon")){
				equipList_S.add(equipDto);
			}
		}
		List<Map<String, String>> positionWording = commonService.getPositionWording();
		// 調查報告
		CharaReportDto charaReportDto_CH = characterService.getCharaReport(charaId, "CH");
		CharaReportDto charaReportDto_KR = characterService.getCharaReport(charaId, "KR");
		// 裝備故事情報
		List<EquipDto> equipInfoList = equipService.getEquipInformation(charaId);
		List<EquipDto> outputEquipInfoList = new ArrayList<EquipDto>();
		String lastInfo = "";
		for(EquipDto equipDto : equipInfoList){
			String thisInfo = equipDto.getInformation();
			if(!thisInfo.equals(lastInfo)){
				outputEquipInfoList.add(equipDto);
			}
			lastInfo = thisInfo;
		}
		//補充資料
		CharaOthersDto charaOthersDto = characterService.getCharaOthers(charaId);

		model.addAttribute("charaDataDto", charaDataDto);
		model.addAttribute("skillList", skillList);
		model.addAttribute("extSkillList", extSkillList);
		model.addAttribute("equipList_E", equipList_E);
		model.addAttribute("equipList_S", equipList_S);
		model.addAttribute("positionWording", positionWording);
		model.addAttribute("charaReportDto_CH",charaReportDto_CH);
		model.addAttribute("charaReportDto_KR",charaReportDto_KR);
		model.addAttribute("equipInfoList",outputEquipInfoList);
		model.addAttribute("charaOthersDto",charaOthersDto);
		return "charaPage";
	}
}
