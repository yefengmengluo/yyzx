<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>会员信息管理</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<div class="t1000-votB-tit" id="t1000-votB-tit">
	<div class="t1000-votB-tit-l" id="t1000-votB-tit-l">&nbsp;</div>
    <div class="t1000-votB-tit-r" id="t1000-votB-tit-r">
    	<span>当前用户：<a href="">${sessionScope.user.account }</a></span>
    	<span class="t1000-home"><a href="">网站首页</a></span>
    	<span class="t1000-chanpw"><a href="javascript:void(0)" name="setData">修改密码</a></span>
    	<span class="t1000-loginOut">
    	<a href="${pageContext.request.contextPath }/loginController/LogoutAction">安全退出</a></span>
    	<input type="hidden" name="account" value="${sessionScope.user.account }">
    	<input type="hidden" id="userId" name="userId" value="${sessionScope.user.userId }">
    	<input type="hidden" id="uPower" name="uPower" value="${sessionScope.user.userPower }">
    </div>
</div>

<div class="t1000-votB-L" id="t1000-votB-L">
	<div class="t1000-votB-list current" id="t1000-tit-1">
    	<h2 class="t1000-tit-1"><a id="company_list_a" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/vote/voteList">投票信息管理</a>
    	</h2>
        	<ul style="display:block;">
            	<!--<li><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/backstage/backPage/corporation/corporation_edit.jsp">编辑企业信息</a></li>-->
                <%-- <li><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/VoteCompany/v1/toAddCompany?source=0&voteId=0">添加企业详细信息</a></li> --%>
                 <li><a  href="javascript:void(0)" urlData="${pageContext.request.contextPath }/VoteCompany/v1/selectCompanyList">企业会员管理</a></li>
                 <li><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/CommentController/queryAllVoteItemByCommentCount?uPower=${sessionScope.user.userPower }&userId=${sessionScope.user.userId }">评论信息管理</a></li>
            </ul>
    </div>
    <%-- <div class="t1000-votB-list" id="t1000-tit-2">
    	<h2 class="t1000-tit-2"><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/vote/voteList">投票信息管理</a></h2>
        	<ul>
            	<li><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/backstage/backPage/vote/vote_detial.jsp">主题投票信息管理</a></li>
                <li><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/backstage/backPage/vote/vote_edit.jsp">修改主题</a></li>
                <li><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/backstage/backPage/vote/vote_add.jsp">添加投票主题</a></li>
            </ul>
    </div> --%>
   <%--  <div class="t1000-votB-list" id="t1000-tit-3">
    	<h2 class="t1000-tit-3"><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/CommentController/queryAllVoteItemByCommentCount?uPower=${sessionScope.user.userPower }&userId=${sessionScope.user.userId }">评论信息管理</a></h2>
        	<ul>
            	<li><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/backstage/backPage/comment/comment_detial.jsp">评论详情页</a></li>
            </ul>
    </div> --%>
    <div class="t1000-votB-list" id="t1000-tit-4">
    	<h2 class="t1000-tit-4"><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/liuYanController/queryAllLiuYanByPage">留言管理</a></h2>
        	<ul>
        		<li><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/liuYanController/queryAllLiuYanByPageStatus?status=0">未审核</a></li>
            	<li><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/liuYanController/queryAllLiuYanByPageStatus?status=1">已审核</a></li>
                <li><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/liuYanController/queryAllLiuYanByPageStatus?status=2">已禁用</a></li>
            </ul> 
    </div>
    
    <div class="t1000-votB-list" id="t1000-tit-5">
    	<h2 class="t1000-tit-5"><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/userController/queryAllUserByPage?uPower=${sessionScope.user.userPower }">管理员权限</a></h2>
        	<%-- <ul>
            	<li><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/backstage/backPage/users/users_add.jsp">添加站点</a></li>
                <!--<li><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/backstage/backPage/users/users_edit.jsp">编辑</a></li>-->
            </ul> --%>
    </div>
    
   <%-- <div class="t1000-votB-list">
    	<h2 class="t1000-tit-4"></h2>
        	 <ul>
            	<li><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/backstage/backPage/users/users_add.jsp">添加站点</a></li>
                <!--<li><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/backstage/backPage/users/users_edit.jsp">编辑</a></li>-->
            </ul>   
        </div> --%>
            

</div>
<div class="t1000-votB-R" id="t1000-votB-R">
    <iframe id="t1000-votB-R-box" class="t1000-votB-R-box" scrolling="auto" frameborder="0" width="100%" src=""></iframe>
</div>
<div class="bookingBlackBg"></div>
    <div class="bookingBox2">
        <div class="bookingTit">
            <h3>修改密码</h3>
            <span></span>
        </div>
        <div content="">
			<form action="javascript:void(0)" method="post" id="uppassword">
            <div class="vote_num">新密码:&nbsp&nbsp<input class="new_vote" type="password" id="newpassword" name="newpassword" value=""/></div>
          <div class="vote_num">   确认密码:<input class="new_vote" type="password" id="compassword" value=""/></div>
            <div class="vote_btn">
                 <input type="button" class="t1000-com-search-con-btn1 t1000-edit-vote" id="tijiao" value="提交"/>
                 <input type="button" class="t1000-com-search-con-btn2 t1000-edit-close" value="关闭"/>
            </div>
            </form>
        </div>
</div>


<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/left.js"></script>
<script type="text/javascript">
 $(function(){
	 var uPower=$("#uPower").val();
	 if(uPower==1){
		 $("#t1000-tit-4").css("display","none");

	 }
	$("#tijiao").click(function(){
		var casRemoteLoginUrl="${pageContext.request.contextPath}/userController/modifyPassword";
		updatePassword(casRemoteLoginUrl);
	})
	
	$("#company_list_a").click();
}) 
</script>
</body>
</html>
