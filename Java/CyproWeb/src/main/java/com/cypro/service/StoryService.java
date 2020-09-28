package com.cypro.service;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypro.dao.StoryDao;
import com.cypro.model.*;

@Service("StoryService")
public class StoryService {

	@Autowired
	StoryDao storyDao = new StoryDao();

	// ==============================================================================================
	// STORY
	/**
	 * 取得事件年表
	 */
	public String getChronology() {
		return storyDao.getChronology();
	}

	/**
	 * 更新/新增事件年表
	 */
	public void saveChronology(String chronology) {
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		StoryDto storyDto = new StoryDto();
		storyDto.setChapter("OTHERS");
		storyDto.setSection("0");
		storyDto.setStoryContent_ch(chronology);
		storyDto.setLastModified(datetime.toString());
		if (storyDao.isStoryExist(storyDto.getChapter(), storyDto.getSection())) {
			storyDao.updateStory(storyDto);
		} else {
			storyDao.insertStory(storyDto);
		}
	}

	// ==============================================================================================
	// STORY
	/**
	 * 取得名詞辭典
	 */
	public String getDictionary() {
		return storyDao.getDictionary();
	}

	/**
	 * 更新/新增名詞辭典
	 */
	public void saveDictionary(String dictionary) {
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		StoryDto storyDto = new StoryDto();
		storyDto.setChapter("OTHERS");
		storyDto.setSection("1");
		storyDto.setStoryContent_ch(dictionary);
		storyDto.setLastModified(datetime.toString());
		if (storyDao.isStoryExist(storyDto.getChapter(), storyDto.getSection())) {
			storyDao.updateStory(storyDto);
		} else {
			storyDao.insertStory(storyDto);
		}
	}

	// ==============================================================================================
	// STORY
	/**
	 * 取得所有背景故事章節
	 */
	public List<String> getChapters() {
		return storyDao.getChapters();
	}

	/**
	 * 取得對應章節的背景故事內容
	 */
	public StoryDto getStory(String chapter, String section) throws SQLException, IOException {
		StoryDto storyDto = new StoryDto();
		storyDto = storyDao.getStory(chapter, section);
		return storyDto;
	}
	/**
	 *  根據chapter取得背景故事列表
	 */
	public List<StoryDto> getStoryListByChapter(String chapter) throws SQLException, IOException {
		List<StoryDto> storyDtoList = storyDao.getStoryListByChapter(chapter);
		return storyDtoList;
	}

	/**
	 * 更新/新增背景故事內容
	 */
	public void saveStory(StoryDto storyDto) {
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		storyDto.setLastModified(datetime.toString());
		if (storyDao.isStoryExist(storyDto.getChapter(), storyDto.getSection())) {
			storyDao.updateStory(storyDto);
		} else {
			storyDao.insertStory(storyDto);
		}
	}

}