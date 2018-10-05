<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /> | CyphersProject</title>

<tilesx:useAttribute id="scriptsList" name="scriptsList"
	classname="java.util.List" />
<c:forEach var="scriptUrl" items="${scriptsList}">
	<script type="text/javascript" src="${scriptUrl}"></script>
</c:forEach>

<tilesx:useAttribute id="stylesList" name="stylesList"
	classname="java.util.List" />
<c:forEach var="styleUrl" items="${stylesList}">
	<link rel="stylesheet" href="${styleUrl}">
</c:forEach>

</head>
<body>
	<div id="header" class="header">
		<div class="headerContent">
			<tiles:insertAttribute name="header" />
		</div>
	</div>
	<div id="content" class="content">
		<tiles:insertAttribute name="content" />
	</div>
	<div id="footer" class="footer">
		<div id="footerContent" class="footerContent">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		//設定content位置
		SetContentMarginTop();
		//將content的高度填滿畫面
		SetContentMinHeight();
	});
</script>
</html>