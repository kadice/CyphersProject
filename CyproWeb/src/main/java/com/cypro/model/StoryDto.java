package com.cypro.model;

public class StoryDto {
	private String chapter = "";			// 章
	private String section = "";			// 節
	private String title = "";			    // 標題
	private String storyContent_kr = "";	// 韓文故事
	private String storyContent_ch = "";	// 中文故事
	private String lastModified = "";	// 最後編輯時間
	
	
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter.trim();
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section.trim();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStoryContent_kr() {
		return storyContent_kr;
	}
	public void setStoryContent_kr(String storyContent_kr) {
		this.storyContent_kr = storyContent_kr.trim();
	}
	public String getStoryContent_ch() {
		return storyContent_ch;
	}
	public void setStoryContent_ch(String storyContent_ch) {
		this.storyContent_ch = storyContent_ch.trim();
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified.trim();
	}
}
