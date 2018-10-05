package com.cypro.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.cypro.model.*;

public class EquipDao extends SqlSessionDaoSupport {

	// ==============================================================================================
	// EQUIP
	/**
	 * 取得角色粉裝
	 * 
	 * @param charaId 角色英文名
	 */
	public List<EquipDto> getUniqueEquips(String charaId) {
		List<EquipDto> equipList = getSqlSession().selectList("getUniqueEquips", charaId);
		return equipList;
	}

	/**
	 * 根據條件取得裝備列表
	 * 
	 * @param charaId      角色英文名
	 * @param qualityList  1:一般 2:少見 3:稀有 4:獨特
	 * @param positionList 手、頭...etc
	 */
	public List<EquipDto> getEquipList(String charaId, String[] qualityList, String[] positionList) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("charaId", charaId);
		paramMap.put("qualityList", qualityList);
		paramMap.put("positionList", positionList);
		List<EquipDto> equipList = getSqlSession().selectList("getEquip", paramMap);
		return equipList;
	}

	/**
	 * 根據charaId取得裝備編號列表
	 * 
	 * @param charaId 角色英文名
	 */
	public List<String> getEquipIdList(String charaId) {
		List<String> equipIdList = getSqlSession().selectList("getEquipId", charaId);
		return equipIdList;
	}

	/**
	 * 根據關鍵字取得裝備列表
	 * 
	 * @param equipKey 裝備韓文名稱關鍵字
	 */
	public List<EquipDto> getEquipList(String equipKey) {
		List<EquipDto> equipList = getSqlSession().selectList("getEquipByKey", equipKey);
		return equipList;
	}

	/**
	 * 根據equipID取得單一裝備資料
	 */
	public EquipDto getEquipById(String equipID) {
		EquipDto equip = getSqlSession().selectOne("getEquipById", equipID);
		return equip;
	}

	/**
	 * update裝備資料
	 */
	public int updateEquip(EquipDto equipDto) {
		return getSqlSession().update("updateEquip", equipDto);
	}

	/**
	 * update裝備資料中的effect
	 */
	public int updateEquipEffect(EquipDto equipDto) {
		return getSqlSession().update("updateEquipEffect", equipDto);
	}

	/**
	 * update裝備資料中的information和information_ch
	 */
	public int updateEquipInfo(EquipDto equipDto) {
		return getSqlSession().update("updateEquipInfo", equipDto);
	}

	/**
	 * insert裝備資料
	 */
	public int insertEquip(EquipDto equipDto) {
		return getSqlSession().insert("insertEquip", equipDto);
	}

	/**
	 * 依charaId取得角色裝備故事情報
	 */
	public List<EquipDto> getEquipInformation(String charaId) {
		return getSqlSession().selectList("getEquipInformation", charaId);
	}

	/**
	 * 查詢該EquipId是否存在
	 */
	public boolean isEquipIdExist(String equipId) {
		String temp = getSqlSession().selectOne("isEquipIdExist", equipId);
		return (null != temp) ? true : false;
	}
}
