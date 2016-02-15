/**
 * user_add.jsp  user_edit.jsp页面使用的js
 **/
//
$("#specId").blur(function(){
	   if($("#specId").val()==""){
			  $("#specId2").show();
			  $("#specId1").hide();
			  //$("#siteName").focus();
	   }else{
		   $("#specId1").show();
		   $("#specId2").hide();
	 } 
	})
	
$("#specId").blur(function(){
	var id=$("#specId").val();
	var regId=/^[0-9]*$/;
	   if($("#specId").val()==""||!(regId.test(id))){
			  $("#specId2").show();
			  $("#specId1").hide();
			 // $("#mobile").focus();
	   }else{
		   $("#mobile1").show();
		   $("#mobile2").hide();
	 } 
	})
$("#copName").blur(function(){
	   if($("#copName").val()==""){
			  $("#copName2").show();
			  $("#copName1").hide();
			 // $("#siteNickname").focus();
	   }else{
		   $("#copName1").show();
		   $("#copName2").hide();
	 } 
	})
$("#linkman").blur(function(){
		var homepage=$("#linkman").val();
	
		 if($("#linkman").val()==""){
			  $("#linkman2").show();
			  $("#linkman1").hide();
			 // $("#siteNickname").focus();
	   }else{
		   $("#linkman1").show();
		   $("#linkman2").hide();
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

	
/*
 * =====================添加提交的js验证===========================================
 */
	
	function addsave(casRemoteLoginUrl){
			var mob=$("#mobile").val();
			var regMobile=/^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|17[0-9]{9}$|18[0-9]{9}$/;
		  if($("#copName").val()==""||$("#mobile").val()==""|| $("#linkman").val()=="0"){//
				alert("信息错误！请正确填写信息！");  
		  }else if(!(regMobile.test(mob))){   
			  alert("您输入的手机号码有误，请重新填写！");
			  $("#mobile2").show();
			  $("#mobile1").hide();
			  $("#mobile").focus();
		
		  }else{
			$("#liuyanadd").attr("action",casRemoteLoginUrl);
		  }
		}
/*
 * =================修改提交js验证======================================
 */
	
		//提交修改信息判断
	 
		   function liuyanupdate(casRemoteLoginUrl){
		  
			var mob=$("#mobile").val();
			var regMobile=/^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|17[0-9]{9}$|18[0-9]{9}$/;//手机号验证
			 if($("#copName").val()==""||$("#mobile").val()==""|| $("#linkman").val()=="0"){//
					alert("信息错误！请正确填写信息！");  
			  }else if(!(regMobile.test(mob))){   
			  alert("您输入的手机号码有误，请重新填写！");
			  $("#mobile2").show();
			  $("#mobile1").hide();
			  $("#mobile").focus();
			  //密码判断
		  }else{
			$("#liuyanup").attr("action",casRemoteLoginUrl);
		  }
		}
		 
		 