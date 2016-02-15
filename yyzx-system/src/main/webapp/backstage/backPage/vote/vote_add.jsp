<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>投票主题</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>
	<div class="t1000-votB-R-in clearfix">
        <form action="${pageContext.request.contextPath }/vote/voteAdd" method="post">
	        <table class="t1000-editTab" cellpadding="0" cellspacing="0">
	            	<tr>
	                	<th colspan="2">基本信息</th>
	                </tr>
	                <tr>
	                	<td class="w15">投票标题</td>
	                    <td width="*">
		                    <span>
			                    <input id="vSubject-input" class="t1000-company-text" type="text" name="vSubject" value=""/>
			                    <font color="red">( * 必填项 )</font>
		                    </span>
		                    <label></label>
	                    </td>
	                </tr>
	                <tr>
	                	<td class="w15">投票规则</td>
	                    <td width="*"><span class="t1000-vote-radio-con">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; IP2小时</span></td>
	                </tr>
	                <tr>
	                	<td class="w15">投票简介</td>
	                    <td width="*"><textarea class="t1000-company-info" name="vSummary"></textarea></td>
	                </tr>
	                <!--<tr>
	                	<td class="w15">允许多选投票</td>
	                    <td width="*"><span class="t1000-vote-checkbox-con"><input class="t1000-vote-checkbox" type="checkbox" value=""/>允许多选<b>最多可选<input class="t1000-vote-max" type="text" value=""/>人</b></span></td>
	                </tr>-->
	                <tr>
	                	<td class="w15">投票有限期限</td>
	                    <td width="*">
	                    	<span class="t1000-vote-time-con">
	                    		起始时间<input id="d242" class="Wdate t1000-time-text" type="text" name="beginTime" value=""
	                    				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'d241\');}'})"/>
	                    		结束时间<input id="d241" class="Wdate t1000-time-text" type="text" name="endTime" value=""
	                    				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'d242\');}'})"/>
	                    	</span>
	                    	<font color="red">( * 必填项 )</font>
	                    </td>
	                </tr>
	                
	                <tr>
	                	<td class="w15">是否开启状态</td>
	                    <td width="*">
		                    <span class="t1000-vote-radio-con">
				                    <input class="t1000-vote-radio" type="radio" name="dataStatus" value="1" checked="checked" />开启
				                    <input class="t1000-vote-radio" type="radio" name="dataStatus" value="0"/>关闭
		                    </span>
	                    </td>
	                </tr>
	                
	                <tr>
	                	<td class="t1000-company-btn" colspan="2">
	                        <span>
	                            <input id="form-commit" type="submit" class="t1000-batch-btn1" value="保存"/>
	                            <input id="return" type="button" class="t1000-batch-btn2" value="取消" onclick="javascript:history.go(-1)"/>
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
	$("#form-commit").click(function(){
		var vSubject = $("#vSubject-input").val().trim();
		var start = $("#d241").val();
		var end = $("#d242").val();
		
		if(vSubject==''){
			alert("请输入投票标题");
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
