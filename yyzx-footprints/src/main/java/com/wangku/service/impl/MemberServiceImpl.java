package com.wangku.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangku.entity.Member;
import com.wangku.mapper.MemberMapper;
import com.wangku.service.MemberService;

/**
 * 会员服务实现。
 * 
 */
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public Member getMemberIdByName(String nickName) {
		List<Member> list=mapper.getMemberIdByName(nickName);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	
}
