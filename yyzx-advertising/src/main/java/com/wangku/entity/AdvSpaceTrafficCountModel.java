package com.wangku.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author zsl
 * 2015年9月16日上午11:41:46
 * 类描述：用于展示指定广告位下广告流量统计
 */
public class AdvSpaceTrafficCountModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 223863890947251345L;
	private Long industryId;//行业ID
	private String industryName;//行业名称
	private Integer advAllTrafficCount;//指定行业下的广告总流量
	private List<AdvTrafficCountModel> trafficModel;
	public Long getIndustryId() {
		return industryId;
	}
	public void setIndustryId(Long industryId) {
		this.industryId = industryId;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	
	public Integer getAdvAllTrafficCount() {
		return advAllTrafficCount;
	}
	public void setAdvAllTrafficCount(Integer advAllTrafficCount) {
		this.advAllTrafficCount = advAllTrafficCount;
	}
	public List<AdvTrafficCountModel> getTrafficModel() {
		return trafficModel;
	}
	public void setTrafficModel(List<AdvTrafficCountModel> trafficModel) {
		this.trafficModel = trafficModel;
	}
	

}
