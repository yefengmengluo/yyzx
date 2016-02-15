package com.wangku.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangku.entity.MemberBasic;
import com.wangku.mapper.MemberBasicMapper;
import com.wangku.service.MemberBasicService;
/**
 * @author zhp
 * 类描述：网库会员表查询
 */
@Service("memberBasicService")
public class MemberBasicServiceImpl implements MemberBasicService{
	
	@Autowired 	private  MemberBasicMapper  memberBasicMapper;
	
	/**
	 * 
	 * @author：zhp  2015年11月20日 上午11:05:16
	 * @方法名： queryMemberBasicByMemberId
	 * @方法描述：根据会员ID查询会员信息
	 * @param:
	 * @返回值：MemberBasic
	 *
	 */
	@Override
	public MemberBasic queryMemberBasicByMemberId(Long memberId) throws Exception {
	
		return memberBasicMapper.selectByPrimaryKey(memberId);
	}

}
