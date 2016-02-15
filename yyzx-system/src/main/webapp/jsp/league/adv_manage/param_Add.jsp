<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:if test="${paramType==0}">
	<title>Param_Add | 添加行业</title>
</c:if>
<c:if test="${paramType==1}">
	<title>Param_Add | 添加广告类型</title>
</c:if>

<link
	href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css"
	type="text/css" rel="stylesheet" />

<link
	href="${pageContext.request.contextPath }/backstage/css/league/addParam.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath }/backstage/js/league/right.js"></script>

<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
		
		$("#cancelBtn").click(function(){
			location.href = "${pageContext.request.contextPath }/LeagueSize/v1/queryLeagueSizeList";
		});
		

		$("#addLeagueParam")
				.click(
						function() {
							var paramName = $("#paramName").val().trim();
							var paramType = "${paramType}";
							if (paramName != "") {
								$
										.ajax({
											url : "${pageContext.request.contextPath }/LeaguePram/addLeaguePram/"
													+ paramType,
											type : "POST",
											data : {
												"paramName" : paramName
											},
											success : function(data) {
												if (data == "0") {
													/* $("#checkInfo").html("添加成功").show(); */
													alert("保存成功");
													location.reload();
												} else if (data == "1") {
													/* $("#checkInfo").html("行业已存在或其他").show(); */
													if (paramType == 0) {
														alert("行业名称已经存在");
													}
													if (paramType == 1) {
														alert("广告类型名称已经存在");
													}
												} else if (data == "2") {
													alert("保存失败");
												}
											},
											error : function(XMLHttpRequest,
													textStatus, errorThrown) {
												alert("保存失败！");
											}

										});

							} else {
								if (paramType == 0) {
									alert("请输入行业名称");
								}
								if (paramType == 1) {
									alert("请输入广告类型名称");
								}
								return false;
							}
						});

	});

	
	$(function() {

		$(".modify_btn")
				.click(
						function() {
							var $v = $(this).parent().siblings(".vote_w3");
							var vHtml = "<input style='width:50%; margin:0 auto;border:1px solid #0432e1; background:#fff;font-size:14px;'  value='"
									+ $v.text().trim() + "' type='text'>";
							$v.html(vHtml);
							$(this).hide();
							$(this).siblings(".save_btn").css({
								"color" : "#ff5a00"
							}).show();

						});

		$(".save_btn").click(function() {
			
			var paramType = "${paramType}";
			
			var $v = $(this);
			var $vTd = $v.parent();
			var $vW3 = $vTd.siblings(".vote_w3");
			var $vW1 = $vTd.siblings(".vote_w1");
			
			var paramName = $vW3.children(":input").val().trim();
			var paramId = $vW1.children(":input").val();
			
			if(paramName!=null&&paramName!=""){
					$
					.ajax({
						url : "${pageContext.request.contextPath}/LeaguePram/modifyLeaguePram/"
								+ paramType,
						type : "POST",
						data : {
							"id":paramId,
							"paramName" : paramName
						},
						success : function(data) {
							if (data == "0") {
								//alert("保存成功");
								$vW3.empty();
								$vW3.html(paramName);
								$v.hide();
								$v.siblings(".modify_btn").show();
							} else if (data == "1") {
								if (paramType == 0) {
									alert("行业名称已经存在");
								}
								if (paramType == 1) {
									alert("广告类型名称已经存在");
								}
								
							} else if (data == "2") {
								alert("保存失败");
								
							}else if(data == "3"){
								$vW3.empty();
								$vW3.html(paramName);
								$v.hide();
								$v.siblings(".modify_btn").show();
							}
						},
						error : function(XMLHttpRequest,
								textStatus, errorThrown) {
							alert("保存失败！");
						}

					});
			}else{
				if (paramType == 0) {
					alert("行业名称不能为空,请输入");
					$vW3.children(":input").focus();
				}
				if (paramType == 1) {
					alert("广告类型名称不能为空,请输入");
					$vW3.children(":input").focus();
				}
			}
		});
	});
	
	//删除行业、类型
	function delParam(id){
		var v = '${paramType}';
		$
		.ajax({
			url : "${pageContext.request.contextPath}/LeaguePram/querySizeCountByParamId",
			type : "POST",
			data : {
				"id":id,
				"paramType":v
			},
			success : function(data) {
				//alert(data);
				if(data == "no"){//no没有
					if(confirm("温馨提示：行业类型谨慎删除\n确定删除吗？")){
						deleteParam(id);
					}
				}else if(data == "pic"){//1有
					if(v == 0){
						alert("该行业正在被使用，请先删除尺寸信息！");
					}else if(v == 1){
						alert("该类型正在被使用，请先删除尺寸信息！");
					}
					
				}else if(data == "word"){
					alert("该行业正在被使用，请先删除此行业下的文字广告信息！");
				}else if(data == "fail"){
					alert("删除失败");
				}
			},
			error : function(XMLHttpRequest,
					textStatus, errorThrown) {
				alert("删除失败！");
			}

		});
	}
	
	
	function deleteParam(id){
		var v = '${paramType}';
		var s = '${sourceL}';//1从广告管理进入    0从菜单进入
		location.href = "${pageContext.request.contextPath}/LeaguePram/delLeaguePram?id="+id+"&paramType="+v+"&sourceL="+s;
	}
	
</script>
</head>
<body>
	<div class="t1000-votB-R-in clearfix">
		<div class="advertising-siteManagement-tit clearfix">
			<c:if test="${paramType==0}">
				<h2 class="t1000-tit">添加行业</h2>
			</c:if>
			<c:if test="${paramType==1}">
				<h2 class="t1000-tit">添加广告类型</h2>
			</c:if>

		</div>
		<div class="advertising-addcorporation-con">
			<div class="advertising-com-search-con clearfix">
				<c:if test="${paramType==0}">
					<h2>行业名称</h2>
				</c:if>
				<c:if test="${paramType==1}">
					<h2>广告类型名称</h2>
				</c:if>
				<!-- 失去焦点检测行业名称是否存在 -->
				<label><input id="paramName" type="text"
					class="advertising-com-search-con-text focusBlur grayTips" value="" /></label>
				<input id="addLeagueParam" type="button"
					class="advertising-com-search-con-btn1" value="保存" />
					<c:if test="${sourceL==1}">
						<!-- 从广告管理进入 -->
						<input id="cancelBtn" type="button"
						class="advertising-com-search-con-btn1" value="返回" />
					</c:if>
					
			</div>
			<table class="memberList t1000-siteManagement" cellpadding="0"
				cellspacing="0">
				<tr>
					<th class="vote_w1">编号</th>
					<c:if test="${paramType==0}">
						<th class="vote_w3">行业名称</th>
					</c:if>
					<c:if test="${paramType==1}">
						<th class="vote_w3">广告类型名称</th>
					</c:if>

					<th class="vote_w4">添加时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${leagueParams}" var="leagueParam" varStatus="vs">
					<tr <c:if test="${vs.index%2==0}">bgcolor="#e1ecfa"</c:if>
						onmouseover="this.style.backgroundColor='#e1ecfa'"
						onmouseout="this.style.backgroundColor=''">
						<td class="vote_w1">${vs.index+1}<input type="hidden" value="${leagueParam.id}"></input></td>
						<td class="vote_w3">${leagueParam.paramName}</td>
						<td class="vote_w4"><fmt:formatDate
								value="${leagueParam.createTime}" type="date" /></td>
						<!-- data -->
						<td width="*"><a class="modify_btn" href="javascript:;">修改</a>
							<a class="save_btn" href="javascript:;" style="display: none;">保存</a>
							<c:if test="${sessionScope.user.userPower == 0}">
								<a class="delete" href="javascript:delParam('${leagueParam.id}');">删除</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>