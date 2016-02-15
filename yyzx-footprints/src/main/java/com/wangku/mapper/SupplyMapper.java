package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.Supply;

public interface SupplyMapper {
   
	List<Supply> selectByPrimaryKey(@Param("ids") List<Long> ids,@Param("orderIds") String orderIds);

}