package com.cypro.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.cypro.model.*;

public class StoryDao extends SqlSessionDaoSupport {

	// ==============================================================================================
	// chronology
	/**
	 * 取得事件年表
	 */
	public String getChronology() {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("chapter", "OTHERS");
		paramMap.put("section", "0");
		StoryDto tempStoryDto = getSqlSession().selectOne("getStory", paramMap);
		String chronology = tempStoryDto.getStoryContent_ch();
		return chronology;
	}

	// ==============================================================================================
	// dictionary
	/**
	 * 取得名詞辭典
	 */
	public String getDictionary() {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("chapter", "OTHERS");
		paramMap.put("section", "1");
		StoryDto tempStoryDto = getSqlSession().selectOne("getStory", paramMap);
		String dictionary = tempStoryDto.getStoryContent_ch();
		return dictionary;
	}

	// ==============================================================================================
	// STORY
	/**
	 * 取得所有背景故事章節
	 */
	public List<String> getChapters() {
		List<String> ColumnDistValue = getSqlSession().selectList("getChapters");
		return ColumnDistValue;
	}

	/**
	 * 取得對應章節的背景故事內容
	 */
	public StoryDto getStory(String chapter, String section) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("chapter", chapter);
		paramMap.put("section", section);
		StoryDto storyDto = getSqlSession().selectOne("getStory", paramMap);
		return storyDto;
	}
	/**
	 * 根據chapter取得背景故事列表
	 */
	public List<StoryDto> getStoryListByChapter(String chapter) {

		List<StoryDto> storyDtoList = getSqlSession().selectList("getStoryListByChapter", chapter);
		return storyDtoList;
	}

	/**
	 * update背景故事內容
	 */
	public int updateStory(StoryDto storyDto) {
		return getSqlSession().update("updateStory", storyDto);
	}

	/**
	 * insert背景故事內容
	 */
	public void insertStory(StoryDto storyDto) {
		getSqlSession().insert("insertStory", storyDto);
	}

	/**
	 * 查詢該Story是否存在
	 */
	public boolean isStoryExist(String chapter, String section) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("chapter", chapter);
		paramMap.put("section", section);
		String temp = getSqlSession().selectOne("isStoryExist", paramMap);
		return (null != temp) ? true : false;
	}
}
