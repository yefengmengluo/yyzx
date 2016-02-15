<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>足迹列表</title>
<link href="${pageContext.request.contextPath }/backstage/css/footprintscss/vbar.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
//添加足迹


function jumpDetail(memberId,supplyId,memberName){
	
	var siteId=$("#siteId").val();
	
	//var zujiDiv=$('#footprintCon', window.parent.document).parent().attr("class");
//alert(zujiDiv);
	 /* $(".menu-title").removeClass("selected");
	$(".vbarCon").hide(); */ 
	//alert("memberName:"+memberName);
	var url="${pageContext.request.contextPath }/footPrint/footPrintAdd?siteId="+siteId+"&supplyId="+supplyId+"&memberName="+memberName;	
	$.ajax({
		 url:url,
		 dataType:'jsonp',
		 processData: false, 
		 type:'get',
		 jsonpCallback:"result",
		 success:function(data){
			
			/*  var str="http://"+host+"/s_"+memberId+"_"+supplyId+".html";
			 window.open(str);*/	
			 window.location = window.location.href; 
			 
		 },
		 error:function(XMLHttpRequest, textStatus, errorThrown) {
			 /* var str="http://"+host+"/s_"+memberId+"_"+supplyId+".html";
			 window.open(str); */
		}});
}

</script>
</head>

<body>
<input type="hidden" value="${siteId }" id="siteId"/>
 <ul class="footprintCon-list clearfix">
		 <c:forEach items="${list}" var="l">
                <li>
                    <div class="footprintCon-piccenter"><span><a target="_blank" href="http://${host }/s_${l.memberId}_${l.id}.html" onclick="jumpDetail('${l.memberId}','${l.id}','${memberName }')" title="${l.name}"><img  src="${l.pic}"/></a></span></div>
                    <div class="footprintCon-text"><span><label>¥</label>${l.promotionPrice}/${l.unit}</span></div>
                </li>
          </c:forEach>
</ul>

</body>
</html>



