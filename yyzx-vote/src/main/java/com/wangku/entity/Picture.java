package com.wangku.entity;

import java.util.Date;

public class Picture {
    private Long picId;

    private Long advId;

    private String picUrl;

    private String targetUrl;

    private String picName;

    private String title;

    private String text;

    private Integer picType;

    private String alt;

    private Date starttime;

    private Date endtime;

    private String comment;

    private Integer picOrder;

    public Long getPicId() {
        return picId;
    }

    public void setPicId(Long picId) {
        this.picId = picId;
    }

    public Long getAdvId() {
        return advId;
    }

    public void setAdvId(Long advId) {
        this.advId = advId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl == null ? null : targetUrl.trim();
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName == null ? null : picName.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Integer getPicType() {
        return picType;
    }

    public void setPicType(Integer picType) {
        this.picType = picType;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt == null ? null : alt.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getPicOrder() {
        return picOrder;
    }

    public void setPicOrder(Integer picOrder) {
        this.picOrder = picOrder;
    }

	@Override
	public String toString() {
		return "Picture [picId=" + picId + ", advId=" + advId + ", picUrl="
				+ picUrl + ", targetUrl=" + targetUrl + ", picName=" + picName
				+ ", title=" + title + ", text=" + text + ", picType="
				+ picType + ", alt=" + alt + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", comment=" + comment
				+ ", picOrder=" + picOrder + "]";
	}
    
    
}