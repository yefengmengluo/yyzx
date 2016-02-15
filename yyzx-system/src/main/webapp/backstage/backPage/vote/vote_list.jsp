<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cach" /> 
<meta http-equiv="cache-control" content="no-cache" /> 
<meta http-equiv="expires" content="0" />
<title>投票主题列表</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>


	<div class="t1000-votB-R-in clearfix">
    	<div class="t1000-com-search-con clearfix">
            <span>请输入主题名称</span>
            <form id="select_form" action="${pageContext.request.contextPath }/vote/voteList" method="post">
	            <label><input id="keyWord" type="text" class="t1000-com-search-con-text focusBlur" name="keyWord" value="${keyWord}"/></label>
	            <input type="submit" class="t1000-com-search-con-btn1" value="搜索"/>
            </form>
            
            <input type="button" class="t1000-com-search-con-btn2" value="添加主题" onclick="add()"/>
        </div>
        
        <table class="memberList t1000-votTheme" cellpadding="0" cellspacing="0">
            	<tr>
					<th class="vote_w6">序号</th>
                    <th class="vote_w1">投票主题名称</th>
                    <th class="vote_w2">开始时间</th>
                    <th class="vote_w3">结束时间</th>
                    <th class="vote_w4">状态</th>
                    <th>操作</th>
                </tr>
                
                <c:forEach items="${voteTablesPage.pageList }" var="voteTable" varStatus="status">
					 <tr>
						<td class="vote_w6">${status.index+1}</td>
	                	<td class="vote_w1">${voteTable.vSubject }</td>
	                    <td class="vote_w2"><fmt:formatDate value="${voteTable.beginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	                    <td class="vote_w3"><fmt:formatDate value="${voteTable.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	                    <td class="vote_w4">
	                    	<c:if test="${voteTable.dataStatus==1}"><span class="memSate_open">开启</span></c:if>
	                    	<c:if test="${voteTable.dataStatus==0}"><span class="memSate_close">关闭</span></c:if>
	                    </td>
	                    <td width="*">
		                    <a class="setData" href="<c:url value='/vote/toVoteModify?id=${voteTable.id}'/>">查看</a>
		                    
		                    <c:choose>
		                    	<c:when test="${fn:length(voteTablesPage.pageList)==1 && voteTablesPage.currentNum!=1}">
									<a class="del" href="<c:url value='/vote/voteDelete'/>?id=${voteTable.id}&currentNum=${voteTablesPage.currentNum-1}&keyWord=${keyWord}">删除</a>
		                    	</c:when>
		                    	<c:otherwise>
									<a class="del" href="<c:url value='/vote/voteDelete'/>?id=${voteTable.id}&currentNum=${voteTablesPage.currentNum}&keyWord=${keyWord}">删除</a>
		                    	</c:otherwise>
		                    </c:choose>
		                  
							<%-- <a class="setData" href="${pageContext.request.contextPath }/VoteCompany/v1/toAddCompany?source=1&voteId=${voteTable.id}">添加企业</a> --%>
							<a class="setData" href="${pageContext.request.contextPath }/VoteItem/v1/selectVoteItemList?voteId=${voteTable.id}">品牌列表</a>
							<a class="setData" href=" <c:url value='/vote/advertisingList'/>?vId=${voteTable.id}&channelName=0">广告管理</a>
						</td>
	                </tr>
                </c:forEach>
        </table>  
        
    	<!-- 处理分页 -->
    	<div  class="t1000-vote-pageCon">
    		<div class="t1000-vote-pager">
    			<c:if test="${voteTablesPage.currentNum == 1 }">
    				<a title="" href="javascript:toPage(1)">上一页</a>
    			</c:if>
    			<c:if test="${voteTablesPage.currentNum != 1 }">
    				<a title="" href="javascript:toPage(${voteTablesPage.currentNum-1})">&lt;&lt;上一页</a>
    			</c:if>
    		
	    		<c:forEach begin="1" end="${voteTablesPage.maxPage}" step="1" varStatus="s" var="i">
					<c:choose>
					<c:when test="${i==voteTablesPage.currentNum }">
						<a class="on" href="javascript:toPage(${s.index})">${i}</a>
					</c:when>
					<c:when test="${voteTablesPage.currentNum-2>i &&i==3}">
						<a href="">&hellip;</a>
					</c:when>
					<c:when test="${i!=voteTablesPage.currentNum &&i<3||i>voteTablesPage.currentNum-3&&i<voteTablesPage.currentNum+3||i>=voteTablesPage.maxPage-1}">
						<a href="javascript:toPage(${s.index})">${i}</a>
					</c:when>
					<c:when test="${voteTablesPage.currentNum+3==i&&i<voteTablesPage.maxPage-1}">
						<a href="" id="hellip">&hellip;</a>
					</c:when>
					</c:choose>
				</c:forEach>
    		
    			<c:if test="${voteTablesPage.currentNum!=voteTablesPage.maxPage }">
					<a href="javascript:toPage(${voteTablesPage.currentNum+1})">下一页&gt;&gt;</a>
				</c:if>
				<c:if test="${voteTablesPage.currentNum==voteTablesPage.maxPage }" >
					<a>下一页</a>
				</c:if>
    		</div>
    	</div>
 	</div>



<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/right.js"></script>
<script type="text/javascript">
$(function(){
	
	//删除提示
	$("a[class='del']").click(function(){
		var openFlag = $(this).parent().prev().children().first().text()=="开启";
		if(openFlag){
			alert("该主题为开启状态，不允许删除");
			return false;
		}
		
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
		var keyWord = document.getElementById("keyWord").value;
		var newUrl ="${pageContext.request.contextPath }/vote/voteList?&keyWord="
				+keyWord + '&&currentNum=' + currentNum;
		$("#select_form").attr("action", newUrl);
		$("#select_form").submit();
	}
	
	////跳转添加页
	function add(){
		location.href="${pageContext.request.contextPath }/backstage/backPage/vote/vote_add.jsp";
	}
</script>
</body>
</html>
