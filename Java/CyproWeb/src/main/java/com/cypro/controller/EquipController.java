package com.cypro.controller;

import java.awt.Checkbox;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cypro.model.*;
import com.cypro.service.*;

@Controller
public class EquipController {

	@Autowired
	CommonService commonService = new CommonService();
	@Autowired
	EquipService equipService = new EquipService();

	EquipListForm equipListForm = new EquipListForm();
	EquipParamSourceForm equipParamSourceForm = new EquipParamSourceForm();
	
	/**
	 * 進入裝備呈現畫面
	 */
	@RequestMapping(value = "equips", method = RequestMethod.GET)
	public String to_equips_init(Model model) throws SQLException, IOException {
		fillEquipParamSourceForm();
		equipParamSourceForm.setSearchType("byChara");
		model.addAttribute("equipParamSourceForm", equipParamSourceForm);
		return "equips";
	}
	
	/**
	 * 按下查詢裝備
	 */
	@RequestMapping(value = "queryEquip", method = RequestMethod.POST)
	public String to_queryEquip_POST(HttpServletRequest request, Model model) throws SQLException, IOException {
		
		//執行查詢裝備
		List<EquipDto> equipDtoList = queryEquipDtoList(request);

		//調整格式
		for(EquipDto equipDto : equipDtoList){
			String qua = equipDto.getQualityStr();
			switch(qua){
				case "獨特": qua = "<b><font style='color: rgb(235, 70, 160)'>" + qua + "</font></b>"; break;
				case "稀有": qua = "<b><font style='color: rgb(160, 50, 255)'>" + qua + "</font></b>"; break;
				case "少見": qua = "<b><font style='color: rgb(50, 100, 255)'>" + qua + "</font></b>"; break;
				case "一般": qua = "<b>" + qua + "</b>";
			}
			equipDto.setQualityStr(qua);
		}

		equipListForm.setEquipDtoList(equipDtoList);
		equipListForm.setMaxIndex(equipDtoList.size());
		model.addAttribute("equipListForm", equipListForm);
		return to_equips_init(model);
	}
	/**
	 * 執行查詢裝備
	 */
	private List<EquipDto> queryEquipDtoList(HttpServletRequest request) throws SQLException, IOException{
		List<EquipDto> equipDtoList = new ArrayList<EquipDto>();

		String searchType = request.getParameter("searchType");//以條件搜尋(byChara)/以關鍵字搜尋(byKey)
		String charaId = request.getParameter("charaId");//角色英文名
		String equipKey = request.getParameter("equipKey");//裝備名關鍵字
		String[] checkedQuality = request.getParameterValues("quality");//要查詢的裝備品質
		String[] checkedPosition = request.getParameterValues("position");//要查詢的裝備部位
		if("byKey".equals(searchType)){
			equipDtoList.addAll(equipService.getEquipListByKey(equipKey));
		} else if("byChara".equals(searchType)) {
			equipDtoList.addAll(equipService.getEquipList(charaId, checkedQuality, checkedPosition));
		}
		return equipDtoList;
	}
	
	/**
	 * 取得裝備查詢/編輯區塊所需的LIST與MAP資料
	 */
	private void fillEquipParamSourceForm() throws SQLException, IOException{
		// 取得角色列表
		List<Map<String, String>> charaList = commonService.getAllChara();
		Map<String, String> publicCharaMap = new HashMap<String, String>();
		publicCharaMap.put("charaId", "Public");
		publicCharaMap.put("name", "共用");
		publicCharaMap.put("iconURL", "/resources/pic/public.png");
		charaList.add(0, publicCharaMap);
		Map<String, String> charaItemMap = new LinkedHashMap<String, String>();
		charaItemMap.putAll(changeMapListToItemMap(charaList, "charaId", "name")); // 值="Loras" 標籤="勞拉斯"
		equipParamSourceForm.setCharaList(charaList);// 圖片按鈕用
		equipParamSourceForm.setCharaItemMap(charaItemMap);// 下拉選單用

		// 取得品質列表
		List<Map<String, String>> qualityList = commonService.getAllQuality();
		Map<String, String> qualityItemMap = changeMapListToItemMap(qualityList, "key", "value"); // 值="4" 標籤="獨特"
		equipParamSourceForm.setQualityItemMap(qualityItemMap);// checkBox用 // 下拉選單用

		// 取得部位列表
		List<Map<String, String>> positionList = commonService.getAllPosition();
		Map<String, String> positionItemMap = changeMapListToItemMap(positionList, "value", "value"); // 值="手" 標籤="手"
		equipParamSourceForm.setPositionItemMap(positionItemMap);// checkBox用 // 下拉選單用

		// 取得SEASON列表
		List<Map<String, String>> seasonList = commonService.getAllSeason();
		Map<String, String> seasonItemMap = changeMapListToItemMap(seasonList, "value", "value"); // 值="" 標籤=""
		equipParamSourceForm.setSeasonItemMap(seasonItemMap);// 下拉選單用

		// 取得SEGMENT列表
		List<Map<String, String>> segmentList = commonService.getAllSegment();
		Map<String, String> segmentItemMap = changeMapListToItemMap(segmentList, "value", "value"); // 值="三階" 標籤="三階"
		equipParamSourceForm.setSegmentItemMap(segmentItemMap);// 下拉選單用
	}
	

	
	
	

	/**
	 * 將MapList資料轉換為form:form可用的itemMap
	 * @param source
	 * @param itemValueKey
	 * @param itemLableKey
	 */
	private Map<String,String> changeMapListToItemMap(List<Map<String, String>> source, String itemValueKey, String itemLableKey){
		Map<String,String> result = new LinkedHashMap<String,String>();
		for(Map<String, String> m : source){
			String value = m.get(itemValueKey);
			String lable = m.get(itemLableKey);
			result.put(value,lable);
		}
		return result;
		
	}
}
