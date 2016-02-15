package com.wangku.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author zsl
 * 2015年7月24日上午10:19:27
 * 类描述：用于图片广告添加页面类型尺寸的展示
 */
public class AdvTypeAndSize implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4902948402229491310L;
	private Long advTypeId;//类型ID
	private String advType;//广告类型
	private List<AdvLeagueSize> leagueSizeList;//尺寸集合
	
	public Long getAdvTypeId() {
		return advTypeId;
	}
	public void setAdvTypeId(Long advTypeId) {
		this.advTypeId = advTypeId;
	}
	public String getAdvType() {
		return advType;
	}
	public void setAdvType(String advType) {
		this.advType = advType;
	}
	
	public List<AdvLeagueSize> getLeagueSizeList() {
		return leagueSizeList;
	}
	public void setLeagueSizeList(List<AdvLeagueSize> leagueSizeList) {
		this.leagueSizeList = leagueSizeList;
	}
	@Override
	public String toString() {
		return "AdvTypeAndSize [advTypeId=" + advTypeId + ", advType="
				+ advType + ", leagueSizeList=" + leagueSizeList + "]";
	}
	
	
}
