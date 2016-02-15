package com.wangku.entity;

import java.io.Serializable;
import java.util.Date;

public class LeagueAdvWord implements Serializable{
	private Long id;

	private Long industryId;

	private String advName;

	private String title;

	private String targetUrl;

	private String memo;

	private Integer onFlag;

	private Integer redFlag;

	private Integer orderNum;

	private Date createTime;

	private Date startTime;

	private Date endTime;

	private String industryName;//附加属性，保存行业名称

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Long industryId) {
		this.industryId = industryId;
	}

	public String getAdvName() {
		return advName;
	}

	public void setAdvName(String advName) {
		this.advName = advName == null ? null : advName.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl == null ? null : targetUrl.trim();
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}

	public Integer getOnFlag() {
		return onFlag;
	}

	public void setOnFlag(Integer onFlag) {
		this.onFlag = onFlag;
	}

	public Integer getRedFlag() {
		return redFlag;
	}

	public void setRedFlag(Integer redFlag) {
		this.redFlag = redFlag;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "LeagueAdvWord [id=" + id + ", industryId=" + industryId + ", advName=" + advName + ", title=" + title
				+ ", targetUrl=" + targetUrl + ", memo=" + memo + ", onFlag=" + onFlag + ", redFlag=" + redFlag
				+ ", orderNum=" + orderNum + ", createTime=" + createTime + ", startTime=" + startTime + ", endTime="
				+ endTime + ", industryName=" + industryName + "]";
	}
	
}