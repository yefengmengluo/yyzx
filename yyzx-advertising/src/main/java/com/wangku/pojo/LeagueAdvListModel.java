package com.wangku.pojo;

import java.util.Date;

/**
 * 展示广告列表的实体类
 * 
 * @author 徐国辉
 * @version 2015年7月30日
 */
public class LeagueAdvListModel {

	private Long id;// 广告位ID

	private String advName;// 广告名称

	private String typeName;// 广告类型名称

	private String targetUrl;// 目标URL

	private String picUrl;//图片路径
	
	private Integer industryId;// 行业id

	private String industryName;// 行业名称

	private String paramName;// 文字广告的行业名称

	private Integer onFlag;// 占用标识：0:未占用,1:,2:占用

	private Date startTime;// 发布时间

	private Date endTime;// 结束时间

	private Date createTime;// 创建时间

	private String advCode;// 广告位编码

	private String sizeId;// 尺寸id

	private String advSize;//广告尺寸
	
	
	/**
	 * @return the advSize
	 */
	public String getAdvSize() {
		return advSize;
	}

	/**
	 * @param advSize the advSize to set
	 */
	public void setAdvSize(String advSize) {
		this.advSize = advSize;
	}

	/**
	 * @return the picUrl
	 */
	public String getPicUrl() {
		return picUrl;
	}

	/**
	 * @param picUrl the picUrl to set
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public Integer getOnFlag() {
		return onFlag;
	}

	public void setOnFlag(Integer onFlag) {
		this.onFlag = onFlag;
	}

	public String getAdvName() {
		return advName;
	}

	public void setAdvName(String advName) {
		this.advName = advName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAdvCode() {
		return advCode;
	}

	public void setAdvCode(String advCode) {
		this.advCode = advCode;
	}

	public String getSizeId() {
		return sizeId;
	}

	public void setSizeId(String sizeId) {
		this.sizeId = sizeId;
	}

	@Override
	public String toString() {
		return "LeagueAdvListModel [advName=" + advName + ", typeName=" + typeName + ", targetUrl=" + targetUrl
				+ ", industryId=" + industryId + ", industryName=" + industryName + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", createTime=" + createTime + ", advCode=" + advCode + ", sizeId=" + sizeId
				+ "]";
	}

}
