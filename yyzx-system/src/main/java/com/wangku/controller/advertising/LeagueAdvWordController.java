package com.wangku.controller.advertising;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangku.entity.LeagueAdvWord;
import com.wangku.entity.LeaguePram;
import com.wangku.service.LeagueAdvWordService;
import com.wangku.service.LeaguePramService;
import com.wangku.util.Page;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/league")
public class LeagueAdvWordController {

	@InitBinder
	public void allowEmptyDateBinding(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@Autowired
	private LeaguePramService pramService;
	@Autowired
	private LeagueAdvWordService leagueAdvWordService;

	/**
	 * 徐国辉 2015年8月5日 下午2:18:15 方法名称:queryAdvInfosByKeywordPaged
	 * 方法描述:条件分页查询文字广告记录
	 * 
	 * @param:
	 * @返回值:String I can do anything in my world with program !!!
	 */
	@RequestMapping(value = "/advWordList")
	public String queryAdvInfosByKeywordPaged(Model model, HttpServletRequest request) {
		try {

			// 收集页面参数
			String industryIdPage = request.getParameter("industryId");
			String titleKeyWod = request.getParameter("titleKeyWod");
			String titleKeyWodPage = null;
			// 处理页面参数
			Long industryId = null;
			if (!StringUtils.isEmpty(industryIdPage) && !industryIdPage.equals("0")) {
				industryId = Long.parseLong(request.getParameter("industryId"));
			}
			if (StringUtils.isEmpty(titleKeyWod)) {
				titleKeyWod = "%%";
			} else {
				titleKeyWodPage = titleKeyWod.trim();
				titleKeyWod = "%" + titleKeyWod + "%";
			}

			Integer currentNum = 1;
			String currentNumStr = request.getParameter("currentNum");
			if (!StringUtils.isEmpty(currentNumStr)) {
				currentNum = Integer.parseInt(currentNumStr);
			}

			Page<LeagueAdvWord> advWordsPage = leagueAdvWordService.queryAdvWordsByKeywordPaged(industryId, titleKeyWod,
					currentNum);
			List<LeaguePram> industrys = pramService.queryLeaguePram(0);// 查找所有的行业

			model.addAttribute("advWordsPage", advWordsPage);
			model.addAttribute("industrys", industrys);
			// 参数传回
			model.addAttribute("industryIdPage", industryIdPage);
			model.addAttribute("titleKeyWodPage", titleKeyWodPage);

			return "jsp/league/list_manage/list_manager_word";
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * 徐国辉 2015年8月3日 下午3:42:47 方法名称:toAddWordAdvInfo 方法描述:跳转到添加文字广告页面
	 * 
	 * @param:
	 * @返回值:String I can do anything in my world with program !!!
	 */
	@RequestMapping(value = "/toAddWordAdvInfo")
	public String toAddWordAdvInfo(Model model) {
		try {
			// 查询全部的行业信息
			List<LeaguePram> industrys = pramService.queryLeaguePram(0);// 查找所有的行业
			model.addAttribute("industrys", industrys);
			return "jsp/league/list_manage/add_wordAdv";
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * 徐国辉 2015年8月3日 下午3:42:47 方法名称:addWordAdvInfo 方法描述:添加文字广告
	 * 
	 * @param:
	 * @返回值:String I can do anything in my world with program !!!
	 */
	@ResponseBody
	@RequestMapping(value = "/addWordAdvInfo")
	public int addWordAdvInfo(HttpServletRequest request, @RequestParam String title, @RequestParam Integer order,
			@RequestParam String targetUrl, @RequestParam Date startTime, @RequestParam Date endTime,
			@RequestParam Integer redFlag, @RequestParam String industryIds) {

		try {
			// 处理发布状态
//			long startTimeLong = startTime.getTime();
//			long sysTime = System.currentTimeMillis();
//			int onFlag = 0;
//			if (sysTime < startTimeLong) {
//				onFlag = 1;
//			} else {
//				onFlag = 2;
//			}

			String[] industryIdsArr = industryIds.split(",");
			for (String industryId : industryIdsArr) {
				LeagueAdvWord advWord = new LeagueAdvWord();
				advWord.setIndustryId(Long.parseLong(industryId));
				advWord.setTitle(title);
				advWord.setTargetUrl(targetUrl);
				advWord.setStartTime(startTime);
				advWord.setEndTime(endTime);
//				advWord.setOnFlag(onFlag);
				advWord.setRedFlag(redFlag);
				advWord.setOrderNum(order);
				leagueAdvWordService.addAdvWord(advWord);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 徐国辉 2015年8月5日 上午8:19:36 方法名称:toModifyWordAdvInfo 方法描述:跳转文字广告修改页
	 * 
	 * @param:
	 * @返回值:String I can do anything in my world with program !!!
	 */
	@RequestMapping(value = "/toModifyAdvWord/{id}")
	public String toModifyWordAdvInfo(Model model, @PathVariable Long id) {
		try {
			LeagueAdvWord advWord = leagueAdvWordService.queryWordAdvById(id);
			LeaguePram industry = pramService.queryById(advWord.getIndustryId());
			model.addAttribute("industry", industry);
			model.addAttribute("advWord", advWord);
			return "jsp/league/list_manage/modify_wordAdv";
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * 徐国辉 2015年8月5日 下午4:52:30 方法名称:modifyWordAdvInfo 方法描述:文字广告修改
	 * 
	 * @param:页面提交参数
	 * @返回值:String I can do anything in my world with program !!!
	 */
	@RequestMapping(value = "/modifyWordAdv")
	public String modifyWordAdv(LeagueAdvWord advWord) {
		try {
			LeagueAdvWord oldAdvWord = leagueAdvWordService.queryWordAdvById(advWord.getId());

//			long startTimeLong = advWord.getStartTime().getTime();
//			long systime = System.currentTimeMillis();
//			if (systime < startTimeLong) {
//				advWord.setOnFlag(1);
//			} else {
//				advWord.setOnFlag(2);
//			}
			advWord.setCreateTime(oldAdvWord.getCreateTime());
			leagueAdvWordService.modifyWordAdv(advWord);
			return "redirect:/league/advWordList";
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}

	@RequestMapping(value = "/deleteWordAdv/{id}/{currentNum}/{industryIdPage}")
	public String deleteWordAdv(@PathVariable Long id, @PathVariable Integer currentNum,
			@PathVariable String industryIdPage) {
		try {
			leagueAdvWordService.removeWordAdvById(id);
			return "redirect:/league/advWordList?currentNum=" + currentNum + "&industryId=" + industryIdPage;
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}

	// 文字广告排序
	@RequestMapping(value = "/modifyWordAdvOrder", method = RequestMethod.GET)
	public @ResponseBody String modifyWordAdvOrder(@RequestParam Long id, @RequestParam Integer order) {
		leagueAdvWordService.modifyWordAdvOrder(id, order);
		JSONObject obj = new JSONObject();
		obj.put("success", "排序完成");
		return obj.toString();

	}

	@ResponseBody
	@RequestMapping(value = "/wordAdvs/show/{industryId}/{dataNum}")
	public List<LeagueAdvWord> queryWordAdvShow(@PathVariable Long industryId, @PathVariable Integer dataNum) {
		List<LeagueAdvWord> wordAdvOnFlag = leagueAdvWordService.queryWordAdvOnFlag(industryId, dataNum);
		return wordAdvOnFlag;
	}

}
