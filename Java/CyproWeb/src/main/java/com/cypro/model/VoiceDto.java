package com.cypro.model;

public class VoiceDto {
	private String voiceId = "";
	private String charaId = "";
	private String seq = "";
	private String chara_sub = "";
	private String summary = "";
	private String actions = "";
	private String actions_ch = "";
	private String v_lines = "";
	private String v_lines_ch = "";
	private String voiceURL = "";
	private String lastModified = "";	// 最後編輯時間

	private boolean changed = false;	// 批次儲存時，分辨是否被編輯過
	private String backupStr = "";		// LOG用

	public String getVoiceId() {
		return voiceId;
	}

	public void setVoiceId(String voiceId) {
		this.voiceId = voiceId.trim();
	}

	public String getCharaId() {
		return charaId;
	}

	public void setCharaId(String charaId) {
		this.charaId = charaId.trim();
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq.trim();
	}

	public String getChara_sub() {
		return chara_sub;
	}

	public void setChara_sub(String chara_sub) {
		this.chara_sub = chara_sub.trim();
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary.trim();
	}

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions.trim();
	}

	public String getActions_ch() {
		return actions_ch.trim();
	}

	public void setActions_ch(String actions_ch) {
		this.actions_ch = actions_ch.trim();
	}

	public String getV_lines() {
		return v_lines;
	}

	public void setV_lines(String v_lines) {
		this.v_lines = v_lines.trim();
	}

	public String getV_lines_ch() {
		return v_lines_ch;
	}

	public void setV_lines_ch(String v_lines_ch) {
		this.v_lines_ch = v_lines_ch.trim();
	}

	public String getVoiceURL() {
		return voiceURL;
	}

	public void setVoiceURL(String voiceURL) {
		this.voiceURL = voiceURL.trim();
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	public String getBackupStr() {
		return backupStr;
	}

	public void setBackupStr(String backupStr) {
		this.backupStr = backupStr;
	}
	
	private String toParamStr(){
		// 分隔符號為/@/，並在每個參數後方加上空白以避免空值導致NullPointerException
		String paramStr = 
					voiceId+" /@/"+
					charaId+" /@/"+
					seq+" /@/"+
					chara_sub+" /@/"+
					summary+" /@/"+
					actions+" /@/"+
					actions_ch+" /@/"+
					v_lines+" /@/"+
					v_lines_ch+" /@/"+
					voiceURL+" ";
		return paramStr;
	}

	public void backup(){
		this.backupStr = toParamStr();
	}
	
	public String toLog(){
		String[] paramsNow = (this.toParamStr()).split("/@/");
		String[] paramsBackup = backupStr.split("/@/");
		for(int i = 0; i < paramsNow.length; i++){
			String a = paramsNow[i];	//新參數+空白
			String b = paramsBackup[i];	//舊參數+空白
			if(!a.equals(b)){
				paramsNow[i] = "<s>" + b.trim() + "</s> → <font style='color:red'>" + a.trim() + "</font>";
			}
		}
		String log = "<b>["+paramsNow[0].trim()+"] </b>";
		for(int i = 1;i < paramsNow.length;i++){
			log+=paramsNow[i].trim()+"; ";
		}
		return log + "<font style='color:blue'> <最後編輯時間> </font>" + this.lastModified;
	}
}