package com.cypro.service;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypro.dao.SkillDao;
import com.cypro.model.*;

@Service("SkillService")
public class SkillService {

	@Autowired
	SkillDao skillDao = new SkillDao();

	// ==============================================================================================
	// SKILL
	/**
	 * 根據charaId取得技能列表
	 */
	public List<SkillDto> getSkillList(String charaId) throws SQLException, IOException {
		List<SkillDto> skillList = skillDao.getSkillList(charaId);
		return skillList;
	}

	/**
	 * 根據charaId取得working=1的技能列表
	 */
	public List<SkillDto> getWorkingSkillList(String charaId) throws SQLException, IOException {
		List<SkillDto> skillList = skillDao.getWorkingSkillList(charaId);
		return skillList;
	}

	/**
	 * 更新/新增 技能資料
	 */
	public boolean saveSkill(SkillDto skillDto) throws SQLException, IOException {
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		skillDto.setLastModified(datetime.toString());

		String charaId = skillDto.getCharaId();
		String skillSeq = skillDto.getSkillSeq();
		if (skillDao.getSkillByIdAndSeq(charaId, skillSeq) != null) {
			int resultInt = skillDao.updateSkill(skillDto);
			return (resultInt > 0) ? true : false;
		} else {
			int resultInt = skillDao.insertSkill(skillDto);
			return (resultInt > 0) ? true : false;
		}
	}

	/**
	 * 取得擴充技能表狀態描述
	 */
	public String getExtSkillDesc(String charaId) {
		String extSkillDesc = skillDao.getExtSkillDesc(charaId);
		return extSkillDesc;
	}

	/**
	 * 更新擴充技能表狀態描述
	 */
	public boolean saveExtSkillDesc(String charaId, String extSkillDesc) {
		int resultInt = skillDao.updateExtSkillDesc(charaId, extSkillDesc);
		return (resultInt > 0) ? true : false;
	}
}