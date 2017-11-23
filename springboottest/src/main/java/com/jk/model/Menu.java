package com.jk.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/14.
 */
public class Menu implements Serializable{
    private static final long serialVersionUID = 3797829027174376926L;
    private Integer id;
    private Integer pid;
    private String name;
    private Integer type;
    private String icon;
    private String url;

    private String open="true";
    private String isParent = "false";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (!id.equals(menu.id)) return false;
        if (pid != null ? !pid.equals(menu.pid) : menu.pid != null) return false;
        if (name != null ? !name.equals(menu.name) : menu.name != null) return false;
        if (type != null ? !type.equals(menu.type) : menu.type != null) return false;
        if (icon != null ? !icon.equals(menu.icon) : menu.icon != null) return false;
        if (url != null ? !url.equals(menu.url) : menu.url != null) return false;
        if (open != null ? !open.equals(menu.open) : menu.open != null) return false;
        return isParent != null ? isParent.equals(menu.isParent) : menu.isParent == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (open != null ? open.hashCode() : 0);
        result = 31 * result + (isParent != null ? isParent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", open='" + open + '\'' +
                ", isParent='" + isParent + '\'' +
                '}';
    }
}