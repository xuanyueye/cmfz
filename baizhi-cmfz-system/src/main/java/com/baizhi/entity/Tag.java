package com.baizhi.entity;

import java.util.List;

/**
 * Created by GXL on 2017/5/31.
 */
public class Tag {
    private String id;
    private String name;
    private String href;
    private String iconCls;
    private List<Tag> listt;

    public List<Tag> getListt() {
        return listt;
    }

    public void setListt(List<Tag> listt) {
        this.listt = listt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }


    public Tag(String id, String name, String href, String iconCls) {
        this.id = id;
        this.name = name;
        this.href = href;
        this.iconCls = iconCls;
    }

    public Tag() {
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                '}';
    }
}
