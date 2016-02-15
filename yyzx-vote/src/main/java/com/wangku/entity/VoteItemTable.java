package com.wangku.entity;
/**
 * 
 * @author zsl
 * 2015-6-25上午11:27:17
 * 类描述：投票选项实体表
 */
public class VoteItemTable {
    private Long id;

    private Long vId;

    private Integer itemSort;

    private Integer itemLastSort;

    private String vdTitle;
    
    private Integer vdCount;
    
    

    public Integer getVdCount() {
		return vdCount;
	}

	public void setVdCount(Integer vdCount) {
		this.vdCount = vdCount;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getvId() {
        return vId;
    }

    public void setvId(Long vId) {
        this.vId = vId;
    }

    public Integer getItemSort() {
        return itemSort;
    }

    public void setItemSort(Integer itemSort) {
        this.itemSort = itemSort;
    }

    public Integer getItemLastSort() {
        return itemLastSort;
    }

    public void setItemLastSort(Integer itemLastSort) {
        this.itemLastSort = itemLastSort;
    }

    public String getVdTitle() {
        return vdTitle;
    }

    public void setVdTitle(String vdTitle) {
        this.vdTitle = vdTitle == null ? null : vdTitle.trim();
    }
}