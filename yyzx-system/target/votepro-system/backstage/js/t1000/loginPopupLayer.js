/**
 * 创建登录弹出框html
 * 
 * @param siteId
 * @return 登录弹窗层的html
 */
function createLoginHtml(siteId) {
	siteId = siteId == null || siteId == "" ? 1 : siteId;
	var strHtml = '<div class="pop" id="login_pop">'
			+ '密码错误密码错误密码错误><img id="login_close" src="http://wk-static.99114.cn/static/login/images/error.gif">用户登录</h4>'
			+ '<div class="warn warn01" id="login_error" style="display:none;"></div>'
			+ '<input type="hidden" name="login_service" id="login_service"/>'
			+ '<dl><dt>账   户：  </dt><dd><input id="login_username" name="userName" type="text"  class="input" style="color: rgb(153, 153, 153);"></dd></dl>'
			+ '<dl><dt>密   码：  </dt><dd><input id="login_password" name="password" type="password"  class="input" style="color: rgb(153, 153, 153);"></dd></dl>'
			+ '<p><input type="checkbox" id="login_remmberMe" value="1">记住我的登录状态<a href="http://member.99114.com/login/gotoRegister?backUrl=http://member.99114.com/member/toMemberType&siteId='
			+ siteId
			+ '" class="register">免费注册</a></p>'
			+ '<p><input type="button" id="login_button" value="登录" class="btn01"><a href="http://member.99114.com/view/findpassword/passwordForm.jsp?siteId='
			+ siteId + '">忘记密码了？</a></p>' + '<div class="qq_nonbg pngimg">'
			+ ' </div>' + ' </div>';
	return strHtml;
}

/**
 * 绑定弹出层的时间 ，关闭事件 ，登录的点击事件
 * 
 * @param casRemoteLoginUrl
 *            远程登录的地址
 * @parame limitUrl 本系统的受限地址（受限地址主要做转发之用）
 * @param siteId
 *            站点id
 * @param showId
 *            弹出层所在的位置的id
 */
function initLoginDiv(casRemoteLoginUrl, limitUrl, siteId, showId) {
	var html = createLoginHtml(siteId);
	// var olderHtml = $("#"+showId).html();
	$("#" + showId).html(html);
	// 绑定关闭事件
	$("#login_close").click(function() {
		loginClose();
	});
	$("#login_button").click(function() {
		validataLoginParam();
		loginSubmit(casRemoteLoginUrl, limitUrl);
	})
}

// 弹出层的关闭事件
function loginClose() {
	$("#login_pop").remove();
}
/**
 * 参数验证 ，验证用户名密码
 */
function validataLoginParam() {
	var userName = $("#login_username").val();
	var password = $("#login_password").val();
	var validateCode = $("#code").val();
	if (userName == "") {
		// $("#login_error").html("请输入账户名。").show();
		alert("请输入账户名！");
		return false;
	} else if (password == "") {
		// $("#login_error").html("请输入密码。").show();
		alert("请输入密码!")
		return false;
	} else if (validateCode == "") {
		// $("#login_error").html("请输入密码。").show();
		alert("请输入验证码!")
		return false;
	} else
		return true;
}

function loginSubmit(casRemoteLoginUrl, limitUrl,validateUrl) {
	var userName = $("#login_username").val();
	var password = $("#login_password").val();
	var validateCode = $("#code").val();
	var remmberMe = $("#login_remmberMe:checked").val() == 1 ? 1 : "";
	var source = 1;// 代表会员登录
	var service = window.location.href;// 获取当前的url地址
	
	saveUserInfo(userName,password,remmberMe);
	$.ajax({
		type : "post",
		url : casRemoteLoginUrl,
		data : {
			account : userName,
			password : password,
			code:validateCode,
			source : source,
			rememberMe : remmberMe
		},
		// dataType : "jsonp",

		// jsonp: "callbackparam",//服务端用于接收callback调用的function名的参数
		// jsonpCallback:"success_jsonpCallback",//callback的function名称
		success : function(code) {
			// var code = json.code;
			//alert(code)
			if (code != null) {
				if (code == "1") {
					// $("#login_error").hide();
					// loginClose();
					// location.href=limitUrl+"?service="+service;//登录成功回到原页面
					location.href = limitUrl;
					
				} else if (code == "0") {
					alert("您输入的账户名不存在！");
					$("#login_password").val("");
					$("#code").val("");
					$("#login_username").focus();
					$("#captchaImage").attr("src",validateUrl);
				} else if (code == "2") {
					alert("密码错误，请重新输入！");
					$("#login_password").val("");
					$("#code").val("");
					$("#login_password").focus();
					$("#captchaImage").attr("src",validateUrl);
				} else if (code == "3") {
					alert("验证码错误！请重新输入！");
					$("#captchaImage").attr("src",validateUrl);
					$("#code").val("");
					$("#code").focus();
					
				} else if (code == "5") {
					alert("用户已删除！");
					// $("#login_error").html("用户已删除。").show();
				} else if (code == "6") {
					alert("用户已禁用！");
					// $("#login_error").html("用户已禁用。").show();
				} else {
					alert("系统维护中，请稍后再试！");
					$("#login_password").val("");
					$("#code").val("");
					$("#captchaImage").attr("src",validateUrl);
					// $("#login_error").hmtl("系统错误。").show();
				}
			}
		},
		error : function() {
			// alert('登录失败');
		}
	});
}
function findPassword(casRemoteLoginUrl, limitUrl) {
	var email = $("#email").val();
	if (email == "") {
		alert("请输入邮箱/手机号！");
	} else {
		$.post(casRemoteLoginUrl, {
			"email" : email
		}, function(code) {
			if (code == "ok") {
				alert("短信已发送！返回登陆界面，请重新登录！");
				//$("#forgotform").attr("action", limitUrl);
				location.href = limitUrl;
			} else if (code == "error") {
				alert("系统繁忙，请稍后再试！");
			} else {
				alert("系统繁忙，请稍后再试2！");
			}

		}

		);
	}
}


//保存用户名密码
function saveUserInfo(userName,password,remmberMe) {
	if (remmberMe == 1) {
	$.cookie("rmbUser", "true", { expires: 7 }); // 存储一个带7天期限的 cookie
	$.cookie("userName", userName, { expires: 7 }); // 存储一个带7天期限的 cookie
	$.cookie("passWord", password, { expires: 7 }); // 存储一个带7天期限的 cookie
	}
	else {
	$.cookie("rmbUser", "false", { expires: -1 });
	$.cookie("userName", '', { expires: -1 });
	$.cookie("passWord", '', { expires: -1 });
	}
	} 