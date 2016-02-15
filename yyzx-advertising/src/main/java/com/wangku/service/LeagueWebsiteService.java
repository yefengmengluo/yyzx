package com.wangku.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wangku.entity.LeaguePram;
import com.wangku.entity.LeagueSize;
import com.wangku.jdbc.DataSource;
import com.wangku.entity.LeagueWebsite;
import com.wangku.entity.LeagueWebsiteExample;
import com.wangku.util.Page;

public interface LeagueWebsiteService {
	
	/**
	 * @author： 何利娟  2015年9月21日 上午11:00:25
	 * @方法名： queryLeagueWebsitesByIndustryIdPaged
	 * @方法描述：根据行业ID分页查询网站列表
	 * @param:Long industryId 行业ID
	 * @param:Integer currentNum 用于分页
	 * @返回值：Page<LeagueWebsite>
	 *
	 */
	@DataSource("slave")
	public Page<LeagueWebsite> queryLeagueWebsitesByIndustryIdPaged(Long industryId,Integer currentNum,Integer pageSize,String likeParam)throws Exception;

	/**
	 * @author： 何利娟  2015年9月21日 上午11:01:49
	 * @方法名： queryById
	 * @方法描述：根据ID查询网站信息
	 * @param:long id 网站Id
	 * @返回值：LeaguePram
	 *
	 */
	@DataSource("slave")
	public LeagueWebsite queryById(long id)throws Exception;//用于修改行业时，获取对象
	
	/**
	 * @author： 何利娟  2015年9月21日 上午11:03:06
	 * @方法名： queryByParamName
	 * @方法描述：条件查询，根据网站域名、网站名称。。。
	 * @param:LeagueWebsite leagueWebsite
	 * @返回值：int
	 *
	 */
	@DataSource("slave")
	public Page<LeagueWebsite> querySelective(LeagueWebsiteExample example ,Integer currentNum) throws Exception;

	/**
	 * 
	 * @author： 何利娟  2015年9月21日 下午5:26:26
	 * @方法名： querySelectiveCount
	 * @方法描述：计数查询
	 * @param:
	 * @返回值：int
	 *
	 */
	@DataSource("slave")
	public int countByExample(LeagueWebsiteExample example) throws Exception;
	
	/**
	 * @author： 何利娟  2015年9月21日 上午11:05:23
	 * @方法名： addLeaguePram
	 * @方法描述：添加
	 * @param:
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void addLeagueWebsite(LeagueWebsite leagueWebsite) throws Exception;
	
	/**
	 * 
	 * @author： 何利娟  2015年9月21日 上午11:06:56
	 * @方法名： modifyLeagueWebsite
	 * @方法描述：更新网站信息
	 * @param:
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void modifyLeagueWebsite(LeagueWebsite leagueWebsite) throws Exception;
	
	/**
	 * 
	 * @author： 何利娟  2015年9月21日 上午11:07:19
	 * @方法名： removeLeagueWebsiteById
	 * @方法描述：根据ID删除网站信息
	 * @param:Long id
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void removeLeagueWebsiteById(Long id) throws Exception;
	
	/**
	 * 
	 * @author： 何利娟  2015年9月21日 上午11:07:40
	 * @方法名： delBatch
	 * @方法描述：批量删除
	 * @param:
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void delBatch(String ids) throws Exception;
	
	/**
	 * 
	 * @author： 何利娟  2015年9月21日 上午11:20:02
	 * @方法名： addBatch
	 * @方法描述：批量添加
	 * @param:List<LeagueWebsite> list
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void addBatch(List<LeagueWebsite> list) throws Exception;
	
	/**
	 * 根据站点名查询数据库数据
	 * @author： zsl  2015年10月15日 上午10:24:21
	 * @方法名： queryLeagueWebsiteBySiteName
	 * @方法描述：
	 * @param:
	 * @返回值：LeagueWebsite
	 *
	 */
	@DataSource("slave")
	public LeagueWebsite queryLeagueWebsiteBySiteName(String siteName)throws Exception;
	/**
	 * 修改行业单品信息
	 * @author： zsl  2015年10月15日 上午10:46:21
	 * @方法名： updateLeagueWebsite
	 * @方法描述：
	 * @param:
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void updateLeagueWebsite(LeagueWebsite leagueWebsite)throws Exception;
	
	/**
	 * 上传行业单品文档
	 * @author： zsl  2015年10月15日 上午11:08:24
	 * @方法名： uploadFile
	 * @方法描述：
	 * @param:
	 * @返回值：String
	 *
	 */
	public String uploadFile(HttpServletRequest req)throws Exception;
}
