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

/*轮播*/
function banner($bannerPic,Icon){
	var num=0;
	var timer=null;
	$("ul",$bannerPic).append($("ul li",$bannerPic).clone());
	var liNum=$("ul li",$bannerPic).length/2;
	var liW=$("ul li:eq(0)",$bannerPic).width();//一个图片的宽度
	$("ol li",$bannerPic).click(function(){
		$(this).addClass(Icon).siblings().removeClass(Icon);
		var index=$(this).index();
		$(this).parent().siblings("ul").find("li").eq(index).show().fadeTo(500,1.0).siblings().fadeTo(500,0).hide();		
		num=index;	
	})
	function palyBanner(){
		if(num>=liNum){
			$("ul li",$bannerPic).eq(num).show().fadeTo(500,1.0).siblings().fadeTo(500,0).hide();
			$("ol li",$bannerPic).eq(0).addClass(Icon).siblings().removeClass(Icon);	
			num=1;
		}else{
			$("ol li",$bannerPic).eq(num).addClass(Icon).siblings().removeClass(Icon);	
			$("ul li",$bannerPic).eq(num).show().fadeTo(500,1.0).siblings().fadeTo(500,0).hide();
			num++;	
		}
	}
	var timer=setInterval(palyBanner,3000);
	$bannerPic.hover(
		function(){
			clearInterval(timer);
		},
		function(){
			timer=setInterval(palyBanner,3000);
		}
	)			
}

$(function(){
banner(
			$bannerPic=$(".t1124-ind-banner-con .advertising-common-slide"),
			Icon="on"
	)	
})