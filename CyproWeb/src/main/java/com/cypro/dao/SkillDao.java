package com.cypro.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.cypro.model.*;

public class SkillDao extends SqlSessionDaoSupport {

	// ==============================================================================================
	// SKILL
	/**
	 * 根據charaId取得技能列表
	 */
	public List<SkillDto> getSkillList(String charaId) {
		List<SkillDto> skillList = getSqlSession().selectList("getSkillList", charaId);
		return skillList;
	}

	/**
	 * 根據charaId取得working=1的技能列表
	 */
	public List<SkillDto> getWorkingSkillList(String charaId) {
		List<SkillDto> skillList = getSqlSession().selectList("getWorkingSkillList", charaId);
		return skillList;
	}

	/**
	 * 根據charaId和skillSeq取得單一技能資料
	 */
	public SkillDto getSkillByIdAndSeq(String charaId, String skillSeq) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("charaId", charaId);
		paramMap.put("skillSeq", skillSeq);
		SkillDto skill = getSqlSession().selectOne("getSkillByIdAndSeq", paramMap);
		return skill;
	}

	/**
	 * update技能資料
	 */
	public int updateSkill(SkillDto skillDto) {
		return getSqlSession().update("updateSkill", skillDto);
	}

	/**
	 * insert技能資料
	 */
	public int insertSkill(SkillDto skillDto) {
		return getSqlSession().insert("insertSkill", skillDto);
	}

	/**
	 * 取得擴充技能表狀態描述
	 */
	public String getExtSkillDesc(String charaId) {
		String extSkillDesc = getSqlSession().selectOne("getExtSkillDesc", charaId);
		return extSkillDesc;
	}

	/**
	 * 更新擴充技能表狀態描述
	 */
	public int updateExtSkillDesc(String charaId, String extSkillDesc) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("charaId", charaId);
		paramMap.put("extSkillDesc", extSkillDesc);
		return getSqlSession().update("updateExtSkillDesc", paramMap);
	}

}
