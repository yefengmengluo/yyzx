package com.wangku.mapper;

import com.wangku.entity.LeaguePram;
import com.wangku.entity.LeaguePramExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LeaguePramMapper {
    int countByExample(LeaguePramExample example);

    int deleteByExample(LeaguePramExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LeaguePram record);

    int insertSelective(LeaguePram record);

    List<LeaguePram> selectByExample(LeaguePramExample example);

    LeaguePram selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LeaguePram record, @Param("example") LeaguePramExample example);

    int updateByExample(@Param("record") LeaguePram record, @Param("example") LeaguePramExample example);

    int updateByPrimaryKeySelective(LeaguePram record);

    int updateByPrimaryKey(LeaguePram record);
/**
 * 
 * @author： zsl  2015年8月3日 下午3:32:24
 * @方法名： modifyLeagueSizePramNameById
 * @方法描述：根据参数ID修改尺寸表中对应的参数名
 * @param:
 * @返回值：void
 *
 */
	void modifyLeagueSizePramNameById(@Param("abc") int abc,@Param("id") Long id,@Param("paramName") String paramName);
	/**
	 * 
	 * @author： zsl  2015年9月7日 下午1:37:00
	 * @方法名： querySizeCountByParamId
	 * @方法描述：根据参数ID查询有无尺寸信息
	 * @param:
	 * @返回值：int
	 *
	 */
	int querySizeCountByParamId(@Param("paramType") int paramType,@Param("id") Long id);
	
	/**
	 * 
	 * @author： zsl  2015年9月7日 下午1:37:00
	 * @方法名： querySizeCountByParamId
	 * @方法描述：根据行业ID查询有无文字广告信息
	 * @param:
	 * @返回值：int
	 *
	 */
	int queryWordCountByParamId(@Param("industryId") Long industryId);
}