// JavaScript Document
/*弹出框*/
var eleWidth, eleHeight,winHeight,btn_index, boxWW,boxHH,boxLL,boxTT;
function Boxpos(){
	 eleWidth=$(document).width();
	 eleHeight=$(document).height();
	 winHeight=$(window).height();
	 btn_index=0;
	 boxWW=$(".bookingBox").width();
	 boxHH=$(".bookingBox").height();
	 boxLL=(eleWidth-boxWW)/2;
	 boxTT=(winHeight-boxHH)/2;
	$(".bookingBlackBg").css("height",eleHeight);
	$(".bookingBox").css("left",parseInt(boxLL));
}

function inputTipText() {
	$("[class*=grayTips]") // 所有样式名中含有grayTips的input
	.each(function() {
		var _this = $(this);
	   if($.trim(_this.val()) == '' || $.trim(_this.val())== '请输入关键字'){
		   _this.css('color', '#999');
	   }else{
		   _this.css('color', '#333');
	   }
		_this.focus(function() {
				if (_this.val() =='请输入关键字') {
					_this.val('').css("color", "#333");
			 }})
			.blur(function() {
			if (!_this.val() || $.trim(_this.val()) == "" || $.trim(_this.val()) =='请输入关键字') {
				_this.val("请输入关键字").css("color", "#999");
			}
		}).keydown(function() {
			_this.css({
				"color" : "#333"
			})
		})
	})
} 
	
$(function(){
	/*全选*/
/*	$("#checkedAll").click(function() {
		$("input[name='companyList[]']").prop("checked", this.checked);
	});
	
	$("input[name='companyList[]']").click(function() {
		var $companyList = $("input[name='companyList[]']");
		$("#checkedAll").prop("checked" , $companyList.length == $companyList.filter(":checked").length ? true :false);
	});*/
	
	
	/*$(function(){     
		inputTipText(); 
		return false;     
	})*/
	
	/*修改密码*/
	$(".noRead").focus(function() {
				$(this).css("background-color", "#fff");
			}).blur(function() {
			if (!$(this).val() || $.trim($(this).val()) == "") {
				$(this).css("background-color", "#f8f8f8");
			}
		}).keydown(function() {
			$(this).css("background-color","#fff")
		})


})

$(function(){
	if($('.advertising-listManage-consearch select').html()=="请选择广告行业"){
		$('.advertising-listManage-consearch select').css({"color":"#929292"});	
	}else{
		$('.advertising-listManage-consearch select').css({"color":"#252525"});	
	}
})

$(function(){
	$('.focus_on').focus(function(){
		$(this).css({"border":"1px solid #80cbf9"});	
	}).blur(function(){
		$(this).css({"border":"1px solid #dfdfdf"});	
	})	
})


$(function(){

		$('.single').click(function(){
			if($(this).attr("checked")=="checked"){
				$(this).parent().children('.red').css("color","#f00");	
			}else{
				
				$(this).parent().children('.red').css("color","#acacac");
			}
		})
			
	
		
})


/*发布*/
$(function(){
	$('.fabu').click(function(){
		$(this).parent().parent().children().children('.focus_on').attr('disabled','disabled');	
		//$('.advertising-pic-modify-con .focus_on').attr('disabled','disabled');
	})
		
})


/*图片广告*/
$(function(){
	var pic_ad=$(".advertising-picture-con-bottom").prop("outerHTML");
	$('.advertising-picture-con-top ul li').click(function(){
		if($(this).hasClass('blue')==true){
			$(this).removeClass('blue');
		}else{
			$(this).addClass('blue');
		}
	})	
	$('.advertising-picture-con-center dd a').click(function(){
		var Aid=$(this).attr('id');
				var dtHtml=$(this).parent().parent().children('dt').html();
				//alert(dtHtml);
		if($(this).hasClass('blue')==true){
			$(this).removeClass('blue');
			
			$(this).closest('.advertising-picture-con').find("#adv-"+Aid+"").html("");
		}else{
			$(this).addClass('blue');
			//$('.content').prepend(pic_ad);
			$(this).closest('.advertising-picture-con').find(".content").prepend(pic_ad);
					$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).find('th').html(dtHtml);
			$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).find('i').html($(this).html());
								$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).attr('id','adv-'+Aid);
			
		}
					$('.fabu').click(function(){
				$(this).closest('.con').find('.focus_on').attr('disabled','disabled');
			})

	})	
})
$(function(){
	var pic_adAll=$('.con').prop("outerHTML");
	$('.add').click(function(){
		$(".outer").append(pic_adAll);	
			var num=1;
			var aLength= $('.advertising-picture-con-center a').length;
			for(num; num<=aLength;num++){
				$('.advertising-picture-con-center a').eq(num-1).attr('id','size-'+num);
			}	
		$(function(){
			var pic_ad=$(".advertising-picture-con-bottom").prop("outerHTML");
			
			$('.advertising-picture-con-top ul li').click(function(){
				if($(this).hasClass('blue')==true){
					$(this).removeClass('blue');
				}else{
					$(this).addClass('blue');
				}
			})	
			$('.advertising-picture-con-center dd a').click(function(){
				var Aid=$(this).attr('id');
				var dtHtml=$(this).parent().parent().children('dt').html();
				
				if($(this).hasClass('blue')==true){
					$(this).removeClass('blue');
					$(this).closest('.advertising-picture-con').find("#adv-"+Aid+"").html("");
					//$(this).closest('.advertising-picture-con').find('img').attr('src','');
				}else{
					$(this).addClass('blue');
					$(this).closest('.advertising-picture-con').find(".content").prepend(pic_ad).find('.focus_on').removeAttr('disabled');
					var img='<img class="imghead" id="imghead"  src="../../../../fodder/advertising/add_bg.jpg"/>';
					$(this).closest('.advertising-picture-con').find(".content").find('.advertising-picture-con-bottom').eq(0).find('.imghead').remove();
					
					$(this).closest('.advertising-picture-con').find(".content").find('.advertising-picture-con-bottom').eq(0).find('.preview').append(img);
					$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).find('th').html(dtHtml);
					$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).find('i').html($(this).html());
					$(this).closest('.advertising-picture-con').find('.advertising-picture-con-bottom').eq(0).attr('id','adv-'+Aid);
					$(this).closest('.con').find('.fabu').click(function(){
						$(this).closest('.con').find('.focus_on').attr('disabled','disabled');
			})

				}

			})	
		})
	})
	$('.reduce').click(function(){
		$(".outer").children('.con:last').remove();
		
	})
})


/*添加id名*/
$(function(){
	var num=1;
	var aLength= $('.advertising-picture-con-center a').length;
	for(num; num<=aLength;num++){
		$('.advertising-picture-con-center a').eq(num-1).attr('id','size-'+num);
	}	
});


/*广告管理*/
$(function(){
	//alert(1);
	var num = $('.advertising-manage-con table th').length;
	/*var windowW = $(window).width();
	var th1 = $('.m1').width();
	var tableW = windowW-32-th1;
	var tdW = parseInt(tableW/(num-1));*/	
	var tab_h=$(window.parent.document).find(".t1000-votB-R-box").height()-40;
	$('.advertising-manage-con').height(tab_h);
	$('.m1,.m3').width(108);
	$('.advertising-manage-con table').width(108*num);
	/*var th_w=0;
	$('.advertising-manage-con table th').each(function(){
		th_w += $(this).width();
	
	});
	$('.advertising-manage-con table').width(th_w);*/
	
});























