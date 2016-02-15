package com.wangku.entity;

import java.io.Serializable;
import java.util.Date;

public class LeaguePram implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6924292527082332217L;

	private Long id;

    private String paramName;

    private Integer paramType;

    private Date createTime;

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
        this.paramName = paramName == null ? null : paramName.trim();
    }

    public Integer getParamType() {
        return paramType;
    }

    public void setParamType(Integer paramType) {
        this.paramType = paramType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "LeaguePram [id=" + id + ", paramName=" + paramName + ", paramType=" + paramType + ", createTime="
				+ createTime + "]";
	}
    
}