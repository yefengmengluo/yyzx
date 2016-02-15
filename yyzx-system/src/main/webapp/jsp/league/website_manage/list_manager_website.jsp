<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文字广告列表</title>
<link href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css" type="text/css" rel="stylesheet"/>

</head>

<body>
<div class="t1000-votB-R-in clearfix">
    <div class="advertising-siteManagement-tit clearfix">
        <h2 class="t1000-tit">行业单品列表</h2> 
    </div>
    <div class="advertising-listManage-con">
        <form id="select_form" action="${pageContext.request.contextPath }/LeagueWebsite/queryLeagueWebsite" method="post">
	        <div class="advertising-listManage-consearch1">
	        	<span>
	            	根据行业搜索
	            	<c:if test="${empty industrys}">
	            		<select id="industryId" name="industryId">
	                		<option>暂无行业信息</option>
	                	</select>
	            	</c:if>
	            	<c:if test="${!empty industrys}">
		                <select id="industryId" name="industryId">
		                	<option selected="selected" value="">全部广告行业</option>
		                	<c:forEach items="${industrys}" var="industry">
		                		<c:if test="${industry.id == industryId}">
			                		<option value="${industry.id}" selected="selected">${industry.paramName}</option>
		                		</c:if>
		                		<c:if test="${industry.id != industryId}">
			                		<option value="${industry.id}">${industry.paramName}</option>
		                		</c:if>
		                	</c:forEach>
		                </select> 
	            	</c:if>
	            </span>
	            <input type="submit" class="advertising-com-search-con-btn1" value="查询"/>
	        	<input type="button" class="advertising-com-search-con-btn1" onclick="saveExel()" value="导出"/>
	        </div>
        </form>
        <table class="listManage1" cellpadding="0" cellspacing="0">
			 <tr>
             	<th class="lm_3_1">行业名称</th>
             	<th class="lm_2_1">单品名称</th>
             	<th class="lm_3_1">基地名称</th>
             	<th class="lm_3_1">添加人</th>
             	<th class="lm_3_1">操作</th>
             </tr> 
             
             <c:forEach items="${page.pageList}" var="website">
	             <tr>
	             	<td class="lm_1_1">${website.industryName}</td>
			        <td class="lm_2_1" title="${website.siteName}"><a target="_blank" href="${website.siteUrl}">${website.siteName}</a></td>
	             	
			        <td class="lm_3_1">
			        	${website.jdBelong}
			        </td>
			        <td class="lm_3_1">
			        	${website.optPerson}
			        </td>
			        	
	                
	                <td>
	                	<a href="javascript:toWebsiteEdit('${website.id}','${page.currentNum}')" class="change">查看</a>
	                	<a href="javascript:delWebsite('${website.id}','${page.currentNum}')" class="delete">删除</a>
	                </td>
	             </tr>
             </c:forEach>
        </table>
    </div>
    
     <!-- 处理分页 -->
    <div class="t1000-vote-pageCon">
    	<div class="t1000-vote-pager">
    		
    		<a title="" href="javascript:toPage(1)">首页</a>
    		
   			<c:forEach begin="1" end="${page.maxPage}" step="1" varStatus="s" var="i">
				<c:choose>
				<c:when test="${i==page.currentNum }">
					<a class="on" href="javascript:toPage(${s.index})">${i}</a>
				</c:when>
				<c:when test="${page.currentNum-2>i &&i==3}">
					<a href="">&hellip;</a>
				</c:when>
				<c:when test="${i!=page.currentNum &&i<3||i>page.currentNum-3&&i<page.currentNum+3||i>=page.maxPage-1}">
					<a href="javascript:toPage(${s.index})">${i}</a>
				</c:when>
				<c:when test="${page.currentNum+3==i&&i<page.maxPage-1}">
					<a href="" id="hellip">&hellip;</a>
				</c:when>
				</c:choose>
			</c:forEach>

    		<a title="" href="javascript:toPage(${page.maxPage})">末页</a>
    		
    	</div>
    </div>
    
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/league/right.js"></script>
<script type="text/javascript">
	
//页面跳转
function toPage(currentNum) {
	var industryId = document.getElementById("industryId").value;
	var newUrl ="${pageContext.request.contextPath }/LeagueWebsite/queryLeagueWebsite?&industryId="
			+industryId + '&currentNum=' + currentNum;
	location.href=newUrl;
}

function toWebsiteEdit(id,currentNum){
	var industryId = document.getElementById("industryId").value;
	var newUrl ="${pageContext.request.contextPath }/LeagueWebsite/selectLeagueWebsiteById?id="+id+'&currentNum=' + currentNum;
	location.href=newUrl;
}

function delWebsite(id,currentNum){
	var industryId = document.getElementById("industryId").value;
	if(confirm("确定删除吗？")){
		var newUrl ="${pageContext.request.contextPath }/LeagueWebsite/delLeagueWebsite?id="+id+"&industryIdPage="
		+industryId + '&currentNum=' + currentNum;
		location.href=newUrl;
	}
}

function saveExel(){
	var url="${pageContext.request.contextPath }/LeagueWebsite/downloadWebsites";
    window.open(url);
}
</script>
</body>
</html>
