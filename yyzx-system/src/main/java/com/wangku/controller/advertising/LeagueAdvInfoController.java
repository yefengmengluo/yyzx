package com.wangku.controller.advertising;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangku.entity.AdvLeagueSize;
import com.wangku.entity.AdvTypeAndSize;
import com.wangku.entity.LeagueAdvInfo;
import com.wangku.entity.LeaguePram;
import com.wangku.entity.LeagueSize;
import com.wangku.mapper.LeagueSizeMapper;
import com.wangku.pojo.LeagueAdvListModel;
import com.wangku.service.LeagueAdvInfoService;
import com.wangku.service.LeaguePramService;
import com.wangku.service.LeagueSizeService;
import com.wangku.util.Page;

@Controller
@RequestMapping("/league")
public class LeagueAdvInfoController {

	@InitBinder
	public void allowEmptyDateBinding(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	private static final Logger logger = LoggerFactory
			.getLogger(LeaguePramController.class);
	@Autowired
	private LeagueAdvInfoService leagueAdvInfoService;
	@Autowired
	private LeaguePramService pramService;
	@Autowired
	private LeagueSizeService sizeService;
	@Autowired
	LeagueSizeMapper sizeMapper;

	/**
	 * 
	 * @author： 徐国辉 2015年8月5日 下午2:45:57
	 * @方法名： queryAdvInfosByKeywordPaged
	 * @方法描述：列表管理，
	 * @param:
	 * @返回值：ModelAndView
	 * 
	 */
	@RequestMapping(value = "/advInfoList")
	public String queryAdvInfosByKeywordPaged(Model model,
			HttpServletRequest request) {
		try {

			// 收集页面参数
			String industryIdPage = request.getParameter("industryId");
			String typeIdPage = request.getParameter("typeId");

			// 处理页面参数
			Long industryId = null;
			Long typeId = null;
			if (!StringUtils.isEmpty(industryIdPage)
					&& !industryIdPage.equals("0")) {
				industryId = Long.parseLong(request.getParameter("industryId"));
			}
			if (!StringUtils.isEmpty(typeIdPage) && !typeIdPage.equals("0")) {
				typeId = Long.parseLong(request.getParameter("typeId"));
			}

			Integer currentNum = 1;
			String currentNumStr = request.getParameter("currentNum");
			if (!StringUtils.isEmpty(currentNumStr)) {
				currentNum = Integer.parseInt(currentNumStr);
			}

			Page<LeagueAdvListModel> advInfosPage = leagueAdvInfoService
					.queryAdvInfosByKeywordPaged(industryId, typeId, currentNum);
			List<LeaguePram> industrys = pramService.queryLeaguePram(0);// 查找所有的行业
			List<LeaguePram> types = pramService.queryLeaguePram(1);// 查找所有的广告类型

			model.addAttribute("advInfosPage", advInfosPage);
			model.addAttribute("industrys", industrys);
			model.addAttribute("types", types);
			// 参数传回
			model.addAttribute("industryIdPage", industryIdPage);
			model.addAttribute("typeIdPage", typeIdPage);

			return "jsp/league/list_manage/list_manager_image";
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * 
	 * @author： zsl 2015年8月5日 下午2:45:57
	 * @方法名： toAdvEdit
	 * @方法描述：跳转到图片广告修改页面
	 * @param:
	 * @返回值：ModelAndView
	 * 
	 */
	@RequestMapping(value = "/toAdvEdit")
	public ModelAndView toAdvEdit(ModelAndView mav,
			Long advInfoId,Integer currentNum,Long industryId,Long typeId) {
		try {
			logger.debug("跳转到图片广告修改页面===========");
			LeagueAdvInfo info = leagueAdvInfoService
					.queryAdvInfoById(advInfoId);
			mav.getModel().put("info", info);
			mav.getModel().put("currentNum", currentNum);
			mav.getModel().put("industryId", industryId);
			mav.getModel().put("typeId", typeId);
			mav.setViewName("jsp/league/list_manage/pic_adv_edit");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("backstage/backPage/errors/error");
			return mav;
		}
	}

	/**
	 * 
	 * @author： zsl 2015年8月5日 下午6:09:17
	 * @方法名： toAdvEdit
	 * @方法描述：修改图片广告
	 * @param:
	 * @返回值：String
	 * 
	 */
	@RequestMapping(value = "/modifyAdvPic")
	public String modifyAdvPic(ModelAndView mav,
			LeagueAdvInfo info,Integer currentNum,Long industryId,Long typeId,
			HttpServletRequest req) {
		try {
			logger.debug("修改图片广告数据=========");
			leagueAdvInfoService.modifyAdvPic(info, req);
			return "redirect:/league/advInfoList?currentNum="
					+currentNum+"&industryId="+industryId+"&typeId="+typeId;
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * 
	 * @author： zsl 2015年8月7日 上午9:33:34
	 * @方法名： removeAdvPic
	 * @方法描述：图片广告批量删除
	 * @param: idStr ：id拼成的字符串，中间由逗号隔开
	 * @返回值：String
	 * 
	 */
	// @RequestMapping(value = "/removeAdvPic")
	// public @ResponseBody String removeAdvPic(ModelAndView mav,String idStr,
	// HttpServletRequest req){
	// try {
	// logger.debug("批量删除=========={}",idStr);
	// String[] idAry = idStr.split(",");
	// List<Long> idList = new ArrayList<Long>();
	// for (String str : Arrays.asList(idAry)) {
	// idList.add(Long.valueOf(str));
	// }
	// leagueAdvInfoService.removeAdvPic(idList,req);
	// return "success";
	// } catch (Exception e) {
	// e.printStackTrace();
	// return "fail";
	// }
	// }

	@RequestMapping(value = "/removeAdvPic")
	public String removeAdvPic(String idStr, Integer currentNum,
			HttpServletRequest req) {
		try {
			logger.debug("批量删除=========={}", idStr);
			String[] idAry = idStr.split(",");
			List<Long> idList = new ArrayList<Long>();
			for (String str : Arrays.asList(idAry)) {
				idList.add(Long.valueOf(str));
			}
			leagueAdvInfoService.removeAdvPic(idList, req);
			return "redirect:/league/advInfoList?currentNum=" + currentNum;
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}

	

	/**
	 * @author:谢虹英 2015年7月27日 上午11:36:36
	 * @方法名:queryAll
	 * @方法描述:图片添加页 初始化 行业、类型和尺寸
	 * @param:@param model paramType:参数的类型 0：代表行业 1:代表广告类型
	 * @param:@return
	 * @返回值:String
	 */
	@RequestMapping(value = "/Initialze/{paramType}")
	public String Initialze(Model model, @PathVariable int paramType) {
		try {
			logger.debug("查询全部{}", paramType == 0 ? "行业数据==========="
					: "广告类型数据============");
			List<LeaguePram> leagueParams = pramService
					.queryLeaguePram(paramType);
			List<Long> ids = null;
			List<AdvTypeAndSize> sizeList = sizeService
					.queryAdvTypeAndSizeByIndustryIds(ids);
			model.addAttribute("paramsList", leagueParams);
			model.addAttribute("sizeList", sizeList);
			model.addAttribute("paramType", paramType);
			return "jsp/league/list_manage/pic_adv_add";
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * 
	 * @author： 谢虹英 2015年8月6日 下午2:16:06
	 * @方法名： querySizeByIndustry
	 * @方法描述：ajax查询某行业所拥有的尺寸
	 * @param:
	 * @返回值：String
	 * 
	 */
	@RequestMapping("/querySizeUIndustry")
	@ResponseBody
	public List<AdvTypeAndSize> querySizeByIndustry(ModelMap map,
			HttpServletResponse response, String ids) {
		List<Long> idList = new ArrayList<Long>();
		List<AdvTypeAndSize> sizeList = new ArrayList<AdvTypeAndSize>();
		try {
			if (!(StringUtils.isEmpty(ids))) {
				String[] split = ids.split(",");
				for (int i = 0, len = split.length; i < len; i++) {
					idList.add(Long.parseLong(split[i]));
				}
			}
			sizeList = sizeService.queryAdvTypeAndSizeByIndustryIds(idList);
			for (AdvTypeAndSize s : sizeList) {
				for (AdvLeagueSize m : s.getLeagueSizeList()) {
					System.out.println(m);
				}
			}
			/*
			 * JSONArray object = JSONArray.fromObject(sizeList);
			 * System.out.println("JSONObject:"+object.toString());
			 * response.getWriter().print(object);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sizeList;
	}

	/**
	 * 
	 * @author： 谢虹英 2015年8月12日 上午10:34:13
	 * @方法名： addAdvPicList
	 * @方法描述：添加图片广告
	 * @param:图片广告对象中的部分属性
	 * @返回值：String
	 * 
	 */
	@RequestMapping(value = "/addAdvPic")
	@ResponseBody
	public String addAdvPicList(HttpServletRequest request,
			LeagueAdvInfo ladvInfo, @RequestParam String industryIds,
			@RequestParam String sizeCode) {
		try {

			List<LeagueAdvInfo> advInfos = new ArrayList<LeagueAdvInfo>();
			// 处理提交的行业id
			String[] ids = industryIds.split(",");
			if (!(ladvInfo == null) && ids.length > 0) {
				for (String id : ids) {
					LeagueAdvInfo advInfo = new LeagueAdvInfo();
					advInfo.setAdvName(ladvInfo.getAdvName());
					advInfo.setTargetUrl(ladvInfo.getTargetUrl());
					advInfo.setStartTime(ladvInfo.getStartTime());
					advInfo.setEndTime(ladvInfo.getEndTime());
					LeagueSize size = sizeMapper
							.queryLeagueSizeByIndustryIdAndSizeCode(
									Long.parseLong(id), sizeCode);
					advInfo.setSizeId(size.getId());
					String advCode = id + "_" + sizeCode;
					advInfo.setAdvCode(advCode);

					long startime = advInfo.getStartTime().getTime();
					long curtime = System.currentTimeMillis();
					long endTime = advInfo.getEndTime().getTime()+24*60*60*1000;
					if (startime <= curtime && curtime < endTime) {
						advInfo.setOnFlag(2);
					} else if (curtime < startime) {
						advInfo.setOnFlag(1);
					}
					advInfos.add(advInfo);
				}
				String res = leagueAdvInfoService.addAdvInfoPic(request, advInfos);
				return res;
			} else
				return "nok";
		} catch (Exception e) {
			e.printStackTrace();
			return "nok";
		}
	}

	/**
	 * 
	 * @author： zsl 2015年8月17日 下午5:41:03
	 * @方法名： queryAdvCountBySizeId
	 * @方法描述：根据尺寸ID查询此尺寸下的广告位的个数
	 * @param:
	 * @返回值：int
	 * 
	 */
	@RequestMapping(value = "/queryAdvCountBySizeId")
	public @ResponseBody
	int queryAdvCountBySizeId(ModelAndView mav, HttpServletRequest request,
			Long sizeId) {
		logger.debug("根据尺寸ID查询此尺寸下的广告位的个数==========");

		int count=0;
		try {
			count = leagueAdvInfoService.queryAdvCountBySizeId(sizeId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

}
