<%@ page contentType="text/html;charset=UTF-8"%>
<style type="text/css">
body {
	background-image: url("/resources/pic/bg-dark.jpg");
	background-size: cover;
}

.content {
	background-image: url("/resources/pic/bg-001.jpg");
	background-repeat:repeat-y;
}
</style>

<div id="selector"></div>
<div id="pageContent"></div>

<input type="button" id="contentSetBtn" value="Loras"
	onclick="setContent(this); return false;" style="display: none;">

<script type="text/javascript">
	$(document).ready(function() {
		$.get("charaSelBox", function(data) { //初始將charaSelBox設定為selector的內容
			$("#selector").html(data);
		});
		$("#contentSetBtn").click();//初始化；或儲存角色後，回到前一個編輯的角色畫面
	});
	function setContent(sourse) { //設定content的內容
		var charaId = sourse.value;
		//組裝url
		var url = "charaPage/" + charaId;
		$.get(url, function(data) {
			$("#pageContent").html(data);
		});
	}
</script>