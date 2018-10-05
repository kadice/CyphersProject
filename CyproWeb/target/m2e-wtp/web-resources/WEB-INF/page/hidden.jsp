<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Cyphers Project</title>
<style>
</style>
</head>
<body>
	<h1>Cyphers Project</h1>
	<hr>
	<br>
	你好，${questName}，<br>
	<br>
	歡迎來到陽春版<font style="text-decoration:line-through">隱藏版</font>Cyphers Project。<br>
	這裡的畫面很簡陋，但其實隱藏了所有開發中的功能和頁面<br>
	<br>
	你可以在這裡查詢一些和能力者們有關的資料。<br>
	或著協助我們完善檔案庫。<br>
	<br>
	請各位不要蓄意破壞資料，萬分感謝。<br>
	<br>
	
	<table border="1" style="width: 60%">
	<tbody>
		<colgroup>
			<col width="20%">
			<col width="40%">
			<col width="40%">
		</colgroup>
		<tr><td></td><td>WIX頁面</td><td>後台功能</td></tr>
		
		<tr><td>CHARACTER</td>
			<td><a href="characters">能力者檔案頁面</a></td>
			<td><a href="editChara">能力者編輯頁面</a></td></tr>
		
		<tr><td>SKILL</td>
			<td><a href="skills">技能呈現頁面(彈出影片版)</a>
				<a href="skills2">技能呈現頁面(嵌入影片版)</a></td>
			<td><a href="editSkill">編輯技能頁面</a></td></tr>
		
		<tr><td>EQUIP</td>
			<td><a href="equips">裝備資料呈現頁面</a></td>
			<td><a href="batchEditEquip">批次查詢/編輯裝備資料</a></td></tr>
		
		<tr><td>STORY</td>
			<td>請選擇篇章<select id="targetChapter" onchange="setWixStoryPath();">
				<c:forEach items="${chapterList}" var="chap">
					<option value="${chap}">${chap}</option>
				</c:forEach>
				</select><br>
				章節數字(例:0~10)<input type="text" id="targetSection" onchange="setWixStoryPath();" value="0">
				<input type="button" id="toWixStoryBtn" value="產生WIX故事呈現頁面" onclick=""/>
				<a id="toWixStoryPage" href="http://cyphersproject.wixsite.com/zh-tw/story" target="_blank"> >> WIX-story</a><br/>
			</td>
			<td><a href="editStory">背景故事編輯頁面</a><br/></td></tr>
		
		<tr><td>建立新能力者</td><td><a href="newChara">建立新能力者頁面</a></td><td></td></tr>
		<tr><td></td><td></td><td></td></tr>
		<tr><td>爬蟲</td><td><a href="crawler" target="_blank">爬蟲功能頁</a></td><td></td></tr>
		<tr><td>OTHERS</td><td><a href="logView" target="_blank">看LOG</a></td><td></td></tr>
	</table>
	
	<br/>
	語音台詞 要個別一個功能頁??還是和角色資料一起?<br/>
	<br/>
	<hr>
	發佈版本 <a href="https://cyphersproject.appspot.com/">https://cyphersproject.appspot.com/</a><br/>
	開發用 <a href="https://cyphersprojecttestfield.appspot.com/">https://cyphersprojecttestfield.appspot.com/</a><br/>
	<hr>
	<object style="border:0px" type="text/x-scriptlet" data="/process" width=100% height="300"></object>
</body>
<script type="text/javascript">
setWixStoryPath();
	function toPage(pagename) {
		document.mainForm.action = pagename;
		document.mainForm.submit();
	}
	function setWixStoryPath(){
		var tempPath = "story/" + document.getElementById("targetChapter").value 
					+ "/" + document.getElementById("targetSection").value;
		document.getElementById("toWixStoryBtn").onclick = function() { window.open(tempPath); };
		if(document.getElementById("targetSection").value != ""){
			document.getElementById("toWixStoryBtn").disabled = "";
		}else{
			document.getElementById("toWixStoryBtn").disabled = "disabled";
		}
	}
</script>
</html>