<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>广告添加/修改</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>


	<div class="t1000-votB-R-in">
    	<div class="t1000-com-tips-con clearfix">
            <span>&nbsp;</span>
            <div class="t1000-tips_r">
            	<h3>操作小贴士</h3>
                <p>1、广告添加/修改</p>
            </div>
        </div>
        <form action="<c:url value='/vote/advertisingAdd'/>" method="post" enctype="multipart/form-data">
        <table class="t1000-editTab addAdvtab" cellpadding="0" cellspacing="0">
                <tr>
                	<td class="w15">投票主题
                		<input type="hidden" name="vId" value="${voteTable.id}"/>
                	</td>
                    <td width="*">
                    	<p>${voteTable.vSubject}</p>
                    </td>
                </tr>
               
                <tr>
                	<td class="w15">频道名称
                	</td>
                    <td width="*">
                    	<span>
		                	<c:if test="${channelName == 0}">
	                    		<select class="t1000-company-sel" name="channelName">
	                                <option value="0" selected="selected">投票详情</option>
	                                <option value="1">投票列表</option>
	                    		 </select>
		                	</c:if>
		                	<c:if test="${channelName == 1}">
	                    		<select class="t1000-company-sel" name="channelName">
	                                <option value="0" >投票详情</option>
	                                <option value="1" selected="selected">投票列表</option>
	                    		 </select>
		                	</c:if>
                        </span>
                    </td>
                </tr>
                <tr>
                	<td class="w15">标识名称</td>
                    <td width="*">
	                    <p>填写格式例如：投票通栏100*90</p>
	                    <span>
	                    	<input id="positionName-input" class="t1000-company-text" type="text" name="positionName" value=""/>
	                    	<font color="red">( * 必填项 )</font>
	                    </span>
                    </td>
                </tr>
                <tr>
                	<td class="w15">广告客户显示名称</td>
                    <td width="*">
	                    <p>填写格式例如：北京***科技有限公司</p>
	                    <span>
	                    	<input id="title-input" class="t1000-company-text" type="text" name="picture.title" value=""/>
	                    	<font color="red">( * 必填项 )</font>
	                    </span>
                    </td>
                </tr>
				 <tr>
                	<td class="w15">广告类型</td>
                    <td width="*">
	                    <span>
	                    	<select class="t1000-company-sel" id="t1000-ad-type" name="advType">
	                        	<option value="0">图片广告</option>
	                            <option value="1">文字广告</option>
	                           <!--  <option value="2">焦点图,</option> -->
	                    	</select>
	                        
							&nbsp;&nbsp;&nbsp;&nbsp;
							<span style="" id="dataNum">显示广告数量 
							<input id="dataNum-input" type="text" style="width:45px" name="advNum" value="" class="t1000-company-text"/></span>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<span style="" id="tlength">广告字数 
								<input id="tlength-input" type="text" name="tlength" value="" class="t1000-company-text" style="width:45px"/>
							</span>
							<font id="numTips" color="gray">（请输入数字,该项为必填项）</font>
						</span>
					</td>
                </tr>
                <tr id="t1000-ad-text" style="display:none">
                	<td class="w15">
                	广告文字<span style="" id="addNum"> <input type="button"  value="+添加文字广告" /></span></td>
                    <td width="*" id="addTd">
                    <span id="addAd1">
	                    <label>广告1：</label>
	                    <input class="t1000-company-text" type="text" name="pictures[0].text" value=""/>&nbsp;&nbsp;&nbsp;&nbsp;
	            		目标地址:<input class="t1000-company-text" type="text" name="pictures[0].targetUrl" value="http://" style="width:300px"/>
            			<font color="red">( * 必填项 )</font>
            		</span>
					</td>
                </tr>
                <tr id="picUrl">
                	<td class="w15">图片路径</td>
                    <td width="*">
	                    <span>
	                    	<input type="file" onchange="" id="upload" name="picUrl" class="t1000-logo-upload" />
	                    </span>
                    </td>
                </tr>

                <tr id="targetUrl">
                	<td class="w15">图片URL地址</td>
                    <td width="*">
	                    <span>
	                    	<input id="imgUrl" class="t1000-company-text" type="text" name="picture.targetUrl" value="http://"/>
	                    	<font color="red">( * 必填项 )</font>
	                    </span>
                    </td>
                </tr>
                <tr>
                	<td class="t1000-company-btn" colspan="2">
                        <span>
                            <input id="commit-form" type="submit" class="t1000-batch-btn1" value="添加"/>
                            <input type="button" class="t1000-batch-btn2" value="返回" onclick="javascript:history.go(-1)"/>
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
	var checkSubmitFlg = false;//防止表单二次提交
	//表单提交验证
	$("#commit-form").click(function(){
		var positionName = $("#positionName-input").val().trim();
		var title = $("#title-input").val().trim();
		var imgUrl = $("#imgUrl").val().trim();
		var tlength = $("#tlength-input").val().trim();//广告字数
		var dataNum = $("#dataNum-input").val().trim();//广告数量
		
		if (!checkSubmitFlg){
			if(positionName == ''){
			alert("请输入标识名称");
			return false;
			}
			if(title == ''){
				alert("请输入广告客户显示名称");
				return false;
			}
			if(!$("#targetUrl").is(":hidden")){
				var str = imgUrl.match(/http:\/\/.+/); 
				if (str == null){
					alert('你输入的URL无效'); 
					return false;
				}
			}
			
			if(!$("#tlength").is(":hidden")){
				var reg = new RegExp("^[0-9]*$");
				//验证广告数量
				if(dataNum == ""){
					alert("请输入广告数量");
					return false;
				}else if(!reg.test(dataNum)){
					alert("请输入正确的广告数量");
					return false;
				}
				//验证广告字数
				if(tlength == ""){
					alert("请输入广告字数");
					return false;
				}else if(!reg.test(tlength)){
					alert("请输入正确的广告字数");
					return false;
				}
				//验证文字广告的标题文字
				var wordText = true;
				var $wordText = $("input[name$='text']");
				$wordText.each(function(){
					if ($(this).val().trim() == ''){
						wordText = false;
					}
				});
				if(!wordText){
					return confirm("文字广告内容未填写，本条广告数据不会被保存，是否继续?");
				}
				//验证文字广告的url
				var wordB = true;
				var $wordAdv = $("input[name$='targetUrl'][id!='imgUrl']");
				$wordAdv.each(function(){
					var str = $(this).val().trim().match(/http:\/\/.+/); 
					if(str == null){
						wordB = false;
					}
				});
				if(!wordB){
					alert('你输入的URL无效');
					return wordB;
				}
			}
			//第一次提交
            checkSubmitFlg = true;
            return true;
         }else{
             //重复提交
             alert("数据正在传送中，请勿重复提交！");
             return false;
         }
	});
	
});

$(function(){
	function ad_text_change(selId,adText,textId){
		var ad_type=$("#"+selId+" option:selected").text();
		if(ad_type == adText){
			$("#"+textId).show();
			$("#tlength").show();
			$("#dataNum").show();
			$("#numTips").show();
			$("#picUrl").hide();
			$("#targetUrl").hide();
		}else{
			$("#"+textId).hide();
			$("#tlength").hide();
			$("#dataNum").hide();
			$("#numTips").hide();
			$("#picUrl").show();
			$("#targetUrl").show();
		}
	}
	
	ad_text_change("t1000-ad-type","文字广告","t1000-ad-text");
	
	$("#t1000-ad-type").change(function(){
		ad_text_change("t1000-ad-type","文字广告","t1000-ad-text");
	})
	//添加文字广告
		var num=1;
		$("#addNum").click(function(){
			
			var tdhtml = "<span ><label>广告"+(num+1)+"：</label><input class='t1000-company-text' type='text' name='pictures["+num+"].text' value=''/>&nbsp&nbsp&nbsp&nbsp目标地址:<input class='t1000-company-text' type='text' name='pictures["+ num +"].targetUrl' value='http://' style='width:300px'/><font color='red'>( * 必填项 )</font></span>"
			num++;
			$("#addTd span:last").after(tdhtml);
		})
});
</script>
</body>
</html>
