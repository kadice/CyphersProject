package com.cypro.service;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypro.dao.CommonDao;

@Service("CommonService")
public class CommonService {

	@Autowired
	CommonDao commonDao = new CommonDao();

	/**
	 * 根據charaId取得角色中文名 (技能編輯頁面)
	 */
	public String getCharaName(String charaId) throws SQLException, IOException {
		return commonDao.getCharaName(charaId);
	}

	/**
	 * 取得角色列表 map.id = 角色英文名 map.name = 角色中文名 map.iconURL = 圖示連結
	 */
	public List<Map<String, String>> getAllChara() throws SQLException, IOException {
		List<Map<String, String>> charaList = commonDao.getAllChara();
		return charaList;
	}


	/**
	 * 由公共參數表 取得品質列表
	 */
	public List<Map<String, String>> getAllQuality() throws SQLException, IOException {
		return commonDao.getPublicParam("QualityStrCh");
	}
	/**
	 * 由公共參數表 取得部位列表
	 */
	public List<Map<String, String>> getAllPosition() throws SQLException, IOException {
		return commonDao.getPublicParam("ItemPosition");
	}
	/**
	 * 由公共參數表 取得SEASON列表
	 */
	public List<Map<String, String>> getAllSeason() throws SQLException, IOException {
		return commonDao.getPublicParam("ItemSeason");
	}
	/**
	 * 由公共參數表 取得階數列表
	 */
	public List<Map<String, String>> getAllSegment() throws SQLException, IOException {
		return commonDao.getPublicParam("ItemSegment");
	}
	/**
	 * 由公共參數表 取得PositionWording
	 */
	public List<Map<String, String>> getPositionWording() throws SQLException, IOException {
		return commonDao.getPublicParam("PositionWording");
	}
	/**
	 * 由公共參數表 取得HotkeyDesc
	 */
	public List<Map<String, String>> getHotkeyDesc() throws SQLException, IOException {
		return commonDao.getPublicParam("HotkeyDesc");
	}
	
	// ==============================================================================================
	// LOG
	/**
	 * 取出近期log
	 */
	public List<Map<String, Object>> getLatestLogs(int i) {
		List<Map<String, Object>> logs = commonDao.getLogs(i);
		return logs;
	}

	/**
	 * 寫入log
	 */
	public void log(String ip, String logMsg) {
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		commonDao.log(datetime, ip, logMsg);
	}

	
}