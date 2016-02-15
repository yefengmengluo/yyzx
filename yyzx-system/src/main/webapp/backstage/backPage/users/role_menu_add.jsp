<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>权限管理</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>


	<div class="t1000-votB-R-in">
        <form action="javascript:void(0)" method="post" id="useradd" accept-charset="utf-8">
        <table class="t1000-editTab" cellpadding="0" cellspacing="0">
       
            	<tr>
                	<th colspan="2">权限添加</th>
                </tr>
                <tr ><td > 
                	<p >&nbsp&nbsp权限名称：
                    <span><input class="t1000-company-text" type="text" id="siteName" name="siteName" value="" /><font color="red">   ( * 必填 )</font></span ><label class="t1000-success" id="siteName1" style="display:none">输入正确</label><label class="t1000-error" id="siteName2" style="display:none">必填项，请输入</label>
                </p>
               
                	<p >&nbsp&nbsp权限描述：
                    <span><input class="t1000-company-text" type="text" id="siteNickname" name="siteNickname" value=""/><font color="red">   ( * 必填 )</font></span><label class="t1000-success" id="siteNickname1" style="display:none">输入正确</label><label class="t1000-error" id="siteNickname2" style="display:none">必填项，请输入</label>
                </p>
                	<p >&nbsp&nbsp排 &nbsp&nbsp 序：
                    <span><input class="t1000-company-text" type="text" id="siteNickname" name="siteNickname" value=""/><font color="red">   ( * 必填 )</font></span><label class="t1000-success" id="siteNickname1" style="display:none">输入正确</label><label class="t1000-error" id="siteNickname2" style="display:none">必填项，请输入</label>
                	</p>
                	<p >&nbsp&nbsp启 &nbsp&nbsp用：&nbsp&nbsp&nbsp&nbsp<input type="radio"  name="flag_on" value="0"/>是&nbsp&nbsp&nbsp&nbsp<input type="radio"  name="flag_on" value="1"/>否
                </p>
                 <p >&nbsp&nbsp组 &nbsp&nbsp别：&nbsp&nbsp&nbsp&nbsp
                    <select>
	                    <option>投票系统</option>
	                    <option>广告联盟</option>
	                    <option>专题管理</option>
                    </select>
                    &nbsp&nbsp&nbsp&nbsp<input type="button" value="添加分组" class="addGroup"/>
                </p>
                    
                	&nbsp&nbsp操作员&nbsp：
                    <span width="*"><input class="t1000-company-text" type="text" id="realName" name="realName"  value=""/><font color="red">   ( * 必填 )</font></span><label class="t1000-success" id="realName1" style="display:none">输入正确</label><label class="t1000-error" id="realName2" style="display:none">真实姓名不能为空</label></td>
                </tr>
                <tr>
                	<td class="t1000-company-btn" colspan="2">
                	<input type="hidden" name="uPower" value="${sessionScope.user.userPower }"/>
                        <span>
                            <input type="submit" class="t1000-batch-btn1" id="addsave" value="保存"/>
                            <input type="button" class="t1000-batch-btn2" value="返回" onclick="location.href='javascript:history.go(-1);'"/>
                        </span>
                    </td>
                </tr></div>
        </table>  
	</form>
        	
    </div>




<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/right.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/user.js"></script>
<script type="text/javascript">
	$(function(){
		//添加分组名
		$(".addGroup").click(function(){
			var oneGroup="<div class='addGroupClass'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp新添组名：<input type='text'class='t1000-company-text' name='menuGroup'>&nbsp&nbsp<input type='button' class='saveGroup' value='保存'/>&nbsp&nbsp<input type='button' class='deleteGroup' value='删除'/></div>";
			$(".addGroup").after(oneGroup);
		})
		//保存分组
		$("div").on("click",".saveGroup",function(){
			$(this).parent().remove();
		})
		//删除分组
		$("div").on("click",".deleteGroup",function(){
			$(this).parent().remove();
		})
		
		
		
		$("#account").val("");
		$("#password").val("");
		//添加一个用户
	   $("#addsave").click(function(){
		   $(this).attr("disabled","true");
		   $(this).attr("value","正在保存");
			 var casRemoteLoginUrl="${pageContext.request.contextPath }/userController/addAllUser?uPower=${sessionScope.user.userPower }";
			 addsave(this,casRemoteLoginUrl);	 
		})
		$("#account").blur(function(){
			var casRemoteLoginUrl="${pageContext.request.contextPath }/userController/queryOneByUseraccount";
			checkAccount(casRemoteLoginUrl);
	})
	})
	
	</script> 
</body>
</html>
