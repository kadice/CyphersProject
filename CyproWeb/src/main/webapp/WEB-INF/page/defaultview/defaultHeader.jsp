<%@ page contentType="text/html;charset=UTF-8"%>
<style type="text/css">
/* CSS used here will be applied after bootstrap.css */
.navbar {
	margin-bottom: 0px;
	border-radius: 0px 0px 4px 4px;
}
li.dropdown:hover>.dropdown-menu {
	/*menu展開方式：水平*/
	/*display: flex;*/
	
	/*menu展開方式：垂直*/
	display: block;
	min-width: unset;
	right:auto;
}
</style>
<div class="navbar navbar-inverse">
	<div class="navbar-header">
		<a class="navbar-brand" href="/">CyphersProject</a>
	</div>
	<ul class="nav navbar-nav navbar-right" data-hover="tab">
		<li class="dropdown"><a class="dropdown-toggle">市立圖書館</a>
			<ul class="dropdown-menu">
				<li><a href="/story">背景故事</a></li>
				<li><a href="#chronology">事件年表</a></li>
				<li><a href="#dictionary">名詞辭典</a></li>
				<li><a href="#">官網系統</a></li>
				<li><a href="#">遊戲內系統</a></li>
				<li><a href="#">對戰地圖</a></li>
			</ul></li>
		<li class="dropdown"><a class="dropdown-toggle">廣場上的人們</a>
			<ul class="dropdown-menu">
				<li><a href="/characters">能力者檔案</a></li>
				<li><a href="/skills">技能情報</a></li>
			</ul></li>
		<li class="dropdown"><a class="dropdown-toggle">船塢卸貨區</a>
			<ul class="dropdown-menu">
				<li><a href="/equips">戰鬥裝備</a></li>
				<li><a href="#">消耗性道具</a></li>
				<li><a href="#">時裝飾品</a></li>
			</ul></li>
		<li><a href="#">工程部</a></li>
		<li><a href="login">登入</a></li>
	</ul>
</div>
<script type="text/javascript">
	$(document).ready(

	);
</script>