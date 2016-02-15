<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta   http-equiv= "Pragma"   content= "no-cache" />
<meta   http-equiv= "Cache-Control"   content= "no-cache" />
<meta   http-equiv= "Expires"   content= "0" /> 
<title>图片广告列表</title>

<link href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css" type="text/css" rel="stylesheet"/>

</head>

<body>
<input id="currentNum" type="hidden" value="${advInfosPage.currentNum}"></input>
<input id="removeUrl" type="hidden" value="${pageContext.request.contextPath }/league/removeAdvPic"></input>
<div class="t1000-votB-R-in clearfix">
    <div class="advertising-siteManagement-tit clearfix">
        <h2 class="t1000-tit">图片广告列表</h2> 
    </div>
    <div class="advertising-listManage-con">
        <form id="select_form" action="${pageContext.request.contextPath }/league/advInfoList" method="post">
	        <div class="advertising-listManage-consearch">
	        	<span>
	            	根据行业搜索
	            	<c:if test="${empty industrys}">
	            		<select id="industryId" name="industryId">
	                		<option>暂无行业信息</option>
	                	</select>
	            	</c:if>
	            	<c:if test="${!empty industrys}">
		                <select id="industryId" name="industryId">
		                	<option selected="selected" value="0">请选择广告行业</option>
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
	            	<!-- 根据尺寸搜索 -->
	            	根据类型搜索
	            	<c:if test="${empty types}">
	            		<select id="typeId" name="typeId">
	                		<option selected="selected">暂无类型信息</option>
	                	</select>
	            	</c:if>
	            	<c:if test="${!empty types}">
		                <select id="typeId" name="typeId">
		                	<option selected="selected" value="0">请选择广告类型</option>
		                	<c:forEach items="${types}" var="type">
		                		<c:if test="${type.id == typeIdPage}">
			                		<option value="${type.id}" selected="selected">${type.paramName}</option>
		                		</c:if>
		                		<c:if test="${type.id != typeIdPage}">
			                		<option value="${type.id}">${type.paramName}</option>
		                		</c:if>
		                	</c:forEach>
		                </select>
	            	</c:if>
	            </span>
	            <input type="submit" class="advertising-com-search-con-btn1" value="查询"/>
	        </div>
        </form>
        <table class="listManage" cellpadding="0" cellspacing="0">
			 <tr>
			 	<th class="lm_5"><input id="checkedAll" name="checkedAll"
					type="checkBox">全选</th>
             	<th class="lm_1">广告名称</th>
             	<th class="lm_2">广告类型</th>
             	<th class="lm_3">URL链接</th>
             	<th class="lm_1">所属行业</th>
             	<th class="lm_4">状态</th>
             	<th class="lm_2">发布时间</th>
             	<th class="lm_2">结束时间</th>
             	<th>操作</th>
             </tr> 
             
             <c:forEach items="${advInfosPage.pageList}" var="advInfo" varStatus="status">
	             <tr>
	             	<td><input name="companyList[]" type="checkBox"
						value="${advInfo.id}" /></td>
	             	<td class="lm_1">${advInfo.advName }</td>
		            <td class="lm_2 pic">
		            <img alt="" src="${advInfo.picUrl }"><br/>
		            ${advInfo.typeName }(${advInfo.advSize })</td>
	               	<td class="lm_3"><a href="${advInfo.targetUrl }" title="" target="_blank">${advInfo.targetUrl }</a></td>
			        <td class="lm_1">${advInfo.industryName }</td>
	                <c:choose>
	                	<c:when test="${advInfo.onFlag==0}">
	                		<td class="lm_4"><span class="memSate_close">过期</span></td>
	                	</c:when>
	                	<c:when test="${advInfo.onFlag==1}">
	                		<td class="lm_4"><span class="memSate_over">待用</span></td>
	                	</c:when>
	                	<c:when test="${advInfo.onFlag==2}">
	                		<td class="lm_4"><span class="memSate_open">启用</span></td>
	                	</c:when>
	                	<c:otherwise>
	                		<td class="lm_4"></td>
	                	</c:otherwise>
	                </c:choose>
	                
	                <td class="lm_2"><fmt:formatDate value="${advInfo.startTime }" pattern="yyyy-MM-dd"/></td>
	                <td class="lm_2"><fmt:formatDate value="${advInfo.endTime }" pattern="yyyy-MM-dd"/></td>
	                <td>
	                <c:choose>
	                	<c:when test="${advInfo.onFlag==0}">
	                		<a title="过期广告只能查看不能修改" href="javascript:toAdvEdit('${advInfo.id}','${advInfosPage.currentNum }')" class="change">编辑</a>
	                	</c:when>
	                	<c:otherwise>
	                		<a href="javascript:toAdvEdit('${advInfo.id}','${advInfosPage.currentNum }')" class="change">编辑</a>
	                	</c:otherwise>
	                </c:choose>
	                	<!-- zsl -->
	                	<a href="javascript:delPicOne('${advInfo.id}','${advInfo.onFlag}')" class="delete">删除</a>
	                </td>
	             </tr>
             </c:forEach>
             
                   	
        </table>
        <div class="t1000-batch-btn clearfix">
			<span><input id="batchDelete" type="button"
				class="t1000-batch-btn2" value="批量删除" />
			</span>
		</div>
    </div>
    <!-- 处理分页 -->
    <div class="t1000-vote-pageCon">
    	<div class="t1000-vote-pager">
    		
    		<a title="" href="javascript:toPage(1)">首页</a>
    		
   			<c:forEach begin="1" end="${advInfosPage.maxPage}" step="1" varStatus="s" var="i">
				<c:choose>
				<c:when test="${i==advInfosPage.currentNum }">
					<a class="on" href="javascript:toPage(${s.index})">${i}</a>
				</c:when>
				<c:when test="${advInfosPage.currentNum-2>i &&i==3}">
					<a href="">&hellip;</a>
				</c:when>
				<c:when test="${i!=advInfosPage.currentNum &&i<3||i>advInfosPage.currentNum-3&&i<advInfosPage.currentNum+3||i>=advInfosPage.maxPage-1}">
					<a href="javascript:toPage(${s.index})">${i}</a>
				</c:when>
				<c:when test="${advInfosPage.currentNum+3==i&&i<advInfosPage.maxPage-1}">
					<a href="" id="hellip">&hellip;</a>
				</c:when>
				</c:choose>
			</c:forEach>

    		<a title="" href="javascript:toPage(${advInfosPage.maxPage})">末页</a>
    		
    	</div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/league/right.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/league/league.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/commonRight.js"></script>

<script type="text/javascript">
	//页面跳转
	function toPage(currentNum) {
		
		var industryId = document.getElementById("industryId").value;
		var typeId = document.getElementById("typeId").value;
		var newUrl ="${pageContext.request.contextPath }/league/advInfoList?industryId="
				+industryId + '&typeId=' + typeId + '&currentNum=' + currentNum;
		$("#select_form").attr("action", newUrl);
		$("#select_form").submit();
	}
	
	function toAdvEdit(id,currentNum){
		var industryId = document.getElementById("industryId").value;
		var typeId = document.getElementById("typeId").value;
		var newUrl ="${pageContext.request.contextPath }/league/toAdvEdit?advInfoId="+id+"&industryId="
			+industryId + '&typeId=' + typeId + '&currentNum=' + currentNum;
		location.href=newUrl;
	}

	
	$(function(){
		
		$(".lm_2 img").mouseover(function(){
			$(this).parent().addClass("pic_on").removeClass("pic");	
		
		}).mouseout(function(){
			$(this).parent().addClass("pic").removeClass("pic_on");	
		})
		
	})

</script>
</body>
</html>
