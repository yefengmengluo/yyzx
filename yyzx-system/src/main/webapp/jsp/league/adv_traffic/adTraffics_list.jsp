<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>详情信息——流量分析</title>
<link
	href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css"
	type="text/css" rel="stylesheet" />
<link
	href="${pageContext.request.contextPath }/backstage/css/league/detail.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/backstage/js/common/chart/echarts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/backstage/js/league/flow.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/backstage/js/time/WdatePicker.js"></script>
<script type="text/javascript">
	var isInput;
	$(function() {
		// 路径配置
		var dataList = new Array();
		dataList = ${adTrafficsPie};
		var dLength = dataList.length;
		var areaName = new Array(dLength);
		var objList = new Array(dLength);

		for (var i = 0; i < dLength; i++) {
			var obj = {
				name : dataList[i].area,
				value : dataList[i].visitNum
			};
			objList[i] = obj;
			areaName[i] = dataList[i].area;
		}
		require
				.config({
					paths : {
						echarts : '${pageContext.request.contextPath }/backstage/js/common'
					}
				});
		require([ 'echarts', // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
		'echarts/chart/pie' ], function(ec) {
			var myChart = ec.init(document.getElementById('main'));
			var option = {
				title : {
					text : '区域流量统计',
					//subtext : '今日',
					x : 'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				toolbox : {
					show : true,
					feature : {
						saveAsImage : {
							show : true,
							title : '保存图片',
							type : 'jpeg',
							lang : [ '点击保存' ],
							//name : "流量统计" + new Date().Format("yyyyMMddHHmmss")
						}
					},
					itemSize : 22,//工具箱大小
					x : 1050,
					y : 15
				},
				legend : {
					orient : 'vertical',
					x : 'left',
					data : areaName
				},
				calculable : false,
				series : [ {
					name : '访问来源',
					type : 'pie',
					radius : '55%',
					center : [ '50%', '60%' ],
					data : objList
				} ],
				noDataLoadingOption:{
					text:"暂无数据"
					,x:"center"
					,y:"center"
					,effect :"whirling"
			}
			};
			myChart.setOption(option);
		});
		initTabStatus("${isInput}", "${beginDate}", "${endDate}");
	});

	function goBack() {
		var param = "${fn:replace(urlParam, ',', '&')}";
		var locationUrl = "${pageContext.request.contextPath }/LeagueAdTrafficTab/queryTrafficCountBySizeCode?"
				+ param;
		location.href = locationUrl;
	}
</script>
</head>
<body>
	<div class="t1000-votB-R-in clearfix">
		<div class="advertising-siteManagement-tit clearfix">
			<img title="后退" style="width: 30px; display: inline"
				src="${pageContext.request.contextPath }/backstage/images/league/goback.png"
				onclick="goBack()" />
			<h2 style="display: inline" class="t1000-tit">详情信息——流量分析</h2>
		</div>
		<div class="detail-content">
			<!-- 饼图显示 -->
			<div id="main" class="analysis-pic"></div>
			<input id="currentNum" type="hidden" value="${adTraffics.currentNum}"></input>
			<input type="hidden" id="urlParam" value="${urlParam}" />
			<table cellpadding="0" cellspacing="0" class="flow-analysis">
				<tr>
					<td onclick="doQuery(false,'0','${adId}','1')" class="a_1 current">今天</td>
					<td onclick="doQuery(false,'1','${adId}','1')" class="a_1">7天之内</td>
					<td onclick="doQuery(false,'2','${adId}','1')" class="a_1">30天之内</td>
					<td colspan="3">开始日期： <input id="beginDate" type="text"
						class="Wdate focus_on"
						value="<fmt:formatDate value='${beginDate}' pattern='yyyy-MM-dd'/>"
						onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\');}'})" />
						结束日期： <input id="endDate" type="text" class="Wdate focus_on"
						value="<fmt:formatDate value='${endDate}' pattern='yyyy-MM-dd'/>"
						onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'beginDate\');}'})" />
						<input type="button" value="搜索"
						onclick="doQuery(true,'-1','${adId}','1')"
						class="detail-search-btn" />
					</td>
				</tr>
				<tr>
					<th colspan="3">IP</th>
					<th class="a_2">访问时间</th>
					<th class="a_2">区域</th>
					<th class="a_2">次数</th>
				</tr>
				<c:forEach items="${adTraffics.pageList}" var="adTraffic"
					varStatus="status">
					<tr class="h">
						<td colspan="3" class="red-text">${adTraffic.ip }</td>
						<td class="a_2"><fmt:formatDate
								value="${adTraffic.visitTime }" pattern="yyyy-MM-dd HH:mm:ss " /></td>
						<td class="a_2 blue-text">${adTraffic.area }</td>
						<td class="red-text">${adTraffic.visitNum }</td>
					</tr>
				</c:forEach>
			</table>


			<!-- 处理分页 -->
			<div class="t1000-vote-pageCon">
				<div class="t1000-vote-pager">

					<a title="" href="javascript:toPage(1)">首页</a>

					<c:forEach begin="1" end="${adTraffics.maxPage}" step="1"
						varStatus="s" var="i">
						<c:choose>
							<c:when test="${i==adTraffics.currentNum }">
								<a class="on" href="javascript:toPage(${s.index})">${i}</a>
							</c:when>
							<c:when test="${adTraffics.currentNum-2>i &&i==3}">
								<a href="">&hellip;</a>
							</c:when>
							<c:when
								test="${i!=adTraffics.currentNum &&i<3||i>adTraffics.currentNum-3&&i<adTraffics.currentNum+3||i>=adTraffics.maxPage-1}">
								<a href="javascript:toPage(${s.index})">${i}</a>
							</c:when>
							<c:when
								test="${adTraffics.currentNum+3==i&&i<adTraffics.maxPage-1}">
								<a href="" id="hellip">&hellip;</a>
							</c:when>
						</c:choose>
					</c:forEach>

					<a title="" href="javascript:toPage(${adTraffics.maxPage})">末页</a>

				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/backstage/js/league/right.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/backstage/js/league/league.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/backstage/js/common/commonRight.js"></script>

	<script type="text/javascript">
		//页面跳转
		function toPage(currentNum) {
			var beginDate = $("#beginDate").val();
			var endDate = $("#endDate").val();
			var newUrl = "${pageContext.request.contextPath }/LeagueAdTrafficTab/queryAdTrafficByKeywordPaged?adId="
					+ ${adId}
			+"&currentNum=" + currentNum + "&beginDate=" + beginDate
					+ "&endDate=" + endDate + "&isInput=" + isInput+"&urlParam="+$("#urlParam").val();
			location.href = newUrl;
		}
	</script>
</body>
</html>
