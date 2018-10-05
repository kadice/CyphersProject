package com.cypro.model;

public class EquipDto {
	private String equipId = "";		// 裝備代號
	private String equipName = "";		// 韓文名稱
	private String equipName_ch = "";	// 中文名稱
	private String charaId = "";		// 專屬角色或共用
	private String quality = "";		// 品質(1/2/3/4)
	private String segment = "";		// 階數
	private String position = "";		// 部位
	private String cost = "";			// 花費
	private String season = "";			// SEASON
	private String effect = "";			// 裝備效果
	private String information = "";	// 故事情報(裝備句子)
	private String information_ch = "";	// 故事情報中譯
	private String iconURL = "";		// 圖示連結
	private String picURL = "";			// 圖片連結
	private String fullPicURL = "";		// 大圖片連結(粉裝)
	private String lastModified = "";	// 最後編輯時間
	
	private boolean changed = false;	// 批次儲存時，分辨是否被編輯過
	private String backupStr = ""; 		// LOG用

	private String qualityStr = "";		// 品質(普通/少見/稀有/獨特)(查詢時由公共資料表併入)
	private String charaName = "";		// 專屬角色或共用(查詢時由CHARADATA資料表併入)
	
	public String getEquipId() {
		return equipId;
	}
	public void setEquipId(String equipId) {
		this.equipId = equipId.trim();
	}
	public String getEquipName() {
		return equipName;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName.trim();
	}
	public String getEquipName_ch() {
		return equipName_ch;
	}
	public void setEquipName_ch(String equipName_ch) {
		this.equipName_ch = equipName_ch.trim();
	}
	public String getCharaId() {
		return charaId;
	}
	public void setCharaId(String charaId) {
		this.charaId = charaId.trim();
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality.trim();
	}
	public String getQualityStr() {
		return qualityStr;
	}
	public void setQualityStr(String qualityStr) {
		this.qualityStr = qualityStr.trim();
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment.trim();
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season.trim();
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position.trim();
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost.trim();
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect.trim();
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information.trim();
	}
	public String getInformation_ch() {
		return information_ch;
	}
	public void setInformation_ch(String information_ch) {
		this.information_ch = information_ch.trim();
	}
	public String getIconURL() {
		return iconURL;
	}
	public void setIconURL(String iconURL) {
		this.iconURL = iconURL.trim();
	}
	public String getPicURL() {
		return picURL;
	}
	public void setPicURL(String picURL) {
		this.picURL = picURL.trim();
	}
	public String getFullPicURL() {
		return fullPicURL;
	}
	public void setFullPicURL(String fullPicURL) {
		this.fullPicURL = fullPicURL.trim();
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
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified.trim();
	}
	
	public String getCharaName() {
		return charaName;
	}
	public void setCharaName(String charaName) {
		this.charaName = charaName;
	}
	
	public String toEffectCheck(){
		return "["+equipId+"/"+charaId+"/"+quality+"/"+position+"] "+toOneLine(effect)+".";
	}
	
	private String toOneLine(String str){
		return str.replaceAll("<br>", "||");
	}

	private String toParamStr(){
		// 分隔符號為/@/，並在每個參數後方加上空白以避免空值導致NullPointerException
		String paramStr = equipId+" /@/"+
						equipName+" /@/"+
						equipName_ch+" /@/"+
						charaId+" /@/"+
						quality+" /@/"+
						segment+" /@/"+
						position+" /@/"+
						cost+" /@/"+
						season+" /@/"+
						toOneLine(effect)+" /@/"+
						information+" /@/"+
						information_ch+" /@/"+
						iconURL+" /@/"+
						picURL+" ";
		return paramStr;
	}

	public void backup(){
		this.backupStr = toParamStr();
	}

//	public String toLog(){
//		String effectInOneLine =  effect.replaceAll("<br>", "||");
//		String tempInformation = (information != "")? "<br>"+information:information;
//		return "["+equipId+"] "+equipName+", "+equipName_ch+", "+charaId+", "+quality+", "+segment+", "+position+", "+season+", "+cost+"金幣, "+effectInOneLine+", "
//				+tempInformation+", "+information_ch+", <br>"
//				+iconURL+", "+picURL+", "+fullPicURL+".";
//	}
	
	public String toLog(){
		String[] paramsNow = (this.toParamStr()).split("/@/");
		String[] paramsBackup = backupStr.split("/@/");
		for(int i = 0; i < paramsNow.length; i++){
			String a = paramsNow[i];	//新參數+空白
			String b = paramsBackup[i];	//舊參數+空白
//			b = b.replace("\n", "");//不明原因讀取舊參數時會多出\n
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
