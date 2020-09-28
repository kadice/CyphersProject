<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">
.se-icon{
	background-color: antiquewhite;
	vertical-align: sub;
	height: 20px;
	border-radius: 5px;
}
th.selTh{
	cursor: pointer;
}
th.selTh.selected{
	background-color: #800000;
	cursor: default;
}
th.selTh.disabled{
	background-color: #592B03;
	cursor: default;
	opacity: 0.4;
}
td{
	font-weight: bold;
}
</style>
<h3 style="width: 950px">技能情報——${charaName}</h3>
<div class="leftTabs">
	<ul class="nav nav-tabs ">
		<c:forEach items="${skillList}" var="skill" varStatus="varSta">
			<c:if test="${varSta.index == 0}">
				<li class="active"><a data-toggle="tab" href="#tab_${skill.hotkey}"><img src="\resources\icon\sk_hotkey_${skill.hotkey}.png"></a></li>
			</c:if>
			<c:if test="${varSta.index != 0}">
				<li><a data-toggle="tab" href="#tab_${skill.hotkey}"><img src="\resources\icon\sk_hotkey_${skill.hotkey}.png"></a></li>
			</c:if>
		</c:forEach>
	</ul>
	<div class="tab-content">
		<c:forEach items="${skillList}" var="skill" varStatus="varSta">
			<div id="tab_${skill.hotkey}" class="tab-pane fade">
				
				<h3>基本情報</h3>
				<div class="charaTable">
					<table class="table top-th-bottom-tr" style="width: 850px">
						<colgroup>
							<col width="282">
							<col width="550">
						</colgroup>
						<thead>
						</thead>
						<tbody>
							<tr><th>${skill.skillName}<br>${skill.skillName_ch}</th>
								<td rowspan="2">${skill.description}</td></tr>
							<tr><td><img src="\resources\icon\sk_hotkey_${skill.hotkey}.png">${skill.hotkeyDesc}</td>
								</tr>
							<tr><th class="sub-th">冷卻時間</th>
								<td rowspan="8"><object type="application/x-shockwave-flash" data="\resources\player_flv.swf" width="550" height="315">
												     <param name="movie" value="player_flv.swf" />
												     <param name="FlashVars" value="flv=${skill.videoURL}&amp;autoload=1&amp;buffer=10&amp;showvolume=1&amp;showtime=1" />
												</object></td></tr>
							<tr><td>${skill.cooltime}</td></tr>
							<tr><th class="sub-th">距離/範圍</th></tr>
							<tr><td>${skill.distance}</td></tr>
							<tr><th class="sub-th">攻擊判定</th></tr>
							<tr><td>${skill.skilltype}</td></tr>
							<tr><th class="sub-th">擊倒觸發</th></tr>
							<tr><td>${skill.down}</td></tr>
						</tbody>
					</table>
				</div>
				
				<h3>詳細情報</h3>
				<div class="charaTable">
					<table class="table left-th-right-tr" style="width: 850px">
						<colgroup>
							<col width="80">
							<col width="80">
							<col width="80">
							<col width="80">
							<col width="80">
							<col width="80">
						</colgroup>
						<thead>
						</thead>
						<tbody>
							<tr><th class="selTh th-damage" onclick="selectTh('damage${skill.skillSeq}');"><input type="hidden" id="damage${skill.skillSeq}" value="true">
									<font>傷害係數</font><span class="caret"></span></th>
								<th class="selTh th-spEffect" onclick="selectTh('spEffect${skill.skillSeq}');"><input type="hidden" id="spEffect${skill.skillSeq}" value="${skill.spEffect}">
									<img src="\resources\icon\sk_se_spEffect.png" class="se-icon"><font>特殊效果</font><span class="caret"></span></th>
								<th class="selTh th-superArmor" onclick="selectTh('superArmor${skill.skillSeq}');"><input type="hidden" id="superArmor${skill.skillSeq}" value="${skill.superArmor}">
									<img src="\resources\icon\sk_se_sparmor.png" class="se-icon"><font>霸體</font><span class="caret"></span></th>
								<th class="selTh th-invincible" onclick="selectTh('invincible${skill.skillSeq}');"><input type="hidden" id="invincible${skill.skillSeq}" value="${skill.invincible}">
									<img src="\resources\icon\sk_se_invincible.png" class="se-icon"><font>無敵</font><span class="caret"></span></th>
								<th class="selTh th-catchJudge" onclick="selectTh('catchJudge${skill.skillSeq}');"><input type="hidden" id="catchJudge${skill.skillSeq}" value="${skill.catchJudge}">
									<img src="\resources\icon\sk_se_catchJudge.png" class="se-icon"><font>抓取判定</font><span class="caret"></span></th>
								<th class="selTh th-catchAvoid" onclick="selectTh('catchAvoid${skill.skillSeq}');"><input type="hidden" id="catchAvoid${skill.skillSeq}" value="${skill.catchAvoid}">
									<img src="\resources\icon\sk_se_catchAvoid.png" class="se-icon"><font>抓取抵抗</font><span class="caret"></span></th>
								</tr>
							<tr><td colspan="6" style="height: 10px;">
								</td></tr>
							
							<tr class="selTr damage">
								<th class="sub-th">對人係數</th><td>${skill.toPlayer}</td>
								<th class="sub-th">對建築係數</th><td>${skill.toTower}</td>
								<th class="sub-th">對怪物係數</th><td>${skill.toTrooper}</td></tr>
							<c:if test="${not empty skill.damage1_wording || not empty skill.damage1}">
								<tr class="selTr damage"><th class="sub-th">${skill.damage1_wording}</th><td colspan="5">${skill.damage1}</td></tr>
							</c:if>
							<c:if test="${not empty skill.damage2_wording || not empty skill.damage2}">
								<tr class="selTr damage"><th class="sub-th">${skill.damage2_wording}</th><td colspan="5">${skill.damage2}</td></tr>
							</c:if>
							<c:if test="${not empty skill.damage3_wording || not empty skill.damage3}">
								<tr class="selTr damage"><th class="sub-th">${skill.damage3_wording}</th><td colspan="5">${skill.damage3}</td></tr>
							</c:if>
							<c:if test="${not empty skill.damage4_wording || not empty skill.damage4}">
								<tr class="selTr damage"><th class="sub-th">${skill.damage4_wording}</th><td colspan="5">${skill.damage4}</td></tr>
							</c:if>
							<c:if test="${not empty skill.damage5_wording || not empty skill.damage5}">
								<tr class="selTr damage"><th class="sub-th">${skill.damage5_wording}</th><td colspan="5">${skill.damage5}</td></tr>
							</c:if>
							<c:if test="${not empty skill.damage6_wording || not empty skill.damage6}">
								<tr class="selTr damage"><th class="sub-th">${skill.damage6_wording}</th><td colspan="5">${skill.damage6}</td></tr>
							</c:if>
							
							<tr class="selTr spEffect">
								<td colspan="6">${skill.spEffect_effect}</td></tr>
							
							<tr class="selTr superArmor">
								<th class="sub-th">種類</th><td colspan="2">${skill.superArmor_type}</td>
								<th class="sub-th">方向</th><td colspan="2">${skill.superArmor_direct}</td></tr>
							<tr class="selTr superArmor">
								<th class="sub-th">適用時機</th><td colspan="5">${skill.superArmor_timing}</td></tr>
							
							<tr class="selTr invincible">
								<th class="sub-th">種類</th><td colspan="2">${skill.invincible_type}</td>
								<th class="sub-th">方向</th><td colspan="2">${skill.invincible_direct}</td></tr>
							<tr class="selTr invincible">
								<th class="sub-th">適用時機</th><td colspan="5">${skill.invincible_timing}</td></tr>
							
							<tr class="selTr catchJudge">
								<th class="sub-th">等級</th><td>${skill.catchJudge_lv}</td>
								<th class="sub-th">適用時機</th><td colspan="3">${skill.catchJudge_timing}</td></tr>
								
							<tr class="selTr catchAvoid">
								<th class="sub-th">等級</th><td>${skill.catchAvoid_lv}</td>
								<th class="sub-th">適用時機</th><td colspan="3">${skill.catchAvoid_timing}</td></tr>
						</tbody>
					</table>
				</div>
				
				<h3>玩家補充技巧</h3>
				<div class="charaTable">
					<table class="table" style="width: 850px; height: 150px; vertical-align: top;">
						<tbody>
							<tr><td>${skill.others}</td></tr>
						</tbody>
					</table>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<br>
<script type="text/javascript">
onload();
function onload(){
	// 啟動該角色第一個tab
	var firstTabPane = $('div.tab-content div.tab-pane').first().addClass("in active");
	
	// 設定按下標籤時會把詳細情報按鈕設定在傷害係數
	$('a[data-toggle="tab"]').click(function(){selectTh('damage01');});
	
	// 啟動傷害列；關閉其他列
	selectTh('damage01');
	
	// 設定詳細情報按鈕的CSS
	$('th.selTh').each(function(){setSeCss(this);});
}
function selectTh(key){ //key=damage03
	var keyVal = $("#"+key).attr('value'); // keyVal='true'/'false'
	if(keyVal == 'true'){
		// 設定列
		$('.selTr').css('display','none');
		var keyTag = key.slice(0, -2); // keyTag=damage，把所有技能的damage列都打開
		$('.'+keyTag).css('display','');
		
		// 設定按鈕
		$('.selTh').removeClass('selected');
		$('.th-'+keyTag).addClass('selected');
	}
	
	
}
function setSeCss(targetTh){
	var keyVal = $(targetTh).find('input').val(); 
	if(keyVal == 'false')
		$(targetTh).addClass('disabled');
}
</script>
</html>