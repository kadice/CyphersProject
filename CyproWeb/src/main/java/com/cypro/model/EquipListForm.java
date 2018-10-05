package com.cypro.model;

import java.util.List;

public class EquipListForm {
	private String editType;
	private List<EquipDto> equipDtoList;
	private int maxIndex; 
	
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public List<EquipDto> getEquipDtoList() {
		return equipDtoList;
	}
	public void setEquipDtoList(List<EquipDto> equipDtoList) {
		this.equipDtoList = equipDtoList;
	}
	public int getMaxIndex() {
		return maxIndex;
	}
	public void setMaxIndex(int maxIndex) {
		this.maxIndex = maxIndex;
	}
}