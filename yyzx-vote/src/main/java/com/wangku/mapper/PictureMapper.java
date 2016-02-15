package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.Picture;
import com.wangku.entity.PictureExample;

public interface PictureMapper {
	
    int countByExample(PictureExample example);
	
    int deleteByExample(PictureExample example);
	
    int deleteByPrimaryKey(Long picId);
	
    int insert(Picture record);
	
    int insertSelective(Picture record);
    
    List<Picture> selectByExample(PictureExample example);
    
    Picture selectByPrimaryKey(Long picId);
    
    int updateByExampleSelective(@Param("record") Picture record, @Param("example") PictureExample example);
    
    int updateByExample(@Param("record") Picture record, @Param("example") PictureExample example);
    
    int updateByPrimaryKeySelective(Picture record);
    
    int updateByPrimaryKey(Picture record);
}