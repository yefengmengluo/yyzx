package com.wangku.entity;

import java.io.Serializable;

/**
 * 
 * @author zsl
 * 2015年8月10日上午9:28:15
 * 类描述：广告数据model
 */
public class LeagueDataModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6464124140306563348L;
	private String picHeight;//图片的高度
	private String picWidth;//图片的宽度
	private String advName;//广告名称
	private String advCode;//广告位标识
	private String picUrl;//图片的存储路径
	private String targetUrl;//广告的链接路径
	private String title;//标题
    private String memo;//备注
	private Integer orderNum;//排序号
	private Long industryId;//行业ID
	private String industryName;//附加属性，保存行业名称
	private Long typeId;//类型ID
	private String typeName;//类型名称
	
	private long adID;//广告ID（用于广告流量统计）
	
	public String getPicHeight() {
		return picHeight;
	}
	public void setPicHeight(String picHeight) {
		this.picHeight = picHeight;
	}
	public String getPicWidth() {
		return picWidth;
	}
	public void setPicWidth(String picWidth) {
		this.picWidth = picWidth;
	}
	public String getAdvName() {
		return advName;
	}
	public void setAdvName(String advName) {
		this.advName = advName;
	}
	public String getAdvCode() {
		return advCode;
	}
	public void setAdvCode(String advCode) {
		this.advCode = advCode;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
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
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public long getAdID() {
		return adID;
	}
	public void setAdID(long adID) {
		this.adID = adID;
	}
	@Override
	public String toString() {
		return "LeagueDataModel [picHeight=" + picHeight + ", picWidth="
				+ picWidth + ", advName=" + advName + ", advCode=" + advCode
				+ ", picUrl=" + picUrl + ", targetUrl=" + targetUrl
				+ ", title=" + title + ", memo=" + memo + ", orderNum="
				+ orderNum + ", industryId=" + industryId + ", industryName="
				+ industryName + ", typeId=" + typeId + ", typeName="
				+ typeName  + ", adID=" + adID+ "]";
	}
	
	
}
