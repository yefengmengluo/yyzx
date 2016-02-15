package com.wangku.controller.vote;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wangku.entity.Company;
import com.wangku.entity.User;
import com.wangku.entity.VoteTable;
import com.wangku.service.VoteCompanyService;
import com.wangku.service.VoteTableService;
import com.wangku.util.Page;

/**
 * 
 * @author zsl 2015-5-17 17:00:00 类描述：投票会员Controller
 * 
 */
@Controller
@RequestMapping("/VoteCompany/v1")
public class VoteCompanyController {

	private static final Log logger = LogFactory
			.getLog(VoteCompanyController.class);
	@Autowired
	private VoteCompanyService comService;

	@Autowired
	private VoteTableService voteTableService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));// true:允许输入空值，false:不能为空值
	}

	/**
	 * 
	 * @author： zsl 2015-6-18 上午9:27:49
	 * @方法名： getCompanyList
	 * @方法描述：分页查询投票会员信息列表
	 * @param:
	 * @返回值：ModelAndView
	 * 
	 */
	@RequestMapping(value = "/selectCompanyList",produces = "text/html;charset=UTF-8")
	public ModelAndView queryByPage(ModelAndView mav, HttpServletRequest request) {
		User user = (User) request.getSession(true).getAttribute("user");
//		User user = new User();
//		user.setUserId(Long.parseLong("3"));
//		user.setAccount("zsl");
//		user.setUserPower(1);
		logger.debug("分页查询投票会员列表");
		String searchStr = "";
		try {
			request.setCharacterEncoding("utf-8");
			String keyWord = request.getParameter("keyWord");
			if (StringUtils.isEmpty(keyWord)||"请输入关键字".equals(keyWord.trim())) {
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

			Page<Company> voteCompanyPage = comService.queryByPage(keyWord,
					currentNum,user);
			mav.getModel().put("page", voteCompanyPage);
			mav.getModel().put("keyWord", searchStr);
			mav.setViewName("backstage/backPage/corporation/corporation_list");
			return mav;
		} catch (Exception e) {
			mav.setViewName("backstage/backPage/errors/error");
			return mav;
		}

	}

	/**
	 * 
	 * @author： zsl 2015-6-19 下午5:54:10
	 * @方法名： queryVoteTable
	 * @方法描述：查询主题信息列表
	 * @param:
	 * @返回值：List<VoteTable>
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/queryVoteTable_company", method = RequestMethod.GET)
	public List<VoteTable> queryVoteTable(ModelAndView mav,
			HttpServletRequest request) {
		User user = (User) request.getSession(true).getAttribute("user");
		logger.debug("查询投票主题列表，为信息推荐做准备");
		List<VoteTable> voteTableList = voteTableService.quaryByUserId(user.getUserId(),user.getUserPower());
		return voteTableList;
	}

	/**
	 * 
	 * @author： zsl 2015-6-18 下午2:09:15
	 * @方法名： deleteCompany
	 * @方法描述：删除投票会员数据
	 * @param: idStr：由id组成的字符串，中间由“，”隔开,如1,2,3
	 * @返回值：String
	 * 
	 */
	@RequestMapping(value = "/removeCompany")
	public @ResponseBody
	String removeCompany(@RequestParam String idStr, HttpServletRequest request) {
		logger.debug("删除投票会员数据");
		try {
			String[] idAry = idStr.split(",");
			List<Long> idList = new ArrayList<Long>();
			for (String str : Arrays.asList(idAry)) {
				idList.add(Long.valueOf(str));
			}
			comService.removeCompany(idList,request);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}

	/**
	 * 
	 * @author： zsl 2015-6-19 上午11:29:17
	 * @方法名： modifyCompanyStatus
	 * @方法描述：信息推荐
	 * @param: idStr：id组成的字符串，如1,2,3,4 status：投票状态 voteId:投票主题ID
	 * @返回值：String
	 * 
	 */
	@RequestMapping(value = "/modifyCompanyStatus")
	public @ResponseBody
	String modifyCompanyStatus(@RequestParam String idStr,
			@RequestParam Long voteId, @RequestParam int status,
			HttpServletRequest request) {
		logger.debug("修改投票会员数据状态");
		try {
			String[] idAry = idStr.split(",");
			List<Long> idList = new ArrayList<Long>();
			for (String str : Arrays.asList(idAry)) {
				idList.add(Long.valueOf(str));
			}
			comService.modifyCompanyStatus(voteId, idList, status);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}

	/**
	 * 
	 * @author： zsl 2015-6-23 上午10:52:39
	 * @方法名： toModifyCompany
	 * @方法描述：跳转到修改页面
	 * @param:
	 * @返回值：ModelAndView
	 * 
	 */
	@RequestMapping(value = "/toModifyCompany")
	public ModelAndView toModifyCompany(ModelAndView mav,
			@RequestParam Long copId, HttpServletRequest request) {

		try {
			Company company = comService.queryById(copId);
			if(!StringUtils.isEmpty(company.getLogo())){
				String str = company.getLogo();
				company.setLogo(str.substring(str.lastIndexOf("/")+1));
			}
			if(!StringUtils.isEmpty(company.getWeixinPic())){
				String str = company.getWeixinPic();
				company.setWeixinPic(str.substring(str.lastIndexOf("/")+1));		
			}
			if(!StringUtils.isEmpty(company.getWeiboPic())){
				String str = company.getWeiboPic();
				company.setWeiboPic(str.substring(str.lastIndexOf("/")+1));
			}
			if(!StringUtils.isEmpty(company.getErweimaPic())){
				String str = company.getErweimaPic();
				company.setErweimaPic(str.substring(str.lastIndexOf("/")+1));
			}
			mav.getModel().put("company", company);
			mav.setViewName("backstage/backPage/corporation/corporation_edit");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	/**
	 * 
	 * @author： zsl  2015-6-24 下午1:14:02
	 * @方法名： modifyCompany
	 * @方法描述：修改会员信息
	 * @param: 会员对象
	 * @返回值：String
	 *
	 */
	@RequestMapping(value = "/modifyCompany")
	public String modifyCompany(ModelAndView mav,
			Company company, HttpServletRequest request) {
		try {
			comService.modifyCompany(company,request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/VoteCompany/v1/selectCompanyList";
	}

	/**
	 * 
	 * @author： zsl 2015-6-23 上午10:51:49
	 * @方法名： toAddCompany
	 * @方法描述：跳转到添加页面
	 * @param:
	 * @返回值：ModelAndView
	 * 
	 */
	@RequestMapping(value = "/toAddCompany")
	public ModelAndView toAddCompany(ModelAndView mav,
			@RequestParam long voteId,
			@RequestParam String source,
			HttpServletRequest request) {
		mav.getModel().put("voteId", voteId);
		mav.getModel().put("source", source);
		mav.setViewName("backstage/backPage/corporation/corporation_add");
		return mav;
	}
	/**
	 * 
	 * @author： zsl  2015-6-24 下午6:04:24
	 * @方法名： saveCompany
	 * @方法描述：保存会员信息
	 * @param:source 数据对象来源 
	 * 0：从会员管理添加，此时状态为关闭,主题为空    1：从主题管理之品牌管理添加，此时状态为开启
	 * @返回值：String
	 *
	 */
	@RequestMapping(value = "/saveCompany", method = RequestMethod.POST)
	public String saveCompany(HttpServletRequest request, Company company,
			@RequestParam String source) throws IOException {
		User user = (User) request.getSession(true).getAttribute("user");
		
		try {
			if("0".equals(source)){
				company.setVoteId(null);
				company.setUserId(user.getUserId());
				comService.saveCompany(company,request,0);
				return "redirect:/VoteCompany/v1/selectCompanyList";
			}
			
			if("1".equals(source)){
				company.setUserId(user.getUserId());
				comService.saveCompany(company,request,1);
				return "redirect:/VoteItem/v1/selectVoteItemList?voteId="+company.getVoteId();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	
}
