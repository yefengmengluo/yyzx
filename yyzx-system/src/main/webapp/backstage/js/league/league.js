/*zsl   图片修改发布*/
function editAdvPic(obj,edit_url){
	var Expression = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
	var advName = $("input[name='advName']").val();
    var targetUrl = $("input[name='targetUrl']").val();
    var startTime = $("input[name='startTime']").val();
    var endTime = $("input[name='endTime']").val();
    if(advName==""||targetUrl=="" ||startTime=="" ||endTime==""){
    	if(advName == ""){
			$("#advName").css({"border":"1px solid red"});
		}
		if(targetUrl == ""){
			$("#targetUrl").css({"border":"1px solid red"});
		}
		if(startTime == ""){
			$("#d242").css({"border":"1px solid red"});
		}
		if(endTime == ""){
			$("#d241").css({"border":"1px solid red"});
		}
    	alert("请先完善信息");
    	$(obj).removeAttr("disabled");
    	$("#cancel_btn").removeAttr("disabled");
        $(obj).attr("value","发布");
    }else if (!Expression.test(targetUrl)) {
		alert("网址格式不正确！请重新填写！如：http://xxx");
		$("#advName").css({"border":"1px solid #dfdfdf"});
		$("#d242").css({"border":"1px solid #dfdfdf"});
		$("#d241").css({"border":"1px solid #dfdfdf"});
		$("#targetUrl").css({"border":"1px solid red"});
		$("#targetUrl").focus();
		$(obj).removeAttr("disabled");
		$("#cancel_btn").removeAttr("disabled");
        $(obj).attr("value","发布");
	} else {
		$("#modify_form").attr("action", edit_url);
		$("#modify_form").submit();
	}
}

$(function(){
	$("#advName").blur(function() {
		var advName = $("input[name='advName']").val();
		if (advName == "") {
			$("#advName_tishi").text("必填项,请输入").show();
		}else{
			$("#advName_tishi").text("").hide();		
		}
	});
	$("#targetUrl").blur(function() {
		var Expression = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
	    var targetUrl = $("input[name='targetUrl']").val();
		if (targetUrl == "") {
			$("#targetUrl_tishi").text("请输入：URL地址").show();
		} else if (!Expression.test(targetUrl)){
			$("#targetUrl_tishi").text("格式如：http://...").show();
			
		}else{
			$("#targetUrl_tishi").text("").hide();
		}
	});
	/*$("#d242").blur(function() {
	    var startTime = $("input[name='startTime']").val();
		if (startTime == "") {
			$("#startTime_tishi").html("必填项,请输入");
			$("#d242").css({"border":"1px solid red"});
		} else {
			$("#startTime_tishi").html("");
			$("#d242").css({"border":"1px solid #dfdfdf"});
		}
	});
	$("#d241").blur(function() {
	    var endTime = $("input[name='endTime']").val();
		if (endTime == "") {
			$("#endTime_tishi").html("必填项,请输入");
			$("#d241").css({"border":"1px solid red"});
		} else {
			$("#endTime_tishi").html("");
			$("#d241").css({"border":"1px solid #dfdfdf"});
		}
	});*/
});

/*图片广告删除*/
//删除一条图片广告数据
function delPicOne(id,onFlag){
	if(onFlag != 0){
		if (confirm("广告未过期,确定删除吗？")) {
			deleteAdvPic(id);
		}
	}else{
		if(confirm("确定删除吗？")){
			deleteAdvPic(id);
		}
	}
}

$("#batchDelete").click(
		function() {
			var $cks = $("input[name='companyList[]']:checked");

			if ($cks.length == 0) {
				alert("请至少选中一条数据删除...");
				return;
			}
			var idAll = new Array();//选中的全部数据id
			var flag = false;//判断有没有未过期的数据标识
			$cks.each(function() {
				var $tr = $(this).parent().parent();
				if ($.trim($tr.children(".lm_4").children().text())
						!=("过期")) {
					flag = true;
				}
				idAll.push($(this).val());
			});

			if (flag == true) {
				if (confirm("要删除的数据有未过期的数据，确定删除吗？")) {
					deleteAdvPic(idAll);
				}
			}else{
				if(confirm("确定删除吗？")){
					deleteAdvPic(idAll);
				}
			}
		});

//删除操作
function deleteAdvPic(idStr) {
	var currentNum = $("#currentNum").val();
	var removeUrl = $("#removeUrl").val();
//	alert(currentNum);
//	alert(removeUrl);
	location.href = removeUrl + "?idStr=" +idStr+"&currentNum=" +currentNum;

//	$
//			.ajax({
//				type : "post",
//				url : removeUrl,
//				data : {
//					idStr : idStr.toString()
//				},
//				success : function(data) {
//					if (data == "success") {
//						//alert("删除成功！");
//						//刷新当前页面
//						$("input[name='checkedAll']").prop("checked",false);
//						$("input[name='companyList[]']").prop("checked",false);
//						location.reload();
//					} else {
//						alert("删除失败");
//					}
//				},
//				error : function(){
//					alert("删除失败");
//				}
//			});

}











