package com.wangku.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;
@Alias(value="FootPrints")
public class FootPrints {
    private Long id;

    private String memberName;

    private String ip;

    private Long supplyId;

    private Long siteId;

    private Integer count;

    private Date visitTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Long getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Long supplyId) {
        this.supplyId = supplyId;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

	/**
	 * @author： 谢虹英  2015-7-14 下午12:12:58
	 * @方法名： toString
	 * @方法描述：
	 * @param:
	 * @返回值：
	 */
	@Override
	public String toString() {
		return "FootPrints [id=" + id + ", memberName=" + memberName + ", ip=" + ip
				+ ", supplyId=" + supplyId + ", siteId=" + siteId + ", count="
				+ count + ", visitTime=" + visitTime + "]";
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
    
}