package com.wangku.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wangku.entity.AdvTypeAndSize;
import com.wangku.entity.LeagueSize;
import com.wangku.entity.LeagueSizeListModel;
import com.wangku.jdbc.DataSource;
import com.wangku.pojo.LeagueAdvListModel;
import com.wangku.util.Page;
/**
 * 行业类型尺寸关系服务接口
 * @author zsl
 * 2015年7月23日下午5:03:11
 * 类描述：
 */
public interface LeagueSizeService {
	
	/**
	 * 
	 * @author： zsl  2015年7月23日 下午4:40:23
	 * @方法名： queryAll
	 * @方法描述：查询全部的数据
	 * @param:
	 * @返回值：List<LeagueSize>
	 *
	 */
	@DataSource("slave")
	public List<LeagueSize> queryAll() throws Exception;
	
	/**
	 * 
	 * @author： zsl  2015年7月23日 下午5:01:21
	 * @方法名： queryById
	 * @方法描述：根据id查询尺寸数据
	 * @param:
	 * @返回值：LeagueSize
	 *
	 */
	@DataSource("slave")
	public LeagueSize queryById(Long id) throws Exception;
	
	/**
	 * 
	 * @author： zsl  2015年7月23日 下午5:02:54
	 * @方法名： addLeagueSize
	 * @方法描述：新增尺寸数据
	 * @param:
	 * @返回值：int
	 *
	 */
	@DataSource("master")
	public int addLeagueSize(LeagueSize leagueSize) throws Exception;
	
	
	/**
	 * 
	 * @author： zsl  2015年7月23日 下午5:05:13
	 * @方法名： updateLeagueSize
	 * @方法描述：修改尺寸数据
	 * @param:
	 * @返回值：int
	 *
	 */
	@DataSource("master")
	public int updateLeagueSize(LeagueSize leagueSize) throws Exception;
	
	/**
	 * 
	 * @author： zsl  2015年7月23日 下午5:05:55
	 * @方法名： deleteLeagueSizeById
	 * @方法描述：根据ID删除尺寸数据
	 * @param:
	 * @返回值：int
	 *
	 */
	@DataSource("master")
	public int deleteLeagueSizeById(Long id) throws Exception;
	
	/**
	 * 
	 * @author： zsl  2015年7月24日 上午10:18:13
	 * @方法名： queryAdvTypeAndSizeByIndustryIds
	 * @方法描述：根据行业id集合查询行业下共同的尺寸
	 * @param:
	 * @返回值：List<AdvTypeAndSize>
	 *
	 */
	@DataSource("slave")
	public List<AdvTypeAndSize> queryAdvTypeAndSizeByIndustryIds(List<Long> ids) throws Exception;
	
	/**
	 * 
	 * @author： zsl  2015年7月27日 上午9:42:40
	 * @方法名： queryInitTypeSize
	 * @方法描述：初始化广告类型和尺寸列表
	 * @param:
	 * @返回值：List<AdvTypeAndSize>
	 *
	 */
   // public List<AdvTypeAndSize> queryInitTypeSize()throws Exception;
    /**
     * 
     * @author： zsl  2015年7月27日 上午9:42:58
     * @方法名： queryTypeSizeByOneIndustryId
     * @方法描述：传入一个行业ID查询广告类型尺寸列表
     * @param:
     * @返回值：List<AdvTypeAndSize>
     *
     */
   // public List<AdvTypeAndSize> queryTypeSizeByOneIndustryId(Long industryId)throws Exception;
   /**
    * 
    * @author： zsl  2015年7月27日 上午9:43:32
    * @方法名： queryTypeSizeByIndustryIds
    * @方法描述：传入多个行业ID查询广告类型尺寸列表
    * @param:
    * @返回值：List<AdvTypeAndSize>
    *
    */
    //public List<AdvTypeAndSize> queryTypeSizeByIndustryIds(List<Long> industryIdList)throws Exception;
    /**
     * 
     * @author： zsl  2015年7月27日 下午3:08:44
     * @方法名： addLeagueSizeBatch
     * @方法描述：批量添加尺寸数据
     * @param:
     * @返回值：List<LeagueSize>
     *
     */
	@DataSource("master")
    public List<LeagueSize> addLeagueSizeBatch(String[] industryIds,String[] advTypeIds,String advSize) throws Exception;
    /**
     * 
     * @author： zsl  2015年7月28日 下午4:23:19
     * @方法名： queryLeagueSizeList
     * @方法描述：查询尺寸列表
     * @param:
     * @返回值：List<LeagueSizeListModel>
     *
     */
    @DataSource("slave")
    public List<LeagueSizeListModel> queryLeagueSizeList() throws Exception;
    
    /**
     * 
     * @author： zsl  2015年8月17日 下午3:53:45
     * @方法名： queryAdvSizeListByKeywordPaged
     * @方法描述：根据关键字查询尺寸信息
     * @param:
     * @返回值：Page<LeagueSize>
     *
     */
    @DataSource("slave")
	public Page<LeagueSize> queryAdvSizeListByKeywordPaged(Long industryId,Long typeId,Integer currentNum)throws Exception ;
    
    /**
     * 
     * @author： zsl  2015年8月18日 上午8:54:27
     * @方法名： removeAdvSize
     * @方法描述：根据ID删除尺寸数据
     * @param:  id 尺寸id           count：用来判断此尺寸广告位下有无广告    0无    1有
     * @返回值：void
     *
     */
    @DataSource("master")
    public void removeAdvSize(Long id,Integer count) throws Exception ;
}
