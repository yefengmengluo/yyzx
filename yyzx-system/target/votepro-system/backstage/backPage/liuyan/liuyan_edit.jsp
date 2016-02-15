<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑站点</title>
<link href="${pageContext.request.contextPath }/backstage/css/t1000/default/main/votBack_main.css" type="text/css" rel="stylesheet"/>
</head>

<body>



	<div class="t1000-votB-R-in">
       <form action="javascript:void(0)" method="post" id="liuyanup" accept-charset="utf-8">
        <table class="t1000-editTab" cellpadding="0" cellspacing="0">
            	<tr>
                	<th colspan="2">基本信息</th>
                </tr>
                <tr>
                	<td class="w15">专题ID</td>
                    <td width="*"><span><input class="t1000-company-text" type="text" id="specId" name="specId" value="${specialliuyan. specId}"/></span >
                    <label class="t1000-success" id="specId1" style="display:none">输入正确</label><label class="t1000-error" id="specId2" style="display:none">格式不正确，请输入</label></td>
                </tr>
               
                <tr>
                	<td class="w15">公司名称</td>
                    <td width="*"><span><input class="t1000-company-text" type="text" id="copName" name="copName" value="${specialliuyan. copName}"/></span>
                    <label class="t1000-success" id="copName1" style="display:none">输入正确</label><label class="t1000-error" id="copName2" style="display:none">输入错误，请重新输入</label></td>
                </tr>
                <tr>
                	<td class="w15">联系人</td>
                    <td width="*"><span><input class="t1000-company-text" type="text" id="linkman" name="linkman"  value="${specialliuyan. linkman}"/></span>
                    <label class="t1000-success" id="linkman1" style="display:none">输入正确</label><label class="t1000-error" id="linkman2" style="display:none">真实姓名不能为空</label></td>
                </tr>
                <tr>
                	<td class="w15">电话</td>
                    <td width="*"><span><input class="t1000-company-text" type="text" id="mobile"  name="mobile" value="${specialliuyan. mobile}"/></span>
                    <label class="t1000-success" id="mobile1" style="display:none">输入正确</label><label class="t1000-error" id="mobile2" style="display:none">输入错误，请重新输入</label></td>
                </tr>
				 <tr>
                	<td class="w15">备注</td>
                    <td width="*"><span><input class="t1000-company-text" type="text" id="comment"  name="comment" value="${specialliuyan. comment}"/></span>
                    <label class="t1000-success" id="comment1" style="display:none">输入正确</label><label class="t1000-error" id="comment2" style="display:none">输入错误，请重新输入</label></td>
                </tr>
                 <tr>
                	<td class="w15">添加时间</td>
                    <td width="*"><span>&nbsp;&nbsp;&nbsp;
                     <fmt:formatDate value="${specialliuyan. creatTime}" type="both" /> </span>
                     
                    <label class="t1000-success" id="creatTime1" style="display:none">输入正确</label><label class="t1000-error" id="creatTime2" style="display:none">输入错误，请重新输入</label></td>
                </tr>
                
                <tr>
				 <c:if test="${specialliuyan. status==1}">
                	<td class="w15">状态</td>
                    <td width="*"><span class="t1000-vote-radio-con">
                    <input class="t1000-vote-radio" id="status"  name="status" type="radio" value="1" checked />已审核
                    <input class="t1000-vote-radio" type="radio" name="status" value="0"/>未审核</span>
                     <input class="t1000-vote-radio" type="radio" name="status" value="2"/>禁用</span>
                    </td>
                 </c:if>
				 <c:if test="${specialliuyan. status==0}">
                	<td class="w15">状态</td>
                    <td width="*"><span class="t1000-vote-radio-con">
                    <input class="t1000-vote-radio" id="status"  name="status" type="radio" value="1"  />已审核
                    <input class="t1000-vote-radio" type="radio" name="status" value="0" checked/>未审核
                    <input class="t1000-vote-radio" type="radio" name="status" value="2"/>禁用</span>
                    </td>
                 </c:if>
                 <c:if test="${specialliuyan. status==2}">
                	<td class="w15">状态</td>
                    <td width="*"><span class="t1000-vote-radio-con">
                    <input class="t1000-vote-radio" id="status"  name="status" type="radio" value="1"  />已审核
                    <input class="t1000-vote-radio" type="radio" name="status" value="0" />未审核
                    <input class="t1000-vote-radio" type="radio" name="status" value="2" checked/>禁用</span>
                   </td>
                 </c:if>
                </tr>
                 <tr>
                	<td class="w15">标签</td>
                    <td width="*">
                     <textarea name="tag" cols="100" rows="5"> ${specialliuyan. tag} </textarea>
                     </td>
                 	</tr>
                
              
                <tr>
                	<td class="t1000-company-btn" colspan="2">
                	<input type="hidden" name="lyId" value="${specialliuyan.lyId}"/>
                	
                	<input type="hidden" id="currentNum"name="currentNum" value="${page.currentNum }"/>
                	<input type="hidden" id="status1"name="status1" value="${status1}"/>
                        <span>
                            <input type="submit" class="t1000-batch-btn1" id="liuyanupdate" value="更新"/>
                            <input type="button" class="t1000-batch-btn2" value="返回" onclick="location.href='javascript:history.go(-1);'"/>
                        </span>
                    </td>
                </tr>
        </table>  

        </form>
        	
    </div>



<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/right.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/t1000/lyedit.js"></script>
<script type="text/javascript">
	$(function(){
		
		 $("#liuyanupdate").click(function(){
			var currentNum=$("#currentNum").val();
			/* if($("#passwordedit").val()==""){
				var p=$("#password0").val();
				$("#passwordedit").val(p);
			} */
			var status1=$("#status1").val();
			var casRemoteLoginUrl="${pageContext.request.contextPath }/liuYanController/modifyLiuYan?currentNum="+currentNum+"&status1="+status1;
		 	liuyanupdate(casRemoteLoginUrl);
		 })
	   
	})
	</script> 
</body>
</html>
