package com.wangku.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.wangku.entity.Payment;
import com.wangku.entity.PaymentExample;
import com.wangku.mapper.PaymentMapper;
import com.wangku.service.PaymentService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.util.VoteSeqEnum;
/**
 * @author zhp
 * 类描述：订单表操作
 */
@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired 
	private PaymentMapper paymentMapper;
	@Autowired
	private VoteSequenceDao voteSequenceDao;
	
	
	/**
	 * 
	 * @author：zhp  2015年11月20日 上午10:47:42
	 * @方法名： addOnePay
	 * @方法描述：添加订单信息
	 * @param:
	 * @返回值：int
	 *
	 */
	@Override 
	public int addOnePay(Payment payment) throws Exception {
		Long id=voteSequenceDao.getIdByTableName(VoteSeqEnum.PAYMENT_SEQ.PAYMENT.getValue());
		String status=VoteSeqEnum.PAY_STATUS.WAIT.getValue();
		payment.setId(id);
		payment.setPayTime(new Date());
		payment.setSuccessFlag(status);
		
		if(payment.getGoodsType()== 1){//采购支付
			//TODO
		}else if(payment.getGoodsType()==2){//广告支付
			//TODO
		}
		return paymentMapper.insert(payment);
	}

	/**
	 * 
	 * @author：zhp  2015年11月20日 上午10:47:50
	 * @方法名： modifyOrderStaus
	 * @方法描述：付款成功后根据订单号修改订单状态
	 * @param:
	 * @返回值：Payment
	 *
	 */
	@Override
	public Payment modifyOrderStaus(String id) throws Exception {
		PaymentExample qbe = new PaymentExample();
		qbe.createCriteria().andOutTradeNoEqualTo(id);
		List<Payment> payments = paymentMapper.selectByExample(qbe);
		Payment payment = null;
		if(!CollectionUtils.isEmpty(payments)){
			payment = payments.get(0);
			payment.setSuccessFlag(VoteSeqEnum.PAY_STATUS.SUCCESS.getValue());
			paymentMapper.updateByExampleSelective(payment, qbe);
		}
		return  payment;
	}
	
	/**
	 * 
	 * @author：zhp  2015年11月20日 上午10:48:00
	 * @方法名： SelectOrderById
	 * @方法描述：根据订单号查询订单
	 * @param:
	 * @返回值：Payment
	 *
	 */
	@Override
	public Payment SelectOrderById(String id) throws Exception {
		PaymentExample qbe = new PaymentExample();
		qbe.createCriteria().andOutTradeNoEqualTo(id);
		List<Payment> payments = paymentMapper.selectByExample(qbe);
		Payment payment = null;
		if(!CollectionUtils.isEmpty(payments)){
			payment = payments.get(0);}
		return payment;
	}

	@Override
	public List<Payment> SelectOrderByPay(Payment payment) throws Exception {
		PaymentExample qbe = new PaymentExample();
		qbe.createCriteria().andPurcherIdEqualTo(payment.getPurcherId()).andTelephoneEqualTo(payment.getTelephone()).andOutTradeNoEqualTo(payment.getOutTradeNo());
		return paymentMapper.selectByExample(qbe);
	}

	
	
	
}
