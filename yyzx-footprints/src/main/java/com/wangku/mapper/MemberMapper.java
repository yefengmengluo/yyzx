package com.wangku.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.Member;

public interface MemberMapper {

    List<Member> getMemberIdByName(@Param("account")String account);

 }