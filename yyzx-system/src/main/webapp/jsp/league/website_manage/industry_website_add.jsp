<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta   http-equiv= "Pragma"   content= "no-cache" />
<meta   http-equiv= "Cache-Control"   content= "no-cache" />
<meta   http-equiv= "Expires"   content= "0" /> 
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
	/* 返回列表 */
	function goBack() {
		var backUrl = "${pageContext.request.contextPath }/LeagueWebsite/queryLeagueWebsite?currentNum=1";
		location.href = backUrl;
	}
	/* 添加保存 */
	function ajaxAddWebSite() {
		$
				.ajax({

					type : "post",
					url : "${pageContext.request.contextPath }/LeagueWebsite/addLeagueWebsite",
					data : $('#addForm').serialize(),
					dataType : "json",

					success : function(data) {
						$("#saveButton").removeAttr("disabled");
						$("#saveButton").val("提交");
						$("#cancelBtn").removeAttr("disabled");
						if (data == 0) {//添加成功
							alert("添加成功！");
							//$(":reset").click();
							//$("strong").hide();
							location.href = "${pageContext.request.contextPath }/LeagueWebsite/queryLeagueWebsite?currentNum=1";
						} else if (data == 1) {//此单品网已经存在
							$("#siteName").css({
								"border" : "1px solid red"
							});
							$("#siteName_tishi").hide();
							var siteName = $("#siteName").val();
							alert(siteName + " 已经存在");
						} else {
							alert("添加失败");
						}
					},
					error : function() {
						alert("添加失败！");
					}
				});
	};
</script>
</head>

<body>
	<div class="t1000-votB-R-in clearfix">
		<div class="advertising-siteManagement-tit clearfix">
			<h2 class="t1000-tit">行业单品添加</h2>
		</div>
		<form id="addForm" action="" method="">
			<div class="detail-content">
				<table class="listManage ind_add" cellpadding="0" cellspacing="0">
					<tr>
						<td class="ia_1">行业名称</td>
						<td class="ia_2"><select id="industry_id" name="industryId">
								<option selected="selected" value="0">请选择广告行业</option>
								<c:forEach items="${industrys}" var="industry">
									<option value="${industry.id}">${industry.paramName}</option>
								</c:forEach>
						</select> <span>*</span> <strong id="industryId_tishi"></strong></td>
					</tr>
					<tr>
						<td class="ia_1">单品名称</td>
						<td class="ia_2"><input id="siteName" type="text"
							name="siteName" /> <span>*</span> <strong id="siteName_tishi"></strong></td>
					</tr>
					<tr>
						<td class="ia_1">URL链接</td>
						<td class="ia_2"><input id="siteUrl" type="text"
							value="http://" name="siteUrl" /> <span>*</span> <strong id="siteUrl_tishi"></strong>
						</td>
					</tr>
					<tr>
						<td class="ia_1">基地</td>
						<td class="ia_2"><input id="jdBelong" type="text"
							name="jdBelong" /> <span>*</span> <strong id="jdBelong_tishi"></strong></td>
					</tr>
					<tr>
						<td class="ia_1">添加人姓名</td>
						<td class="ia_2"><input id="optPerson" type="text"
							name="optPerson" /> <span>*</span> <strong id="optPerson_tishi"></strong></td>
					</tr>
				</table>
				<div class="ind-add-btn">
					<input id="saveButton" type="button" value="提交"
						class="detail-search-btn floatL" style="cursor: pointer;" />
					<c:if test="${sourceL == 1}">
						<input id="cancelBtn" type="button" value="返回"
							class="detail-search-btn floatL" style="cursor: pointer;"
							onclick="goBack();" />
					</c:if>
					<!-- <input type="reset" value="重置" style="display: none" /> -->
				</div>
			</div>
		</form>
	</div>
</body>
</html>
