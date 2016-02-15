<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加企业详细信息</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>


	<div class="t1000-votB-R-in clearfix">
        <form id="add_form" action="" method="post" enctype="multipart/form-data" >
        <table class="t1000-editTab" cellpadding="0" cellspacing="0">
            	<tr>
                	<th colspan="2">基本信息
                		<input name="voteId" type="hidden" value="${voteId}"/>
                		<input name="source" type="hidden" value="${source}"/>
                	</th>
                </tr>
                <tr>
                	<td class="w15">公司名称</td>
                    <td width="*"><span><input id="copName" class="t1000-company-text" name="copName" type="text" value=""/><font color="red">   (  *  必填)</font>
                    </span><label class="t1000-success" id="copName_success" style="display:none">输入正确</label><label class="t1000-error" id="copName_error" style="display:none">必填项，请输入</label></td>
                </tr>
                <tr>
                	<td class="w15">品牌名称</td>
                    <td width="*"><span><input id="copBrand" class="t1000-company-text" name="copBrand" type="text" value=""/><font color="red">   (  *  必填)</font>
                    </span><label class="t1000-success" id="copBrand_success" style="display:none">输入正确</label><label class="t1000-error" id="copBrand_error" style="display:none">必填项，请输入</label></td>
                </tr>
                <tr>
                	<td class="w15">品牌logo</td>
                    <td width="*"><input id="id_logo" type="file" name="_logo" accept="image/*" value="" class="t1000-logo-upload" style="width:36%"/><font color="red">   (  *  必填)</font>
                    <label class="t1000-success" id="logo_success" style="display:none">图片已上传</label><label class="t1000-error" id="logo_error" style="display:none">请上传图片</label></td>
                </tr>
                <tr>
                	<td class="w15">所属行业</td>
                    <td width="*"><span>
						<input class="t1000-vote-radio" name="industry" type="radio" value="1" checked />食品饮料
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
                    <td width="*"><span><input id="copUrl" placeholder="格式如：http://www.baidu.com" class="t1000-company-text" name="copUrl" type="text" value=""/><font color="red">   (  *  必填)</font>
                    <label class="t1000-success" id="copUrl_success" style="display:none">输入正确</label><label class="t1000-error" id="copUrl_error" style="display:none">格式输入错误，请重新输入</label><!-- &nbsp;&nbsp;<label>格式如：http://www.baidu.com</label> --></span></td>
                </tr>
                <tr>
                	<td class="w15">企业地址</td>
                    <td width="*"><span><input id="copAddress" class="t1000-company-text" name="copAddress" type="text" value=""/><font color="red">   (  *  必填)</font>
                    <label class="t1000-success" id="copAddress_success" style="display:none">输入正确</label><label class="t1000-error" id="copAddress_error" style="display:none">必填项，请输入</label></span></td>
                </tr>
                <tr>
                	<td class="w15">品牌行业</td>
                    <td width="*"><span><input class="t1000-company-text" name="brandIndustry" type="text" value=""/></span></td>
                </tr>
                <tr>
                	<td class="w15">官方微信</td>
                    <td width="*"><input type="file" name="_weixinPic" accept="image/*" value="" onchange="" class="t1000-logo-upload" /></td>
                </tr>
                <tr>
                	<td class="w15">官方微博</td>
                    <td width="*"><input type="file" name="_weiboPic" accept="image/*" value="" onchange="" class="t1000-logo-upload" /></td>
                </tr>
                <tr>
                	<td class="w15">手机投票二维码</td>
                    <td width="*"><input id="id_erweimaPic" type="file" name="_erweimaPic" accept="image/*" value="" class="t1000-logo-upload" style="width:36%"/><font color="red">   (  *  必填)</font>
                     <label class="t1000-success" id="erweimaPic_success" style="display:none">图片已上传</label><label class="t1000-error" id="erweimaPic_error" style="display:none">请上传图片</label></td>
                </tr>
                <tr>
                	<th colspan="2">公司简介</th>
                </tr>
                <tr>
                	<td class="w15">公司简介</td>
                    <td width="*"><textarea name="copSummary" class="t1000-company-info"></textarea></td>
                </tr>
                <tr>
                	<td class="w15">企业大事记</td>
                    <td width="*"><textarea name="copEvents" class="t1000-company-info"></textarea></td>
                </tr>
                
                <tr>
                	<td class="t1000-company-btn" colspan="2">
                        <span>
                            <input id="save_btn" type="button" class="t1000-batch-btn1" value="保存"/>
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
		/*添加企业*/
		$("#save_btn").click(function(){
			var save_url="${pageContext.request.contextPath }/VoteCompany/v1/saveCompany?source=${source}";
			 saveCompany(save_url);
		} );
		
		
		$("#id_logo").change(function(){
			$("#logo_error").hide();
			$("#logo_success").show();
		});
		
		
		$("#id_erweimaPic").change(function(){
			$("#erweimaPic_error").hide();
			$("#erweimaPic_success").show();
		});
	});
	
</script>
</body>
</html>
