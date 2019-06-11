package com.exam.examsystem.po;

import java.io.Serializable;

/**
 * menu_resource
 * @author 
 */
public class MenuResourcePo implements Serializable {
    /**
     * 菜单标识
     */
    private Integer menuid;

    /**
     * 父菜单
     */
    private Integer parentmenuid;

    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 链接
     */
    private String url;

    /**
     * 优先级
     */
    private Integer priority;

    private String status;

    /**
     * 删除标志
     */
    private String removed;

    /**
     * 菜单类型
     */
    private String menutype;

    /**
     * 是否允许自定义菜单(0 不支持， 1支持 )
     */
    private String allowcustom;

    private String icon;

    /**
     * 树的层级
     */
    private String levels;

    private static final long serialVersionUID = 1L;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getParentmenuid() {
        return parentmenuid;
    }

    public void setParentmenuid(Integer parentmenuid) {
        this.parentmenuid = parentmenuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemoved() {
        return removed;
    }

    public void setRemoved(String removed) {
        this.removed = removed;
    }

    public String getMenutype() {
        return menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    public String getAllowcustom() {
        return allowcustom;
    }

    public void setAllowcustom(String allowcustom) {
        this.allowcustom = allowcustom;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }
}