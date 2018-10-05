package com.cypro.model;

public class EditCharaForm {
	private String editType;
	private CharaDataDto charaDataDto;
	private CharaReportDto charaReportDto_CH;
	private CharaReportDto charaReportDto_KR;
	private CharaOthersDto charaOthersDto; 

	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public CharaDataDto getCharaDataDto() {
		return charaDataDto;
	}
	public void setCharaDataDto(CharaDataDto charaDataDto) {
		this.charaDataDto = charaDataDto;
	}
	public CharaReportDto getCharaReportDto_CH() {
		return charaReportDto_CH;
	}
	public void setCharaReportDto_CH(CharaReportDto charaReportDto_CH) {
		this.charaReportDto_CH = charaReportDto_CH;
	}
	public CharaReportDto getCharaReportDto_KR() {
		return charaReportDto_KR;
	}
	public void setCharaReportDto_KR(CharaReportDto charaReportDto_KR) {
		this.charaReportDto_KR = charaReportDto_KR;
	}
	public CharaOthersDto getCharaOthersDto() {
		return charaOthersDto;
	}
	public void setCharaOthersDto(CharaOthersDto charaOthersDto) {
		this.charaOthersDto = charaOthersDto;
	}
}