package com.cypro.dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CommonDao extends SqlSessionDaoSupport {

	// ==============================================================================================
	// COMMON
	/**
	 * 取得 公共參數
	 */
	public List<Map<String, String>> getPublicParam(String paramClass) {
		List<Map<String, String>> publicParamMap = getSqlSession().selectList("getPublicParam", paramClass);
		return publicParamMap;
	}

	/**
	 * 根據charaId取得角色中文名 (技能編輯用)
	 */
	public String getCharaName(String charaId) {
		String charaName = getSqlSession().selectOne("getCharaName", charaId);
		if ("public".equals(charaId)) {
			charaName = "共用";
		}
		return charaName;
	}

	/**
	 * 取得角色列表
	 */
	public List<Map<String, String>> getAllChara() {
		List<Map<String, String>> charaList = getSqlSession().selectList("getAllChara");

		return charaList;
	}

	// ==============================================================================================
	// LOG
	/**
	 * 取出近期log
	 */
	public List<Map<String, Object>> getLogs(int i) {
		List<Map<String, Object>> logs = getSqlSession().selectList("getLogs", i);
		return logs;
	}

	/**
	 * 寫入log
	 */
	public void log(Timestamp datetime, String ip, String logMsg) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("date", datetime);
		paramMap.put("ip", ip);
		paramMap.put("logMsg", logMsg);
		getSqlSession().insert("insertLog", paramMap);
	}

}
