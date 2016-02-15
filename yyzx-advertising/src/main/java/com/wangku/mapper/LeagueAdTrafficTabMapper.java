package com.wangku.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.AdTrafficModel;
import com.wangku.entity.AdvSpaceTrafficCountModel;
import com.wangku.entity.DateGroupCount;
import com.wangku.entity.LeagueAdTrafficTab;
import com.wangku.entity.LeagueAdTrafficTabExample;

public interface LeagueAdTrafficTabMapper {
    int countByExample(LeagueAdTrafficTabExample example);

    int deleteByExample(LeagueAdTrafficTabExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LeagueAdTrafficTab record);

    int insertSelective(LeagueAdTrafficTab record);

    List<LeagueAdTrafficTab> selectByExample(LeagueAdTrafficTabExample example);

    LeagueAdTrafficTab selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LeagueAdTrafficTab record, @Param("example") LeagueAdTrafficTabExample example);

    int updateByExample(@Param("record") LeagueAdTrafficTab record, @Param("example") LeagueAdTrafficTabExample example);

    int updateByPrimaryKeySelective(LeagueAdTrafficTab record);

    int updateByPrimaryKey(LeagueAdTrafficTab record);
    
    List<LeagueAdTrafficTab> queryAdTrafficByKeywordPaged(@Param("adId")Long adId,@Param("beginDate") Date beginDate,@Param("endDate") Date endDate,@Param("offsetValue") Integer offsetValue,@Param("pageSize") Integer pageSize);
    
    int queryAdTrafficByKeywordCount(@Param("adId") Long adId,@Param("beginDate") Date beginDate,@Param("endDate") Date endDate);
    
    List<LeagueAdTrafficTab> queryAdTrafficArea(@Param("adId") Long adId,@Param("beginDate") Date beginDate,@Param("endDate") Date endDate);
    

	/**
	 * 
	 * @author： zsl 2015年9月15日 下午4:11:20
	 * @方法名： queryTrafficCount_advSpace
	 * @方法描述：图片广告位的流量
	 * @param:
	 * @返回值：List<AdTrafficModel>
	 * 
	 */
	List<AdTrafficModel> queryTrafficCount_advSpace_list(
			@Param("offsetValue") Integer offsetValue,
			@Param("pageSize") Integer pageSize);
	
	/**
	 * 
	 * @author： zsl  2015年9月23日 下午2:34:52
	 * @方法名： getAllAdvSpaceTotalFlow
	 * @方法描述：获取所有广告位的总流量
	 * @param:
	 * @返回值：int
	 *
	 */
	int getAllAdvSpaceTotalFlow();

	/**
	 * 
	 * @author： zsl 2015年9月23日 下午2:24:19
	 * @方法名： queryTrafficCount_advSpace_count
	 * @方法描述：广告位数量
	 * @param:
	 * @返回值：int
	 * 
	 */
	int queryTrafficCount_advSpace_count();

	/**
	 * 
	 * @author： zsl 2015年9月21日 上午11:54:53
	 * @方法名： queryTrafficCountBySizeCode
	 * @方法描述：指定广告位下各个行业各个广告的流量统计
	 * @param:
	 * @返回值：List<AdvSpaceTrafficCountModel>
	 * 
	 */
	List<AdvSpaceTrafficCountModel> queryTrafficCountBySizeCode(
			@Param("sizeCode") String sizeCode,
			@Param("industryId") Long industryId,
			@Param("keyWord") String keyWord);
	
	List<AdvSpaceTrafficCountModel> queryTrafficCountBySizeCode2(
			@Param("sizeCode") String sizeCode,
			@Param("industryId") Long industryId,
			@Param("keyWord") String keyWord,
			@Param("selectDate") Long selectDate,
			@Param("beginDate") Date beginDate,
			@Param("endDate") Date endDate);
	
	/**
	 * 文字广告流量统计
	 * @author： zsl  2015年9月24日 下午3:42:18
	 * @方法名： queryWordTrafficCountBySizeCode
	 * @方法描述：
	 * @param:
	 * @返回值：List<AdvSpaceTrafficCountModel>
	 *
	 */
	List<AdvSpaceTrafficCountModel> queryWordTrafficCountBySizeCode(
			@Param("industryId") Long industryId,
			@Param("keyWord") String keyWord);
	
	List<AdvSpaceTrafficCountModel> queryWordTrafficCountBySizeCode2(
			@Param("industryId") Long industryId,
			@Param("keyWord") String keyWord,
			@Param("selectDate") Long selectDate,
			@Param("beginDate") Date beginDate,
			@Param("endDate") Date endDate);
	

	/**
	 * 
	 * @author： zsl 2015年9月21日 上午11:55:21
	 * @方法名： queryChartNum
	 * @方法描述：今天某时段的流量统计
	 * @param:
	 * @返回值：Integer
	 * 
	 */
	Integer queryChartNum(@Param("beginDate") Date beginDate,
			@Param("endDate") Date endDate, @Param("sizeCode") String sizeCode,
			@Param("industryId") Long industryId);

	/**
	 * 
	 * @author： zsl 2015年9月21日 上午11:55:38
	 * @方法名： queryChartNumByDayGroup
	 * @方法描述：根据天数统计流量
	 * @param:
	 * @返回值：List<DateGroupCount>
	 * 
	 */
	List<DateGroupCount> queryChartNumByDayGroup(
			@Param("beginDate") Date beginDate,
			@Param("sizeCode") String sizeCode,
			@Param("industryId") Long industryId);
	
	
	/**
	 * 
	 * @author： zsl 2015年9月21日 上午11:55:21
	 * @方法名： queryChartNum
	 * @方法描述：今天某时段的文字广告流量统计
	 * @param:
	 * @返回值：Integer
	 * 
	 */
	Integer queryWordChartNum(@Param("beginDate") Date beginDate,
			@Param("endDate") Date endDate,
			@Param("industryId") Long industryId);

	/**
	 * 
	 * @author： zsl 2015年9月21日 上午11:55:38
	 * @方法名： queryChartNumByDayGroup
	 * @方法描述：根据天数统计文字广告流量
	 * @param:
	 * @返回值：List<DateGroupCount>
	 * 
	 */
	List<DateGroupCount> queryWordChartNumByDayGroup(
			@Param("beginDate") Date beginDate,
			@Param("industryId") Long industryId);
	
	/**
	 * 
	 * @author： zsl  2015年9月25日 上午8:48:56
	 * @方法名： queryAllTrafficCountBySizeCode
	 * @方法描述：根据编码查询图片广告流量总数
	 * @param:
	 * @返回值：int
	 *
	 */
	int queryAllTrafficCountBySizeCode(String sizeCode);
	
	int queryAllTrafficCountBySizeCode2(
			@Param("sizeCode")String sizeCode,
			@Param("selectDate") Long selectDate,
			@Param("beginDate") Date beginDate,
			@Param("endDate") Date endDate);
	
	/**
	 * 
	 * @author： zsl  2015年9月25日 上午8:49:32
	 * @方法名： queryWordAllTrafficCountBySizeCode
	 * @方法描述：查询文字广告流量总数
	 * @param:
	 * @返回值：int
	 *
	 */
	int queryWordAllTrafficCountBySizeCode();
	
	int queryWordAllTrafficCountBySizeCode2(
			@Param("selectDate") Long selectDate,
			@Param("beginDate") Date beginDate,
			@Param("endDate") Date endDate);
}