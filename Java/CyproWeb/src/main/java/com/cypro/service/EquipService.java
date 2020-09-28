package com.cypro.service;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypro.dao.*;
import com.cypro.model.*;

@Service("EquipService")
public class EquipService {

	@Autowired
	CommonDao commonDao = new CommonDao();
	@Autowired
	EquipDao equipDao = new EquipDao();

	// ==============================================================================================
	// EQUIP
	/**
	 * 取得角色粉裝
	 * 
	 * @param charaId 角色英文名
	 */
	public List<EquipDto> getUniqueEquips(String charaId) throws SQLException, IOException {
		List<EquipDto> equipList = equipDao.getUniqueEquips(charaId);
		return equipList;
	}

	/**
	 * 根據條件取得裝備列表
	 * 
	 * @param charaId      角色英文名
	 * @param qualityList  1:一般 2:少見 3:稀有 4:獨特
	 * @param positionList 手、頭...etc
	 */
	public List<EquipDto> getEquipList(String charaId, String[] qualityList, String[] positionList)
			throws SQLException, IOException {
		// 當輸入值為0時直接排除該條件
		if (qualityList == null || qualityList.length == commonDao.getPublicParam("QualityStrCh").size())
			qualityList = null;
		if (positionList == null || positionList.length == commonDao.getPublicParam("ItemPosition").size())
			positionList = null;

		// 建立搜尋結果
		List<EquipDto> equipList = new ArrayList<EquipDto>();
		List<EquipDto> temp = equipDao.getEquipList(charaId, qualityList, positionList);
		// 若查詢結果不為空，則加入List
		if (temp.size() > 0)
			equipList.addAll(temp);
		return equipList;
	}

	/**
	 * 根據charaId取得裝備編號列表
	 * 
	 * @param charaId 角色英文名
	 */
	public List<String> getEquipIdList(String charaId) throws SQLException, IOException {
		// 建立搜尋結果
		List<String> equipList = new ArrayList<String>();
		List<String> temp = equipDao.getEquipIdList(charaId);
		// 若查詢結果不為空，則加入List
		if (temp.size() > 0)
			equipList.addAll(temp);
		return equipList;
	}

	/**
	 * 根據關鍵字取得裝備列表
	 * 
	 * @param equipKey 裝備韓文名稱關鍵字
	 */
	public List<EquipDto> getEquipListByKey(String equipKey) throws SQLException, IOException {
		List<EquipDto> equipList = new ArrayList<EquipDto>();
		List<EquipDto> temp = equipDao.getEquipList(equipKey);
		// 若查詢結果不為空，則加入List
		if (temp.size() > 0)
			equipList.addAll(temp);
		return equipList;
	}

	/**
	 * 根據equipID取得單一裝備資料
	 */
	public EquipDto getEquipById(String equipID) throws SQLException, IOException {
		EquipDto equipDto = equipDao.getEquipById(equipID);
		return equipDto;
	}

	/**
	 * 更新/新增 裝備資料
	 * 
	 * @param editType update=更新 create=新增
	 */
	public boolean saveEquip(String editType, EquipDto equipDto) throws SQLException, IOException {
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		equipDto.setLastModified(datetime.toString());

		if ("update".equals(editType)) {
			int resultInt = equipDao.updateEquip(equipDto);
			return (resultInt > 0) ? true : false;
		} else if ("insert".equals(editType)) {
			if (equipDao.isEquipIdExist(equipDto.getEquipId())) {
				return false;
			} else {
				int resultInt = equipDao.insertEquip(equipDto);
				return (resultInt > 0) ? true : false;
			}
		}
		return false;
	}

	/**
	 * 覆寫裝備效果
	 */
	public boolean updateEquipEffect(EquipDto equipDto) {
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		equipDto.setLastModified(datetime.toString());
		int resultInt = equipDao.updateEquipEffect(equipDto);
		return (resultInt > 0) ? true : false;
	}

	/**
	 * 覆寫裝備故事情報
	 */
	public boolean updateEquipInfo(EquipDto equipDto) {
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		equipDto.setLastModified(datetime.toString());
		int resultInt = equipDao.updateEquipInfo(equipDto);
		return (resultInt > 0) ? true : false;
	}

	// ==============================================================================================
	// EQUIP INFO
	/**
	 * 根據charaId取得角色裝備故事情報
	 */
	public List<EquipDto> getEquipInformation(String charaId) {
		return equipDao.getEquipInformation(charaId);
	}

}