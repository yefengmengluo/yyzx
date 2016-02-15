package com.wangku.entity;

import java.beans.Transient;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User {
    private Long userId;

    private String account;//帐户

    private String password;//密码

    private String realName;//真实姓名

    private String mobile;//手机

    private String siteName;//站点名称

    private String siteNickname;//站点别称

    private String webUrl;//网址

    private Integer userPower;//权限
    
    private String code; //
    @Transient   //不需要持久到DB的属性使用该注解  
    public String getCode() { 
        return code; 
    } 
     
    public void setCode(String code) { 
        this.code = code; 
    } 

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getSiteNickname() {
        return siteNickname;
    }

    public void setSiteNickname(String siteNickname) {
        this.siteNickname = siteNickname == null ? null : siteNickname.trim();
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl == null ? null : webUrl.trim();
    }

    public Integer getUserPower() {
        return userPower;
    }

    public void setUserPower(Integer userPower) {
        this.userPower = userPower;
    }

	/**
	 * @author： 谢虹英  2015-6-18 上午11:12:15
	 * @方法名： toString
	 * @方法描述：
	 * @param:
	 * @返回值：
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", account=" + account
				+ ", password=" + password + ", realName=" + realName
				+ ", mobile=" + mobile + ", siteName=" + siteName
				+ ", siteNickname=" + siteNickname + ", webUrl=" + webUrl
				+ ", userPower=" + userPower + "]";
	}
}