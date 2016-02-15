package com.wangku.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
    private Long id;

    private Long userId;

    private Integer purcherId;

    private String advCode;

    private String subject;

    private String body;

    private Integer goodsType;

    private BigDecimal price;

    private BigDecimal totalFee;

    private Integer quantity;

    private String outTradeNo;

    private String tradeNo;

    private Date payTime;

    private String successFlag;

    private String telephone;

    private Date startTime;

    private Date endTime;

    private String common1;

    private String common2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPurcherId() {
        return purcherId;
    }

    public void setPurcherId(Integer purcherId) {
        this.purcherId = purcherId;
    }

    public String getAdvCode() {
        return advCode;
    }

    public void setAdvCode(String advCode) {
        this.advCode = advCode == null ? null : advCode.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(String successFlag) {
        this.successFlag = successFlag == null ? null : successFlag.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCommon1() {
        return common1;
    }

    public void setCommon1(String common1) {
        this.common1 = common1 == null ? null : common1.trim();
    }

    public String getCommon2() {
        return common2;
    }

    public void setCommon2(String common2) {
        this.common2 = common2 == null ? null : common2.trim();
    }

	@Override
	public String toString() {
		return "Payment [id=" + id + ", userId=" + userId + ", purcherId=" + purcherId + ", advCode=" + advCode
				+ ", subject=" + subject + ", body=" + body + ", goodsType=" + goodsType + ", price=" + price
				+ ", totalFee=" + totalFee + ", quantity=" + quantity + ", outTradeNo=" + outTradeNo + ", tradeNo="
				+ tradeNo + ", payTime=" + payTime + ", successFlag=" + successFlag + ", telephone=" + telephone
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", common1=" + common1 + ", common2=" + common2
				+ "]";
	}
    
}