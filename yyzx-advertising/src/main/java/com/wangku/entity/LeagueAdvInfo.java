package com.wangku.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class LeagueAdvInfo implements Serializable{
	private Long id;

	private Long sizeId;

	private String advName;

	private String advCode;

	private String title;

	private String picName;

	private String picUrl;

	private String targetUrl;

	private String memo;

	private Integer onFlag;

	private Integer redFlag;

	private Integer orderNum;

	private Date createTime;

	private Date startTime;

	private Date endTime;
	
	
	private String industryName;//行业名称
	private String advSize;//尺寸
	private String typeName;//广告类型
	

	public String getAdvSize() {
		return advSize;
	}

	public void setAdvSize(String advSize) {
		this.advSize = advSize;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

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

	public Long getSizeId() {
		return sizeId;
	}

	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}

	public String getAdvName() {
		return advName;
	}

	public void setAdvName(String advName) {
		this.advName = advName == null ? null : advName.trim();
	}

	public String getAdvCode() {
		return advCode;
	}

	public void setAdvCode(String advCode) {
		this.advCode = advCode == null ? null : advCode.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName == null ? null : picName.trim();
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl == null ? null : picUrl.trim();
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

	/**
	 * @author： 谢虹英  2015年8月11日 上午10:59:27
	 * @方法名： toString
	 * @方法描述：
	 * @param:
	 * @返回值：
	 *
	 */
	@Override
	public String toString() {
		return "LeagueAdvInfo [id=" + id + ", sizeId=" + sizeId + ", advName=" + advName + ", advCode=" + advCode
				+ ", title=" + title + ", picName=" + picName + ", picUrl=" + picUrl + ", targetUrl=" + targetUrl
				+ ", memo=" + memo + ", onFlag=" + onFlag + ", redFlag=" + redFlag + ", orderNum=" + orderNum
				+ ", createTime=" + createTime + ", startTime=" + startTime + ", endTime=" + endTime + ", industryName="
				+ industryName + ", advSize=" + advSize + ", typeName=" + typeName 
				+ "]";
	}
	
}