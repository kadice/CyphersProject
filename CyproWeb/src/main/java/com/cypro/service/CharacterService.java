package com.cypro.service;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypro.dao.CharacterDao;
import com.cypro.model.*;

@Service("CharacterService")
public class CharacterService {

	@Autowired
	CharacterDao characterDao = new CharacterDao();

	// ==============================================================================================
	// CHARADATA
	/**
	 * 根據charaId取得能力者基本資料
	 */
	public CharaDataDto getCharaData(String charaId) throws SQLException, IOException {
		CharaDataDto charaDataDto = (CharaDataDto) characterDao.getCharaData(charaId);
		return charaDataDto;
	}

	/**
	 * 更新/新增 能力者基本資料
	 */
	public boolean saveCharaData(CharaDataDto charaDataDto) {
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		charaDataDto.setLastModified(datetime.toString());

		if (characterDao.getCharaData(charaDataDto.getCharaId()) != null) {
			int resultInt = characterDao.updateCharaData(charaDataDto);
			return (resultInt > 0) ? true : false;
		} else {
			int resultInt = characterDao.insertCharaData(charaDataDto);
			return (resultInt > 0) ? true : false;
		}
	}

	// ==============================================================================================
	// CHARAREPORT
	/**
	 * 根據id,language取得角色調查報告
	 * 
	 * @param charaId  角色英文名
	 * @param language CH:中文 KR:韓文
	 */
	public CharaReportDto getCharaReport(String charaId, String language) throws SQLException, IOException {
		CharaReportDto charaReportDto = (CharaReportDto) characterDao.getCharaReport(charaId, language);
		return charaReportDto;
	}

	/**
	 * 更新/新增 能力者調查報告
	 */
	public boolean saveCharaReport(CharaReportDto charaReportDto) {
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		charaReportDto.setLastModified(datetime.toString());

		if (characterDao.isCharaReportExist(charaReportDto.getCharaId(), charaReportDto.getLanguage())) {
			int resultInt = characterDao.updateCharaReport(charaReportDto);
			return (resultInt > 0) ? true : false;
		} else {
			int resultInt = characterDao.insertCharaReport(charaReportDto);
			return (resultInt > 0) ? true : false;
		}
	}

	// ==============================================================================================
	// CHARAOTHERS
	/**
	 * 根據charaId取得能力者補充資料
	 */
	public CharaOthersDto getCharaOthers(String charaId) {
		CharaOthersDto charaOthersDto = (CharaOthersDto) characterDao.getCharaOthers(charaId);
		return charaOthersDto;
	}

	/**
	 * 更新/新增 能力者補充資料
	 */
	public boolean saveCharaOthers(CharaOthersDto charaOthersDto) {
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		charaOthersDto.setLastModified(datetime.toString());

		String charaId = charaOthersDto.getCharaId();
		if (characterDao.getCharaOthers(charaId) != null) {
			int resultInt = characterDao.updateCharaOthers(charaOthersDto);
			return (resultInt > 0) ? true : false;
		} else {
			int resultInt = characterDao.insertCharaOthers(charaOthersDto);
			return (resultInt > 0) ? true : false;
		}
	}

}