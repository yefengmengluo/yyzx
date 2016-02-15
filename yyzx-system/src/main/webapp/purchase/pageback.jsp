<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/backstage/css/pay/purchase/pay-back.css" />
<title>采购信息详情</title>
</head>
<body>
	<div class="pay-back-common">
    	<div class="pay-back-common-con">
        	<div class="pay-back-title"><h2>标&nbsp;&nbsp;&nbsp;&nbsp;题：<span>${ purchase.title }</span></h2></div>
            <div class="pay-back-linkman">联 系 人：<span>${ purchase.linkman}</span></div>
            <div class="pay-back-tell">电&nbsp;&nbsp;&nbsp;&nbsp;话：<span>${purchase.tel }</span></div>
            <div class="pay-back-name">企业名称：<a href="http://shop.99114.com/${memberBasic.memberId }" target="_blank">${memberBasic.corporationName }</a></div>
            <div class="pay-back-introduction">企业简介：<p>
            ${(empty memberBasic.summary)? '暂无简介':memberBasic.summary }</p></div>
        	<div class="pay-back-information">该信息已发送您的手机，请注意查收！</div>
        </div>
    </div>
</body>
</html>