package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.VoteSequence;
import com.wangku.entity.VoteSequenceExample;

public interface VoteSequenceMapper {
	
    int countByExample(VoteSequenceExample example);
	
    int deleteByExample(VoteSequenceExample example);
	
    int deleteByPrimaryKey(String seqName);
	
    int insert(VoteSequence record);
	
    int insertSelective(VoteSequence record);
    
    List<VoteSequence> selectByExample(VoteSequenceExample example);
    
    VoteSequence selectByPrimaryKey(String seqName);
    
    int updateByExampleSelective(@Param("record") VoteSequence record, @Param("example") VoteSequenceExample example);
    
    int updateByExample(@Param("record") VoteSequence record, @Param("example") VoteSequenceExample example);
    
    int updateByPrimaryKeySelective(VoteSequence record);
    
    int updateByPrimaryKey(VoteSequence record);
}