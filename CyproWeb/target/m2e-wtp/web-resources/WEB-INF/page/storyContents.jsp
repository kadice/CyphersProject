<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
body {
	background-image: url(/resources/pic/399318.jpg);
	background-attachment: fixed; /*固定背景*/
	background-size: cover;
}

.content {
	background-color: rgba(1, 1, 1, 0.5);
}

.sectionDiv {
	width: 750px;
	color: #ecf0f1;
	text-align: justify;
	padding: 40px 40px;
}

#contentsDiv {
	position: fixed;
	right: 30px;
	max-width: 260px;
	color: #ecf0f1;
}

#contentsDiv>ul {
	margin-bottom: 0px;
}

#contentsDiv a {
	color: #ecf0f1;
}

li{
    list-style-type: square;
    
}
</style>
<div id="contentsDiv">
	<ul><li><a href="/story">回上層</a></li></ul>
	<br>
	<c:forEach items="${storyDtoList}" var="storyDto" varStatus="varSta">
		<ul>
			<li><a href="#section_${storyDto.section}">${storyDto.title}</a></li>
		</ul>
	</c:forEach>
</div>
<div id="mainDiv">
	<c:forEach items="${storyDtoList}" var="storyDto" varStatus="varSta">
		<div class="sectionDiv" id="section_${storyDto.section}">
			<div class="languageTabs">
				<ul class="nav nav-tabs navbar-right">
					<li class="active"><a data-toggle="tab" href="#section_ch_${storyDto.section}">中文</a></li>
					<li><a data-toggle="tab" href="#section_kr_${storyDto.section}">韓文</a></li>
				</ul>
			</div>
			<div class="tab-content">
				<div id="section_ch_${storyDto.section}" class="tab-pane fade in active">
					<div id="storyContent_ch_${storyDto.section}">${storyDto.storyContent_ch}</div>
				</div>
				<div id="section_kr_${storyDto.section}" class="tab-pane fade">
					<div>${storyDto.storyContent_kr}</div>
				</div>
			</div>
		</div>
		<hr>
	</c:forEach>
</div>
<script type="text/javascript">
	init();
	setContentsDivPosition();
	$( window ).resize(function() {
		setContentsDivPosition();
		});
	
	/*如果沒有中文翻譯，則顯示韓文原文*/
	function init() {
		<c:forEach items="${storyDtoList}" var="storyDto">
		if (document.getElementById("storyContent_ch_"+${storyDto.section}).innerHTML == "") {
			document.getElementById("section_ch_"+${storyDto.section}).className = "tab-pane fade";
			document.getElementById("section_kr_"+${storyDto.section}).className = "tab-pane fade in active";
		}
		</c:forEach>
	}

	function setContentsDivPosition() {
		var right = (($(window).width() - $("#mainDiv").width()) / 2) - 10;
		$('#contentsDiv').css({
			'right' : right + 'px',
		});
	}
</script>