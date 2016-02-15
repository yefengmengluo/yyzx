package com.wangku.controller.advertising;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangku.entity.LeaguePram;
import com.wangku.service.LeaguePramService;


@Controller
@RequestMapping("/LeaguePram")
public class LeaguePramController {
	
	@InitBinder
	public void allowEmptyDateBinding(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
	
	private static final Logger logger = LoggerFactory
			.getLogger(LeaguePramController.class);
	
	@Autowired
	private LeaguePramService leaguePramService;
	
	/**
	 * @author:李焕焕 2015年7月27日 上午11:36:36
	 * @方法名:queryAll
	 * @方法描述:TODO(查询所有行业)
	 * @param:@param model      paramType:参数的类型        0：代表行业   1:代表广告类型
	 * @param:@return
	 * @返回值:String
	 */
	@RequestMapping(value = "/queryLeaguePram/{paramType}/{sourceL}")
	public String queryLeaguePram(Model model,@PathVariable int paramType,@PathVariable Integer sourceL){
		try {
			logger.debug("查询全部{}",paramType==0?"行业数据===========":"广告类型数据============");
			List<LeaguePram> leagueParams = leaguePramService.queryLeaguePram(paramType);
			model.addAttribute("leagueParams", leagueParams);
			model.addAttribute("paramType",paramType);
			model.addAttribute("sourceL",sourceL);
			return "jsp/league/adv_manage/param_Add";
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}
	
	/**
	 * 
	 * @author： zsl  2015年7月30日 上午10:02:28
	 * @方法名： addLeaguePram
	 * @方法描述：      添加参数       
	 * @param: paramType  ：添加参数的类型         0 ：行业          1广告类型
	 * @返回值：String
	 *
	 */
	@RequestMapping("/addLeaguePram/{paramType}")	  
	public @ResponseBody String addLeaguePram(@RequestParam String paramName,
			@PathVariable Integer paramType, HttpServletRequest request){
		try {
			int count = leaguePramService.queryByParamName(paramType,paramName);
			System.out.println(count);
			if(count==0){
				LeaguePram	leaguePram = new LeaguePram();
				leaguePram.setParamName(paramName);
				leaguePram.setParamType(paramType);
				leaguePramService.addLeaguePram(leaguePram);
				return "0";
			}else{
				logger.debug("{}=={}的==已经存在", paramType==0?"行业名称为"+paramName:"广告类型名称为"+paramName);
				return "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}
	}
	
	/**
	 * 
	 * @author： zsl  2015年8月3日 上午10:04:39
	 * @方法名： modifyLeaguePram
	 * @方法描述：修改参数名称
	 * @param:paramType：参数类型          0行业           1广告类型
	 * @返回值：String
	 *
	 */
	@RequestMapping("/modifyLeaguePram/{paramType}")
	public @ResponseBody String modifyLeaguePram(
			Long id,
			String paramName, 
			@PathVariable int paramType,HttpServletRequest request) {
		logger.debug("修改参数名称===============");
		try {
			int count = leaguePramService.queryByParamNameAndId(paramType,paramName,id);
			if(count==0){
				LeaguePram	leaguePram = leaguePramService.queryById(id);
				if(leaguePram.getParamName().equals(paramName)){
					return "3";//没有做任何改动
				}
				leaguePram.setParamName(paramName);
				leaguePramService.modifyLeaguePram(leaguePram);
				return "0";
			}else{
				System.out.println("该参数已存在");
				return "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}
	}
	
	/**
	 * 
	 * @author： zsl  2015年9月7日 上午11:41:01
	 * @方法名： querySizeCountByParamId
	 * @方法描述：根据参数ID查询相应参数现有无尺寸信息
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/querySizeCountByParamId")
	public @ResponseBody String querySizeCountByParamId(
			Long id,
			int paramType,HttpServletRequest request) {
		logger.debug("查询指定参数下有无尺寸信息===============");
		try {
			int count = leaguePramService.querySizeCountByParamId(paramType,id);
			if(count==0){
				if(paramType == 0){//删除行业
					int numWord = leaguePramService.queryWordCountByParamId(id);
					if(numWord != 0){
						return "word";//文字广告有
					}
				}
				return "no";//没有
			}else{
				System.out.println("有尺寸信息");
				return "pic";//图片广告有
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/**
	 * 
	 * @author： zsl  2015年9月7日 上午11:46:39
	 * @方法名： delLeaguePram
	 * @方法描述：删除指定参数
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/delLeaguePram")
	public String delLeaguePram(
			Long id,
			Integer paramType,
			Integer sourceL) {
		logger.debug("删除指定参数===============");
		try {
			leaguePramService.delLeaguePram(id);
			return "redirect:/LeaguePram/queryLeaguePram/"+paramType+"/"+sourceL;
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}
	
}
