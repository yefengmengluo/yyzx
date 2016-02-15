<%@ page pageEncoding="UTF-8" contentType="text/html"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑企业信息</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>


	<div class="t1000-votB-R-in">
        <form id="modify_form" action="" method="post" enctype="multipart/form-data" >
        <table class="t1000-editTab" cellpadding="0" cellspacing="0">
            	<tr>
                	<th colspan="2">基本信息
                	<input name="copId" type="hidden" value="${company.copId}"/>
                	<input name="voteId" type="hidden" value="${company.voteId}"/>
                	</th>
                </tr>
                <tr>
                	<td class="w15">公司名称</td>
                    <td width="*"><span><input id="copName" class="t1000-company-text" name="copName" type="text" value="${company.copName}"/></span><label class="t1000-success" id="copName_success" style="display:none">输入正确</label><label class="t1000-error" id="copName_error" style="display:none">必填项，请输入</label></td>
                </tr>
                <tr>
                	<td class="w15">品牌名称</td>
                    <td width="*"><span><input id="copBrand" class="t1000-company-text" name="copBrand" type="text" value="${company.copBrand}"/></span><label class="t1000-success" id="copBrand_success" style="display:none">输入正确</label><label class="t1000-error" id="copBrand_error" style="display:none">必填项，请输入</label></td>
                </tr>
                <tr>
                	<td class="w15">品牌logo</td>
                    <td width="*">
                    	<input id="logo_file" type="file" accept="image/*" onchange="getVal(this.value,'logo_fileName')" name="_logo" class="t1000-logo-upload" accept="image/*" style="display:none"/>
                    	
                    	<input id="logo_btn" type="button" class="t1000-logo-upload" value="浏览..." style="margin-left:20px;width:5.5%; height:31px; line-height:25px;"/>
					<c:choose>
						<c:when test="${empty company.logo}">
							<span id="logo_fileName" style="font-size:10pt;width:30%">未选择文件</span>
	                    </c:when>
	                    <c:otherwise>
	                    	<span id="logo_fileName" style="font-size:10pt;width:30%" >${fn:substring(company.logo,fn:indexOf(company.logo, 'company')+8,fn:length(company.logo))}</span>
	                    </c:otherwise>
                    </c:choose>
                    <label class="t1000-success" id="logo_success" style="display:none">图片已上传</label><label class="t1000-error" id="logo_error" style="display:none">请上传图片</label>
                    </td>
                </tr>
                <tr>
                	<!-- <td class="w15">所属行业</td>
                    <td width="*"><span><input class="t1000-company-text" name="copName" type="text" value=""/></span></td> -->
                    <td class="w15">所属行业</td>
                    <td width="*"><span id="industry_radio">
						<input class="t1000-vote-radio" name="industry" type="radio" value="1"/>食品饮料
						<input class="t1000-vote-radio" name="industry" type="radio" value="2"/>服装饰品
						<input class="t1000-vote-radio" name="industry" type="radio" value="3"/>家居用品
						<input class="t1000-vote-radio" name="industry" type="radio" value="4"/>照明安防
						<input class="t1000-vote-radio" name="industry" type="radio" value="5"/>数码礼品
						<input class="t1000-vote-radio" name="industry" type="radio" value="6"/>农副产品
						<input class="t1000-vote-radio" name="industry" type="radio" value="7"/>建筑装饰
						<input class="t1000-vote-radio" name="industry" type="radio" value="8"/>汽摩五金
						<input class="t1000-vote-radio" name="industry" type="radio" value="9"/>金属矿产
						<input class="t1000-vote-radio" name="industry" type="radio" value="10"/>机械设备
						</span>
					</td>
                </tr>
                <tr>
                	<td class="w15">企业网站</td>
                    <td width="*"><span><input id="copUrl" placeholder="格式如：http://www.baidu.com" class="t1000-company-text" name="copUrl" type="text" value="${company.copUrl}"/><label class="t1000-success" id="copUrl_success" style="display:none">输入正确</label><label class="t1000-error" id="copUrl_error" style="display:none">格式输入错误，请重新输入</label><!-- &nbsp;&nbsp;<label>格式如：http://www.baidu.com</label> --></span></td>
                </tr>
                <tr>
                	<td class="w15">企业地址</td>
                    <td width="*"><span><input id="copAddress" class="t1000-company-text" name="copAddress" type="text" value="${company.copAddress}"/><label class="t1000-success" id="copAddress_success" style="display:none">输入正确</label><label class="t1000-error" id="copAddress_error" style="display:none">必填项，请输入</label></span></td>
                </tr>
                <tr>
                	<td class="w15">品牌行业</td>
                    <td width="*"><span><input class="t1000-company-text" name="brandIndustry" type="text" value="${company.brandIndustry}"/></span></td>
                </tr>
                <tr>
                	<td class="w15">官方微信</td>
                    <td width="*"><!-- <input type="file" onchange="" class="t1000-logo-upload" /> -->
                    <input id="weixinPic_file" type="file" accept="image/*" onchange="getVal(this.value,'weixinPic_fileName')" name="_weixinPic" class="t1000-logo-upload" style="display:none"/>
                    <input id="weixinPic_btn" type="button" class="t1000-logo-upload" value="浏览..." style="margin-left:20px;width:5.5%; height:31px; line-height:25px;"/>
					<c:choose>
						<c:when test="${empty company.weixinPic}">
							<span id="weixinPic_fileName" style="font-size:10pt">未选择文件</span>
	                    </c:when>
	                    <c:otherwise>
	                    	<span id="weixinPic_fileName" style="font-size:10pt">${fn:substring(company.weixinPic,fn:indexOf(company.weixinPic, 'company')+8,fn:length(company.weixinPic ))}</span>
	                    </c:otherwise>
                    </c:choose>
                    </td>
                </tr>
                <tr>
                	<td class="w15">官方微博</td>
                    <td width="*">
                    <!-- <input type="file" onchange="" class="t1000-logo-upload" /> -->
                    <input id="weiboPic_file" type="file" accept="image/*" onchange="getVal(this.value,'weiboPic_fileName')" name="_weiboPic" class="t1000-logo-upload" style="display:none"/>
                    <input id="weiboPic_btn" type="button" class="t1000-logo-upload" value="浏览..." style="margin-left:20px;width:5.5%; height:31px; line-height:25px;"/>
					<c:choose>
						<c:when test="${empty company.weiboPic}">
							<span id="weiboPic_fileName" style="font-size:10pt">未选择文件</span>
	                    </c:when>
	                    <c:otherwise>
	                    	<span id="weiboPic_fileName" style="font-size:10pt">${fn:substring(company.weiboPic,fn:indexOf(company.weiboPic, 'company')+8,fn:length(company.weiboPic))}</span>
	                    </c:otherwise>
                    </c:choose>
                    </td>
                </tr>
                <tr>
                	<td class="w15">手机投票二维码</td>
                    <td width="*"><!-- <input type="file" onchange="" class="t1000-logo-upload" /> -->
                     <input id="erweimaPic_file" type="file" accept="image/*" onchange="getVal(this.value,'erweimaPic_fileName')" name="_erweimaPic" class="t1000-logo-upload" style="display:none"/>
                    <input id="erweimaPic_btn" type="button" class="t1000-logo-upload" value="浏览..." style="margin-left:20px;width:5.5%; height:31px; line-height:25px;"/>
					<c:choose>
						<c:when test="${empty company.erweimaPic}">
							<span id="erweimaPic_fileName" style="font-size:10pt">未选择文件</span>
	                    </c:when>
	                    <c:otherwise>
	                    	<span id="erweimaPic_fileName" style="font-size:10pt">${fn:substring(company.erweimaPic,fn:indexOf(company.erweimaPic, 'company')+8,fn:length(company.erweimaPic))}</span>
	                    </c:otherwise>
                    </c:choose>
                    <label class="t1000-success" id="erweimaPic_success" style="display:none">图片已上传</label><label class="t1000-error" id="erweimaPic_error" style="display:none">请上传图片</label>
                    </td>
                </tr>
                <tr>
                	<th colspan="2">公司简介</th>
                </tr>
                <tr>
                	<td class="w15">公司简介</td>
                    <td width="*"><textarea name="copSummary" class="t1000-company-info">${company.copSummary}</textarea></td>
                </tr>
                <tr>
                	<td class="w15">企业大事记</td>
                    <td width="*"><textarea name="copEvents" class="t1000-company-info">${company.copEvents}</textarea></td>
                </tr>
                
                <tr>
                	<td class="t1000-company-btn" colspan="2">
                        <span>
                            <input id="edit_btn" type="button" class="t1000-batch-btn1" value="保存"/>
                            <input type="button" class="t1000-batch-btn2" value="关闭并返回" onclick="window.history.go(-1)"/>
                        </span>
                    </td>
                </tr>
        </table>  
        </form>	
    </div>


<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/right.js"></script>
<script type="text/javascript">
$(function(){
	var $cks = $("input[name='industry']");
	$cks.each(function() {
		if($(this).val()=='${company.industry}'){
			$(this).attr("checked","checked");
		}
	});
	
	$("#logo_btn").click(function(){
		$("#logo_file").click();
	})
	
	$("#weixinPic_btn").click(function(){
		$("#weixinPic_file").click();
	})
	
	$("#weiboPic_btn").click(function(){
		$("#weiboPic_file").click();
	})
	
	$("#erweimaPic_btn").click(function(){
		$("#erweimaPic_file").click();
	})
	
	
	
	$("#logo_file").change(function(){
		$("#logo_error").hide();
		$("#logo_success").show();
	});
	
	
	$("#erweimaPic_file").change(function(){
		$("#erweimaPic_error").hide();
		$("#erweimaPic_success").show();
	});
	
});

function getVal(val,id){
	document.getElementById(id).innerHTML = val;
}

$(function(){
	/*修改企业*/
	$("#edit_btn").click(function(){
		var edit_url="${pageContext.request.contextPath }/VoteCompany/v1/modifyCompany";
		editCompany(edit_url);
	} );
});

/* 修改企业 */
function editCompany(edit_url) {
	var copUrl = $("#copUrl").val();
	var Expression = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
	var copName = $("#copName").val();
	var copBrand = $("#copBrand").val();
	var logo_fileName = $("#logo_fileName").text();
	var erweimaPic_fileName = $("#erweimaPic_fileName").text();
	var copAddress = $("#copAddress").val();	
	
	if (copName == "" || copBrand == "" || copUrl == ""||(logo_fileName=="未选择文件")||(erweimaPic_fileName=="未选择文件")) {
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
		if(logo_fileName=="未选择文件"){
			$("#logo_error").html("请上传图片");
			$("#logo_error").show();
			$("#logo_success").hide();
		}
		if(erweimaPic_fileName=="未选择文件"){
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
		$("#modify_form").attr("action", edit_url);
		$("#modify_form").submit();
	}
	
}
</script>
</body>
</html>
