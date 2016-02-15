<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>评论信息管理</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>

	<div class="t1000-votB-R-in clearfix">
    	<div class="t1000-com-search-con clearfix">
            <h1  align="center" style="color:red; font-size:45px">评 论 排 行 榜</h1>
            <form action="${pageContext.request.contextPath }/CommentController/queryVoteItemLikeByUser" method="post" >
	            <span>输入品牌名称</span>
	            <label><input type="text" class="t1000-com-search-con-text focusBlur grayTips" name="keyWord" value="请输入关键字"/></label>
	            <input type="hidden" name="userId" value="${sessionScope.user.userId }"/>
	            <input type="hidden" name="uPower" value="${sessionScope.user.userPower }"/>
	            
	            <input type="submit" class="t1000-com-search-con-btn1" value="搜索"/>
            </form>
        </div>
        
        <table class="memberList commentTab" cellpadding="0" cellspacing="0">
            	<tr>
					<th class="vote_w60">排序</th>
                    <th class="vote_w40">品牌名称</th>
                    <th class="vote_w20">评论数</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${page.pageList }" var="p" varStatus="s">
                <tr>
					<td class="vote_w6">${s.count}</td>
                	<td class="vote_w40">${p.vdTitle }</td>
                    <td class="vote_w20">${p.num }</td>
                    <td width="*"><a class="setData" href="${pageContext.request.contextPath }/CommentController/queryAllCommentByViId?viId=${p.viId}&tag=0">查看评论详情</a></td><!-- tag表示返回页 -->
                </tr>
                </c:forEach>
        </table>  
       <!--  <div class="t1000-vote-pageCon">
    		<div class="t1000-vote-pager"><a title="" href="">&lt;&lt;上一页</a><a class="on" href="">1</a><a title="" href="">2</a><a title="" href="">3</a><a title="" href="">...</a><a title="" href="">42</a><a title="" href="">上一页&gt;&gt;</a></div>
    	</div> -->
		<!-- <div class="t1000-batch-btn clearfix">
				<span><input type="button" value="批量删除" class="t1000-batch-btn2" id="batchDelete"/>
				</span>
			</div>
	    </div> -->
	            <div class="t1000-vote-pageCon clearfix">
    		<div class="t1000-vote-pager">
	    		<!-- <a title="" href="">&lt;&lt;上一页</a><a class="on" href="">1</a><a title="" href="">2</a><a title="" href="">3</a><a title="" href="">...</a><a title="" href="">42</a><a title="" href="">上一页&gt;&gt;</a> -->
	    			<c:if test="${page.currentNum!=1 }">
					<a onclick="pageSkip(${page.currentNum-1})" rel="last">&lt;&lt;上一页</a>
				</c:if>
				<c:if test="${page.currentNum==1 }" >
					<a>&lt;&lt;上一页</a>
				</c:if>
				<c:forEach begin="1" end="${page.maxPage }" step="1" varStatus="s" var="i">
					<c:choose>
					<c:when test="${i==page.currentNum }">
						<a class="on">${i}</a>
						<input type="hidden" id="on" value="${i}"/>
					</c:when>
					<c:when test="${page.currentNum-2>i &&i==3}">
						<a href="">...</a>
					</c:when>
					<c:when test="${i!=page.currentNum &&i<3||i>page.currentNum-3&&i<page.currentNum+3||i>=page.maxPage-1}">
						<a onclick="pageSkip(${i})">${i}</a>
					</c:when>
					<c:when test="${page.currentNum+3==i&&i<page.maxPage-1}">
						<a href="">&hellip;</a>
					</c:when>
				
					</c:choose>
				
				</c:forEach>
					<c:if test="${page.currentNum!=page.maxPage }">
						<a onclick="pageSkip(${page.currentNum+1})" rel="last">&gt;&gt;下一页</a>
					</c:if>
					<c:if test="${page.currentNum==page.maxPage }" >
						<a>&gt;&gt;下一页</a>
					</c:if>
						<!-- <li><a href="" rel="next">下一页</a></li> -->
				<c:if test="${page.currentNum!=page.maxPage }">
						<a  onclick="pageSkip(${page.maxPage})" rel="last">尾页</a>
				</c:if>
				<c:if test="${page.currentNum==page.maxPage }">
						<a  onclick="pageSkip(${page.maxPage})" rel="last">尾页</a>
				</c:if>
			    
			</div>
    	</div>
    	</div>


<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/right.js"></script>
<script type="text/javascript" >
	function  pageSkip(num){
		location.href="${pageContext.request.contextPath }/CommentController/queryAllVoteItemByCommentCount?uPower=${sessionScope.user.userPower }&userId=${sessionScope.user.userId }&currentNum="+num;
	}
</script>
</body>
</html>
