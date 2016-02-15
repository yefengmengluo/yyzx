package com.wangku.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.type.Alias;
@Alias(value="Supply")
public class Supply {
    private Long id;

    private String invoiceName;

    private Integer storeNum;

    private String classCode;

    private String categoryCode;

    private String pic;

    private String alias;

    private String name;

    private String brandName;

    private String brandCode;

    private Long memberId;

    private String summary;

    private BigDecimal priceMin;

    private Integer addrId;

    private String priceInterval;

    private Integer freightId;

    private Integer siteId;

    private String unitCustom;

    private String unit;

    private Date times;

    private Byte deliveryDayEnd;

    private Byte deliveryDayBegin;

    private Date expireTime;

    private String promotionType;

    private Long promotionPrice;

    private Boolean promotionIsShow;

    private Boolean isForTrade;

    private Integer status;

    private Date addTime;

    private Date modifyTime;

    private Integer sales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName == null ? null : invoiceName.trim();
    }

    public Integer getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(Integer storeNum) {
        this.storeNum = storeNum;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode == null ? null : classCode.trim();
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode == null ? null : brandCode.trim();
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public BigDecimal getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(BigDecimal priceMin) {
        this.priceMin = priceMin;
    }

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public String getPriceInterval() {
        return priceInterval;
    }

    public void setPriceInterval(String priceInterval) {
        this.priceInterval = priceInterval == null ? null : priceInterval.trim();
    }

    public Integer getFreightId() {
        return freightId;
    }

    public void setFreightId(Integer freightId) {
        this.freightId = freightId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getUnitCustom() {
        return unitCustom;
    }

    public void setUnitCustom(String unitCustom) {
        this.unitCustom = unitCustom == null ? null : unitCustom.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public Byte getDeliveryDayEnd() {
        return deliveryDayEnd;
    }

    public void setDeliveryDayEnd(Byte deliveryDayEnd) {
        this.deliveryDayEnd = deliveryDayEnd;
    }

    public Byte getDeliveryDayBegin() {
        return deliveryDayBegin;
    }

    public void setDeliveryDayBegin(Byte deliveryDayBegin) {
        this.deliveryDayBegin = deliveryDayBegin;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType == null ? null : promotionType.trim();
    }

    public Long getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(Long promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Boolean getPromotionIsShow() {
        return promotionIsShow;
    }

    public void setPromotionIsShow(Boolean promotionIsShow) {
        this.promotionIsShow = promotionIsShow;
    }

    public Boolean getIsForTrade() {
        return isForTrade;
    }

    public void setIsForTrade(Boolean isForTrade) {
        this.isForTrade = isForTrade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

	/**
	 * @author： 谢虹英  2015-7-14 下午12:13:26
	 * @方法名： toString
	 * @方法描述：
	 * @param:
	 * @返回值：
	 */
	@Override
	public String toString() {
		return "Supply [id=" + id + ", invoiceName=" + invoiceName
				+ ", storeNum=" + storeNum  + ", classCode="
				+ classCode + ", categoryCode=" + categoryCode + ", pic=" + pic
				+ ", alias=" + alias + ", name=" + name + ", brandName="
				+ brandName + ", brandCode=" + brandCode + ", memberId="
				+ memberId + ", summary=" + summary + ", priceMin=" + priceMin
				+ ", addrId=" + addrId + ", priceInterval=" + priceInterval
				+ ", freightId=" + freightId + ", siteId=" + siteId
				+ ", unitCustom=" + unitCustom + ", unit=" + unit + ", times="
				+ times + ", deliveryDayEnd=" + deliveryDayEnd
				+ ", deliveryDayBegin=" + deliveryDayBegin + ", expireTime="
				+ expireTime + ", promotionType=" + promotionType
				+ ", promotionPrice=" + promotionPrice + ", promotionIsShow="
				+ promotionIsShow + ", isForTrade=" + isForTrade + ", status="
				+ status + ", addTime=" + addTime + ", modifyTime="
				+ modifyTime + ", sales=" + sales + "]";
	}
    
}