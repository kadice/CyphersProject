package com.cypro.model;

public class CharaOthersDto {
	
	private String charaId = "";		// 英文名
	private String content = "";		// 補充資料
	private String lastModified = "";	// 最後編輯時間
	
	private String backupStr = "";		// LOG用

	public String getCharaId() {
		return charaId;
	}

	public void setCharaId(String charaId) {
		this.charaId = charaId.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getBackupStr() {
		return backupStr;
	}

	public void setBackupStr(String backupStr) {
		this.backupStr = backupStr.trim();
	}
}
