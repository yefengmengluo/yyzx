<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文字广告修改</title>
<link href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css" type="text/css" rel="stylesheet"/>

</head>

<body>
<div class="t1000-votB-R-in clearfix">
    <div class="advertising-siteManagement-tit clearfix">
        <h2 class="t1000-tit">文字广告修改</h2> 
    </div>
     <form action="${pageContext.request.contextPath }/league/modifyWordAdv" method="post">
    	<div class="advertising-pic-modify">
    	<div class="advertising-pic-modify-tit">
    		<h2>行业名称：${industry.paramName}</h2>
    		<input id="industryId-hidden" name="industryId" type="hidden" value="${advWord.industryId}"/>
    	</div>
        <div class="advertising-word-reduce-con">
		<table class="word-in-table1" cellpadding="0" cellspacing="0">
				<tr>
	           		<td class="textInp1">
		               	<span>标题</span>
		                   <input id="titleInput" type="text" name="title" class="focus_on" value="${advWord.title}"/>
		                   <input type="hidden" name="id" class="focus_on" value="${advWord.id}"/>
		               </td>
		        </tr>
		        <tr>
	               <td class="textInp1">
		               <span>URL地址</span>
		               <input id="urlInput" type="text" name="targetUrl" class="focus_on" value="${advWord.targetUrl}"/>
	               </td>
	            </tr>
	            <tr>
		           	<td class="textInp2">
		               	<span>发布时间</span>
		                   <input id="d11" type="text" name="startTime" class="Wdate focus_on" value="<fmt:formatDate value='${advWord.startTime}' pattern='yyyy-MM-dd'/>" 
		                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'d12\');}'})"/>
		               </td>
		         </tr>
		         <tr>
	               <td class="textInp2">
	               	<span>结束时间</span>
	                   <input id="d12" type="text" name="endTime" class="Wdate focus_on" value="<fmt:formatDate value='${advWord.endTime}' pattern='yyyy-MM-dd'/>" 
	                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d11\');}'})"/>
	               </td>
	               </tr>
	               <tr>
	               		<td class="textInp3">
	               			<span>序列号</span>
	               			<input id="orderNumInput" type="text" name="orderNum" value="${advWord.orderNum}" class="paixuhao" />
			               	
	               		</td>
	               </tr>
	               <tr>
	               		<td>
							<span class="red" <c:if test="${advWord.redFlag == 1}">style="color:#f00"</c:if>>标红</span>
			               	<input type="checkbox" name='redFlag' class="single" value="1" <c:if test="${advWord.redFlag == 1}">checked="checked"</c:if>/>	               		
	               		</td>
	               </tr>
	               <tr>
	               <td class="btn">
	                   <input id="sunmitBtn" type="submit" value="发布" class="fabu1" />
	                   <input type="button" class="fabu1" value="返回" onclick="javascript:history.go(-1)"/>
	               </td>
	           </tr>
	      </table>
                </div>
                <div class="advertising-word-reduce-con">
                	<div class="para_div">广告条数:<input id="nums" type="text" style="width: 5%;text-align: center;"/>
						&nbsp;&nbsp;页面宽度:&nbsp;<input name="pageWidth" type="radio" value="1000" checked="checked"/>1000&nbsp;&nbsp;<input name="pageWidth" type="radio" value="1190"/>1190</div>
	                	获取代码：<br/>&lt;script type="text/javascript" src="http://yyzx.99114.com/backstage/js/league/ad_league.js?pageWidth=<span id="pageWidth">1000</span>&amp;advType=1&amp;advCode=${industry.id}_0_0&dataNum=<span id="numSpan">1</span>">&lt;/script>
                	</div>		
				</div>
   	<!-- <div class="button">
   		<input type="button" class="advertising-com-search-con-btn1" value="返回" onclick="javascript:history.go(-1)"/>
   	</div> -->
	</form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/league/right.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/time/WdatePicker.js"></script>
<script type="text/javascript">


//表单提交校验
$(function(){
	$("#sunmitBtn").click(function(){
		var title = $("#titleInput").val();
		var url = $("#urlInput").val();
		var startTime = $("#d11").val();
		var endTime = $("#d12").val();
		var orderNum = $("#orderNumInput").val();
		var strRegex = '^((https|http|ftp|rtsp|mms)?://)'
		    + '?(([0-9a-z_!~*\'().&=+$%-]+: )?[0-9a-z_!~*\'().&=+$%-]+@)?' //ftp的user@
		    + '(([0-9]{1,3}.){3}[0-9]{1,3}' // IP形式的URL- 199.194.52.184
		    + '|' // 允许IP和DOMAIN（域名）
		    + '([0-9a-z_!~*\'()-]+.)*' // 域名- www.
		    + '([0-9a-z][0-9a-z-]{0,61})?[0-9a-z].' // 二级域名
		    + '[a-z]{2,6})' // first level domain- .com or .museum
		    + '(:[0-9]{1,4})?' // 端口- :80
		    + '((/?)|' // a slash isn't required if there is no file name
		    + '(/[0-9a-z_!~*\'().;?:@&=+$,%#-]+)+/?)$';
		
		var re=new RegExp(strRegex);
		
		//验证标题
		if(title == ""){
			alert("请输入广告标题");
			return false;
		}
		//验证url
		if(!re.test(url)){
			alert("请输入正确的地址");
			return false;
		}
		if(startTime == '' || endTime == ''){
			alert("请选择开始时间和结束时间");
			return false;
		}
		
		if(!/^[0-9]*$/.test(orderNum)){
			alert("排序号必须为数字!");
			return false;
		}
	});
});

//动态url生成
$(function(){
	$("#nums").keyup(function(){
		var num=$("#nums").val();
		$("#numSpan").text(num);
	});
	
	$("input[name='pageWidth']").click(function(){
		var pageWidth=$(this).val();
		$("#pageWidth").text(pageWidth);
	});
});
</script>
</body>
</html>
