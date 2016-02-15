<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文字广告</title>
<link
	href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css"
	type="text/css" rel="stylesheet" />
<link
	href="${pageContext.request.contextPath }/backstage/css/league/detail.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/backstage/js/league/right.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/backstage/js/time/WdatePicker.js"></script>
<script type="text/javascript">
var result=true;
function checkOptPerson(){
		var optPerson=$("#optPerson").val();
		$("#optPerson").parent().find('strong').remove();
		if(optPerson==""){
			//alert("请输入操作人姓名");
			result=false;
		}else{
			$("#optPerson").parent().append('<strong>输入正确</strong>');
		}
	}
	function checkJdBelong(){
		var jdBelong=$("#jdBelong").val();
		$("#jdBelong").parent().find('strong').remove();
		if(jdBelong==""){
			//alert("请输入基地名称");
			result=false;
			//return false;
		}else{
			$("#jdBelong").parent().append('<strong>输入正确</strong>');
		}
	}
	
	function checkSiteName(){
		var siteName=$("#siteName").val();
		$("#siteName").parent().find('strong').remove();
		if(siteName==""){
			//alert("请输入单品名称");
			result=false;
			//$("#jdBelong").parent().append('<strong>请输入单品名称</strong>');
			//return false;
		}else{
			$("#siteName").parent().append('<strong>输入正确</strong>');
		}
	}
	
	function checkIndustryId(){
		var industryId=$("#industryId").val();
		$("#industryId").parent().find('strong').remove();
		if(industryId==""){
		//	alert("请选择行业");
			result=false;
		}else{
			$("#industryId").parent().append('<strong>输入正确</strong>');
		}
	}
	
	function checkSiteUrl(){

	 var siteUrl = $("#siteUrl").val();
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

		$("#siteUrl").parent().find('strong').remove();
		if(!re.test(siteUrl)){
			//alert("请输入正确的地址");
			result=false;
		}else{
			$("#siteUrl").parent().append('<strong>输入正确</strong>');
		}
	}
	function doCheck(){
		result=true;
		checkSiteUrl(); 
		checkSiteName(); 
		checkIndustryId(); 
		checkJdBelong(); 
		checkOptPerson();
		if(result){
			$("#addForm").submit();
		}
	}
	function goBack(){
		var  industryIdPage="${industryIdPage}";
		var currentNum="${currentNum}";
		var backUrl="${pageContext.request.contextPath }/LeagueWebsite/queryLeagueWebsite?currentNum="+currentNum+"&industryId="+industryIdPage;
		location.href=backUrl;
	}
</script>
</head>
<body>
	<div class="t1000-votB-R-in clearfix">

		<div class="advertising-siteManagement-tit clearfix">
			<h2 class="t1000-tit">行业单品修改</h2>
		</div>

		<div class="detail-content">
			<form id="addForm"
				action="${pageContext.request.contextPath }/LeagueWebsite/modifyLeagueWebsite"
				method="post">
				<table class="listManage ind_add" cellpadding="0" cellspacing="0">
					<tr>
						<td class="ia_1"><span>行业名称</span></td>
						<td class="ia_2"><input type="hidden" name="currentNum"
							id="currentNum" value="${currentNum}"></input> <input
							type="hidden" name="industryIdPage" id="industryIdPage"
							value="${industryId}"></input> <select name="industryId"
							onchange='checkIndustryId()' id="industryId">
								<option selected="selected" value="-1">全部广告行业</option>
								<c:forEach items="${industrys}" var="industry">
									<c:if test="${industry.id == leagueWebsite.industryId}">
										<option value="${industry.id}" selected="selected">${industry.paramName}</option>
									</c:if>
									<c:if test="${industry.id != leagueWebsite.industryId}">
										<option value="${industry.id}">${industry.paramName}</option>
									</c:if>
								</c:forEach>
						</select> <span>(*必填)</span></td>
					</tr>
					<tr>
						<td class="ia_1"><span>单品名称</span></td>
						<td class="ia_2"><input type="hidden" name="id" id="id"
							value="${leagueWebsite.id}"></input> <input name="siteName"
							id="siteName" onchange="checkSiteName()" type="text"
							class="focus_on" value="${leagueWebsite.siteName}" /> <span>(*必填)</span>
						</td>
					</tr>
					<tr>
						<td class="ia_1"><span>url链接</span></td>
						<td class="ia_2"><input name="siteUrl"
							onchange="checkSiteUrl()" value="${leagueWebsite.siteUrl}"
							id="siteUrl" type="text" class="focus_on" value="http://" /></td>
					</tr>
					<tr>
						<td class="ia_1"><span>基地</span></td>
						<td class="ia_2"><input name="jdBelong"
							onchange="checkJdBelong()" value="${leagueWebsite.jdBelong} "
							id="jdBelong" type="text" class="focus_on" /></td>
					</tr>
					<tr>
						<td class="ia_1"><span>添加人姓名</span></td>
						<td class="ia_2"><input name="optPerson"
							onchange="checkOptPerson()" value="${leagueWebsite.optPerson}"
							type="text" class="paixuhao" /></td>
					</tr>
				</table>
				<div class="ind-add-btn">
					<input type="button" onclick="doCheck()"
						class="detail-search-btn floatL" class="detail-search-btn floatL"
						value="提交" /> <input type="button" onclick="goBack()"
						class="detail-search-btn floatL" value="返回" />
				</div>
			</form>
		</div>
	</div>

</body>
</html>
