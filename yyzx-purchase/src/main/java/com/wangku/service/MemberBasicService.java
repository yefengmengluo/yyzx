package com.wangku.service;

import com.wangku.entity.MemberBasic;
import com.wangku.jdbc.DataSource;

/**
 * @author zhp
 * 类描述：网库会员表查询
 */
public interface MemberBasicService {

	
	/**
	 * 
	 * @author：zhp  2015年11月20日 上午11:05:16
	 * @方法名： queryMemberBasicByMemberId
	 * @方法描述：根据会员ID查询会员信息
	 * @param:
	 * @返回值：MemberBasic
	 *
	 */
	@DataSource("slaveWkSysMeb")
	public MemberBasic  queryMemberBasicByMemberId(Long memberId)throws  Exception;
}
