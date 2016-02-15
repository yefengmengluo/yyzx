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
<title>广告尺寸列表</title>
<link href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css" type="text/css" rel="stylesheet"/>
<style type="text/css">
body {position:relative;}
#showUrl{
display:none;
	width:100%;
	height:100%;
	position:absolute;
	z-index:10;
}
#showUrl .out{

	border:4px solid #dfdfdf;
	background:#f4f4f4;
	width:620px;
	height:120px;
	padding:20px;
	z-index:100;
	position:fixed;
	left:200px;
	top:200px;
}
#showUrl .out p{ font-size:14px; font-family:"宋体";line-height:22px;}
#showUrl input {
	width:60px;
	height:30px;
	text-align:center;
	position:absolute;
	right:20px; 
	bottom:10px;
}
</style>

</head>

<body>
<div id="showUrl" class="clearfix">
	<div class="out"> 
		 <p id="url_memo"></p>
		<input type="button" value="确定" id="showUrlBtn"/>
	</div>
	
</div>
<div class="t1000-votB-R-in clearfix">



    <div class="advertising-siteManagement-tit clearfix">
        <h2 class="t1000-tit">尺寸列表</h2> 
    </div>
    <div class="advertising-listManage-con">
        <form id="select_form" action="${pageContext.request.contextPath }/LeagueSize/v1/advSizeList" method="post">
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
			 	<!-- <th class="lm_5"><input id="checkedAll" name="checkedAll"
					type="checkBox">全选</th> -->
				<th>序号</th>	
             	<th class="lm_1">所属行业</th>
             	<th class="lm_1">广告类型</th>
             	<th class="lm_1">尺寸</th>
             	<th class="lm_1">advCode</th>
             	<th class="lm_1">添加时间</th>
             	<th>操作</th>
             </tr> 
             
             <c:forEach items="${advSizePage.pageList}" var="advSize" varStatus="status">
	             <tr>
	             	<%-- <td><input name="companyList[]" type="checkBox"
						value="${advSize.id}" /></td> --%>
					<td style="width:50px">${status.index+1}</td>
	             	<td class="lm_1">${advSize.industryName }</td>
		            <td class="lm_1">${advSize.typeName }</td>
	               	<td class="lm_1">${advSize.advSize }</td>
			        <td class="lm_1">${advSize.industryId }${'_'}${advSize.typeId }${'_'}${advSize.advSize}</td>
	                
	                <td class="lm_1"><fmt:formatDate value="${advSize.createTime }" pattern="yyyy-MM-dd"/></td>
	                <td>
	                	<a href="javascript:toShowUrl('${advSize.industryId }','${advSize.typeId }','${advSize.advSize}')" class="change">查看URL</a>
	                	<a href="javascript:delSizeOne('${advSize.id}')" class="delete">删除</a>
	                </td>
	             </tr>
             </c:forEach>
             
                   	
        </table>
        <!-- <div class="t1000-batch-btn clearfix">
			<span><input id="batchDelete" type="button"
				class="t1000-batch-btn2" value="批量删除" />
			</span>
		</div> -->
    </div>
    <!-- 处理分页 -->
    <div class="t1000-vote-pageCon">
    	<div class="t1000-vote-pager">
    		
    		<a title="" href="javascript:toPage(1)">首页</a>
    		
   			<c:forEach begin="1" end="${advSizePage.maxPage}" step="1" varStatus="s" var="i">
				<c:choose>
				<c:when test="${i==advSizePage.currentNum }">
					<a class="on" href="javascript:toPage(${s.index})">${i}</a>
				</c:when>
				<c:when test="${advSizePage.currentNum-2>i &&i==3}">
					<a href="">&hellip;</a>
				</c:when>
				<c:when test="${i!=advSizePage.currentNum &&i<3||i>advSizePage.currentNum-3&&i<advSizePage.currentNum+3||i>=advSizePage.maxPage-1}">
					<a href="javascript:toPage(${s.index})">${i}</a>
				</c:when>
				<c:when test="${advSizePage.currentNum+3==i&&i<advSizePage.maxPage-1}">
					<a href="" id="hellip">&hellip;</a>
				</c:when>
				</c:choose>
			</c:forEach>

    		<a title="" href="javascript:toPage(${advSizePage.maxPage})">末页</a>
    		
    	</div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/league/right.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/league/league.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/commonRight.js"></script>

<script type="text/javascript">

	var removeUrl = "${pageContext.request.contextPath }/LeagueSize/v1/removeAdvSize";
	

	//页面跳转
	function toPage(currentNum) {
		
		var industryId = document.getElementById("industryId").value;
		var typeId = document.getElementById("typeId").value;
		var newUrl ="${pageContext.request.contextPath }/LeagueSize/v1/advSizeList?industryId="
				+industryId + '&typeId=' + typeId + '&currentNum=' + currentNum;
		$("#select_form").attr("action", newUrl);
		$("#select_form").submit();
	}
	
	/*尺寸删除*/
	//删除一条尺寸数据
	function delSizeOne(id){
		queryAdvCountBySizeId(id);
	}

	//删除操作
	function deleteSize(id,count) {
		var industryId = document.getElementById("industryId").value;
		var typeId = document.getElementById("typeId").value;
		var currentNum = "${advSizePage.currentNum}";
		location.href = "${pageContext.request.contextPath }/LeagueSize/v1/removeAdvSize?id="
				+id+"&count="+count+"&currentNum="+currentNum+"&industryId="+industryId+"&typeId="+typeId;

		/* $
				.ajax({
					type : "post",
					url : removeUrl,
					data : {
						id : id,
						count : count
					},
					success : function(data) {
						if (data == "success") {
							location.reload();
						} else {
							alert("删除失败");
						}
					},
					error : function(){
						alert("删除失败");
					}
				}); */

	}
	
	//判断此尺寸下的广告位上有没有广告
	function queryAdvCountBySizeId(id) {

		$
				.ajax({
					type : "get",
					url : "${pageContext.request.contextPath }/league/queryAdvCountBySizeId",
					data : {
						sizeId : id
					},
					success : function(data) {
						if (data != 0) {
							if(confirm("此尺寸广告位正在使用,确定删除吗")){
								deleteSize(id,1);
							}
						} else {
							if(confirm("确定删除吗")){
								deleteSize(id,0);
							}
						}
					},
					error : function(){
						alert("查询失败");
					}
				});

	}
	
	
	function toShowUrl(a,b,c){
		var str1 = "http://yyzx.99114.com/backstage/js/league/ad_league.js?pageWidth=1000&advType=0&advCode=";
		var str2 = "&dataNum=1";
		var str3 = str1+a+"_"+b+"_"+c+str2;
		var s = '<script type="text/javascript" src="'+
				str3+
				'"><\/script>';
		
		//alert(s);
		$("#url_memo").text(s);
		$("#showUrl").show();
		
	};


	$(function(){
		$("#showUrlBtn").click(function(){
			$("#showUrl").hide();
		});
		
		
		
	});
</script>
</body>
</html>
