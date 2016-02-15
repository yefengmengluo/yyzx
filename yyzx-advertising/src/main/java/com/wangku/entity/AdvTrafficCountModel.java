package com.wangku.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告统计实体
 * @author zsl
 * 2015年9月16日上午11:57:02
 * 类描述：
 */
public class AdvTrafficCountModel extends LeagueAdvInfo implements Serializable{
	
	private static final long serialVersionUID = 4634542589778390945L;
	
//	private Long id;//广告ID
//	private String advName;//广告名
//	private Date createTime;//创建时间
	private String userName;//用户名
	private Integer advOneTrafficCount;//每个广告的流量统计数
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAdvOneTrafficCount() {
		return advOneTrafficCount;
	}
	public void setAdvOneTrafficCount(Integer advOneTrafficCount) {
		this.advOneTrafficCount = advOneTrafficCount;
	}
	
}
