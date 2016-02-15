package com.wangku.entity;


import java.util.Date;

import org.apache.ibatis.type.Alias;
@Alias(value="Member")
public class Member {
    private Integer channelsType;

    private String mobile;

    private Integer status;

    private Date modifyTime;

    private Date addTime;

    private Integer bindType;

    private String email;

    private String password;

    private String regIp;

    private String account;

    private Long memberId;

    private String loginIp;

    private Integer totalLogin;

    private Integer siteId;

    private String position;

    private String department;

    private String postCode;

    private String telephone;

    private String qq;

    private String sex;

    private String headPortrait;

    private String linkMan;

    private String nickname;

    private String areaCode;

    private String address;

    private Long parentId;

    private Byte roleId;

    private String memberType;

    private Integer accreditStatus;

    private String fromUi;

    private Date expirTime;

    private Short validDay;

    private String fax;

    private Date times;

    private Date beginTime;

    public Integer getChannelsType() {
        return channelsType;
    }

    public void setChannelsType(Integer channelsType) {
        this.channelsType = channelsType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getBindType() {
        return bindType;
    }

    public void setBindType(Integer bindType) {
        this.bindType = bindType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp == null ? null : regIp.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public Integer getTotalLogin() {
        return totalLogin;
    }

    public void setTotalLogin(Integer totalLogin) {
        this.totalLogin = totalLogin;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait == null ? null : headPortrait.trim();
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Byte getRoleId() {
        return roleId;
    }

    public void setRoleId(Byte roleId) {
        this.roleId = roleId;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType == null ? null : memberType.trim();
    }

    public Integer getAccreditStatus() {
        return accreditStatus;
    }

    public void setAccreditStatus(Integer accreditStatus) {
        this.accreditStatus = accreditStatus;
    }

    public String getFromUi() {
        return fromUi;
    }

    public void setFromUi(String fromUi) {
        this.fromUi = fromUi == null ? null : fromUi.trim();
    }

    public Date getExpirTime() {
        return expirTime;
    }

    public void setExpirTime(Date expirTime) {
        this.expirTime = expirTime;
    }

    public Short getValidDay() {
        return validDay;
    }

    public void setValidDay(Short validDay) {
        this.validDay = validDay;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

	/**
	 * @author： 谢虹英  2015-7-14 上午11:51:41
	 * @方法名： toString
	 * @方法描述：
	 * @param:
	 * @返回值：
	 */
	@Override
	public String toString() {
		return "Member [channelsType=" + channelsType + ", mobile=" + mobile
				+ ", status=" + status + ", modifyTime=" + modifyTime
				+ ", addTime=" + addTime + ", bindType=" + bindType
				+ ", email=" + email + ", password=" + password + ", regIp="
				+ regIp + ", account=" + account + ", memberId=" + memberId
				+ ", loginIp=" + loginIp + ", totalLogin=" + totalLogin
				+ ", siteId=" + siteId + ", position=" + position
				+ ", department=" + department + ", postCode=" + postCode
				+ ", telephone=" + telephone + ", qq=" + qq + ", sex=" + sex
				+ ", headPortrait=" + headPortrait + ", linkMan=" + linkMan
				+ ", nickname=" + nickname + ", areaCode=" + areaCode
				+ ", address=" + address + ", parentId=" + parentId
				+ ", roleId=" + roleId + ", memberType=" + memberType
				+ ", accreditStatus=" + accreditStatus + ", fromUi=" + fromUi
				+ ", expirTime=" + expirTime + ", validDay=" + validDay
				+ ", fax=" + fax + ", times=" + times + ", beginTime="
				+ beginTime + "]";
	}
    
}