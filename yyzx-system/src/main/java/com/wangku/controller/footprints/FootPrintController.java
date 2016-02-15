package com.wangku.controller.footprints;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangku.entity.FootPrints;
import com.wangku.entity.Supply;
import com.wangku.service.FootprintsService;
import com.wangku.service.ProductSupplyService;
import com.wangku.util.IPService;
import com.wangku.was.images.dubbo.IRDubboImgImageService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/footPrint")
public class FootPrintController {
	@Autowired
    private IRDubboImgImageService rDubboImgImageService;
	@Autowired
	private FootprintsService footPrintsService;
	@Autowired
	private ProductSupplyService productSupplyService;
	/**
	 * 
	 * @author： 何利娟2015-7-13 上午8:43:38
	 * @方法名： addfootPrint
	 * @方法描述：足迹记录添加
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping(value = "/footPrintAdd")
	public @ResponseBody String addFootPrint(FootPrints footPrints,HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		try {
			String ip=IPService.getIpAddr(request);
			footPrints.setIp(ip);
			//添加
			footPrintsService.addFootprints(footPrints);
			obj.put("success", "ok");
			return "result("+obj.toString()+")";
		}
		catch (Exception e) {
			e.printStackTrace();
			obj.put("success", "error");
			return "result("+obj.toString()+")";
		}
	}

	/**
	 * 
	 * @author： 何利娟2015-7-15 下午3:34:06
	 * @方法名： getFootPrintList
	 * @方法描述：查询网站浏览记录
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping(value = "/getFootPrintList")
	public  String getFootPrintList(ModelMap map,long siteId,String host,HttpServletRequest request,int size,String memberName) {
		List<Long> list=null;
		//JSONObject obj = new JSONObject();
		try {
			FootPrints footPrints=new FootPrints();
			String ip=IPService.getIpAddr(request);
			footPrints.setIp(ip);
			footPrints.setSiteId(siteId);
			//查询
			list=footPrintsService.queryByKey(footPrints, 0, size);
			//跨库查询供应列表
			//跨库查询供应列表
			List<Supply> supplyList=null;
			if(list!=null&&list.size()>0){
				supplyList=productSupplyService.queryByPrimaryKey(list);
			
				for(Supply li:supplyList){
				List<String> url = rDubboImgImageService.parseImgUrl(li.getPic());
				li.setPic(url.get(0));
				}
			}
			//跨库查询供应列表
			map.put("list", supplyList);
			map.put("host",host);
			map.put("siteId",siteId);
			map.put("memberName",memberName);
			return "footprints/show_footPrints";
		}
		catch (Exception e) {
			e.printStackTrace();
			//obj.put("success", "error");
			//return "result("+obj.toString()+")";
			return "";
		}
	}
	
}
