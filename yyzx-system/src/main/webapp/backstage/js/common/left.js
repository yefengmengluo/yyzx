// JavaScript Document
function showMenu(uClass){
	$(uClass).click(function(){
		$(this).parent().addClass("current").siblings().removeClass("current").children("ul").slideUp(600);
		$(this).next("ul").slideDown(600).children("li").removeClass("current");
	});
}
function showMenu1(uClass){
	$(uClass).click(function(){
		$(this).parent().addClass("current").siblings().removeClass("current").children("dd").slideUp(600);
		$(this).next("dd").slideDown(600).children("li").removeClass("current");
	});
}

$(function(){
	 /*左侧导航添加选中状态*/
	 showMenu(".advertising-vote-list h2");
	 showMenu1(".three-title dt");
	 /*点击切换iframe地址*/
	 $(".advertising-vote-list a").click(function() {
			var $this = $(this);
			var $currentMenu =$this.attr("urlData");
			$("#t1000-votB-R-box").attr("src",$currentMenu);
	  });
	 
	 /*左侧列表li选中状态*/
	$(".t1000-votB-list ul li").click(function(){
		$(this).addClass("current").siblings().removeClass("current");
	});
			
	/*计算左侧高度*/
	//var win_c_H=$(window).height()-60-30-2;
	var win_c_H=$(window).height()-70;
	var left_H;
	win_c_H >=340 ? left_H=win_c_H : left_H=340;
	$(".t1000-votB-L").height(left_H);
	$("#t1000-votB-R-box").height(left_H);
		
});
$(window).resize(function(){
	var win_c_H=$(window).height()-70;
	var left_H;
	win_c_H >=340 ? left_H=win_c_H : left_H=340;
	$(".t1000-votB-L").height(left_H);
	$("#t1000-votB-R-box").height(left_H);
});
1

/*二级标题*/
/*$(function(){
	var num = 5;
	var numDt = $(".advertising-vote-list ul dl dt").length;
	for(num; num < numDt+5; num++){
		$(".advertising-vote-list ul dl dt").eq(num-5).css({"background-image":"url(../../images/league/icon"+num+".jpg)"});
	}	
});*/
$(function(){
	$(".advertising-vote-list dl").click(function(){
		$(".advertising-vote-list dl").removeClass("current");
		$(this).addClass("current");	
	});	
	$(".three-title dd a").click(function(){
		$(".three-title dd a").removeClass("yellow");
		$(this).addClass("yellow");	
	});
});
/*三级标题*/
/*$(function(){
	var num = 1;
	var numDd = $(".advertising-vote-list ul dl dd a").length;
	for(num; num <= numDd; num++){
		$(".advertising-vote-list ul dl dd a").eq(num-1).css({"background-image":"url(../../images/league/icon11"+num+".jpg)"});
	}	
});*/


$(function(){
	var eleWidth=$(document).width();
	var eleHeight=$(document).height();
	var winHeight=$(window).height();
	var btn_index=0;
	var boxWW=$(".bookingBox2").width();
	var boxHH=$(".bookingBox2").height();
	var boxLL=(eleWidth-boxWW)/2;
	var boxTT=(winHeight-boxHH)/2;
	
	$(".bookingBlackBg").css("height",eleHeight);
	$(".bookingBox2").css("left",parseInt(boxLL));

	$("a[name='setData']").click(function(){
		$("#newpassword").val("");
		$("#compassword").val("");
		var boxScroll=$(document).scrollTop();
		$(".bookingBlackBg,.bookingBox2").show();	
		$(".bookingBox2").css("top",parseInt(boxTT+boxScroll-50));
		btn_index=$(this).parent().parent().index();

	});
	$(".bookingTit span").click(function(){
		$(".bookingBlackBg,.bookingBox2").hide();	
	});
	$(window).scroll(function(){
		var boxScroll=$(document).scrollTop();
		$(".bookingBox2").css("top",parseInt(boxTT+boxScroll));	
	});
	
	$(".t1000-edit-vote,.t1000-edit-close").click(function(){
		$(".bookingBox2").hide();
		$(".bookingBlackBg").hide();
	});
	/*限制只能输入数字
	$(".new_vote").keyup(function(){
	 $(this).val($(this).val().replace(/\D|^0/g,'')); }).bind("paste",function(){
	  $(this).val($(this).val().replace(/\D|^0/g,'')); }).css("ime-mode", "disabled"); 
	*/
});


$(function(){
		$("#newpassword").blur(function(){
		if($("#newpassword").val().length<6){
			alert("密码长度必须大于6位！");
			// $("#newpassword").focus();
		}
	});
	$("#compassword").blur(function(){
		if(!($("#newpassword").val()==$("#compassword").val())){
			alert("两次密码不一致。请重新输入！");
			$("#compassword").val("");
			// $("#compassword").focus();
		}
	});
});
	function updatePassword(casRemoteLoginUrl){
		if($("#newpassword").val()==""||$("#compassword").val()==""){
			alert("请填写新密码信息！");
		}else{
			$.post(casRemoteLoginUrl,
					{"newpaw":$("#newpassword").val(),"userId":$("#userId").val()},
					function(str){
						if(str=="1"){
							alert("恭喜您，密码修改成功！");
						}else{
							alert("系统繁忙，请稍后再试！");
						}
					}
			);
		}
	}
	//页面展示-权限限制
	$(function(){
		
		 if(uPower==0){//超级管理员所有权限
			$("#company_list_a").click();
		 }else{//普通管理员所有权限，无设置广告联盟行业、尺寸添加的权限
			 $("#league_sys_param").css("display","none");//不显示广告联盟参数设置 
		 }
		 
		 if(uPower==21){//拥有投票权限
			 $("#t1000-tit-2").css("display","none");//广告联盟不显示
			 $("#t1000-tit-3").css("display","none");//留言不显示
			 $("#t1000-tit-4").css("display","none");//管理员页面显示
			 $("#company_list_a").click();

		 }else if(uPower==22){//拥有广告联盟权限
			 $("#t1000-tit-1").css("display","none");//投票不显示
			 $("#t1000-tit-3").css("display","none");//广告联盟不显示
			 $("#t1000-tit-4").css("display","none");//管理员页面显示
			 $(".t1000-tit-2 a").click();
			 $("#league-menu-21 a").click();

		 }else  if(uPower==23){//拥有查看专题留言
			 $("#t1000-tit-1").css("display","none");//投票不显示
			 $("#t1000-tit-2").css("display","none");//广告联盟不显示
			 $("#t1000-tit-4").css("display","none");//管理员页面显示
			 $(".t1000-tit-3 a").click();

		 }
	})



