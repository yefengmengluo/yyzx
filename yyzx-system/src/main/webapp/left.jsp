<%@ page pageEncoding="UTF-8" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="pragma" content="no-cach" /> 
<meta http-equiv="cache-control" content="no-cache" /> 
<meta http-equiv="expires" content="0" />
<title>运营系统管理</title>
<link href="${pageContext.request.contextPath }/backstage/css/common/left.css" type="text/css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath }/backstage/css/common/leftMenu.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<div class="t1000-votB-tit" id="t1000-votB-tit">
	<div class="t1000-votB-tit-l" id="t1000-votB-tit-l">&nbsp;</div>
    <div class="t1000-votB-tit-r" id="t1000-votB-tit-r">
    	<span>当前用户：<a href="">${sessionScope.user.account }</a></span>
    	<span class="t1000-home"><a href="">网站首页</a></span>
    	<span class="t1000-chanpw"><a href="javascript:void(0)" name="setData">修改密码</a></span>
    	<span class="t1000-loginOut">
    	<a href="${pageContext.request.contextPath }/loginController/LogoutAction">安全退出</a></span>
    	<input type="hidden" name="account" value="${sessionScope.user.account }">
    	<input type="hidden" id="userId" name="userId" value="${sessionScope.user.userId }">
    	<input type="hidden" id="uPower" name="uPower" value="${sessionScope.user.userPower }">
    </div>
</div>

<div class="advertising-vote-L" id="advertising-vote-L">
	<div class="advertising-vote-list current" id="t1000-tit-1">
    	<h2 class="t1000-tit-1"><a id="company_list_a" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/vote/voteList">投票信息管理</a></h2>
        <ul style="display:block;">
        	<li>
            	<dl>
                	<dt id="vote-menu-21"><a  href="javascript:void(0)" urlData="${pageContext.request.contextPath }/VoteCompany/v1/selectCompanyList">企业会员管理</a></dt>
                </dl>
            	<dl>
                	<dt id="vote-menu-22"><a  href="javascript:void(0)" urlData="${pageContext.request.contextPath }/CommentController/queryAllVoteItemByCommentCount">评论信息管理</a></dt>
                </dl>
            </li>
        </ul>
    </div>
	<div class="advertising-vote-list" id="t1000-tit-2">
    	<h2 class="t1000-tit-2"><a>广告联盟系统</a><!-- <a href="javascript:void(0)" urlData="会员信息管理.html">广告联盟系统</a> --></h2>
        <ul class="three-title">
        	<li>
            	<dl class="">
                	<dt id="league-menu-21"><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/league/advInfoList">列表管理</a></dt>
                    <dd><a id="league-menu-211" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/league/Initialze/0">图片广告添加</a>
                    <a id="league-menu-212" href="javascript:void(0)" urlData="${pageContext.request.contextPath}/league/toAddWordAdvInfo">文字广告添加</a>
                    <a id="league-menu-213" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/league/advInfoList">图片广告列表</a>
                    <a id="league-menu-214" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/league/advWordList">文字广告列表</a>
                 </dl>
                <dl id="league_traffic">
                	<dt id="league-menu-24"><a  href="javascript:void(0)" urlData="${pageContext.request.contextPath }/LeagueAdTrafficTab/queryTrafficCount">流量管理</a></dt>
                </dl>
            	<dl id="league_sys_param">
                	<dt id="league-menu-22"><a  href="javascript:void(0)" urlData="${pageContext.request.contextPath }/LeagueSize/v1/queryLeagueSizeList">系统管理</a></dt>
                    <dd><a id="league-menu-221" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/LeaguePram/queryLeaguePram/0/0">添加行业</a>
                    <a id="league-menu-222" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/LeaguePram/queryLeaguePram/1/0">添加广告类型</a>
                    <a id="league-menu-223" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/LeagueSize/v1/toAddLeagueSize/0">广告尺寸添加</a>
                    </dd>
                </dl>
                <dl id="league_industry_station">
                	<dt id="league-menu-23"><a  href="javascript:void(0)" urlData="${pageContext.request.contextPath }/LeagueWebsite/queryLeagueWebsite?currentNum=1">行业单品查询</a></dt>
                    <dd><a id="league-menu-231" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/LeagueWebsite/toAddIndustryWebSite/0">行业单品添加</a>
                    </dd>
                </dl>
                
            	<dl>
                	<dt id="league-menu-25"> <a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/jsp/league/adv_example/ad_example.html">广告范例</a></dt>
            <%--         <dd>
                    <a id="league-menu-231" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/jsp/league/adv_example/pic_adv.html">图片广告</a>
                    <a id="league-menu-232" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/jsp/league/adv_example/liebiao_adv.html">列表广告</a>
                    <a id="league-menu-233" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/jsp/league/adv_example/duilian_adv.html">对联广告</a>
                    <a id="league-menu-234" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/jsp/league/adv_example/tonglan_adv.html">通栏广告</a>
                    <a id="league-menu-235" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/jsp/league/adv_example/popup_adv.html">弹窗广告</a>
                    <a id="league-menu-236" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/jsp/league/adv_example/info_adv.html">资讯广告</a>
                    <a id="league-menu-237" href="javascript:void(0)" urlData="${pageContext.request.contextPath }/jsp/league/adv_example/detail_adv.html">详情广告</a>
                    </dd> --%>
                </dl>
            </li>
        </ul>
    </div>
    <div class="advertising-vote-list" id="t1000-tit-3">
    	<h2 class="t1000-tit-3"><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/liuYanController/sp_ly/queryAllLiuYanByPage">留言管理</a></h2>
        <ul>
        	<li>
            	<dl>
                	<dt><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/liuYanController/sp_ly/queryAllLiuYanByPageStatus?status=0">未审核</a></dt>
                </dl>
            	<dl>
                	<dt><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/liuYanController/sp_ly/queryAllLiuYanByPageStatus?status=1">已审核</a></dt>
                </dl>
            	<dl>
                	<dt><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/liuYanController/sp_ly/queryAllLiuYanByPageStatus?status=2">已禁用</a></dt>
                </dl>
            </li>
        </ul>
    </div>
	<div class="advertising-vote-list" id="t1000-tit-4">
    	<h2 class="t1000-tit-4"><a href="javascript:void(0)" urlData="${pageContext.request.contextPath }/userController/queryAllUserByPage">管理员权限</a></h2>
       
    </div>
    
    
</div>


<div class="t1000-votB-R" id="t1000-votB-R">
    <iframe id="t1000-votB-R-box" class="t1000-votB-R-box" scrolling="auto" frameborder="0" width="100%" src=""></iframe>
</div>
<div class="bookingBlackBg"></div>
    <div class="bookingBox2">
        <div class="bookingTit">
            <h3>修改密码</h3>
            <span></span>
        </div>
        <div content="">
			<form action="javascript:void(0)" method="post" id="uppassword">
            <div class="vote_num">新密码:&nbsp&nbsp<input class="new_vote" type="password" id="newpassword" name="newpassword" value=""/></div>
          <div class="vote_num">   确认密码:<input class="new_vote" type="password" id="compassword" value=""/></div>
            <div class="vote_btn">
                 <input type="button" class="t1000-com-search-con-btn1 t1000-edit-vote" id="tijiao" value="提交"/>
                 <input type="button" class="t1000-com-search-con-btn2 t1000-edit-close" value="关闭"/>
            </div>
            </form>
        </div>
</div>


<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/left.js"></script>
<script type="text/javascript">
var uPower=$("#uPower").val();
 $(function(){
	/*  var uPower=$("#uPower").val();
	 if(uPower==0){//超级管理员所有权限
		$("#company_list_a").click();
	 }else{//普通管理员所有权限，无设置广告联盟行业、尺寸添加的权限
		 $("#league_sys_param").css("display","none");//不显示广告联盟参数设置 
	 }
	 
	 if(uPower==10||uPower==20){//拥有投票权限
		 $("#t1000-tit-2").css("display","none");//广告联盟不显示
		 $("#t1000-tit-3").css("display","none");//留言不显示
		 $("#t1000-tit-4").css("display","none");//管理员页面显示
		 $("#company_list_a").click();

	 }
	 if(uPower==11||uPower==21){//拥有广告联盟权限
		 $("#t1000-tit-1").css("display","none");//投票不显示
		 $("#t1000-tit-2").css("display","none");//广告联盟不显示
		 $("#t1000-tit-4").css("display","none");//管理员页面显示
		 $("#company_list_a").click();

	 } */
	$("#tijiao").click(function(){
		var casRemoteLoginUrl="${pageContext.request.contextPath}/userController/modifyPassword";
		updatePassword(casRemoteLoginUrl);
	})
	
	
}) 
</script>
</body>
</html>
