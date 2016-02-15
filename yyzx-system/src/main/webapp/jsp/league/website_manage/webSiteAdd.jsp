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
	var result = true;
	function checkOptPerson() {
		var optPerson = $("#optPerson").val();
		$("#optPerson").parent().find('strong').remove();
		if (optPerson == "") {
			//alert("请输入操作人姓名");
			result = false;
		} else {
			$("#optPerson").parent().append('<strong>输入正确</strong>');
		}
	}
	function checkJdBelong() {
		var jdBelong = $("#jdBelong").val();
		$("#jdBelong").parent().find('strong').remove();
		if (jdBelong == "") {
			//alert("请输入基地名称");
			result = false;
		} else {
			$("#jdBelong").parent().append('<strong>输入正确</strong>');
		}
	}

	function checkSiteName() {
		var siteName = $("#siteName").val();
		$("#siteName").parent().find('strong').remove();
		if (siteName == "") {
			//alert("请输入单品名称");
			result = false;
			//$("#jdBelong").parent().append('<strong>请输入单品名称</strong>');
			//return false;
		} else {
			$("#siteName").parent().append('<strong>输入正确</strong>');
		}
	}

	function checkIndustryId() {
		var industryId = $("#industryId").val();
		$("#industryId").parent().parent().find('strong').remove();
		if (industryId == "") {
			//	alert("请选择行业");
			result = false;
		} else {
			$("#industryId").parent().parent().append('<strong>输入正确</strong>');
		}
	}

	function checkSiteUrl() {
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

		var re = new RegExp(strRegex);

		$("#siteUrl").parent().find('strong').remove();
		if (!re.test(siteUrl)) {
			//alert("请输入正确的地址");
			result = false;
		} else {
			$("#siteUrl").parent().append('<strong>输入正确</strong>');
		}
	}
	/* 	$.ajax({
		    url:"${pageContext.request.contextPath }/LeagueWebsite/addLeagueWebsite",
		    type: "POST",
			dataType : "json",
		 	data:{"industryId":industryId,"siteUrl":siteUrl,"siteName":siteName,
		    	"optPerson":optPerson,"jdBelong":jdBelong},
		    success:function(data){
		    	var executeStatus = data;
		    	if(data == "success"){
		    		alert("发布成功");
		    	}else{
		    		alert("发布失败");
		    	}
		    }
		}); */
	function doCheck() {
		$("strong").remove();
		result = true;
		checkSiteUrl();
		checkSiteName();
		checkIndustryId();
		checkJdBelong();
		checkOptPerson();
		if (result) {
			$("#addForm").submit();
		}else{
			alert("error");
		}
	}
	$(function() {
		//初始化行业下拉列表
		$
				.ajax({
					url : "${pageContext.request.contextPath }/LeagueWebsite/queryIndustry",
					type : "POST",
					dataType : "json",
					success : function(data) {
						var executeStatus = data;
						if (data != null & data.length > 0) {
							var datasize = data.length;
							var str = "<select id='industryId' onchange='checkIndustryId()' name='industryId'>"
							for (var i = 0; i < datasize; i++) {
								str += "<option value='"+data[i].id+"'>";
								str += data[i].paramName;
								str += "</option>";
							}
							str += "</select>";
							$("#industrySelect").html(str);
						} else {
							//alert("发布失败");
						}

					}
				});

	});
	function goBack() {
		var backUrl = "${pageContext.request.contextPath }/LeagueWebsite/queryLeagueWebsite";
		location.href = backUrl;
	}
</script>
</head>
<body>
	<div class="t1000-votB-R-in clearfix">

		<div class="advertising-siteManagement-tit clearfix">
			<h2 class="t1000-tit">行业单品添加</h2>
		</div>

		<div class="detail-content">
			<form id="addForm"
				action="${pageContext.request.contextPath }/LeagueWebsite/addLeagueWebsite"
				method="post">
				<table class="listManage ind_add" cellpadding="0" cellspacing="0">
					<tr>
						<td class="ia_1"><span>行业名称</span></td>
						<td class="ia_2"><span id="industrySelect"></span> <span>(*必填)</span>
						</td>
					</tr>
					<tr>
						<td class="ia_1"><span>单品名称</span></td>
						<td class="ia_2"><input onchange="checkSiteName()"
							name="siteName" id="siteName" type="text" class="focus_on" /> <span>(*必填)</span>
						</td>
					</tr>
					<tr>
						<td class="ia_1"><span>url链接</span></td>
						<td class="ia_2"><input onchange="checkSiteUrl()"
							name="siteUrl" id="siteUrl" type="text" class="focus_on"
							value="http://" /> <span>(*必填)</span></td>
					</tr>
					<tr>
						<td class="ia_1"><span>基地</span></td>
						<td class="ia_2"><input onchange="checkJdBelong()"
							name="jdBelong" id="jdBelong" type="text" class="focus_on" /> <span>(*必填)</span>
						</td>
					</tr>
					<tr>
						<td class="ia_1"><span>添加人姓名</span></td>
						<td class="ia_2"><input id="optPerson"
							onchange="checkOptPerson()" name="optPerson" type="text"
							class="paixuhao" /> <span>(*必填)</span></td>
					</tr>

				</table>
				<div class="ind-add-btn">
					<input type="button" onclick="doCheck()"
						class="detail-search-btn floatL" class="detail-search-btn floatL"
						value="提交" /> <input type="button" onclick="goBack()"
						class="detail-search-btn floatL"  value="返回" />
				</div>
			</form>
		</div>


	</div>

</body>
</html>
