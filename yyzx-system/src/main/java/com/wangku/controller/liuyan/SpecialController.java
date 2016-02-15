/**
 * 
 */
package com.wangku.controller.liuyan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 谢虹英
 * 2015年9月14日下午3:29:19
 * 类描述：跳转专题页面
 */
@Controller
public class SpecialController {
	/**
	 * 
	 * @author： 谢虹英  2015年9月14日 下午3:40:17
	 * @方法名：  tgwmspecial
	 * @方法描述：缩短专题跳转路径
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/tgwm.html")
	public String tgwmSpecial(){
		return "jsp/special/tgwm/index";
	}
	/**
	 * 
	 * @author： 谢虹英  2015年9月14日 下午3:40:17
	 * @方法名：  tgliuspecial
	 * @方法描述：缩短专题跳转路径
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/tgliu.html")
	public String tgliuSpecial(){
		return "jsp/special/tgwm/index";
	}
	/**
	 * 
	 * @author： 谢虹英  2015年9月14日 下午3:40:17
	 * @方法名：  tggaospecial
	 * @方法描述：缩短专题跳转路径
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/tggao.html")
	public String tggaoSpecial(){
		return "jsp/special/tggao/index";
	}
	/**
	 * 
	 * @author： 谢虹英  2015年9月14日 下午3:40:17
	 * @方法名： UEspecial-推广专题
	 * @方法描述：缩短专题跳转路径
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/tuiguang.html")
	public String UESpecial(){
		//return "frontliuyan/UEspecial/index";
		return "jsp/special/UEspecial/index";
	}
	/**
	 * 
	 * @author： 谢虹英  2015年9月14日 下午3:40:17
	 * @方法名：国庆中秋-双节促销专题
	 * @方法描述：缩短专题跳转路径
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/d_festival.html")
	public String twoFestivalSpecial(){
		return "jsp/special/festivalspecial-guoqing_zhongqiu/index";
	}
	
	/**
	 * 
	 * @author：zhp  2015年11月25日 下午3:36:21
	 * @方法名：微信推广专题
	 * @方法描述：缩短专题跳转路径
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/wxtg.html")
	public String weixinSpecial(){
		return "jsp/special/weixinspecial/index";
	}
	
}
