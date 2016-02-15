package com.wangku.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.PrintCount;

import com.wangku.jdbc.DataSource;

public interface PrintCountMapper {
    
    void deleteByPrimaryKey(Long supplyId);

    void insert(PrintCount record);
    
    int countBySupplyId();
    
    List<PrintCount> selectByPage(@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);
 
    PrintCount selectByPrimaryKey(Long supplyId);

    int updateByPrimaryKey(PrintCount record);
}