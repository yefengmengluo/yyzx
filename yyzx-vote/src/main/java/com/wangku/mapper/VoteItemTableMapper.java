package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.Company;
import com.wangku.entity.VoteItemTable;
import com.wangku.entity.VoteItemTableExample;
import com.wangku.entity.VoteItemTableWithBLOBs;

public interface VoteItemTableMapper {
	
    int countByExample(VoteItemTableExample example);

    int deleteByExample(VoteItemTableExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VoteItemTableWithBLOBs record);

    int insertSelective(VoteItemTableWithBLOBs record);
    
    List<VoteItemTableWithBLOBs> selectByExampleWithBLOBs(VoteItemTableExample example);
    
    List<VoteItemTable> selectByExample(VoteItemTableExample example);
    
    VoteItemTableWithBLOBs selectByPrimaryKey(Long id);
    
    int updateByExampleSelective(@Param("record") VoteItemTableWithBLOBs record, @Param("example") VoteItemTableExample example);
    
    int updateByExampleWithBLOBs(@Param("record") VoteItemTableWithBLOBs record, @Param("example") VoteItemTableExample example);
    
    int updateByExample(@Param("record") VoteItemTable record, @Param("example") VoteItemTableExample example);
    
    int updateByPrimaryKeySelective(VoteItemTableWithBLOBs record);
    
    int updateByPrimaryKeyWithBLOBs(VoteItemTableWithBLOBs record);
    
    int updateByPrimaryKey(VoteItemTable record);
    
    void modifyItemVoteIdByCopIdList(@Param("voteId") Long voteId,@Param("copIdList") List<Long> copIdList);
    
    List<VoteItemTable> queryByPage(@Param("keyWord") String keyWord,@Param("voteId") long voteId,
			@Param("offsetValue") int offsetValue, @Param("pageSize") int pageSize);
    
    void modifyCompanyStatusByItemIdList(@Param("status") int status,@Param("viidList") List<Long> viidList);
    
    void modifyItemByItemIdList(@Param("viidList") List<Long> viidList);
    
    List<Company> queryCompanyByViidList(@Param("viidList") List<Long> viidList);
    
    int modifyCount(@Param("id")long id,@Param("vdCount") int vdCount);
    
    List<Long> queryItemByVid(@Param("vId") long vId);
}