package com.wangku.controller.purchase;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangku.entity.MemberBasic;
import com.wangku.entity.Payment;
import com.wangku.entity.Propurchase;
import com.wangku.service.MemberBasicService;
import com.wangku.service.PaymentService;
import com.wangku.service.PurchaseService;
import com.wangku.util.NoteUtil;
import com.wangku.util.Page;

/**
 * @author 周海朋 
 * 类描述： 采购表controller
 */
@Controller
@RequestMapping("purchaseDo")
public class PurchaseController {
	@Autowired  private PurchaseService purchaseService;
	@Autowired private MemberBasicService  memberBasicService;
	@Autowired	private PaymentService paymentService;
	/**
	 * 
	 * @author：zhp 2015年11月4日 下午4:08:40 
	 * @方法名： queryPurchaseBySiteId
	 * @方法描述：分页查询指定站点下的所有采购信息
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/purchase/allPurchase.html")
	public String queryPurchaseBySiteId(ModelMap map, HttpServletRequest request, Page<Propurchase> page,
			Integer siteId) {
		siteId = 3;
		try {
			page = purchaseService.queryPurchaseBySiteId(page, 3);
			List<Propurchase> pageList = page.getPageList();
			for (int i = 0; i < pageList.size(); i++) {
				String tell = pageList.get(i).getTel();
				String newtell = null;
				if (!StringUtils.isEmpty(tell)) {
					newtell = tell.substring(0, tell.length() - (tell.substring(3)).length()) + "****"
							+ tell.substring(7);
				}
				// System.out.println("newtell"+newtell);
				pageList.get(i).setTel(newtell);

			}
			page.setPageList(pageList);
			map.put("page", page);
			// System.out.println(page);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return "purchase/list1";
	}

	/**
	 * 
	 * @author：zhp 2015年11月4日 下午4:09:16
	 * @方法名：queryPurchase
	 * @方法描述：查询站点下所有采购
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/purchase/Purchase.html")
	public String queryPurchase(ModelMap map, HttpServletRequest request, Integer siteId) throws Exception {
		siteId = 3;
		List<Propurchase> list = purchaseService.queryPurchase(siteId);
		for (int i = 0; i < list.size(); i++) {
			String tell = list.get(i).getTel();
			String newtell = null;
			if (!StringUtils.isEmpty(tell)) {
				newtell = tell.substring(0, tell.length() - (tell.substring(3)).length()) + "****" + tell.substring(7);
			}
			// System.out.println("newtell"+newtell);
			list.get(i).setTel(newtell);
		}
		map.put("list", list);
		// System.out.println(list);
		return "purchase/list";
	}

	/**
	 * 
	 * @author：zhp 2015年11月4日 下午4:09:40 
	 * @方法名： queryPurchaseById
	 * @方法描述：根据采购ID查询采购详细信息
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/purchase/OnePurchase.html")
	public String queryPurchaseById(ModelMap map, HttpServletRequest request, Integer id,String out_trade_no) {
		String message = null;;
		String result;
		try {
			//根据采购ID查询采购信息
			Propurchase purchase = purchaseService.queryPurchaseById(id);
			//查询会员ID
			Long memberId=purchase.getMemberId();
			//根据会员Id查询网库会员的信息（公司名称  公司简介）
			MemberBasic memberBasic= memberBasicService.queryMemberBasicByMemberId(memberId);
			//根据订单号查询支付信息
			Payment payment = paymentService.SelectOrderById(out_trade_no);
		


			message="感谢您使用中国网库采购平台， 标题:"+purchase.getTitle()+"，联系人:"+purchase.getLinkman()+"，联系电话:"+purchase.getTel()+"，企业名称:"+memberBasic.getCorporationName()+"【中国网库】";
			//message="您的验证码是："+randomNum+"。请不要把验证码泄露给其他人。【百分信息】";
			
			result = NoteUtil.SMSCenter(message, payment.getTelephone());
				System.out.println("成功结果" + result);
				if (result.contains("<State>")) {
					String substring = result.substring(result.indexOf("<State>"), result.indexOf("</State>"));
					System.out.println("substring:" + substring);
					for (int i = 0; i < 3; i++) {
						if (!substring.equals("<State>0")) {
							result = NoteUtil.SMSCenter(message, payment.getTelephone());
						} else {
							break;
						}

					}
				}
			
			map.put("purchase", purchase);
			map.put("memberBasic", memberBasic);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return "purchase/pageback";
	}

	/**
	 * 
	 * @author：xhy 2015年11月4日 下午4:09:40 
	 * @方法名： sendNote
	 * @方法描述：发送短信
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/purchase/sendNote.html")
	@ResponseBody
	public String sendNote(ModelMap map, HttpServletRequest request, String mobile) {
		String randomNum = "";
		String message = null;;
		String result;
		try {
			
			randomNum = NoteUtil.randomNum();
			//message="您的验证码是："+randomNum+"。请不要把验证码泄露给其他人。【百分信息】";
			message="您的验证码是："+randomNum+"。请不要把验证码泄露给其他人。【中国网库】";
			request.getSession().setAttribute(mobile, randomNum);
			result = NoteUtil.SMSCenter(message, mobile);
			System.out.println("短信结果" + result);
			if (result.contains("<State>")) {
				String substring = result.substring(result.indexOf("<State>"), result.indexOf("</State>"));
				System.out.println("substring:" + substring);
				for (int i = 0; i < 3; i++) {
					if (!substring.equals("<State>0")) {
						result = NoteUtil.SMSCenter(message, mobile);
					} else {
						break;
					}

				}
			}
			// System.out.println("发送短信结果："+result);
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("随机数字验证码:"+randomNum);
		return "result("+randomNum+")";
	}
}
