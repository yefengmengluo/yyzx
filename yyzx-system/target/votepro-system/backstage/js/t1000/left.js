// JavaScript Document
function showMenu(uClass){
	$(uClass).click(function(){
		$(this).parent().addClass("current").siblings().removeClass("current").children("ul").slideUp(400);
		$(this).next("ul").slideDown(400).children("li").removeClass("current");
	})
}

$(function(){
	 /*左侧导航添加选中状态*/
	 showMenu(".t1000-votB-list h2");
	 /*点击切换iframe地址*/
	 $(".t1000-votB-list a").click(function() {
			var $this = $(this);
			var $currentMenu =$this.attr("urlData");
			$("#t1000-votB-R-box").attr("src",$currentMenu);
	  });
	 
	 /*左侧列表li选中状态*/
	$(".t1000-votB-list ul li").click(function(){
		$(this).addClass("current").siblings().removeClass("current");
	});
			
	/*计算左侧高度*/
	var win_c_H=$(window).height()-60-30-2;
	var left_H;
	win_c_H >=340 ? left_H=win_c_H : left_H=340;
	$(".t1000-votB-L").height(left_H);
	$("#t1000-votB-R-box").height(left_H+2);
		
})
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

	})
	$(".bookingTit span").click(function(){
		$(".bookingBlackBg,.bookingBox2").hide();	
	})
	$(window).scroll(function(){
		var boxScroll=$(document).scrollTop();
		$(".bookingBox2").css("top",parseInt(boxTT+boxScroll));	
	})
	
	$(".t1000-edit-vote,.t1000-edit-close").click(function(){
		$(".bookingBox2").hide();
		$(".bookingBlackBg").hide();
	});
	/*限制只能输入数字
	$(".new_vote").keyup(function(){
	 $(this).val($(this).val().replace(/\D|^0/g,'')); }).bind("paste",function(){
	  $(this).val($(this).val().replace(/\D|^0/g,'')); }).css("ime-mode", "disabled"); 
	*/
})

$(window).resize(function(){
	var win_c_H=$(window).height()-60-30-2;
	var left_H;
	win_c_H >=340 ? left_H=win_c_H : left_H=340;
	$(".t1000-votB-L").height(left_H);
	$("#t1000-votB-R-box").height(left_H+2);
})
$(function(){
		$("#newpassword").blur(function(){
		if($("#newpassword").val().length<6){
			alert("密码长度必须大于6位！");
			// $("#newpassword").focus();
		}
	})
	$("#compassword").blur(function(){
		if(!($("#newpassword").val()==$("#compassword").val())){
			alert("两次密码不一致。请重新输入！");
			$("#compassword").val("");
			// $("#compassword").focus();
		}
	})
})
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
