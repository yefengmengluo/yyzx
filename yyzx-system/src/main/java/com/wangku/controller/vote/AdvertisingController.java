package com.wangku.controller.vote;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangku.entity.Advertising;
import com.wangku.entity.VoteTable;
import com.wangku.mapper.VoteTableMapper;
import com.wangku.service.AdvertisingService;

@Controller
@RequestMapping("/vote")
public class AdvertisingController {

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		dateFormat.setLenient(false);
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(
//				dateFormat, true));// true:允许输入空值，false:不能为空值
//	}
	@InitBinder
	public void allowEmptyDateBinding(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}


	@Autowired
	private AdvertisingService advertisingService;
	@Autowired
	private VoteTableMapper mapper;

	/**
	 * @author： 徐国辉 2015-6-19 下午4:50:40
	 * @方法名： queryAll
	 * @方法描述：根据投票主题id查询 广告位
	 * @param: vId 投票主题id
	 * @返回值：String 广告位列表逻辑视图名
	 */
	@RequestMapping(value = "/advertisingList", method = RequestMethod.GET)
	public String queryAll(Model model, @RequestParam Long vId, @RequestParam Integer channelName) {
		try {
			List<Advertising> advertisings = advertisingService.queryByVid(vId,channelName);
//			VoteTable voteTable = mapper.selectByPrimaryKey(vId);
			model.addAttribute("vId", vId);
			model.addAttribute("channelName", channelName);
			model.addAttribute("advertisings", advertisings);
			return "backstage/backPage/advertising/advertising_list";
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}
	
	
	/**
	 * @author： 徐国辉 2015-6-19 下午4:50:40
	 * @方法名： modifyAdvertising
	 * @方法描述：添加广告位页面跳转
	 * @param:
	 * @返回值：String 广告位列表逻辑视图名
	 */
	@RequestMapping(value = "/toAdvertisingAdd")
	public String toAddAdvertisingPage(HttpServletRequest request,@RequestParam Integer channelName,
			@RequestParam Long vId) {
		try {
			VoteTable voteTable = mapper.selectByPrimaryKey(vId);
			request.setAttribute("voteTable", voteTable);
			request.setAttribute("channelName", channelName);
			return "backstage/backPage/advertising/advertising_add";
		} catch (Exception e) {
			return "backstage/backPage/errors/error";
		}
	}
	

	/**
	 * @author： 徐国辉 2015-6-19 下午4:50:40
	 * @方法名： modifyAdvertising
	 * @方法描述：添加广告位
	 * @param:
	 * @返回值：String 广告位列表逻辑视图名
	 */
	@RequestMapping(value = "/advertisingAdd")
	public String addAdvertising(Advertising advertising,HttpServletRequest request) {
		try {
			String code = advertisingService.addAdvertising(advertising,request);//"false"-失败，"ok"-成功
			return "redirect:/vote/advertisingList?vId=" + advertising.getvId()+"&channelName="+advertising.getChannelName();
		} catch (Exception e) {
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * @author： 徐国辉 2015-6-19 下午4:50:40
	 * @方法名： toVodifyAdvertising
	 * @方法描述：跳转到广告位修改页面
	 * @param:
	 * @返回值：String 修改广告位页面逻辑视图名
	 */
	@RequestMapping(value = "/toAdvertisingModify", method = RequestMethod.GET)
	public String toVodifyAdvertising(Model model, HttpServletRequest request,@RequestParam Long id) {
		try {
			Advertising advertising = advertisingService.queryAdvertising(id);
			//查找当前广告所属主题
			VoteTable voteTable = mapper.selectByPrimaryKey(advertising.getvId());
			model.addAttribute("advertising", advertising);
			model.addAttribute("voteTable", voteTable);
			return "backstage/backPage/advertising/advertising_edit";
		} catch (Exception e) {
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * @author： 徐国辉 2015-6-19 下午4:50:40
	 * @方法名： modifyAdvertising
	 * @方法描述：修改指定的广告位
	 * @param:
	 * @返回值：String 广告位列表逻辑视图名
	 */
	@RequestMapping(value = "/advertisingModify", method = RequestMethod.POST)
	public String modifyAdvertising(Model model, HttpServletRequest request,
			Advertising advertising) {
		try {
			String code=advertisingService.modifyAdvertising(advertising,request);//"false"-失败，"ok"-成功
			return "redirect:/vote/advertisingList?vId=" + advertising.getvId()+"&channelName="+advertising.getChannelName();
		} catch (Exception e) {
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * @author： 徐国辉 2015-6-19 下午4:51:10
	 * @方法名： delete
	 * @方法描述：删除指定id的广告位
	 * @param:
	 * @返回值：String
	 */
	@RequestMapping(value = "/advertisingDelete", method = RequestMethod.GET)
	public String delete(@RequestParam Long id,@RequestParam Long vId,HttpServletRequest request,@RequestParam Integer channelName) {
		try {
			advertisingService.removeAdvertising(id);
			return "redirect:/vote/advertisingList?vId=" + vId+"&channelName="+channelName;
		} catch (Exception e) {
			return "backstage/backPage/errors/error";
		}
	}
	
	
	@RequestMapping(value = "/modifyAdvOrder", method = RequestMethod.GET)
	public @ResponseBody String modifyAdvOrder(@RequestParam Long id,@RequestParam Integer order) {
		try {
			Advertising advertising = advertisingService.queryAdvertisingOnly(id);
			advertisingService.modifyAdvOrder(advertising, order);
			JSONObject obj = new JSONObject();
			obj.put("advertising",advertising);
			obj.put("success", "排序完成");
			return obj.toString();
		} catch (Exception e) {
			return "backstage/backPage/errors/error";
		}
	}
}
