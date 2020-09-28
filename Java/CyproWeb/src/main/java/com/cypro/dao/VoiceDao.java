package com.cypro.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.cypro.model.*;

public class VoiceDao extends SqlSessionDaoSupport {

	// ==============================================================================================
	// VOICE
	/**
	 * 根據CharaId取得語音列表
	 */
	public List<VoiceDto> getVoiceList(String charaId) {
		List<VoiceDto> voiceList = getSqlSession().selectList("getVoiceByCharaId", charaId);
		return voiceList;
	}

	/**
	 * 根據voiceId取得語音資料
	 */
	public VoiceDto getVoiceByVoiceId(String voiceId) {
		return getSqlSession().selectOne("getVoiceByVoiceId", voiceId);
	}

	/**
	 * update語音資料
	 */
	public int updateVoice(VoiceDto voiceDto) {
		return getSqlSession().update("updateVoice", voiceDto);
	}

	/**
	 * insert語音資料
	 */
	public int insertVoice(VoiceDto voiceDto) {
		return getSqlSession().insert("insertVoice", voiceDto);
	}

	/**
	 * 取得聲優
	 */
	public String getVoiceActor(String charaId) {
		String voiceActor = getSqlSession().selectOne("getVoiceActor", charaId);
		return voiceActor;
	}

	/**
	 * update聲優
	 */
	public int updateVoiceActor(String charaId, String voiceActor) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("charaId", charaId);
		paramMap.put("voiceActor", voiceActor);
		return getSqlSession().update("updateVoiceActor", paramMap);
	}

	/**
	 * 根據聲優取得角色中文名列表
	 */
	public List<String> getCharaListByVoiceActor(String voiceActor) {
		List<String> charaNameList = getSqlSession().selectList("getCharaListByVoiceActor", voiceActor);
		return charaNameList;
	}

	/**
	 * 取得聲優資料
	 */
	public String getVa_info(String voiceActor) {
		String va_info = getSqlSession().selectOne("getVa_info", voiceActor);
		return va_info;
	}

	/**
	 * update聲優資料
	 */
	public int updateVa_info(String voiceActor, String va_info) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("voiceActor", voiceActor);
		paramMap.put("va_info", va_info);
		return getSqlSession().update("updateVa_info", paramMap);
	}

	/**
	 * insert聲優資料
	 */
	public int insertVa_info(String voiceActor, String va_info) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("voiceActor", voiceActor);
		paramMap.put("va_info", va_info);
		return getSqlSession().insert("insertVa_info", paramMap);
	}
}
