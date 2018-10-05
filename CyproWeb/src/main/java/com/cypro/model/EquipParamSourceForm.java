package com.cypro.model;

import java.util.List;
import java.util.Map;

public class EquipParamSourceForm {
	private String searchType;
	private String charaId;
	private String[] quality;
	private String[] position;
	
	private List<Map<String, String>> charaList;
	private Map<String, String> charaItemMap;
	private Map<String, String> qualityItemMap;
	private Map<String, String> positionItemMap;
	private Map<String, String> seasonItemMap;
	private Map<String, String> segmentItemMap;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getCharaId() {
		return charaId;
	}
	public void setCharaId(String charaId) {
		this.charaId = charaId;
	}
	public String[] getQuality() {
		return quality;
	}
	public void setQuality(String[] quality) {
		this.quality = quality;
	}
	public String[] getPosition() {
		return position;
	}
	public void setPosition(String[] position) {
		this.position = position;
	}
	public List<Map<String, String>> getCharaList() {
		return charaList;
	}
	public void setCharaList(List<Map<String, String>> charaList) {
		this.charaList = charaList;
	}
	public Map<String, String> getCharaItemMap() {
		return charaItemMap;
	}
	public Map<String, String> getQualityItemMap() {
		return qualityItemMap;
	}
	public void setQualityItemMap(Map<String, String> qualityItemMap) {
		this.qualityItemMap = qualityItemMap;
	}
	public Map<String, String> getPositionItemMap() {
		return positionItemMap;
	}
	public void setPositionItemMap(Map<String, String> positionItemMap) {
		this.positionItemMap = positionItemMap;
	}
	public void setCharaItemMap(Map<String, String> charaItemMap) {
		this.charaItemMap = charaItemMap;
	}
	public Map<String, String> getSeasonItemMap() {
		return seasonItemMap;
	}
	public void setSeasonItemMap(Map<String, String> seasonItemMap) {
		this.seasonItemMap = seasonItemMap;
	}
	public Map<String, String> getSegmentItemMap() {
		return segmentItemMap;
	}
	public void setSegmentItemMap(Map<String, String> segmentItemMap) {
		this.segmentItemMap = segmentItemMap;
	}
}
