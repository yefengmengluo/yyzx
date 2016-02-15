<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主题投票信息管理</title>
<link
	href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css"
	type="text/css" rel="stylesheet" />
</head>

<body>


	<div class="t1000-votB-R-in clearfix">
		<div class="t1000-com-search-con clearfix">
			<h2>${table.vSubject }</h2>
			<span>输入品牌</span>
			<form  id="select_form" action="${pageContext.request.contextPath}/VoteItem/v1/selectVoteItemList" method="post">
	            <label>
	            <input id="keyWord" type="text" class="t1000-com-search-con-text focusBlur grayTips" name="keyWord" value="${keyWord}"/>
	            <input id="voteId" type="hidden" name="voteId" value="${voteId}"/>
	            </label>
	            <input type="submit" class="t1000-com-search-con-btn1" value="搜索"/>
            </form>
			
				
			<input
				type="button" class="t1000-com-search-con-btn2" onclick="toAddCompany('${voteId}');" value="添加企业" />
				
				<input
				type="button" id="sort_btn" class="t1000-com-search-con-btn3" value="排序" />
				
		</div>
		<input type="hidden" value="${voteId}"/>
		<table class="memberList subjectTab" cellpadding="0" cellspacing="0">
			<tr>
				<th class="w1"><input id="checkedAll" name="checkedAll"
					type="checkbox">全选</th>
				<th class="vote_w5">投票品牌名称</th>
				<th class="vote_w2">排名</th>
				<th class="vote_w3">票数</th>
				<th>操作</th>
			</tr>
			
			<c:forEach items="${page.pageList}" var="item" varStatus="status">
			<tr>
				<td class="w1"><input name="companyList[]" type="checkbox" value="${item.id}"/></td>
				<td class="vote_w5">${item.vdTitle}</td>
				<td class="vote_w2">${item.itemSort}</td>
				<td class="vote_w3">${item.vdCount}</td>
				<td width="*"><a class="setData" href="javascript:void(0)"
					name="setData">编辑票数</a> <a class="setData"
					href="${pageContext.request.contextPath }/CommentController/queryAllCommentByViId?viId=${item.id}&tag=1">评论管理</a>
					<a class="del" href="Javascript:delComOne('${item.id}');">移除</a></td>
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
				value="信息移除" /> <input type="button" class="t1000-batch-btn2"
				value="返回" onclick="returnPage()"/>
			</span>
		</div>

	</div>

	<div class="bookingBlackBg"></div>
	<div class="bookingBox">
		<div class="bookingTit">
			<h3>票数修改</h3>
			<span></span>
		</div>
		<div content="">
			<div class="vote_num">
				票数<input class="new_vote" type="text" value="" />
			</div>
			<div class="vote_btn">
				<input type="button"
					class="t1000-com-search-con-btn1 t1000-edit-vote" value="编辑票数" /> <input
					type="submit" class="t1000-com-search-con-btn2 t1000-edit-close"
					value="关闭" />
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/backstage/js/t1000/right.js"></script>
	<script type="text/javascript">
	
	//跳转到指定页
	function toPage(pageNum) {
		//var keyWord = document.getElementById("keyWord").value;
		var newUrl = '${pageContext.request.contextPath}/VoteItem/v1/selectVoteItemList?';
		newUrl += 'currentNum=' + pageNum;
		$("#select_form").attr("action", newUrl);
		$("#select_form").submit();
	}
	
	//批量删除
	$(function() {
		$(".t1000-batch-btn1").click(
				function() {
					var $cks = $("input[name='companyList[]']:checked");

					if ($cks.length == 0) {
						alert("请至少选中一条数据删除...");
						return;
					}

					var ids = new Array();//符合条件的id集合
					$cks.each(function() {
						ids.push($(this).attr("value"));
					});

					if (confirm("确认删除品牌信息吗？")) {
						deleteCompany(ids);
					}
				});

	});

	//删除一条记录
	function delComOne(id) {
		if (confirm("确认删除此条信息?")) {
			deleteCompany(id);
		}
	}

	//删除操作
	function deleteCompany(idStr) {
		$.ajax({
					type : "get",
					url : "${pageContext.request.contextPath}/VoteItem/v1/removeItem",
					data : {
						idStr : idStr.toString()
					},
					success : function(data) {
						if (data == "success") {
							alert("删除成功！");
							//刷新当前页面
							location.reload();
						} else {
							alert("删除失败");
						}
					}
				});

	}
	function returnPage(){
		var vId=$("#vId").val();
		location.href = "${pageContext.request.contextPath }/vote/voteList";
	    
	}
	
	
		$(function() {
			var eleWidth = $(document).width();
			var eleHeight = $(document).height();
			var winHeight = $(window).height();
			var btn_index = 0;
			var boxWW = $(".bookingBox").width();
			var boxHH = $(".bookingBox").height();
			var boxLL = (eleWidth - boxWW) / 2;
			var boxTT = (winHeight - boxHH) / 2;

			$(".bookingBlackBg").css("height", eleHeight);
			$(".bookingBox").css("left", parseInt(boxLL));

			$("[name='setData']").click(function() {
				var boxScroll = $(document).scrollTop();
				
				btn_index = $(this).parent().parent().index();
				var $count = $(".subjectTab tr").eq(btn_index).find(".vote_w3");
				var v = $count.html();
				$(".new_vote").val(v);
				
				$(".bookingBlackBg,.bookingBox").show();
				$(".bookingBox").css("top", parseInt(boxTT + boxScroll - 50));
				

			})
			$(".bookingTit span").click(function() {
				$(".bookingBlackBg,.bookingBox").hide();
				$(".new_vote").html("");
			})
			$(window).scroll(function() {
				var boxScroll = $(document).scrollTop();
				$(".bookingBox").css("top", parseInt(boxTT + boxScroll));
			})

			$(".t1000-edit-vote").click(function() {
				$(".bookingBox").hide();
				$(".bookingBlackBg").hide();
			});
			
			$(".t1000-edit-close").click(function() {
				$(".bookingBox").hide();
				$(".bookingBlackBg").hide();
				$(".new_vote").html("");
			});
			/*更改变更后的票数*/
			$(".t1000-edit-vote").click(
					function() {
						var new_vote = $(".new_vote").val();
						if(new_vote==null||new_vote == ""){
							alert("票数不能为空！");
							return;
						}
						var viId = $(".subjectTab tr").eq(btn_index).find(".w1").find("input").val();
						modifyCount(viId,new_vote);
						$(".subjectTab tr").eq(btn_index).find(".vote_w3")
								.html(new_vote);
					});
			/*限制只能输入数字*/
			$(".new_vote").keyup(function() {
				$(this).val($(this).val().replace(/\D|^0/g, ''));
			}).bind("paste", function() {
				$(this).val($(this).val().replace(/\D|^0/g, ''));
			}).css("ime-mode", "disabled");
		})
		
		
		function modifyCount(viId,new_vote){
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/VoteItem/v1/modifyCount",
				data : {
					id: viId,
					vdCount:new_vote
				},
				success : function(data) {
					if (data == "success") {
						alert("编辑成功！");
						//刷新当前页面
						location.reload();
					} else {
						alert("编辑失败");
						return;
					}
				}
			});
		}
		

		//跳转到添加品牌页面
		function toAddCompany(voteId) {
			var newUrl = '${pageContext.request.contextPath}/VoteCompany/v1/toAddCompany?source=1&voteId='+voteId;
			window.location.href = newUrl;
		}
		
		$(function(){
			//排序
			$("#sort_btn").click(function(){
				var sortUrl = '${pageContext.request.contextPath}/VoteItem/v1/sortItem?voteId=${voteId}';
				$
				.ajax({
					type : "get",
					url : sortUrl,
					success : function(data) {
						if (data == "success") {
							alert("排序成功！");
							$("#keyWord").val("");
							toPage(1);
							//刷新当前页面
							//location.reload();
						} else {
							alert("排序失败");
						}
					}
				});
			});
		});
			
	</script>
</body>
</html>
