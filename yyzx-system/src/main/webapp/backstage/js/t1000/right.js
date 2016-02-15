/*// JavaScript Document
弹出框
var eleWidth, eleHeight,winHeight,btn_index, boxWW,boxHH,boxLL,boxTT;
function Boxpos(){
	 eleWidth=$(document).width();
	 eleHeight=$(document).height();
	 winHeight=$(window).height();
	 btn_index=0;
	 boxWW=$(".bookingBox").width();
	 boxHH=$(".bookingBox").height();
	 boxLL=(eleWidth-boxWW)/2;
	 boxTT=(winHeight-boxHH)/2;
	$(".bookingBlackBg").css("height",eleHeight);
	$(".bookingBox").css("left",parseInt(boxLL));
}
$(function(){
	全选
	$("#checkedAll").click(function() {
		$("input[name='companyList[]']").prop("checked", this.checked);
	});
	
	$("input[name='companyList[]']").click(function() {
		var $companyList = $("input[name='companyList[]']");
		$("#checkedAll").prop("checked" , $companyList.length == $companyList.filter(":checked").length ? true :false);
	});

})*/

// JavaScript Document
/*弹出框*/
var eleWidth, eleHeight, winHeight, btn_index, boxWW, boxHH, boxLL, boxTT;
function Boxpos() {
	eleWidth = $(document).width();
	eleHeight = $(document).height();
	winHeight = $(window).height();
	btn_index = 0;
	boxWW = $(".bookingBox").width();
	boxHH = $(".bookingBox").height();
	boxLL = (eleWidth - boxWW) / 2;
	boxTT = (winHeight - boxHH) / 2;
	$(".bookingBlackBg").css("height", eleHeight);
	$(".bookingBox").css("left", parseInt(boxLL));
}

function inputTipText() {
	$("[class*=grayTips]") // 所有样式名中含有grayTips的input
	.each(
			function() {
				var _this = $(this);
				if ($.trim(_this.val()) == ''
						|| $.trim(_this.val()) == '请输入关键字') {
					_this.css('color', '#999');
				} else {
					_this.css('color', '#333');
				}
				_this.focus(function() {
					if (_this.val() == '请输入关键字') {
						_this.val('').css("color", "#333");
					}
				}).blur(
						function() {
							if (!_this.val() || $.trim(_this.val()) == ""
									|| $.trim(_this.val()) == '请输入关键字') {
								_this.val("请输入关键字").css("color", "#999");
							}
						}).keydown(function() {
					_this.css({
						"color" : "#333"
					})
				})
			})
}

$(function() {
	/* 全选 */
	$("#checkedAll").click(function() {
		$("input[name='companyList[]']").prop("checked", this.checked);
	});

	$("input[name='companyList[]']").click(
			function() {
				var $companyList = $("input[name='companyList[]']");
				$("#checkedAll")
						.prop(
								"checked",
								$companyList.length == $companyList
										.filter(":checked").length ? true
										: false);
			});

	$(function() {
		inputTipText(); // 直接调用就OK了
		return false;
	})

	/* 修改密码 */
	$(".noRead").focus(function() {
		$(this).css("background-color", "#fff");
	}).blur(function() {
		if (!$(this).val() || $.trim($(this).val()) == "") {
			$(this).css("background-color", "#f8f8f8");
		}
	}).keydown(function() {
		$(this).css("background-color", "#fff")
	})

	/* 判断企业网址格式 */
	$("#copUrl").blur(function() {
		var homepage = $("#copUrl").val();
		var Expression = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
		if ($("#copUrl").val() == "") {
			$("#copUrl_error").html("必填项,请输入");
			$("#copUrl_error").show();
			$("#copUrl_success").hide();

		} else if (!Expression.test(homepage)) {
			$("#copUrl_error").html("格式不正确，请重新输入");
			$("#copUrl_error").show();
			$("#copUrl_success").hide();
		} else {
			$("#copUrl_success").show();
			$("#copUrl_error").hide();

		}
	});
	/* 企业名不为空 */
	$("#copName").blur(function() {
		if ($("#copName").val() == "") {
			$("#copName_error").show();
			$("#copName_success").hide();
			$("#copName").html("必填项,请输入");
		} else {
			$("#copName_success").show();
			$("#copName_error").hide();
		}
	});
	/* 品牌不为空 */
	$("#copBrand").blur(function() {
		if ($("#copBrand").val() == "") {
			$("#copBrand_error").show();
			$("#copBrand_success").hide();
			$("#copBrand").html("必填项,请输入");
		} else {
			$("#copBrand_success").show();
			$("#copBrand_error").hide();
		}
	});
	/* 企业地址不为空 */
	$("#copAddress").blur(function() {
		if ($("#copAddress").val() == "") {
			$("#copAddress_error").show();
			$("#copAddress_success").hide();
			$("#copAddress").html("必填项,请输入");
		} else {
			$("#copAddress_success").show();
			$("#copAddress_error").hide();
		}
	});
	
})
/* 添加企业 */
function saveCompany(save_url) {
	var copUrl = $("#copUrl").val();
	var Expression = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
	var copName = $("#copName").val();
	var copBrand = $("#copBrand").val();
    var logo = $("#id_logo").val();
    var erweimaPic = $("#id_erweimaPic").val();
	var copAddress = $("#copAddress").val();	
	


	if (copName == "" || copBrand == "" || copUrl == ""||logo==""||copAddress==""||erweimaPic == "") {
		if(copName == ""){
			$("#copName_error").html("必填项,请输入");
			$("#copName_error").show();
			$("#copName_success").hide();
		}
		if(copBrand == ""){
			$("#copBrand_error").html("必填项,请输入");
			$("#copBrand_error").show();
			$("#copBrand_success").hide();
		}
		if(copUrl == ""){
			$("#copUrl_error").html("必填项,请输入");
			$("#copUrl_error").show();
			$("#copUrl_success").hide();
		}
		if(logo == ""){
			$("#logo_error").html("请上传图片");
			$("#logo_error").show();
			$("#logo_success").hide();
		}
		if(erweimaPic == ""){
			$("#erweimaPic_error").html("请上传图片");
			$("#erweimaPic_error").show();
			$("#erweimaPic_success").hide();
		}
		if(copAddress == ""){
			$("#copAddress_error").html("必填项,请输入");
			$("#copAddress_error").show();
			$("#copAddress_success").hide();
		}
		alert("请先完善信息！");
	} else if (!Expression.test(copUrl)) {
		alert("网址格式不正确！请重新填写！如：http://xxx");
		$("#copUrl_error").html("格式不正确，请重新输入");
		$("#copUrl_error").show();
		$("#copUrl_success").hide();
		$("#copUrl").focus();
	} else {
		$("#add_form").attr("action", save_url);
		$("#add_form").submit();
	}
	
}
