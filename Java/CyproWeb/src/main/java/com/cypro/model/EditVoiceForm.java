package com.cypro.model;

import java.util.List;

public class EditVoiceForm {
	private String charaName_ch;
	private String voiceActor;
	private String voiceActor_bk;
	private String va_info;
	private String va_info_bk;
	private List<VoiceDto> voiceList_pack;
	private List<VoiceDto> voiceList_base;
	private List<VoiceDto> voiceList_skill;
	private List<VoiceDto> voiceList_quick;

	private String lastEditId;
	
	public String getCharaName_ch() {
		return charaName_ch;
	}
	public void setCharaName_ch(String charaName_ch) {
		this.charaName_ch = charaName_ch;
	}
	public String getVoiceActor() {
		return voiceActor;
	}
	public void setVoiceActor(String voiceActor) {
		this.voiceActor = voiceActor;
	}
	public String getVoiceActor_bk() {
		return voiceActor_bk;
	}
	public void setVoiceActor_bk(String voiceActor_bk) {
		this.voiceActor_bk = voiceActor_bk;
	}
	public String getVa_info() {
		return va_info;
	}
	public void setVa_info(String va_info) {
		this.va_info = va_info;
	}
	public String getVa_info_bk() {
		return va_info_bk;
	}
	public void setVa_info_bk(String va_info_bk) {
		this.va_info_bk = va_info_bk;
	}
	public List<VoiceDto> getVoiceList_pack() {
		return voiceList_pack;
	}
	public void setVoiceList_pack(List<VoiceDto> voiceList_pack) {
		this.voiceList_pack = voiceList_pack;
	}
	public List<VoiceDto> getVoiceList_base() {
		return voiceList_base;
	}
	public void setVoiceList_base(List<VoiceDto> voiceList_base) {
		this.voiceList_base = voiceList_base;
	}
	public List<VoiceDto> getVoiceList_skill() {
		return voiceList_skill;
	}
	public void setVoiceList_skill(List<VoiceDto> voiceList_skill) {
		this.voiceList_skill = voiceList_skill;
	}
	public List<VoiceDto> getVoiceList_quick() {
		return voiceList_quick;
	}
	public void setVoiceList_quick(List<VoiceDto> voiceList_quick) {
		this.voiceList_quick = voiceList_quick;
	}
	public String getLastEditId() {
		return lastEditId;
	}
	public void setLastEditId(String lastEditId) {
		this.lastEditId = lastEditId;
	} 
}