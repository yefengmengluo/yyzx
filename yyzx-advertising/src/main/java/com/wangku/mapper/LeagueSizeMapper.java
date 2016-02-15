package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.AdvTypeAndSize;
import com.wangku.entity.LeagueSize;
import com.wangku.entity.LeagueSizeExample;
import com.wangku.entity.LeagueSizeListModel;
import com.wangku.pojo.LeagueAdvListModel;

public interface LeagueSizeMapper {
    int countByExample(LeagueSizeExample example);

    int deleteByExample(LeagueSizeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LeagueSize record);

    int insertSelective(LeagueSize record);

    List<LeagueSize> selectByExample(LeagueSizeExample example);

    LeagueSize selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LeagueSize record, @Param("example") LeagueSizeExample example);

    int updateByExample(@Param("record") LeagueSize record, @Param("example") LeagueSizeExample example);

    int updateByPrimaryKeySelective(LeagueSize record);

    int updateByPrimaryKey(LeagueSize record);
    
    /**
     * 初始化广告类型和尺寸列表
     * @return
     */
    List<AdvTypeAndSize> queryInitTypeSize();
    /**
     * 传入一个行业ID查询广告类型尺寸列表
     * @return
     */
    List<AdvTypeAndSize> queryTypeSizeByOneIndustryId(@Param("industryId") Long industryId);
    /**
     * 传入多个行业ID查询广告类型尺寸列表
     * @param industryIds
     * @return
     */
    List<AdvTypeAndSize> queryTypeSizeByIndustryIds(@Param("industryIdList") List<Long> industryIdList,
    		@Param("iNum") Integer iNum);
    /**
     * 
     * @author： zsl  2015年7月27日 下午3:40:45
     * @方法名： addBatch
     * @方法描述：批量添加尺寸数据
     * @param:
     * @返回值：void
     *
     */
    void addBatch(@Param("list") List<LeagueSize> list);
    /**
     * 
     * @author： zsl  2015年7月28日 下午2:31:52
     * @方法名： queryLeagueSizeList
     * @方法描述：查询尺寸列表
     * @param:
     * @返回值：List<AdvTypeAndSize>
     *
     */
    List<LeagueSizeListModel> queryLeagueSizeList();
    /**
     * 
     * @author： zsl  2015年8月3日 下午3:36:50
     * @方法名： queryLeagueSizeByIndustryIdAndSizeCode
     * @方法描述：根据行业ID和尺寸编码查询尺寸数据
     * @param:
     * @返回值：LeagueSize
     *
     */
	LeagueSize queryLeagueSizeByIndustryIdAndSizeCode(@Param("industryId") Long industryId,
			@Param("sizeCode") String sizeCode);
	
	
	//条件分页查询广告位信息记录
    List<LeagueSize> queryAdvSizeListByKeywordPaged(@Param("industryId")Long industryId,@Param("typeId") Long typeId,@Param("offsetValue") Integer offsetValue,@Param("pageSize") Integer pageSize);
    //条件分页查询广告位信息记录
    int queryAdvSizeListByKeywordPagedCount(@Param("industryId")Long industryId,@Param("typeId") Long typeId);
    
    //根据ID删除此尺寸广告位下的广告
    void deleteAdvInfos(@Param("id") Long id);
    
    //根据尺寸id查询广告部分信息
    List<String> queryAdvStrList(@Param("id") Long id);
}