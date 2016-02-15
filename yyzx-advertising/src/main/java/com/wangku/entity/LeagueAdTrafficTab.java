package com.wangku.entity;

import java.io.Serializable;
import java.util.Date;

public class LeagueAdTrafficTab extends WkYYZXModel implements Serializable{

	private static final long serialVersionUID = 6018697431131638701L;

	private Long id;

    private Long adId;

    private String adType;

    private Long siteId;

    private String ip;

    private String area;

    private Date visitTime;

    private Long yyzxAccountId;

    private String plwMember;
    
    private int visitNum;

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType == null ? null : adType.trim();
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public Long getYyzxAccountId() {
        return yyzxAccountId;
    }

    public void setYyzxAccountId(Long yyzxAccountId) {
        this.yyzxAccountId = yyzxAccountId;
    }

    public String getPlwMember() {
        return plwMember;
    }

    public void setPlwMember(String plwMember) {
        this.plwMember = plwMember == null ? null : plwMember.trim();
    }

	public int getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(int visitNum) {
		this.visitNum = visitNum;
	}

	@Override
	public String toString() {
		return "LeagueAdTrafficTab [id=" + id + ", adId=" + adId + ", adType=" + adType + ", siteId=" + siteId + ", ip="
				+ ip + ", area=" + area + ", visitTime=" + visitTime + ", yyzxAccountId=" + yyzxAccountId
				+ ", plwMember=" + plwMember + ", visitNum=" + visitNum + "]";
	}
	
	
}