package com.wangku.entity;

import java.io.Serializable;
import java.util.Date;

public class LeagueWebsite extends WkYYZXModel implements Serializable{
   
	private static final long serialVersionUID = 670827138904965116L;

	private Long id;

    private String siteUrl;

    private String siteName;

    private String jdBelong;

    private Long industryId;

    private Date createTime;

    private Date updateTime;

    private String optPerson;
    
    private String industryName;

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

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl == null ? null : siteUrl.trim();
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getJdBelong() {
        return jdBelong;
    }

    public void setJdBelong(String jdBelong) {
        this.jdBelong = jdBelong == null ? null : jdBelong.trim();
    }

    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }

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

    public String getOptPerson() {
        return optPerson;
    }

    public void setOptPerson(String optPerson) {
        this.optPerson = optPerson == null ? null : optPerson.trim();
    }

	@Override
	public String toString() {
		return "LeagueWebsite [id=" + id + ", siteUrl=" + siteUrl
				+ ", siteName=" + siteName + ", jdBelong=" + jdBelong
				+ ", industryId=" + industryId + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", optPerson=" + optPerson
				+ ", industryName=" + industryName + "]";
	}
    
    
    
}