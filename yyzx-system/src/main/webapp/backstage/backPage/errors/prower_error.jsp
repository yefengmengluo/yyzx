<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/backstage/css/common/Base.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/backstage/css/common/404.css"/>
<body  class="bgbody">

<div style="opacity: 1;" class="dialog">
    <div  class="icon">
        <img src="${pageContext.request.contextPath }/backstage/images/t1000/error/error.png">
    </div>
    <h1 style="opacity: 1;">非常抱歉，您暂无权限访问!</h1>
    <p style="opacity: 1;" class="info">您的权限不足，请走别的通道!</p>
    <p style="opacity: 1;" class="goback"><a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath }/backstage/images/t1000/error/return.png" /></a></p>


    

  </div>

  <script src="${pageContext.request.contextPath }/backstage/js/jquery-1.8.0.min.js"></script>
  <script src="${pageContext.request.contextPath }/backstage/js/404.js"></script>
</body>
</html>
