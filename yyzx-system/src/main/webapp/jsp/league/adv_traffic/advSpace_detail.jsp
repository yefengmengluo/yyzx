<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta   http-equiv= "Pragma"   content= "no-cache" />
<meta   http-equiv= "Cache-Control"   content= "no-cache" />
<meta   http-equiv= "Expires"   content= "0" /> 
<title>流量管理详情页</title>
<link href="${pageContext.request.contextPath }/backstage/css/league/addcorporation.css" type="text/css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath }/backstage/css/league/detail.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="t1000-votB-R-in clearfix">
    <div class="advertising-siteManagement-tit clearfix">
    <a href="${pageContext.request.contextPath }/LeagueAdTrafficTab/queryTrafficCount?currentNum=${currentNum}" title="后退">
    <img  style="width:30px;display:inline" src="${pageContext.request.contextPath }/backstage/images/league/goback.png"/>
    </a>
    <h2 style="display:inline" class="t1000-tit">图片广告</h2> 
    </div>
    <div class="detail-content">
    
    	<div class="detail-title clearfix">
    	<form id="select_form" action="${pageContext.request.contextPath }/LeagueAdTrafficTab/queryTrafficCountBySizeCode" method="post">
        	<div id="listSelect" class="detail-title-left floatL">
                <select id="industry" name="industryId">
                    <option selected="selected" value="0">全部</option>
					<c:forEach items="${industrys}" var="industry">
						<option value="${industry.id}">${industry.paramName}</option>
					</c:forEach>
                </select>
            </div>
            <input type="hidden" id="advSpace" name="advSpace" value="${advSpace}" />
			<input type="hidden" id="sizeCode" name="sizeCode" value="${sizeCode}" />
			<input type="hidden" id="advType" name="advType" value="${advType}" />
			<input type="hidden" id="currentNum" name="currentNum" value="${currentNum}" />
            <div class="detail-title-center floatL">
            	会员账户
                <input id="keyWord" type="text" class="detail-search-text" value="${keyWord}" name="keyWord"/>
                <input type="submit" value="搜索" class="detail-search-btn"/>
            </div>
            
         </form>
            <div class="detail-title-right floatR">
            	<p>总流量IP数据：<span>${totalTrafficCount}</span></p>
            </div>
        </div>
        
       
        <table class="listManage" cellpadding="0" cellspacing="0">
			 <tr>
             	<th class="lm_1">投放行业</th>
             	<th class="lm_2">广告名称</th>
             	<th class="lm_3">开始时间</th>
             	<th class="lm_3">结束时间</th>
             	<!-- <th class="lm_5">投放状态</th> -->
             	<th class="lm_3">会员账户</th>
             	<th class="lm_3">访问流量</th>
             	<th class="lm_4">操作</th>
             	<th>流量总计</th>
             </tr>
             <c:forEach items="${listAdvCount}" var="i_list">
				<c:forEach items="${i_list.trafficModel}" var="adv_list"
					varStatus="status">
					<c:if test="${status.index == 0}">
						<tr>
							<td rowspan="${fn:length(i_list.trafficModel)}" class="lm_1">${i_list.industryName}</td>
							<td class="lm_2">${adv_list.advName}</td>
							<td class="lm_3"><fmt:formatDate value="${adv_list.startTime}"
									pattern="yyyy-MM-dd" type="date" /></td>
							<td class="lm_3"><fmt:formatDate value="${adv_list.endTime}"
									pattern="yyyy-MM-dd" type="date" /></td>
							<!-- <td class="lm_5" style="color: red">投放中</td> -->
							<td class="lm_3">${adv_list.userName}</td>
							<td class="lm_3">${adv_list.advOneTrafficCount}</td>
							
							
							<td class="lm_4">
							<a href="javascript:toAdvDetail('${adv_list.id}')" class="detail">详情</a>
							<a href="javascript:toDel('${adv_list.id}');" class="delete">清空流量</a></td>
							<td rowspan="${fn:length(i_list.trafficModel)}" class="red-text">${i_list.advAllTrafficCount}</td>
						</tr>
					</c:if>
					<c:if test="${status.index != 0}">
						<tr>
							<td class="lm_2">${adv_list.advName}</td>
							<td class="lm_3"><fmt:formatDate value="${adv_list.startTime}"
									pattern="yyyy-MM-dd" type="date" /></td>
							<td class="lm_3"><fmt:formatDate value="${adv_list.endTime}"
									pattern="yyyy-MM-dd" type="date" /></td>
							<!-- <td class="lm_5" style="color: #a5a5a5">过期</td> -->
							<td class="lm_3">${adv_list.userName}</td>
							<td class="lm_3">${adv_list.advOneTrafficCount}</td>
							
							
							<td class="lm_4">
							<a href="javascript:toAdvDetail('${adv_list.id}')" class="detail">详情</a>
							<a href="javascript:toDel('${adv_list.id}');" class="delete">清空流量</a></td>
						</tr>
					</c:if>

				</c:forEach>
			</c:forEach>
        </table>
        
        <div class="flow-trend">
        	<div class="flow-trend-title">
            	<h2>流量趋势</h2>
            </div>
            <div id="chartSelect" class="flow-trend-content clearfix">
                <div class="detail-title-left floatL">
                    <select id="industryId">
                        <option selected="selected" value="0">全部</option>
						<c:forEach items="${industrys}" var="industry">
							<option value="${industry.id}">${industry.paramName}</option>
						</c:forEach>
                    </select>
                </div>
                <div class="flow-trend-data floatL">
                    <select id="dateSelect">
                        <option selected="selected" value="0">今天</option>
						<option value="3">昨天</option>
						<option value="1">近一周(单位：天)</option>
						<option value="2">近一个月(单位：天)</option>
                    </select>
                </div>
                <div class="cls"></div>
                <div id="main" class="flow-trend-pic" style="border : 1px solid #dfdfdf">
                	
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/dateFormat.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/backstage/js/common/chart/echarts.js"></script>
<script type="text/javascript">
	//广告流量统计
	function toAdvDetail(adId){
		var sizeCode = $("#sizeCode").val();
		var advSpace = $("#advSpace").val();
		var advType = $("#advType").val();
		var industryId = $("#industry").val();
		var keyWord = $("#keyWord").val();
		var urlParam ="sizeCode=" +sizeCode +",advSpace="+advSpace+",advType="+advType+",industryId="+industryId+",keyWord="+keyWord;
		var newUrl = "${pageContext.request.contextPath }/LeagueAdTrafficTab/queryAdTrafficByKeywordPaged?urlParam="+urlParam+"&adId=";
		location.href = newUrl + adId;
	}
	//清空对应的访问数据
	function toDel(adId){
		if(confirm("清空后将无法恢复,确定清空流量数据么？")){
			$
			.ajax({
				type : "post",
				async: false, //同步执行
				url : "${pageContext.request.contextPath }/LeagueAdTrafficTab/delTraffics",
				data : {
					adId : adId//广告位ID
				},
				success : function(data) {
					if(data == "success"){
						$("#select_form").submit();
					}else if(data == "fail"){
						alert("删除失败！");
					}
				},
				error : function(){
					
					alert("删除失败");
				}
			});
		}
	}

	$(function() {
		chart();
		$("#chartSelect select").bind("change",function(){
			chart();
		});
		
		//列表查询，行业默认选中值
		var pVar = '${industryId}';
		$("#industry option[value='"+pVar+"']").attr("selected",true);
	});
	
	

	function chart() {
		var divWidth = $("#main").width() * 0.93;
		var val  = $("#dateSelect").val();
		var rotateX =0;
		if(val == 2){//今天或者一周
			rotateX = 45;
		}
		var advSpace = $("#advSpace").val();

		// 路径配置
		require
				.config({
					paths : {
						echarts : '${pageContext.request.contextPath }/backstage/js/common'
					}
				});
		// 使用
		require([ 'echarts', // 使用柱状图就加载bar模块，按需加载
		'echarts/chart/line'], function(ec) {
			// 基于准备好的dom，初始化echarts图表
			var myChart = ec.init(document.getElementById('main'));

			//图表显示提示信息
			myChart.showLoading({
				text : "图表数据正在努力加载...",
				textStyle : {
					fontSize : 18
				},
				//effect:'sapn'
				effect:'ring'
				//effect:'whirling'
				//effect:'bar'
				//effect:'dynamicLine'
				//effect:'bubble'
								
			});

			var option = {
				title : {
					text : advSpace,
					subtext: '流量',
					x : 55,
					y :15,
					textStyle : {

						fontSize : 16
						//color : 'red'
					}
				},
				tooltip : {
					trigger : 'axis'
				},
				/* legend : {
					data : [ advSpace ],
					textStyle : {
						fontSize : 16,
						color : 'red'
					}
				}, */
				toolbox : {
					show : true,
					feature : {
						//mark : {show: true},
						//dataView : {show: true, readOnly: false},
						//magicType : {show: true, type: ['line']},
						//restore : {show: true},
						saveAsImage : {
							show : true,
							title : '保存图片',
							type : 'jpeg',
							lang : ['点击保存'],
							name : "流量统计" + new Date().Format("yyyyMMddHHmmss")
						}
					},
					itemSize:22,//工具箱大小
					x:divWidth,
					y:15
				},
				calculable : false,
				xAxis : [ {
					type : 'category',
					boundaryGap : false,
					data : [],
					axisLabel : {
						rotate : rotateX,
						textStyle : {
							fontSize : 14
						}
					}

				} ],
				yAxis : [ {
					type : 'value',
					axisLabel : {
						//formatter: '{value} °C'
						textStyle : {
							fontSize : 14
						}
					}
				} ],
				grid : {
					x : 100,
					y : 75,
					x2 : 100,
					y2 : 100,
				},
				series : [ {
					name : advSpace,
					type : 'line',
					stack : '总量',
					data : [],
					markPoint : {
						data : [ {
							type : 'max',
							name : '最大值'
						}, {
							type : 'min',
							name : '最小值'
						} ]
					}
				} ]
			};
			
				var sizeCode = $("#sizeCode").val();
				var dateValue = $("#dateSelect").val();
				var industryId = $("#industryId").val();
				var advType = $("#advType").val();
				//ajax查询走势图数据
				$
				.ajax({
					type : "post",
					async: false, //同步执行
					url : "${pageContext.request.contextPath }/LeagueAdTrafficTab/queryTrafficCountEcharts",
					dataType: "json", //返回数据形式为json
					data : {
						sizeCode : sizeCode,//广告位编码
						queryType : dateValue,//时间段类型
						industryId :industryId,//行业ID
						advType : advType // 广告位类型      0 ：图片广告     1 ：文字广告
					},
					success : function(jsonObj) {
						//将返回的category和series对象赋值给options对象内的category和series
						//因为xAxis是一个数组 这里需要是xAxis[i]的形式
						option.xAxis[0].data = jsonObj.dateList;
						option.series[0].data = jsonObj.numList;		
						myChart.hideLoading();
						myChart.setOption(option);
					},
					error : function(){
						myChart.hideLoading();
						alert("数据加载失败");
					}
				});
			
		});
	}
	
</script>
</body>
</html>
