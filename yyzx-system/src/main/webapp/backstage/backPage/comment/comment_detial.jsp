<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑企业信息</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>


	<div class="t1000-votB-R-in clearfix">
        
        <table class="t1000-editTab t1000-commentDetail" cellpadding="0" cellspacing="0">
            	<tr>
                	<th colspan="2"><span>${item.vdTitle }</span>&nbsp&nbsp&nbsp评论基本信息操作
                		<input  type="hidden" id="viId" value="${item.id }"/>
                		<input  type="hidden" id="vId" value="${item.vId }"/>
                	</th>
                </tr>
                <c:forEach items="${page.pageList }" var="p">
                <tr>
                	<td colspan="2">
                    	<ul class="t1000-comment-list">
                        	<li><span>评论时间：</span> <fmt:formatDate value="${p.comTime }"   pattern="yyyy-MM-dd HH:mm:ss"  type="time" timeStyle="medium"/></li>
                            <li><span>评论IP：</span>${p.comIp }</li>
                            <li><span>评论内容：</span> ${p.comContent }</li>
                            <li><a class="del" href="${pageContext.request.contextPath }/CommentController/removeComment?comIds=${p.comId}&viId=${item.id }&currentNum=${page.currentNum}&tag=${param.tag}">删除</a></li>
                        </ul>                    
                    </td>
                </tr>
                </c:forEach>
              
        </table>  
        <!-- <div class="t1000-vote-pageCon clearfix">
    		   <input type="submit" value="返回" class="t1000-batch-btn2"/>
    		   <div class="t1000-vote-pager">
	    		   <a title="" href="">&lt;&lt;上一页</a>
	    		   <a class="on" href="">1</a><a title="" href="">2</a><a title="" href="">3</a>
	    		   <a title="" href="">...</a><a title="" href="">42</a>
	    		   <a title="" href="">下一页&gt;&gt;</a>
    		   </div>
    	</div> -->
               <div class="t1000-vote-pageCon clearfix">
               <input type="button" value="返回" class="t1000-batch-btn2" onclick="returnPage()"/>
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
		var viId=$("#viId").val();
		location.href="${pageContext.request.contextPath }/CommentController/queryAllCommentByViId?currentNum="+num+"&viId="+viId+"&tag="+${param.tag};
	}
	function returnPage(){
		var tag=${param.tag};
		if(tag==1){
			var vId=$("#vId").val();
			location.href = "${pageContext.request.contextPath }/VoteItem/v1/selectVoteItemList?voteId="+vId;
		}else if(tag==0){
			location.href ="${pageContext.request.contextPath }/CommentController/queryAllVoteItemByCommentCount?uPower=${sessionScope.user.userPower }&userId=${sessionScope.user.userId }";
		}
	}
</script>
</body>
</html>
