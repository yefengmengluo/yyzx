<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改主题</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>
	<div class="t1000-votB-R-in clearfix">
        <form action="<c:url value='/vote/voteModify'/>" method="post">
        <table class="t1000-editTab" cellpadding="0" cellspacing="0">
            	<tr>
                	<th colspan="2">基本信息
                		<!-- 隐藏域，报错不可更改信息 -->
                	<input type="hidden" name="id" value="${voteTable.id}"/>
                	<input type="hidden" name="userId" value="${voteTable.userId }"/>
                	<input type="hidden" name="dataAddTime" value="<fmt:formatDate value='${voteTable.dataAddTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                		
                	</th>
                </tr>
                <tr>
                	<td class="w15">投票标题</td>
                    <td width="*"><span><input id="vSubject-input" class="t1000-company-text" type="text" name="vSubject" value="${voteTable.vSubject }"/></span><label></label></td>
                </tr>
                <tr>
                	<td class="w15">投票规则</td>
                    <td width="*"><span class="t1000-vote-radio-con">&nbsp&nbsp&nbsp&nbsp&nbsp IP2小时</span></td>
                </tr>
                <tr>
                	<td class="w15">投票简介</td>
                    <td width="*"><textarea name="vSummary" class="t1000-company-info">${voteTable.vSummary }</textarea></td>
                </tr>               
                <tr>
                	<td class="w15">投票有限期限</td>
                    <td width="*">
                    	<span class="t1000-vote-time-con">
                    		起始时间<input id="d242" class="Wdate t1000-time-text " type="text" name="beginTime"
                    			value="<fmt:formatDate value='${voteTable.beginTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"
                    			onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'d241\');}'})"/>
                    		结束时间<input id="d241" class="Wdate t1000-time-text " type="text" name="endTime"
                    			value="<fmt:formatDate value='${voteTable.endTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"
                    			onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'d242\');}'})"/>
                    	</span>
                    </td>
                </tr>
                <tr>
                	<td class="w15">是否开启状态</td>
                    <td width="*">
	                    <span class="t1000-vote-radio-con">
	                    	<c:if test="${voteTable.dataStatus==1}">
			                    <input class="t1000-vote-radio" name="dataStatus" type="radio" value="1" checked />开启
			                    <input class="t1000-vote-radio" type="radio" name="dataStatus" value="0"/>关闭
	                    	</c:if>
	                    	<c:if test="${voteTable.dataStatus==0}">
			                    <input class="t1000-vote-radio" name="dataStatus" type="radio" value="1"/>开启
			                    <input class="t1000-vote-radio" type="radio" name="dataStatus" value="0" checked/>关闭
	                    	</c:if>
	                    </span>
                    </td>
                </tr>
                
                <tr>
                	<td class="w15">投票主题链接</td>
                    <td width="*"><span class="t1000-vote-radio-con" style="padding-left: 20px">http://toupiao.99114.com/VoteItemStuff/selectVoteItemList/voteIndex/${voteTable.id}?tlength=9</span></td>
                </tr>
                
                <tr>
                	<td class="t1000-company-btn" colspan="2">
                        <span>
                            <input id="voteMotify" type="submit" class="t1000-batch-btn1" value="保存"/>
                            <input id="returnBtn" type="submit" class="t1000-batch-btn2" value="取消" onclick=""/>
                        </span>
                    </td>
                </tr>
        </table>  
      </form>  	
    </div>

<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/right.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/time/WdatePicker.js"></script>
<script type="text/javascript">
$(function(){
	//表单验证
	$("#voteMotify").click(function(){
		var vSubject = $("#vSubject-input").val().trim();
		var start = $("#d241").val();
		var end = $("#d242").val();
		
		if(vSubject==''){
			alert("请输入投票主题");
			return false;
		}
		
		if(start == '' || end == ''){
			alert("请输入起始时间或结束时间");
			return false;
		}
	});
	
	
	
});
</script>
</body>
</html>
