package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.VoteResultTable;
import com.wangku.entity.VoteResultTableExample;

public interface VoteResultTableMapper {
	
    int countByExample(VoteResultTableExample example);
	
    int deleteByExample(VoteResultTableExample example);
	
    int deleteByPrimaryKey(Long id);
	
    int insert(VoteResultTable record);
	
    int insertSelective(VoteResultTable record);
    
    List<VoteResultTable> selectByExample(VoteResultTableExample example);
    
    VoteResultTable selectByPrimaryKey(Long id);
    
    int updateByExampleSelective(@Param("record") VoteResultTable record, @Param("example") VoteResultTableExample example);
    
    int updateByExample(@Param("record") VoteResultTable record, @Param("example") VoteResultTableExample example);
    
    int updateByPrimaryKeySelective(VoteResultTable record);
    
    int updateByPrimaryKey(VoteResultTable record);
}