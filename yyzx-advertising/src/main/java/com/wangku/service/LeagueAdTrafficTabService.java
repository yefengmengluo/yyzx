package com.wangku.service;

import java.util.Date;
import java.util.List;

import com.wangku.entity.AdTrafficModel;
import com.wangku.entity.AdvSpaceTrafficCountModel;
import com.wangku.entity.ChartData;
import com.wangku.entity.LeagueAdTrafficTab;
import com.wangku.jdbc.DataSource;
import com.wangku.util.Page;
/**
 * 
 * @author zsl
 * 2015年9月15日下午3:41:57
 * 类描述：广告联盟广告流量统计服务接口
 */
public interface LeagueAdTrafficTabService {
	/**
	 * 
	 * @author： 何利娟  2015年9月15日 下午4:01:12
	 * @方法名： addTrafficRecord
	 * @方法描述：添加流量记录
	 * @param:
	 * @返回值：String
	 *
	 */
	@DataSource("master")
	public int addTrafficRecord(LeagueAdTrafficTab leagueAdTrafficTab) throws Exception;
	
	/**
	 * @author： 何利娟  2015年9月16日 下午4:38:13
	 * @方法名： queryAdTrafficByKeywordPaged
	 * @方法描述：分页查询流量记录
	 * @param:adId 广告ID
	 * @param:beginDate 开始时间
	 * @param:endDate 结束时间
	 * @param:currentNum 当前序号
	 * @返回值：Page<LeagueAdTrafficTab>
	 *
	 */
	@DataSource("slave")
	Page<LeagueAdTrafficTab> queryAdTrafficByKeywordPaged(Long adId, Date beginDate, Date endDate, Integer currentNum)
			throws Exception;
	
	/**
	 * @author： 何利娟  2015年9月16日 下午4:40:09
	 * @方法名： queryAdTrafficArea
	 * @方法描述：统计各地区流量数
	 * @param:adId 广告ID
	 * @param:beginDate 开始时间
	 * @param:endDate 结束时间
	 * @返回值：List<LeagueAdTrafficTab>
	 *
	 */
	@DataSource("slave")
	public List<LeagueAdTrafficTab> queryAdTrafficArea(Long adId, Date beginDate, Date endDate)
			throws Exception;
	
	/**
	 * 
	 * @author： zsl  2015年9月23日 下午2:33:09
	 * @方法名： getAllAdvSpaceTotalFlow
	 * @方法描述：获取所有广告位的总流量
	 * @param:
	 * @返回值：int
	 *
	 */
	@DataSource("slave")
	public int getAllAdvSpaceTotalFlow();

/**
	 * 
	 * @author： zsl  2015年9月23日 下午2:03:07
	 * @方法名： queryAdvSpaceCountListByKeywordPaged
	 * @方法描述：分页查询广告位流量统计列表
	 * @param:
	 * @返回值：Page<AdTrafficModel>
	 *
	 */
	@DataSource("slave")
	public Page<AdTrafficModel> queryAdvSpaceListByPaged(Integer currentNum) throws Exception;	
	
	/**
	 * 
	 * @author： zsl  2015年9月24日 上午9:31:35
	 * @方法名： queryTrafficCountBySizeCode
	 * @方法描述：指定广告位下各个行业各个广告流量统计列表
	 * @param:
	 * @返回值：List<AdvSpaceTrafficCountModel>
	 *
	 */
	@DataSource("slave")
	public List<AdvSpaceTrafficCountModel> queryTrafficCountBySizeCode(String sizeCode,Long industryId,
			String keyWord,Integer advType) throws Exception;
	
	@DataSource("slave")
	public List<AdvSpaceTrafficCountModel> queryTrafficCountBySizeCode(String sizeCode,Long industryId,
			String keyWord,Integer advType,Long selectDate) throws Exception;
	
	/**
	 * 
	 * @author： zsl  2015年9月24日 上午9:32:21
	 * @方法名： queryChart
	 * @方法描述：走势图的查询
	 * @param:
	 * @返回值：ChartData
	 *
	 */
	@DataSource("slave")
	public ChartData queryChart(String sizeCode,String queryType,Long industryId,Integer advType) throws Exception;
	
	/**
	 * 清空对应广告的的流量
	 * @author： zsl  2015年9月24日 下午4:54:43
	 * @方法名： delTraffics
	 * @方法描述：
	 * @param:
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void delTraffics(Long adId);
	/**
	 * 
	 * @author： zsl  2015年9月24日 下午6:08:39
	 * @方法名： queryAllTrafficCountBySizeCode
	 * @方法描述：查询指定广告位下的所有广告的总流量
	 * @param:
	 * @返回值：int
	 *
	 */
	@DataSource("slave")
	public int queryAllTrafficCountBySizeCode(String sizeCode,Integer advType) throws Exception;;
	@DataSource("slave")
	public int queryAllTrafficCountBySizeCode(String sizeCode,Integer advType,Long selectDate) throws Exception;;
}
