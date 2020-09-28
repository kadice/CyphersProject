package com.cypro.service;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypro.dao.VoiceDao;
import com.cypro.model.*;

@Service("VoiceService")
public class VoiceService {

	@Autowired
	VoiceDao voiceDao = new VoiceDao();

	// ==============================================================================================
	// VOICE
	/**
	 * 根據charaId取得語音列表
	 */
	public List<VoiceDto> getVoiceList(String charaId) {
		return voiceDao.getVoiceList(charaId);
	}

	/**
	 * 更新/新增語音資料
	 */
	public boolean saveVoice(VoiceDto voiceDto) {
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		voiceDto.setLastModified(datetime.toString());

		if (voiceDao.getVoiceByVoiceId(voiceDto.getVoiceId()) != null) {
			int resultInt = voiceDao.updateVoice(voiceDto);
			return (resultInt > 0) ? true : false;
		} else {
			int resultInt = voiceDao.insertVoice(voiceDto);
			return (resultInt > 0) ? true : false;
		}
	}

	/**
	 * 取得聲優
	 */
	public String getVoiceActor(String charaId) {
		String voiceActor = voiceDao.getVoiceActor(charaId);
		return voiceActor;
	}

	/**
	 * 更新聲優
	 */
	public boolean saveVoiceActor(String charaId, String voiceActor) {
		int resultInt = voiceDao.updateVoiceActor(charaId, voiceActor);
		return (resultInt > 0) ? true : false;
	}

	/**
	 * 根據聲優取得角色中文名列表
	 */
	public List<String> getCharaListByVoiceActor(String voiceActor) {
		List<String> CharaNameList = voiceDao.getCharaListByVoiceActor(voiceActor);
		return CharaNameList;
	}

	/**
	 * 取得聲優資料
	 */
	public String getVa_info(String voiceActor) {
		String va_info = voiceDao.getVa_info(voiceActor);
		return (va_info == null) ? "" : va_info;
	}

	/**
	 * 更新/新增聲優資料
	 */
	public boolean saveVa_info(String voiceActor, String va_info) {
		if (voiceDao.getVa_info(voiceActor) != null) {
			int resultInt = voiceDao.updateVa_info(voiceActor, va_info);
			return (resultInt > 0) ? true : false;
		} else {
			int resultInt = voiceDao.insertVa_info(voiceActor, va_info);
			return (resultInt > 0) ? true : false;
		}
	}
}