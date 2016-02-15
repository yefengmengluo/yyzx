<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page isELIgnored="false"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="0"/> 
<title>图片广告修改</title>


<link href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css" type="text/css" rel="stylesheet"/>


<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/league/pic_ad.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/league/league.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/time/WdatePicker.js"></script>

<style>
	#imghead {filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);}
</style>
<script type="text/javascript">
/*zsl   图片修改发布*/
$(function(){
	$("#save_pic_btn").click(function(){
		 var flag = '${info.onFlag}';
		 if(flag == 0){//此数据为过去数据，不能修改
			alert("过期广告不能修改");
		 }else{
			 $("#cancel_btn").attr("disabled","true");
			 $(this).attr("disabled","true");
	         $(this).attr("value","发布中");
			var edit_url="${pageContext.request.contextPath }/league/modifyAdvPic?currentNum=${currentNum}&industryId=${industryId}&typeId=${typeId}";
			editAdvPic(this,edit_url); 
		 }
		 
	});
	
	$("#cancel_btn").click(function(){
		var query_url=
			"${pageContext.request.contextPath }/league/advInfoList?currentNum=${currentNum}&industryId=${industryId}&typeId=${typeId}";
		window.location.href=query_url;
	});
	$("#nums").keyup(function(){
		var num=$("#nums").val();
		$("#numSpan").text(num);
		
	})
	
	$("input[name='pageWidth']").click(function(){
		var pageWidth=$(this).val();
		$("#pageWidth").text(pageWidth);
		
	})
	
	
});


$(function(){
	var flag = '${info.onFlag}';
	if(flag == 0){//过去广告
		$("#fileToUpload").attr("disabled","true");
		$("#advName").attr("disabled","true");
		$("#targetUrl").attr("disabled","true");
		$("#d242").attr("disabled","true");
		$("#d241").attr("disabled","true"); 
	}
	
});
</script>

</head>

<body>
<div class="t1000-votB-R-in clearfix">
	<form id="modify_form" action="" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${info.id}"/>
    <div class="advertising-siteManagement-tit clearfix">
        <h2 class="t1000-tit">图片广告修改</h2> 
    </div>
    <div class="advertising-pic-modify">
    	<div class="advertising-pic-modify-tit"><h2 headline="">行业名称：${info.industryName}</h2></div>
        <div class="advertising-pic-modify-con">
        	<table>
            	<tr>
                	<th>${info.typeName}</th>
                </tr>
                <tr>
                	<td>
                    	<dl>
                        	<dt>
                            	<span id="preview" class="preview">
                            	<c:if test="${empty info.picUrl}"> 
   								 	<img class="imghead" id="imghead"  src="${pageContext.request.contextPath }/backstage/fodder/league/add_bg.jpg"/>
								</c:if>
								<c:if test="${!empty info.picUrl}"> 
   								 	<img id="imghead" class="imghead" src='${info.picUrl}'/> 
								</c:if>
								</span>  
                            	<input id="fileToUpload" type="file" onchange="previewImage(this)"  name="pic_file" class="file"/>       
                                <p>图片上传</p>
                                <i>${info.advSize}</i>
                            </dt>
                            <dd>
                            	<ul>
                                	<li>
                                    	<span class="aaaa">广告名称</span>
                                        <input id="advName" type="text" class="focus_on" name="advName" value="${info.advName}"/>
                                        <span id="advName_tishi" style="color:red;float:left;"></span>
                                    </li>
                                	<li>
                                    	<span class="aaaa">URL地址</span>
                                        <input id="targetUrl" type="text" placeholder="格式如：http://xxx" class="focus_on" name="targetUrl" value="${info.targetUrl}"/>
                                    	<span id="targetUrl_tishi" style="color:red;float:left;"></span>
                                    </li>
                                	<li>
                                    	<span class="aaaa">发布时间</span>
                                        
							<input id="d242" autocomplete="off" class="Wdate focus_on" type="text" name="startTime"
                    			value="<fmt:formatDate value='${info.startTime}' pattern='yyyy-MM-dd'/>"
                    			onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'d241\');}'})"/>
                    			<span id="startTime_tishi" style="color:red;float:left;"></span>
                                    </li>
                                	<li>
                                    	<span class="aaaa">结束时间</span>
                                        <input id="d241" class="Wdate focus_on " autocomplete="off"  type="text" name="endTime"
                    			value="<fmt:formatDate value='${info.endTime}' pattern='yyyy-MM-dd'/>"
                    			onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d242\');}'})"/>
                    			<span id="endTime_tishi" style="color:red;float:left;"> </span>
                                    </li>
                                </ul>
                            </dd>
                        </dl>
                    </td>
                </tr>
            </table>
        </div>
        <c:if test="${sessionScope.user.userPower ==0}">
        <div class="advertising-word-reduce-con">
                	<div class="para_div">图片个数:<input id="nums" type="text"/>
        &nbsp;&nbsp;页面宽度:&nbsp;<input name="pageWidth" type="radio" value="1000" checked="true"/>1000&nbsp;&nbsp;<input name="pageWidth" type="radio" value="1190"/>1190</div>
                	获取代码：<br/>&lt;script type="text/javascript" src="http://yyzx.99114.com/backstage/js/league/ad_league.js?pageWidth=<span id="pageWidth">1000</span>&amp;advType=0&amp;advCode=${info.advCode}&dataNum=<span id="numSpan">1</span>">&lt;/script>
                </div>
          </c:if>
    </div>
    	<div class="btn2">
    	<input id="save_pic_btn" type="button" class="advertising-com-search-con-btn1 fabu" value="发布"/>
    	<input id="cancel_btn" type="button" class="advertising-com-search-con-btn1" value="返回"/></div>
</form>
</div>

</body>
</html>
