package com.wangku.mapper;

import com.wangku.entity.MemberBasic;
import com.wangku.entity.MemberBasicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberBasicMapper {
    int countByExample(MemberBasicExample example);

    int deleteByExample(MemberBasicExample example);

    int deleteByPrimaryKey(Long memberId);

    int insert(MemberBasic record);

    int insertSelective(MemberBasic record);

    List<MemberBasic> selectByExample(MemberBasicExample example);

    MemberBasic selectByPrimaryKey(Long memberId);

    int updateByExampleSelective(@Param("record") MemberBasic record, @Param("example") MemberBasicExample example);

    int updateByExample(@Param("record") MemberBasic record, @Param("example") MemberBasicExample example);

    int updateByPrimaryKeySelective(MemberBasic record);

    int updateByPrimaryKey(MemberBasic record);
}