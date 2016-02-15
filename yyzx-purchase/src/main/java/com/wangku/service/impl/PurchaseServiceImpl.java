package com.wangku.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangku.entity.Propurchase;
import com.wangku.entity.PropurchaseExample;
import com.wangku.mapper.PropurchaseMapper;
import com.wangku.service.PurchaseService;
import com.wangku.util.Page;
/**
 * @author zhp
 * 类描述：网库采购表操作
 */
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService{
	 @Autowired
	 private PropurchaseMapper propurchaseMapper;
	
	/**
	 * 
	 * @author：zhp  2015年11月4日 下午4:10:44
	 * @方法名： queryPurchaseBySiteId
	 * @方法描述：分页查制定站点所有采购(状态值为2)
	 * @param:
	 * @返回值：Page<Propurchase>
	 *
	 */
	@Override
	 public Page<Propurchase> queryPurchaseBySiteId(Page<Propurchase> page, Integer siteId)
	    throws Exception
	  {
		Integer STATUS =2 ;
	    PropurchaseExample propurchaseExample = new PropurchaseExample();
	    if (page == null)
	      page = new Page<Propurchase>();
	    else {
	      page.setPageSize(Integer.valueOf(10));
	    }
	    page.setSqlPage(page);
	    List list =propurchaseMapper.selectPropurchaseBySiteId(page.getOffsetValue(), page.getPageSize(), siteId,STATUS);
	    //System.out.println(list+"++++++++++");
	    page.setPageList(list);
	    //状态值 status: 1-待审核； 2-已通过； 4-已禁用；8-推荐；16-置顶；32-删除；64-过期；128-启用；256-未通过；
	    propurchaseExample.createCriteria().andSiteIdEqualTo(siteId).andStatusEqualTo(STATUS);
	    List allList = propurchaseMapper.selectByExample(propurchaseExample);
	    page.setMaxPage(Integer.valueOf(allList.size()), page);

	    return page;
	  }
	/**
	 * 
	 * @author：zhp  2015年11月4日 下午4:10:47
	 * @方法名： queryPurchase
	 * @方法描述：查询制定站点所有采购信息
	 * @param:
	 * @返回值：List<Propurchase>
	 *
	 */
	@Override
	public List<Propurchase> queryPurchase(Integer siteId) throws Exception {
		PropurchaseExample propurchaseExample = new PropurchaseExample();
		//状态值 status: 1-待审核； 2-已通过； 4-已禁用；8-推荐；16-置顶；32-删除；64-过期；128-启用；256-未通过；
		propurchaseExample.createCriteria().andSiteIdEqualTo(siteId).andStatusEqualTo(2);
		List  list=propurchaseMapper.selectByExample(propurchaseExample);
		return list;
	}

 	/**
	 * 
	 * @author：zhp  2015年11月4日 下午4:10:50
	 * @方法名： queryPurchaseById
	 * @方法描述：根据ID查采购信息
	 * @param:
	 * @返回值：Propurchase
	 *
	 */
	@Override
	public Propurchase queryPurchaseById(Integer id) throws Exception {
		return propurchaseMapper.selectByPrimaryKey(id);
	}
	

}
