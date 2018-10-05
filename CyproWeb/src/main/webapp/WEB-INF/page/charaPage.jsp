<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
/* 各區塊基本位置設定 (設定在id) */
#charaPic	{width: 470px; min-height:550px; display: inline-block; float: left;}
#charaData	{width: 470px; display: inline-block; float: right;}
#theme		{width: 470px; height: 96px;}
#theme_content{width: 470px; height: 65px; background-image:url(/resources/pic/bg-theme.png);}

#groupbox	{width: 950px; clear: left; height: 140px}
#basic		{width: 470px; display: inline-block; float: left;}
#evaluation	{width: 470px; display: inline-block; float: right;}

#skill		{width: 950px; clear: left;}
#equip		{width: 950px;}

#lvUpAbi	{width: 950px;}

#charaReport{width: 950px; min-height: 100px;}
#charaReport_content{clear: right; width: 930px; color: #ecf0f1; background-color: rgba(0,0,0,0.75); padding: 10px; margin:10px; border-radius: 10px;}
#information{width: 950px; min-height: 100px;}
#others		{width: 950px; min-height: 100px;}
#others_content{width: 950px; padding: 10px;}


/* 裝備表格特殊設定 */
/*#equipTable{width: 473px;}*/
#equipColumnBox	{width: 314px; display: inline-block;}
#equipTable th{padding: 0px; text-align: center; vertical-align: middle;}/* 完全置中 */
#equipTable td{padding: 5px; text-align: center; vertical-align: top;}
/* 角色調查報告內的表格設定 */
#c_story_ch table, #c_story_kr table{border: 0px;}
#c_story_ch table td, #c_story_kr table td{border: 0px; background-color: transparent; color: #ecf0f1; font-size: 14px;}

</style>
<div id="charaPic">
	<img border="0"  width="460px" src="${charaDataDto.pictureURL}"
			style="margin: 5px 5px 5px 5px; background-color: transparent; clip: rect(460px,);">
</div>

<div id="charaData">
	<input type="hidden" id="number" value="${charaDataDto.number}"/>
	<input type="hidden" id="themeURL" value="${charaDataDto.themeURL}"/>
	<div>
		<c:if test="${not empty charaDataDto.title_ch_old}">
			<h1><b>${charaDataDto.title_ch_old} ${charaDataDto.charaName_ch}</b></h1>
		</c:if>
		<c:if test="${empty charaDataDto.title_ch_old}">
			<h1><b>${charaDataDto.title_ch} ${charaDataDto.charaName_ch}</b></h1>
		</c:if>
		<br>
		${charaDataDto.title_ch} ${charaDataDto.charaName_ch} -
		${charaDataDto.positionDescribe_ch}
		<br>
		${charaDataDto.title} ${charaDataDto.charaName} -
		${charaDataDto.positionDescribe}
	</div>
	<div class="languageTabs">
		<ul class="nav nav-tabs navbar-right">
			<li class="active"><a data-toggle="tab" href="#c_data_ch">中文</a></li>
			<li><a data-toggle="tab" href="#c_data_kr">韓文</a></li>
		</ul>
	</div>
	<div class="tab-content">
        <div id="c_data_ch" class="tab-pane fade in active">
        	<div class="charaTable">
	            <table class="table left-th-right-tr" style="width: 470px;">
	            	<colgroup>
						<col width="60px">
						<col width="175px">
						<col width="60px">
						<col width="175px">
					</colgroup>
					<tr><th>全名</th><td>${charaDataDto.fullName_ch}<br>
											${charaDataDto.fullName}<br>
											${charaDataDto.fullName_en}</td>
						<th>CODE NAME</th><td>${charaDataDto.codeName}<br>
											${charaDataDto.codeName_ch}</td></tr>
					<tr><th>所屬</th><td>${charaDataDto.belongs_ch}</td>
						<th>國籍</th><td>${charaDataDto.nation_ch}</td></tr>
					<tr><th>職業</th><td colspan="3">${charaDataDto.job_ch}</td>	</tr>
					<tr><th>年齡</th><td>${charaDataDto.age}</td>
						<th>生日</th><td>${charaDataDto.birthday}</td></tr>
					<tr><th>身高</th><td>${charaDataDto.height}</td>
						<th>體重</th><td>${charaDataDto.weight}</td></tr>
	            </table>
	        </div>
        </div>
        <div id="c_data_kr" class="tab-pane fade">
	        <div class="charaTable">
				<table class="table left-th-right-tr" style="width: 470px;">
	            	<colgroup>
						<col width="60px">
						<col width="175px">
						<col width="60px">
						<col width="175px">
					</colgroup>
					<tr><th>全名</th><td>${charaDataDto.fullName_ch}<br>
											${charaDataDto.fullName}<br>
											${charaDataDto.fullName_en}</td>
						<th>CODE NAME</th><td>${charaDataDto.codeName}<br>
											${charaDataDto.codeName_ch}</td></tr>
					<tr><th>所屬</th><td>${charaDataDto.belongs}</td>
						<th>國籍</th><td>${charaDataDto.nation}</td></tr>
					<tr><th>職業</th><td colspan="3">${charaDataDto.job}</td></tr>
					<tr><th>年齡</th><td>${charaDataDto.age}</td>
						<th>生日</th><td>${charaDataDto.birthday}</td></tr>
					<tr><th>身高</th><td>${charaDataDto.height}</td>
						<th>體重</th><td>${charaDataDto.weight}</td></tr>
	            </table>
            </div>
        </div>
    </div>
	<div id="theme">
		<h3>Main Theme</h3>
		<div id="theme_content">
			<font style="color:white; line-height:2.5; padding-left: 10px;">♪ Theme of ${charaDataDto.charaId}</font>
			<audio id="themePlayer" controls style="width: 470px">
				<source src="" type="audio/mpeg">
				<!-- source src="http://static.cyphers.co.kr/media/bgmbox/data/character/${charaDataDto.number}.Cyphers_Theme_of_${charaDataDto.charaId}.mp3" type="audio/mpeg" -->
			</audio>
		</div>
	</div>
</div>

<div id="groupbox">
	<div id="basic">
		<h3>空裝數值</h3>
		<div class="charaTable">
			<table id="table_basic" class="table top-th-bottom-tr" style="width: 470px;">
		       	<colgroup>
					<col width="80">
					<col width="80">
					<col width="80">
					<col width="80">
					<col width="80">
					<col width="80">
				</colgroup>
				<tr><th>攻擊</th>
					<th>暴擊</th>
					<th>血量</th>
					<th>迴避</th>
					<th>防禦</th>
					<th>移動</th>
				</tr>
				<tr><td>${charaDataDto.ini_attack}</td>
					<td>${charaDataDto.ini_critical}</td>
					<td>${charaDataDto.ini_vitality}</td>
					<td>${charaDataDto.ini_avoidance}</td>
					<td>${charaDataDto.ini_defense}</td>
					<td>${charaDataDto.ini_speed}</td>
				</tr>
			</table>
		</div>
	</div>
	
	<div id="evaluation">
		<h3>能力評價</h3>
		<div class="charaTable">
			 <table id="table_evaluation" class="table top-th-bottom-tr" style="width: 470px;">
		       	<colgroup>
					<col width="80">
					<col width="80">
					<col width="80">
					<col width="80">
					<col width="80">
					<c:if test="${not empty charaDataDto.abi_others1_wording}">
						<col width="80">
					</c:if>
					<c:if test="${not empty charaDataDto.abi_others2_wording}">
						<col width="80">
					</c:if>
					<c:if test="${not empty charaDataDto.abi_others3_wording}">
						<col width="80">
					</c:if>
				</colgroup>
				<tr align="center">
					<th>近距離</th>
					<th>遠距離</th>
					<th>對人</th>
					<th>對建築</th>
					<th>難易度</th>
					<c:if test="${not empty charaDataDto.abi_others1_wording}">
						<th style="background-color: #800000;">${charaDataDto.abi_others1_wording}</th>
					</c:if>
					<c:if test="${not empty charaDataDto.abi_others2_wording}">
						<th style="background-color: #800000;">${charaDataDto.abi_others2_wording}</th>
					</c:if>
					<c:if test="${not empty charaDataDto.abi_others3_wording}">
						<th style="background-color: #800000;">${charaDataDto.abi_others3_wording}</th>
					</c:if>
				</tr>
				<tr align="center">
					<td>${charaDataDto.abi_close}</td>
					<td>${charaDataDto.abi_distance}</td>
					<td>${charaDataDto.abi_toPlayer}</td>
					<td>${charaDataDto.abi_toTower}</td>
					<td>${charaDataDto.abi_difficulty}</td>
					<c:if test="${not empty charaDataDto.abi_others1_wording}">
						<td>${charaDataDto.abi_others1}</td>
					</c:if>
					<c:if test="${not empty charaDataDto.abi_others2_wording}">
						<td>${charaDataDto.abi_others2}</td>
					</c:if>
					<c:if test="${not empty charaDataDto.abi_others3_wording}">
						<td>${charaDataDto.abi_others3}</td>
					</c:if>
				</tr>
			</table>
		</div>
	</div>
</div>

<div id="skill">
	<h3>技能說明</h3>
	<div class="charaTable">
		<table class="table left-th-right-tr" style="width: 950px;">
			<colgroup>
				<col width="200px">
				<col width="120px">
				<col width="">
				<col width="58px">
			</colgroup>
			<tbody>
				<c:if test="${not empty skillList}">
					<c:forEach items="${skillList}" var="skill" varStatus="varSta">
						<tr>
							<td><b>${skill.skillName}</b><br>${skill.skillName_ch}</td>
							<td><img src="\resources\icon\sk_hotkey_${skill.hotkey}.png">${skill.hotkeyDesc}</td>
							<td>${skill.description}</td>
							<td style="padding: 0px; text-align: center;">
								<c:if test="${skill.spEffect}">
									<img src="\resources\icon\sk_se_spEffect.png" title="特殊效果" style="margin: -1px -2px;"></c:if>
								<c:if test="${skill.superArmor}">
									<img src="\resources\icon\sk_se_sparmor.png" title="霸體" style="margin: -1px -2px;"></c:if>
								<c:if test="${skill.invincible}">
									<img src="\resources\icon\sk_se_invincible.png" title="無敵" style="margin: -1px -2px;"></c:if>
								<c:if test="${skill.catchJudge}">
									<img src="\resources\icon\sk_se_catchJudge.png" title="抓取判定" style="margin: -1px -2px;"></c:if>
								<c:if test="${skill.catchAvoid}">
									<img src="\resources\icon\sk_se_catchAvoid.png" title="抓取抵抗" style="margin: -1px -2px;"></c:if>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${not empty extSkillList}">
					<tr><td colspan="4" style="height: 10px;"></td></tr>
					<tr><th colspan="4" >${charaDataDto.extSkillDesc}</th></tr>
					<c:forEach items="${extSkillList}" var="extSkill" varStatus="varSta">
						<tr>
							<td><b>${extSkill.skillName}</b><br>${extSkill.skillName_ch}</td>
							<td><img src="\resources\icon\sk_hotkey_${extSkill.hotkey}.png">${extSkill.hotkeyDesc}</td>
							<td>${extSkill.description}</td>
							<td style="padding: 0px; text-align: center;">
								<c:if test="${extSkill.spEffect}">
									<img src="\resources\icon\sk_se_spEffect.png" title="特殊效果" style="margin: -1px -2px;"></c:if>
								<c:if test="${extSkill.superArmor}">
									<img src="\resources\icon\sk_se_sparmor.png" title="霸體" style="margin: -1px -2px;"></c:if>
								<c:if test="${extSkill.invincible}">
									<img src="\resources\icon\sk_se_invincible.png" title="無敵" style="margin: -1px -2px;"></c:if>
								<c:if test="${extSkill.catchJudge}">
									<img src="\resources\icon\sk_se_catchJudge.png" title="抓取判定" style="margin: -1px -2px;"></c:if>
								<c:if test="${extSkill.catchAvoid}">
									<img src="\resources\icon\sk_se_catchAvoid.png" title="抓取抵抗" style="margin: -1px -2px;"></c:if>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>

<div id="equip">
	<h3>粉裝基本資訊</h3>
	<c:if test="${not empty equipList_E}">
		<c:forEach items="${equipList_E}" var="equip" varStatus="count">
			<c:if test="${count.index < 6}">
				<div class="charaTable">
					<table class="table left-th-right-tr" id="equipTable" >
						<tr><th width="65px" rowspan="2"><img src="${equipList_E[count.index].iconURL}" border="1px" width="64px" height="64px"></th>
							<th width="50%">${equipList_E[count.index].equipName}<c:if test="${not empty equipList_E[count.index].equipName_ch}"> (${equipList_E[count.index].equipName_ch})</c:if></th>
							<th width="50%">
								<c:if test="${not empty equipList_S}">
									${equipList_S[count.index].equipName}<c:if test="${not empty equipList_S[count.index].equipName_ch}"> (${equipList_S[count.index].equipName_ch})</c:if>
								</c:if>
							</th>
						</tr>
						<tr><td id="effectTd_${count.index}" style="position:relative;">${equipList_E[count.index].effect}
								<div style="position:absolute; top:5px; right: 10px;"><b>${positionWording[count.index].value}</b></div></td>
							<td id="effectTd_${count.index}" style="position:relative;">
								<c:if test="${not empty equipList_S}">
									${equipList_S[count.index].effect}
								</c:if>
								<div style="position:absolute; top:5px; right: 10px;"><b>${positionWording[count.index].value}</b></div></td>
						</tr>
					</table>
				</div>
			</c:if>
			<c:if  test="${count.index >= 6}">
				<div id="equipColumnBox">
					<div class="charaTable">
						<table class="table left-th-right-tr" id="equipTable" >
							<tr><th width="1"><img src="${equip.iconURL}" border="1px" width="64px" height="64px"></th>
								<th>${equip.equipName}<br>${equip.equipName_ch}</th></tr>
							<tr><td id="effectTd_${count.index}" colspan="2" style="position:relative;">${equip.effect}
								<div style="position:absolute; top:5px; right: 10px;"><b>${positionWording[count.index].value}</b></div></td></tr>
						</table>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</c:if>
	<!--<c:if test="${not empty equipList_S}">
		<c:forEach items="${equipList_S}" var="equip" varStatus="count">
			<c:if test="${count.index > 5}">
				<div id="equipBox" style="max-width: 314px; width: 314px; display: inline-block;">
					<table class="table left-th-right-tr" id="equipTable" >
						<tr><th>${equip.equipName}<br>${equip.equipName_ch}</th>
							<th width="1"><img src="${equip.iconURL}" border="1px" width="64px" height="64px"></th></tr>
						<tr><td id="effectTd_${count.index}" colspan="2" style="position:relative;">${equip.effect}
							<div style="position:absolute; top:5px; right: 10px;"><b>${positionWording[count.index].value}</b></div></td></tr>
					</table>
				</div>
			</c:if>
		</c:forEach>
	</c:if>
	-->
</div>

<div id="lvUpAbi">
	<h3>升級能力加成</h3>
	<div class="charaTable">
		<table class="table .top-th-bottom-tr" style="width: 950px;">
			<colgroup>
				<col width="200">
				<col width="200">
				<col width="200">
				<col width="200">
				<col width="200">
			</colgroup>
			<tbody>
				<tr><th></th><th>Lv.2</th><th>Lv.3</th><th>Lv.4</th><th>Lv.5</th></tr>
				<tr><td></td>
					<td>${charaDataDto.lvUpAbi_lv2}</td>
					<td>${charaDataDto.lvUpAbi_lv3}</td>
					<td>${charaDataDto.lvUpAbi_lv4}</td>
					<td>${charaDataDto.lvUpAbi_lv5}</td>
				</tr>
				<tr><th>Lv.6</th><th>Lv.7</th><th>Lv.8</th><th>Lv.9</th><th>Lv.10</th></tr>
				<tr><td>${charaDataDto.lvUpAbi_lv6}</td>
					<td>${charaDataDto.lvUpAbi_lv7}</td>
					<td>${charaDataDto.lvUpAbi_lv8}</td>
					<td>${charaDataDto.lvUpAbi_lv9}</td>
					<td>${charaDataDto.lvUpAbi_lv10}</td>
				</tr>
				<tr><th>Lv.11</th><th>Lv.12</th><th>Lv.13</th><th>Lv.14</th><th>Lv.15</th></tr>
				<tr><td>${charaDataDto.lvUpAbi_lv11}</td>
					<td>${charaDataDto.lvUpAbi_lv12}</td>
					<td>${charaDataDto.lvUpAbi_lv13}</td>
					<td>${charaDataDto.lvUpAbi_lv14}</td>
					<td>${charaDataDto.lvUpAbi_lv15}</td>
				</tr>
				<tr><th>Lv.16</th><th>Lv.17</th><th>Lv.18</th><th>Lv.19</th><th>Lv.20</th></tr>
				<tr><td>${charaDataDto.lvUpAbi_lv16}</td>
					<td>${charaDataDto.lvUpAbi_lv17}</td>
					<td>${charaDataDto.lvUpAbi_lv18}</td>
					<td>${charaDataDto.lvUpAbi_lv19}</td>
					<td>${charaDataDto.lvUpAbi_lv20}</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div id="charaReport">
	<h3>調查報告</h3>
	<div class="languageTabs">
		<ul class="nav nav-tabs navbar-right" style="margin-right: 15px">
			<li class="active"><a data-toggle="tab" href="#c_story_ch">中文</a></li>
			<li><a data-toggle="tab" href="#c_story_kr">韓文</a></li>
		</ul>
	</div>
	<div id="charaReport_content">
	    <div class="tab-content">
	        <div id="c_story_ch" class="tab-pane fade in active">
				<c:if test="${not empty charaReportDto_CH}">
					<h4 style="color: #cf3e2b"><b>觀察</b></h4>
						<c:if test="${not empty charaReportDto_CH.observed}">
							<tr><td>${charaReportDto_CH.observed}</td></tr>
						</c:if>
						<c:if test="${empty charaReportDto_CH.observed}">
							<tr><td>${charaReportDto_KR.observed}<font color="firebrick">(尚未翻譯)</font></td></tr>
						</c:if>
					<br>
					<h4 style="color: #cf3e2b"><b>能力</b></h4>
						<c:if test="${not empty charaReportDto_CH.ability}">
							<tr><td>${charaReportDto_CH.ability}</td></tr>
						</c:if>
						<c:if test="${empty charaReportDto_CH.ability}">
							<tr><td>${charaReportDto_KR.ability}<font color="firebrick">(尚未翻譯)</font></td></tr>
						</c:if>
					<br>
					<h4 style="color: #cf3e2b"><b>相關事件檔案</b></h4>
						<c:if test="${not empty charaReportDto_CH.relatedEvents}">
							<tr><td>${charaReportDto_CH.relatedEvents}</td></tr>
						</c:if>
						<c:if test="${empty charaReportDto_CH.relatedEvents}">
							<tr><td>${charaReportDto_KR.relatedEvents}<font color="firebrick">(尚未翻譯)</font></td></tr>
						</c:if>
					<br>
					<h4 style="color: #cf3e2b"><b>相關檔案</b></h4>
					<c:if test="${charaReportDto_KR.report_tony != ''}">
						<img src="/resources/pic/relateddoc_tony.jpg"><br>
							<c:if test="${not empty charaReportDto_CH.report_tony}">
								<tr><td>${charaReportDto_CH.report_tony}</td></tr>
							</c:if>
							<c:if test="${empty charaReportDto_CH.report_tony}">
								<tr><td>${charaReportDto_KR.report_tony}<font color="firebrick">(尚未翻譯)</font></td></tr>
							</c:if>
						<br>
					</c:if>
					<c:if test="${charaReportDto_KR.report_yogi != ''}">
						<img src="/resources/pic/relateddoc_yogi.jpg"><br>
							<c:if test="${not empty charaReportDto_CH.report_yogi}">
								<tr><td>${charaReportDto_CH.report_yogi}</td></tr>
							</c:if>
							<c:if test="${empty charaReportDto_CH.report_yogi}">
								<tr><td>${charaReportDto_KR.report_yogi}<font color="firebrick">(尚未翻譯)</font></td></tr>
							</c:if>
						<br>
					</c:if>
					<c:if test="${charaReportDto_KR.report_bruno != ''}">
						<img src="/resources/pic/relateddoc_bruno.jpg"><br>
							<c:if test="${not empty charaReportDto_CH.report_bruno}">
								<tr><td>${charaReportDto_CH.report_bruno}</td></tr>
							</c:if>
							<c:if test="${empty charaReportDto_CH.report_bruno}">
								<tr><td>${charaReportDto_KR.report_bruno}<font color="firebrick">(尚未翻譯)</font></td></tr>
							</c:if>
						<br>
					</c:if>
					<c:if test="${charaReportDto_KR.report_tian != ''}">
						<img src="/resources/pic/relateddoc_tian.jpg"><br>
							<c:if test="${not empty charaReportDto_CH.report_tian}">
								<tr><td>${charaReportDto_CH.report_tian}</td></tr>
							</c:if>
							<c:if test="${empty charaReportDto_CH.report_tian}">
								<tr><td>${charaReportDto_KR.report_tian}<font color="firebrick">(尚未翻譯)</font></td></tr>
							</c:if>
						<br>
					</c:if>
					<h4 style="color: #cf3e2b"><b>性格</b></h4>
						<c:if test="${not empty charaReportDto_CH.personality}">
							<tr><td>${charaReportDto_CH.personality}</td></tr>
						</c:if>
						<c:if test="${empty charaReportDto_CH.personality}">
							<tr><td>${charaReportDto_KR.personality}<font color="firebrick">(尚未翻譯)</font></td></tr>
						</c:if>
					<br>
					<h4 style="color: #cf3e2b"><b>關係</b></h4>
						<c:if test="${not empty charaReportDto_CH.relationship}">
							<tr><td>${charaReportDto_CH.relationship}</td></tr>
						</c:if>
						<c:if test="${empty charaReportDto_CH.relationship}">
							<tr><td>${charaReportDto_KR.relationship}<font color="firebrick">(尚未翻譯)</font></td></tr>
						</c:if>
					<br>
					<c:if test="${charaReportDto_KR.remark != '' || charaReportDto_CH.remark != ''}">
						<hr>
							<c:if test="${not empty charaReportDto_CH.remark}">
								<tr><td>${charaReportDto_CH.remark}</td></tr>
							</c:if>
							<c:if test="${empty charaReportDto_CH.remark}">
								<tr><td>${charaReportDto_KR.remark}<font color="firebrick">(尚未翻譯)</font></td></tr>
							</c:if>
						<br>
					</c:if>
				</c:if>
			</div>
			<div id="c_story_kr" class="tab-pane fade">
				<c:if test="${not empty charaReportDto_KR}">
					<h4 style="color: #cf3e2b"><b>觀察</b></h4>
					${charaReportDto_KR.observed}
					<br>
					<h4 style="color: #cf3e2b"><b>能力</b></h4>
					${charaReportDto_KR.ability}
					<br>
					<h4 style="color: #cf3e2b"><b>相關事件檔案</b></h4>
					${charaReportDto_KR.relatedEvents}
					<br>
					<h4 style="color: #cf3e2b"><b>相關檔案</b></h4>
					<c:if test="${charaReportDto_KR.report_tony != ''}">
						<img src="/resources/pic/relateddoc_tony.jpg"><br>
						${charaReportDto_KR.report_tony}
						<br>
					</c:if>
					<c:if test="${charaReportDto_KR.report_yogi != ''}">
						<img src="/resources/pic/relateddoc_yogi.jpg"><br>
						${charaReportDto_KR.report_yogi}
						<br>
					</c:if>
					<c:if test="${charaReportDto_KR.report_bruno != ''}">
						<img src="/resources/pic/relateddoc_bruno.jpg"><br>
						${charaReportDto_KR.report_bruno}
						<br>
					</c:if>
					<c:if test="${charaReportDto_KR.report_tian != ''}">
						<img src="/resources/pic/relateddoc_tian.jpg"><br>
						${charaReportDto_KR.report_tian}
						<br>
					</c:if>
					<h4 style="color: #cf3e2b"><b>性格</b></h4>
					${charaReportDto_KR.personality}
					<br>
					<h4 style="color: #cf3e2b"><b>關係</b></h4>
					${charaReportDto_KR.relationship}
					<br>
					<c:if test="${charaReportDto_KR.remark != ''}">
						<hr>
						<tr><td>${charaReportDto_KR.remark}</td></tr>
						<br>
					</c:if>
				</c:if>
			</div>
		</div>
	</div>
</div>
<div id="information">
	<h3>裝備故事情報</h3>
	<div class="languageTabs">
		<ul class="nav nav-tabs navbar-right">
			<li class="active"><a data-toggle="tab" href="#e_info_ch">中文</a></li>
			<li><a data-toggle="tab" href="#e_info_kr">韓文</a></li>
		</ul>
	</div>
	<div class="tab-content">
	    <div id="e_info_ch" class="tab-pane fade in active">
	    	<div class="charaTable">
				<table class="table left-th-right-tr" style="width: 950px;">
					<c:forEach items="${equipInfoList}" var="equip" varStatus="count">
						<c:if test="${not empty equip.information_ch}">
							<tr><td>${equip.information_ch}</td></tr>
						</c:if>
						<c:if test="${empty equip.information_ch}">
							<tr><td>${equip.information}<font color="firebrick">(尚未翻譯)</font></td></tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
		</div>
	    <div id="e_info_kr" class="tab-pane fade">
	    	<div class="charaTable">
				<table class="table left-th-right-tr" style="width: 950px;">
					<c:forEach items="${equipInfoList}" var="equip" varStatus="count">
						<tr><td>${equip.information}</td></tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
<div id="others">
	<h3>補充資料</h3>
	<div id="others_content">${charaOthersDto.content}</div>
</div>

<script type="text/javascript">
onload();

function onload(){
	// 設定主題曲播放器URL與播放音量
	var themeURL = document.getElementById("themeURL").value;
	$("#themePlayer source").attr("src", themeURL);
	$("#themePlayer").prop("volume", 0.6);
	
	// 當能力評價table發生換行時，減少空裝數值區塊寬度，增加能力評價區塊寬度
	var eva_height = $('#table_evaluation').height();//能力評價TABLE高度
	if(eva_height > 80){
		$('#basic').width(390);
		$('#table_basic').width(390);
		$('#table_basic').attr("style", "max-width: 390px;");
		$('#evaluation').width(550);
		$('#table_evaluation').attr("style", "max-width: 550px;");
	}
		
	// 對齊裝備框高度
	//for(i=0;i<3;i++){
		var index = 6;//0,3,6
		var temp1 = $('#effectTd_'+(index++)).height();//0,3,6
		var temp2 = $('#effectTd_'+(index++)).height();//1,4,7
		var temp3 = $('#effectTd_'+(index++)).height();//2,5,8

		var maxHeight = Math.max(temp1, temp2, temp3);
		
		var index = 6;//0,3,6
		$('#effectTd_'+(index++)).height(maxHeight);//0,3,6
		$('#effectTd_'+(index++)).height(maxHeight);//1,4,7
		$('#effectTd_'+(index++)).height(maxHeight);//2,5,8
	//}
}
</script>