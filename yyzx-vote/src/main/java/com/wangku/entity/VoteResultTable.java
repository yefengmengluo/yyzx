package com.wangku.entity;

import java.util.Date;

public class VoteResultTable {
    private Long id;

    private Long viId;

    private Long vId;

    private String ipAdd;

    private String ipName;

    private Date voteAddTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getViId() {
        return viId;
    }

    public void setViId(Long viId) {
        this.viId = viId;
    }

    public Long getvId() {
        return vId;
    }

    public void setvId(Long vId) {
        this.vId = vId;
    }

    public String getIpAdd() {
        return ipAdd;
    }

    public void setIpAdd(String ipAdd) {
        this.ipAdd = ipAdd == null ? null : ipAdd.trim();
    }

    public String getIpName() {
        return ipName;
    }

    public void setIpName(String ipName) {
        this.ipName = ipName == null ? null : ipName.trim();
    }

    public Date getVoteAddTime() {
        return voteAddTime;
    }

    public void setVoteAddTime(Date voteAddTime) {
        this.voteAddTime = voteAddTime;
    }
}