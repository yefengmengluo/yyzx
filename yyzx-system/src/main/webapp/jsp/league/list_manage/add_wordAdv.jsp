<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文字广告</title>
<link href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="t1000-votB-R-in clearfix">

		<div class="advertising-siteManagement-tit clearfix">
			<h2 class="t1000-tit">文字广告</h2>
		</div>
		<div class="advertising-word-con">
			<div class="advertising-word-con-tit">
				<ul>
					<c:forEach items="${industrys}" var="industry">
						<li>
							<input name="industrys[]" type="checkbox" value="${industry.id}"/>${industry.paramName}
						</li>
					</c:forEach>
					<li><input type="checkbox" class="checkAll"/><span>全选</span></li>
				</ul>
			</div>
			<div class="advertising-word-content">
				<table class="word-in-table" cellpadding="0" cellspacing="0">
					<tr>
						<td class="textInp1">
							<span>标题1</span>
							<input name="title" type="text" class="focus_on"/>
						</td>
						<td class="textInp1">
							<span>URL地址</span>
							<input name="targetUrl" type="text" class="focus_on" value="http://"/>
						</td>
						<td class="textInp2">
							<span>发布时间</span>
							<input id="d11" name="startTime" type="text" class="Wdate focus_on" 
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'d12\');}'})"/>
						</td>
						<td class="textInp2">
							<span>结束时间</span>
							<input id="d12" name="endTime" type="text" class="Wdate focus_on"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d11\');}'})"/>
						</td>
						<td class="textInp3">
							<span>排序号</span>						
							<input type="text" class="paixuhao" value="1"/>							
						</td>
						
						<td class="btn">
							<span class="red">标红</span>
							<input type="checkbox" name="single[]" class="single"/>
							<input type="submit" value="发布" class="fabu1" />
						</td>
					</tr>
					<tr>
						<td class="textInp1">
							<span>标题2</span>
							<input name="title" type="text" class="focus_on"/>
						</td>
						<td class="textInp1">
							<span>URL地址</span>
							<input name="targetUrl" type="text" class="focus_on" value="http://"/>
						</td>
						<td class="textInp2">
							<span>发布时间</span>
							<input id="d21" name="startTime" type="text" class="Wdate focus_on" 
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'d22\');}'})"/>
						</td>
						<td class="textInp2">
							<span>结束时间</span>
							<input id="d22" name="endTime" type="text" class="Wdate focus_on"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d21\');}'})"/>
						</td>
						<td class="textInp3">
							<span>排序号</span>						
							<input type="text" class="paixuhao" value="2"/>							
						</td>
						
						<td class="btn">
							<span class="red">标红</span>
							<input type="checkbox" name="single[]" class="single"/>
							<input type="submit" value="发布"  class="fabu1" />
						</td>
					</tr>
					<tr>
						<td class="textInp1">
							<span>标题3</span>
							<input name="title" type="text" class="focus_on"/>
						</td>
						<td class="textInp1">
							<span>URL地址</span>
							<input name="targetUrl" type="text" class="focus_on" value="http://"/>
						</td>
						<td class="textInp2">
							<span>发布时间</span>
							<input id="d31" name="startTime" type="text" class="Wdate focus_on" 
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'d32\');}'})"/>
						</td>
						<td class="textInp2">
							<span>结束时间</span>
							<input id="d32" name="endTime" type="text" class="Wdate focus_on"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d31\');}'})"/>
						</td>
						<td class="textInp3">
							<span>排序号</span>						
							<input type="text" class="paixuhao" value="3"/>							
						</td>
						
						<td class="btn">
							<span class="red">标红</span>
							<input type="checkbox" name="single[]" class="single"/>
							<input type="submit" value="发布"  class="fabu1" />
						</td>
					</tr>
					<tr>
						<td class="textInp1">
							<span>标题4</span>
							<input name="title" type="text" class="focus_on"/>
						</td>
						<td class="textInp1">
							<span>URL地址</span>
							<input name="targetUrl" type="text" class="focus_on" value="http://"/>
						</td>
						<td class="textInp2">
							<span>发布时间</span>
							<input id="d41" name="startTime" type="text" class="Wdate focus_on" 
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'d42\');}'})"/>
						</td>
						<td class="textInp2">
							<span>结束时间</span>
							<input id="d42" name="endTime" type="text" class="Wdate focus_on"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d41\');}'})"/>
						</td>
						<td class="textInp3">
							<span>排序号</span>						
							<input type="text" class="paixuhao" value="4"/>							
						</td>
						
						<td class="btn">
							<span class="red">标红</span>
							<input type="checkbox" name="single[]" class="single"/>
							<input type="submit" value="发布"  class="fabu1" />
						</td>
					</tr>
					<tr>
						<td class="textInp1">
							<span>标题5</span>
							<input name="title" type="text" class="focus_on"/>
						</td>
						<td class="textInp1">
							<span>URL地址</span>
							<input name="targetUrl" type="text" class="focus_on" value="http://"/>
						</td>
						<td class="textInp2">
							<span>发布时间</span>
							<input id="d51" name="startTime" type="text" class="Wdate focus_on" 
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'d52\');}'})"/>
						</td>
						<td class="textInp2">
							<span>结束时间</span>
							<input id="d52" name="endTime" type="text" class="Wdate focus_on"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'d51\');}'})"/>
						</td>
						<td class="textInp3">
							<span>排序号</span>						
							<input type="text" class="paixuhao" value="5"/>							
						</td>
						
						<td class="btn">
							<span class="red">标红</span>
							<input type="checkbox" name="single[]" class="single"/>
							<input type="submit" value="发布"  class="fabu1" />
						</td>
					</tr>
				</table>
			</div>


		</div>
		<!-- <div class="button">
			<input type="button" class="advertising-com-search-con-btn1" value="返回" />
		</div> -->
	</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/league/right.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/time/WdatePicker.js"></script>
<script type="text/javascript">
	$(function(){
		$(".checkAll").click(function() {
			$("input[name='industrys[]']").prop("checked", this.checked);
		});
	
	
	})
$(function(){
	$(":submit").click(function(){
		var $currObj = $(this);
		//获取选中状态的行业id
		var ids = $("input[name='industrys[]']:checked");
		var industryIds = new Array();
		ids.each(function(){
			industryIds.push($(this).val());
		});
		
		if(industryIds.length == 0){
			alert("请选择行业");
			return false;
		}
		industryIds = industryIds.join(",");
		
		//获取当前行的提交值
		var title = $(this).parent().parent().children().eq(0).children(":input").val().trim();
		var targetUrl = $(this).parent().parent().children().eq(1).children(":input").val();
		var startTime = $(this).parent().parent().children().eq(2).children(":input").val();
		var endTime = $(this).parent().parent().children().eq(3).children(":input").val();
		var order = $(this).parent().parent().children().eq(4).children(":input").val();
		var redFlag = $(this).parent().children().eq(1).attr("checked")=="checked";
		if(redFlag == true){
			redFlag = 1;//标红为1
		}else{
			redFlag = 0;//未标红为0
		}
		if(title==""){
			alert("请输入文字广告标题");
			return false;
		}
		
		 var strRegex = '^((https|http|ftp|rtsp|mms)?://)'

			    + '?(([0-9a-z_!~*\'().&=+$%-]+: )?[0-9a-z_!~*\'().&=+$%-]+@)?' //ftp的user@

			    + '(([0-9]{1,3}.){3}[0-9]{1,3}' // IP形式的URL- 199.194.52.184

			    + '|' // 允许IP和DOMAIN（域名）

			    + '([0-9a-z_!~*\'()-]+.)*' // 域名- www.

			    + '([0-9a-z][0-9a-z-]{0,61})?[0-9a-z].' // 二级域名

			    + '[a-z]{2,6})' // first level domain- .com or .museum

			    + '(:[0-9]{1,4})?' // 端口- :80

			    + '((/?)|' // a slash isn't required if there is no file name

			    + '(/[0-9a-z_!~*\'().;?:@&=+$,%#-]+)+/?)$';
		 
		 var re=/http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
		// var re=new RegExp(strRegex);
		 
		 alert(!re.test(targetUrl));
		 
		if(!re.test(targetUrl) &&!(targetUrl=="#")){
			alert("请输入正确的跳转链接,无跳转链接请用 # 代替 ");
			return false;
		}
		
		if(startTime == '' || endTime == ''){
			alert("请选择开始时间和结束时间");
			return false;
		}
		
		$.ajax({
		    url:"${pageContext.request.contextPath }/league/addWordAdvInfo",
		    type: "POST",
			dataType : "json",
   		 	data:{"industryIds":industryIds,"title":title,"targetUrl":targetUrl,
		    	"startTime":startTime,"endTime":endTime,"redFlag":redFlag,"order":order},
		    success:function(data){
		    	var executeStatus = data;
		    	if(data == 1){
		    		//alert("发布成功");
		    		$currObj.val("已发布").css("color","#999");
		    		$currObj.closest("tr").find(":input").attr('disabled','disabled');	
		    	}else{
		    		alert("发布失败");
		    	}
		    	
		    }
		});
		
		
	});
	
});
</script>
</body>
</html>
