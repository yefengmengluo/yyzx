package com.wangku.mapper;

import com.wangku.entity.Propurchase;
import com.wangku.entity.PropurchaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PropurchaseMapper {
    int countByExample(PropurchaseExample example);

    int deleteByExample(PropurchaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Propurchase record);

    int insertSelective(Propurchase record);

    List<Propurchase> selectByExample(PropurchaseExample example);

    Propurchase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Propurchase record, @Param("example") PropurchaseExample example);

    int updateByExample(@Param("record") Propurchase record, @Param("example") PropurchaseExample example);

    int updateByPrimaryKeySelective(Propurchase record);

    int updateByPrimaryKey(Propurchase record);
    List<Propurchase> selectPropurchaseBySiteId(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize, @Param("siteId") Integer siteId,@Param("status") Integer status);
}