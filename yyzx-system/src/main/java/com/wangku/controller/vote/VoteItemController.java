package com.wangku.controller.vote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangku.entity.VoteItemTable;
import com.wangku.entity.VoteTable;
import com.wangku.service.VoteItemService;
import com.wangku.service.VoteTableService;
import com.wangku.util.Page;
/**
 * 
 * @author zsl
 * 2015-5-17 17:00:00
 * 类描述：投票选项Controller
 *
 */
@Controller
@RequestMapping("/VoteItem/v1")
public class VoteItemController {
	
	private static final Log logger = LogFactory
			.getLog(VoteCompanyController.class);
	
	@Autowired
	private VoteItemService itemService;
	@Autowired
	private VoteTableService tableService;
	/**
	 * 
	 * @author： zsl  2015-6-24 下午4:40:29
	 * @方法名： queryByPage
	 * @方法描述：根据主题id分页查询
	 * @param:voteId：主题id
	 * @返回值：ModelAndView
	 *
	 */
	@RequestMapping(value = "/selectVoteItemList",produces = "text/html;charset=UTF-8")
	public ModelAndView queryByPage(ModelAndView mav, 
			HttpServletRequest request) {
		logger.debug("分页查询投票会员列表");
		String searchStr = "";
		try {
			request.setCharacterEncoding("utf-8");
			String voteId = request.getParameter("voteId");
			String keyWord = request.getParameter("keyWord");
			if (StringUtils.isEmpty(keyWord)||"请输入关键字".equals(keyWord)) {
				searchStr="请输入关键字";
				keyWord = "%";
			} else {
				searchStr = keyWord;
				keyWord = "%" + keyWord.trim() + "%";
			}
			Integer currentNum = 1;
			String currentNumStr = request.getParameter("currentNum");
			if (!StringUtils.isEmpty(currentNumStr)) {
				currentNum = Integer.parseInt(currentNumStr);
			}

			Page<VoteItemTable> voteCompanyPage = itemService.queryByPage(keyWord,
					currentNum,Long.parseLong(voteId));
			VoteTable table = tableService.queryVoteTable(Long.parseLong(voteId));
			mav.getModel().put("page", voteCompanyPage);
			mav.getModel().put("keyWord", searchStr);
			mav.getModel().put("table", table);
			mav.getModel().put("voteId", voteId);
			mav.setViewName("backstage/backPage/vote/vote_item_list");
			return mav;
		} catch (Exception e) {
			mav.setViewName("backstage/backPage/errors/error");
			return mav;
		}

	}
	/**
	 * 
	 * @author： zsl  2015-6-25 上午9:54:53
	 * @方法名： removeCompany
	 * @方法描述：删除投票选项记录
	 * @param:idStr：id组成的字符串，如1,2,3,4
	 * @返回值：String
	 *
	 */
	@RequestMapping(value = "/removeItem")
	public @ResponseBody
	String removeItem(@RequestParam String idStr, HttpServletRequest request) {
		logger.debug("删除投票选项数据");
		try {
			String[] idAry = idStr.split(",");
			List<Long> idList = new ArrayList<Long>();
			for (String str : Arrays.asList(idAry)) {
				idList.add(Long.valueOf(str));
			}
			itemService.removeItem(idList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	/**
	 * 
	 * @author： zsl  2015-6-25 下午1:32:55
	 * @方法名： modifyCount
	 * @方法描述：修改票数
	 * @param: id：投票选项id
	 *         vdCount:票数
	 * @返回值：String
	 *
	 */
	@RequestMapping(value = "/modifyCount")
	public @ResponseBody
	String modifyCount(@RequestParam long id,
			             @RequestParam int vdCount,
			HttpServletRequest request) {
		logger.debug("修改票数");
		try {
			itemService.modifyCount(id,vdCount);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	/**
	 * 
	 * @author： zsl  2015-7-2 下午3:50:36
	 * @方法名： removeCompany
	 * @方法描述：对某个主题下的所有品牌排序
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping(value = "/sortItem")
	public @ResponseBody
	String removeCompany(@RequestParam long voteId, HttpServletRequest request) {
		logger.debug("排序");
		try {
			
			itemService.modifySort(voteId);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
}
