<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>投票系统-登录页</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/login.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<div class="t1000-loginBox">
	<h2 class="t1000-login-tit">中国网库投票后台管理系统</h2>
	<form action="javascript:void(0)" method="post" id="loginform" accept-charset="utf-8"><input name="url" type="hidden"/>
    <ul class="t1000-login-ul">
    	<li><span>用户名：</span><input class="t1000-login-inp" type="text" id="login_username" name="username" value=""/></li>
        <li><span>密码：</span><input class="t1000-login-inp" type="password" id="login_password" name="password" value=""/></li>
        <li><span>验证码：</span><input class="t1000-login-verCode" type="text" id="code" name="code" value="" /><img src="${pageContext.request.contextPath }/code"  id="captchaImage"/><a id="change">换一张？</a></li>
        <li class="remember"><span></span><input id="login_remmberMe" name="remember" value="1" type="checkbox"/> <label for="remember">记住密码</label></li>
        <li><span></span><input class="t1000-login-submit" type="submit" id="login" value="登录"/></li>
    </ul>
    </form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/loginPopupLayer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/jquery.cookie.js"></script>
<script type="text/javascript">
	$(function(){
		if ($.cookie("rmbUser") == "true") {
			$("#login_remmberMe").attr("checked", true);
			$("#login_username").val($.cookie("userName"));
			$("#login_password").val($.cookie("passWord"));
			//alert("$.cookie('userName'):"+$.cookie("userName")+"passWord"+$.cookie("passWord"));
		} 
	   $("#login").click(function(){
		   //alert($("#login_username").val());
		   //alert($("input[name='username']").val());
		   if(validataLoginParam()==true){
			   var validateUrl="${pageContext.request.contextPath }/code?id="+new Date().getTime();
			   var limitUrl="${pageContext.request.contextPath }/left.jsp";
			   var casRemoteLoginUrl="${pageContext.request.contextPath }/loginController/queryOneByAccount";
			   loginSubmit(casRemoteLoginUrl,limitUrl,validateUrl);
		   }
		})
		//点击更换验证码：
		$("#captchaImage").click(function(){//点击更换验证码
			$(this).attr("src","${pageContext.request.contextPath }/code?id="+new Date().getTime());
		});
		//点击更换验证码：
		$("#change").click(function(){//点击更换验证码
			$("#captchaImage").attr("src","${pageContext.request.contextPath }/code?id="+new Date().getTime());
		});
	})
		 
	</script> 
</body>
</html>
