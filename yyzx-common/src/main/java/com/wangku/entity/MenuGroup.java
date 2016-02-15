package com.wangku.entity;

import java.util.Date;

public class MenuGroup {
    private Integer groupId;

    private String groupname;

    private Date addtime;

    private Date modifytime;

    private Integer grouporder;

    private String comment;

    private String flagon;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Integer getGrouporder() {
        return grouporder;
    }

    public void setGrouporder(Integer grouporder) {
        this.grouporder = grouporder;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getFlagon() {
        return flagon;
    }

    public void setFlagon(String flagon) {
        this.flagon = flagon == null ? null : flagon.trim();
    }
}