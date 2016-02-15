package com.wangku.controller.vote;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangku.entity.User;
import com.wangku.entity.VoteTable;
import com.wangku.service.VoteTableService;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/vote")
public class VoteTableController {

	@InitBinder
	public void allowEmptyDateBinding(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	

	@Autowired
	private VoteTableService voteTableService;

	/**
	 * @author： 徐国辉 2015-6-18 上午8:55:12
	 * @方法名： queryAll
	 * @方法描述：关键字+分页查询 投票主题
	 * @param:
	 * @返回值：String 投票主题列表逻辑视图名
	 */
	@RequestMapping(value = "/voteList")
	public String queryAll(Model model, HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			User user = (User) request.getSession().getAttribute("user");
			Integer power = user.getUserPower();
			String keyWord = request.getParameter("keyWord");
			String pageKeyWord = null;// 用于页面刷新保存用户输入的关键字
			if (StringUtils.isEmpty(keyWord)) {
				keyWord = "%%";
			} else {
				pageKeyWord = keyWord.trim();
				keyWord = "%" + keyWord.trim() + "%";
			}
			Integer currentNum = 1;
			String currentNumStr = request.getParameter("currentNum");
			if (!StringUtils.isEmpty(currentNumStr)) {
				currentNum = Integer.parseInt(currentNumStr);
			}

			Page<VoteTable> voteTablesPage = null;
			
			if(power==VoteSeqEnum.UPOWER.ALLPOWER.getValue()||power==VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()){
				voteTablesPage = voteTableService.queryAllPage(keyWord, currentNum);
			}else if(power==VoteSeqEnum.UPOWER.VOTE_POWER.getValue()){
				voteTablesPage = voteTableService.querySomePage(keyWord, currentNum, user.getUserId());
			}

			model.addAttribute("voteTablesPage", voteTablesPage);
			model.addAttribute("keyWord", pageKeyWord);
			response.setContentType("text/html;charset=UTF-8");
			return "backstage/backPage/vote/vote_list";
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * @author： 徐国辉 2015-6-18 上午8:55:12
	 * @方法名： modifyVoteTable
	 * @方法描述：添加投票主题
	 * @param:
	 * @返回值：String 投票主题列表逻辑视图名
	 */
	@RequestMapping(value = "/voteAdd", method = RequestMethod.POST)
	public String addVoteTable(VoteTable voteTable, HttpServletRequest request) {
		try {
			User user = (User) request.getSession().getAttribute("user");
			System.out.println(request.getParameter("beginTime"));
			voteTable.setUserId(user.getUserId());
			voteTableService.addVoteTable(voteTable);
			return "redirect:/vote/voteList";
		} catch (Exception e) {
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * @author： 徐国辉 2015-6-18 上午8:55:12
	 * @方法名： toVodifyVoteTable
	 * @方法描述：跳转到投票主题修改页面
	 * @param:
	 * @返回值：String 修改投票主题页面逻辑视图名
	 */
	@RequestMapping(value = "/toVoteModify", method = RequestMethod.GET)
	public String toVodifyVoteTable(Model model, HttpServletRequest request) {
		try {
			String id = request.getParameter("id");
			VoteTable voteTable = voteTableService.queryVoteTable(Long
					.parseLong(id));
			model.addAttribute("voteTable", voteTable);
			return "backstage/backPage/vote/vote_edit";
		} catch (Exception e) {
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * @author： 徐国辉 2015-6-18 上午8:55:12
	 * @方法名： modifyVoteTable
	 * @方法描述：修改指定的投票主题
	 * @param:
	 * @返回值：String 投票主题列表逻辑视图名
	 */
	@RequestMapping(value = "/voteModify", method = RequestMethod.POST)
	public String modifyVoteTable(Model model, HttpServletRequest request,
			VoteTable voteTable) {
		System.out.println(request.getParameter("beginTime"));
		try {
			voteTableService.modifyVoteTable(voteTable);
			return "redirect:/vote/voteList";
		} catch (Exception e) {
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-23 上午9:14:13
	 * @方法名： delete
	 * @方法描述：删除指定的指定的投票主题
	 * @param:id
	 * @返回值：String 重定向到列表页的逻辑视图名
	 */
	@RequestMapping(value = "/voteDelete", method = RequestMethod.GET)
	public String delete(@RequestParam Long id, HttpServletRequest request) {
		try {
			String currentNum = request.getParameter("currentNum");
			String keyWord = request.getParameter("keyWord");
			voteTableService.removeVoteTable(id);
			return "redirect:/vote/voteList?currentNum=" + currentNum
					+ "&keyWord=" + keyWord;
		} catch (Exception e) {
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * @author： 徐国辉 2015-6-23 上午9:28:33
	 * @方法名： subjectJSON
	 * @方法描述：获取全部投票主题的JSON，用于实现添加广告时的主题下拉列表
	 * @param:
	 * @返回值：String 全部投票主题记录的JSON字符串
	 */
	@RequestMapping(value = "/votesJSON", method = RequestMethod.GET)
	public @ResponseBody String allSubjectJSON(HttpServletRequest request) {
		try {
			User user = (User) request.getSession().getAttribute("user");
			List<VoteTable> voteTables = voteTableService.quaryAll(user);
			JSONObject obj = new JSONObject();
			obj.put("voteTables", voteTables);
			return obj.toString();
		} catch (Exception e) {
			return "backstage/backPage/errors/error";
		}
	}
}
