<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cach" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<title>广告尺寸添加</title>
<link
	href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css"
	type="text/css" rel="stylesheet" />

<script type="text/javascript"
	src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>

<script type="text/javascript">
	$(function() {
		/* 全选 */
		$("#checkAllIndustry").click(function() {
			$("input[name='industryIds']").prop("checked", this.checked);
		});
		
		$("#checkAllType").click(function() {
			$("input[name='advTypeIds']").prop("checked", this.checked);
		});
	});

	$(function() {

		$("#cancelBtn")
				.click(
						function() {
							var path = "${pageContext.request.contextPath }/LeagueSize/v1/queryLeagueSizeList";
							window.location.href = path;
						});

		$("#adv_size_id").blur(
				function() {
					var size = $("input[name='advSize']").val();
					var Expression = /[1-9]\d*x{1}[1-9]\d*((-)[1-9]\d*)?$/;
					if (size == null || size == "") {
						$("#info_cue_id").html("必填项，不能为空").show();
					} else if (!Expression.test(size)) {

						$("#info_cue_id").html(
								"请输入正确的格式(宽x高-位置或宽x高)：200x200-1或200x200")
								.show();
						//$("#adv_size_id").focus();
					} else {
						$("#info_cue_id").hide();
					}
				});

		$("#saveButton")
				.click(
						function() {

							var $industryIds = $("input[name='industryIds']:checked");

							if ($industryIds.length == 0) {
								alert("请至少选中一个行业");
								return false;
							}

							var $advTypeIds = $("input[name='advTypeIds']:checked");

							if ($advTypeIds.length == 0) {
								alert("请至少选中一种广告类型");
								return false;
							}

							var size = $("input[name='advSize']").val();
							if (size == null || size == "") {
								alert("尺寸不能为空！");
								return false;
							}

							var Expression = /[1-9]\d*x{1}[1-9]\d*((-)[1-9]\d*)?$/;
							//alert(size);
							if (!Expression.test(size)) {
								$("#info_cue_id")
										.html(
												"请输入正确的格式(宽x高-位置或宽x高)：200x200-1或200x200");
								$("#info_cue_id").focus();
								return false;
							} else {
								$("#info_cue_id").hide();
							}
							
							
							$("#saveButton").attr("disabled","disabled");
							$("#saveButton").val("保存中...");
							$("#cancelBtn").attr("disabled","disabled");

							$
									.ajax({

										type : "post",
										url : "${pageContext.request.contextPath }/LeagueSize/v1/addLeagueSizeBatch",
										data : $('#add_size_form').serialize(),
										dataType : "json",

										success : function(data) {
											alert("添加成功！");
											$("#saveButton").removeAttr("disabled");
											$("#saveButton").val("保存");
											$("#cancelBtn").removeAttr("disabled");
											$(":reset").click();
											/* if(data==null||data==""){
												alert("添加成功！");
												$(":reset").click();
											}else{
												var str = "";
												for(var i = 0;i<data.length;i++){
													str += (i+1)+"、"+data[i].industryName + ">>" + data[i].typeName + ">>" + data[i].advSize + "\n";
												}
												alert(str+"\n以上数据已经存在");
												$(":reset").click();
											} */

										},
										error : function() {
											alert("添加失败！");
										}
									});
						});

	});
</script>

</head>

<body>
	<div class="t1000-votB-R-in clearfix">
		<div class="advertising-siteManagement-tit clearfix">
			<h2 class="t1000-tit">添加尺寸</h2>
		</div>
		<form id="add_size_form">
			<div class="advertising-addsize-con">
				<table class="addsize" cellpadding="0" cellspacing="0">
					<tr>
						<td class="size1">选择行业</td>
						<td class="size2">
							<ul>
								<c:forEach var="industry" items="${industryList}">
									<%-- <c:if test="${industry.paramType==1}"> --%>
									<li><input id="${industry.id}" type="checkbox"
										name="industryIds"
										value="${industry.id};${industry.paramName}" /> <label
										for="${industry.id}">${industry.paramName}</label></li>
									<%-- </c:if> --%>

								</c:forEach>
								<li style="float:right;margin-right: 1%"><input id="checkAllIndustry" type="checkbox"
									name="checkAllIndustry" value="" /> <label
									for="checkAllIndustry">全部</label></li>
							</ul>
						</td>
					</tr>
					<tr>
						<td class="size1">广告类型</td>
						<td class="size2">
							<ul>
								<c:forEach var="advType" items="${advTypeList}">
									<%-- <c:if test="${advType.paramType==0}"> --%>
									<li><input id="${advType.id}" type="checkbox"
										name="advTypeIds" value="${advType.id};${advType.paramName}" />
										<label for="${advType.id}">${advType.paramName}</label></li>
									<%-- </c:if> --%>
								</c:forEach>
								<li style="float:right;margin-right: 1%"><input id="checkAllType" type="checkbox"
									name="checkAllType" value="" /> <label for="checkAllType">全部</label></li>
							</ul>
						</td>
					</tr>
					<tr>
						<td class="size1">广告规格</td>
						<td class="size3"><input id="adv_size_id" type="text"
							placeholder="格式如(宽x高-位置或宽x高)：200x200-1或200x200" class="textInp"
							name="advSize" value="" />&nbsp;&nbsp;<span id="info_cue_id"
							style="font-size: 11pt">( * 必填)</span></td>
					</tr>
				</table>
			</div>
			<div class="advertising-save">
				<input type="reset" class="advertising-com-search-con-btn1"
					value="重置" style="display: none" />
				<c:if test="${sourceL==1}">
					<input id="cancelBtn" type="button"
						class="advertising-com-search-con-btn1" value="返回" />
				</c:if>
				<input id="saveButton" type="button"
					class="advertising-com-search-con-btn1" value="保存" />
			</div>
		</form>
	</div>
</body>
</html>
