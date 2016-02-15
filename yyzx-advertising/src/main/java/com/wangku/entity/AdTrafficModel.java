package com.wangku.entity;

import java.io.Serializable;
/**
 * 
 * @author zsl
 * 2015年9月15日下午3:52:48
 * 类描述：用于图片广告流量统计展示
 */
public class AdTrafficModel extends LeagueSize implements Serializable{

	private static final long serialVersionUID = -4071103001036903750L;
	private Integer advType;//广告位类型   0：图片广告位      1：文字广告位
	private Integer visitCount;//访问数量
	
	public Integer getAdvType() {
		return advType;
	}
	public void setAdvType(Integer advType) {
		this.advType = advType;
	}
	public Integer getVisitCount() {
		return visitCount;
	}
	public void setVisitCount(Integer visitCount) {
		this.visitCount = visitCount;
	}
	
}
