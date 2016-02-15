package com.wangku.controller.payment.alipay;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipayNotify;
import com.alipay.util.AlipaySubmit;
import com.wangku.entity.Payment;
import com.wangku.service.PaymentService;
import com.wangku.util.VoteSeqEnum;

/**
 * 
 * @author xiehongying
 * 20152015年11月5日上午10:42:21
 * AliPayController.java
 */
@Controller
@RequestMapping("/alipay")
public class AliPayController {
	  @Autowired
	    private static final Logger log = LoggerFactory
				.getLogger(AliPayController.class);
	  
	  @Autowired
		private PaymentService paymentService;
	  /**
	     * 支付请求处理
	     *
	     * @param map
	     * @param orderIdStr
	     * @param orderAmtStr
	     * @param gateId
	     * @return
	     */
	    @RequestMapping("/pay")
	    public String pay(ModelMap map
	            ,  String WIDout_trade_no
	            , String WIDreceive_mobile
	            , String WIDsubject
	            , String WIDtotal_fee
	            , String WIDbody
	            , String WIDshow_url
	            ,HttpServletRequest request,HttpServletResponse response) {
	        Long paymentId;
	        BigDecimal orderAmt;

	        try {
	        	paymentId = Long.parseLong(WIDout_trade_no);
	            orderAmt = new BigDecimal(WIDtotal_fee);
	            //String WIDsubject1=new String(WIDsubject.getBytes("ISO-8859-1"),"UTF-8");
	           // System.out.println(WIDsubject1);
	            System.out.println("WIDout_trade_no订单号:  "+paymentId+"WIDsubject产品名称:  "+WIDsubject);
	            System.out.println("WIDtotal_fee金额:  "+orderAmt+"WIDbody产品介绍:  "+WIDbody);
	            System.out.println("WIDshow_url:  "+WIDshow_url);
	        } catch (Exception e) {
	            return "alipay/payError";
	        }

	     
	        map.addAttribute("paydomain", "http://yyzx.99114.com");
	        return "jsp/alipay/alipayapi";
	    }

	    @RequestMapping("/bussCallback")
	    public String callback( @RequestParam("out_trade_no")String out_trade_no,  @RequestParam("trade_no")String trade_no,  @RequestParam("trade_status")String trade_status,ModelMap modelMap, HttpServletRequest request) throws UnsupportedEncodingException {
	        // ................................................. 验证交易合法性 ...
	    	//获取支付宝POST过来反馈信息
	    	String payId =request.getParameter("payId");
	    	System.out.println("采购bussCallback"+payId);
	    	String refund_status =request.getParameter("refund_status");	
	    	Map<String,String> params = new HashMap<String,String>();
	    	Map requestParams = request.getParameterMap();
	    	for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
	    		String name = (String) iter.next();
	    		String[] values = (String[]) requestParams.get(name);
	    		String valueStr = "";
	    		for (int i = 0; i < values.length; i++) {
	    			valueStr = (i == values.length - 1) ? valueStr + values[i]
	    					: valueStr + values[i] + ",";
	    		}
	    		System.out.println("异步处理接收到的参数："+name+" : "+valueStr);
	    		System.out.println();
	    		params.put(name, valueStr);
	    	}

	    	// log.error("--------alipay callback-------"+ JSON.toJSONString(params)+"------------");
	        
	    	if(AlipayNotify.verify(params)){//通知验证成功
	    		if((trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS"))&&(StringUtils.isBlank(refund_status))){
	    			
	    		Long paymentId=new Long(out_trade_no);
	    		}
	    	      log.error("--------alipay callback success-------------------");
	    	     // return "alipay/callbacksuccess";
	    		return "success";
           }else{//验证失败
        	      log.error("-------- alipay callback fail-------------------");
	    		modelMap.addAttribute("msg", "fail");
	    	}
	    	return "jsp/alipay/callbackfail";
	    }

	    @RequestMapping("/pageCallback")
	    public String callback2(HttpServletRequest request) throws UnsupportedEncodingException {
	    	Map<String,String> params = new HashMap<String,String>();
	    	Map requestParams = request.getParameterMap();
	    	for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
	    		String name = (String) iter.next();
	    		String[] values = (String[]) requestParams.get(name);
	    		String valueStr = "";
	    		for (int i = 0; i < values.length; i++) {
	    			valueStr = (i == values.length - 1) ? valueStr + values[i]
	    					: valueStr + values[i] + ",";
	    		}
	    		//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
	    		// 调试的时候 下一行代码注释取消，线上的要加注释 可能是环境不一样 编码不一样的问题
	    		//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
	    		params.put(name, valueStr);
	    	}
	    	
	    	//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
	    	//商户订单号

	    	String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

	    	//支付宝交易号

	    	String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

	    	//交易状态
	    	String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
	    	String refund_status =request.getParameter("refund_status");  
	    
	    	
	    
	    	System.out.println("同步请求接收到的参数1：out_trade_no:   "+out_trade_no);
	    	System.out.println("同步请求接收到的参数2：trade_no:   "+trade_no);
	    	System.out.println("同步请求接收到的参数3：trade_status:  "+trade_status);
	    	System.out.println("同步请求接收到的参数4：refund_status:  "+refund_status);
	    	//计算得出通知验证结果
	    	boolean verify_result = AlipayNotify.verify(params);
	    	//log.error("--------alipay callbackpage-------"+ JSON.toJSONString(params)+"------------");
	    	log.error("trade_status:"+trade_status+"----------");
	    	if(verify_result){
	    		
	    		Integer pruchaseId = null;
	    		
	    		if((trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS"))&&(StringUtils.isBlank(refund_status))){

	    			    Long paymentId=new Long(out_trade_no);
	    			    System.out.println("paymentId:   "+paymentId);
	    			    //支付成功后修改支付状态为已支付
	    			    try {
	    				
	    					Payment payment = paymentService.modifyOrderStaus(out_trade_no);
	    					pruchaseId = payment.getPurcherId();
	    			    } catch (Exception e) {
	    				
	    					e.printStackTrace();
	    				}
	    		}
	    		log.error("--------alipay callbackpage success-------------------");
	    		//该页面可做页面美工编辑
	    		return "redirect:/purchaseDo/purchase/OnePurchase.html?id="+pruchaseId+"&out_trade_no="+out_trade_no;
	    		
	    	}else{
	    		log.error("--------alipay callbackpage fail-------------------");
	    		//该页面可做页面美工编辑
	    		return "jsp/alipay/fail";
	    	}
	    }
	
	    
	    
	    
	    
	
}
