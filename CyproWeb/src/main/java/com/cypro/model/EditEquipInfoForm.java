package com.cypro.model;

import java.util.List;

public class EditEquipInfoForm {
	private String charaName_ch;
	private List<EquipDto> equipInfoList;
	
	public String getCharaName_ch() {
		return charaName_ch;
	}
	public void setCharaName_ch(String charaName_ch) {
		this.charaName_ch = charaName_ch;
	}
	public List<EquipDto> getEquipInfoList() {
		return equipInfoList;
	}
	public void setEquipInfoList(List<EquipDto> equipInfoList) {
		this.equipInfoList = equipInfoList;
	}
}