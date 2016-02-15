<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>广告信息管理</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>


	<div class="t1000-votB-R-in clearfix">
    	<div class="t1000-com-tips-con clearfix">
            <span>&nbsp;</span>
            <div class="t1000-tips_r">
            	<h3>操作小贴士</h3>
                <p>1、图片广告位管理</p>
            </div>
        </div>
        <div class="t1000-vote-page">
        	<select id="channelSelect" name="channelName" onchange="changeChannel(this.value)">
        		<c:if test="${channelName == 0 }">
	                <option value="0" selected="selected">投票详情页</option>
	            	<option value="1">投票列表页</option>
        		</c:if>
        		<c:if test="${channelName == 1 }">
	                <option value="0">投票详情页</option>
	            	<option value="1" selected="selected">投票列表页</option>
        		</c:if>
            </select>
            <span>请选择展示页面</span>
        </div>
       
        <table class="memberList advTab" cellpadding="0" cellspacing="0">
            	<tr>
					<th class="vote_w6"><input id="checkedAll" name="checkedAll" type="checkbox" />全选</th>
                    <th class="vote_w4">广告位名称</th>
                    <th class="vote_w4">图片</th>
                    <th class="vote_w5">URL</th>
                    <th class="w4">排序</th>
                    <th class="vote_w2">开始日期</th>
                    <th width="*">操作</th>
                </tr>
                
                 <c:forEach items="${advertisings}" var="advertising">
                	<tr>
						<td class="vote_w6"><input id="${advertising.advId}" name="companyList[]" type="checkbox"/></td>
		                <td class="vote_w4">${advertising.positionName}</td>
		                
		                 <td class="vote_w4">
		                 	<c:if test="${advertising.advType == 0 && !empty advertising.pictures[0] }">
			            		<img src="${advertising.pictures[0].picUrl}"/>
		                	</c:if>
		                 	<c:if test="${advertising.advType == 0 && empty advertising.pictures[0].picUrl }">
			            		<br/>暂未上传图片
		                	</c:if>
			                <c:if test="${advertising.advType == 1}">
								文字广告 无图片
			                </c:if>
		                 </td>
		               
		               
		                <td class="vote_w5">
		                	<c:if test="${!empty advertising.pictures[0]}">
		                		${advertising.pictures[0].targetUrl}
		                	</c:if> 
		                </td>
		                <td class="w4"><input id="advOrder" type="text" value="${advertising.advOrder}" /></td>
		                <td class="vote_w2">
		                    <fmt:formatDate value="${advertising.createTime}" pattern="yyyy-MM-dd" />
		                </td>
		                <td width="*">
		                    <a class="setData" href="<c:url value='/vote/toAdvertisingModify?id=${advertising.advId}'/>">修改</a><br/>
		                    <a class="del" href="<c:url value='/vote/advertisingDelete?id=${advertising.advId}&vId=${advertising.vId}&channelName=${advertising.channelName}'/>">删除</a>
		                </td>
		            </tr>
                </c:forEach>
                <tr>
                    <td class="tab_btn" colspan="7">
                     <span>
                        <a id="addButton" href=""><input type="button" class="t1000-batch-btn1" value="新增"/></a>
                        <input id="sortBtn" type="submit" class="t1000-batch-btn2" value="排序保存"/>
                         <input type="button" class="t1000-batch-btn2" value="返回" onclick="toVotePage()"/>
                     </span>
                    </td>
                </tr>
                
        </table>  
    </div>


<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/right.js"></script>
<script type="text/javascript">
$(function(){
	//删除提示
	$("a[class='del']").click(function(){
		var fdel = window.confirm("是否确定删除？ ");
		if (fdel) {
			return true;
		} else {
			return false;
		}
		
		return false;
	});
	
	
	//排序功能
	$("#sortBtn").click(function(){
		var vId = ${vId};
		var channelName = ${channelName};
		var $checked = $("input[name='companyList[]']:checked");
		if($checked.length==0){
			alert("请选择要排序的数据");
			return;
		};
		
		//排序数字正则验证
		if($checked.length != 0){
			var num_flag = true;
			$checked.each(function(){
				vat = advId = $(this).attr("id");
				var order = $(this).parent().nextAll(".w4").children().attr("value");
				if(!/^[0-9]*$/.test(order)){
					num_flag = false;
					alert("排序号必须为数字!");
				}
			});
			if(num_flag == false){
				return;
			}
		}
		
		//修改排序号并刷新页面
		$checked.each(function(){
			var advId = $(this).attr("id");
			var order = $(this).parent().nextAll(".w4").children().attr("value");
			 
			$.ajax({
				contentType : "application/json",
				dataType : "json",
			    type: "GET",
			    url:"${pageContext.request.contextPath }/vote/modifyAdvOrder?id="+advId+"&order="+order ,
			    success:function(data){
			    	window.location.href = "${pageContext.request.contextPath }/vote/advertisingList?vId=" + vId + "&channelName="+channelName;
			    }
			});
		});
		
		return false;
	});
	
	/* 
	$("#channelSelect").change(function(){
		var vId = ${vId};
		channelName = $(this).val();
		window.location.href = "${pageContext.request.contextPath }/vote/advertisingList?vId=" + vId + "&channelName="+channelName;
	    return false;
	}); */
	
	
	$("#addButton").click(function(){
		var channelName = $("#channelSelect").val();
		var vId = ${vId};
		window.location.href = "${pageContext.request.contextPath }/vote/toAdvertisingAdd?channelName="+channelName+"&vId="+vId;
		return false;
	});
	
});

function changeChannel(channelName){
	var vId = ${vId};
	//channelName = $(this).val();
	window.location.href = "${pageContext.request.contextPath }/vote/advertisingList?vId=" + vId + "&channelName="+channelName;
    
}
function toVotePage(){
	window.location.href = "${pageContext.request.contextPath }/vote/voteList";
    
}
</script>

</body>
</html>
