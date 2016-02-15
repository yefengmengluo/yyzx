package com.wangku.service;

import java.util.List;

import com.wangku.entity.Propurchase;
import com.wangku.jdbc.DataSource;
import com.wangku.util.Page;

/**
 * @author zhp
 * 类描述：网库采购表操作
 */
public interface PurchaseService {
	
	
	 	/**
		 * 
		 * @author：zhp  2015年11月4日 下午4:10:44
		 * @方法名： queryPurchaseBySiteId
		 * @方法描述：分页查制定站点所有采购
		 * @param:
		 * @返回值：Page<Propurchase>
		 *
		 */
	@DataSource("slaveWkSysBus")
	public  Page<Propurchase> queryPurchaseBySiteId(Page<Propurchase> page, Integer siteId) throws Exception;
	 
	 	/**
		 * 
		 * @author：zhp  2015年11月4日 下午4:10:47
		 * @方法名： queryPurchase
		 * @方法描述：查询制定站点所有采购信息
		 * @param:
		 * @返回值：List<Propurchase>
		 *
		 */
	@DataSource("slaveWkSysBus")
	public List<Propurchase> queryPurchase(Integer siteId) throws Exception;
	 
	 	/**
		 * 
		 * @author：zhp  2015年11月4日 下午4:10:50
		 * @方法名： queryPurchaseById
		 * @方法描述：根据ID查采购信息
		 * @param:
		 * @返回值：Propurchase
		 *
		 */
	@DataSource("slaveWkSysBus")
	public Propurchase queryPurchaseById(Integer id) throws Exception;
}
