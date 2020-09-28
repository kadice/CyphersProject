package com.cypro.model;

public class CharaDataDto {

	private String number;//於新增角色時自動給予，只能直接從DB編輯
	
	private String charaId = "";
	private String title = "";
	private String title_ch = "";
	private String title_ch_old = "";
	private String charaName = "";
	private String charaName_ch = "";
	private String positionDescribe = "";
	private String positionDescribe_ch = "";
	private String fullName = "";
	private String fullName_ch = "";
	private String fullName_en = "";
	private String codeName = "";
	private String codeName_ch = "";
	private String nation = "";
	private String nation_ch = "";
	private String belongs = "";
	private String belongs_ch = "";
	private String job = "";
	private String job_ch = "";
	private String age = "";
	private String birthday = "";
	private String height = "";
	private String weight = "";
	private String iconURL = "";
	private String pictureURL = "";
	private String themeURL = "";
	private String chReportExist = "";
	
	private String abi_close = "";
	private String abi_distance = "";
	private String abi_toPlayer = "";
	private String abi_toTower = "";
	private String abi_difficulty = "";
	private String abi_others1 = "";
	private String abi_others1_wording = "";
	private String abi_others2 = "";
	private String abi_others2_wording = "";
	private String abi_others3 = "";
	private String abi_others3_wording = "";
	
	private String ini_attack = "";
	private String ini_critical = "";
	private String ini_vitality = "";
	private String ini_avoidance = "";
	private String ini_defense = "";
	private String ini_speed = "";

	private String lvUpAbi_lv2 = "";
	private String lvUpAbi_lv3 = "";
	private String lvUpAbi_lv4 = "";
	private String lvUpAbi_lv5 = "";
	private String lvUpAbi_lv6 = "";
	private String lvUpAbi_lv7 = "";
	private String lvUpAbi_lv8 = "";
	private String lvUpAbi_lv9 = "";
	private String lvUpAbi_lv10 = "";
	private String lvUpAbi_lv11 = "";
	private String lvUpAbi_lv12 = "";
	private String lvUpAbi_lv13 = "";
	private String lvUpAbi_lv14 = "";
	private String lvUpAbi_lv15 = "";
	private String lvUpAbi_lv16 = "";
	private String lvUpAbi_lv17 = "";
	private String lvUpAbi_lv18 = "";
	private String lvUpAbi_lv19 = "";
	private String lvUpAbi_lv20 = "";
	private String lastModified = "";	// 最後編輯時間
	private String extSkillDesc = "";
	
	private String backupStr = ""; //LOG用
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number.trim();
	}
	public String getCharaId() {
		return charaId;
	}
	public void setCharaId(String charaId) {
		this.charaId = charaId.trim();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title.trim();
	}
	public String getTitle_ch() {
		return title_ch;
	}
	public void setTitle_ch(String title_ch) {
		this.title_ch = title_ch.trim();
	}
	public String getTitle_ch_old() {
		return title_ch_old;
	}
	public void setTitle_ch_old(String title_ch_old) {
		this.title_ch_old = title_ch_old.trim();
	}
	public String getCharaName() {
		return charaName;
	}
	public void setCharaName(String charaName) {
		this.charaName = charaName.trim();
	}
	public String getCharaName_ch() {
		return charaName_ch;
	}
	public void setCharaName_ch(String charaName_ch) {
		this.charaName_ch = charaName_ch.trim();
	}
	public String getPositionDescribe() {
		return positionDescribe;
	}
	public void setPositionDescribe(String positionDescribe) {
		this.positionDescribe = positionDescribe.trim();
	}
	public String getPositionDescribe_ch() {
		return positionDescribe_ch;
	}
	public void setPositionDescribe_ch(String positionDescribe_ch) {
		this.positionDescribe_ch = positionDescribe_ch.trim();
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName.trim();
	}
	public String getFullName_ch() {
		return fullName_ch;
	}
	public void setFullName_ch(String fullName_ch) {
		this.fullName_ch = fullName_ch.trim();
	}
	public String getFullName_en() {
		return fullName_en;
	}
	public void setFullName_en(String fullName_en) {
		this.fullName_en = fullName_en.trim();
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName.trim();
	}
	public String getCodeName_ch() {
		return codeName_ch;
	}
	public void setCodeName_ch(String codeName_ch) {
		this.codeName_ch = codeName_ch.trim();
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation.trim();
	}
	public String getNation_ch() {
		return nation_ch;
	}
	public void setNation_ch(String nation_ch) {
		this.nation_ch = nation_ch.trim();
	}
	public String getBelongs() {
		return belongs;
	}
	public void setBelongs(String belongs) {
		this.belongs = belongs.trim();
	}
	public String getBelongs_ch() {
		return belongs_ch;
	}
	public void setBelongs_ch(String belongs_ch) {
		this.belongs_ch = belongs_ch.trim();
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job.trim();
	}
	public String getJob_ch() {
		return job_ch;
	}
	public void setJob_ch(String job_ch) {
		this.job_ch = job_ch.trim();
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age.trim();
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday.trim();
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height.trim();
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight.trim();
	}
	public String getIconURL() {
		return iconURL;
	}
	public void setIconURL(String iconURL) {
		this.iconURL = iconURL.trim();
	}
	public String getPictureURL() {
		return pictureURL;
	}
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL.trim();
	}
	public String getThemeURL() {
		return themeURL;
	}
	public void setThemeURL(String themeURL) {
		this.themeURL = themeURL.trim();
	}
	public String getChReportExist() {
		return chReportExist;
	}
	public void setChReportExist(String chReportExist) {
		this.chReportExist = chReportExist.trim();
	}
	
	public String getAbi_close() {
		return abi_close;
	}
	public void setAbi_close(String abi_close) {
		this.abi_close = abi_close.trim();
	}
	public String getAbi_distance() {
		return abi_distance;
	}
	public void setAbi_distance(String abi_distance) {
		this.abi_distance = abi_distance.trim();
	}
	public String getAbi_toPlayer() {
		return abi_toPlayer;
	}
	public void setAbi_toPlayer(String abi_toPlayer) {
		this.abi_toPlayer = abi_toPlayer.trim();
	}
	public String getAbi_toTower() {
		return abi_toTower;
	}
	public void setAbi_toTower(String abi_toTower) {
		this.abi_toTower = abi_toTower.trim();
	}
	public String getAbi_difficulty() {
		return abi_difficulty;
	}
	public void setAbi_difficulty(String abi_difficulty) {
		this.abi_difficulty = abi_difficulty.trim();
	}
	public String getAbi_others1() {
		return abi_others1;
	}
	public void setAbi_others1(String abi_others1) {
		this.abi_others1 = abi_others1.trim();
	}
	public String getAbi_others1_wording() {
		return abi_others1_wording;
	}
	public void setAbi_others1_wording(String abi_others1_wording) {
		this.abi_others1_wording = abi_others1_wording.trim();
	}
	public String getAbi_others2() {
		return abi_others2;
	}
	public void setAbi_others2(String abi_others2) {
		this.abi_others2 = abi_others2.trim();
	}
	public String getAbi_others2_wording() {
		return abi_others2_wording;
	}
	public void setAbi_others2_wording(String abi_others2_wording) {
		this.abi_others2_wording = abi_others2_wording.trim();
	}
	public String getAbi_others3() {
		return abi_others3;
	}
	public void setAbi_others3(String abi_others3) {
		this.abi_others3 = abi_others3.trim();
	}
	public String getAbi_others3_wording() {
		return abi_others3_wording;
	}
	public void setAbi_others3_wording(String abi_others3_wording) {
		this.abi_others3_wording = abi_others3_wording.trim();
	}
	public String getIni_attack() {
		return ini_attack;
	}
	public void setIni_attack(String ini_attack) {
		this.ini_attack = ini_attack.trim();
	}
	public String getIni_critical() {
		return ini_critical;
	}
	public void setIni_critical(String ini_critical) {
		this.ini_critical = ini_critical.trim();
	}
	public String getIni_vitality() {
		return ini_vitality;
	}
	public void setIni_vitality(String ini_vitality) {
		this.ini_vitality = ini_vitality.trim();
	}
	public String getIni_avoidance() {
		return ini_avoidance;
	}
	public void setIni_avoidance(String ini_avoidance) {
		this.ini_avoidance = ini_avoidance.trim();
	}
	public String getIni_defense() {
		return ini_defense;
	}
	public void setIni_defense(String ini_defense) {
		this.ini_defense = ini_defense.trim();
	}
	public String getIni_speed() {
		return ini_speed;
	}
	public void setIni_speed(String ini_speed) {
		this.ini_speed = ini_speed.trim();
	}
	public String getLvUpAbi_lv2() {
		return lvUpAbi_lv2;
	}
	public String getLvUpAbi_lv3() {
		return lvUpAbi_lv3;
	}
	public String getLvUpAbi_lv4() {
		return lvUpAbi_lv4;
	}
	public String getLvUpAbi_lv5() {
		return lvUpAbi_lv5;
	}
	public String getLvUpAbi_lv6() {
		return lvUpAbi_lv6;
	}
	public String getLvUpAbi_lv7() {
		return lvUpAbi_lv7;
	}
	public String getLvUpAbi_lv8() {
		return lvUpAbi_lv8;
	}
	public String getLvUpAbi_lv9() {
		return lvUpAbi_lv9;
	}
	public String getLvUpAbi_lv10() {
		return lvUpAbi_lv10;
	}
	public String getLvUpAbi_lv11() {
		return lvUpAbi_lv11;
	}
	public String getLvUpAbi_lv12() {
		return lvUpAbi_lv12;
	}
	public String getLvUpAbi_lv13() {
		return lvUpAbi_lv13;
	}
	public String getLvUpAbi_lv14() {
		return lvUpAbi_lv14;
	}
	public String getLvUpAbi_lv15() {
		return lvUpAbi_lv15;
	}
	public String getLvUpAbi_lv16() {
		return lvUpAbi_lv16;
	}
	public String getLvUpAbi_lv17() {
		return lvUpAbi_lv17;
	}
	public String getLvUpAbi_lv18() {
		return lvUpAbi_lv18;
	}
	public String getLvUpAbi_lv19() {
		return lvUpAbi_lv19;
	}
	public String getLvUpAbi_lv20() {
		return lvUpAbi_lv20;
	}
	public void setLvUpAbi_lv2(String lvUpAbi_lv2) {
		this.lvUpAbi_lv2 = lvUpAbi_lv2.trim();
	}
	public void setLvUpAbi_lv3(String lvUpAbi_lv3) {
		this.lvUpAbi_lv3 = lvUpAbi_lv3.trim();
	}
	public void setLvUpAbi_lv4(String lvUpAbi_lv4) {
		this.lvUpAbi_lv4 = lvUpAbi_lv4.trim();
	}
	public void setLvUpAbi_lv5(String lvUpAbi_lv5) {
		this.lvUpAbi_lv5 = lvUpAbi_lv5.trim();
	}
	public void setLvUpAbi_lv6(String lvUpAbi_lv6) {
		this.lvUpAbi_lv6 = lvUpAbi_lv6.trim();
	}
	public void setLvUpAbi_lv7(String lvUpAbi_lv7) {
		this.lvUpAbi_lv7 = lvUpAbi_lv7.trim();
	}
	public void setLvUpAbi_lv8(String lvUpAbi_lv8) {
		this.lvUpAbi_lv8 = lvUpAbi_lv8.trim();
	}
	public void setLvUpAbi_lv9(String lvUpAbi_lv9) {
		this.lvUpAbi_lv9 = lvUpAbi_lv9.trim();
	}
	public void setLvUpAbi_lv10(String lvUpAbi_lv10) {
		this.lvUpAbi_lv10 = lvUpAbi_lv10.trim();
	}
	public void setLvUpAbi_lv11(String lvUpAbi_lv11) {
		this.lvUpAbi_lv11 = lvUpAbi_lv11.trim();
	}
	public void setLvUpAbi_lv12(String lvUpAbi_lv12) {
		this.lvUpAbi_lv12 = lvUpAbi_lv12.trim();
	}
	public void setLvUpAbi_lv13(String lvUpAbi_lv13) {
		this.lvUpAbi_lv13 = lvUpAbi_lv13.trim();
	}
	public void setLvUpAbi_lv14(String lvUpAbi_lv14) {
		this.lvUpAbi_lv14 = lvUpAbi_lv14.trim();
	}
	public void setLvUpAbi_lv15(String lvUpAbi_lv15) {
		this.lvUpAbi_lv15 = lvUpAbi_lv15.trim();
	}
	public void setLvUpAbi_lv16(String lvUpAbi_lv16) {
		this.lvUpAbi_lv16 = lvUpAbi_lv16.trim();
	}
	public void setLvUpAbi_lv17(String lvUpAbi_lv17) {
		this.lvUpAbi_lv17 = lvUpAbi_lv17.trim();
	}
	public void setLvUpAbi_lv18(String lvUpAbi_lv18) {
		this.lvUpAbi_lv18 = lvUpAbi_lv18.trim();
	}
	public void setLvUpAbi_lv19(String lvUpAbi_lv19) {
		this.lvUpAbi_lv19 = lvUpAbi_lv19.trim();
	}
	public void setLvUpAbi_lv20(String lvUpAbi_lv20) {
		this.lvUpAbi_lv20 = lvUpAbi_lv20.trim();
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified.trim();
	}
	public String getExtSkillDesc() {
		return extSkillDesc;
	}
	public void setExtSkillDesc(String extSkillDesc) {
		this.extSkillDesc = extSkillDesc;
	}
	public String getBackupStr() {
		return backupStr;
	}
	public void setBackupStr(String backupStr) {
		this.backupStr = backupStr;
	}
	
	
	private String toParamStr(){
		// 分隔符號為/@/，並在每個參數後方加上空白以避免空值導致NullPointerException
		// 0, 1: key
		String paramStr = 
					number+" /@/"+
					charaId+" /@/";
		// 2~27: 基本資料
		paramStr += title+" /@/"+
					title_ch+" /@/"+
					title_ch_old+" /@/"+
					charaName+" /@/"+
					charaName_ch+" /@/"+
					positionDescribe+" /@/"+
					positionDescribe_ch+" /@/"+
					fullName+" /@/"+
					fullName_ch+" /@/"+
					fullName_en+" /@/"+
					codeName+" /@/"+
					codeName_ch+" /@/"+
					nation+" /@/"+
					nation_ch+" /@/"+
					belongs+" /@/"+
					belongs_ch+" /@/"+
					job+" /@/"+
					job_ch+" /@/"+
					age+" /@/"+
					birthday+" /@/"+
					height+" /@/"+
					weight+" /@/"+
					iconURL+" /@/"+
					pictureURL+" /@/"+
					themeURL+" /@/"+
					chReportExist+" /@/";
		// 28~38: 能力評價
		paramStr += abi_close+" /@/"+
					abi_distance+" /@/"+
					abi_toPlayer+" /@/"+
					abi_toTower+" /@/"+
					abi_difficulty+" /@/"+
					abi_others1+" /@/"+
					abi_others1_wording+" /@/"+
					abi_others2+" /@/"+
					abi_others2_wording+" /@/"+
					abi_others3+" /@/"+
					abi_others3_wording+" /@/";
		// 39~44: 空裝數值
		paramStr += ini_attack+" /@/"+
					ini_critical+" /@/"+
					ini_vitality+" /@/"+
					ini_avoidance+" /@/"+
					ini_defense+" /@/"+
					ini_speed+" /@/";
		// 45~63: 升級加成
		paramStr += lvUpAbi_lv2+" /@/"+
					lvUpAbi_lv3+" /@/"+
					lvUpAbi_lv4+" /@/"+
					lvUpAbi_lv5+" /@/"+
					lvUpAbi_lv6+" /@/"+
					lvUpAbi_lv7+" /@/"+
					lvUpAbi_lv8+" /@/"+
					lvUpAbi_lv9+" /@/"+
					lvUpAbi_lv10+" /@/"+
					lvUpAbi_lv11+" /@/"+
					lvUpAbi_lv12+" /@/"+
					lvUpAbi_lv13+" /@/"+
					lvUpAbi_lv14+" /@/"+
					lvUpAbi_lv15+" /@/"+
					lvUpAbi_lv16+" /@/"+
					lvUpAbi_lv17+" /@/"+
					lvUpAbi_lv18+" /@/"+
					lvUpAbi_lv19+" /@/"+
					lvUpAbi_lv20+" ";
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
		String log = "<b>["+paramsNow[0].trim()+"/"+paramsNow[1].trim()+"] </b>";
		for(int i = 2;i < paramsNow.length;i++){
			switch(i){
				case 2: log+="<font style='color:blue'> <基本資料> </font>"; break;
				case 28: log+="<font style='color:blue'> <能力評價> </font>"; break;
				case 39: log+="<font style='color:blue'> <空裝數值> </font>"; break;
				case 45: log+="<font style='color:blue'> <升級加成> </font>";
			}
			log+=paramsNow[i].trim()+"; ";
		}
		return log + "<font style='color:blue'> <最後編輯時間> </font>" + this.lastModified;
	}
}