package com.wangku.entity;

import java.util.Date;

public class SpecialLiuYan {
    private Long lyId;

    private Long siteId;

    private Long specId;

    private String copName;

    private String linkman;

    private String mobile;

    private String comment;

    private String tag;

    private Integer sort;

    private Integer status;

    private Date creatTime;

    private Date endTime;

    private Long userId;

    public Long getLyId() {
        return lyId;
    }

    public void setLyId(Long lyId) {
        this.lyId = lyId;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public String getCopName() {
        return copName;
    }

    public void setCopName(String copName) {
        this.copName = copName == null ? null : copName.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	@Override
	public String toString() {
		return "SpecialLiuYan [lyId=" + lyId + ", siteId=" + siteId
				+ ", specId=" + specId + ", copName=" + copName + ", linkman="
				+ linkman + ", mobile=" + mobile + ", comment=" + comment
				+ ", tag=" + tag + ", sort=" + sort + ", status=" + status
				+ ", creatTime=" + creatTime + ", endTime=" + endTime
				+ ", userId=" + userId + "]";
	}
    
    
}