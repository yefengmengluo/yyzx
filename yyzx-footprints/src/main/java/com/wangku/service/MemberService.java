package com.wangku.service;

import com.wangku.entity.Member;
import com.wangku.jdbc.DataSource;

public interface MemberService {
	@DataSource("slaveWkSysMeb")
	public Member getMemberIdByName(String nickName);
	
}
