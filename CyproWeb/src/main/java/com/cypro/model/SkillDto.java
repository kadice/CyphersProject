package com.cypro.model;

public class SkillDto {
	private String charaId = "";		//KEY 角色名
	private String skillSeq = "";		//KEY 技能序號
	private String hotkey = "";			//熱鍵代號
	private boolean working = false;	//是否啟用中
	private String skillName = "";
	private String skillName_ch = "";
	private String description = "";
	private String cooltime = "";
	private String distance = "";
	private String skilltype = "";
	private String down = "";
	private String toPlayer = "";
	private String toTower = "";
	private String toTrooper = "";
	private String damage1 = "";
	private String damage1_wording = "";
	private String damage2 = "";
	private String damage2_wording = "";
	private String damage3 = "";
	private String damage3_wording = "";
	private String damage4 = "";
	private String damage4_wording = "";
	private String damage5 = "";
	private String damage5_wording = "";
	private String damage6 = "";
	private String damage6_wording = "";
	private boolean spEffect = false;
	private String spEffect_effect = "";
	private boolean superArmor = false;
	private String superArmor_type = "";
	private String superArmor_direct = "";
	private String superArmor_timing = "";
	private boolean invincible = false;
	private String invincible_type = "";
	private String invincible_direct = "";
	private String invincible_timing = "";
	private boolean catchJudge = false;
	private String catchJudge_lv = "";
	private String catchJudge_timing = "";
	private boolean catchAvoid = false;
	private String catchAvoid_lv = "";
	private String catchAvoid_timing = "";
	private String videoURL = "";
	private String others = "";
	private String lastModified = "";	// 最後編輯時間
	
	private boolean changed = false;	// 批次儲存時，分辨是否被編輯過
	private String backupStr = ""; 		// LOG用

	private String hotkeyDesc = "";		// 熱鍵圖示與說明(查詢時由公共資料表併入)
	
	public String getCharaId() {
		return charaId;
	}
	public void setCharaId(String charaId) {
		this.charaId = charaId;
	}
	public String getSkillSeq() {
		return skillSeq;
	}
	public void setSkillSeq(String skillSeq) {
		this.skillSeq = skillSeq;
	}
	public String getHotkey() {
		return hotkey;
	}
	public void setHotkey(String hotkey) {
		this.hotkey = hotkey;
	}
	public boolean isWorking() {
		return working;
	}
	public void setWorking(boolean working) {
		this.working = working;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillName_ch() {
		return skillName_ch;
	}
	public void setSkillName_ch(String skillName_ch) {
		this.skillName_ch = skillName_ch;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCooltime() {
		return cooltime;
	}
	public void setCooltime(String cooltime) {
		this.cooltime = cooltime;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getSkilltype() {
		return skilltype;
	}
	public void setSkilltype(String skilltype) {
		this.skilltype = skilltype;
	}
	public String getDown() {
		return down;
	}
	public void setDown(String down) {
		this.down = down;
	}
	public String getToPlayer() {
		return toPlayer;
	}
	public void setToPlayer(String toPlayer) {
		this.toPlayer = toPlayer;
	}
	public String getToTower() {
		return toTower;
	}
	public void setToTower(String toTower) {
		this.toTower = toTower;
	}
	public String getToTrooper() {
		return toTrooper;
	}
	public void setToTrooper(String toTrooper) {
		this.toTrooper = toTrooper;
	}
	public String getDamage1() {
		return damage1;
	}
	public void setDamage1(String damage1) {
		this.damage1 = damage1;
	}
	public String getDamage1_wording() {
		return damage1_wording;
	}
	public void setDamage1_wording(String damage1_wording) {
		this.damage1_wording = damage1_wording;
	}
	public String getDamage2() {
		return damage2;
	}
	public void setDamage2(String damage2) {
		this.damage2 = damage2;
	}
	public String getDamage2_wording() {
		return damage2_wording;
	}
	public void setDamage2_wording(String damage2_wording) {
		this.damage2_wording = damage2_wording;
	}
	public String getDamage3() {
		return damage3;
	}
	public void setDamage3(String damage3) {
		this.damage3 = damage3;
	}
	public String getDamage3_wording() {
		return damage3_wording;
	}
	public void setDamage3_wording(String damage3_wording) {
		this.damage3_wording = damage3_wording;
	}
	public String getDamage4() {
		return damage4;
	}
	public void setDamage4(String damage4) {
		this.damage4 = damage4;
	}
	public String getDamage4_wording() {
		return damage4_wording;
	}
	public void setDamage4_wording(String damage4_wording) {
		this.damage4_wording = damage4_wording;
	}
	public String getDamage5() {
		return damage5;
	}
	public void setDamage5(String damage5) {
		this.damage5 = damage5;
	}
	public String getDamage5_wording() {
		return damage5_wording;
	}
	public void setDamage5_wording(String damage5_wording) {
		this.damage5_wording = damage5_wording;
	}
	public String getDamage6() {
		return damage6;
	}
	public void setDamage6(String damage6) {
		this.damage6 = damage6;
	}
	public String getDamage6_wording() {
		return damage6_wording;
	}
	public void setDamage6_wording(String damage6_wording) {
		this.damage6_wording = damage6_wording;
	}
	public boolean isSpEffect() {
		return spEffect;
	}
	public void setSpEffect(boolean spEffect) {
		this.spEffect = spEffect;
	}
	public String getSpEffect_effect() {
		return spEffect_effect;
	}
	public void setSpEffect_effect(String spEffect_effect) {
		this.spEffect_effect = spEffect_effect;
	}
	public boolean isSuperArmor() {
		return superArmor;
	}
	public void setSuperArmor(boolean superArmor) {
		this.superArmor = superArmor;
	}
	public String getSuperArmor_type() {
		return superArmor_type;
	}
	public void setSuperArmor_type(String superArmor_type) {
		this.superArmor_type = superArmor_type;
	}
	public String getSuperArmor_direct() {
		return superArmor_direct;
	}
	public void setSuperArmor_direct(String superArmor_direct) {
		this.superArmor_direct = superArmor_direct;
	}
	public String getSuperArmor_timing() {
		return superArmor_timing;
	}
	public void setSuperArmor_timing(String superArmor_timing) {
		this.superArmor_timing = superArmor_timing;
	}
	public boolean isInvincible() {
		return invincible;
	}
	public void setInvincible(boolean invincible) {
		this.invincible = invincible;
	}
	public String getInvincible_type() {
		return invincible_type;
	}
	public void setInvincible_type(String invincible_type) {
		this.invincible_type = invincible_type;
	}
	public String getInvincible_direct() {
		return invincible_direct;
	}
	public void setInvincible_direct(String invincible_direct) {
		this.invincible_direct = invincible_direct;
	}
	public String getInvincible_timing() {
		return invincible_timing;
	}
	public void setInvincible_timing(String invincible_timing) {
		this.invincible_timing = invincible_timing;
	}
	public boolean isCatchJudge() {
		return catchJudge;
	}
	public void setCatchJudge(boolean catchJudge) {
		this.catchJudge = catchJudge;
	}
	public String getCatchJudge_lv() {
		return catchJudge_lv;
	}
	public void setCatchJudge_lv(String catchJudge_lv) {
		this.catchJudge_lv = catchJudge_lv;
	}
	public String getCatchJudge_timing() {
		return catchJudge_timing;
	}
	public void setCatchJudge_timing(String catchJudge_timing) {
		this.catchJudge_timing = catchJudge_timing;
	}
	public boolean isCatchAvoid() {
		return catchAvoid;
	}
	public void setCatchAvoid(boolean catchAvoid) {
		this.catchAvoid = catchAvoid;
	}
	public String getCatchAvoid_lv() {
		return catchAvoid_lv;
	}
	public void setCatchAvoid_lv(String catchAvoid_lv) {
		this.catchAvoid_lv = catchAvoid_lv;
	}
	public String getCatchAvoid_timing() {
		return catchAvoid_timing;
	}
	public void setCatchAvoid_timing(String catchAvoid_timing) {
		this.catchAvoid_timing = catchAvoid_timing;
	}
	public String getVideoURL() {
		return videoURL;
	}
	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
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
	public String getHotkeyDesc() {
		return hotkeyDesc;
	}
	public void setHotkeyDesc(String hotkeyDesc) {
		this.hotkeyDesc = hotkeyDesc;
	}
	
	
	private String toParamStr(){
		// 分隔符號為/@/，並在每個參數後方加上空白以避免空值導致NullPointerException
		// 0, 1: key
		String paramStr = 
					this.charaId+" /@/"+
					this.skillSeq+" /@/";
		// 2~10: 基本情報
		paramStr += this.hotkey+" /@/"+
					this.working+" /@/"+
					this.skillName+" /@/"+
					this.skillName_ch+" /@/"+
					this.description+" /@/"+
					this.cooltime+" /@/"+
					this.distance+" /@/"+
					this.skilltype+" /@/"+
					this.down+" /@/";
		// 11~25: 傷害係數
		paramStr += this.toPlayer+" /@/"+
					this.toTower+" /@/"+
					this.toTrooper+" /@/"+
					this.damage1+" /@/"+
					this.damage1_wording+" /@/"+
					this.damage2+" /@/"+
					this.damage2_wording+" /@/"+
					this.damage3+" /@/"+
					this.damage3_wording+" /@/"+
					this.damage4+" /@/"+
					this.damage4_wording+" /@/"+
					this.damage5+" /@/"+
					this.damage5_wording+" /@/"+
					this.damage6+" /@/"+
					this.damage6_wording+" /@/";
		// 26~43: 其他情報
		paramStr += this.spEffect+" /@/"+
					this.spEffect_effect+" /@/"+
					this.superArmor+" /@/"+
					this.superArmor_type+" /@/"+
					this.superArmor_direct+" /@/"+
					this.superArmor_timing+" /@/"+
					this.invincible+" /@/"+
					this.invincible_type+" /@/"+
					this.invincible_direct+" /@/"+
					this.invincible_timing+" /@/"+
					this.catchJudge+" /@/"+
					this.catchJudge_lv+" /@/"+
					this.catchJudge_timing+" /@/"+
					this.catchAvoid+" /@/"+
					this.catchAvoid_lv+" /@/"+
					this.catchAvoid_timing+" /@/"+
					this.videoURL+" /@/"+
					this.others+" ";
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
				case 2: log+="<font style='color:blue'> <基本情報> </font>"; break;
				case 11: log+="<font style='color:blue'> <傷害係數> </font>"; break;
				case 26: log+="<font style='color:blue'> <其他情報> </font>";
			}
			log+=paramsNow[i].trim()+"; ";
		}
		return log + "<font style='color:blue'> <最後編輯時間> </font>" + this.lastModified;
	}
}