// 點選條件TAB時可以把條件BOX關起來
$(function() {
	var active = $('a[data-toggle="tab"]').parents('.active').length;
	var tabClicked = false;
	// Closing active tab on clicking on toggle:
	$('[data-toggle=tab]').click(function(){
		if ($(this).parent().hasClass('active')){
			$($(this).attr("href")).toggleClass('active');
			active = false;
		} else {
			tabClicked = true;
			active = this;
		}
	});
});
//按下查詢時，關閉條件box
function closeCondiBox(){
	$('a[data-toggle="tab"]').parents('.active').removeClass('active');
	$('div.tab-pane').removeClass('active');
}
//點選角色時設定紅框
$(function(){
	$('#sel_chara a').click(function() {
 		var target = $(this).attr('target'); // 找到連結a中的href(或target)標籤值
		$("#charaId").attr('value', target);

		$('#sel_chara a img').css("border", "1px solid #333");
		$(this).find("img").css("border", "1px solid red");
	})
})
//設定產生的checkbox套用的class
$(function(){
	$('div#sel_quality span').addClass('condiItem');
	$('div#sel_position span').addClass('condiItem');
});
//送出查詢時，設定查詢方式 (type: byChara=條件查詢 ByKey=關鍵字查詢)
function setType(type){
	document.getElementById("searchType").value = type;
}
//送出條件查詢時，檢查格式
function checkAndSubmit(){
	var result = true;
	document.getElementById("errorMsg").innerHTML = " ";
	var targetChara = document.getElementById("charaId").value;
	var qualities = document.getElementsByName("quality");
	var positions = document.getElementsByName("position");
	var atLeastOneChecked = false;
	
	if(targetChara == null || targetChara == ""){
		document.getElementById("errorMsg").innerHTML += "請選擇角色。　";
		result = false;
	}
	
	for(i=0,n=qualities.length; i<n; i++){
		if(qualities[i].checked){
			atLeastOneChecked = true;
			break;
		}
	}
	if(!atLeastOneChecked){
		document.getElementById("errorMsg").innerHTML += "請選擇至少一種裝備品質。　";
		result = false;
	}
	
	var atLeastOneChecked = false;
	for(i=0,n=positions.length; i<n; i++){
		if(positions[i].checked){
			atLeastOneChecked = true;
			break;
		}
	}
	if(!atLeastOneChecked){
		document.getElementById("errorMsg").innerHTML += "請選擇至少一種裝備部位。　";
		result = false;
	}
	
	if(result){
		document.getElementById('queryForm').submit();
	}
}
//送出以關鍵字查詢時，檢查格式&再確認
function checkBlank(){
	if(document.getElementById("equipKey").value == "" || document.getElementById("equipKey").value == " "){
		document.getElementById("errorMsg").innerHTML = "請輸入關鍵字. ";
		return false;
	} else{
		document.getElementById("errorMsg").innerHTML = "以關鍵字查詢可能會花費較多時間，請耐心等候... ";
		return true;
	}
}
//全選特定條件 (source:點選的全選選項物件; cbxName:要操作的條件選項name)
function selectAll(source, cbxName){
	var checkboxes = document.getElementsByName(cbxName);
	for(i=0,n=checkboxes.length; i<n; i++){
		checkboxes[i].checked = source.checked;
	}
}
