package com.cypro.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.cypro.model.*;

public class CharacterDao extends SqlSessionDaoSupport {

	// ==============================================================================================
	// CHARADATA

	/**
	 * 根據charaId取得能力者基本資料
	 */
	public CharaDataDto getCharaData(String charaId) {
		CharaDataDto charaDataDto = getSqlSession().selectOne("getCharaData", charaId);
		return charaDataDto;
	}

	/**
	 * update能力者基本資料
	 */
	public int updateCharaData(CharaDataDto charaDataDto) {
		return getSqlSession().update("updateCharaData", charaDataDto);
	}

	/**
	 * insert能力者基本資料
	 */
	public int insertCharaData(CharaDataDto charaDataDto) {
		return getSqlSession().insert("insertCharaData", charaDataDto);
	}

	// ==============================================================================================
	// CHARAREPORT

	/**
	 * 根據id,language取得能力者調查報告
	 * 
	 * @param charaId  英文名
	 * @param language CH:中文 KR:韓文
	 */
	public CharaReportDto getCharaReport(String charaId, String language) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("charaId", charaId);
		paramMap.put("language", language);
		CharaReportDto charaReportDto = getSqlSession().selectOne("getCharaReport", paramMap);
		return charaReportDto;
	}

	/**
	 * update能力者調查報告
	 */
	public int updateCharaReport(CharaReportDto charaReportDto) {
		return getSqlSession().update("updateCharaReport", charaReportDto);
	}

	/**
	 * insert能力者調查報告
	 */
	public int insertCharaReport(CharaReportDto charaReportDto) {
		return getSqlSession().insert("insertCharaReport", charaReportDto);
	}

	// ==============================================================================================
	// CHARAOTHERS
	/**
	 * 根據charaId取得能力者補充資料
	 * 
	 * @param charaId
	 * @return
	 */
	public CharaOthersDto getCharaOthers(String charaId) {
		return getSqlSession().selectOne("getCharaOthers", charaId);
	}

	/**
	 * update能力者補充資料
	 */
	public int updateCharaOthers(CharaOthersDto charaOthersDto) {
		return getSqlSession().update("updateCharaOthers", charaOthersDto);
	}

	/**
	 * insert能力者補充資料
	 */
	public int insertCharaOthers(CharaOthersDto charaOthersDto) {
		return getSqlSession().insert("insertCharaOthers", charaOthersDto);
	}

	/**
	 * 查詢該CharaId是否存在
	 */
	public boolean isCharaIdExist(String charaId) {
		String temp = getSqlSession().selectOne("isCharaIdExist", charaId);
		return (null != temp) ? true : false;
	}

	/**
	 * 查詢該CharaReport是否存在
	 */
	public boolean isCharaReportExist(String charaId, String language) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("charaId", charaId);
		paramMap.put("language", language);
		String temp = getSqlSession().selectOne("isCharaReportExist", paramMap);
		return (null != temp) ? true : false;
	}
}
