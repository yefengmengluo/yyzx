package com.wangku.entity;

import java.util.Date;

public class VoteTable {
    private Long id;

    private String vSubject;

    private String vSummary;

    private Byte vForever;

    private Date beginTime;

    private Date endTime;

    private Byte dataStatus;

    private Date dataAddTime;

    private Date dataModifyTime;

    private Date limitTime;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getvSubject() {
        return vSubject;
    }

    public void setvSubject(String vSubject) {
        this.vSubject = vSubject == null ? null : vSubject.trim();
    }

    public String getvSummary() {
        return vSummary;
    }

    public void setvSummary(String vSummary) {
        this.vSummary = vSummary == null ? null : vSummary.trim();
    }

    public Byte getvForever() {
        return vForever;
    }

    public void setvForever(Byte vForever) {
        this.vForever = vForever;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Byte dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Date getDataAddTime() {
        return dataAddTime;
    }

    public void setDataAddTime(Date dataAddTime) {
        this.dataAddTime = dataAddTime;
    }

    public Date getDataModifyTime() {
        return dataModifyTime;
    }

    public void setDataModifyTime(Date dataModifyTime) {
        this.dataModifyTime = dataModifyTime;
    }

    public Date getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Date limitTime) {
        this.limitTime = limitTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	@Override
	public String toString() {
		return "VoteTable [id=" + id + ", vSubject=" + vSubject + ", vSummary="
				+ vSummary + ", vForever=" + vForever + ", beginTime="
				+ beginTime + ", endTime=" + endTime + ", dataStatus="
				+ dataStatus + ", dataAddTime=" + dataAddTime
				+ ", dataModifyTime=" + dataModifyTime + ", limitTime="
				+ limitTime + ", userId=" + userId + "]";
	}
    
}