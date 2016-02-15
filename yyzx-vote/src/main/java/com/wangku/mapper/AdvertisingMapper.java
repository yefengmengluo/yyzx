package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.Advertising;
import com.wangku.entity.AdvertisingExample;

public interface AdvertisingMapper {
	
    int countByExample(AdvertisingExample example);
	
    int deleteByExample(AdvertisingExample example);
	
    int deleteByPrimaryKey(Long advId);
	
    int insert(Advertising record);
	
    int insertSelective(Advertising record);
    
    List<Advertising> selectByExample(AdvertisingExample example);
    
    Advertising selectByPrimaryKey(Long advId);
    
    int updateByExampleSelective(@Param("record") Advertising record, @Param("example") AdvertisingExample example);
    
    int updateByExample(@Param("record") Advertising record, @Param("example") AdvertisingExample example);
    
    int updateByPrimaryKeySelective(Advertising record);
    
    int updateByPrimaryKey(Advertising record);
    
    //根据频道名称和主题id查询当前主题下指定频道广告位的最大序号，用于添加广告位时排序
    Integer queryMaxAdvOrder(@Param("channelName") Integer channelName,@Param("vId") Long vId);
    
    //查询已经失效的广告位记录(查询出来的结果集将被定时清理，详细功能介绍请见AdvertisingDeleteScheduled类的类级注释)
    List<Advertising> selectInvalidAdvs();
}