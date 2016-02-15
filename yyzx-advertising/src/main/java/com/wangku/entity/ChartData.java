package com.wangku.entity;

import java.util.List;
/**
 * 
 * @author zsl
 * 2015年9月24日上午10:18:06
 * 类描述：指定广告位流量统计走势图model
 */
public class ChartData {
	private Long industryId;//行业Id
	private String industryName;//行业名称
	private List<String> dateList;//日期集合
	private List<Integer> numList;//流量统计集合
	public List<String> getDateList() {
		return dateList;
	}
	public void setDateList(List<String> dateList) {
		this.dateList = dateList;
	}
	public List<Integer> getNumList() {
		return numList;
	}
	public void setNumList(List<Integer> numList) {
		this.numList = numList;
	}
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
	
}
