$("input[name='mobile']").focus(function() {
				if ($("input[name='mobile']").val() == "手机必填") {
					$(this).val("")
				}
			})
			$("input[name='mobile']").blur(
					function() {
						var str = $("input[name='mobile']").val();
						reg1 = /^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/;
						reg2 = /^((\(\d{2,3}\))|(\d{3}\-))?15\d{9}$/;
						reg3 = /^((\(\d{2,3}\))|(\d{3}\-))?18\d{9}$/;
						reg4 = /^((\(\d{2,3}\))|(\d{3}\-))?14\d{9}$/;
						if ((!reg1.test(str)) && (!reg2.test(str))
								&& (!reg3.test(str)) && (!reg4.test(str))) { 
							$("input[name='mobile']").val("手机必填")
							$("input[name='mobile']").css({
								"border" : "1px solid #f00"
							});
							return false;
						} else {
							$("input[name='mobile']").css({
								"border" : "1px solid #dedede"
							});
						}
					})
		
		
		
		

$("input[name='copName']").focus(function() {
				if ($("input[name='copName']").val() == "请输入公司名称") {
					$(this).val("")
				}
			})
			$("input[name='copName']").blur(
					function() {
						var str = $("input[name='copName']").val();
						
						if ($("#copName").val()=="") { 
							$("input[name='copName']").val("请输入公司名称")
							$("input[name='copName']").css({
								"border" : "1px solid #f00"
							});
							return false;
						} else {
							$("input[name='copName']").css({
								"border" : "1px solid #dedede"
							});
						}
					})
$("input[name='linkman']").focus(function() {
				if ($("input[name='linkman']").val() == "填写申请人的真实姓名") {
					$(this).val("")
				}
			})
			$("input[name='linkman']").blur(
					function() {
						var str = $("input[name='linkman']").val();
						
						if ($("#linkman").val()=="") { 
							$("input[name='linkman']").val("填写申请人的真实姓名")
							$("input[name='linkman']").css({
								"border" : "1px solid #f00"
							});
							return false;
						} else {
							$("input[name='linkman']").css({
								"border" : "1px solid #dedede"
							});
						}
					})	
					
					
	function addsave(casRemoteLoginUrl){
		  if($("#copName").val()=="请输入公司名称"||$("#copName").val()==""||$("#mobile").val()=="手机必填"|| $("#linkman").val()=="填写申请人的真实姓名"){//
				alert("信息填写有误！请正确填写信息！");  
		  }else{
			$("#liuyanadd").attr("action",casRemoteLoginUrl);
		  }
		}
