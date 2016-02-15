package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.LeagueAdvWord;
import com.wangku.entity.LeagueAdvWordExample;

public interface LeagueAdvWordMapper {
	int countByExample(LeagueAdvWordExample example);

	int deleteByExample(LeagueAdvWordExample example);

	int deleteByPrimaryKey(Long id);

	int insert(LeagueAdvWord record);

	int insertSelective(LeagueAdvWord record);

	List<LeagueAdvWord> selectByExample(LeagueAdvWordExample example);

	LeagueAdvWord selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") LeagueAdvWord record, @Param("example") LeagueAdvWordExample example);

	int updateByExample(@Param("record") LeagueAdvWord record, @Param("example") LeagueAdvWordExample example);

	int updateByPrimaryKeySelective(LeagueAdvWord record);

	int updateByPrimaryKey(LeagueAdvWord record);

	// 条件分页查询文字广告记录
	List<LeagueAdvWord> queryAdvWordsByKeywordPaged(@Param("industryId") Long industryId,@Param("titleKeyWod") String titleKeyWod,
			@Param("offsetValue") Integer offsetValue, @Param("pageSize") Integer pageSize);
	
	// 条件分页查询广告位信息记录
	int queryAdvWordsByKeywordPagedCount(@Param("industryId") Long industryId,@Param("titleKeyWod") String titleKeyWod);
	
	//文字广告查看页数据集合
	List<LeagueAdvWord> queryAdvWordsByIndustryIdAndAdvName(@Param("industryId") Long industryId,@Param("advName") String advName);
	
	//修改文字广告的排序号
	int updateWordAdvOrder(@Param("id") Long id,@Param("orderNum")Integer orderNum);
	
	////查询文字广告--用于单品网展示的文字广告记录
	List<LeagueAdvWord> queryWordAdvOnFlag(@Param("industryId") Long industryId,@Param("dataNum")Integer dataNum);
}