package com.wangku.controller.advertising;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangku.entity.LeaguePram;
import com.wangku.entity.LeagueSize;
import com.wangku.entity.LeagueSizeListModel;
import com.wangku.pojo.LeagueAdvListModel;
import com.wangku.service.LeaguePramService;
import com.wangku.service.LeagueSizeService;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;

/**
 * 
 * @author zsl 2015年7月29日下午4:19:36 类描述：尺寸controller
 */
@Controller
@RequestMapping("/LeagueSize/v1")
public class LeagueSizeController {

	private static final Log logger = LogFactory
			.getLog(LeagueSizeController.class);

	@Autowired
	private LeaguePramService leaguePramService;

	@Autowired
	private LeagueSizeService leagueSizeService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));// true:允许输入空值，false:不能为空值
	}

	/**
	 * 
	 * @author： zsl 2015年7月27日 下午2:49:24
	 * @方法名： toModifyCompany
	 * @方法描述：跳转到新增尺寸页面
	 * @param:sourceL:确定从哪里进入添加页面 0 ：左侧菜单 1：广告管理页面
	 * @返回值：ModelAndView
	 * 
	 */
	@RequestMapping(value = "/toAddLeagueSize/{sourceL}")
	public ModelAndView toAddLeagueSize(ModelAndView mav,
			HttpServletRequest request, @PathVariable String sourceL) {

		logger.debug("进入添加尺寸界面=====");
		List<LeaguePram> industryList = null;
		List<LeaguePram> advTypeList = null;
		try {
			advTypeList = leaguePramService
					.queryLeaguePramByPramType(VoteSeqEnum.LEAGUE_PARAM_TYPE.ADV_TYPE
							.getValue());
			industryList = leaguePramService
					.queryLeaguePramByPramType(VoteSeqEnum.LEAGUE_PARAM_TYPE.INDUSTRY_TYPE
							.getValue());
			mav.getModel().put("sourceL", sourceL);
			mav.getModel().put("industryList", industryList);
			mav.getModel().put("advTypeList", advTypeList);
			mav.setViewName("jsp/league/adv_manage/leagueSize_add");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("backstage/backPage/errors/error");
			return mav;
		}

	}

	/**
	 * 
	 * @author： zsl 2015年7月28日 下午2:24:29
	 * @方法名： addLeagueSizeBatch
	 * @方法描述：批量添加尺寸数据
	 * @param:
	 * @返回值：List<LeagueSize>
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/addLeagueSizeBatch")
	public List<LeagueSize> addLeagueSizeBatch(ModelAndView mav,
			HttpServletRequest request, @RequestParam String[] industryIds,
			@RequestParam String[] advTypeIds, @RequestParam String advSize) {
		logger.debug("批量添加尺寸数据==========");
		List<LeagueSize> aNo = null;
		try {
			aNo = leagueSizeService.addLeagueSizeBatch(industryIds, advTypeIds,
					advSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aNo;
	}
	/**
	 * 
	 * @author： zsl  2015年8月3日 下午2:15:41
	 * @方法名： queryLeagueSizeList
	 * @方法描述：尺寸列表查询
	 * @param:
	 * @返回值：ModelAndView
	 *
	 */
	@RequestMapping(value = "/queryLeagueSizeList")
	public ModelAndView queryLeagueSizeList(ModelAndView mav,
			HttpServletRequest request) {
		logger.debug("查询尺寸列表==========");
		List<LeaguePram> typeList = new ArrayList<LeaguePram>();
		
		List<LeaguePram> industryList = new ArrayList<LeaguePram>();
		
		List<LeagueSizeListModel> list = null;
		try {
			typeList = leaguePramService
					.queryLeaguePramByPramType(VoteSeqEnum.LEAGUE_PARAM_TYPE.ADV_TYPE
							.getValue());
			industryList = leaguePramService
					.queryLeaguePramByPramType(VoteSeqEnum.LEAGUE_PARAM_TYPE.INDUSTRY_TYPE
							.getValue());
			list = leagueSizeService.queryLeagueSizeList();
			mav.getModel().put("list", list);
			mav.getModel().put("pramList", industryList);
			mav.getModel().put("typeList", typeList);
			mav.setViewName("jsp/league/adv_manage/leagueSize_list");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("backstage/backPage/errors/error");
			return mav;
		}

	}
	
	
	/*#######################################################################*/
	
	@RequestMapping(value = "/advSizeList")
	public String queryAdvInfosByKeywordPaged(Model model,HttpServletRequest request){
		try {
			
			//收集页面参数
			String industryIdPage = request.getParameter("industryId");
			String typeIdPage = request.getParameter("typeId");
			
			//处理页面参数
			Long industryId = null;
			Long typeId = null;
			if(!StringUtils.isEmpty(industryIdPage) && !industryIdPage.equals("0") ){
				industryId = Long.parseLong(request.getParameter("industryId"));
			}
			if(!StringUtils.isEmpty(typeIdPage) && !typeIdPage.equals("0") ){
				typeId = Long.parseLong(request.getParameter("typeId"));
			}
			
			Integer currentNum = 1;
			String currentNumStr = request.getParameter("currentNum");
			if (!StringUtils.isEmpty(currentNumStr)) {
				currentNum = Integer.parseInt(currentNumStr);
			}
			
			Page<LeagueSize> advSizePage = leagueSizeService.queryAdvSizeListByKeywordPaged(industryId,typeId, currentNum);
			List<LeaguePram> industrys = leaguePramService.queryLeaguePram(0);//查找所有的行业
			List<LeaguePram> types = leaguePramService.queryLeaguePram(1);//查找所有的广告类型
			
			model.addAttribute("advSizePage", advSizePage);
			model.addAttribute("industrys", industrys);
			model.addAttribute("types", types);
			//参数传回
			model.addAttribute("industryIdPage", industryIdPage);
			model.addAttribute("typeIdPage", typeIdPage);
			
			return "jsp/league/adv_manage/leagueSize_list2";
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}
	
	/**
	 * 
	 * @author： zsl  2015年8月17日 下午5:39:43
	 * @方法名： removeAdvSize
	 * @方法描述：删除尺寸数据
	 * @param:count :此尺寸下广告位有无广告标识0 无      1有
	 * @返回值：String
	 *
	 */
	@RequestMapping(value = "/removeAdvSize")
	public String removeAdvSize(
			HttpServletRequest request,Long id
			,Integer count,HttpServletRequest req,
			Integer currentNum,
			Integer industryId,
			Integer typeId) {
		logger.debug("删除尺寸列表数据==========");
		
		try{
			leagueSizeService.removeAdvSize(id,count);
			return "redirect:/LeagueSize/v1/advSizeList?currentNum="
					+currentNum+"&industryId="+industryId+"&typeId="+typeId;
		}catch(Exception e){
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}
}
