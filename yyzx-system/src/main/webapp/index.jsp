<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>中国棉纱交易网</title>
<link href="${pageContext.request.contextPath }/pay/css/common/module.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/pay/css/common/buy_pay.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/pay/css/t1127/default/top.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/pay/css/t1127/default/home.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/pay/css/t1127/default/bottom.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/pay/css/t1127/default/vbar.css" rel="stylesheet" type="text/css" />
<!-- 足迹引入begin -->
<link href="${pageContext.request.contextPath }/pay/css/t1127/default/vbar.css" rel="stylesheet" type="text/css" />
<!-- 足迹引入end -->
<script type="text/javascript" src="${pageContext.request.contextPath }/pay/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/pay/js/t1127/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/pay/js/t1127/home.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/pay/js/common/buy_pay.js"></script> 
<!-- 足迹引入begin -->
<script type="text/javascript" src="${pageContext.request.contextPath }/pay/js/common/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/pay/js/t1127/vbar.js"></script>
<script type="text/javascript">
$(function(){
	//queryFootPrint(8);
	$(".zujiTit").click(function(){
		if($(".vbarCon").css("display")=='block'){
			queryFootPrint(8);
		}
	})
})
</script> 
<!-- 足迹引入end -->
</head>
<body>
<script type="text/javascript">
var pageData = "${pageData}";
</script>
<div id="top">
    <div class="t1124-com-full-wrapper">
       <div class="t1124-com-wrapper clearfix">
            <div class="common-logo floatL" id="common-logo" module="siteConfig" bestFitModule="common-logo"><div content=""><h1><a href=""><img src="../../../pay/images/t1127/top/logo.jpg" /></a></h1></div></div>
            <div class="t1124-logo-right floatL" id="t1124-logo-right" module="advertising" bestfitmodule="advertising-common-single-img" refusemodule="global-common-*,advertising-common-*">
            	<div class="t1124-logo-right-con" content="">
                	<div class="advertising-common-single-img">
                        <a title="" href="javascript:void(0)"><img src="../../../pay/images/t1127/top/logo_right.jpg"></a>
                    </div>
                </div>
            </div>
            
            <div class="t1124-logo-ad floatR" id="t1124-logo-ad" module="advertising" bestfitmodule="advertising-common-single-img" refusemodule="global-common-*,advertising-common-*">
            	<div class="t1124-logo-ad-con" content="">
                	<div class="advertising-common-single-img">
                        <a title="" href="javascript:void(0)"><img src="../../../pay/fodder/t1127/top_ad.jpg"></a>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
    
    <div class="t1124-com-navWrap clearfix">
    	<div class="t1124-com-navBox">
            <div class="common-nav-full floatL" id="common-nav-full" module="navigation" bestFitModule="common-nav-full">
                <div class="common-nav-con" content="">
                    <ul>
                        <li class="on"><a href="">首页</a></li>
                        <li><a href="">产品供应</a></li>
                        <li><a href="">产品求购</a></li>
                        <li><a href="">招商加盟</a></li>
                        <li><a href="">公司企业</a></li>
                        <li><a href="">资讯中心</a></li>
                    </ul>
                </div>
            </div>
            
            <div class="t1124-com-nav-right floatR" id="t1127-com-nav-right" module="advertising" bestfitmodule="t1127-com-nav-right" refusemodule="global-common-*,advertising-common-*" >
                    <div class="t1124-com-nav-right-con"content="">
                        <ul class="t1127-nav-right-list clearfix">
                            <li><a href="" title="">搜索推广活动</a><span class="t1127-new-ico"></span></li>
                            <li><a href="" title="">互动商圈</a></li>
                            <li><a href="" title="">人才招聘</a></li>
                        </ul>
                    </div>
            </div>
        </div>
        
    </div>
    
    <div class="t1127-com-searchWrap clearfix" id="t1127-com-search">
    	<div class="t1127-index-newData floatL" id="t1127-index-newData" module="advertising" bestfitmodule="t1127-index-newData" refusemodule="global-common-*,advertising-common-*">
        	<div class="t1127-index-newData-tit">
            	<h2 headline="">最新数据</h2>
            </div> 
            <div class="t1127-index-newData-con" content="">
            	<ul class="t1127-index-newData-ul">
                	<li>供应产品:<span>5610</span>件</li>
                    <li>求购信息:<span>5610</span>条</li>
                    <li>招商信息:<span>5610</span>条</li>
                    <li>入驻企业:<span>5610</span>家</li>
                </ul>
            </div>
        </div>
    
    	<div class="t1036-com-searchbox floatR clearfix "> 
                <div class="t1036-com-search"> 
                     <div class="t1036-com-select"> 
                          <input type="hidden" value="0" name="cateID" id="cateID" /> 
                          <div class="t1036-com-tagselect">选择</div> 
                          <ul id="tabul" class="t1036-com-tagoptions" style="display:none;">
                          	<li value="1">供应</li>
                            <li value="2">求购</li>
                            <li value="3">企业</li>
                            <li value="4">加盟</li>
                          </ul>
                     </div> 
                     <div class="t1036-com-search-con"> 
                        <input id="txtSearchKey" type="text" class="t1036-com-search-con-text focusBlur grayTips" value="请输入您感兴趣的内容" onblur="if(this.value=='') this.value='请输入您感兴趣的内容';" onclick="if(this.value == '请输入您感兴趣的内容') this.value='';"/>
                        <input id="btnSearch" type="submit" class="t1036-com-search-con-btn1" value="搜索"/> 
                        <input id="lmsearch" type="submit" class="t1036-com-search-con-btn2" value="联盟搜"/>
                          <input type="hidden" id="siteID" value="10010"/>
                        <script type="text/javascript">
							var loadSearch = new loadTopSearch("loadSearch");
							loadSearch.txtObj = $d("txtSearchKey");
							loadSearch.btnObj = $d("btnSearch");
							loadSearch.lmObj = $d("lmsearch");
							loadSearch.tabDiv = $d("tabul");
							loadSearch.isTabSearch = true;
							loadSearch.createHTML("on");
							loadSearch.initEvents();// 控件添加事
						</script> 
                        
                     </div> 
                       
                </div> 
     		  </div>
    </div>
    
</div>
 <!-- 足迹 -->
<div class="vbar" style="display: block;"> 
   <div class="t1124-on-bg"></div> 
   <div class="vbar-main"> 
    <div class="vbar-promotions"> 
     <ul class="vbar-promotions-wrapper">
     </ul> 
    </div> 
    <div data-type="menus" class="vbar-menus"> 
     <div class="vbar-menus-wrapper"> 
      			 <div id="zujiDiv" >
						<div class="menu-title zujiTit" >
							<a id="queryFoot" target="_self" href="javascript:void(0);">足迹</a>
						</div>
						<div class="vbarCon zujiCon" >
							<div class="panel-hd">
								<div class="panel-title">我的足迹</div>
								<a target="_self" class="vbar-panel-close"
									href="javascript:void(0);">&nbsp;</a>
							</div>
							<iframe class="footprintCon" id="footprintCon"
								src="../top/linkTimeout.html" width="240" height="" scrolling="auto"
								frameborder="0" marginheight="0" marginwidth="0"></iframe>
						</div>
				</div>
      <div class="vbar-tool service-wrap" id="t1124-on-service" module="advertising" bestfitmodule="t1124-on-service" refusemodule="global-common-*,advertising-common-*"> 
       <div class="menu-title ser-btn">
        	<a headline="" class="txt" target="_self" href="javascript:void(0)">客服</a>
       </div> 
       <div class="vbarCon t1124-online-service" content="">
        	<div class="online-service-box">
            	<div class="t1124-onSer-close"></div>
                <div class="t1124-ifrSrc">http://webim.qiao.baidu.com/im/index?siteid=6662349&qq-pf-to=pcqq.c2c</div>
           </div>
       </div> 
      </div> 
     </div> 
    </div> 
    <div class="vbar-tools"> 
     <div class="vbar-tools-wrapper"> 
      <div class="vbar-tool ewm-wrap" id="ewmDiv" module="advertising" bestfitmodule="ewmDiv" refusemodule="global-common-*,advertising-common-*"> 
       <div class="menu-title f-link"> 
        <a headline="" class="txt" href="javascript:void(0)"></a> 
       </div> 
       <div class="vbarCon vbar-ewm-box" content="">
       	<div class="ewm-box-in">
            <div class="ewm-arr"></div>
            <img src="../../../pay/images/t1127/top/ewm.jpg" />
        </div>
       </div> 
      </div> 
      <div class="vbar-tool gotop"> 
       <div class="icon tool-icon"></div> 
      </div> 
     </div> 
    </div> 
    <div class="vbar-hide"> 
     <a href="javascript:void(0)"></a> 
    </div> 
   </div> 
   <div class="vbar-sub"> 
    <div class="vbar-tools"> 
     <div class="vbar-tools-wrapper"> 
      <div class="vbar-tool gotop"> 
       <div class="icon tool-icon"></div> 
      </div> 
     </div> 
    </div> 
    <div class="vbar-show"></div> 
   </div> 
  </div>
<!-- 足迹结束 -->

<div class="t1124-com-wrapper clearfix">

	<div class="t1124-ind-full-ad1" id="t1127-ind-full-ad1" module="advertising" refusemodule="global-common-*" bestfitmodule="t1127-ind-full-ad1">
        <div class="t1127-ind-full-ad1-con" content="">
        	<a class="t1127-ind-full-ad1-close" href="javascript:void(0)" target="_self">&nbsp;</a>
            <div class="advertising-common-single-img">
                <a id="t1127-ind-full-ad1-sm" href="" title=""><img src="../../../pay/fodder/t1127/sm_ad.jpg"></a>
                <a id="t1127-ind-full-ad1-big" href="" title=""><img src="../../../pay/fodder/t1127/big_ad.jpg"></a>
            </div>
        </div>
    </div>
    
    <div class="t1124-ind-sort floatL comMt30" id="t1124-ind-sort" module="category" bestFitModule="t1040-ind-sort">
    	<div class="t1124-ind-prolisttit">
    		<h2 headline="">棉纱</h2><img src="../../../pay/images/t1127/main/sort_tit_bg.png"/>
        </div>
        <div class="t1124-ind-prolistcon clearfix" content="">
           <dl>
           	<dt>品牌：</dt>
            <dd><a href="">Canon/佳能</a><a href="">Nikon</a><a href="">索尼</a><a href="">现代</a><a href="">星辉</a></dd>
           </dl>
           <dl>
           	<dt>像素：</dt>
            <dd><a href="">300万</a><a href="">500万</a><a href="">800万</a><a href="">1000万</a><a href="">1100万</a><a href="">2400万及以上</a></dd>
           </dl>
           <dl>
           	<dt>尺寸：</dt>
            <dd><a href="">3</a><a href="">2.7</a><a href="">3.2</a><a href="">2.5</a><a href="">3.0英寸</a><a href="">2.1</a></dd>
           </dl>
           <dl>
           	<dt>倍数：</dt>
            <dd><a href="">3倍</a><a href="">4倍</a><a href="">5倍</a><a href="">8倍</a><a href="">10倍</a><a href="">20倍以上</a></dd>
           </dl>
        </div>
    </div>
    
	<div class="t1124-ind-banner floatL comMt30" id="t1124-ind-banner" module="advertising" refuseModule="global-common-*,advertising-common-single-html" bestFitModule="advertising-common-slide,advertising-common-single-img">
        <div class="t1124-ind-banner-con" content="">
            
            <div class="advertising-common-slide">
            <ul>
                <li><a href="http://www.baidu.com"><img src="../../../pay/fodder/t1127/banner01.jpg"></a></li>
                <li><a href="http://www.1688.com"><img src="../../../pay/fodder/t1127/banner02.jpg"></a></li>
                <li><a href="http://www.taobao.com"><img src="../../../pay/fodder/t1127/banner03.jpg"></a></li>
                <li><a href="http://www.jd.com"><img src="../../../pay/fodder/t1127/banner04.jpg"></a></li>
                <li><a href="http://www.qq.com"><img src="../../../pay/fodder/t1127/banner05.jpg"></a></li>
            </ul>
            <ol><li class="on">1</li><li>2</li><li>3</li><li>4</li><li>5</li></ol>
        </div>
            
        </div>
    </div>
    
    <div class="t1124-ind-loginWrap comMt30 floatR">
    	<div bestfitmodule="common-login-user" module="user" id="common-login-user" class="common-login-user">
            <div content="">
                <div class="common-login-user-pre"><a href="" class="common-login-user-pre-login">登录</a><a href="" class="common-login-user-pre-register">会员注册</a></div>
                <!--<div class="common-login-user-after"><a href="">进入会员中心</a><a href="">发布采购</a><a href="">发布供应</a><a href="">进入店铺</a></div>-->
            </div>
        </div>
        <div class="t1006-com-tell" id="t1006-com-tell" module="advertising" bestFitModule="advertising-common-single-html" refuseModule="advertising-common-*,global-common-*">
        		<div class="t1006-com-tell-tit">
                	<h2 headline="">全国免费客服电话</h2>
                </div>
            	<div class="t1006-com-tellText" content="">
            		<div class="advertising-common-single-html">
                		400-651-5888
                	</div>
                </div>
            </div>
       
        <div class="t1127-ind-priList" id="t1127-ind-priList" bestfitmodule="t1127-ind-priList" refusemodule="global-common-*,advertising-common-*" module="advertising">
           <div class="t1127-ind-priList-con" content="">  
                <table cellspacing="0" cellpadding="0">
                    <thead>
                        <tr>
                            <th class="t1127-tdw1">报价产品</th>
                            <th class="t1127-tdw2">报价金额</th>
                            <th class="t1127-tdw3">产品库存</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                             <td colspan="8">
                                <div class="scrollList2">
                                  <table cellspacing="0" cellpadding="0">
                                       <tbody>
                                             <tr>
                                                <td class="t1127-tdw1">云v嘉纱业</td>
                                                <td class="t1127-tdw2">23000/吨</td>
                                                <td class="t1127-tdw3">纱支：21s</td>
                                             </tr>
                                             <tr>
                                                <td class="t1127-tdw1">云嘉嘉纱业</td>
                                                <td class="t1127-tdw2">23000/吨</td>
                                                <td class="t1127-tdw3">纱支：21s</td>
                                             </tr>
                                             <tr>
                                                <td class="t1127-tdw1">云嘉纱业</td>
                                                <td class="t1127-tdw2">23000/吨</td>
                                                <td class="t1127-tdw3">纱支：21s</td>
                                             </tr>
                                             <tr>
                                                <td class="t1127-tdw1">云嘉嘉纱业</td>
                                                <td class="t1127-tdw2">23000/吨</td>
                                                <td class="t1127-tdw3">纱支：21s</td>
                                             </tr>
                                             <tr>
                                                <td class="t1127-tdw1">云嘉纱业</td>
                                                <td class="t1127-tdw2">23000/吨</td>
                                                <td class="t1127-tdw3">纱支：21s</td>
                                             </tr>
                                             <tr>
                                                <td class="t1127-tdw1">云嘉纱业</td>
                                                <td class="t1127-tdw2">23000/吨</td>
                                                <td class="t1127-tdw3">纱支：21s</td>
                                             </tr>
                                             <tr>
                                                <td class="t1127-tdw1">云嘉纱业</td>
                                                <td class="t1127-tdw2">23000/吨</td>
                                                <td class="t1127-tdw3">纱支：21s</td>
                                             </tr>
                                             
                                        </tbody>
                                  </table>
                                  </div>
                             </td>
                        </tr>
                        
                    </tbody>
                </table>
            </div>
       </div>
        
        
        
        
  
        
        
        
            
    </div>
        
 </div>

<div class="t1127-ind-full-column1 comMt20 clearfix">
<div refusemodule="global-common-pic-list-text" bestfitmodule="t1124-ind-supplier" module="corporation" id="t1124-ind-supplier" class="t1124-ind-supplier">
		<div class="t1124-ind-supplier-tit">
        	<h2 headline="">金牌供应商<span>TOP榜</span></h2>
        </div>
        <div content="" class="t1124-ind-supplier-con">
            <div class="t1124-in-supplierBox">
                <dl class="t1124-in-supplierBox-dl t1124-ind-sup1">
                    <dt><a href=""><img src="../../../pay/fodder/t1127/06.jpg" /></a></dt>
                    <dd>
                    	<span class="t1124-in-supplierBox-addr">河河河河河河河河河河河河南商丘</span>
                        <span class="t1124-in-supplierBox-company t1124-bgColor1"><a href="">慈溪市锐玛电子有限公司慈溪市锐玛电子有限公司慈溪市锐玛电子有限公司慈溪市锐玛电子有限公司慈溪市锐玛电子有限公司</a></span>
                        <span class="t1124-in-supplierBox-companyInfo">华光集团旗华光集团旗华光集团旗华光集团旗华光集团旗华光集团旗华光集团旗华光集团旗下一家集食品研发</span>
                    </dd>
                </dl>
                <dl class="t1124-in-supplierBox-dl t1124-ind-sup2">
                    <dt><a href=""><img src="../../../pay/fodder/t1127/07.jpg" /></a></dt>
                    <dd>
                    	<span class="t1124-in-supplierBox-addr">广东佛山</span>
                        <span class="t1124-in-supplierBox-company t1124-bgColor2"><a href="">慈溪市锐玛电子有限公司</a></span>
                        <span class="t1124-in-supplierBox-companyInfo">华光集团旗下一家集食品研发</span>
                    </dd>
                </dl>
                <dl class="t1124-in-supplierBox-dl t1124-ind-sup3">
                    <dt><a href=""><img src="../../../pay/fodder/t1127/01.jpg" /></a></dt>
                    <dd>
                    	<span class="t1124-in-supplierBox-addr">湖北武汉</span>
                        <span class="t1124-in-supplierBox-company t1124-bgColor3"><a href="">慈溪市锐玛电子有限公司</a></span>
                        <span class="t1124-in-supplierBox-companyInfo">华光集团旗下一家集食品研发</span>
                    </dd>
                </dl>
                <dl class="t1124-in-supplierBox-dl t1124-ind-sup4">
                    <dt><a href=""><img src="../../../pay/fodder/t1127/04.jpg" /></a></dt>
                    <dd>
                    	<span class="t1124-in-supplierBox-addr">山西太原</span>
                        <span class="t1124-in-supplierBox-company t1124-bgColor1"><a href="">慈溪市锐玛电子有限公司</a></span>
                        <span class="t1124-in-supplierBox-companyInfo">华光集团旗下一家集食品研发</span>
                    </dd>
                </dl>
                
                <dl class="t1124-in-supplierBox-dl t1124-ind-sup5">
                    <dt><a href=""><img src="../../../pay/fodder/t1127/05.jpg" /></a></dt>
                    <dd>
                    	<span class="t1124-in-supplierBox-addr">山西太原</span>
                        <span class="t1124-in-supplierBox-company t1124-bgColor4"><a href="">慈溪市锐玛电子有限公司</a></span>
                        <span class="t1124-in-supplierBox-companyInfo">华光集团旗下一家集食品研发</span>
                    </dd>
                </dl>
                
                
                <dl class="t1124-in-supplierBox-dl t1124-ind-sup6">
                    <dt><a href=""><img src="../../../pay/fodder/t1127/04.jpg" /></a></dt>
                    <dd>
                    	<span class="t1124-in-supplierBox-addr">河南商丘</span>
                        <span class="t1124-in-supplierBox-company t1124-bgColor4"><a href="">慈溪市锐玛电子有限公司</a></span>
                        <span class="t1124-in-supplierBox-companyInfo">华光集团旗下一家集食品研发</span>
                    </dd>
                </dl>
                <dl class="t1124-in-supplierBox-dl t1124-ind-sup7">
                    <dt><a href=""><img src="../../../pay/fodder/t1127/02.jpg" /></a></dt>
                    <dd>
                    	<span class="t1124-in-supplierBox-addr">广东佛山</span>

                        <span class="t1124-in-supplierBox-company t1124-bgColor1"><a href="">慈溪市锐玛电子有限公司</a></span>
                        <span class="t1124-in-supplierBox-companyInfo">华光集团旗下一家集食品研发</span>
                    </dd>
                </dl>
                <dl class="t1124-in-supplierBox-dl t1124-ind-sup8">
                    <dt><a href=""><img src="../../../pay/fodder/t1127/03.jpg" /></a></dt>
                    <dd>
                    	<span class="t1124-in-supplierBox-addr">湖北武汉</span>
                        <span class="t1124-in-supplierBox-company t1124-bgColor2"><a href="">慈溪市锐玛电子有限公司</a></span>
                        <span class="t1124-in-supplierBox-companyInfo">华光集团旗下一家集食品研发</span>
                    </dd>
                </dl>
                <dl class="t1124-in-supplierBox-dl t1124-ind-sup9">
                    <dt><a href=""><img src="../../../pay/fodder/t1127/04.jpg" /></a></dt>
                    <dd>
                    	<span class="t1124-in-supplierBox-addr">山西太原</span>
                        <span class="t1124-in-supplierBox-company t1124-bgColor5"><a href="">慈溪市锐玛电子有限公司</a></span>
                        <span class="t1124-in-supplierBox-companyInfo">华光集团旗下一家集食品研发</span>
                    </dd>
                </dl>
                
            </div>
            
        </div>
    </div>
</div>

<div id="t1127-ind-tuijian" class="t1127-ind-tuijian" bestfitmodule="t1127-ind-tuijian" refusemodule="advertising-common-*,global-common-text-list-date" module="advertising">
            <div class="t1127-ind-tuijian-con clearfix" content="">
                 <ul class="t1127-ind-tuijian-ul clearfix">
                    <li><a target="_blank" href="http://za1411.aiao.cn">祁连獒业祁连獒业祁连獒业祁连獒业祁连獒业祁连獒业祁连獒业</a></li>
                    <li><a target="_blank" href="http://new.aiao.cn/2013/1107/32576.html">2014天津津津津津津津津金色是“真火"</a></li>
                    <li><a target="_blank" href="http://hbaoyun.aiao.cn">十三太保十三太保十三太保十三太保十三太保十三太保之“超能量”</a></li>
                    <li><a target="_blank" href="http://www.bjqingxiang.aiao.cn/">北京庆北京庆北京庆北京庆北京庆北京庆北京庆祥獒园</a></li>
                    <li><a target="_blank" href="http://pzay.aiao.cn">内蒙古赤峰平平平平平平平庄獒园</a></li>
                    <li><a target="_blank" href="http://www.baose.aiao.cn">宝鸡宝色鸡宝色鸡宝色鸡宝色鸡宝色鸡宝色獒园&mdash;东方神灵</a></li>
                    <li class="t1127-t-red"><a target="_blank" href="http://www.baose.aiao.cn">宝鸡宝色獒色獒色獒色獒色獒园&mdash;东方神灵</a><img width="28" height="11" src="../../../pay/images/t1127/main/sup.gif"></li>
                    <li class="t1127-t-red"><a target="_blank" href="http://www.baose.aiao.cn">宝鸡宝色獒园&mdash;东方神灵</a><img width="28" height="11" src="../../../pay/images/t1127/main/sup.gif"></li>
                    <li><a target="_blank" href="http://www.ysawjz.aiao.cn">北京皇城獒园</a></li>
                    <li><a target="_blank" href="http://shenwu.aiao.cn">北京神武獒园---雪狮王</a></li>
                    <li><a target="_blank" href="http://www.zgfq.aiao.cn">中国富强爱獒--摩道</a></li>
                    <li><a target="_blank" href="http://xcgj.aiao.cn">乡村狗圈</a></li>
                    <li><a target="_blank" href="http://www.kangba.aiao.cn">薪火顶级后代看这里</a></li>
                    <li class="t1127-t-red"><a target="_blank" href="http://www.baose.aiao.cn">宝鸡宝色獒园&mdash;东方神灵</a><img width="28" height="11" src="../../../pay/images/t1127/main/sup.gif"></li>
                    <li><a target="_blank" href="http://shanxidingtai.aiao.cn">山西鼎太獒园</a></li>
                    <li><a target="_blank" href="http://taigu.aiao.cn">海城太古獒园－龙王</a></li>
                    <li><a target="_blank" href="http://www.szbg.aiao.cn">深圳博古獒园</a></li>
                    <li><a target="_blank" href="http://zyac.aiao.cn">中原獒场－中原巨狮</a></li>
                    <li><a target="_blank" href="http://zjxt.aiao.cn">浙江啸天獒园&mdash;东方</a></li>
                    <li><a target="_blank" href="http://kunpeng.aiao.cn">山西阳泉锟鹏獒园</a></li>
                    <li><a target="_blank" href="http://www.didu.aiao.cn/">北京帝都獒业-红毛兽</a></li>
                    <li><a target="_blank" href="http://www.zhengdao.aiao.cn">沈阳正道－金色巨獒</a></li>
                    <li><a target="_blank" href="http://www.hwday.aiao.cn">湖北枣阳雪域汉武帝獒园</a></li>
                    <li class="t1127-t-red"><a target="_blank" href="http://www.baose.aiao.cn">宝鸡宝色獒园&mdash;东方神灵</a><img width="28" height="11" src="../../../pay/images/t1127/main/sup.gif"></li>
                    <li><a target="_blank" href="http://www.jufeng.aiao.cn">湖北枣阳飓风藏獒园</a></li>
                    <li><a target="_blank" href="http://www.tianci.aiao.cn">山东天赐獒园</a></li>
                    <li><a target="_blank" href="http://mingrui.aiao.cn">山东明睿獒园</a></li>
                    <li><a target="_blank" href="http://www.bianao.aiao.cn">南京边獒山庄</a></li>
                    <li><a target="_blank" href="http://e.souao.cn/yp/web/?108">沈阳沈北獒园</a></li>
                    <li><a target="_blank" href="http://haiwenfeng.aiao.cn">山东海文峰獒园-巨狮</a></li>
                </ul>
            </div>
        </div>

<div class="t1124-com-wrapper clearfix">   
   
    <div bestfitmodule="advertising-common-single-img" refusemodule="global-common-*,advertising-common-*" module="advertising" id="t1127-ind-full-adcolumn1" class="t1124-ind-full-adcolumn1 comMt20">
        <div content="" class="t1127-ind-full-adcolumn1-con">
            <div class="advertising-common-single-img">
                <a title="" href=""><img src="../../../pay/fodder/t1127/1190X116.jpg"></a>
            </div>
        </div>
    </div>
        
    <div bestfitmodule="global-common-pic-list" refusemodule="global-common-*,advertising-common-*" module="advertising" id="t1127-ind-full-adcolumn2" class="t1127-ind-full-adcolumn2 comMt20">
        <div content="" class="t1127-ind-full-adcolumn2-con">
            <ul class="global-common-pic-list clearfix">
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-1.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-2.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-3.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-4.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-1.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-2.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-3.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-4.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-1.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-2.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-3.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-4.jpg"></a></span></li>
            </ul>
        </div>
    </div>
    
       
    <div class="t1124-ind-hotSale comMt30 clearfix" id="t1127-ind-hotSale" module="supply" refusemodule="supply-common-hotline-con,global-common-text-list,global-common-text-list-date" bestfitmodule="t1124-sup-hotSale">
    	<div class="t1124-ind-hotSale-tit">
    		<h2 headline="">热卖专场</h2>
        </div>
        <div class="t1124-ind-hotSale-con" content="">
        
     
            <ul class="t1124-ind-hotSale-list2 clearfix">
                <li>
                    <div class="t1124-ind-hotSale-list2-piccenter"><span><a href="" title=""><img src="../../../pay/fodder/t1127/02.jpg"></a></span></div>
                    <a class="t1124-ind-hotSale-list2-text" href="" title=""><p>品类网防类网防类网防类网防类网防类网防类网防类网防水卷材_防水品类网防水卷材_防水</p><span><label>¥</label>3200/台</span></a>
                </li>
                <li>
                    <div class="t1124-ind-hotSale-list2-piccenter"><span><a href="" title=""><img src="../../../pay/fodder/t1127/173X173.jpg"></a></span></div>
                    <a class="t1124-ind-hotSale-list2-text" href="" title=""><p>品类网防类网防类网防类网防类网防类网防水卷材_防水品类网防水卷材_防水</p><span><label>¥</label>3200/台</span></a>
                </li>
                <li>
                    <div class="t1124-ind-hotSale-list2-piccenter"><span><a href="" title=""><img src="../../../pay/fodder/t1127/173X173.jpg"></a></span></div>
                    <a class="t1124-ind-hotSale-list2-text" href="" title=""><p>品类网防水卷材_防水品类网防水卷材_防水</p><span><label>¥</label>3200/台</span></a>
                </li>
                <li>
                    <div class="t1124-ind-hotSale-list2-piccenter"><span><a href="" title=""><img src="../../../pay/fodder/t1127/173X173.jpg"></a></span></div>
                    <a class="t1124-ind-hotSale-list2-text" href="" title=""><p>品类网防水卷材_防水品类网防水卷材_防水</p><span><label>¥</label>3200/台</span></a>
                </li>
                <li>
                    <div class="t1124-ind-hotSale-list2-piccenter"><span><a href="" title=""><img src="../../../pay/fodder/t1127/173X173.jpg"></a></span></div>
                    <a class="t1124-ind-hotSale-list2-text" href="" title=""><p>品类网类网类网类网类网类网防水卷材_防水品类网防水卷材_防水</p><span><label>¥</label>3200/台</span></a>
                </li>
                <li>
                    <div class="t1124-ind-hotSale-list2-piccenter"><span><a href="" title=""><img src="../../../pay/fodder/t1127/173X173.jpg"></a></span></div>
                    <a class="t1124-ind-hotSale-list2-text" href="" title=""><p>品类网防类网类网类网类网类网类网水卷材_防水品类网防水卷材_防水</p><span><label>¥</label>3200/台</span></a>
                </li>
                <li>
                    <div class="t1124-ind-hotSale-list2-piccenter"><span><a href="" title=""><img src="../../../pay/fodder/t1127/173X173.jpg"></a></span></div>
                    <a class="t1124-ind-hotSale-list2-text" href="" title=""><p>品类网防类网类网类网类网水卷材_防水品类网防水卷材_防水</p><span><label>¥</label>3200/台</span></a>
                </li>
                <li>
                    <div class="t1124-ind-hotSale-list2-piccenter"><span><a href="" title=""><img src="../../../pay/fodder/t1127/173X173.jpg"></a></span></div>
                    <a class="t1124-ind-hotSale-list2-text" href="" title=""><p>品类网防水卷材_防水品类网防水卷材_防水</p><span><label>¥</label>3200/台</span></a>
                </li>
                <li>
                    <div class="t1124-ind-hotSale-list2-piccenter"><span><a href="" title=""><img src="../../../pay/fodder/t1127/173X173.jpg"></a></span></div>
                    <a class="t1124-ind-hotSale-list2-text" href="" title=""><p>品类网防水卷材_防水品类网防水卷材_防水</p><span><label>¥</label>3200/台</span></a>
                </li>
                <li>
                    <div class="t1124-ind-hotSale-list2-piccenter"><span><a href="" title=""><img src="../../../pay/fodder/t1127/173X173.jpg"></a></span></div>
                    <a class="t1124-ind-hotSale-list2-text" href="" title=""><p>品类网防水卷材_防水品类网防水卷材_防水</p><span><label>¥</label>3200/台</span></a>
                </li>
                
                <li>
                    <div class="t1124-ind-hotSale-list2-piccenter"><span><a href="" title=""><img src="../../../pay/fodder/t1127/173X173.jpg"></a></span></div>
                    <a class="t1124-ind-hotSale-list2-text" href="" title=""><p>品类网防水卷材_防水品类网防水卷材_防水</p><span><label>¥</label>3200/台</span></a>
                </li>
                <li>
                    <div class="t1124-ind-hotSale-list2-piccenter"><span><a href="" title=""><img src="../../../pay/fodder/t1127/173X173.jpg"></a></span></div>
                    <a class="t1124-ind-hotSale-list2-text" href="" title=""><p>品类网防水卷材_防水品类网防水卷材_防水</p><span><label>¥</label>3200/台</span></a>
                </li>
                <li>
                    <div class="t1124-ind-hotSale-list2-piccenter"><span><a href="" title=""><img src="../../../pay/fodder/t1127/173X173.jpg"></a></span></div>
                    <a class="t1124-ind-hotSale-list2-text" href="" title=""><p>品类网防水卷材_防水品类网防水卷材_防水</p><span><label>¥</label>3200/台</span></a>
                </li>
                <li>
                    <div class="t1124-ind-hotSale-list2-piccenter"><span><a href="" title=""><img src="../../../pay/fodder/t1127/173X173.jpg"></a></span></div>
                    <a class="t1124-ind-hotSale-list2-text" href="" title=""><p>品类网防水卷材_防水品类网防水卷材_防水</p><span><label>¥</label>3200/台</span></a>
                </li>

        	</ul>
          
        </div>
    </div>
    
    <div class="t1127-ind-full-adcolumn2 comMt20" id="t1127-ind-full-adcolumn5" module="advertising" refusemodule="global-common-*,advertising-common-*" bestfitmodule="global-common-pic-list">
        <div class="t1127-ind-full-adcolumn2-con" content="">
            <ul class="global-common-pic-list clearfix">
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-1.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-2.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-3.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-4.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-1.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-2.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-3.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-4.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-1.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-2.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-3.jpg"></a></span></li>
                <li><span><a title="" href=""><img src="../../../pay/fodder/t1127/281X278-4.jpg"></a></span></li>
            </ul>
        </div>
    </div>
    
<div class="t1124-ind-hotsup floatL comMt30" id="t1124-ind-hotsup" bestfitmodule="t1124-ind-hotsup" refusemodule="global-common-pic-list-text,global-common-pic-list" module="buy"> 
  <div class="t1124-ind-title1"> 
   <h2 headline="">采购专场</h2> 
   <div>
    <a target="_blank" title="我要求购产品" href="http://oppor.99114.com/purchase/toSave?siteId=10010" class="add" other="">我要求购产品</a>
    <a target="_blank" title="更多" href="/Buy/l_0_10010_0_0_0_0_0_0_1.html" class="more" more="">更多</a>
   </div> 
  </div> 
  <div class="t1124-ind-hotsup-con" content="">
   <table cellspacing="0" cellpadding="0"> 
 <thead> 
  <tr> 
   <th class="t1124-tdw1">标题</th> 
   <th class="t1124-tdw2">报价数</th> 
   <th class="t1124-tdw3">区域要求</th> 
   <th class="t1124-tdw4">发布时间</th> 
   <th class="t1124-tdw4">截止时间</th> 
   <th class="t1124-tdw5">联系人</th> 
   <th class="t1124-tdw5">联系电话</th> 
   <th>操作</th> 
  </tr> 
 </thead> 
 <tbody> 
  <tr> 
   <td colspan="8"> 
    <div class="scrollList"> 
     <table cellspacing="0" cellpadding="0" style="margin-top: -35.4203px;"> 
      <tbody> 
   
      <tr> 
        <td class="t1124-tdw1"> 东莞市大朗粤雄纺织品贸易行 采...
        <input type="hidden" id="title" name="title" class="title" value="东莞市大朗粤雄纺织品贸易行 采购棉纱">
        <input type="hidden" id="purchaseId" name="purchaseId" class="purchaseId" value="84177665">
        
         </td> 
        <td class="t1124-tdw2">0</td> 
        <td class="t1124-tdw3"> 无限制</td> 
        <td class="t1124-tdw4"> 2015-11-12 </td> 
        <td class="t1124-tdw4">2015-12-21</td> 
        <td class="t1124-tdw5">丁园</td> 
        <td class="t1124-tdw5">188****4501</td> 
        <td><input type="button" value="购买" onclick="queryPurchase('东莞市大朗粤雄纺织品贸易行 采购棉纱','84177665')" class="pay"></td> 
       </tr>
       <tr> 
        <td class="t1124-tdw1"> 再生棉棉纱（绿色）
         <input type="hidden" id="title" name="title" class="title" value="再生棉棉纱（绿色）">
        <input type="hidden" id="purchaseId" name="purchaseId" class="purchaseId" value="84177661">
         </td> 
        <td class="t1124-tdw2">0</td> 
        <td class="t1124-tdw3"> 无限制</td> 
        <td class="t1124-tdw4"> 2015-11-12 </td> 
        <td class="t1124-tdw4">2015-12-21</td> 
        <td class="t1124-tdw5">丁园</td> 
        <td class="t1124-tdw5">188****4501</td> 
        <td><input type="button" value="购买" onclick="queryPurchase('再生棉棉纱（绿色）','84177661')" class="pay"></td> 
       </tr>
       <tr> 
        <td class="t1124-tdw1"> 21支纯棉细棉纱线价格 
         <input type="hidden" id="title" name="title" class="title" value="21支纯棉细棉纱线价格 ">
        <input type="hidden" id="purchaseId" name="purchaseId" class="purchaseId" value="84177484">
        </td> 
        <td class="t1124-tdw2">0</td> 
        <td class="t1124-tdw3"> 无限制</td> 
        <td class="t1124-tdw4"> 2015-11-12 </td> 
        <td class="t1124-tdw4">2015-12-18</td> 
        <td class="t1124-tdw5">葛现成</td> 
        <td class="t1124-tdw5">139****1376</td> 
        <td><input type="button" value="购买" onclick="queryPurchase('21支纯棉细棉纱线价格 ','84177484')" class="pay"></td> 
       </tr><tr> 
        <td class="t1124-tdw1"> 求购40JC 针织 环锭纺 强... 
         <input type="hidden" id="title" name="title" class="title" value="求购40JC 针织 环锭纺 强捻度达到160">
        <input type="hidden" id="purchaseId" name="purchaseId" class="purchaseId" value="84177770">
        </td> 
        <td class="t1124-tdw2">0</td> 
        <td class="t1124-tdw3"> 无限制</td> 
        <td class="t1124-tdw4"> 2015-11-12 </td> 
        <td class="t1124-tdw4">2015-12-21</td> 
        <td class="t1124-tdw5">张昌飞</td> 
        <td class="t1124-tdw5">137****8740</td> 
        <td><input type="button" value="购买" onclick="queryPurchase('求购40JC 针织 环锭纺 强捻度达到160','84177770')" class="pay"></td> 
       </tr><tr> 
        <td class="t1124-tdw1"> 求购 50JC 针织 
         <input type="hidden" id="title" name="title" class="title" value="求购 50JC 针织">
        <input type="hidden" id="purchaseId" name="purchaseId" class="purchaseId" value="84177773">
        </td> 
        <td class="t1124-tdw2">0</td> 
        <td class="t1124-tdw3"> 无限制</td> 
        <td class="t1124-tdw4"> 2015-11-12 </td> 
        <td class="t1124-tdw4">2015-12-21</td> 
        <td class="t1124-tdw5">张昌飞</td> 
        <td class="t1124-tdw5">137****8740</td> 
        <td><input type="button" value="购买" onclick="queryPurchase('求购 50JC 针织','84177773')" class="pay"></td> 
       </tr><tr> 
        <td class="t1124-tdw1"> 求购 精梳纯棉21S 26S ...
         <input type="hidden" id="title" name="title" class="title" value="求购 精梳纯棉21S 26S 32S 40S">
        <input type="hidden" id="purchaseId" name="purchaseId" class="purchaseId" value="84175762">
         </td> 
        <td class="t1124-tdw2">1</td> 
        <td class="t1124-tdw3"> 无限制</td> 
        <td class="t1124-tdw4"> 2015-11-12 </td> 
        <td class="t1124-tdw4">2015-12-10</td> 
        <td class="t1124-tdw5">张昌飞</td> 
        <td class="t1124-tdw5">137****8740</td> 
        <td><input type="button" value="购买" onclick="queryPurchase('求购 精梳纯棉21S 26S 32S 40S','84175762')" class="pay"></td> 
       </tr><tr> 
        <td class="t1124-tdw1"> 求购 人棉纱26S 环锭纺 
         <input type="hidden" id="title" name="title" class="title" value="求购 人棉纱26S 环锭纺">
        <input type="hidden" id="purchaseId" name="purchaseId" class="purchaseId" value="84180871">
        </td> 
        <td class="t1124-tdw2">0</td> 
        <td class="t1124-tdw3"> 无限制</td> 
        <td class="t1124-tdw4"> 2015-11-12 </td> 
        <td class="t1124-tdw4">2016-01-08</td> 
        <td class="t1124-tdw5">李大强</td> 
        <td class="t1124-tdw5">137****6609</td> 
        <td><input type="button" value="购买" onclick="queryPurchase('求购 人棉纱26S 环锭纺','84180871')" class="pay"></td> 
       </tr><tr> 
        <td class="t1124-tdw1"> 求购 40S棉+20D拉架平纹... 
         <input type="hidden" id="title" name="title" class="title" value="求购 40S棉+20D拉架平纹胚布 32寸32针">
        <input type="hidden" id="purchaseId" name="purchaseId" class="purchaseId" value="84180872">
        
        </td> 
        <td class="t1124-tdw2">0</td> 
        <td class="t1124-tdw3"> 无限制</td> 
        <td class="t1124-tdw4"> 2015-11-12 </td> 
        <td class="t1124-tdw4">2016-01-08</td> 
        <td class="t1124-tdw5">李大强</td> 
        <td class="t1124-tdw5">137****6609</td> 
        <td><input type="button" value="购买" onclick="queryPurchase('求购 40S棉+20D拉架平纹胚布 32寸32针','84180872')" class="pay"></td> 
       </tr></tbody> 
     </table> 
    </div> </td> 
  </tr> 
 </tbody> 
</table>
  </div> 
 </div>
    <div class="t1007-ind-trade floatL comMt30"  id="t1007-ind-trade" bestfitmodule="advertising-com-trade" refusemodule="global-common-pic-list-text,global-common-pic-list,advertising-common-*" module="advertising">
           <div class="t1124-ind-title1">
             <h2 headline="">交易信息</h2>
             <div><a other="" class="add">成交量最多的产品&gt;&gt;</a></div>  
       	   </div>  
             <div class="t1007-ind-trade-box" content="">
                 <ul class="advertising-com-trade clearfix">
                    <li>
                    <div>
                      <p class="floatL">订单号 130315602590000</p>
                      <span class="floatR">已经到货</span></div>
                    <p><span class="floatL">金额<strong>3210.0</strong>元</span> <span class="floatR">批发商-绿时代</span></p>
                    </li>
                    <li>
                    <div>
                      <p class="floatL">订单号 130315602590000</p>
                      <span class="floatR">已经到货</span></div>
                    <p><span class="floatL">金额<strong>3210.0</strong>元</span> <span class="floatR">批发商-绿时代</span></p>
                    </li>
                    
                    <li>
                    <div>
                      <p class="floatL">订单号 130315602590000</p>
                      <span class="floatR">已经到货</span></div>
                    <p><span class="floatL">金额<strong>3210.0</strong>元</span> <span class="floatR">批发商-绿时批发商-绿时代代-绿时代</span></p>
                    </li>
                    <li>
                    <div>
                      <p class="floatL">订单号 130315602590000</p>
                      <span class="floatR">已经到货</span></div>
                    <p><span class="floatL">金额<strong>3210.0</strong>元</span> <span class="floatR">批发商-绿时代</span></p>
                    </li>
                    <li>

                    <div>
                      <p class="floatL">订单号 130315602590000</p>
                      <span class="floatR">已经到货</span></div>
                    <p><span class="floatL">金额<strong>3210.0</strong>元</span> <span class="floatR">批发商-绿时代</span></p>
                    </li>
                    <li>
                    <div>
                      <p class="floatL">订单号 130315602590000</p>
                      <span class="floatR">已经到货</span></div>
                    <p><span class="floatL">金额<strong>3210.0</strong>元</span> <span class="floatR">批发商-绿时代</span></p>
                    </li>
           		</ul>
            </div>
    </div>
    <div class="cls"></div>
    
    <div class="t1124-ind-full-adcolumn1  comMt20" id="t1127-ind-full-adcolumn3" module="advertising" refusemodule="global-common-*,advertising-common-*" bestfitmodule="advertising-common-single-img">
        <div class="t1127-ind-full-adcolumn1-con" content="">
            <div class="advertising-common-single-img">
                <a href="" title=""><img src="../../../pay/fodder/t1127/1190X116.jpg"></a>
            </div>
        </div>
    </div>
    
    
    <div class="t1124-ind-exhi floatL comMt30 clearfix" id="t1127-ind-exhi" module="headline" bestFitModule="t1127-ind-exhi" refuseModule="global-common-*">
    	<div class="t1124-ind-tab-tit">
            <h2 headline="">展品汇</h2>
            <div class="info" other="">专业生产，千万产品供你选择。<br/>让您足不出户逛商场！</div>
        </div>
        <div class="t1124-ind-exhi-con" content="">
        	            
            <div class="t1124-ind-exhi-tab" id="t1124-ind-exhi-tab" module="supply" bestFitModule="t1124-ind-exhi-tab" refuseModule="global-common-*,supply-common-*">
            	<div class="t1124-ind-exhi-tab-con" content="">
                	<ul class="t1124-ind-exhi-tab-l">
                    	<li class="current"><a href="">2015春夏品牌展</a></li>
                    </ul>
                    <div class="t1124-ind-exhi-tab-rBox">
                   		<div class="t1124-ind-exhi-tab-r-con" style="display:block;">
                        	
                            <div class="t1124-ind-exhi-tab-r-list">
                            	
                                <div class="t1124-ind-exhi-recom">
                                    <h4 class="t1124-ind-exhi-recom-tit"><a href="">正品柯达AZ651</a></h4>
                                    <span class="t1124-ind-exhi-recom-money">价格<strong>¥ 6199.00</strong>/台</span>
                                    <span class="t1124-ind-exhi-recom-money">成交量<strong>70</strong>笔</span>
                                    <span class="t1124-ind-exhi-recom-join"><a href="">查看详情</a></span>
                                </div>
                                <ul class="t1124-ind-exhi-list-text">
                                	<li><a href="">11批发数码相机 1800万像素 自拍美颜</a></li>
                                    <li><a href="">批发数码相机 1800万像素 自拍美颜</a></li>
                                    <li><a href="">批发数码相机 1800万像素 自拍美颜</a></li>
                                    <li><a href="">批发数码相机 1800万像素 自拍美颜</a></li>
                                    <li><a href="">批发数码相机 1800万像素 自拍美颜</a></li>
                                    <li><a href="">批发数码相机 1800万像素 自拍美颜</a></li>
                                </ul>
                                
                                <ul class="t1124-ind-exhi-ul clearfix">
                                    <li>
                                    	<span>
                                        <a href="">
                                            <img alt="" src="../../../pay/fodder/t1127/cp01.jpg">
                                            <p>￥5200.00</p>
                                            <div class="t1124-ind-infor-text-bg"></div>
                                        </a>
                                        </span>
                                    </li>
                                    
                                    
                                    
                                    <li>
                                    	<span>
                                        <a href="">
                                            <img alt="" src="../../../pay/fodder/t1127/cp01.jpg">
                                            <p>￥5200.00</p>
                                            <div class="t1124-ind-infor-text-bg"></div>
                                        </a>
                                        </span>
                                    </li>
                                    <li>
                                    	<span>
                                        <a href="">
                                            <img alt="" src="../../../pay/fodder/t1127/cp01.jpg">
                                            <p>￥5200.00</p>
                                            <div class="t1124-ind-infor-text-bg"></div>
                                        </a>
                                        </span>
                                    </li>
                                    <li>
                                    	<span>
                                        <a href="">
                                            <img alt="" src="../../../pay/fodder/t1127/cp01.jpg">
                                            <p>￥5200.00</p>
                                            <div class="t1124-ind-infor-text-bg"></div>
                                        </a>
                                        </span>
                                    </li>
                              
                        		</ul>
                                
                            </div>
                            
                            <div class="t1124-ind-exhi-tab-r-list">
                            	
                                <div class="t1124-ind-exhi-recom">
                                    <h4 class="t1124-ind-exhi-recom-tit"><a href="">长焦数码相机</a></h4>
                                    <span class="t1124-ind-exhi-recom-money">价格<strong>¥ 6199.00</strong>/台</span>
                                    <span class="t1124-ind-exhi-recom-money">成交量<strong>70</strong>笔</span>
                                    <span class="t1124-ind-exhi-recom-join"><a href="">查看详情</a></span>
                                </div>
                                <ul class="t1124-ind-exhi-list-text">
                                	<li><a href="">批发数码相机 1800万像素 自拍美颜</a></li>
                                    <li><a href="">批发数码相机 1800万像素 自拍美颜</a></li>
                                    <li><a href="">批发数码相机 1800万像素 自拍美颜</a></li>
                                    <li><a href="">批发数码相机 1800万像素 自拍美颜</a></li>
                                    <li><a href="">批发数码相机 1800万像素 自拍美颜</a></li>
                                    <li><a href="">批发数码相机 1800万像素 自拍美颜</a></li>
                                </ul>
                                
                                <ul class="t1124-ind-exhi-ul clearfix">
                                    <li>
                                    	<span>
                                        <a href="">
                                            <img alt="" src="../../../pay/images/t1127/main/ico5.jpg">
                                            <p>￥5200.00</p>
                                            <div class="t1124-ind-infor-text-bg"></div>
                                        </a>
                                        </span>
                                    </li>
                                    <li>
                                    	<span>
                                        <a href="">
                                            <img alt="" src="../../../pay/fodder/t1127/cp02.jpg">
                                            <p>￥5200.00</p>
                                            <div class="t1124-ind-infor-text-bg"></div>
                                        </a>
                                        </span>
                                    </li>
                                    <li>
                                    	<span>
                                        <a href="">
                                            <img alt="" src="../../../pay/fodder/t1127/cp02.jpg">
                                            <p>￥5200.00</p>
                                            <div class="t1124-ind-infor-text-bg"></div>
                                        </a>
                                        </span>
                                    </li>
                                    <li>
                                    	<span>
                                        <a href="">
                                            <img alt="" src="../../../pay/fodder/t1127/cp02.jpg">
                                            <p>￥5200.00</p>
                                            <div class="t1124-ind-infor-text-bg"></div>
                                        </a>
                                        </span>
                                    </li>
                                    
                        		</ul>
                                
                            </div>
                            
                        </div>
                                               
                    </div>
                    
                </div>
            </div>
            
            <div refusemodule="global-common-*,supply-common-*" bestfitmodule="t1124-ind-exhi-ad" module="supply" id="t1124-ind-exhi-ad" class="t1124-ind-infor-recom t1124-ind-exhi-ad"> 
                <div content="" class="t1124-ind-exhi-recom-con">
                    <div class="t1124-ind-exhi-recom">
                        <h4 class="t1124-ind-exhi-recom-tit"><a href="">正品柯达AZ651</a></h4>
                        <span class="t1124-ind-exhi-recom-money">价格<strong>¥ 6199.00</strong>/台</span>
                        <span class="t1124-ind-exhi-recom-money">成交量<strong>70</strong>笔</span>
                        <span class="t1124-ind-exhi-recom-join"><a href="">查看详情</a></span>
                    </div>
                </div>
           </div>
        </div>
    </div>
    
    
    
<!--广告联盟通栏1-->        
<div id="fullAd-1190X60-1" class="fullAd-1190X116 floatL" bestfitmodule="advertising-common-single-html,advertising-common-single-img,global-common-pic-list,t1007-ind-full-column,t1007-ind-full-column2" refusemodule="global-common-*,advertising-common-slide" module="advertising">
    <div content="" class="fullAd-1190X116-con">
        <div class="advertising-common-single-html"> 
			 <script src="http://yyzx.99114.com/backstage/js/league/ad_league.js?pageWidth=1190&advType=0&advCode=109_112_1190x60-1&dataNum=1" type="text/javascript"></script> 
        </div>
	</div>
</div>
<!--广告联盟通栏1-->
    
    
    <div class="t1124-ind-article comMt30 clearfix">
    	
        	<div class="t1124-ind-article-l floatL" id="t1124-ind-article-l" module="article" bestFitModule="t1124-ind-article-l" refuseModule="article-common-*,global-common-pic-list">
            
                <div class="t1124-ind-tab-tit">
                    <h2 headline="">创业资讯</h2>
                    <div class="info" other="">海量资讯的新闻服务平台<br/>真实反映每时每刻的新闻热点</div>
                </div>
            
            	<div class="t1124-ind-article-l-con" content="">
                	<div class="t1124-ind-article-topPic-bottomText">
                    
                    	<div class="t1124-ind-article-topPic">
                        	<a href="">
                            	<img src="../../../pay/fodder/t1127/01.jpg">
                                <p>慧聪网产业带火热招募运营服务商，期待与您的合作</p>
                                <div class="t1124-ind-article-textBg"></div>
                            </a>
                        </div>
                        <ul class="t1124-ind-article-bottomText clearfix">
                        	<li><a href="">电商横行，实体店如何实现年年</a></li>
                            <li><a href="">电商横行，实体店如何实现年年</a></li>
                            <li><a href="">电商横行，实体店如何实现年年</a></li>
                            <li><a href="">电商横行，实体店如何实现年年</a></li>
                            <li><a href="">电商横行，实体店如何实现年年</a></li>
                            <li><a href="">电商横行，实体店如何实现年年</a></li>
                            <li><a href="">电商横行，实体店如何实现年年</a></li>
                            <li><a href="">电商横行，实体店如何实现年年</a></li>
                        </ul>
                        
                    </div>

                
                </div>
            
            </div>
            <div class="t1124-ind-article-m floatL" id="t1124-ind-article-m" module="article" bestFitModule="t1124-ind-article-m" refuseModule="article-common-*">
            	<div class="t1124-ind-article-tit">
                	<h2 headline="">【热门活动】</h2>
                </div>
                <div content="" class="t1124-ind-article-m-con">
                	<div class="t1124-ind-article-m-actibity">
                    	<p>2015年5月15日下午，第十三届中国（漯河）食品博览会迎来了“互联网+食博会”的创新性尝试，漯河市政府领导在漯河市会展中心接待了来自慧聪网30 <a href="">详情&gt;</a></p>
                        <ul class="t1124-ind-article-m-actibity-ul">
                        	<li><a href="">慧聪网携知名采购商带3亿订单齐聚食博会 </a><span>01-21</span></li>
                            <li><a href="">慧聪网携知名采购商带3亿订单齐聚食博会 </a><span>01-21</span></li>
                            <li><a href="">慧聪网携知名采购商带3亿订单齐聚食博会 </a><span>01-21</span></li>
                            <li><a href="">慧聪网携知名采购商带3亿订单齐聚食博会 </a><span>01-21</span></li>
                            <li><a href="">慧聪网携知名采购商带3亿订单齐聚食博会 </a><span>01-21</span></li>
                            <li><a href="">慧聪网携知名采购商带3亿订单齐聚食博会 </a><span>01-21</span></li>
                            <li><a href="">慧聪网携知名采购商带3亿订单齐聚食博会 </a><span>01-21</span></li>
                            <li><a href="">慧聪网携知名采购商带3亿订单齐聚食博会 </a><span>01-21</span></li>
                            <li><a href="">慧聪网携知名采购商带3亿订单齐聚食博会 </a><span>01-21</span></li>
                            <li><a href="">慧聪网携知名采购商带3亿订单齐聚食博会 </a><span>01-21</span></li>
                        </ul>
                    </div>
                </div>
            
            </div>
            <div class="t1124-ind-article-r floatL">
            	<div class="t1127-ind-logQuery" id="t1127-ind-logQuery" module="advertising" bestFitModule="t1127-ind-logQuery" refuseModule="global-common-*,advertising-common-*">
                    <div class="t1127-ind-logQuery-tit">
                        <h2 headline="">【物流查询】</h2>
                    </div>
                    <div class="t1127-logQuery-con" content="">
                    	<div class="exCompanySelect">
                            <input type="hidden" value="0" name="exCompanyName" id="exCompanyName" />
                            <div class="exCompanySelectCon">请选择快递公司</div>
                            <ul class="exCompanySelectList" style="display: none">
                                <li name="1">北京申通</li>
                                <li name="2">北京园通</li>
                                <li name="3">邮政</li>
                                <li name="4">顺丰</li>
                                <li name="5">京东</li>
                            </ul>
                        </div>
                        <input type="text" value="请输入快递单号" name="exNum" id="exNum" class="exNum" />
                    	<input type="button" class="checkEX" onclick="" value="点击查询">
                        
                        <div class="t1127-ExBg"></div>
   						<div class="t1127-exInfoBox">
                        	<div class="t1127-exInfoBox-tit">物流跟踪记录：2202820150411 <span></span></div>
                        	<div class="t1127-exInfoBox-con">
                            	<table cellpadding="0" cellspacing="0">
                                	<tr>
                                    	<th class="t1127-time">时间</th>
                                        <th class="t1127-status">状态</th>
                                    </tr>
                                    <tr>
                                    	<td class="t1127-time t1127-signed">2015-02-11 12:20:21</td>
                                        <td class="t1127-status t1127-signed">已签收，签收是本人</td>
                                    </tr>
                                    <tr>
                                    	<td class="t1127-time">2015-02-11 12:20:21</td>
                                        <td class="t1127-status"> 杭州留下公司 的收件员 公司已收件</td>
                                    </tr>
                                    <tr>
                                    	<td class="t1127-time">2015-02-11 12:20:21</td>
                                        <td class="t1127-status"> 杭州留下公司 的收件员 公司已收件</td>
                                    </tr>
                                    <tr>
                                    	<td class="t1127-time">2015-02-11 12:20:21</td>
                                        <td class="t1127-status"> 杭州留下公司 的收件员 公司已收件</td>
                                    </tr>
                                    <tr>
                                    	<td class="t1127-time">2015-02-11 12:20:21</td>
                                        <td class="t1127-status"> 杭州留下公司 的收件员 公司已收件</td>
                                    </tr>
                                    <tr>
                                    	<td class="t1127-time">2015-02-11 12:20:21</td>
                                        <td class="t1127-status"> 杭州留下公司 的收件员 公司已收件</td>
                                    </tr>
                                    <tr>
                                    	<td class="t1127-time">2015-02-11 12:20:21</td>
                                        <td class="t1127-status"> 杭州留下公司 的收件员 公司已收件</td>
                                    </tr>
                                    <tr>
                                    	<td class="t1127-time">2015-02-11 12:20:21</td>
                                        <td class="t1127-status"> 杭州留下公司 的收件员 公司已收件</td>
                                    </tr>
                                    <tr>
                                    	<td class="t1127-time">2015-02-11 12:20:21</td>
                                        <td class="t1127-status"> 杭州留下公司 的收件员 公司已收件</td>
                                    </tr>
                                    <tr>
                                    	<td class="t1127-time">2015-02-11 12:20:21</td>
                                        <td class="t1127-status"> 杭州留下公司 的收件员 公司已收件</td>
                                    </tr>
                         
                                </table>
                            </div>
                        </div>
                    
                        
                        
                    </div>
                  </div>
                  
                  
                <div class="t1127-ind-sina"  id="t1127-ind-sina" bestFitModule="advertising-common-single-html" refuseModule="global-common-pic-list-text,advertising-common-slide,advertising-common-single-img" module="advertising" >
                <div content="" class="t1127-ind-sina-box">
                    <div class="advertising-common-single-html">
                    <iframe width="292" scrolling="no" height="220" frameborder="0" class="share_self" src="http://widget.weibo.com/weiboshow/index.php?language=&amp;width=292&amp;height=195&amp;fansRow=2&amp;ptype=1&amp;speed=0&amp;skin=1&amp;isTitle=1&amp;noborder=1&amp;isWeibo=1&amp;isFans=1&amp;uid=3735606571&amp;verifier=86c1c81c&amp;dpc=1"> </iframe>
                  </div>
                </div>
          </div>
                  
                  
                              
            </div>
    </div>
    <div class="t1124-ind-full-column5 floatL comMt20" id="t1124-ind-full-column6" module="advertising" refusemodule="global-common-*,advertising-common-*" bestfitmodule="global-common-pic-list">
        <div class="t1124-ind-full-column5-con" content="">
            <ul class="global-common-pic-list clearfix">
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/banner03.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-1.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-3.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-2.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-3.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-1.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-3.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-2.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-4.jpg"></a></span></li>
            </ul>
        </div>
    </div>
    
    <div bestfitmodule="advertising-common-single-img" refusemodule="global-common-*,advertising-common-*" module="advertising" id="t1127-ind-full-adcolumn7" class="t1124-ind-full-adcolumn1 floatL comMt20">
        <div content="" class="t1127-ind-full-adcolumn1-con">
            <div class="advertising-common-single-img">
                <a title="" href=""><img src="../../../pay/fodder/t1127/1190X116.jpg"></a>
            </div>
        </div>
    </div>
   
    <div class="t1124-ind-full-column5 floatL comMt20" id="t1124-ind-full-column8" module="advertising" refusemodule="global-common-*,advertising-common-*" bestfitmodule="global-common-pic-list">
        <div class="t1124-ind-full-column5-con" content="">
            <ul class="global-common-pic-list clearfix">
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/banner03.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-1.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-3.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-2.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-3.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-1.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-3.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-2.jpg"></a></span></li>
                <li><span><a href="" title=""><img src="../../../pay/fodder/t1127/281X278-4.jpg"></a></span></li>
            </ul>
        </div>
    </div>
    
    <div bestfitmodule="advertising-common-single-img" refusemodule="global-common-*,advertising-common-*" module="advertising" id="t1127-ind-full-adcolumn9" class="t1124-ind-full-adcolumn1 floatL comMt20">
        <div content="" class="t1127-ind-full-adcolumn1-con">
            <div class="advertising-common-single-img">
                <a title="" href=""><img src="../../../pay/fodder/t1127/1190X116.jpg"></a>
            </div>
        </div>
    </div>   
    
    <div class="t1022-ind-bottom-ad floatL" id="t1124-ind-bottom-ad" module="advertising" refuseModule="global-common-*,advertising-common-*" bestFitModule="t1124-ind-bottom-ad">
		<div class="t1022-ind-bottom-ad-kinds" content="">
    	<ul>
    		<li class="t1022-ind-bottom-ad-fen">
            	<a>招商代理</a>
                <a class="hui">招商4代理</a>
            </li>
            <li class="t1022-ind-bottom-ad-fen">
            	<a>招商代理</a>
                <a>招商2代理</a>
            </li>
            <li class="t1022-ind-bottom-ad-he">
            	<a class="hui">白茶砖型</a>
            </li>
            <li class="t1022-ind-bottom-ad-fen">
            	<a>招商代理</a>
                <a>招商代理</a>
            </li>
            <li class="t1022-ind-bottom-ad-long">
            	<a>招商代理</a>
            </li>
            <li class="t1022-ind-bottom-ad-he">
            	<a class="seven">白茶砖型</a>
            </li>
            <li class="t1022-ind-bottom-ad-long">
            	<a class="seven">招商4代理</a>
            </li>
            <li class="t1022-ind-bottom-ad-he">
            	<a class="seven">招商5代理</a>
            </li>
            <li class="t1022-ind-bottom-ad-long">
            	<a class="seven hui">招商代理</a>
            </li>
            
            <li class="t1022-ind-bottom-ad-fen">
            	<a>招商代理</a>
                <a>招商代理</a>
            </li>
            <li class="t1022-ind-bottom-ad-he">
            	<a class="seven hui">招商代理</a>
            </li>
    	</ul>
    </div>
   </div>
   
   <!--广告联盟通栏2-->    
<div id="fullAd-1190X60-2" class="fullAd-1190X116 floatL" bestfitmodule="advertising-common-single-html,advertising-common-single-img,global-common-pic-list,t1007-ind-full-column,t1007-ind-full-column2" refusemodule="global-common-*,advertising-common-slide" module="advertising">
    <div content="" class="fullAd-1190X116-con">
        <div class="advertising-common-single-html"> 
			<script type="text/javascript" src="http://yyzx.99114.com/backstage/js/league/ad_league.js?pageWidth=1000&advType=0&advCode=109_112_1190x116&dataNum=1"></script>        
        </div>  
    </div>
</div>
<!--广告联盟通栏2-->
    
    <div bestfitmodule="common-link-box" module="link" id="common-link-box" class="common-link-box">
	<div class="common-link-box-tit"><h3 headline="">友情链接</h3><div class="t1124-line-bg"></div></div>
    <div content="" class="common-link-box-con">
        <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a><a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a><a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a> <a href="" title="">中国铁塔交易网</a>
    </div>
</div>
        
</div>

<div id="div2">
    <div class="div2_close"></div>

    <div bestfitmodule="t1075-ind-goods-form" module="form" id="t1075-ind-goods-form" class="t1075-ind-goods-form"> 
  <div content="" class="t1075-ind-goods-form-box">
   <div class="t1075-ind-goods-form-con"> 
 <form method="post" action="" class="form6581"> 
  <input type="hidden" value="6581" id="formId" name="formId"> 
  <textarea id="message" rows="" cols="" name="message" class="t1075-ind-goods-textarea" style="color: rgb(153, 153, 153); border: 1px solid rgb(222, 222, 222);">填写您的真实需求</textarea> 
  <input type="text" value="" class="t1075-ind-goods-textarea-tell" name="telphone" id="telphone" style="color: rgb(153, 153, 153); border: 1px solid rgb(255, 0, 0);"> 
  <input type="button" value="立即帮我找" class="t1075-ind-goods-btn"> 
 </form> 
 <div class="cls"></div> 
 <div class="t1075-ind-goods-form-flow"></div> 
</div> 
<script src="/js/common/jquery-1.8.0.min.js" type="text/javascript"></script> 
<script type="text/javascript">

$(function(){
//电话栏失焦验证事件
	$(".t1075-ind-goods-textarea-tell").blur(function(){
		var str = $(".t1075-ind-goods-textarea-tell").val();
		reg1 = /^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/;
		reg2 = /^((\(\d{2,3}\))|(\d{3}\-))?15\d{9}$/;
		reg3 = /^((\(\d{2,3}\))|(\d{3}\-))?18\d{9}$/;
		reg4 = /^((\(\d{2,3}\))|(\d{3}\-))?14\d{9}$/;
		if ((!reg1.test(str)) && (!reg2.test(str))
				&& (!reg3.test(str)) && (!reg4.test(str))) {
			//请将"字符串类型"要换成你要验证的那个属性名称！    
			$('.t1075-ind-goods-textarea-tell').css({
				"border" : "1px solid #f00"
			});
			return false;
		} else {
			$('.t1075-ind-goods-textarea-tell').css({
				"border" : "1px solid #dedede"
			});
		}
		
	})
	//电话栏点击事件
	$(".t1075-ind-goods-textarea-tell").focus(function(){
		var str = $(".t1075-ind-goods-textarea-tell").val();
		reg1 = /^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/;
		reg2 = /^((\(\d{2,3}\))|(\d{3}\-))?15\d{9}$/;
		reg3 = /^((\(\d{2,3}\))|(\d{3}\-))?18\d{9}$/;
		reg4 = /^((\(\d{2,3}\))|(\d{3}\-))?14\d{9}$/;
		if ((reg1.test(str)) && (reg2.test(str))
				&& (reg3.test(str)) && (reg4.test(str))) {
			$('.t1075-ind-goods-textarea-tell').css({
				"border" : "1px solid #f00"
			});
		}
		if (str == "联系电话") {
			$(".t1075-ind-goods-textarea-tell").attr("value","")
		}
		
	})
	//文本框失焦验证事件
	$(function(){
		$(".t1075-ind-goods-textarea").blur(function(){
			var str = $(".t1075-ind-goods-textarea").val();
			if(str==""){
				$(".t1075-ind-goods-textarea").html("填写您的真实需求");
				$(".t1075-ind-goods-textarea").css({
					"border" : "1px solid #f00"
				});
				return false;
			}else{
				$(".t1075-ind-goods-textarea").css({
					"border" : "1px solid #dedede"
				});
			}
		});
	})
	//文本域点击事件
	$(function(){
		$(".t1075-ind-goods-textarea").focus(function(){
			var str = $(".t1075-ind-goods-textarea").val();
			if(str=="填写您的真实需求"){
				$(".t1075-ind-goods-textarea").val("");
				$(".t1075-ind-goods-textarea").css({
					"border" : "1px solid #dedede"
				});
			}
		})
	})
	
})

</script> 
<script type="text/javascript">
$(function(){
	$(".t1075-ind-goods-btn").click(function(){
		
		//验证文本域
		$(".t1075-ind-goods-textarea").blur(function(){
			var str = $(".t1075-ind-goods-textarea").val();
			if(str==""){
				$(".t1075-ind-goods-textarea").html("填写您的真实需求");
				$(".t1075-ind-goods-textarea").css({
					"border" : "1px solid #f00"
				});
				return false;
			}
		});
		//验证电话
		var str = $(".t1075-ind-goods-textarea-tell").val();
		reg1 = /^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/;
		reg2 = /^((\(\d{2,3}\))|(\d{3}\-))?15\d{9}$/;
		reg3 = /^((\(\d{2,3}\))|(\d{3}\-))?18\d{9}$/;
		reg4 = /^((\(\d{2,3}\))|(\d{3}\-))?14\d{9}$/;
		if ((!reg1.test(str)) && (!reg2.test(str))
				&& (!reg3.test(str)) && (!reg4.test(str))) {
			//请将"字符串类型"要换成你要验证的那个属性名称！    
			$('.t1075-ind-goods-textarea-tell').css({
				"border" : "1px solid #f00"
			});
			return false;
		} else {
			$('.t1075-ind-goods-textarea-tell').css({
				"border" : "1px solid #dedede"
			});
		}
		
		var formData = $(".form6581").serialize();
		
		 $.post("/searchgoodsform/save",formData,function(data){
			if(data.code==200){
				$(".t1075-ind-goods-textarea").val("");
				$(".t1075-ind-goods-textarea-tell").attr("value","");
				
				
				alert("您的需求我们的工作人员已经收到，稍后会和您联系！");
				location.href="/";
			}else{
				alert("请您稍等片刻，或重新填写需求");
			}
			
		}); 
		
		/* $.ajax({
			   type: "POST",
			   url: "/searchgoodsform/save",
			  // data: "name=John&location=Boston",
			   success: function(msg){
			     alert( "Data Saved: " + msg );
			   },error: function(XMLHttpRequest, textStatus, errorThrown) {
                   alert("A:"+XMLHttpRequest.status);
                   alert("B:"+XMLHttpRequest.readyState);
                   alert("C:"+textStatus);
               }
			});  */
		
	})
})
</script>
  </div> 
 </div>
</div>


<div class="clearfix">
    <div class="copyright-full-bottom">
    <div class="copyright-copy-box">
        <div class="copyright-copy-con floatL" module="category" id="t1124-copyright-copy-con" bestFitModule="t1124-copyright-copy-con">
            <div content="">
            	<ul>
                     <li class="copyright-copy-con-weight">新手指南</li>
                     <li class="com-left-bor"><a>买家入门</a></li>
                     <li><a>卖家入门</a></li>
                     <li><a>开通支付宝</a></li>
                     <li><a>绑定支付宝</a></li>
                 </ul>
                 <ul>
                     <li class="copyright-copy-con-weight">核心服务</li>
                     <li class="com-left-bor"><a>找供应</a></li>
                     <li><a>找求购</a></li>
                     <li><a>找代理</a></li>
                     <li><a>查行情</a></li>
                 </ul>
                 <ul>
                     <li class="copyright-copy-con-weight">关于我们</li>
                     <li class="com-left-bor"><a  href="">广告招商</a></li>
                     <li><a  href="">关于照相机交易网</a></li>
                     <li><a  href="">本站留言</a></li>
                     <li><a  href="">联系我们</a></li>
                     <li><a  href="">隐私策略</a></li>
                 </ul>             
                 <ul>
                     <li class="copyright-copy-con-weight">商务合作</li>
                     <li class="com-left-bor"><a  href="">广告招商</a></li>
                     <li><a  href="">友情链接</a></li>
                     <li><a  href="">会员服务</a></li>
                     <li><a  href="">展会合作</a></li>
                     <li><a  href="">大宗交易</a></li>
                 </ul>  
                 <ul>
                     <li class="copyright-copy-con-weight">合作伙伴</li>
                     <li class="com-left-bor"><a>中国网库</a></li>
                     <li><a>中国行业网联盟</a></li>
                     <li><a>中国B2B电子商务服务联盟</a></li>
                     <li><a>中国招商联盟</a></li>
                     <li><a>企推委企业身份认证</a></li>
                 </ul>  
            </div> 
        </div>
        <div class="copyright-copy-con-special" id="copyright-copy-con-special" module="advertising" refuseModule="advertising-common-*,global-common-*" bestFitModule="copyright-copy-con-special">
            <div class="copyright-copy-con-special-box" content="">
                <h4 class="weight">关注我们</h4> 
                <ul class="copyright-copy-attention-con"> 
                    <li><a href=""><span class="i_sina">&nbsp;</span>新浪微博</a></li> 
                    <li><a href=""><span class="i_renren">&nbsp;</span>博客网</a></li>
                    <li><a href=""><span class="i_dban">&nbsp;</span>搜狐</a></li> 
                    <li><a href=""><span class="i_qzone">&nbsp;</span>天涯</a></li> 
                    <li><a href=""><span class="i_sina2">&nbsp;</span>腾讯微博</a></li>
                    <li><a href=""><span class="i_wangyi">&nbsp;</span>凤凰</a></li>     
                </ul> 
            </div>
        </div> 
        
        <div class="t1124-app-box floatR" id="t1124-app-box" module="advertising" refuseModule="advertising-common-*,global-common-*" bestFitModule="t1124-app-box">
        	<div content="" class="t1124-app-con">
            	<h4 class="weight">手机管理生意更方便</h4> 
                <div class="t1124-app-dl">
                	<span>单品通管理APP</span><a href="">下载</a>
                </div>
                <ul class="t1124-ewm-box">
                	<li><img src="../../../pay/images/t1127/bottom/ewm01.jpg" alt=""/></li>
                    <li><img src="../../../pay/images/t1127/bottom/ewm02.jpg" alt=""/></li>
                </ul>
            </div>
        </div>              
    </div>
    <!-- 采购报价 -->
  <div class="buy-pay-modu" ></div>
    <div class="buy-pay-out">
       
    </div>
    <div module="category" bestFitModule="t1124-com-footer-cate" id="t1124-com-footer-cate" class="t1124-com-footer-cate">
       <div class="t1124-copyright-footer-top" content="">
       		<p><a href="">关于我们</a>|<a href="">帮助中心</a>|<a href="">交易条款</a>|<a href="">诚征英才</a>|<a href="">网站地图</a>|<a href="">友情链接</a></p>
       </div>
    </div>
        
    <div class="copyright-footer" id="t1124-copyright-footer" module="siteConfig" bestFitModule="t1124-copyright-footer">
        <div class="t1124-copyright-footer-con" content="">
            <p>版权所有<span>&copy;</span>中国棉纱交易网&nbsp;地址：北京市东城区胜古中路1号蓝宝商务大厦402&nbsp;技术支持：<a href="http://business.99114.com" rel="nofollow">中国网库</a> ICP备案号：京ICP证060961号
            <script src="http://s96.cnzz.com/stat.php?id=5586469&web_id=5586469&show=pic" language="JavaScript"></script>
            <script src="http://s96.cnzz.com/stat.php?id=5596693&web_id=5596693&show=pic" language="JavaScript"></script>
            <script type="text/javascript" id="bdshare_js" data="type=slide&amp;mini=1&amp;img=4&amp;uid=628257"></script></p>
        </div>     	
    </div>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/pay/js/t1127/goods.js"></script>
  <script type="text/javascript">
  function queryPurchase(title,purId){
	  var ht=queryPurchase1(title,purId);
	  $(".buy-pay-out").html(ht);
	 	$(".buy-pay-modu").show();
		$(".buy-pay-out").show();

  }
  
	function queryPurchase1(title,purId){
		var ht='';
		if(title == ""){
			ht+='<div class="t1127-exInfoBox-tit">错误<span onclick="closeLogQueryPage()"></span></div>';
		}
		else{
			ht+=
				ht+='<div class="buy-pay">';
				ht+='<div class="buy_pay_close"><a href="javascript:;" onclick="closepay()"><img src="../../../pay/images/t1127/main/buy_pay_close.jpg"/></a></div>';
				ht+='<div class="buy-con">';
				ht+='<div class="head"><span>标&nbsp;&nbsp;&nbsp;题：</span><p>'+title+'</p>';
				ht+='<input  type="hidden" id="subject" name="subject" class="subject" value="'+title+'">';
				ht+='<input  type="hidden" id="purcherId" name="purcherId" class="purcherId" value="'+purId+'"></div>';
				ht+='<div class="price"><span>价&nbsp;&nbsp;&nbsp;格：</span><i>2.00元</i><input  type="hidden" id="price" name="price"  value="2.00"></div>';
				ht+='<div class="phone_num"><span>手机号：</span><input  type="text" id="telephone" name="telephone" class="phone_numInp" value="请输入手机号"  ></div>';
				ht+='<div class="yzm"><input type="text" value="" class="yanzheng" name="yanzheng" id="yanzheng"/><input type="button" value="获取短信验证码" class="receive" id="receive" /></div>';
				ht+='<input type="hidden" value="" class="suiji" id="suiji"/>';
				ht+='<input  type="hidden" id="goodsType" name="goodsType" class="goodsType" value="1">';
				ht+='<div class="text"><p>短信已经发送到您的手机，如在60秒之内还没有收到短信验证码,请重新获取验证码</p></div>';
				ht+=' <div class="buy-payPay"><input  type="submit"  id="paySubmit" class="button" value="确认支付"></div> </div></div>';	
			       
			
		}
		
		
		return ht;
	}
	
	function closepay(){
		$(".buy-pay-modu").hide();
		$(".buy-pay-out").hide();	
		$(".buy-pay").hide();
	}
	
	
	
  </script>
              
                    
                  



</body>
</html>