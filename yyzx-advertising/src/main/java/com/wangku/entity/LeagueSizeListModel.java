package com.wangku.entity;

import java.io.Serializable;
/**
 * 
 * @author zsl
 * 2015年7月29日下午1:26:46
 * 类描述：用于广告管理展现尺寸列表
 */
public class LeagueSizeListModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long industryId;//行业id
	private Long typeId;//类型id
	private String sizeListStr;//尺寸集合的字符串
	public String getSizeListStr() {
		return sizeListStr;
	}
	public void setSizeListStr(String sizeListStr) {
		this.sizeListStr = sizeListStr;
	}
	
	public Long getIndustryId() {
		return industryId;
	}
	public void setIndustryId(Long industryId) {
		this.industryId = industryId;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	@Override
	public String toString() {
		return "LeagueSizeListModel3 [industryId=" + industryId + ", typeId="
				+ typeId + ", sizeListStr=" + sizeListStr + "]";
	}
	
}
