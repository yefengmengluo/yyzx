<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cach" /> 
<meta http-equiv="cache-control" content="no-cache" /> 
<meta http-equiv="expires" content="0" />
<link href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css" type="text/css" rel="stylesheet"/>

<title>广告管理</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath }/backstage/js/league/right.js"></script>
<script type="text/javascript">

$(function(){
	
	$("#size_btn").click(function(){
		var path = "${pageContext.request.contextPath }/LeagueSize/v1/toAddLeagueSize/1";
		window.location.href=path;
	});
	
	$("#industry_btn").click(function(){
		var path = "${pageContext.request.contextPath }/LeaguePram/queryLeaguePram/0/1";//前 0 代表行业   后0代表从菜单列表进入   1代表从广告管理进入
		window.location.href=path;
	});
	
	$("#type_btn").click(function(){
		var path = "${pageContext.request.contextPath }/LeaguePram/queryLeaguePram/1/1"; //1 代表类型 后0代表从菜单列表进入   1代表从广告管理进入
		window.location.href=path;
	});
	
	
	
	$(".t1000-tit input").click(function(){
		var newUrl = "${pageContext.request.contextPath }/LeagueSize/v1/advSizeList";
    	location.href = newUrl;
	});
});


</script>


</head>

<body>
<div class="t1000-votB-R-in clearfix">
	<div class="advertising-siteManagement-tit clearfix">
		<h2 class="t1000-tit">广告管理<input type="button" style="width:60px;height:37px;float: right;filter:alpha(opacity=0);cursor: pointer;opacity: 0;"/></h2> 
		
	</div>
	<div class="advertising-manage-con">
		<div class="advertising-manage-search-con">
			<!-- <h3 headline="">请输入类型名称</h3>
			<input type="text" class="manage-textInp" />
			<input type="button" class="manage-btn1" value="搜索" /> -->
			<input id="industry_btn" type="button" class="manage-btn2" value="添加行业" style="cursor: pointer"/>
			<input id="type_btn" type="button" class="manage-btn3" value="添加类型" style="cursor: pointer"/>
			<input id="size_btn" type="button" class="manage-btn2" value="添加尺寸" style="cursor: pointer"/>
		</div>
		<table class="manageList" cellpadding="0" cellspacing="0">
			<tr>
				<c:if test="${fn:length(pramList) != 0}">
					<th class="m1">广告类型</th>
				</c:if>
				<c:forEach items="${pramList}" var="industry" varStatus="status">
					<th class="m3">${industry.paramName}</th>
						
				</c:forEach>
			</tr>
			 <c:forEach items="${typeList}" var="type_list" varStatus="status">
					<tr>
						<td class="m1">${type_list.paramName}</td>
						<c:forEach items="${pramList}" var="industry">
							<td class="m3" id="${'league-'}${industry.id}${'-'}${type_list.id}">
								<c:forEach items="${list}" var="inte">
									<c:if test="${inte.industryId==industry.id&&inte.typeId==type_list.id}">
										${inte.sizeListStr}
									</c:if>
								</c:forEach>
							</td>
						</c:forEach>
					</tr>
			</c:forEach>
		</table>
	</div>
</div>
<script type="text/javascript">
</script>
</body>
</html>
