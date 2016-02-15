package com.wangku.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author zsl
 * 2015年7月27日上午10:25:05
 * 类描述：用于展现广告类型尺寸列表
 */
public class AdvLeagueSize implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = -4813519485219572975L;

	private String advSize;

    private String sizeCode;

    private Integer linkStatus;//尺寸是否存在          0：不存在   1：存在
       
    private Integer onFlag;//尺寸是否被占用              0：没有被占用    2：被占用

	public String getAdvSize() {
		return advSize;
	}

	public void setAdvSize(String advSize) {
		this.advSize = advSize;
	}

	public String getSizeCode() {
		return sizeCode;
	}

	public void setSizeCode(String sizeCode) {
		this.sizeCode = sizeCode;
	}

	public Integer getLinkStatus() {
		return linkStatus;
	}

	public void setLinkStatus(Integer linkStatus) {
		this.linkStatus = linkStatus;
	}

	public Integer getOnFlag() {
		return onFlag;
	}

	public void setOnFlag(Integer onFlag) {
		this.onFlag = onFlag;
	}

	@Override
	public String toString() {
		return "AdvLeagueSize [advSize=" + advSize + ", sizeCode=" + sizeCode
				+ ", linkStatus=" + linkStatus + ", onFlag=" + onFlag + "]";
	}
    
    
    
}
