<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>权限修改</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>



	<div class="t1000-votB-R-in">
       <form action="javascript:void(0)" method="post" id="userup" accept-charset="utf-8">
        <table class="t1000-editTab" cellpadding="0" cellspacing="0">
            	<tr>
                	<th colspan="2">基本信息</th>
                </tr>
                <tr>
                	<td class="w15">账户名</td>
                    <td width="*"><span><input class="t1000-company-text" type="text" id="account" name="account" value="${user. account}"/>
                    <input class="t1000-company-text" type="hidden" id="accounthidden" name="accounthidden" value="${user. account}"/></span>
                    <label class="t1000-success" id="account1" style="display:none">输入正确</label>
                    <label class="t1000-error" id="account2" style="display:none">此项必填</label>
                    <label class="t1000-error" id="account3" style="display:none">该账户已存在！</label></td>
                </tr>
               
                <tr>
                	<td class="w15">公司名称</td>
                    <td width="*"><span><input class="t1000-company-text" type="text" id="siteNickname" name="siteNickname" value="${user. siteNickname}"/></span>
                    <label class="t1000-success" id="siteNickname1" style="display:none">输入正确</label><label class="t1000-error" id="siteNickname2" style="display:none">必填项，请输入</label></td>
                </tr>
                <tr>
                	<td class="w15">网站URL</td>
                    <td width="*"><span><input class="t1000-company-text" type="text" id="webUrl" name="webUrl" value="${user. webUrl}"/></span>
                    <label class="t1000-success" id="webUrl1" style="display:none">输入正确</label><label class="t1000-error" id="webUrl2" style="display:none">输入错误，请重新输入</label></td>
                </tr>
                
                <tr>
                	<td class="w15">电话</td>
                    <td width="*"><span><input class="t1000-company-text" type="text" id="mobile"  name="mobile" value="${user. mobile}"/></span>
                    <label class="t1000-success" id="mobile1" style="display:none">输入正确</label><label class="t1000-error" id="mobile2" style="display:none">输入错误，请重新输入</label></td>
                </tr>
				 <tr>
                	<td class="w15">用户说明</td>
                    <td width="*"><span><input class="t1000-company-text" type="text" id="siteName" name="siteName" value="${user. siteName}"/></span >
                    <label class="t1000-success" id="siteName1" style="display:none">输入正确</label><label class="t1000-error" id="siteName2" style="display:none">必填项，请输入</label></td>
                </tr>
                <tr>
                	<th colspan="2">修改账户</th>
                </tr>
                
                <tr>
                	<td class="w15">密码</td>
                    <td width="*"><span><input class="t1000-company-text noRead" type="password" id="passwordedit"  name="newpaw" value=""/><input type="hidden" id="password0" value="${user. password}"/> </span>
                    <label class="t1000-success" id="password1" style="display:none">输入正确</label><label class="t1000-error" id="password2" style="display:none">密码必须大于6位，请重新输入</label></td>
                </tr>
				 <tr>
				
                	<td class="w15">角色管理<input type="hidden" class="userpower" value="${user. userPower}"/></td>
                    <td width="*"><span class="t1000-vote-radio-con">
	                    <input class="t1000-vote-radio" id="userPower1"  name="userPower" type="radio" value="1"  />管理员
	                    <c:if test="${sessionScope.user.userPower==0 }">
	                    <input class="t1000-vote-radio" id="userPower0" type="radio" name="userPower" value="0"/>超级管理员
	                    </c:if>
	                     <ul>
	                   <li> <input class="t1000-vote-radio" id="userPower21" type="radio" name="userPower" value="21"/>投票系统
	                    <input class="t1000-vote-radio" type="radio" id="userPower22" name="userPower" value="22"/>广告联盟
	                    <input class="t1000-vote-radio" type="radio" id="userPower23" name="userPower" value="23"/>专题留言
	                   
	                   </li> </ul></span></td>
               
				<%--  <c:if test="${user. userPower==0}">
                	<td class="w15">管理权限</td>
                    <td width="*"><span class="t1000-vote-radio-con"><input class="t1000-vote-radio" id="userPower"  name="userPower" type="radio" value="1"  />管理员<input class="t1000-vote-radio" type="radio" name="userPower" value="0" checked/>超级管理员</span></td>
                 </c:if> --%>
                </tr>
                <tr>
                	<td class="w15">操作员姓名</td>
                    <td width="*"><span><input class="t1000-company-text" type="text" id="realName" name="realName"  value="${user. realName}"/></span>
                    <label class="t1000-success" id="realName1" style="display:none">输入正确</label><label class="t1000-error" id="realName2" style="display:none">真实姓名不能为空</label></td>
                </tr>
                <tr>
                	<td class="t1000-company-btn" colspan="2">
                	<input type="hidden" name="userId" value="${user. userId}"/>
                	<input type="hidden" name="uPower" value="${sessionScope.user.userPower }"/>
                	<input type="hidden" id="currentNum"name="currentNum" value="${page.currentNum }"/>
                	
                        <span>
                            <input type="submit" class="t1000-batch-btn1" id="userupdate" value="更新"/>
                            <input type="button" class="t1000-batch-btn2" value="返回" onclick="location.href='javascript:history.go(-1);'"/>
                        </span>
                    </td>
                </tr>
        </table>  

        </form>
        	
    </div>



<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/right.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/user.js"></script>
<script type="text/javascript">
	$(function(){
		 $("#userupdate").click(function(){
			 $(this).attr("disabled","true");
			 $(this).attr("value","更新中");
			var currentNum=$("#currentNum").val();
			/* if($("#passwordedit").val()==""){
				var p=$("#password0").val();
				$("#passwordedit").val(p);
			} */
			var casRemoteLoginUrl="${pageContext.request.contextPath }/userController/modifyUser?currentNum="+currentNum;
		 	userupdate(this,casRemoteLoginUrl);
		 })
	   $("#account").blur(function(){
			var casRemoteLoginUrl="${pageContext.request.contextPath }/userController/queryOneByUseraccount";
			checkAccount(casRemoteLoginUrl);
	})
	//alert($(".userpower").val());
		 var upower=$(".userpower").val();
		 if(upower==0){
			 $("#userPower0").attr("checked",true);
		 }else if(upower==1){
			 $("#userPower1").attr("checked",true);
		 }else if(upower==21){
			 $("#userPower21").attr("checked",true);
		 }else if(upower==22){
			 $("#userPower22").attr("checked",true);
		 }else if(upower==23){
			 $("#userPower23").attr("checked",true);
		 }
	})
	</script> 
</body>
</html>
