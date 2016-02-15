package com.wangku.entity;

import java.util.Date;

public class Company {
    private Long copId;

    private String copName;

    private String copBrand;

    private Integer industry;

    private String copUrl;

    private String copAddress;

    private String brandIndustry;

    private String copSummary;

    private String copEvents;

    private String logo;

    private String weixinPic;

    private String weiboPic;

    private String erweimaPic;

    private Date addTime;

    private Integer status;

    private Long viId;

    private Long userId;
    
    
    private Long voteId;//投票主题Id
    
    private String voteName;//投票主题名称

    public String getVoteName() {
		return voteName;
	}

	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}

	public Long getVoteId() {
		return voteId;
	}

	public void setVoteId(Long voteId) {
		this.voteId = voteId;
	}

	public Long getCopId() {
        return copId;
    }

    public void setCopId(Long copId) {
        this.copId = copId;
    }

    public String getCopName() {
        return copName;
    }

    public void setCopName(String copName) {
        this.copName = copName == null ? null : copName.trim();
    }

    public String getCopBrand() {
        return copBrand;
    }

    public void setCopBrand(String copBrand) {
        this.copBrand = copBrand == null ? null : copBrand.trim();
    }

    public Integer getIndustry() {
        return industry;
    }

    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    public String getCopUrl() {
        return copUrl;
    }

    public void setCopUrl(String copUrl) {
        this.copUrl = copUrl == null ? null : copUrl.trim();
    }

    public String getCopAddress() {
        return copAddress;
    }

    public void setCopAddress(String copAddress) {
        this.copAddress = copAddress == null ? null : copAddress.trim();
    }

    public String getBrandIndustry() {
        return brandIndustry;
    }

    public void setBrandIndustry(String brandIndustry) {
        this.brandIndustry = brandIndustry == null ? null : brandIndustry.trim();
    }

    public String getCopSummary() {
        return copSummary;
    }

    public void setCopSummary(String copSummary) {
        this.copSummary = copSummary == null ? null : copSummary.trim();
    }

    public String getCopEvents() {
        return copEvents;
    }

    public void setCopEvents(String copEvents) {
        this.copEvents = copEvents == null ? null : copEvents.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getWeixinPic() {
        return weixinPic;
    }

    public void setWeixinPic(String weixinPic) {
        this.weixinPic = weixinPic == null ? null : weixinPic.trim();
    }

    public String getWeiboPic() {
        return weiboPic;
    }

    public void setWeiboPic(String weiboPic) {
        this.weiboPic = weiboPic == null ? null : weiboPic.trim();
    }

    public String getErweimaPic() {
        return erweimaPic;
    }

    public void setErweimaPic(String erweimaPic) {
        this.erweimaPic = erweimaPic == null ? null : erweimaPic.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getViId() {
        return viId;
    }

    public void setViId(Long viId) {
        this.viId = viId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	@Override
	public String toString() {
		return "Company [copId=" + copId + ", copName=" + copName
				+ ", copBrand=" + copBrand + ", industry=" + industry
				+ ", copUrl=" + copUrl + ", copAddress=" + copAddress
				+ ", brandIndustry=" + brandIndustry + ", copSummary="
				+ copSummary + ", copEvents=" + copEvents + ", logo=" + logo
				+ ", weixinPic=" + weixinPic + ", weiboPic=" + weiboPic
				+ ", erweimaPic=" + erweimaPic + ", addTime=" + addTime
				+ ", status=" + status + ", viId=" + viId + ", userId="
				+ userId + ", voteId=" + voteId + "]";
	}
    
}