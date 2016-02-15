package com.wangku.mapper;

import com.wangku.entity.LeagueWebsite;
import com.wangku.entity.LeagueWebsiteExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeagueWebsiteMapper {
    int countByExample(LeagueWebsiteExample example);

    int deleteByExample(LeagueWebsiteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LeagueWebsite record);

    int insertSelective(LeagueWebsite record);

    List<LeagueWebsite> selectByExample(LeagueWebsiteExample example);

    LeagueWebsite selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LeagueWebsite record, @Param("example") LeagueWebsiteExample example);

    int updateByExample(@Param("record") LeagueWebsite record, @Param("example") LeagueWebsiteExample example);

    int updateByPrimaryKeySelective(LeagueWebsite record);

    int updateByPrimaryKey(LeagueWebsite record);
    
    void addBatch(List<LeagueWebsite> list);
    
    void delBatch(List<Long> id);
    
    List<LeagueWebsite> queryLeagueWebsitesByIndustryIdPaged(
			@Param("offsetValue") Integer offset,
			@Param("pageSize") Integer pageSize,
			@Param("industryId")Long industryId,
			@Param("likeParam")String likeParam
			);
    int queryLeagueWebsitesByIndustryIdCount(@Param("industryId")Long industryId,@Param("likeParam")String likeParam);
 
}