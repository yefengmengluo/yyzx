// JavaScript Document
$(function(){
	
	
})

function box01(){
	$(".word").stop().animate({"top":"214px","opacity":"1"},1000);
	$(".source").stop().animate({"top":"472px","opacity":"1"},1000);
	
}
function box02(){
	$(".world").stop().animate({"top":"0","opacity":"1"},1500);	
	$(".arrow_l").stop().animate({"left":"10px","opacity":"1"},1500);	
	$(".arrow_r").stop().animate({"right":"10px","opacity":"1"},1500);
	setTimeout(function(){
		$(".money1").stop().animate({"right":"85px","top":"81px","opacity":"1"},2500);	
		$(".money2").stop().animate({"left":"0px","top":"81px","opacity":"1"},2500);
		$(".money3").stop().animate({"left":"26px","top":"340px","opacity":"1"},2500);	
		$(".money4").stop().animate({"left":"148px","top":"575px","opacity":"1"},2500);
	},1000);
		
}


function box03(){
	$(".bulb img").addClass("tf1").addClass("ts1");
	setTimeout(function(){
		$(".sp01").stop().animate({"left":"0px","opacity":"1"},1000);
		$(".sp02").stop().animate({"left":"0px","opacity":"1"},1500);
		$(".sp03").stop().animate({"left":"0px","opacity":"1"},2000);
		$(".sp04").stop().animate({"left":"0px","opacity":"1"},2500);
		$(".sp05").stop().animate({"left":"0px","opacity":"1"},3000);
	},1000)
}
function box04(){
	$(".ad01").stop().animate({"top":"0px","opacity":"1"},1500);
	$(".ad02").stop().animate({"top":"140px","opacity":"1"},1800);
	$(".ad03").stop().animate({"top":"296px","opacity":"1"},2100);
	$(".ad04").stop().animate({"top":"436px","opacity":"1"},2400);
}

function box05(){
	$(".as01").stop().animate({"left":"20px","opacity":"1"},1500);
	$(".as02").stop().animate({"left":"454px","opacity":"1"},1500);
	$(".as03").stop().animate({"left":"900px","opacity":"1"},1500);
}
function box06(){
	$(".prob_b1").stop().animate({"left":"0","opacity":"1"},1000);
	$(".prob_b2").stop().animate({"right":"0","opacity":"1"},1000);
	$(".prob01 img").addClass("tf1").addClass("ts1");
	setTimeout(function(){$(".prob02 img").addClass("tf1").addClass("ts1");},1000)
	setTimeout(function(){$(".prob03 img").addClass("tf1").addClass("ts1");},2000)
	setTimeout(function(){$(".prob04 img").addClass("tf1").addClass("ts1");},3000)
	setTimeout(function(){
		$(".prob_tit1").stop().animate({"left":"50px","opacity":"1"},1000);
	},1000)
	setTimeout(function(){
		$(".prob_tit2").stop().animate({"left":"366px","opacity":"1"},1000);
	},1500)
	setTimeout(function(){
		$(".prob_tit3").stop().animate({"left":"682px","opacity":"1"},1000);
	},2500)
	setTimeout(function(){
		$(".prob_tit4").stop().animate({"left":"998px","opacity":"1"},1000);
	},3500)
	setTimeout(function(){
		$(".prob_w1").stop().animate({"left":"20px","opacity":"1"},1000);
	},1000)
	setTimeout(function(){
		$(".prob_w2").stop().animate({"left":"327px","opacity":"1"},1000);
	},1500)
	setTimeout(function(){
		$(".prob_w3").stop().animate({"left":"640px","opacity":"1"},1000);
	},2500)
	setTimeout(function(){
		$(".prob_w4").stop().animate({"left":"968px","opacity":"1"},1000);
	},3500)
	/*setTimeout(function(){
		$(".prob_tit1").stop().animate({"left":"50px","opacity":"1"},1000);
		$(".prob_tit2").stop().animate({"left":"366px","opacity":"1"},1000);
		$(".prob_tit3").stop().animate({"left":"682px","opacity":"1"},1000);
		$(".prob_tit4").stop().animate({"left":"998px","opacity":"1"},1000);
	},4000)
	setTimeout(function(){
		$(".prob_w1").stop().animate({"left":"20px","opacity":"1"},1000);
		$(".prob_w2").stop().animate({"left":"327px","opacity":"1"},1000);
		$(".prob_w3").stop().animate({"left":"640px","opacity":"1"},1000);
		$(".prob_w4").stop().animate({"left":"968px","opacity":"1"},1000);
	},4000)*/
}
function box07(){
	$(".treeBig").stop().animate({"opacity":"1"},2500);	
	$(".case2").stop().animate({"left":"20px","opacity":"1"},2500);	
	$(".case4").stop().animate({"left":"220px","opacity":"1"},2500);	
	$(".case6").stop().animate({"left":"20px","opacity":"1"},2500);	
	$(".case1").stop().animate({"right":"20px","opacity":"1"},2500);	
	$(".case3").stop().animate({"right":"455px","opacity":"1"},2500);	
	$(".case5").stop().animate({"right":"240px","opacity":"1"},2500);	
	$(".case7").stop().animate({"right":"60px","opacity":"1"},2500);	
}

function box08(){
	$(".win_tit01").stop().animate({"left":"80px","opacity":"1"},2500);	
	setTimeout(function(){
		$(".win_text1").stop().animate({"left":"0px","opacity":"1"},1000);
	},500)
	setTimeout(function(){
		$(".win_tit02").stop().animate({"left":"93px","opacity":"1"},2500);
	},1000)
	setTimeout(function(){
		//$(".win_tit02").stop().animate({"left":"93px","opacity":"1"},2500);
		$(".win_text2").stop().animate({"left":"0px","opacity":"1"},1000);
	},1500)
	setTimeout(function(){
		$(".win_tit03").stop().animate({"left":"93px","opacity":"1"},2500);
	},2000)
	setTimeout(function(){
		//$(".win_tit03").stop().animate({"left":"93px","opacity":"1"},2500);
		$(".win_text3").stop().animate({"left":"0px","opacity":"1"},1000);
	},2500)
	setTimeout(function(){
		$(".win_tit04").stop().animate({"left":"42px","opacity":"1"},2500);
	},3000)
	setTimeout(function(){
		//$(".win_tit04").stop().animate({"left":"42px","opacity":"1"},2500);
		$(".win_text4").stop().animate({"left":"0px","opacity":"1"},1000);
	},3500)
}
function box09(){
	$(".box09_word").stop().animate({"left":"78px","opacity":"1"},2000);
	$(".pen1").stop().animate({"right":"30px","bottom":"40px","opacity":"1"},2000);
	$(".pen2").stop().animate({"right":"248px","bottom":"50px","opacity":"1"},2000);
	$(".pen3").stop().animate({"right":"150px","bottom":"30px","opacity":"1"},2000);
}

function box10(){
	$(".hand").stop().animate({"top":"256px","right":"-40px","opacity":"1"},1500);
	setTimeout(function(){
		$(".campany").stop().animate({"top":"0px","left":"0px","opacity":"1"},500);
		$(".contect").stop().animate({"top":"80px","left":"0px","opacity":"1"},1000);
		$(".phone").stop().animate({"top":"160px","left":"0px","opacity":"1"},1500);
		$(".other").stop().animate({"top":"240px","left":"0px","opacity":"1"},2000);
	},1000)
}

$(function(){
	var wH=$(window).height();
	for(var n=1;n<=10;n++){
		$(".box_0"+n).height(wH);
	}
		
})













