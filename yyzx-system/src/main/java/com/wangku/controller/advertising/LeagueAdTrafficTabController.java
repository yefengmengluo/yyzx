package com.wangku.controller.advertising;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangku.entity.AdTrafficModel;
import com.wangku.entity.AdvSpaceTrafficCountModel;
import com.wangku.entity.ChartData;
import com.wangku.entity.LeagueAdTrafficTab;
import com.wangku.entity.LeaguePram;
import com.wangku.service.LeagueAdTrafficTabService;
import com.wangku.service.LeaguePramService;
import com.wangku.util.Page;

/**
 * 
 * @author zsl
 * 2015年9月15日下午3:35:37
 * 类描述  : 广告联盟广告流量表controller
 */
@Controller
@RequestMapping("/LeagueAdTrafficTab")
public class LeagueAdTrafficTabController {

	private static final Log logger = LogFactory
			.getLog(LeagueAdTrafficTabController.class);


	@Autowired
	private LeagueAdTrafficTabService adTraffic;

	@Autowired
	private LeaguePramService pramService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));// true:允许输入空值，false:不能为空值
	}

	/**
	 * @author： 何利娟  2015年9月18日 上午10:45:04
	 * @方法名：分页查询流量记录
	 * @方法描述：
	 * @param:
	 * @返回值：ModelAndView
	 */
	@RequestMapping(value = "/queryAdTrafficByKeywordPaged")
	public ModelAndView queryAdTrafficByKeywordPaged(ModelAndView mav,Date beginDate,Date endDate,Long adId,
			Integer currentNum,HttpServletRequest request,boolean isInput,String urlParam) {
		logger.debug("分页查询流量记录==========");
		try {
			if(currentNum==null){
				currentNum=1;
			}
			if(beginDate==null){
				//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
				mav.getModel().put("beginDate", new Date());
				Calendar currentDate = new GregorianCalendar();   
				currentDate.set(Calendar.HOUR_OF_DAY, 0);  
				currentDate.set(Calendar.MINUTE, 0);  
				currentDate.set(Calendar.SECOND, 0);
				beginDate=(Date) currentDate.getTime();
			}else{//其他时间开始时间取一天的开始
				mav.getModel().put("beginDate", beginDate);
				Calendar beginCal=Calendar.getInstance();
				beginCal.setTime(beginDate);
				beginCal.set(Calendar.HOUR_OF_DAY, 0);  
				beginCal.set(Calendar.MINUTE, 0);  
				beginCal.set(Calendar.SECOND, 0);
				beginDate=(Date) beginCal.getTime();
			}
			if(endDate==null){
				endDate=new Date();
				//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
				mav.getModel().put("endDate", endDate);
			}else{
				//其他时间取一天的结束
				mav.getModel().put("endDate", endDate);
				Calendar endCal=Calendar.getInstance();
				endCal.setTime(endDate);
				endCal.set(Calendar.HOUR_OF_DAY, 23);  
				endCal.set(Calendar.MINUTE, 59);  
				endCal.set(Calendar.SECOND, 59);
				endDate=(Date) endCal.getTime();
			}

			System.out.println("beginDate===================="+beginDate);
			System.out.println("endDate===================="+endDate);
			Page<LeagueAdTrafficTab> adTraffics = adTraffic.queryAdTrafficByKeywordPaged(adId, beginDate, endDate, currentNum);
			List<LeagueAdTrafficTab> adTrafficsPie = adTraffic.queryAdTrafficArea(adId, beginDate, endDate);
			JSONArray jsonObj = JSONArray.fromObject(adTrafficsPie);

			mav.getModel().put("adTrafficsPie", jsonObj.toString());
			mav.getModel().put("adTraffics", adTraffics);
			mav.getModel().put("adId", adId);
			mav.getModel().put("isInput", isInput);
			mav.getModel().put("urlParam", urlParam);
			System.out.println("urlParam===================="+urlParam);

			mav.setViewName("jsp/league/adv_traffic/adTraffics_list");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("backstage/backPage/errors/error");
			return mav;
		}

	}
	/**
	 * 
	 * @author： 何利娟  2015年9月18日 上午10:47:01
	 * @方法名： queryAdTrafficArea
	 * @方法描述：区域流量统计
	 * @param:
	 * @返回值：ModelAndView
	 *
	 */
	@RequestMapping(value = "/queryAdTrafficArea")
	public ModelAndView queryAdTrafficArea(ModelAndView mav,Long adId,Date beginDate, Date endDate,Integer currentNum,
			HttpServletRequest request) {
		logger.debug("统计各个区域流量分布==========");
		try {
			List<LeagueAdTrafficTab> adTrafficsPie = adTraffic.queryAdTrafficArea(adId, beginDate, endDate);
			mav.getModel().put("adTrafficsPie", adTrafficsPie);
			mav.setViewName("jsp/league/adv_traffic/adTraffics_list");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("backstage/backPage/errors/error");
			return mav;
		}
	}


	/**
	 * 
	 * @author： zsl  2015年9月16日 上午10:09:46
	 * @方法名： queryTrafficCount
	 * @方法描述：根据广告位统计
	 * @param:
	 * @返回值：ModelAndView
	 *
	 */
	@RequestMapping(value = "/queryTrafficCount")
	public ModelAndView queryTrafficCount(ModelAndView mav,
			HttpServletRequest request) {
		logger.debug("根据广告位统计=========="); 
		try {
			Integer currentNum = 1;
			String currentNumStr = request.getParameter("currentNum");
			if (!StringUtils.isEmpty(currentNumStr)) {
				currentNum = Integer.parseInt(currentNumStr);
			}

			Page<AdTrafficModel> advSpacePage = adTraffic.queryAdvSpaceListByPaged(currentNum);
			//获取所有广告位的总流量
			int totalFlow = adTraffic.getAllAdvSpaceTotalFlow();

			mav.getModel().put("totalFlow", totalFlow);
			mav.getModel().put("advSpacePage", advSpacePage);
			mav.setViewName("jsp/league/adv_traffic/advSpace_traffic_count");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("backstage/backPage/errors/error");
			return mav;
		}

	}


	/**
	 * 
	 * @author： zsl  2015年9月21日 上午11:56:49
	 * @方法名： queryTrafficCountBySizeCode
	 * @方法描述：指定广告位下各个行业各个广告流量统计列表
	 * @param:
	 * @返回值：ModelAndView
	 *
	 */
//	@RequestMapping(value = "/queryTrafficCountBySizeCode")
//	public ModelAndView queryTrafficCountBySizeCode(
//			ModelAndView mav,
//			HttpServletRequest request,
//			String advSpace,
//			String sizeCode,
//			Long industryId,
//			String keyWord,
//			Integer advType,
//			Integer currentNum) {
//		logger.debug("根据指定广告位统计==========");
//		try {
//			List<AdvSpaceTrafficCountModel> list = adTraffic.queryTrafficCountBySizeCode(sizeCode,industryId,keyWord,advType);
//			List<LeaguePram> industrys = pramService.queryLeaguePram(0);// 查找所有的行业
//			//查询指定广告位下的所有广告的总流量
//			int totalTrafficCount = adTraffic.queryAllTrafficCountBySizeCode(sizeCode,advType);
//			mav.getModel().put("listAdvCount", list);
//			mav.getModel().put("industrys", industrys);
//			mav.getModel().put("advSpace", advSpace);
//			mav.getModel().put("sizeCode", sizeCode);
//			mav.getModel().put("totalTrafficCount", totalTrafficCount);
//			mav.getModel().put("industryId", industryId);
//			mav.getModel().put("keyWord", keyWord);
//			mav.getModel().put("advType", advType);
//			mav.getModel().put("currentNum", currentNum);
//			mav.setViewName("jsp/league/adv_traffic/advSpace_detail_2");
//			return mav;
//		} catch (Exception e) {
//			e.printStackTrace();
//			mav.setViewName("backstage/backPage/errors/error");
//			return mav;
//		}
//
//	}
	@RequestMapping(value = "/queryTrafficCountBySizeCode")
	public ModelAndView queryTrafficCountBySizeCode(
			ModelAndView mav,
			HttpServletRequest request,
			String advSpace,
			String sizeCode,
			Long industryId,
			Long selectDate,
			String keyWord,
			Integer advType,
			Integer currentNum) {
		logger.debug("根据指定广告位统计==========");
		try {
			System.out.println("&&&&&&&&&&&&&&&&&&&&&==========="+selectDate);
			List<AdvSpaceTrafficCountModel> list = adTraffic.queryTrafficCountBySizeCode(sizeCode,industryId,keyWord,advType,selectDate);
			List<LeaguePram> industrys = pramService.queryLeaguePram(0);// 查找所有的行业
			//查询指定广告位下的所有广告的总流量
			int totalTrafficCount = adTraffic.queryAllTrafficCountBySizeCode(sizeCode,advType,selectDate);
			mav.getModel().put("listAdvCount", list);
			mav.getModel().put("industrys", industrys);
			mav.getModel().put("advSpace", advSpace);
			mav.getModel().put("sizeCode", sizeCode);
			mav.getModel().put("totalTrafficCount", totalTrafficCount);
			mav.getModel().put("industryId", industryId);
			mav.getModel().put("selectDate", selectDate);
			mav.getModel().put("keyWord", keyWord);
			mav.getModel().put("advType", advType);
			mav.getModel().put("currentNum", currentNum);
			mav.setViewName("jsp/league/adv_traffic/advSpace_detail_2");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("backstage/backPage/errors/error");
			return mav;
		}

	}


	/**
	 * 
	 * @author： zsl  2015年9月21日 上午11:41:19
	 * @方法名： queryTrafficCountEcharts
	 * @方法描述：ajax调用查询图表信息
	 * @param:
	 * @返回值：ChartData
	 *		queryType ：0：按今天查询 1 ：按近一周查询 2：按近一个月查询  3 :昨天
	 * 					advType   :  0 :图片广告     1  ：文字广告
	 */
	@RequestMapping(value = "/queryTrafficCountEcharts")
	@ResponseBody
	public ChartData queryTrafficCountEcharts(ModelAndView mav,
			HttpServletRequest request,
			String sizeCode,
			String queryType,
			Long industryId,
			Integer advType) {
		logger.debug("ajax调用查询图表信息==========");
		try {
			ChartData chartData = adTraffic.queryChart(sizeCode, queryType,industryId,advType);
			return chartData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	/**
	 * 
	 * @author： zsl  2015年9月21日 上午11:41:19
	 * @方法名： queryTrafficCountEcharts
	 * @方法描述：ajax调用查询图表信息(全部行业)
	 * @param:
	 * @返回值：ChartData
	 *					queryType ：0：按今天查询 1 ：按近一周查询 2：按近一个月查询  3 :昨天
	 * 					advType   :  0 :图片广告     1  ：文字广告
	 */
	@RequestMapping(value = "/queryTrafficCountEcharts_2")
	@ResponseBody
	public List<ChartData> queryTrafficCountEcharts(ModelAndView mav,
			HttpServletRequest request,
			String sizeCode,
			String queryType,
			Integer advType) {
		logger.debug("ajax调用查询图表信息(全部行业)==========");
		try {
			List<ChartData> list = new ArrayList<ChartData>();
			List<LeaguePram> industrys = pramService.queryLeaguePram(0);// 查找所有的行业
			if(CollectionUtils.isEmpty(industrys)){
				return null;
			}
			for(LeaguePram industry :industrys){
				ChartData chartData = adTraffic.queryChart(sizeCode, queryType,industry.getId(),advType);
				chartData.setIndustryId(industry.getId());
				chartData.setIndustryName(industry.getParamName());
				list.add(chartData);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 清空指定广告的访问流量数据
	 * @author： zsl  2015年9月24日 下午4:51:50
	 * @方法名： queryTrafficCountEcharts
	 * @方法描述：
	 * @param:
	 * @返回值：ChartData
	 *
	 */
	@RequestMapping(value = "/delTraffics")
	public @ResponseBody String delTraffics(
			Long adId) {
		logger.debug("ajax删除流量信息信息=========="+adId);
		try {
			adTraffic.delTraffics(adId);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}

	}
}
