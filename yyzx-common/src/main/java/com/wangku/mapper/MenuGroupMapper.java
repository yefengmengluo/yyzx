package com.wangku.mapper;

import com.wangku.entity.MenuGroup;
import com.wangku.entity.MenuGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuGroupMapper {
    int countByExample(MenuGroupExample example);

    int deleteByExample(MenuGroupExample example);

    int deleteByPrimaryKey(Integer groupId);

    int insert(MenuGroup record);

    int insertSelective(MenuGroup record);

    List<MenuGroup> selectByExample(MenuGroupExample example);

    MenuGroup selectByPrimaryKey(Integer groupId);

    int updateByExampleSelective(@Param("record") MenuGroup record, @Param("example") MenuGroupExample example);

    int updateByExample(@Param("record") MenuGroup record, @Param("example") MenuGroupExample example);

    int updateByPrimaryKeySelective(MenuGroup record);

    int updateByPrimaryKey(MenuGroup record);
}