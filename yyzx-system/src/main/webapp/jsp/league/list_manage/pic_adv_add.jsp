<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加图片广告</title>
<style>
#imghead {filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);} 

</style>
<link href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/ajaxfileupload.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/time/WdatePicker.js"></script>
<script type="text/javascript">
var ajaxCallUrl="${pageContext.request.contextPath }/league/querySizeUIndustry";
var ajaxUrl="${pageContext.request.contextPath }/league/addAdvPic";
var pic_ad=$(".advertising-picture-con-bottom").prop("outerHTML");
//var idList = new Array(); 	
var ids='';
var i=0;
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/league/pic_ad.js"></script>

</head>

<body>
<div class="t1000-votB-R-in clearfix">
		<div class="motai_bg"></div>
    <div class="fabu_success"><span>发布成功</span><input type="button" value="确定" /></div>

    <div class="advertising-siteManagement-tit clearfix">
        <h2 class="t1000-tit">图片广告</h2> 
    </div>
    <div class="outer"><div class="con clearfix">
    	<div class="advertising-picture-con clearfix">
            <div class="advertising-picture-con-top">
                <ul>
				 <c:forEach items="${paramsList }" var="pl">
                    <li class="categ" value="${pl.id }">${pl. paramName}</li>
                </c:forEach>
                    <li class="all" value="0">全部</li> 
                </ul>
            </div>
            <div class="advertising-picture-con-center clearfix">
            <div class="hangye">
				  <c:forEach items="${sizeList }" var="stl">
                <dl>
                    <dt>${stl.advType }</dt>
                    <dd>
						<c:forEach items="${stl.leagueSizeList }" var="sl">
							<a href="javascript:void(0);" title="${sl.sizeCode }" id="${sl.sizeCode }" name="200*200">${sl.advSize }</a>
	                   </c:forEach>
                    </dd>
                </dl>
				 </c:forEach>
               </div>
    <!--             <div class="button floatR">
<input type="button" class="advertising-com-search-con-btn1 fabu unify" value="一键通发" onclick="unifyOs()"/>
</div>
       -->      
       				<div class="button floatR" style="font-size:12px;">
       					<img src="${pageContext.request.contextPath }/backstage/images/league/tishi.jpg"  alt="" />
       					<!-- （<font color="red">*</font>温馨提示：<span>白色：可选;灰色：没有该尺寸;蓝色：已选中;橘色：已投放过该尺寸广告</span>） -->
       				</div>
       
       			</div>
       
            
            <div class="content clearfix">

            </div>
        </div>
   
          
        </div></div> 
        
 	 
    
    
    
    
</div>
<div class="advertising-none"><div class="advertising-picture-con-bottom clearfix" >
        <div class="advertising-pic-modify">
            <div class="advertising-pic-modify-con">
               <form action="javascript:void(0)" id="fom1" name="fom1"  method="post" enctype="multipart/form-data" >
               <div id="showmsg"></div>
                <table>
                    <tr>
                        <th><span>图片广告</span><label></label><a class="close"></a></th>
                    </tr>
                    <tr>
                        <td>
                            <dl>
                                <dt>
                                    <span id="preview" class="preview"><img class="imghead" id="imghead"  src="${pageContext.request.contextPath }/backstage/fodder/league/add_bg.jpg"/></span>
                                    <input type="file"  onchange="previewImage(this)" class="file" name="imageUrl" id="fileToUpload"/>
                                   <!--  <img id="hid" class="hid"src="/" style="display:none" /> -->
                                    <p>图片上传</p>
                                    <i>200*200</i>
                                </dt>
                                <dd>
                                    <ul>
                                        <li>
                                            <span>广告名称</span>
                                            <input type="text" class="focus_on" name="advName" />
                                            <input type="hidden" class="focus_on" name="industryIds" />
                                            <input type="hidden" class="focus_on" name="sizeCode" />
                                        </li>
                                        <li class="zIndex1">
                                            <span>URL地址</span>
                                            <input type="text" class="focus_on" name="targetUrl" placeholder="格式如：http://99114.com"/><font color="red" ></font>
                                        </li>
                                        <li class="zIndex2">
                                            <span>发布时间</span>
                                            <input type="text" class="Wdate focus_on"  name="startTime" id="d11"
                                            onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d'})"/>
                                        </li>
                                        <li>
                                            <span>结束时间</span>
                                            <input type="text" class="Wdate focus_on" name="endTime" id="d12"
                                            onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d'})"/>
                                        </li>
                                    </ul>
                                </dd>
                            </dl>
                             <div class="button floatR" style="margin-right:20px;">
<input type="submit" class="advertising-com-search-con-btn1 fabu1" value="发布" name="fa" id="fa" onclick="addAdvPic(this)"/>
<!-- onclick="addAdvPic(this,'${pageContext.request.contextPath}/league/addAdvPic')" -->
</div>
                        </td>
                        
                    </tr>
                </table>
              </form> 
            </div>
            
        </div>
    </div></div>
</body>
</html>
