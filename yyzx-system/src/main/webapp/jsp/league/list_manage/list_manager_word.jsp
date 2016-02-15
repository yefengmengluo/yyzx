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
        <h2 class="t1000-tit">文字广告列表</h2> 
    </div>
    <div class="advertising-listManage-con">
        <form id="select_form" action="${pageContext.request.contextPath }/league/advWordList" method="post">
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
		                	<option selected="selected" value="0">全部广告行业</option>
		                	<c:forEach items="${industrys}" var="industry">
		                		<c:if test="${industry.id == industryIdPage}">
			                		<option value="${industry.id}" selected="selected">${industry.paramName}</option>
		                		</c:if>
		                		<c:if test="${industry.id != industryIdPage}">
			                		<option value="${industry.id}">${industry.paramName}</option>
		                		</c:if>
		                	</c:forEach>
		                </select>
	            	</c:if>
	            </span>
	            <span>
		           	 根据标题搜索 <input id="titleKeyWod" name="titleKeyWod" type="text" value="${titleKeyWodPage}" placeholder="请输入标题..." id="title_search"/>
	            </span>
	            <input type="submit" class="advertising-com-search-con-btn1" value="查询"/>
	        </div>
        </form>
        <table class="listManage1" cellpadding="0" cellspacing="0">
			 <tr>
			 	<th class="lm_4_1"><input id="checkedAll" type="checkbox"/><span class="checkedAll">全选</span></th>
             	<th class="lm_2_1">广告标题</th>
             	<th class="lm_1_1">所属行业</th>
             	<th class="lm_3_1">发布时间</th>
             	<th class="lm_3_1">结束时间</th>
             	<th class="lm_5_1">状态</th>
             	<th class="lm_4_1">排序号</th>
             	<th>操作</th>
             </tr> 
             
             <c:forEach items="${advWordsPage.pageList}" var="advWord">
	             <tr>
	             	<td class="lm_4_1">
	             		<input id="${advWord.id}" type="checkbox" name="wordList[]">
	             	</td>
			        <td class="lm_2_1" title="${advWord.title}">${advWord.title}</td>
	             	<td class="lm_1_1">${advWord.industryName}</td>
			        <td class="lm_3_1">
			        	<fmt:formatDate value="${advWord.startTime}" pattern="yyyy-MM-dd"/>
			        </td>
			        <td class="lm_3_1">
			        	<fmt:formatDate value="${advWord.endTime}" pattern="yyyy-MM-dd"/>
			        </td>
			        	 <c:choose>
	                	<c:when test="${advWord.onFlag==0}">
	                		<td class="lm_6_1"><span class="memSate_close">过期</span></td>
	                	</c:when>
	                	<c:when test="${advWord.onFlag==1}">
	                		<td class="lm_6_1"><span class="memSate_over">待用</span></td>
	                	</c:when>
	                	<c:when test="${advWord.onFlag==2}">
	                		<td class="lm_6_1"><span class="memSate_open">启用</span></td>
	                	</c:when>
	                	<c:otherwise>
	                		<td class="lm_6_1"></td>
	                	</c:otherwise>
	                </c:choose>
	                <td class="lm_4_1">
	                	<input style="width: 60%;text-align: center;" type="text" value="${advWord.orderNum}"/>
	                </td>
	                <td>
	                	<a href="${pageContext.request.contextPath }/league/toModifyAdvWord/${advWord.id}" title="" class="change">查看</a>
	                	<c:choose>
	                    	<c:when test="${fn:length(advWordsPage.pageList)==1 && advWordsPage.currentNum!=1}">
			                	<a href="${pageContext.request.contextPath }/league/deleteWordAdv/${advWord.id}/${(empty advWordsPage.currentNum)? 1 : advWordsPage.currentNum-1}/${(empty industryIdPage) ? 0 : industryIdPage}" class="delete">删除</a>
	                    	</c:when>
	                    	<c:otherwise>
			                	<a href="${pageContext.request.contextPath }/league/deleteWordAdv/${advWord.id}/${(empty advWordsPage.currentNum)? 1 : advWordsPage.currentNum}/${(empty industryIdPage) ? 0 : industryIdPage}" class="delete">删除</a>
	                    	</c:otherwise>
	                   </c:choose>
	                </td>
	             </tr>
             </c:forEach>
             <tr>
             	<td class="lm_5_1" colspan="8">
             		<%-- <a href="${pageContext.request.contextPath}/league/toAddWordAdvInfo">
             			<input type="button" value="新增" style="margin-left:20px;"/>
             		</a> --%>
             		<input id="sortBtn" type="button" value="排序保存"/>
             	</td>
             </tr>
        </table>
    </div>
    
     <!-- 处理分页 -->
    <div class="t1000-vote-pageCon">
    	<div class="t1000-vote-pager">
    		
    		<a title="" href="javascript:toPage(1)">首页</a>
    		
   			<c:forEach begin="1" end="${advWordsPage.maxPage}" step="1" varStatus="s" var="i">
				<c:choose>
				<c:when test="${i==advWordsPage.currentNum }">
					<a class="on" href="javascript:toPage(${s.index})">${i}</a>
				</c:when>
				<c:when test="${advWordsPage.currentNum-2>i &&i==3}">
					<a href="">&hellip;</a>
				</c:when>
				<c:when test="${i!=advWordsPage.currentNum &&i<3||i>advWordsPage.currentNum-3&&i<advWordsPage.currentNum+3||i>=advWordsPage.maxPage-1}">
					<a href="javascript:toPage(${s.index})">${i}</a>
				</c:when>
				<c:when test="${advWordsPage.currentNum+3==i&&i<advWordsPage.maxPage-1}">
					<a href="" id="hellip">&hellip;</a>
				</c:when>
				</c:choose>
			</c:forEach>

    		<a title="" href="javascript:toPage(${advWordsPage.maxPage})">末页</a>
    		
    	</div>
    </div>
    
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/league/right.js"></script>
<script type="text/javascript">

$(function(){
	//排序功能
	$("#sortBtn").click(function(){
		var $checked = $("input[name='wordList[]']:checked");
		
		if($checked.length==0){
			alert("请选择要排序的数据");
			return;
		}
		
		//排序数字正则验证
		if($checked.length != 0){
			var num_flag = true;
			$checked.each(function(){
				var order = $(this).parent().nextAll(".lm_4_1").children().attr("value");
				if(!/^[0-9]*$/.test(order)){
					num_flag = false;
					alert("排序号必须为数字!");
				}
			});
			if(num_flag == false){
				alert(num_flag);
				return;
			}
		}
		
		
		//修改排序号并刷新页面
		$checked.each(function(){
			//获取页面参数
			var industryId = $("#industryId").val();
			var titleKeyWod = $("#titleKeyWod").val();
			
			var wordAdvId = $(this).attr("id");
			var order = $(this).parent().nextAll(".lm_4_1").children().attr("value");
			$.ajax({
				contentType : "application/json",
				dataType : "json",
			    type: "GET",
			    url:"${pageContext.request.contextPath }/league/modifyWordAdvOrder?id="+wordAdvId+"&order="+order ,
			    success:function(data){
			    	window.location.href = "${pageContext.request.contextPath }/league/advWordList?industryId=" + industryId + "&titleKeyWod="+titleKeyWod;
			    }
			});
		});
	});
	
	
	//全选
	$("#checkedAll").click(function() {
		$("input[name='wordList[]']").prop("checked", this.checked);
	});
});


$(function(){
	//删除提示
	$("a[class='delete']").click(function(){
		var fdel = window.confirm("是否确定删除？ ");
		if (fdel) {
			return true;
		} else {
			return false;
		}
	});
});
	
	
//页面跳转
function toPage(currentNum) {
	var industryId = document.getElementById("industryId").value;
	var titleKeyWod = document.getElementById("titleKeyWod").value;
	var newUrl ="${pageContext.request.contextPath }/league/advWordList?&industryId="
			+industryId + '&titleKeyWod=' + titleKeyWod + '&currentNum=' + currentNum;
	location.href=newUrl;
}

</script>
</body>
</html>
