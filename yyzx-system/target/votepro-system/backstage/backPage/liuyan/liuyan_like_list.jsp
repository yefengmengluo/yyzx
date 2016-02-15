<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>留言管理</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>

</head>

<body>

<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/liuyan.js"></script>

	<div class="t1000-votB-R-in clearfix">
    		<div class="t1000-siteManagement-tit clearfix">
                <h2 class="t1000-tit">留言管理</h2>
                 <form action="${pageContext.request.contextPath }/liuYanController/queryLiuYanLikeByKey?uPower=${sessionScope.user.userPower }&userId=${u.userId }" method="post" id="liuyanselect" accept-charset="utf-8">
	                <span>输入公司名称</span>
	                <label><input type="text" class="t1000-com-search-con-text grayTips" name="keyWord" value="${keyWord }"/></label>
	                <input type="hidden" class="t1000-com-search-con-text" id="keyWord1" name="keyWord1" value="${keyWord }"/>
	                <input type="submit" class="t1000-com-search-con-btn1"   id="selectOk" value="搜索"/>
	                </form>
              <%--   <a href="${pageContext.request.contextPath }/backstage/backPage/users/users_add.jsp"><input type="button" class="t1000-com-search-con-btn2" value="添加站点"/></a> --%>
               
                <input type="hidden" id="uPower" name="uPower" value="${sessionScope.user.userPower }"/>
            </div>

        
        <table class="memberList t1000-siteManagement" cellpadding="0" cellspacing="0">
            	<tr>
					<th class="ly1"><input id="checkedAll" name="checkedAll" type="checkbox"/>全选</th>
                    <th class="ly3">公司名称</th>
                    <th class="ly4">联系人</th>
                    <th class="ly5">手机</th>
                     <th class="ly2">提交时间</th>
                    <th class="ly6">备注</th>
                    <th class="ly7">状态</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${page.pageList }" var="u">
                <tr>
					<td class="ly1"><input name="checkBox" type="checkbox" value="${u.lyId }"/></td>
                    <td class="ly3">${u.copName }</td>
                    <td class="ly4">${u.linkman }</td>
                    <td class="ly5">${u.mobile }</td>
                    <td class="ly2">
                    <fmt:formatDate value="${u.creatTime}" type="date" />
                    </td>
                    <td class="ly6">${u.comment }</td>
                    <td class="ly7">
                    	 <script type="text/javascript">
       						 document.write(revertLiuyanStatus(${u.status }));
       					 </script>
                    
                    
                   </td>
                    <td width="*"><a class="setData" href="${pageContext.request.contextPath }/liuYanController/queryOneByLYId?uPower=${sessionScope.user.userPower }&lyId=${u.lyId}&currentNum=${page.currentNum}">编辑</a>
                    
                    
                    
                   <!--  <a class="del" href="${pageContext.request.contextPath }/userController/removeUser?uPower=${sessionScope.user.userPower }&deleteIds=${u.userId }&currentNum=${page.currentNum}">删除</a> -->
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
    	<div class="t1000-batch-btn clearfix">
				<span>
				<!-- <input type="button" value="批量删除" class="t1000-batch-btn2" id="batchDelete"/> -->
				</span>
			</div>
	    </div>
   



<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/right.js"></script>

<script type="text/javascript">
	var key=$("#keyWord1").val();
	$("#keyWord").val(key);
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
		var keyWord=$("#keyWord").val();
		$("#liuyanselect").attr("action","${pageContext.request.contextPath }/liuYanController/queryLiuYanLikeByKey?currentNum="+pageNum);
		$("#selectOk").click();
		}
	
	
</script>
</body>
</html>
