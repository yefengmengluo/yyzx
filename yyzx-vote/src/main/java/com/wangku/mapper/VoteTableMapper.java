package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.VoteTable;
import com.wangku.entity.VoteTableExample;

public interface VoteTableMapper {
	
	int countByExample(VoteTableExample example);
	
	int deleteByExample(VoteTableExample example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(VoteTable record);
	
	int insertSelective(VoteTable record);
	
	List<VoteTable> selectByExample(VoteTableExample example);
	
	VoteTable selectByPrimaryKey(Long id);
	
	int updateByExampleSelective(@Param("record") VoteTable record,@Param("example") VoteTableExample example);
	
	int updateByExample(@Param("record") VoteTable record,@Param("example") VoteTableExample example);
	
	int updateByPrimaryKeySelective(VoteTable record);
	
	int updateByPrimaryKey(VoteTable record);

	/**
	 * @author： 徐国辉 2015-6-18 下午2:49:22
	 * @方法名： selectWithKeyWordPaged
	 * @方法描述：超级管理员 关键字分页查询
	 * @param:
	 * @返回值：List<VoteTable>
	 */
	
	List<VoteTable> selectWithKeyWordPaged(@Param("keyWord") String keyWord,
			@Param("offsetValue") Integer offsetValue,@Param("pageSize") Integer pageSize);

	/**
	 * @author： 徐国辉 2015-6-18 下午2:49:22
	 * @方法名： selectWithKeyWordPaged
	 * @方法描述：普通用户 关键字分页查询
	 * @param:
	 * @返回值：List<VoteTable>
	 */
	
	List<VoteTable> selectSomeWithKeyWordPaged(@Param("keyWord") String keyWord,
			@Param("offsetValue") Integer offsetValue,
			@Param("pageSize") Integer pageSize, @Param("userId") Long userId);
}