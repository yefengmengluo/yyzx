<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html>
<head>
<%
String path1 = request.getContextPath();
String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path1+"/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会员信息管理</title>
<link
	href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css"
	type="text/css" rel="stylesheet" />

</head>

<body>
	<div class="t1000-votB-R-in clearfix">
		<div class="t1000-com-search-con clearfix">
			<span>输入公司名称</span>
			<form  id="select_form" action="${pageContext.request.contextPath}/VoteCompany/v1/selectCompanyList" method="post">
	            <label><input id="keyWord" type="text" class="t1000-com-search-con-text focusBlur grayTips" name="keyWord" value="${keyWord}"/></label>
	            <input type="submit" class="t1000-com-search-con-btn1" value="搜索"/>
            </form>
			<input
				type="button" class="t1000-com-search-con-btn3" onclick="toAddCompany(0)" value="添加企业" />
		</div>
		
		<table id="dataTable" class="memberList" cellpadding="0"
			cellspacing="0">
			<tr>
				<th class="w1"><input id="checkedAll" name="checkedAll"
					type="checkBox">全选</th>
				<th class="w2">公司名称</th>
				<th class="w3">品牌名称</th>
				<th class="w4">加入时间</th>
				<th class="w6">状态</th>
				<th class="w7">投票主题</th>
				<th width="*">操作类型</th>
			</tr>
			<c:forEach items="${page.pageList}" var="company" varStatus="status">
				<tr>
					<td class="w1"><input name="companyList[]" type="checkBox"
						value="${company.copId}" /></td>
					<td class="w2">${company.copName}</td>
					<td class="w3">${company.copBrand}</td>
					<td class="w4"><fmt:formatDate value="${company.addTime}"
							pattern="yyyy-MM-dd" /></td>
					<td class="w6"><c:if test="${company.status==0}">
							<span class="memSate_colse">关闭</span>
						</c:if> <c:if test="${company.status==1}">
							<span class="memSate_open">开启</span>
						</c:if></td>
					<td class="w7">${company.voteName}</td>
					<td width="*"><a class="setData" href='javascript:toModifyCompany("${company.copId}")'>设置基本资料</a><a
						class="del"
						href="javascript:delComOne('${company.copId}','${company.status}','${company.copName}','${company.copBrand}')">删除</a></td>
				</tr>

			</c:forEach>
		</table>

		<!-- 分页 -->
		<div class="t1000-vote-pageCon">
			<div class="t1000-vote-pager">
				<c:if test="${page.currentNum == 1 }">
					<a>上一页</a>
				</c:if>
				<c:if test="${page.currentNum != 1 }">
					<a title="" href="javascript:toPage('${page.currentNum-1}')">&lt;&lt;上一页</a>
				</c:if>

				<c:forEach begin="1" end="${page.maxPage}" step="1" varStatus="s"
					var="i">
					<c:choose>
						<c:when test="${i==page.currentNum }">
							<a class="on" href="javascript:toPage('${i}')">${i}</a>
						</c:when>
						<c:when test="${page.currentNum-2>i &&i==3}">
							<a href="">&hellip;</a>
						</c:when>
						<c:when
							test="${i!=page.currentNum &&i<3||i>page.currentNum-3&&i<page.currentNum+3||i>=page.maxPage-1}">
							<a href="javascript:toPage('${i}')">${i}</a>
						</c:when>
						<c:when test="${page.currentNum+3==i&&i<page.maxPage-1}">
							<a href="">&hellip;</a>
						</c:when>
					</c:choose>
				</c:forEach>

				<c:if test="${page.currentNum!=page.maxPage }">
					<a href="javascript:toPage('${page.currentNum+1}')">下一页&gt;&gt;</a>
				</c:if>
				<c:if test="${page.currentNum==page.maxPage }">
					<a>下一页</a>
				</c:if>
			</div>
		</div>


		<div class="t1000-batch-btn clearfix">
			<span> <input type="button" class="t1000-batch-btn1"
				value="信息推荐" /> <input id="batchDelete" type="button"
				class="t1000-batch-btn2" value="批量删除" />
			</span>
		</div>
	</div>

	<!-- 信息推荐弹出框 -->
	<div class="bookingBlackBg"></div>
	<div class="bookingBox">
		<div class="bookingTit">
			<h3>请选择主题</h3>
			<span></span>
		</div>
		<div content="">
			<ul id="vote_table_ul" class="t1000-themeBox">
				
			</ul>
			<div class="t1000-theme-btnBox">
				<input class="t1000-theme-btn" type="button" value="确定" />
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/backstage/js/t1000/right.js"></script>

	<script type="text/javascript">
	//跳转到修改页面
	function toModifyCompany(copId) {
		var newUrl = '${pageContext.request.contextPath}/VoteCompany/v1/toModifyCompany?copId='+copId;
		window.location.href = newUrl;
	}
	
	
		//通过ajax查询主题信息列表
		function getVoteTableByAjax() {
			$
					.ajax({
						type : "get",
						url : "${pageContext.request.contextPath}/VoteCompany/v1/queryVoteTable_company",
						dataType : "json",
						success : function(data) {
							var tr = "";
							$("#vote_table_ul").empty();
							for (var i = 0; i < data.length; i++) {
								tr += '<li><input type="radio" name="vote_theme" value="'
								+ data[i].id
								+'"/>'   
										+ data[i].vSubject + '</li>';
							}
							document.getElementById("vote_table_ul").innerHTML = tr;
						}
					});

		}

		//信息推荐弹出框
		$(function() {
			
			var rc;//选中主题的id

			Boxpos();
			$(window).resize(function() {
				Boxpos();
			})

			$(".t1000-batch-btn1").click(function() {
				getVoteTableByAjax();
				var boxScroll = $(document).scrollTop();
				$(".bookingBlackBg,.bookingBox").show();
				$(".bookingBox").css("top", parseInt(boxTT + boxScroll - 50));
				btn_index = $(this).parent().parent().index();
			})

			$(".t1000-theme-btn").click(function() {
				rc = $("input[type='radio']:checked").val();
				if (rc == null || rc == "") {
					alert("请选择一条主题，或者退出");
				} else {
					$(".bookingBlackBg,.bookingBox").hide();
					selectCompany(rc);
				}
			})

			$(window).scroll(function() {
				Boxpos();
				var boxScroll = $(document).scrollTop();
				$(".bookingBox").css("top", parseInt(boxTT + boxScroll));
			})

			$(".bookingTit span").click(function() {
				$(".bookingBox").hide();
				$(".bookingBlackBg").hide();
			});

		});

		//信息推荐--选中的会员
		//voteId:投票主题ID
		function selectCompany(voteId) {
			var $cks = $("input[name='companyList[]']:checked");

			if ($cks.length == 0) {
				alert("请至少选中一家公司...");
				return;
			}
			var ids = new Array();//符合条件的id集合,关闭状态，可以推荐
			var strNo = "";//不符合条件的数据，获取每条数据由公司名字和品牌，然后组合成字符串,开启状态，不可以推荐
			var strYes = "";
			$cks.each(function() {
				var $tr = $(this).parent().parent();
				
				if ($.trim($tr.children(".w6").children().text())=="开启") {
					var str = $tr.children(".w2").text() + ">>"
							+ $tr.children(".w3").text() + "\n";
					strNo += str;
				} else {
					ids.push($(this).attr("value"));
					
					var str2 = $tr.children(".w2").text() + ">>"
							+ $tr.children(".w3").text() + "\n";
					strYes += str2;
				}

			});

			if (strNo.length != 0) {
				alert(strNo + "\n以上已经处于参与投票状态 ");
			}

			if (strYes.length == 0) {
				alert("请选择需要推荐的数据。。");
				return;
			}

			strYes = strYes + "\n以上是未参与投票的数据，确定推荐么？";
			if (confirm(strYes)) {
				updateCompanyStatus(voteId,ids);
			}
		}

		//信息推荐
		/* $(function() {
			$("#info_recommend").click(
					function() {
						var $cks = $("input[name='companyList[]']:checked");

						if ($cks.length == 0) {
							alert("请至少选中一条...");
							return;
						}
						var ids = new Array();//符合条件的id集合,关闭状态，可以推荐
						var strNo = "";//不符合条件的数据，获取每条数据由公司名字和品牌，然后组合成字符串,开启状态，不可以推荐
						var strYes = "";
						$cks.each(function() {
							var tr = $(this).parent().parent();
							if ($.trim(tr.children(".w6").text())
									.contains("开启")) {
								var str = tr.children(".w2").text() + ">>"
										+ tr.children(".w3").text() + "\n";
								strNo += str;
							} else {
								ids.push($(this).attr("value"));
								var str2 = tr.children(".w2").text() + ">>"
										+ tr.children(".w3").text() + "\n";
								strYes += str2;
							}

						});

						if (strNo.length != 0) {
							alert(strNo + "\n以上已经处于参与投票状态 ");
						}

						if (strYes.length == 0) {
							alert("请选择需要推荐的数据。。");
							return;
						}

						strYes = strYes + "\n以上是未参与投票的数据，确定推荐么？"
						if (confirm(strYes)) {
							updateCompanyStatus(ids);
						}
					});

		}); */

		//信息推荐
		function updateCompanyStatus(voteId,idStr) {

			$
					.ajax({
						type : "get",
						url : "${pageContext.request.contextPath}/VoteCompany/v1/modifyCompanyStatus",
						data : {
							idStr : idStr.toString(),
							status : 1,
							voteId:voteId
						},
						success : function(data) {
							if (data == "success") {

								alert("推荐成功！");
								//刷新当前页面
								location.reload();
							} else {
								alert("推荐失败");
							}
						}
					});

		}

		//批量删除
		$(function() {
			$("#batchDelete").click(
					function() {
						var $cks = $("input[name='companyList[]']:checked");

						if ($cks.length == 0) {
							alert("请至少选中一条数据删除...");
							return;
						}

						var ids = new Array();//符合条件的id集合,关闭状态，可以删除
						var strNo = "";//不符合条件的数据，获取每条数据由公司名字和品牌，然后组合成字符串,开启状态，不可以删除
						var strYes = "";
						$cks.each(function() {
							var $tr = $(this).parent().parent();
							if ($.trim($tr.children(".w6").children().text())
									==("开启")) {
								var str = $tr.children(".w2").text() + ">>"
										+ $tr.children(".w3").text() + "\n";
								strNo += str;
							} else {
								ids.push($(this).attr("value"));
								var str2 = $tr.children(".w2").text() + ">>"
										+ $tr.children(".w3").text() + "\n";
								strYes += str2;
							}

						});

						if (strNo.length != 0) {
							alert(strNo + "\n以上处于参与投票状态 , 禁止删除");
						}

						if (strYes.length == 0) {
							alert("请选择需要删除的数据。。");
							return;
						}

						strYes = strYes + "\n以上是未参与投票的数据，确定删除么？"
						if (confirm(strYes)) {
							deleteCompany(ids);
						}
					});

		});

		//删除一条记录
		function delComOne(id, status, copName, copBrand) {
			if (status == 1) {
				alert(copName + ">>" + copBrand + "\n\n正在参与投票, 禁止删除！");
				return;
			}
			if (confirm("是否将删除此条信息?")) {
				deleteCompany(id);
			}
		}

		//删除操作
		function deleteCompany(idStr) {

			$
					.ajax({
						type : "get",
						url : "${pageContext.request.contextPath}/VoteCompany/v1/removeCompany",
						data : {
							idStr : idStr.toString()
						},
						success : function(data) {
							if (data == "success") {
								alert("删除成功！");
								$("input[name='checkedAll']").prop("checked",false);
								$("input[name='companyList[]']").prop("checked",false);
								//刷新当前页面
								location.reload();
							} else {
								alert("删除失败");
							}
						}
					});

		}
		//跳转到指定页
		function toPage(pageNum) {
			//var keyWord = document.getElementById("keyWord").value;
			var newUrl = '${pageContext.request.contextPath}/VoteCompany/v1/selectCompanyList?';
			newUrl += 'currentNum=' + pageNum;
			$("#select_form").attr("action", newUrl);
			$("#select_form").submit();
			//window.location.href = newUrl;
		}

		//跳转到添加品牌页面
		function toAddCompany(voteId) {
			var newUrl = '${pageContext.request.contextPath}/VoteCompany/v1/toAddCompany?source=0&voteId='+voteId;
			window.location.href = newUrl;
		}
			
	</script>
</body>
</html>
