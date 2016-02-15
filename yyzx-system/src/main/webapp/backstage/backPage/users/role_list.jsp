<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员权限管理</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>



	<div class="t1000-votB-R-in clearfix">
    		<div class="t1000-siteManagement-tit clearfix" >
                <h2 class="t1000-tit">用户管理</h2>
                 <form action="${pageContext.request.contextPath }/userController/queryUserLikeByPage?uPower=${sessionScope.user.userPower }&userId=${u.userId }" method="post" id="useradd" accept-charset="utf-8">
	                <span>权限名称查询</span>
	                <label><input type="text" class="t1000-com-search-con-text grayTips" name="keyWord" value="请输入关键字"/></label>
	                <input type="submit" class="t1000-com-search-con-btn1" value="搜索"/>
	                </form>
              <%--   <a href="${pageContext.request.contextPath }/backstage/backPage/users/users_add.jsp"><input type="button" class="t1000-com-search-con-btn2" value="添加站点"/></a> --%>
                <input type="button" class="t1000-com-search-con-btn2" value="添加权限" onclick="add()"/>
                <input type="hidden" id="uPower" name="uPower" value="${sessionScope.user.userPower }"/>
                
            </div>

        
        <table class="memberList t1000-siteManagement" cellpadding="0" cellspacing="0">
        
            	<tr>
            		<c:if test="${sessionScope.user.userPower ==0}">
						<th class="vote_w6"><input id="checkedAll" name="checkedAll" type="checkbox"/>全选</th>
					</c:if>
					<c:if test="${!(sessionScope.user.userPower ==0)}">
						<th class="vote_w6">序号</th>
					</c:if>
                    <th class="vote_w1">权限名称</th>
                    <th class="vote_w1">网址</th>
                    <th class="vote_w3">账号</th>
                    <th class="vote_w4">操作员</th>
                    <th>操作<input type="hidden" id="lystatus" name="lystatus" value="${sessionScope.lystatus }"/></th>
                </tr>
                <c:forEach items="${page.pageList }" var="u" varStatus="s">
                <tr>
                	<c:if test="${sessionScope.user.userPower ==0}">
						<td class="vote_w6"><input name="checkBox" type="checkbox" value="${u.userId }"/></td>
					</c:if>
					<c:if test="${!(sessionScope.user.userPower ==0)}">
						<td class="vote_w6">${s.count }</td>
					</c:if>
	                	<td class="vote_w1">${u.siteName}</td>
	                    <td class="vote_w1">${u.webUrl }</td>
	                    <td class="vote_w3">${u.account }</td>
	                    <td class="vote_w4">${u.realName }</td>
	                    <td width="*"><a class="setData" href="${pageContext.request.contextPath }/userController/queryOneByUserId?uPower=${sessionScope.user.userPower }&userId=${u.userId }&currentNum=${page.currentNum}">编辑</a>
                    <c:if test="${sessionScope.user.userPower ==0}">
                    	<a class="del" href="${pageContext.request.contextPath }/userController/removeUser?uPower=${sessionScope.user.userPower }&deleteIds=${u.userId }&currentNum=${page.currentNum}">删除</a>
                    </c:if>
                    </td>
       	       </tr>
          	    </c:forEach>

        </table>  
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
    	<c:if test="${sessionScope.user.userPower ==0}">
    		<div class="t1000-batch-btn clearfix">
				<span><input type="button" value="批量删除" class="t1000-batch-btn2" id="batchDelete"/>
				</span>
			</div>
		</c:if>
	    </div>
   



<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/right.js"></script>
<script type="text/javascript">

$(document).ready(function(){
   var lystatus=$("#lystatus").val(); 
   if(!(lystatus==null)){
	   $(".t1000-siteManagement-tit clearfix").hide();
	   
   }
})	

	//全选
	$(function(){
		$("#checkedAll").click(function(){
			$("input[name='checkBox']").each(function(){
				var sta=$("#checkedAll").prop("checked");
				$(this).prop("checked",sta);
			})
		})
	//批量删
	var str="";
	 $("#batchDelete").click(function(){
		$("input[name='checkBox']:checked").each(function(){
			//alert($(this).val());
			str=str+$(this).val()+",";
			//alert(str);
		})	
		var on= $("#on").val();
		var uPower=$("#uPower").val();
		alert("当前页："+uPower);
			$.post(
			 		"${pageContext.request.contextPath }/userController/removeUser",
					{"deleteIds":str,"uPower":uPower,"currentNum":on},
					//dataType:'text',		
					//date:$("input[name='ids']:checked").serialize(),//$("input[type='checkbox'][id='checkBox']:checked").serialize(),
			 		function(){
					 		//$.message("success","删除成功！");
	     				$("input[name='checkBox']:checked").parent().parent().remove();
		 			} 
					 ); 
		})
		
	}) 
	//分页跳转
	function pageSkip(pageNum){
			location.href="${pageContext.request.contextPath }/userController/queryAllUserByPage?uPower=${sessionScope.user.userPower }&currentNum="+pageNum;
		}
	////跳转添加页
	function add(){
		location.href="${pageContext.request.contextPath }/backstage/backPage/users/users_add.jsp";
	}
</script>
</body>
</html>
