package com.wangku.entity;

import java.io.Serializable;
import java.util.Date;

public class LeagueSize extends AdvLeagueSize implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1875094838297419001L;

	private Long id;

    private Long industryId;

    private String industryName;
    
    private Long typeId;

    private String typeName;

    private Date createTime;

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

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName == null ? null : industryName.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "LeagueSize [id=" + id + ", industryId=" + industryId
				+ ", industryName=" + industryName + ", typeId=" + typeId
				+ ", typeName=" + typeName + ", createTime=" + createTime + "]";
	}

	
    
}