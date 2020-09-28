<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="charaBox" style="width: 950px;">
	<div style="margin: 0px auto; width: 920px; font-size: 12px;">
		<c:forEach items="${charaList}" var="chara" varStatus="v">
			<div
				style="display: inline-block; margin-right: -3px; background-color: #333; min-width: 48px; max-width: 48px;">
				<a href="${chara.charaId}" onclick="return false;"><img
					alt="${chara.name}" src="${chara.iconURL}"
					id="img_${chara.charaId}" width="48px" height="48px"
					style="border: 1px solid #333;" /><br> <label
					style="margin-bottom: 0px; color: #ecf0f1; font-weight: normal;">${chara.name}</label></a>
			</div>
		</c:forEach>
		<c:if test="${v.index % 13 == 0}">
			<br>
		</c:if>
	</div>
</div>
<hr>
<script type="text/javascript">
	$(document).ready(function() {
		$(function() {
			$('.charaBox a').click(function() {
				var target = $(this).attr('href'); // 找到連結a中的href(或target)標籤值
				$("#contentSetBtn").attr('value', target);
				$("#contentSetBtn").click();

				$('.charaBox img').css("border", "1px solid #333");
				$(this).find("img").css("border", "1px solid red");
			})
		})

		//初始化；或儲存角色後，將前一個編輯的角色標示紅框
		setRedBorderAfterPageLoaded();
	});
	function setRedBorderAfterPageLoaded() { //初始化；或儲存角色後，將前一個編輯的角色標示紅框
		var charaId = $("#contentSetBtn").attr('value');
		$("img#img_" + charaId).css("border", "1px solid red");
	}
</script>