package com.wangku.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wangku.entity.Advertising;
import com.wangku.jdbc.DataSource;

public interface AdvertisingService {

	/**
	 * @author： 徐国辉 2015-6-19 下午3:50:41
	 * @方法名： queryByVid
	 * @方法描述：根据投票主题id查询 广告位记录
	 * @param:
	 * @返回值：List<Advertising>
	 */
	@DataSource("slave")
	public List<Advertising> queryByVid(Long vId, Integer channelName)throws Exception;

	/**
	 * @author： 徐国辉 2015-6-19 下午3:50:41
	 * @方法名： addAdvertising
	 * @方法描述：添加广告位
	 * @param:
	 * @返回值：void
	 */
	@DataSource("master")
	public String addAdvertising(Advertising advertising,HttpServletRequest request)throws Exception;

	/**
	 * @author： 徐国辉 2015-6-19 下午3:50:41
	 * @方法名： queryAdvertising
	 * @方法描述：主键查询广告位
	 * @param:
	 * @返回值：Advertising
	 */
	@DataSource("slave")
	public Advertising queryAdvertising(Long id)throws Exception;

	/**
	 * @author： 徐国辉 2015-6-19 下午3:50:41
	 * @方法名： emodifyAdvertising
	 * @方法描述：修改广告位
	 * @param:
	 * @返回值：void
	 */
	@DataSource("master")
	public String modifyAdvertising(Advertising advertising,
			HttpServletRequest request)throws Exception;

	/**
	 * @author： 徐国辉 2015-6-19 下午3:50:41
	 * @方法名： removeAdvertising
	 * @方法描述：删除 广告位
	 * @param:
	 * @返回值：void
	 */
	@DataSource("master")
	public void removeAdvertising(Long id)throws Exception;

	/**
	 * @author： 徐国辉 2015-6-19 下午3:50:41
	 * @方法名： queryAdvertisingOnly
	 * @方法描述：根据广告位id查询 广告位记录,不包含图文信息，用于优化下面排序接口的单条记录查询
	 * @param: id 广告位id
	 * @返回值：Advertising
	 * 
	 */
	@DataSource("slave")
	public Advertising queryAdvertisingOnly(Long id)throws Exception;

	/**
	 * @author： 徐国辉 2015-6-26 上午9:24:44
	 * @方法名： modifyAdvOrder
	 * @方法描述：广告位排序
	 * @param: id：广告位id，order 新的排序号
	 * @返回值：void
	 */
	@DataSource("master")
	public void modifyAdvOrder(Advertising advertising, Integer order)throws Exception;

	/**
	 * @author： 徐国辉 2015-7-3 上午10:40:51
	 * @方法名： selectInvalidAdvs
	 * @方法描述：查询已经失效的广告位记录(查询出来的结果集将被定时清理)
	 * 			注：详细功能介绍请见AdvertisingDeleteScheduled类的类级注释
	 * @param:
	 * @返回值：List<Advertising> 无效的广告位集合
	 * 
	 */
	@DataSource("slave")
	List<Advertising> selectInvalidAdvs()throws Exception;
}
