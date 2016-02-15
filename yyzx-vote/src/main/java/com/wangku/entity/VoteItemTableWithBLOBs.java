package com.wangku.entity;

public class VoteItemTableWithBLOBs extends VoteItemTable {
    private String vdDetail;

    private String vdOther;

    public String getVdDetail() {
        return vdDetail;
    }

    public void setVdDetail(String vdDetail) {
        this.vdDetail = vdDetail == null ? null : vdDetail.trim();
    }

    public String getVdOther() {
        return vdOther;
    }

    public void setVdOther(String vdOther) {
        this.vdOther = vdOther == null ? null : vdOther.trim();
    }
}