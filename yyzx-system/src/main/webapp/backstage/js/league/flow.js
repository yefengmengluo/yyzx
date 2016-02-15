// JavaScript Document
$(function(){
	$(".a_1").click(function(){
		$(this).addClass("current").siblings().removeClass("current");	
	})
	$(".flow-analysis tr.h").hover(function(){
		$(this).addClass("on").siblings().removeClass("on");	
	})
	$(".detail-content .listManage tr.h").hover(function(){
		$(this).addClass("on").siblings().removeClass("on");	
	})
	$(".ind-query-con .listManage tr.h").hover(function(){
		$(this).addClass("on").siblings().removeClass("on");	
	})
})



function initTabStatus(isInputStr,beginDateStr,endDateStr){
	isInput=isInputStr;
	beginDate=new Date(beginDateStr);
	endDate=new Date(endDateStr);
	if(isInputStr==true){
		$("#beginDate").val(beginDate.Format("yyyy-MM-dd"));
		$("#endDate").val(endDate.Format("yyyy-MM-dd"));
		return;
	}
	var now=new Date();
	//今天第一秒
	now.setHours(0);
	now.setMinutes(0);
	now.setSeconds(0);
	now.setMilliseconds(0);
	//七天
	var weekDay = new Date(now.valueOf()-7*24*60*60*1000);
	//30天
	var mouthDay = new Date(now.valueOf()-30*24*60*60*1000);
	var startDateMilln=beginDate.getTime();
	$(".a_1").removeClass("current");
	if(startDateMilln>now.getTime()){
		$(".a_1:eq(0)").addClass("current");
	
	}else if(startDateMilln>weekDay.getTime()){
		$(".a_1:eq(1)").addClass("current");
		
	}else{
		$(".a_1:eq(2)").addClass("current");
		
	}
	
}



function doQuery(isInputStr,index,adId,currentNum){
	var beginDate;
	var endDate;
	isInput=isInputStr;
	if(isInput==true){
		beginDate=$("#beginDate").val();
		endDate=$("#endDate").val();
		var firstUrl=getFirstUrl();
		var newUrl=firstUrl+"/LeagueAdTrafficTab/queryAdTrafficByKeywordPaged?adId="+adId+"&currentNum="+currentNum
		+"&beginDate="+beginDate+"&endDate="+endDate+"&isInput="+isInput+"&urlParam="+$("#urlParam").val();
	
	}else{
		clearInputTime();
		var today=new Date();
		//今天第一秒
		/*today.setHours(0);
		today.setMinutes(0);
		today.setSeconds(0);
		today.setMilliseconds(0);
		
		endDate=new Date(today.valueOf()+1*24*60*60*1000);*/
		endDate=today;
		
		if(index==0){
			beginDate=today;
		}else if(index==1){
			 beginDate=new Date(today.valueOf()-7*24*60*60*1000);
		}else if(index==2){
			beginDate=new Date(today.valueOf()-30*24*60*60*1000);
		}

		var firstUrl=getFirstUrl()
		var newUrl=firstUrl+"/LeagueAdTrafficTab/queryAdTrafficByKeywordPaged?adId="+adId+"&currentNum="+currentNum
		+"&beginDate="+beginDate.Format("yyyy-MM-dd")+"&endDate="+endDate.Format("yyyy-MM-dd")+"&isInput="+isInput+"&urlParam="+$("#urlParam").val();
	
	};
	location.href=newUrl;
}
function getFirstUrl(){
	var urlArr = window.location.host;
	if(urlArr){
		return "http://"+urlArr;
	}else{
		return "yyzx.99114.com";
	}
}
function clearInputTime(){
	$("#beginDate").val('');
	$("#endDate").val('');
}

//对Date的扩展，将 Date 转化为指定格式的String
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
//例子： 
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
Date.prototype.Format = function (fmt) { //author: meizz 
var o = {
   "M+": this.getMonth() + 1, //月份 
   "d+": this.getDate(), //日 
   "h+": this.getHours(), //小时 
   "m+": this.getMinutes(), //分 
   "s+": this.getSeconds(), //秒 
   "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
   "S": this.getMilliseconds() //毫秒 
};
if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
for (var k in o)
if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
return fmt;
}



var Expression2 = '^((https|http|ftp|rtsp|mms)?://)'

	+ '?(([0-9a-z_!~*\'().&=+$%-]+: )?[0-9a-z_!~*\'().&=+$%-]+@)?' //ftp的user@

	+ '(([0-9]{1,3}.){3}[0-9]{1,3}' // IP形式的URL- 199.194.52.184

	+ '|' // 允许IP和DOMAIN（域名）

	+ '([0-9a-z_!~*\'()-]+.)*' // 域名- www.

	+ '([0-9a-z][0-9a-z-]{0,61})?[0-9a-z].' // 二级域名

	+ '[a-z]{2,6})' // first level domain- .com or .museum

	+ '(:[0-9]{1,4})?' // 端口- :80

	+ '((/?)|' // a slash isn't required if there is no file name

	+ '(/[0-9a-z_!~*\'().;?:@&=+$,%#-]+)+/?)$';



/*行业单品条件验证*/
$(function(){
	$("strong").hide();
	
	$("#siteUrl").blur(function(){
		var Expression = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
		var siteUrl = $("#siteUrl").val();
		
		if (siteUrl == "" || siteUrl == "http://") {
			
			$("#siteUrl").css({
				"border" : "1px solid red"
			});
			$("#siteUrl_tishi").hide();
		}else{
			
			if (!Expression.test(siteUrl)){
				$("#siteUrl").css({
					"border" : "1px solid red"
				});
				$("#siteUrl_tishi").hide();
			}else{
				$("#siteUrl").css({"border":"1px solid #dfdfdf"});
				$("#siteUrl_tishi").show();
			}
			
		}
		
	});
	
	$("#siteName").blur(function(){
		var siteName = $("#siteName").val();
		if (siteName == "") {
			$("#siteName").css({
				"border" : "1px solid red"
			});
			$("#siteName_tishi").hide();
		}else{
			$("#siteName").css({"border":"1px solid #dfdfdf"});
			$("#siteName_tishi").show();
		}
		
	});
	
	$("#industry_id").change(function(){
		var industryId = $("#industry_id").val();
		if (industryId == 0) {
			$("#industry_id").css({
				"border" : "1px solid red"
			});
			$("#industryId_tishi").hide();
		}else{
			$("#industry_id").css({"border":"1px solid #dfdfdf"});
			$("#industryId_tishi").show();
		}
		
	});
	
	$("#jdBelong").blur(function(){
		var jdBelong = $("#jdBelong").val();
		if (jdBelong == "") {
			$("#jdBelong").css({
				"border" : "1px solid red"
			});
			$("#jdBelong_tishi").hide();
		}else{
			$("#jdBelong").css({"border":"1px solid #dfdfdf"});
			$("#jdBelong_tishi").show();
		}
		
	});
	
	$("#optPerson").blur(function(){
		var optPerson = $("#optPerson").val();
		if (optPerson == "") {
			$("#optPerson").css({
				"border" : "1px solid red"
			});
			$("#optPerson_tishi").hide();
		}else{
			$("#optPerson").css({"border":"1px solid #dfdfdf"});
			$("#optPerson_tishi").show();
		}
		
	});
	
	$("#saveButton").click(
			function() {
				$("#saveButton").attr("disabled", "disabled");
				$("#saveButton").val("保存中...");
				$("#cancelBtn").attr("disabled", "disabled");

				var Expression = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
				var industryId = $("#industry_id").val();
				var siteName = $("#siteName").val();
				var siteUrl = $("#siteUrl").val();
				var jdBelong = $("#jdBelong").val();
				var optPerson = $("#optPerson").val();

				if (industryId == 0 || siteName == "" || siteUrl == "" || siteUrl == "http://"
						|| jdBelong == "" || optPerson == "") {
					if (industryId == 0) {
						$("#industry_id").css({
							"border" : "1px solid red"
						});
					}
					if (siteName == "") {
						$("#siteName").css({
							"border" : "1px solid red"
						});
					}
					if (siteUrl == "" || siteUrl == "http://") {
						$("#siteUrl").css({
							"border" : "1px solid red"
						});
					}
					if (jdBelong == "") {
						$("#jdBelong").css({
							"border" : "1px solid red"
						});
					}
					if (optPerson == "") {
						$("#optPerson").css({
							"border" : "1px solid red"
						});
					}
					alert("请先完善信息");
					$("#saveButton").removeAttr("disabled");
					$("#saveButton").val("保存");
					$("#cancelBtn").removeAttr("disabled");
				} else if (!Expression.test(siteUrl)) {
					alert("网址格式不正确！请重新填写！如：http://99114.com");
					$("#industry_id").css({"border":"1px solid #dfdfdf"});
					$("#siteName").css({"border":"1px solid #dfdfdf"});
					$("#jdBelong").css({"border":"1px solid #dfdfdf"});
					$("#optPerson").css({"border":"1px solid #dfdfdf"});
					$("#siteUrl").css({
						"border" : "1px solid red"
					});
					$("#siteUrl").focus();
					$("#saveButton").removeAttr("disabled");
					$("#saveButton").val("保存");
					$("#cancelBtn").removeAttr("disabled");
				} else {
					ajaxAddWebSite();
				}
		});

});








