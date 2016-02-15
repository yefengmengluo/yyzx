<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>推广专题</title>

<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/css.css" type="text/css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/module.css" type="text/css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<div class="tuiguang-ind-img" id="tuiguang-ind-img" module="advertising" bestfitmodule="global-common-pic-list" refusemodule="global-common-text-list,global-common-text-list-date,global-common-pic-list-text,advertising-common-*">
	<div class="tuiguang-ind-img-content" content="">
    	
    </div>
</div>
<div class="tuiguang-ind-apply" id="tuiguang-ind-apply" module="user" bestfitmodule="" refusemodule="global-common-*">
	<div class="tuiguang-ind-apply-content" content="">
    	<div class="tuiguang-ind-apply-content-tell">
        	<h2 headline="">电话申请：</h2>
            <p>400-813-1093 &nbsp;&nbsp;&nbsp;QQ：2638348960</p>
        </div>
        <div class="tuiguang-ind-apply-content-online">
        	<h2 headline="">留言成功</h2>
        	
        </div>
        <div class="tuiguang-ind-apply-content-user">
        	
           </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/right.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/addliuyan.js"></script>
<script type="text/javascript">
	$(function(){
			
		
		
		//添加留言
	   $("#addsave").click(function(){
			 var casRemoteLoginUrl="${pageContext.request.contextPath }/liuYanController/addLiuYan";
			 addsave(casRemoteLoginUrl);	
			location.replace( "${pageContext.request.contextPath }/backstage/backPage/liuyan/home.jsp" );
		})
		
		
		
		
		
		
		
	})
	
	</script> 



</body>
</html>
