package com.wangku.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Propurchase {
    private Integer id;

    private Long memberId;

    private String title;

    private String picture;

    private String summary;

    private String deliveryAddr;

    private String supplierAddr;

    private String requirement;

    private String linkman;

    private String tel;

    private Boolean showContact;

    private Date endTime;

    private Date addTime;

    private Date modifyTime;

    private Integer quoteTimes;

    private Integer status;

    private Integer siteId;

    private Date times;

    private String source;

    private BigDecimal purchaseAmount;

    private String purchaseAmountUnit;

    private String invoiceRequest;

    private String sampleRequest;

    private String telAreaCode;

    private String telFixedNumber;

    private Byte dataType;

    private Byte isPush;

    private Integer pushCount;

    private Byte isContact;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getDeliveryAddr() {
        return deliveryAddr;
    }

    public void setDeliveryAddr(String deliveryAddr) {
        this.deliveryAddr = deliveryAddr == null ? null : deliveryAddr.trim();
    }

    public String getSupplierAddr() {
        return supplierAddr;
    }

    public void setSupplierAddr(String supplierAddr) {
        this.supplierAddr = supplierAddr == null ? null : supplierAddr.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Boolean getShowContact() {
        return showContact;
    }

    public void setShowContact(Boolean showContact) {
        this.showContact = showContact;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public Integer getQuoteTimes() {
        return quoteTimes;
    }

    public void setQuoteTimes(Integer quoteTimes) {
        this.quoteTimes = quoteTimes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getPurchaseAmountUnit() {
        return purchaseAmountUnit;
    }

    public void setPurchaseAmountUnit(String purchaseAmountUnit) {
        this.purchaseAmountUnit = purchaseAmountUnit == null ? null : purchaseAmountUnit.trim();
    }

    public String getInvoiceRequest() {
        return invoiceRequest;
    }

    public void setInvoiceRequest(String invoiceRequest) {
        this.invoiceRequest = invoiceRequest == null ? null : invoiceRequest.trim();
    }

    public String getSampleRequest() {
        return sampleRequest;
    }

    public void setSampleRequest(String sampleRequest) {
        this.sampleRequest = sampleRequest == null ? null : sampleRequest.trim();
    }

    public String getTelAreaCode() {
        return telAreaCode;
    }

    public void setTelAreaCode(String telAreaCode) {
        this.telAreaCode = telAreaCode == null ? null : telAreaCode.trim();
    }

    public String getTelFixedNumber() {
        return telFixedNumber;
    }

    public void setTelFixedNumber(String telFixedNumber) {
        this.telFixedNumber = telFixedNumber == null ? null : telFixedNumber.trim();
    }

    public Byte getDataType() {
        return dataType;
    }

    public void setDataType(Byte dataType) {
        this.dataType = dataType;
    }

    public Byte getIsPush() {
        return isPush;
    }

    public void setIsPush(Byte isPush) {
        this.isPush = isPush;
    }

    public Integer getPushCount() {
        return pushCount;
    }

    public void setPushCount(Integer pushCount) {
        this.pushCount = pushCount;
    }

    public Byte getIsContact() {
        return isContact;
    }

    public void setIsContact(Byte isContact) {
        this.isContact = isContact;
    }

	@Override
	public String toString() {
		return "Propurchase [id=" + id + ", memberId=" + memberId + ", title=" + title + ", picture=" + picture
				+ ", summary=" + summary + ", deliveryAddr=" + deliveryAddr + ", supplierAddr=" + supplierAddr
				+ ", requirement=" + requirement + ", linkman=" + linkman + ", tel=" + tel + ", showContact="
				+ showContact + ", endTime=" + endTime + ", addTime=" + addTime + ", modifyTime=" + modifyTime
				+ ", quoteTimes=" + quoteTimes + ", status=" + status + ", siteId=" + siteId + ", times=" + times
				+ ", source=" + source + ", purchaseAmount=" + purchaseAmount + ", purchaseAmountUnit="
				+ purchaseAmountUnit + ", invoiceRequest=" + invoiceRequest + ", sampleRequest=" + sampleRequest
				+ ", telAreaCode=" + telAreaCode + ", telFixedNumber=" + telFixedNumber + ", dataType=" + dataType
				+ ", isPush=" + isPush + ", pushCount=" + pushCount + ", isContact=" + isContact + "]";
	}
    
    
}