//將content的高度填滿畫面
function SetContentMinHeight() {
    var $window = $(window).on('resize', function () {
        var height = $(this).height() - $('.header').height() - $('.footer').height();
        $('.content').css('min-height', height);
    }).trigger('resize'); //on page load
}
//設定content位置
function SetContentMarginTop(){
	var headerHeight = $('.header').height();
    $('.content').css('margin-top', headerHeight);
}