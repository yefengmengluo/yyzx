package com.wangku.controller.payment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.util.UtilDate;
import com.wangku.entity.Payment;
import com.wangku.service.PaymentService;

import net.sf.json.JSONArray;

/**
 * @author zhp
 *
 */
@Controller
@RequestMapping("paymentDo")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;

	/**
	 * 
	 * @author：zhp  2015年11月20日 上午11:08:45
	 * @方法名： addPayment
	 * @方法描述：添加订单
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/payment/addOrder.html")
	public String addPayment(ModelMap map, HttpServletRequest request,	Payment  payment) {
		try {
		//	@RequestParam Integer purcherId,@RequestParam String subject,
		//	@RequestParam BigDecimal price,@RequestParam String telephone,@RequestParam Integer goodsType,@RequestParam String suiji
		
			Integer yztype=0;
			Long payid = 0L;
		
			String outTradeNo=UtilDate.getOrderNum()+UtilDate.getThree();
			payment.setOutTradeNo(outTradeNo);
			payment.setBody("采购支付");
			payment.setTotalFee(payment.getPrice());
			//System.out.println(outTradeNo + ">>>>>>>>>>>>>>>>>>>>>>>>>原始");
		/*	payment.setPurcherId(purcherId);
			payment.setPrice(price);
			payment.setTotalFee(price);
			payment.setSubject(subject);
			payment.setTelephone(telephone);
			payment.setGoodsType(goodsType);
			payment.setOutTradeNo(outTradeNo);
			String  yanzheng =(String) request.getSession().getAttribute(telephone);*/
			List <Payment> list =paymentService.SelectOrderByPay(payment);
		
				//System.err.println(payment+"+++++++++++++++++++++++++++++++++++++++++");
				//if (suiji.equals(yanzheng)){
					if(list.size()==0){
					paymentService.addOnePay(payment);
					}
					//yztype = 1;
					payid=payment.getId();
			
			/*	List<Object> params=new ArrayList<Object>();
				params.add(a);
				params.add(yztype);
				JSONArray object = JSONArray.fromObject(params);*/
			//	return "result("+object+")";
					//?WIDout_trade_no="+payment.getOutTradeNo()+"&WIDsubject="+payment.getSubject()+"&WIDtotal_fee="+payment.getPrice()+"&WIDbody=采购支付&WIDshow_url=&paymentId="+payment.getPurcherId()+"&WIDreceive_mobile="+payment.getTelephone();
				map.put("WIDout_trade_no", payment.getOutTradeNo());
				map.put("WIDsubject", payment.getSubject());
				map.put("WIDtotal_fee", payment.getTotalFee());
				map.put("WIDbody", payment.getBody());
				map.put("paymentId", payment.getPurcherId());
				map.put("WIDshow_url", "");
				map.put("WIDreceive_mobile", payment.getTelephone());
				return "redirect:/alipay/pay";
		
		
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		
	}

}
