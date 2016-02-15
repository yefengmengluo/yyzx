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
    	<ul>
        	<li><img src="${pageContext.request.contextPath }/backstage/images/liuyan/img1.jpg" /></li>
        	<li><img src="${pageContext.request.contextPath }/backstage/images/liuyan/img2.jpg" /></li>
        	<li><img src="${pageContext.request.contextPath }/backstage/images/liuyan/img3.jpg" /></li>
        	<li><img src="${pageContext.request.contextPath }/backstage/images/liuyan/img4.jpg" /></li>
        	<li><img src="${pageContext.request.contextPath }/backstage/images/liuyan/img5.jpg" /></li>
        	<li><img src="${pageContext.request.contextPath }/backstage/images/liuyan/img6.jpg" /></li>
        	<li><img src="${pageContext.request.contextPath }/backstage/images/liuyan/img7.jpg" /></li>
        	<li><img src="${pageContext.request.contextPath }/backstage/images/liuyan/img8.jpg" /></li>
        	<li><img src="${pageContext.request.contextPath }/backstage/images/liuyan/img9.jpg" /></li>
        </ul>
    </div>
</div>
<div class="tuiguang-ind-apply" id="tuiguang-ind-apply" module="user" bestfitmodule="" refusemodule="global-common-*">
	<div class="tuiguang-ind-apply-content" content="">
    	<div class="tuiguang-ind-apply-content-tell">
        	<h2 headline="">电话申请：</h2>
            <p>400-813-1093 &nbsp;&nbsp;&nbsp;QQ：2638348960</p>
        </div>
        <div class="tuiguang-ind-apply-content-online">
        	<h2 headline="">在线申请</h2>
        	
        </div>
        <div class="tuiguang-ind-apply-content-user">
         <form action="javascript:void(0)" method="post" id="liuyanadd" accept-charset="utf-8">
         <input type="hidden" id="specId" name="specId" value="1"/>
        	<div class="floatL">公司名称：<input type="text" id="copName" name="copName" value=""/><span>*</span></div>
        	<div class="floatR">联系人：<input type="text" value="填写申请人的真实姓名" id="linkman" name="linkman" /><span class="star">*</span></div>
        	<div class="floatL">联系电话：<input type="text" value="手机必填" id="mobile"  name="mobile" />	
        	<span>*</span>
        	<span class="t1000-success" id="mobile1" style="display:none;"></span><span class="t1000-error" id="mobile2" style="display:none;"></span>
        	</div>
        	<div class="floatR">备 &nbsp;&nbsp;注：<input type="text" id="comment"  name="comment"/></div>
            <div class="button">
              <input type="submit" class="t1000-batch-btn1" id="addsave" value="" />
            
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
			
		})
		
		
	})
	
	</script> 
<script type="text/javascript"> var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://"); document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F92c4ad978daa89418ca0275f86b262e3' type='text/javascript'%3E%3C/script%3E")) </script>


</body>
</html>
