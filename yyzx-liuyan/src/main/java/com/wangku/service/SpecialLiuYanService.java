package com.wangku.service;

import java.util.List;

import com.wangku.entity.SpecialLiuYan;
import com.wangku.entity.User;
import com.wangku.jdbc.DataSource;
import com.wangku.util.Page;

public interface SpecialLiuYanService {

	/**
	 * 
	 * @author： 周海朋 2015-7-7 下午3:26:39
	 * @方法名：addLiuYan
	 * @方法描述：留言添加
	 * @param:
	 * @返回值：String
	 * 
	 */
	@DataSource("master")
	public String addLiuYan(SpecialLiuYan specialliuyan) throws Exception;

	/**
	 * 
	 * @author： 周海朋 2015-7-8 上午8:16:08
	 * @方法名： queryAllLiuYanByPage
	 * @方法描述：分页查留言信息
	 * @param:
	 * @返回值：Page<SpecialLiuYan>
	 * 
	 */
	@DataSource("slave")
	public Page<SpecialLiuYan> queryAllLiuYanByPage(User user,
			Page<SpecialLiuYan> page) throws Exception;

	/**
	 * 
	 * @author： 周海朋 2015-7-9 下午7:45:54
	 * @方法名： queryAllLiuYanByPageStatus
	 * @方法描述：根据状态分页查留言信息
	 * @param:
	 * @返回值：Page<SpecialLiuYan>
	 * 
	 **/
	@DataSource("slave")
	public Page<SpecialLiuYan> queryAllLiuYanByPageStatus(User user,
			Page<SpecialLiuYan> page, Integer status) throws Exception;

	/**
	 * 
	 * @author： 周海朋 2015-7-9 上午9:28:03
	 * @方法名： queryOneByLYId
	 * @方法描述：根据ID查留言信息
	 * @param:
	 * @返回值：SpecialLiuYan
	 * 
	 **/
	@DataSource("slave")
	public SpecialLiuYan queryOneByLYId(SpecialLiuYan specialliuyan)
			throws Exception;

	/**
	 * 
	 * @author： 周海朋 2015-7-9 上午9:28:36
	 * @方法名： modifyOneLiuYan
	 * @方法描述：修改留言信息
	 * @param:
	 * @返回值：String
	 * 
	 **/
	@DataSource("master")
	public String modifyOneLiuYan(SpecialLiuYan specialliuyan) throws Exception;

	/**
	 * 
	 * @author： 周海朋 2015-7-9 上午9:28:59
	 * @方法名： queryOneByLY
	 * @方法描述：根据条件查询留言信息
	 * @param:
	 * @返回值：List<SpecialLiuYan>
	 * 
	 **/
	@DataSource("master")
	public List<SpecialLiuYan> queryOneByLY(SpecialLiuYan specialliuyan)
			throws Exception;

	/**
	 * 
	 * @author： 周海朋 2015-7-9 上午11:01:53
	 * @方法名：queryLiuYanLikeByCopName
	 * @方法描述：根据公司名模糊查询
	 * @param:
	 * @返回值：Page<SpecialLiuYan>
	 * 
	 **/
	@DataSource("slave")
	public Page<SpecialLiuYan> queryLiuYanLikeByCopName(String copName,
			User user, Page<SpecialLiuYan> page) throws Exception;

	/**
	 * 
	 * @author： 周海朋 2015-7-9 下午1:45:34
	 * @方法名： removeOneLiuYan
	 * @方法描述：删除一条留言信息
	 * @param:
	 * @返回值：String
	 * 
	 **/
	@DataSource("master")
	public String removeOneLiuYan(String lyId) throws Exception;

	/**
	 * 
	 * @author： 周海朋 2015-7-9 下午7:46:21
	 * @方法名： queryAllLiuYanByPage
	 * @方法描述：查询所有留言
	 * @param:
	 * @返回值：List<SpecialLiuYan>
	 * 
	 **/
	@DataSource("slave")
	public List<SpecialLiuYan> queryAllLY(User user) throws Exception;
	/**
	  * 
	  * @author：  周海朋  2015-7-15 下午4:22:55
	  * @方法名： modifyLiuYanById
	  * @方法描述：批量更新留言状态
	  * @param:
	  * @返回值：String
	  *
	  **/
	@DataSource("master")
	public String modifyLiuYanById(String lyId,Integer status) throws Exception;
}
