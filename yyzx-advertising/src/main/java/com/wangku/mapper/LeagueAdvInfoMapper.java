package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.LeagueAdvInfo;
import com.wangku.entity.LeagueAdvInfoExample;
import com.wangku.pojo.LeagueAdvListModel;

public interface LeagueAdvInfoMapper {
    int countByExample(LeagueAdvInfoExample example);

    int deleteByExample(LeagueAdvInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LeagueAdvInfo record);

    int insertSelective(LeagueAdvInfo record);

    List<LeagueAdvInfo> selectByExample(LeagueAdvInfoExample example);

    LeagueAdvInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LeagueAdvInfo record, @Param("example") LeagueAdvInfoExample example);

    int updateByExample(@Param("record") LeagueAdvInfo record, @Param("example") LeagueAdvInfoExample example);

    int updateByPrimaryKeySelective(LeagueAdvInfo record);

    int updateByPrimaryKey(LeagueAdvInfo record);

    //条件分页查询广告位信息记录
    List<LeagueAdvListModel> queryAdvInfosByKeywordPaged(@Param("industryId")Long industryId,@Param("typeId") Long typeId,@Param("offsetValue") Integer offsetValue,@Param("pageSize") Integer pageSize);
    //条件分页查询广告位信息记录
    int queryAdvInfosByKeywordPagedCount(@Param("industryId")Long industryId,@Param("typeId") Long typeId);
    
    
    LeagueAdvInfo queryAdvInfoById(@Param("id") Long id);
    
    void removeAdvPic(@Param("idList") List<Long> idList);
    
    //on_flag标识修改(用于定时调度)
    void updateOn();//修改为上线状态
    void updateOff();//修改为过期状态
}