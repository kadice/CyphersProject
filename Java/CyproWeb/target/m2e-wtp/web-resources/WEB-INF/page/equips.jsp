<%@ page contentType = "text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- 戰鬥裝備頁面專用CSS/JS -->
<script	src="/resources/javascript/bootstrap-ext-equips.js"></script>
<link rel="stylesheet" href="/resources/styles/bootstrap-ext-equips.css">

<style>
body {
	background-image: url(/resources/pic/bg-main.jpg);
	background-attachment: fixed; /*固定背景*/
}
div.detailBox{
	position: absolute;
	background-color: white;
	width: 280px;
	align: center; 
}
table#equipDetailTable{width: 100%; border: 1px solid gray;}
table#equipDetailTable th{
	text-align: center;
	line-height: 1.2;
    padding: 3px 10px;
}
table#equipDetailTable td{
	line-height: 1.2;
    padding: 3px 10px;
}
</style>
	<div class="equipQueryDiv">
		<form:form id="queryForm" action="queryEquip" method="post" modelAttribute="equipParamSourceForm">
			<form:hidden path="searchType"/>
			<input type="submit" value="submit" style="display: none;"/>
			<ul class="nav navbar-inverse nav-tabs">
		        <li><a class="tabBtn" data-toggle="tab" href="#sel_chara">角色 <span class="caret"></span></a></li>
		        <li><a class="tabBtn" data-toggle="tab" href="#sel_quality">品質 <span class="caret"></span></a></li>
		        <li><a class="tabBtn" data-toggle="tab" href="#sel_position">部位 <span class="caret"></span></a></li>
	            <li style="float: right;"><a class="tabBtn" id="queryBtn" href="#" onclick="closeCondiBox(); checkAndSubmit();">搜尋</a></li>
		    </ul>
		    <div class="tab-content">
		        <div id="sel_chara" class="tab-pane fade condiBox">
	        		<form:hidden path="charaId"/>
	        		<c:forEach items="${equipParamSourceForm.charaList}" var="chara" varStatus="v">
						<div style="display: inline-block; margin-right: -3px; background-color: #333; min-width:48px; max-width: 48px; ">
							<a target="${chara.charaId}"><img alt="${chara.name}" src="${chara.iconURL}" width="48px" height="48px" style="border: 1px solid #333;"/><br>
							<label style="margin-bottom: 0px; color: #ecf0f1; font-weight: normal;">${chara.name}</label></a>
						</div>
					</c:forEach>
		        </div>
		        <div id="sel_quality" class="tab-pane fade condiBox">
		        	<span class="selAllItem"><input type="checkbox" onchange="selectAll(this,'quality');"><label>全選</label></span>
		            <form:checkboxes id="quality" items="${equipParamSourceForm.qualityItemMap}" path="quality" name="quality"/>
		        </div>
		        <div id="sel_position" class="tab-pane fade condiBox">
		        	<span class="selAllItem"><input type="checkbox" onchange="selectAll(this,'position');"><label>全選</label></span>
		            <form:checkboxes items="${equipParamSourceForm.positionItemMap}" path="position" name="position"/>
		        </div>
		    </div>
		</form:form>
		<label style="color: firebrick;" id="errorMsg"> </label>
	</div>
	<table id="equipTable" data-toggle="table" data-pagination="true" data-search="true" style="width: 100%">
		<!-- 分頁/可搜尋 -->
		<colgroup>
			<col width="64px">
			<col width="156px">
			<col width="75px">
			<col width="75px">
			<col width="75px">
			<col width="75px">
			<col width="230px">
			<col width="150px">
		</colgroup>
		<thead><tr>
			<th>圖示</th>
			<th>裝備名稱</th>
			<th>角色</th>
			<th data-sortable="true">品質</th>
			<th data-sortable="true">部位</th>
			<th data-sortable="true">階數</th>
			<th>效果</th>
			<th data-sortable="true">SEASON</th>
		</tr></thead>
		<tbody>
			<c:forEach items="${equipListForm.equipDtoList}" var="equipDto" varStatus="varSta">
				<tr>
					<td class="eq-table-img"><img src="${equipDto.iconURL}"></td>
					<td class="eq-table-name" id="td_${equipDto.equipId}">
						<label id="equipName_${equipDto.equipId}">${equipDto.equipName}</label>
						<c:if test="${not empty equipDto.equipName_ch}">
							<br><label id="equipName_ch_${equipDto.equipId}">${equipDto.equipName_ch}</label>
						</c:if></td>
					<td><label id="charaName_${equipDto.equipId}">${equipDto.charaName}</label></td>
					<td><label id="qualityStr_${equipDto.equipId}">${equipDto.qualityStr}</label></td>
					<td><label id="position_${equipDto.equipId}">${equipDto.position}</label></td>
					<td><label id="segment_${equipDto.equipId}">${equipDto.segment}</label></td>
					<td><label id="effect_${equipDto.equipId}">${equipDto.effect}</label></td>
					<td><label id="season_${equipDto.equipId}">${equipDto.season}</label>
						<input type="hidden" id="equipId_${equipDto.equipId}" value="${equipDto.equipId}">
						<input type="hidden" id="cost_${equipDto.equipId}" value="${equipDto.cost}">
						<input type="hidden" id="information_${equipDto.equipId}" value="${equipDto.information}">
						<input type="hidden" id="information_ch_${equipDto.equipId}" value="${equipDto.information_ch}">
						<input type="hidden" id="iconURL_${equipDto.equipId}" value="${equipDto.iconURL}">
						<input type="hidden" id="picURL_${equipDto.equipId}" value="${equipDto.picURL}">
					</td></tr>
			</c:forEach>
		</tbody>
	</table>
<br><br><br><br><br>

<div id="detailBox" class="detailBox" hidden="false">
	<table id="equipDetailTable">
		<tbody>
			<tr><th colspan="2" id="det_equipNameTh"></th></tr>
			<tr><td colspan="2" align="center">
					<img id="det_iconOrPicURL" src=""></td></tr>
			<tr><td align="left"> <label id="det_position"></label></td>
				<td align="right"><label id="det_qualityStr"></label></td></tr>
			<tr><td align="left"> <label id="det_charaName"></label></td>
				<td align="right"><label id="det_cost"></label><label>金幣</label></td></tr>
			<tr><td colspan="2" align="left"><label id="det_season"></label></td></tr>
			<tr><td colspan="2" align="left"><label id="det_effect"></label></td></tr>
			<tr><td colspan="2" align="left"><label id="det_information"></label></td></tr>
		</tbody>
	</table> 
</div>

<script type="text/javascript">
	$(document).ready(function() {
		setMouseEvent();
		
		setDefaultCbx();
	});
	function setMouseEvent() {//在bootstrap-table中也有呼叫
		$("td.eq-table-name").mouseenter(function(event) {
			var index = $(this).attr("id");
			if (index != null) {
				index = index.replace("td_", "");
				showEquipDetail(event, index);
			}
		}).mouseleave(function() {
			closeEquipDetail();
		});
	}
	
	function setDefaultCbx(){
		
	}

	function showEquipDetail(e, index) {
		var IE = document.all ? true : false; // Detect if the browser is IE or not.
		if (!IE)
			document.captureEvents(Event.MOUSEMOVE) //If not IE -- set up for mouse capture
		var tempX = 0
		var tempY = 0
		if (IE) {
			tempX = event.clientX + document.body.scrollLeft
			tempY = event.clientY + document.body.scrollTop
		} else {
			tempX = e.pageX
			tempY = e.pageY
		}
		// catch possible negative values in NS4
		if (tempX < 0) {
			tempX = 0
		}
		if (tempY < 0) {
			tempY = 0
		}

		setEquipDetail(index);
		document.getElementById("detailBox").style.left = (tempX + 10) + "px";
		document.getElementById("detailBox").style.top = (tempY - 120) + "px";
		document.getElementById("detailBox").hidden = false;
	}
	function setEquipDetail(index) {
		var equipName = document.getElementById("equipName_" + index).innerHTML;
		var equipName_ch = "";
		if (document.getElementById("equipName_ch_" + index) != null) {
			equipName_ch = document.getElementById("equipName_ch_" + index).innerHTML;
		}
		var equipNameTh = "<label>" + equipName + "</label>";
		if (equipName_ch != "" && equipName_ch != null) {
			equipNameTh += "<br><label>" + equipName_ch + "</label>";
		}
		document.getElementById("det_equipNameTh").innerHTML = equipNameTh;
		var iconURL = document.getElementById("iconURL_" + index).value;
		var picURL = document.getElementById("picURL_" + index).value;
		if (picURL != null && picURL != "") {
			document.getElementById("det_iconOrPicURL").src = picURL;
		} else {
			document.getElementById("det_iconOrPicURL").src = iconURL;
		}
		document.getElementById("det_position").innerHTML = document
				.getElementById("position_" + index).innerHTML;
		document.getElementById("det_qualityStr").innerHTML = document
				.getElementById("qualityStr_" + index).innerHTML;
		document.getElementById("det_charaName").innerHTML = document
				.getElementById("charaName_" + index).innerHTML;
		document.getElementById("det_cost").innerHTML = document
				.getElementById("cost_" + index).value;
		document.getElementById("det_season").innerHTML = document
				.getElementById("season_" + index).innerHTML;
		document.getElementById("det_effect").innerHTML = document
				.getElementById("effect_" + index).innerHTML;
		var information = document.getElementById("information_" + index).value;
		var information_ch = document.getElementById("information_ch_" + index).value;
		if (information_ch != null && information_ch != "") {
			document.getElementById("det_information").innerHTML = information_ch;
		} else {
			document.getElementById("det_information").innerHTML = information;
		}
	}
	function closeEquipDetail() {
		document.getElementById("detailBox").hidden = true;
	}
</script>