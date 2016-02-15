// JavaScript Document
  /*在线客服*/
$(function(){
	   $(".common-service-box-left").hover(function(){
		  $(".common-service-box").css("display","block");
		  $(".common-service").css("width","200px");
	   });
	$(".common-service").hover(function(){
		  $(".common-service-box").css("display","block");
	   },function(){
		   $(".common-service-box").css("display","none");
		  $(".common-service").css("width","33px");
	});	 
})

$(function(){
	$(".bookingTit span").click(function(){
		$(".advertising-common-single-img").toggle();
		})
	
	})
