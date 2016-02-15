<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>行业单品添加</title>
<link
	href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css"
	type="text/css" rel="stylesheet" />
<link
	href="${pageContext.request.contextPath }/backstage/css/league/detail.css"
	type="text/css" rel="stylesheet" />
	
<script type="text/javascript"
	src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/backstage/js/league/flow.js"></script>

<script type="text/javascript">

//页面跳转
function toPage(currentNum) {
	var industryId = document.getElementById("industryId").value;
	var likeParam=$("#titleKeyWod").val();
	if(likeParam=="请输入网站URL、网站名称、基地名称等搜索条件"){
		likeParam="";
	}
	var newUrl ="${pageContext.request.contextPath }/LeagueWebsite/queryLeagueWebsite?&industryId="
			+industryId + '&currentNum=' + currentNum+"&likeParam="+likeParam;
	location.href=newUrl;
}

function toWebsiteEdit(id,currentNum){
	var newUrl ="${pageContext.request.contextPath }/LeagueWebsite/selectLeagueWebsiteById?id="+id+'&currentNum=' + currentNum;
	location.href=newUrl;
}

function toAddWebSite(){
	var newUrl ="${pageContext.request.contextPath }/LeagueWebsite/toAddIndustryWebSite/1";
	location.href=newUrl;
}

function delWebsite(id,currentNum){
	var likeParam=$("#titleKeyWod").val();
	if(likeParam=="请输入网站URL、网站名称、基地名称等搜索条件"){
		likeParam="";
	}
	var industryId = document.getElementById("industryId").value;
	if(confirm("确定删除吗？")){
		var newUrl ="${pageContext.request.contextPath }/LeagueWebsite/delLeagueWebsite?id="+id+"&industryId="
		+industryId + '&currentNum=' + currentNum+'&likeParam='+likeParam;
		location.href=newUrl;
	}
}

function saveExel(){
	var likeParam=$("#titleKeyWod").val();
	if(likeParam=="请输入网站URL、网站名称、基地名称等搜索条件"){
		likeParam="";
	}
	var industryId=$("#industryId").val();
	var url="${pageContext.request.contextPath }/LeagueWebsite/downloadWebsites?industryId="+industryId+"&likeParam="+likeParam;
  window.open(url);
}

//添加鼠标事件
function excelImport() {
	
	$("#importBtn").attr("disabled", "disabled");
	
	var a=document.createEvent("MouseEvents");
    a.initEvent("click", true, true); 
    var f = document.getElementById("importExcel");
    f.dispatchEvent(a);
}
//单品导入
$(function() {
	$("#importExcel").change(function() {
		if(window.confirm("确认导入“"+this.value+"”吗？")){
			$(".motai").css("display","block");
			$("#excelForm").submit();
		}else{
			$("#importBtn").removeAttr("disabled");
			$(".motai").css("display","none");
		}
	});
})
function doQuery(){
	var likeParam=$("#titleKeyWod").val();
	if(likeParam=="请输入网站URL、网站名称、基地名称等搜索条件"){
		$("#titleKeyWod").val("");
	}
	$("#queryForm").submit();
}
</script>
<style type="text/css">
	.red-text a{
	color:#0432e1;
		text-decoration: underline;
	}
	.red-text a:hover{
		color:#0432e1;
		text-decoration: none;
	}
	.motai { width:100%; height:100%; z-index:10; position:absolute;display: none}
	.motai-con { width:100%; height:100%; background:#000; opacity:0.1; filter:alpha(opacity=10);  position:absolute;}
	.motai-img { position:absolute; top:40%; left:40%; z-index:2;padding: 0 auto;}
	
	#titleKeyWod{width:300px}
	.detail-title-left span{display:block;float:left;height: 26px;line-height:26px;}

	.detail-left {width:40%; height:26px; margin-right:16px;}
	.detail-left select{ height:26px; line-height:26px; border:1px solid #dfdfdf; color:#252525; padding-left:10px;}

</style>
</head>

<body>
<div class="motai">
	<div class="motai-con"></div>
	<div class="motai-img"><%-- <img src="${pageContext.request.contextPath }/backstage/images/league/webSite/loading.gif"/> --%>
	<p style="font-size: 22px;font-weight: bold;">请稍等，数据导入中...</p></div>
</div>

	<div class="t1000-votB-R-in clearfix">
		<div class="advertising-siteManagement-tit clearfix">
			<h2 class="t1000-tit">行业单品查询</h2>
		</div>
		<div class="detail-content">
			<form id="queryForm" action="${pageContext.request.contextPath }/LeagueWebsite/queryLeagueWebsite">
				<div class="detail-left floatL">
					<c:if test="${!empty industrys}">
						<span><select id="industryId" name="industryId">
							<option selected="selected" value="0">全部广告行业</option>
							<c:forEach items="${industrys}" var="industry">
								<c:if test="${industry.id == industryId}">
									<option value="${industry.id}" selected="selected">${industry.paramName}</option>
								</c:if>
								<c:if test="${industry.id != industryId}">
									<option value="${industry.id}">${industry.paramName}</option>
								</c:if>
							</c:forEach>
						</select></span>
					</c:if>
					<c:choose>
						<c:when test="${!empty likeParam}">
							<span style="padding-left:24px"><input style="height: 25px" type="text"  value="${likeParam}"
							 onclick="if(this.value == '请输入网站URL、网站名称、基地名称等搜索条件') this.value='';" 
							 onblur="if(this.value=='') this.value='请输入网站URL、网站名称、基地名称等搜索条件';"
							 name="likeParam" id="titleKeyWod"></input></span>
						</c:when>
						<c:otherwise> 
							<span style="padding-left:24px"><input style="height: 25px" type="text" value="请输入网站URL、网站名称、基地名称等搜索条件"
							 onclick="if(this.value == '请输入网站URL、网站名称、基地名称等搜索条件') this.value='';" 
							 onblur="if(this.value=='') this.value='请输入网站URL、网站名称、基地名称等搜索条件';"
							 name="likeParam" id="titleKeyWod"></input></span>
						</c:otherwise>
					</c:choose>
				</div>
				
				<div class="detail-content-btn floatL" >
					<input type="submit" onclick="doQuery()" class="detail-search-btn floatL" value="查询" style="cursor: pointer;"/>
					<input type="button" value="单品添加" class="detail-search-btn floatL" onclick="toAddWebSite()" style="cursor: pointer;"/>
					<input type="button" value="单品导出" class="detail-search-btn floatR" onclick="saveExel()" style="cursor: pointer;"/>
					<input type="button" id="importBtn" value="单品导入" class="detail-search-btn floatR" onclick="excelImport()" style="cursor: pointer;"/>
				</div>
			</form>
			<form action="${pageContext.request.contextPath }/LeagueWebsite/excelImport" id="excelForm" method="post" style="display: none;" enctype="multipart/form-data">
					<input type="file" id="importExcel" name="file"/>
				</form>
			<div class="cls"></div>
			<div class="ind-query-con">
				<table class="listManage" cellpadding="0" cellspacing="0">
					<tr>
						<th class="">序号</th>
						<th class="iq_1">行业名称</th>
						<th class="iq_2">单品名称</th>
						<th class="iq_1">基地名称</th>
						<th class="iq_1">添加人</th>
						<th>操作</th>
					</tr>

					<c:forEach items="${page.pageList}" var="website" varStatus="status">
						<tr class="h">
							<td>${status.index + 1}</td>
							<td class="iq_1">${website.industryName}</td>
							<td class="iq_2 red-text" title="${website.siteUrl}"><a
								target="_blank" href="${website.siteUrl}">${website.siteName}</a></td>

							<td class="iq_1">${website.jdBelong}</td>
							<td class="iq_1 green-text">${website.optPerson}</td>


							<td><a class="detail"
								href="javascript:toWebsiteEdit('${website.id}','${page.currentNum}')">修改</a>
								<a
								href="javascript:delWebsite('${website.id}','${page.currentNum}')"
								class="delete">删除</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
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

</body>
</html>
