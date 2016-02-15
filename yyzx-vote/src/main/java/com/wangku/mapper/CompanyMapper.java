package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.Company;
import com.wangku.entity.CompanyExample;

public interface CompanyMapper {
	
	int countByExample(CompanyExample example);
	
	int deleteByExample(CompanyExample example);
	
	int deleteByPrimaryKey(Long copId);
	
	int insert(Company record);
	
	int insertSelective(Company record);
	
	List<Company> selectByExample(CompanyExample example);
	
	Company selectByPrimaryKey(Long copId);
	
	int updateByExampleSelective(@Param("record") Company record,
			@Param("example") CompanyExample example);
	
	int updateByExample(@Param("record") Company record,
			@Param("example") CompanyExample example);
	
	int updateByPrimaryKeySelective(Company record);
	
	int updateByPrimaryKey(Company record);
	
	void deleteVoteItem(@Param("idList") List<Long> idList);
	
	void modifyCompanyStatus(@Param("idList") List<Long> idList,
			@Param("status") int status);
	
	List<Company> queryByPage(@Param("keyWord") String keyWord,
			@Param("offsetValue") int offsetValue, @Param("pageSize") int pageSize,@Param("userId") Long userId);
}