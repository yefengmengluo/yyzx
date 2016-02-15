<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta   http-equiv= "Pragma"   content= "no-cache" />
<meta   http-equiv= "Cache-Control"   content= "no-cache" />
<meta   http-equiv= "Expires"   content= "0" /> 
<title>流量统计列表</title>
<link href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css" type="text/css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath }/backstage/css/league/detail.css" type="text/css" rel="stylesheet"/>
<style type="text/css">

</style>
</head>
<body>
<div class="t1000-votB-R-in clearfix">
    <div class="advertising-siteManagement-tit clearfix">
        <h2 class="t1000-tit floatL">广告类型</h2> 
        <span class="floatR">总流量：${totalFlow}</span>
    </div>
    <div class="detail-content">
        <table class="listManage flow-list" cellpadding="0" cellspacing="0">
			 <tr>
				<th style="width:50px">序号</th>	
				<th class="dc_2">广告位类型</th>
             	<th class="dc_1">广告位尺寸</th>
             	<th class="dc_1">访问总流量</th>
             	<th>操作</th>
             </tr> 
             
             <c:forEach items="${advSpacePage.pageList}" var="advCountList" varStatus="status">
	             <tr class="h">
					<td>${status.index+1}</td>
					<td class="dc_2 red-text">${advCountList.typeName }</td>
	             	<td class="dc_1">${advCountList.advSize }</td>
	               	<td class="dc_1">${advCountList.visitCount }</td>
			        <td class="dc_3"><a href="javascript:toDetail('${advCountList.sizeCode }','${advCountList.typeName }','${advCountList.advSize }','${advCountList.advType }')">详细</a></td>
	             </tr>
             </c:forEach>                   	
        </table>
    </div>
    <!-- 处理分页 -->
    <div class="t1000-vote-pageCon">
    	<div class="t1000-vote-pager">
    		
    		<a title="" href="javascript:toPage(1)">首页</a>
    		
   			<c:forEach begin="1" end="${advSpacePage.maxPage}" step="1" varStatus="s" var="i">
				<c:choose>
				<c:when test="${i==advSpacePage.currentNum }">
					<a class="on" href="javascript:toPage(${s.index})">${i}</a>
				</c:when>
				<c:when test="${advSpacePage.currentNum-2>i &&i==3}">
					<a href="">&hellip;</a>
				</c:when>
				<c:when test="${i!=advSpacePage.currentNum &&i<3||i>advSpacePage.currentNum-3&&i<advSpacePage.currentNum+3||i>=advSpacePage.maxPage-1}">
					<a href="javascript:toPage(${s.index})">${i}</a>
				</c:when>
				<c:when test="${advSpacePage.currentNum+3==i&&i<advSpacePage.maxPage-1}">
					<a href="" id="hellip">&hellip;</a>
				</c:when>
				</c:choose>
			</c:forEach>

    		<a title="" href="javascript:toPage(${advSpacePage.maxPage})">末页</a>
    		
    	</div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/league/flow.js"></script>
<script type="text/javascript">
	//页面跳转
	function toPage(currentNum) {
		var newUrl ="${pageContext.request.contextPath }/LeagueAdTrafficTab/queryTrafficCount?currentNum=" + currentNum;
		location.href = newUrl;
	}
	
	function toDetail(sizeCode,typeName,advSize,advType){
		var currentNum = "${advSpacePage.currentNum}";
		if(advType == 1){//文字广告
			advSize = "";
		}
		location.href = "${pageContext.request.contextPath }/LeagueAdTrafficTab/queryTrafficCountBySizeCode?sizeCode="+sizeCode
		+"&advSpace="+typeName+" "+advSize+"&industryId=0&selectDate=0&advType="+advType+"&keyWord="+"&currentNum="+currentNum;
	};
</script>

</body>
</html>