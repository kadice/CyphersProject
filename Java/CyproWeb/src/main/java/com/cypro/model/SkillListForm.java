package com.cypro.model;

import java.util.List;

public class SkillListForm {
	private List<SkillDto> skillDtoList;
	private String charaId;
	private String charaName;
	private String extSkillDesc;

	public List<SkillDto> getSkillDtoList() {
		return skillDtoList;
	}

	public void setSkillDtoList(List<SkillDto> skillDtoList) {
		this.skillDtoList = skillDtoList;
	}

	public String getCharaId() {
		return charaId;
	}

	public void setCharaId(String charaId) {
		this.charaId = charaId;
	}

	public String getCharaName() {
		return charaName;
	}

	public void setCharaName(String charaName) {
		this.charaName = charaName;
	}

	public String getExtSkillDesc() {
		return extSkillDesc;
	}

	public void setExtSkillDesc(String extSkillDesc) {
		this.extSkillDesc = extSkillDesc;
	}
}