package com.wangku.entity;

import java.util.Date;

public class Comment {
    private Long comId;

    private Long viId;

    private String comContent;

    private Date comTime;

    private String comIp;
    
    private String ipName;

    private Integer comStatic;
    
    private Integer top;
    
    private Integer droop;

    private Long userId;
    
    private String vdTitle;
    
    private Integer num;
    
    

    /**
	 * @return the top
	 */
	public Integer getTop() {
		return top;
	}

	/**
	 * @param top the top to set
	 */
	public void setTop(Integer top) {
		this.top = top;
	}

	/**
	 * @return the droop
	 */
	public Integer getDroop() {
		return droop;
	}

	/**
	 * @param droop the droop to set
	 */
	public void setDroop(Integer droop) {
		this.droop = droop;
	}

	/**
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * @return the vdTitle
	 */
	public String getVdTitle() {
		return vdTitle;
	}

	/**
	 * @param vdTitle the vdTitle to set
	 */
	public void setVdTitle(String vdTitle) {
		this.vdTitle = vdTitle;
	}

	/**
	 * @return the ipName
	 */
	public String getIpName() {
		return ipName;
	}

	/**
	 * @param ipName the ipName to set
	 */
	public void setIpName(String ipName) {
		this.ipName = ipName;
	}

	public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Long getViId() {
        return viId;
    }

    public void setViId(Long viId) {
        this.viId = viId;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent == null ? null : comContent.trim();
    }

    public Date getComTime() {
        return comTime;
    }

    public void setComTime(Date comTime) {
        this.comTime = comTime;
    }

    public String getComIp() {
        return comIp;
    }

    public void setComIp(String comIp) {
        this.comIp = comIp == null ? null : comIp.trim();
    }

    public Integer getComStatic() {
        return comStatic;
    }

    public void setComStatic(Integer comStatic) {
        this.comStatic = comStatic;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	/**
	 * @author： 谢虹英  2015-6-26 下午3:43:46
	 * @方法名： toString
	 * @方法描述：
	 * @param:
	 * @返回值：
	 */
	@Override
	public String toString() {
		return "Comment [comId=" + comId + ", viId=" + viId + ", comContent="
				+ comContent + ", comTime=" + comTime + ", comIp=" + comIp
				+ ", ipName=" + ipName + ", comStatic=" + comStatic + ", top="
				+ top + ", droop=" + droop + ", userId=" + userId
				+ ", vdTitle=" + vdTitle + ", num=" + num + "]";
	}

	
    
}