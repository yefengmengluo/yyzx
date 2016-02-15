/**
 * user_add.jsp  user_edit.jsp页面使用的js
 **/
//
$("#siteName").blur(function(){
	   if($("#siteName").val()==""){
			  $("#siteName2").show();
			  $("#siteName1").hide();
			  //$("#siteName").focus();
	   }else{
		   $("#siteName1").show();
		   $("#siteName2").hide();
	 } 
	})
/*	function siteName(){
	   if($("#siteName").val()==""){
			  $("#siteName2").show();
			  $("#siteName1").hide();
			  //return true;
	   }else{
		   $("#siteName1").show();
		   $("#siteName2").hide();
		   //return false;
	 } 
	}*/
$("#siteNickname").blur(function(){
	   if($("#siteNickname").val()==""){
			  $("#siteNickname2").show();
			  $("#siteNickname1").hide();
			 // $("#siteNickname").focus();
	   }else{
		   $("#siteNickname1").show();
		   $("#siteNickname2").hide();
	 } 
	})
$("#webUrl").blur(function(){
		var homepage=$("#webUrl").val();
		var Expression=/http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
	   if($("#webUrl").val()==""||!Expression.test(homepage)){
			  $("#webUrl2").show();
			  $("#webUrl1").hide();
			 // $("#webUrl").focus();
	   }else{
		   $("#webUrl1").show();
		   $("#webUrl2").hide();
	 } 
	})
$("#realName").blur(function(){
	   if($("#realName").val()==""){
			  $("#realName2").show();
			  $("#realName1").hide();
			 // $("#realName").focus();
	   }else{
		   $("#realName1").show();
		   $("#realName2").hide();
	 } 
	})
$("#mobile").blur(function(){
	var mob=$("#mobile").val();
	var regMobile=/^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|17[0-9]{9}$|18[0-9]{9}$/;
	   if($("#mobile").val()==""||!(regMobile.test(mob))){
			  $("#mobile2").show();
			  $("#mobile1").hide();
			 // $("#mobile").focus();
	   }else{
		   $("#mobile1").show();
		   $("#mobile2").hide();
	 } 
	})
/*$("#account").blur(function(){
	   if($("#account").val()==""){
			  $("#account2").show();
			  $("#account1").hide();
			  $("#account").focus();
	   }else{
		   $("#account1").show();
		   $("#account2").hide();
	 } 
	})*/
function checkAccount(casRemoteLoginUrl){
	 if($("#account").val()==""){
		  $("#account2").show();
		  $("#account1").hide();
		  $("#accounthidden").val("0");
		 // $("#account").focus();
	}else{
		if($("#account").val()==$("#accounthidden").val()){
			//$("#accounthidden").val(1);
		}else{
		$.post(casRemoteLoginUrl,
				{"account":$("#account").val()},
				function(code){
					$("#accounthidden").val(code);
					if(code=="0"){
						  $("#account3").show();
						  $("#account1").hide();
						  $("#account2").hide();
						 // $("#account").focus();
					}else{
						 $("#account1").show();
						 $("#account2").hide();
						 $("#account3").hide();
					}
				}
		   )
		}
	}
}
	$("#password").blur(function(){
		if($("#password").val()==""||$("#password").val().length<6){
			$("#password2").show();
			$("#password1").hide();
			$("#password").val("");
			//$("#password").focus();
		}else{
			$("#password1").show();
			$("#password2").hide();
		} 
	})
	$("#passwordedit").blur(function(){
		if($("#passwordedit").val().length<6){
			$("#password2").show();
			$("#password1").hide();
			$("#passwordedit").val("");
			//$("#passwordedit").focus();
		}else{
			$("#password1").show();
			$("#password2").hide();
		} 
	})
/*
 * =====================添加提交的js验证===========================================
 */
	
	function addsave(obj,casRemoteLoginUrl){
		   var homepage=$("#webUrl").val();
			var Expression=/http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
			var mob=$("#mobile").val();
			var regMobile=/^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|17[0-9]{9}$|18[0-9]{9}$/;
			
		  if($("#siteName").val()==""||$("#webUrl").val()==""||$("#mobile").val()==""|| $("#accounthidden").val()=="0"||$("#password").val()==""||$("#realName").val()==""||$("#siteNickname").val()==""){//
			 // alert($("#accounthidden").val());
				alert("信息错误！请正确填写信息！");  
				 $(obj).removeAttr("disabled");
		          $(obj).attr("value","保存");
		  }else if(!Expression.test(homepage)){  
			  alert("网址格式不正确！请重新填写！如：http://xxx");
			  $("#webUrl2").show();
			  $("#webUrl1").hide();
			  $("#webUrl").focus();
			  $(obj).removeAttr("disabled");
	          $(obj).attr("value","保存");
			//手机号验证判断
		  }else if(!(regMobile.test(mob))){   
			  alert("您输入的手机号码有误，请重新填写！");
			  $("#mobile2").show();
			  $("#mobile1").hide();
			  $("#mobile").focus();
			  $(obj).removeAttr("disabled");
	          $(obj).attr("value","保存");
			  //密码判断
		  }else if($("#password").val().length<6){
		   	alert("密码不得少于6位！");
		   	$("#password").focus();
		    $(obj).removeAttr("disabled");
	          $(obj).attr("value","保存");
		  //成功提交修改
		  }else{
			$("#useradd").attr("action",casRemoteLoginUrl);
		  }
		 
		}
/*
 * =================修改提交js验证======================================
 */
	
		//提交修改信息判断
	 
		   function userupdate(obj,casRemoteLoginUrl){
		   var homepage=$("#webUrl").val();
			var Expression=/http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;//网址验证
			var mob=$("#mobile").val();
			var regMobile=/^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|17[0-9]{9}$|18[0-9]{9}$/;//手机号验证
		  if($("#siteName").val()==""||$("#webUrl").val()==""||$("#mobile").val()==""||$("#accounthidden").val()=="0"||$("#realName").val()==""||$("#siteNickname").val()==""){//
				alert("信息错误！请正确填写信息！");  
				  $(obj).removeAttr("disabled");
		          $(obj).attr("value","更新");
				//网址验证判断
		  }else if(!Expression.test(homepage)){  
			  alert("网址格式不正确！请重新填写！如：http://xxx");
			  $("#webUrl2").show();
			  $("#webUrl1").hide();
			  $("#webUrl").focus();
			  $(obj).removeAttr("disabled");
	          $(obj).attr("value","更新");
			//手机号验证判断
		  }else if(!(regMobile.test(mob))){   
			  alert("您输入的手机号码有误，请重新填写！");
			  $("#mobile2").show();
			  $("#mobile1").hide();
			  $("#mobile").focus();
			  $(obj).removeAttr("disabled");
	          $(obj).attr("value","更新");
			  //密码判断
		  }else if(!($("#passwordedit").val()=="")&&$("#passwordedit").val().length<6){
		   	alert("密码不得少于6位！");
		   	$("#passwordedit").focus();
		    $(obj).removeAttr("disabled");
	          $(obj).attr("value","更新");
		  //成功提交修改
		   }else{
			$("#userup").attr("action",casRemoteLoginUrl);
		  }
		
		}
		 
		 