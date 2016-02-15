package com.wangku.entity;

import java.util.Date;

public class MemberBasic {
    private Long memberId;

    private String corporationName;

    private String url;

    private Integer siteId;

    private Date addTime;

    private Date modifyTime;

    private String logo;

    private String fax;

    private String enrollId;

    private String dealInId;

    private String categoryCode;

    private String summary;

    private String pictureUrl;

    private String regNumber;

    private String helpId;

    private String enName;

    private String accreditNumber;

    private Integer status;

    private String icp;

    private String artificialPerson;

    private String trafficUrl;

    private String trafficInfo;

    private String dealInAddress;

    private String dealInAreaCode;

    private Date times;

    private Boolean flag;

    private String orgWeb;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName == null ? null : corporationName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(String enrollId) {
        this.enrollId = enrollId == null ? null : enrollId.trim();
    }

    public String getDealInId() {
        return dealInId;
    }

    public void setDealInId(String dealInId) {
        this.dealInId = dealInId == null ? null : dealInId.trim();
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber == null ? null : regNumber.trim();
    }

    public String getHelpId() {
        return helpId;
    }

    public void setHelpId(String helpId) {
        this.helpId = helpId == null ? null : helpId.trim();
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    public String getAccreditNumber() {
        return accreditNumber;
    }

    public void setAccreditNumber(String accreditNumber) {
        this.accreditNumber = accreditNumber == null ? null : accreditNumber.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIcp() {
        return icp;
    }

    public void setIcp(String icp) {
        this.icp = icp == null ? null : icp.trim();
    }

    public String getArtificialPerson() {
        return artificialPerson;
    }

    public void setArtificialPerson(String artificialPerson) {
        this.artificialPerson = artificialPerson == null ? null : artificialPerson.trim();
    }

    public String getTrafficUrl() {
        return trafficUrl;
    }

    public void setTrafficUrl(String trafficUrl) {
        this.trafficUrl = trafficUrl == null ? null : trafficUrl.trim();
    }

    public String getTrafficInfo() {
        return trafficInfo;
    }

    public void setTrafficInfo(String trafficInfo) {
        this.trafficInfo = trafficInfo == null ? null : trafficInfo.trim();
    }

    public String getDealInAddress() {
        return dealInAddress;
    }

    public void setDealInAddress(String dealInAddress) {
        this.dealInAddress = dealInAddress == null ? null : dealInAddress.trim();
    }

    public String getDealInAreaCode() {
        return dealInAreaCode;
    }

    public void setDealInAreaCode(String dealInAreaCode) {
        this.dealInAreaCode = dealInAreaCode == null ? null : dealInAreaCode.trim();
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getOrgWeb() {
        return orgWeb;
    }

    public void setOrgWeb(String orgWeb) {
        this.orgWeb = orgWeb == null ? null : orgWeb.trim();
    }
}