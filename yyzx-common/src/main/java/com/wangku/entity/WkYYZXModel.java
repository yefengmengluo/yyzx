package com.wangku.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 公共字段的封装
 */
public class WkYYZXModel implements Serializable{
	
	private static final long serialVersionUID = -6643387203057692155L;
	private Integer delFlag;//删除标识   0 未删除  1 删除
	private Date createTime;
	private Date updateTime;
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public WkYYZXModel() {
		this.delFlag = 0;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 设置默认的删除标识。
	 * <p>
	 * 默认值为0。
	 */
	public void setDefaultDelFlag() {
		this.delFlag = 0;
	}

	/**
	 * 设置创建时间为当前时间。
	 */
	public void setCrtTime() {
		this.createTime = new Date();
	}

	/**
	 * 设置更新时间为更新时间。
	 */
	public void setUpTime() {
		this.updateTime = new Date();
	}
}
