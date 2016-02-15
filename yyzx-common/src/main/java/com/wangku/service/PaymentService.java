package com.wangku.service;

import java.util.List;

import com.wangku.entity.Payment;
import com.wangku.jdbc.DataSource;

/**
 * @author zhp
 * 类描述：订单表操作
 */
public interface PaymentService {

	/**
	 * 
	 * @author：zhp  2015年11月20日 上午10:47:42
	 * @方法名： addOnePay
	 * @方法描述：添加订单信息
	 * @param:
	 * @返回值：int
	 *
	 */
	@DataSource("master")
	public int addOnePay(Payment payment)throws Exception;
	/**
	 * 
	 * @author：zhp  2015年11月20日 上午10:47:50
	 * @方法名： modifyOrderStaus
	 * @方法描述：付款成功后根据订单号修改订单状态
	 * @param:
	 * @返回值：Payment
	 *
	 */
	@DataSource("master")
	public Payment modifyOrderStaus(String id)throws Exception;
	/**
	 * 
	 * @author：zhp  2015年11月20日 上午10:48:00
	 * @方法名： SelectOrderById
	 * @方法描述：根据订单号查询订单
	 * @param:
	 * @返回值：Payment
	 *
	 */
	@DataSource("master")
	public Payment SelectOrderById(String id)throws Exception;
	
	@DataSource("master")
	public List<Payment> SelectOrderByPay(Payment payment)throws Exception;
}
