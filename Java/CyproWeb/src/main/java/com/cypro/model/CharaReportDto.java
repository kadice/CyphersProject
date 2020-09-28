package com.cypro.model;

public class CharaReportDto {
	private String charaId = "";
	private String language = "";
	private String observed = "";
	private String ability = "";
	private String relatedEvents = "";
	private String report_tony = "";
	private String report_yogi = "";
	private String report_bruno = "";
	private String report_tian = "";
	private String personality = "";
	private String relationship = "";
	private String remark = "";
	private String lastModified = "";	// 最後編輯時間
	
	private String backupStr = ""; //LOG用
	
	public String getCharaId() {
		return charaId;
	}
	public void setCharaId(String charaId) {
		this.charaId = charaId.trim();
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language.trim();
	}
	public String getObserved() {
		return observed;
	}
	public void setObserved(String observed) {
		this.observed = observed.trim();
	}
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability.trim();
	}
	public String getRelatedEvents() {
		return relatedEvents;
	}
	public void setRelatedEvents(String relatedEvents) {
		this.relatedEvents = relatedEvents.trim();
	}
	public String getReport_tony() {
		return report_tony;
	}
	public void setReport_tony(String report_tony) {
		this.report_tony = report_tony.trim();
	}
	public String getReport_yogi() {
		return report_yogi;
	}
	public void setReport_yogi(String report_yogi) {
		this.report_yogi = report_yogi.trim();
	}
	public String getReport_bruno() {
		return report_bruno;
	}
	public void setReport_bruno(String report_bruno) {
		this.report_bruno = report_bruno.trim();
	}
	public String getReport_tian() {
		return report_tian;
	}
	public void setReport_tian(String report_tian) {
		this.report_tian = report_tian;
	}
	public String getPersonality() {
		return personality;
	}
	public void setPersonality(String personality) {
		this.personality = personality.trim();
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship.trim();
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified.trim();
	}
	
	public String getBackupStr() {
		return backupStr;
	}
	public void setBackupStr(String backupStr) {
		this.backupStr = backupStr;
	}
	
	private String toParamStr(){
		// 分隔符號為/@/，並在每個參數後方加上空白以避免空值導致NullPointerException
		return this.charaId+" /@/"
				+this.language+" /@/"
				+"<觀察> "+this.observed+" /@/"
				+"<能力> "+this.ability+" /@/"
				+"<相關> "+this.relatedEvents+" /@/"
				+"<托尼> "+this.report_tony+" /@/"
				+"<夭基> "+this.report_yogi+" /@/"
				+"<布魯諾> "+this.report_bruno+" /@/"
				+"<天正> "+this.report_tian+" /@/"
				+"<性格> "+this.personality+" /@/"
				+"<關係> "+this.relationship+" /@/"
				+"<備註> "+this.remark+" ";
	}
	public void backup(){
		this.backupStr = toParamStr();
	}
	public String toLog(){
		String[] paramsNow = (this.toParamStr()).split("/@/");
		String[] paramsBackup = backupStr.split("/@/");
		
		String log_1 = "<b>["+paramsNow[0].trim()+"/"+paramsNow[1].trim()+"] </b>";
		String log_2 = "";
		for(int i = 2; i < paramsNow.length; i++){
			String a = paramsNow[i];	//新參數+空白
			String b = paramsBackup[i];	//舊參數+空白
			if(!a.equals(b)){
				log_2 += "<s>" + b.trim() + "</s> → " + a.trim() + "; ";
			}
		}
		if("".equals(log_2)){
			log_2 = "CharaReport內容未變動; ";
		}
		else{
			log_2 = log_2.replaceAll("<p>", "");
			log_2 = log_2.replaceAll("</p>", "");
			log_2 = log_2.replaceAll("<br>", "");
		}
		return log_1 + log_2 + "<font style='color:blue'> <最後編輯時間> </font>" + this.lastModified;
	}
}
