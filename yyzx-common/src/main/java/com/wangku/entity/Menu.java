package com.wangku.entity;

import java.util.Date;

public class Menu {
    private Integer menuId;

    private String menunname;

    private String menucode;

    private String menudescribe;

    private Date addtime;

    private String flagon;

    private Integer menuorder;

    private Integer groupId;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenunname() {
        return menunname;
    }

    public void setMenunname(String menunname) {
        this.menunname = menunname == null ? null : menunname.trim();
    }

    public String getMenucode() {
        return menucode;
    }

    public void setMenucode(String menucode) {
        this.menucode = menucode == null ? null : menucode.trim();
    }

    public String getMenudescribe() {
        return menudescribe;
    }

    public void setMenudescribe(String menudescribe) {
        this.menudescribe = menudescribe == null ? null : menudescribe.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getFlagon() {
        return flagon;
    }

    public void setFlagon(String flagon) {
        this.flagon = flagon == null ? null : flagon.trim();
    }

    public Integer getMenuorder() {
        return menuorder;
    }

    public void setMenuorder(Integer menuorder) {
        this.menuorder = menuorder;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}