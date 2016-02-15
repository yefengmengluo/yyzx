function getByClass(oParent, sClass) {//通过className获取对象
	var aChild = oParent.getElementsByTagName('*');
	var regex = new RegExp('\\b' + sClass + '\\b', 'i');
	var result = [];

	for (var i=0; i<aChild.length; i++) {
		if (regex.test(aChild[i].className)) {//判断对象className是否符合条件
			result.push(aChild[i]);
		}
	}

	return result;
}

//视察滚动
function parallaxAnimate(sDom, region, scrollTop) {
/*
sDom：运动对象class名称或者id名称
 region, scrollTop
*/
	var elm; //要运动的对象

	//判断是.还是#，使用不同的方法获取对象
	if (sDom.charAt(0) == ".") {
		var oWrap = document.getElementById("wrapBox");
		elm = getByClass(oWrap, sDom.substring(1))[0];
	} else if (sDom.charAt(0) == "#") {
		elm = document.getElementById(sDom.substring(1));
	}

	//console.log(elm);
	var area = (scrollTop - region.startTop)/(region.endTop - region.startTop);

	for (var i in region.startCss) {
			var target = (region.endCss[i] - region.startCss[i])*area;
			var json = {};
			json[i] = region.startCss[i] + target;
			//$(elm).css(json);
		if (i == 'backgroundPosition') {
			$(elm).stop().animate({'background-position-x': '50%', 'background-position-y': target}, 1100, 'linear');
		} else {
			$(elm).stop().animate(json, 1100, 'linear');
		}
	}
}

function fnLoad() {
	var $wrapBox = $("#wrapBox");
	var windowHeight = document.documentElement.clientHeight || document.body.clientHeight;
	var boxHeight = (windowHeight-60)>520 ? (windowHeight-60) : 520;

	$(".box").css('height', boxHeight);//初始化.box的高度
	$(".b1_fixed").css('top', (boxHeight-520)/2);//初始化.box的高度
	var wH=$(".box").height();
	for(var n=1;n<10;n++){
		$(".box_0"+n).height(wH);
	}
	$(".box_10").height(wH);
	for(var n=2;n<=10;n++){
		
		$(".box_0"+n+"_con").height(wH);
	}
	$(".box_10_con").height(wH);
	var line = {
		lineHeight: boxHeight*$(".box").length,//虚拟轴高度
		pageIndex: 0,//当前page索引
		scrollRatio: 1,//滚动条和虚拟轴的比率，越大则滚动得越慢（滚动条滚几倍，虚拟轴才滚1）
		isAnimRuning: false,//自动滚动
		obj:[]//虚拟轴上的运动对象
	};//虚拟轴
	document.getElementsByTagName("body")[0].style.height = (line.lineHeight + 60) * line.scrollRatio + "px";

	var page_1 = 0,
		page_2 = line.scrollRatio*boxHeight,
		page_3 = line.scrollRatio*boxHeight*2,
		page_4 = line.scrollRatio*boxHeight*3,
		page_5 = line.scrollRatio*boxHeight*4,
		page_6 = line.scrollRatio*boxHeight*5,
		page_7 = line.scrollRatio*boxHeight*6;
		page_8 = line.scrollRatio*boxHeight*7,
		page_9 = line.scrollRatio*boxHeight*8,
		page_10 = line.scrollRatio*boxHeight*9;
		page_11 = line.scrollRatio*boxHeight*10;

	var beforePage = line.scrollRatio*200,
		afterPage = line.scrollRatio*200;

	var speedTop = 800;
	var scale = (line.lineHeight + 60 - windowHeight)/((line.lineHeight + 60) * line.scrollRatio - windowHeight);

	//fixed
	line.obj.push({
		dom: ".b1_fixed",
		regions: [{
			startTop: 0,
			endTop: (boxHeight-510)/scale,
			startCss: {
				top: (boxHeight-520)/2
			},
			endCss: {
				top: boxHeight-520
			}
		}]
	}, {
		dom: ".b2_fixed",
		regions: [{
			startTop: 510/scale,
			endTop: (boxHeight*2-510)/scale,
			startCss: {
				top: 0
			},
			endCss: {
				top: boxHeight-520
			}
		}]
	}, {
		dom: ".b3_fixed",
		regions: [{
			startTop: (boxHeight+510)/scale,
			endTop: (boxHeight*3-510)/scale,
			startCss: {
				top: 0
			},
			endCss: {
				top: boxHeight-520
			}
		}]
	}, {
		dom: ".b4_fixed",
		regions: [{
			startTop: (boxHeight*2+510)/scale,
			endTop: (boxHeight*4-510)/scale,
			startCss: {
				top: 0
			},
			endCss: {
				top: boxHeight-520
			}
		}]
	}, {
		dom: ".b5_fixed",
		regions: [{
			startTop: (boxHeight*3+510)/scale,
			endTop: (boxHeight*5-510)/scale,
			startCss: {
				top: 0
			},
			endCss: {
				top: boxHeight-520
			}
		}]
	}, {
		dom: ".b6_fixed",
		regions: [{
			startTop: (boxHeight*4+510)/scale,
			endTop: (boxHeight*6-510)/scale,
			startCss: {
				top: 0
			},
			endCss: {
				top: boxHeight-520
			}
		}]
	}, {
		dom: ".b7_fixed",
		regions: [{
			startTop: (boxHeight*5+510)/scale,
			endTop: (boxHeight*7-510)/scale,
			startCss: {
				top: 0
			},
			endCss: {
				top: boxHeight-520
			}
		}]
	});

	//box bg
	line.obj.push({
		dom: ".box1_bg",
		regions: [{
			startTop: 0,
			endTop: (boxHeight-60)/scale,
			startCss: {
				top: 0
			},
			endCss: {
				top: boxHeight - 1100
			}
		}]
	}, {
		dom: ".box2_bg",
		regions: [{
			startTop: 0,
			endTop: (boxHeight*2-60)/scale,
			startCss: {
				top: 0
			},
			endCss: {
				top: boxHeight - 1100
			}
		}]
	}, {
		dom: ".box3_bg",
		regions: [{
			startTop: boxHeight/scale,
			endTop: boxHeight*3/scale,
			startCss: {
				top: 0
			},
			endCss: {
				top: boxHeight - 1100
			}
		}]
	}, {
		dom: ".box4_bg",
		regions: [{
			startTop: boxHeight*2/scale,
			endTop: boxHeight*4/scale,
			startCss: {
				top: 0
			},
			endCss: {
				top: boxHeight - 1100
			}
		}]
	}, {
		dom: ".box5_bg",
		regions: [{
			startTop: boxHeight*3/scale,
			endTop: boxHeight*5/scale,
			startCss: {
				top: 0
			},
			endCss: {
				top: boxHeight - 1100
			}
		}]
	}, {
		dom: ".box6_bg",
		regions: [{
			startTop: boxHeight*4/scale,
			endTop: boxHeight*6/scale,
			startCss: {
				top: 0
			},
			endCss: {
				top: boxHeight - 1100
			}
		}]
	}, {
		dom: ".box7_bg",
		regions: [{
			startTop: boxHeight*5/scale,
			endTop: boxHeight*7/scale,
			startCss: {
				top: 0
			},
			endCss: {
				top: boxHeight - 1100
			}
		}]
	});

	//box1
	/*line.obj.push({
		dom: ".b1_04",
		regions: [{
			startTop: page_1,
			endTop: page_2,
			startCss: {
				top: 470
			},
			endCss: {
				top: 400 + 470
			}
		}]
	});*/

	//box2 --> box3
	line.obj.push({
		dom: ".b2_03",
		regions: [{
			startTop: page_1,
			endTop: page_3,
			startCss: {
				top: -400
			},
			endCss: {
				top: 600 + 30
			}
		}]
	}, {
		dom: ".b2_04",
		regions: [{
			startTop: page_1,
			endTop: page_3,
			startCss: {
				top: -100
			},
			endCss: {
				top: 200+ 350
			}
		}]
	}, {
		dom: ".b2_06",
		regions: [{
			startTop: page_1,
			endTop: page_3,
			startCss: {
				top: -200
			},
			endCss: {
				top: speedTop/2 + 300
			}
		}]
	});

	
	

	var oBody = document.getElementsByTagName('body')[0];
	var scrollNum = 1;

	if(oBody.addEventListener) {
		oBody.addEventListener('DOMMouseScroll', function(e){
			scrollFunc(e);
		}, false);
	}
	oBody.onmousewheel = function(e){
		scrollFunc(e);
	};
	function scrollFunc(e) {
		var e = e || event;
		var wrapTop = 60 - document.getElementById("wrapBox").offsetTop;
		var direct;
		var endWrapTop;

		e.preventDefault ? e.preventDefault() : (e.returnValue = false);

		direct = e.wheelDelta ? e.wheelDelta : e.detail*-1;


		if (direct > 0) {
			if ((scrollNum++)%2) {
				return;
			}

			endWrapTop = (Math.round(wrapTop/boxHeight*1)-1) * boxHeight/1;
		} else {
			if ((scrollNum--)%2) {
				return;
			}
			endWrapTop = (Math.round(wrapTop/boxHeight*1)+1) * boxHeight/1;
		}

		window.scroll(0, endWrapTop/(line.lineHeight + 60 - windowHeight)*((line.lineHeight + 60) * line.scrollRatio - windowHeight));
	}

	var endTop = 0;
	window.onscroll = function() {
		var top = document.documentElement.scrollTop || document.body.scrollTop;//获取滚动条位置
		
		endTop = top;
		
		var wrapTop = top*(line.lineHeight + 60 - windowHeight)/((line.lineHeight + 60) * line.scrollRatio - windowHeight);//内容改变top值


		$wrapBox.stop().animate({"top": -wrapTop+60}, 1300);//#wrap 滚动

		var topIndex = 0;
		if (wrapTop <= boxHeight*(topIndex + 0.6)) {
			if (box1In) {
				boxGoIn_1();
			}
			$(".nav a").removeClass("cur").eq(0).addClass("cur");
			$(".fixedNav li").removeClass("cur").eq(0).addClass("cur");
		} else if (wrapTop > boxHeight*(topIndex + 0.8)) {
			boxGoOut_1();
		}
		topIndex++;

		if (boxHeight*(topIndex-0.4) < wrapTop && wrapTop < boxHeight*(topIndex+0.6)) {
			if (box2In) {
				boxGoIn_2();
			}
			$(".nav a").removeClass("cur").eq(1).addClass("cur");
			$(".fixedNav li").removeClass("cur").eq(1).addClass("cur");
		} else if (wrapTop > boxHeight*(topIndex+0.8) || wrapTop < boxHeight*(topIndex-0.4)) {
			boxGoOut_2();
		}
		topIndex++;

		if (boxHeight*(topIndex-0.4) < wrapTop && wrapTop < boxHeight*(topIndex+0.6)) {
			if (box3In) {
				boxGoIn_3();
			}
			$(".nav a").removeClass("cur").eq(2).addClass("cur");
			$(".fixedNav li").removeClass("cur").eq(2).addClass("cur");
		} else if (wrapTop > boxHeight*(topIndex+0.8) || wrapTop < boxHeight*(topIndex-0.4)) {
			boxGoOut_3();
		}
		topIndex++;

		if (boxHeight*(topIndex-0.4) < wrapTop && wrapTop < boxHeight*(topIndex+0.6)) {
			if (box4In) {
				boxGoIn_4();
			}
			$(".nav a").removeClass("cur").eq(3).addClass("cur");
			$(".fixedNav li").removeClass("cur").eq(3).addClass("cur");
		} else if (wrapTop > boxHeight*(topIndex+0.8) || wrapTop < boxHeight*(topIndex-0.4)) {
			boxGoOut_4();
		}
		topIndex++;

		if (boxHeight*(topIndex-0.4) < wrapTop && wrapTop < boxHeight*(topIndex+0.6)) {
			if (box5In) {
				boxGoIn_5();
			}
			$(".nav a").removeClass("cur").eq(4).addClass("cur");
			$(".fixedNav li").removeClass("cur").eq(4).addClass("cur");
		} else if (wrapTop > boxHeight*(topIndex+0.8) || wrapTop < boxHeight*(topIndex-0.4)) {
			boxGoOut_5();
		}
		topIndex++;

		if (boxHeight*(topIndex-0.4) < wrapTop && wrapTop < boxHeight*(topIndex+0.6)) {
			if (box6In) {
				boxGoIn_6();
			}
			$(".nav a").removeClass("cur").eq(5).addClass("cur");
			$(".fixedNav li").removeClass("cur").eq(5).addClass("cur");
		} else if (wrapTop > boxHeight*(topIndex+0.8) || wrapTop < boxHeight*(topIndex-0.4)) {
			boxGoOut_6();
		}
		topIndex++;

		if (boxHeight*(topIndex-0.4) < wrapTop && wrapTop < boxHeight*(topIndex+0.6)) {
			if (box7In) {
				boxGoIn_7();
			}
			$(".nav a").removeClass("cur").eq(6).addClass("cur");
			$(".fixedNav li").removeClass("cur").eq(6).addClass("cur");
		} else if (wrapTop > boxHeight*(topIndex+0.8) || wrapTop < boxHeight*(topIndex-0.4)) {
			boxGoOut_7();
		}
		topIndex++;

		if (boxHeight*(topIndex-0.4) < wrapTop && wrapTop < boxHeight*(topIndex+0.6)) {
			if (box8In) {
				boxGoIn_8();
			}
			$(".nav a").removeClass("cur").eq(7).addClass("cur");
			$(".fixedNav li").removeClass("cur").eq(7).addClass("cur");
		} else if (wrapTop > boxHeight*(topIndex+0.8) || wrapTop < boxHeight*(topIndex-0.4)) {
			boxGoOut_8();
		}
		topIndex++;

		if (boxHeight*(topIndex-0.4) < wrapTop && wrapTop < boxHeight*(topIndex+0.6)) {
			if (box9In) {
				boxGoIn_9();
			}
			$(".nav a").removeClass("cur").eq(8).addClass("cur");
			$(".fixedNav li").removeClass("cur").eq(8).addClass("cur");
		} else if (wrapTop > boxHeight*(topIndex+0.8) || wrapTop < boxHeight*(topIndex-0.4)) {
			boxGoOut_9();
		}
		topIndex++;

		if (boxHeight*(topIndex-0.4) < wrapTop && wrapTop < boxHeight*(topIndex+0.6)) {
			if (box10In) {
				boxGoIn_10();
			}
			$(".nav a").removeClass("cur").eq(9).addClass("cur");
			$(".fixedNav li").removeClass("cur").eq(9).addClass("cur");
		} else if (wrapTop > boxHeight*(topIndex+0.8) || wrapTop < boxHeight*(topIndex-0.4)) {
			boxGoOut_10();
		}
		topIndex++;

		

		for (var i=0, len=line.obj.length; i<len; i++) {
			var curEle = line.obj[i];
			for (var j=0, len2=curEle.regions.length; j<len2; j++) {
				if (curEle.regions[j].startTop <= top && curEle.regions[j].endTop >= top) {
					parallaxAnimate(curEle.dom, curEle.regions[j], top);
				} else if (curEle.regions[j].endTop <= top) {
					for (var n in curEle.regions[j].endCss) {
						var json = {};

						json[n] = curEle.regions[j].endCss[n];
						//$(curEle.dom).css(json);
						$(curEle.dom).stop().animate(json, 1300);
					}
				} else if (curEle.regions[j].startTop >= top) {
					for (var n in curEle.regions[j].startCss) {
						var json = {};

						json[n] = curEle.regions[j].startCss[n];
						$(curEle.dom).stop().animate(json, 1300);
					}
				}
			}
		}
	};

	for (var i in elementInit) {//初始化对象
		var $i = $wrapBox.find(i);
		for (var j in elementInit[i]) {
			$i.css(j, elementInit[i][j]);
		}
	}

	boxGoIn_1();//默认第一个

	$(".nav li").click(function() {
		var index = $(this).index();
		index = index==0 ? 0 : index;
		//alert(index);
		window.scroll(0, index * line.scrollRatio * boxHeight);
	});

	$(".fixedNav").css({'margin-left': $(window).width()/2-40, 'display': 'block'});
	$(".fixedNav li").click(function() {
		var index = $(this).index();
		index = index==0 ? 0 : index;
		
		window.scroll(0, index * line.scrollRatio * boxHeight);
	});
	$(".fixedNav li").hover(function(){
		$(this).find('.txt').show();
	}, function() {
		$(this).find('.txt').hide();
	})

	var lazyload;
	window.onresize = function() {
		clearTimeout(lazyload);
		lazyload = setTimeout(function() {
			window.location.reload(); 
			document.documentElement.scrollTop = document.body.scrollTop = 0;
		}, 500);
	};

	$(".b1_03 a").click(function() {
		var now = 1;
		document.getElementsByTagName('body')[0].scrollTop = document.documentElement.scrollTop = now * line.scrollRatio * boxHeight;
	});
};

var elementInit = {//初始化对象属性
	".b1_01": {
		opacity: 0
	},
	".b1_02": {
		//left: (1920 - windowWidth)/2 - 709,
		left: 300,
		opacity: 0
	},
	".b1_03": {
		top: 185,
		opacity: 0
	},
	".b1_03_btn": {
		//opacity: 0
	},
	".b1_04": {
		//top: 800
	},
	".b2_01": {
		top: 800,
		left: -200,
		opacity: 0
	},
	".b2_02": {
		left: 1050,
		opacity: 0
	},
	".b2_07": {
		left: 810,
		opacity: 0
	},
	".b2_03": {
		//top: 70,
		//opacity: 0
	},
	".b3_tl": {
		opacity: 0
	},
	".b3_01": {
		left: 670,
		top: 275,
		opacity: 0
	},
	".b3_02": {
		left: 963,
		top: 293,
		opacity: 0
	},
	".b3_03": {
		left: 963,
		opacity: 0
	},
	".b3_04": {
		left: 963,
		top: 353,
		opacity: 0
	},
	".b3_05": {
		left: 670,
		top: 353,
		opacity: 0
	},
	".b3_06": {
		left: 670,
		opacity: 0
	},
	".b4_tl": {
		top: 810,
		opacity: 0
	},
	".b4_txt": {
		opacity: 0
	},
	".b4_txt01": {
		top: 930
	},
	".b4_txt02": {
		top: 1012
	},
	".b4_txt03": {
		top: 1094
	},
	".b4_txt04": {
		top: 1176
	},
	".b4_txt05": {
		top: 1258
	},
	".b4_txt06": {
		top: 1340
	},
	".b4_01": {
		left: 1000,
		opacity: 0
	},
	".b4_02": {
		left: 1235,
		opacity: 0
	},
	".b5_tl": {
		opacity: 0
	},
	".b5_txt": {
		opacity: 0
	},
	".b5_01": {
		//left: 500,
		opacity: 0
	},
	".b5_ico01": {
		left: 500,
		opacity: 0
	},
	".b5_ico02": {
		left: 625,
		top: -34,
		opacity: 0
	},
	".b5_ico03": {
		left: 625,
		top: 304,
		opacity: 0
	},
	".b5_ico04": {
		left: 780,
		top: -145,
		opacity: 0
	},
	".b5_ico05": {
		left: 780,
		opacity: 0
	},
	".b5_ico06": {
		left: 780,
		top: 395,
		opacity: 0
	},
	".b6_tl": {
		opacity: 0
	},
	".b6_img": {
		opacity: 0
	},
	".b6_arrow01": {
		top: 34
	},
	".b6_arrow02": {
		top: -34
	},
	".b6_txt": {
		opacity: 0
	},
	".b6_01": {
		left: 400,
		opacity: 0
	}
}

var box1In = true,
	box2In = true,
	box3In = true,
	box4In = true,
	box5In = true,
	box6In = true;
	box7In = true,
	box8In = true,
	box9In = true,
	box10In = true;

function boxGoIn_1() {
	 box1In = false;
	$(".box_01_top").stop().animate({"top":"18%","opacity":"1"},1000);
	$(".box_01_center").stop().animate({"top":"34%","opacity":"1"},2000);
	$(".box_01_bottom").stop().animate({"top":"66%","opacity":"1"},3000);
}
function boxGoOut_1() {
	 box1In = true;
	$(".box_01_top").stop().animate({"top":"0px","opacity":"1"},1000);
	$(".box_01_center").stop().animate({"top":"326px","opacity":"1"},2000);
	$(".box_01_bottom").stop().animate({"top":"508px","opacity":"1"},3000);
}

function boxGoIn_2() {
	 box2In = false;
	$(".world").stop().animate({"top":"0","opacity":"1"},1500);	
	$(".arrow_l").stop().animate({"left":"10px","opacity":"1"},1500);	
	$(".arrow_r").stop().animate({"right":"10px","opacity":"1"},1500);
		$(".people img").addClass("tf1").addClass("ts1");
	$(".money1 img").addClass("tf1").addClass("ts1");
	$(".money2 img").addClass("tf1").addClass("ts1");
	$(".money3 img").addClass("tf1").addClass("ts1");
	$(".money4 img").addClass("tf1").addClass("ts1");
	setTimeout(function(){
		$(".money1").stop().animate({"right":"85px","top":"81px","opacity":"1"},2500);	
		$(".money2").stop().animate({"left":"0px","top":"81px","opacity":"1"},2500);
		$(".money3").stop().animate({"left":"26px","top":"340px","opacity":"1"},2500);	
		$(".money4").stop().animate({"left":"148px","top":"575px","opacity":"1"},2500);
	},1000);
}
function boxGoOut_2() {
	 box2In = true;
	$(".world").stop().animate({"top":"-100px","opacity":"0"},1500);	
	$(".arrow_l").stop().animate({"left":"-100px","opacity":"0"},1500);	
	$(".arrow_r").stop().animate({"right":"-100px","opacity":"0"},1500);
	
	
	
		$(".money1").stop().animate({"right":"0px","top":"0px","opacity":"0"},2500);	
		$(".money2").stop().animate({"left":"-80px","top":"0px","opacity":"0"},2500);
		$(".money3").stop().animate({"left":"-80px","top":"340px","opacity":"0"},2500);	
		$(".money4").stop().animate({"left":"100px","top":"625px","opacity":"0"},2500);
		
		setTimeout(function(){$(".people img").removeClass("tf1").removeClass("ts1");
		$(".money1 img,.money2 img,.money3 img,.money4 img").removeClass("tf1").removeClass("ts1");},1000)
}

var box3Timer;
var box3Now;
var box3Order = [[1, 2], [6, 3], [5,4]]
function boxGoIn_3() {
	box3In = false;
	setTimeout(function(){$(".bulb img").addClass("tf1").addClass("ts1");},1000)
	
	setTimeout(function(){
		$(".sp01").stop().animate({"left":"0px","opacity":"1"},1000);
		$(".sp02").stop().animate({"left":"0px","opacity":"1"},1500);
		$(".sp03").stop().animate({"left":"0px","opacity":"1"},2000);
		$(".sp04").stop().animate({"left":"0px","opacity":"1"},2500);
		$(".sp05").stop().animate({"left":"0px","opacity":"1"},3000);
	},1000)
	
}
function boxGoOut_3() {
	box3In = true;
	setTimeout(function(){$(".bulb img").removeClass("tf1").removeClass("ts1");},1000)
	
	setTimeout(function(){
		$(".sp01").stop().animate({"left":"148px","opacity":"0"},1000);
		$(".sp02").stop().animate({"left":"178px","opacity":"0"},1500);
		$(".sp03").stop().animate({"left":"208px","opacity":"0"},2000);
		$(".sp04").stop().animate({"left":"238px","opacity":"0"},2500);
		$(".sp05").stop().animate({"left":"278px","opacity":"0"},3000);
	},1000)
	

}

var box4Timer;
function boxGoIn_4() {
	box4In = false;
	$(".ad01").stop().animate({"top":"0px","opacity":"1"},1500);
	$(".ad02").stop().animate({"top":"26%","opacity":"1"},1800);
	$(".ad03").stop().animate({"top":"55%","opacity":"1"},2100);
	$(".ad04").stop().animate({"top":"80%","opacity":"1"},2400);
}
function boxGoOut_4() {
	box4In = true;
	$(".ad01").stop().animate({"top":"622px","opacity":"0"},1500);
	$(".ad02").stop().animate({"top":"622px","opacity":"0"},1800);
	$(".ad03").stop().animate({"top":"622px","opacity":"0"},2100);
	$(".ad04").stop().animate({"top":"622px","opacity":"0"},2400);
}

function boxGoIn_5() {
	box5In = false;
	
	$(".box_05_img1 img,.box_05_img2 img,.box_05_img3 img").addClass("tf1").addClass("ts1");
	
	$(".as01").stop().animate({"left":"72px","opacity":"1"},1500);
	$(".as02").stop().animate({"left":"470px","opacity":"1"},1500);
	$(".as03").stop().animate({"left":"872px","opacity":"1"},1500);
}
function boxGoOut_5() {
	box5In = true;
	setTimeout(function(){$(".box_05_img1 img,.box_05_img2 img,.box_05_img3 img").removeClass("tf1").removeClass("ts1");},1000)
	
	
	$(".as01").stop().animate({"left":"50px","opacity":"0"},1500);
	$(".as02").stop().animate({"left":"484px","opacity":"0"},1500);
	$(".as03").stop().animate({"left":"930px","opacity":"0"},1500);
}

var box6Timer;
function boxGoIn_6() {
	box6In = false;
	$(".prob_b1").stop().animate({"left":"0","opacity":"1"},1000);
	$(".prob_b2").stop().animate({"right":"0","opacity":"1"},1000);
	$(".prob01 img").addClass("tf1").addClass("ts1");
	setTimeout(function(){$(".prob02 img").addClass("tf1").addClass("ts1");},1000)
	setTimeout(function(){$(".prob03 img").addClass("tf1").addClass("ts1");},2000)
	setTimeout(function(){$(".prob04 img").addClass("tf1").addClass("ts1");},3000)
	setTimeout(function(){
		$(".prob_tit1").stop().animate({"left":"5%","opacity":"1"},1000);
	},1000)
	setTimeout(function(){
		$(".prob_tit2").stop().animate({"left":"31%","opacity":"1"},1000);
	},1500)
	setTimeout(function(){
		$(".prob_tit3").stop().animate({"left":"59.5%","opacity":"1"},1000);
	},2500)
	setTimeout(function(){
		$(".prob_tit4").stop().animate({"left":"87%","opacity":"1"},1000);
	},3500)
	setTimeout(function(){
		$(".prob_w1").stop().animate({"left":"1%","opacity":"1"},1000);
	},1000)
	setTimeout(function(){
		$(".prob_w2").stop().animate({"left":"26.5%","opacity":"1"},1000);
	},1500)
	setTimeout(function(){
		$(".prob_w3").stop().animate({"left":"55%","opacity":"1"},1000);
	},2500)
	setTimeout(function(){
		$(".prob_w4").stop().animate({"left":"81%","opacity":"1"},1000);
	},3500)
	
}


function boxGoOut_6() {
	box6In = true;
	$(".prob_b1").stop().animate({"left":"-20px","opacity":"0"},1000);
	$(".prob_b2").stop().animate({"right":"-20px","opacity":"0"},1000);
	
	setTimeout(function(){$(".prob01 img,.prob02 img,.prob03 img,.prob04 img").removeClass("tf1").removeClass("ts1");},1000)
		$(".prob_tit1").stop().animate({"left":"70px","opacity":"1"},1000);
		$(".prob_tit2").stop().animate({"left":"386px","opacity":"0"},1000);
		$(".prob_tit3").stop().animate({"left":"702px","opacity":"0"},1000);
		$(".prob_tit4").stop().animate({"left":"1018px","opacity":"0"},1000);
		$(".prob_w1").stop().animate({"left":"0px","opacity":"0"},1000);
		$(".prob_w2").stop().animate({"left":"307px","opacity":"0"},1000);
		$(".prob_w3").stop().animate({"left":"620px","opacity":"0"},1000);
		$(".prob_w4").stop().animate({"left":"948px","opacity":"0"},1000);
}
function boxGoIn_7() {
	box6In = false;
	$(".treeBig").stop().animate({"opacity":"1"},2500);	
	$(".case2").stop().animate({"left":"20px","opacity":"1"},2500);	
	$(".case4").stop().animate({"left":"220px","opacity":"1"},2500);	
	$(".case6").stop().animate({"left":"20px","opacity":"1"},2500);	
	$(".case1").stop().animate({"right":"20px","opacity":"1"},2500);	
	$(".case3").stop().animate({"right":"455px","opacity":"1"},2500);	
	$(".case5").stop().animate({"right":"240px","opacity":"1"},2500);	
	$(".case7").stop().animate({"right":"60px","opacity":"1"},2500);	
}
function boxGoOut_7() {
	box6In = true;
	$(".treeBig").stop().animate({"opacity":"0"},2500);	
	$(".case2").stop().animate({"left":"-120px","opacity":"0"},2500);	
	$(".case4").stop().animate({"left":"-120px","opacity":"0"},2500);	
	$(".case6").stop().animate({"left":"-120px","opacity":"0"},2500);	
	$(".case1").stop().animate({"right":"-100px","opacity":"0"},2500);	
	$(".case3").stop().animate({"right":"-100px","opacity":"0"},2500);	
	$(".case5").stop().animate({"right":"-100px","opacity":"0"},2500);	
	$(".case7").stop().animate({"right":"-100px","opacity":"0"},2500);	
}
function boxGoIn_8() {
	box6In = false;
	$(".win_tit01").stop().animate({"left":"80px","opacity":"1"},2500);	
	setTimeout(function(){
		$(".win_text1").stop().animate({"left":"0px","opacity":"1"},1000);
	},100)
	setTimeout(function(){
		$(".win_tit02").stop().animate({"left":"93px","opacity":"1"},2500);
	},300)
	setTimeout(function(){
		//$(".win_tit02").stop().animate({"left":"93px","opacity":"1"},2500);
		$(".win_text2").stop().animate({"left":"0px","opacity":"1"},1000);
	},500)
	setTimeout(function(){
		$(".win_tit03").stop().animate({"left":"93px","opacity":"1"},2500);
	},700)
	setTimeout(function(){
		//$(".win_tit03").stop().animate({"left":"93px","opacity":"1"},2500);
		$(".win_text3").stop().animate({"left":"0px","opacity":"1"},1000);
	},900)
	setTimeout(function(){
		$(".win_tit04").stop().animate({"left":"42px","opacity":"1"},2500);
	},1100)
	setTimeout(function(){
		//$(".win_tit04").stop().animate({"left":"42px","opacity":"1"},2500);
		$(".win_text4").stop().animate({"left":"0px","opacity":"1"},1000);
	},1300)
}
function boxGoOut_8() {
	box6In = true;
	$(".win_tit01").stop().animate({"left":"100px","opacity":"0"},1500);
	$(".win_text1").stop().animate({"left":"-20px","opacity":"0"},1500);
	$(".win_tit02").stop().animate({"left":"113px","opacity":"0"},1500);
	$(".win_text2").stop().animate({"left":"-20px","opacity":"0"},1500);
	$(".win_tit03").stop().animate({"left":"113px","opacity":"0"},1500);
	$(".win_text3").stop().animate({"left":"-20px","opacity":"0"},1500);
	$(".win_tit04").stop().animate({"left":"62px","opacity":"0"},1500);	
	$(".win_text4").stop().animate({"left":"-20px","opacity":"0"},1500);
	
}
function boxGoIn_9() {
	box6In = false;
	$(".box09_word").stop().animate({"left":"180px","opacity":"1"},2000);
	$(".erweima").stop().animate({"left":"180px","opacity":"1"},2000);
	$(".box_09_contect").stop().animate({"left":"180px","opacity":"1"},2000);
	$(".pen1").stop().animate({"right":"43px","bottom":"3%","opacity":"1"},2000);
	$(".pen2").stop().animate({"right":"285px","bottom":"5%","opacity":"1"},2000);
	$(".pen3").stop().animate({"right":"175px","bottom":"2%","opacity":"1"},2000);
}
function boxGoOut_9() {
	box6In = true;
	$(".box09_word").stop().animate({"left":"100px","opacity":"0"},2000);
	$(".erweima").stop().animate({"left":"200px","opacity":"0"},2000);
	$(".box_09_contect").stop().animate({"left":"100px","opacity":"0"},2000);
	$(".pen1").stop().animate({"right":"240px","bottom":"40px","opacity":"0"},2000);
	$(".pen2").stop().animate({"right":"240px","bottom":"50px","opacity":"0"},2000);
	$(".pen3").stop().animate({"right":"240px","bottom":"30px","opacity":"0"},2000);
}
function boxGoIn_10() {
	box6In = false;
	$(".hand").stop().animate({"top":"23%","right":"-40px","opacity":"1"},1500);
	setTimeout(function(){
		$(".campany").stop().animate({"top":"0px","left":"0px","opacity":"1"},500);
		$(".contect").stop().animate({"top":"13%","left":"0px","opacity":"1"},1000);
		$(".phone").stop().animate({"top":"26%","left":"0px","opacity":"1"},1500);
		$(".other").stop().animate({"top":"39%","left":"0px","opacity":"1"},2000);
	},1000)
	setTimeout(function(){$(".button").stop().animate({"left":"50%","opacity":"1"},1000);},2000)
}
function boxGoOut_10() {
	box6In = true;
	$(".hand").stop().animate({"top":"360px","right":"-600px","opacity":"0"},1500);
	
		$(".campany").stop().animate({"top":"0px","left":"100px","opacity":"0"},500);
		$(".contect").stop().animate({"top":"80px","left":"200px","opacity":"0"},1000);
		$(".phone").stop().animate({"top":"160px","left":"300px","opacity":"0"},1500);
		$(".other").stop().animate({"top":"240px","left":"400px","opacity":"0"},2000);
	
}
var loadImg = {
	path: 'css/',
	imgs: {
		'.b1_bg': ['b1_01.png', 'b1_02.png', 'b1_03.png', 'b1_03_btn.png', 'b1_04.png', 'b1_bg.jpg', 'b2_01.png', 'b2_03.png', 'b2_04.png', 'b2_05.png', 'b2_06.png', 'b2_bg.jpg', 'sprite.png'],
		'.b3_bg': ['b3_01.png', 'b3_bg.jpg'],
		'.b4_bg': ['b4_01.png',	'b4_02.png', 'b4_bg.jpg'],
		'.b5_bg': ['b5_01.png', 'b5_bg.jpg', 'b5_ico.png'],
		'.b6_bg': ['b6_01.png', 'b6_arrow.png', 'b6_bg.jpg', 'b6_ico.png', 'b6_img.png'],
		'.b7_bg': ['b7_bg.jpg', 'b7_sprite.png', 'map.jpg']
	},
	boxLoad: function(ele, aImgs, callback) {
		var len = aImgs.length,
			i=0, j=0, imgLoad = [];

		console.log("1" + ele);
		for (; i<len; i++) {
			(function(index) {
				imgLoad[index] = new Image();

				imgLoad[index].onload = imgLoad[index].onerror = function(index) {
					j++;
					
					if (j == len) {
						$(ele).find('img').each(function() {
							var src = $(this).attr('data-src');

							src && $(this).attr('src', src);
						});

						if (ele == '.b1_bg') {
							fnLoad();
							$('.b2_bg').find('img').each(function() {
								var src = $(this).attr('data-src');

								src && $(this).attr('src', src);
							});
							$('.b2_bg').find('.load').hide();
						}
						$(ele).find('.load').hide();
						if (callback) {
							callback();
						}
					}

					imgLoad[index].onload = imgLoad[index].onerror = null;
				};

				imgLoad[index].src = this.path + aImgs[index];
			})(i);
		}
	},
	init: function() {
		var index = 1;
		var self = this;
		var imgLoad = function() {
			self.boxLoad('.b'+ index + '_bg', self.imgs['.b'+ index + '_bg'], function() {
				index = index+1 == 2 ? 3 : index+1;

				if (index <= 7) {
					imgLoad();
				}
			});
		};

		imgLoad();
	}
}