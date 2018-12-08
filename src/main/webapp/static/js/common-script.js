$(document).ready(function(){
	//dynamic footer place//
	var headerH = $(".login-wrap").height();
	var footerH = $("footer").height();
	var windowH = $(window).height();
	var contentH = windowH - footerH;
	$(".login-wrap").css("min-height",contentH);
});