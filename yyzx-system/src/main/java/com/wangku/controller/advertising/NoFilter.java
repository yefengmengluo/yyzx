/**
 * 
 */
package com.wangku.controller.advertising;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wangku.entity.LeagueAdTrafficTab;
import com.wangku.entity.LeagueAdvWord;
import com.wangku.entity.LeagueDataModel;
import com.wangku.service.LeagueAdTrafficTabService;
import com.wangku.service.LeagueAdvInfoService;
import com.wangku.service.LeagueAdvWordService;
import com.wangku.util.IPService;

import net.sf.json.JSONObject;

/**
 * @author 谢虹英
 * 2015年8月21日上午11:59:04
 * 类描述：
 */
@Controller
@RequestMapping
public class NoFilter {
	@Autowired
	private LeagueAdvInfoService leagueAdvInfoService;
	@Autowired
	private LeagueAdvWordService leagueAdvWordService;
	@Autowired
	private LeagueAdTrafficTabService leagueAdTrafficTabService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(LeaguePramController.class);
	/**
	 * 
	 * @author： zsl 2015年8月7日 上午10:05:07
	 * @方法名： queryLeagueAdvList
	 * @方法描述：用于查询广告数据展示在网站广告位中
	 * @param: advCode:广告位标识 advType：广告位类型，0 图片广告 1 文字广告 dataNum:广告条数
	 * @返回值：String
	 * 
	 */
	@RequestMapping(value = "/queryLeagueAdvList")
	public String queryLeagueAdvList(String pageWidth,
			String advCode, String advType, Integer dataNum, Long industryId,String scriptParentDiv,
		String adClass,HttpServletRequest req, HttpServletResponse resp) {
		try {
			String callback = req.getParameter("callback");
			//LeaguePageShowModel showData = new LeaguePageShowModel();// 用于前端展示
			List<LeagueDataModel> dataList = null;// 数据集合
JSONObject jsonObj = new JSONObject();
			if ("0".equals(advType)) {
				// 图片广告
				dataList = leagueAdvInfoService.queryLeagueAdvList(advCode,
						dataNum);
				//showData.setPageWidth(pageWidth);
				//showData.setDataList(dataList);
				jsonObj.put("pageWidth", pageWidth);
				jsonObj.put("dataList", dataList);
				jsonObj.put("scriptParentDiv", scriptParentDiv);
				jsonObj.put("adClass", adClass);
				jsonObj.put("advType", advType);
				
			} else if ("1".equals(advType)) {
				// 文字广告
				if(dataNum == null){
					dataNum = 5;
				}
				List<LeagueAdvWord> wordAdvOnFlag = leagueAdvWordService
						.queryWordAdvOnFlag(industryId,dataNum);
				jsonObj.put("pageWidth", pageWidth);
				jsonObj.put("wordList", wordAdvOnFlag);
				jsonObj.put("scriptParentDiv", scriptParentDiv);
				jsonObj.put("adClass", adClass);
				jsonObj.put("advType", advType);
			} else {
				logger.debug("此===={}===广告类型不存在", advType);
			}
			resp.setContentType("text/html");
			resp.setCharacterEncoding("utf-8");
		    PrintWriter out = resp.getWriter();
		    System.out.println("==="+jsonObj);
			out.print(callback + "(" + jsonObj + ")");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * @author： 何利娟  2015年10月10日 上午9:57:35
	 * @方法名： doTrafficRecord
	 * @方法描述：添加流量记录
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping(value = "/doTrafficRecord")
	public String doTrafficRecord(long adId,String adType, long siteId,	String plwMember,HttpServletRequest req, HttpServletResponse resp) {
		String callback = req.getParameter("callback");
		
		LeagueAdTrafficTab leagueAdTrafficTab=new LeagueAdTrafficTab();
		leagueAdTrafficTab.setAdId(adId);
		leagueAdTrafficTab.setSiteId(siteId);
		leagueAdTrafficTab.setPlwMember(plwMember);
		leagueAdTrafficTab.setAdType(adType);
		//获取IP area
		String ip=IPService.getIpAddr(req);
		//String ip="211.162.68.131";
		//110.75.115.75
		String area="";
		if(ip!=null&&(!"".equals(ip))){
			//leagueAdTrafficTab.setIp(ip);
			area=IPService.getIPName(ip);
			if(area==null){
				area="";
			}
		}else{
			ip="";
		}
		leagueAdTrafficTab.setIp(ip);
		leagueAdTrafficTab.setArea(area);
		//添加数据库
		try {
			leagueAdTrafficTabService.addTrafficRecord(leagueAdTrafficTab);
			resp.setContentType("text/html");
			resp.setCharacterEncoding("utf-8");
		    PrintWriter out = resp.getWriter();
			out.print(callback + "({\"result\":\"success\"})");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
	/**
	 * 
	 * @author： 谢虹英  2015年10月13日 下午5:54:15
	 * @方法名： adLeaguesExample
	 * @方法描述：外部直接访问广告联盟范例   yyzx.99114.com/adLeaguesExample.html
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/adLeaguesExample.html")
public String adLeaguesExample(){
	return "jsp/league/adv_example/ad_example";
}
}
