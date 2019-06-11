package com.exam.examsystem.po;

import java.io.Serializable;
import java.util.Date;

/**
 * role_menu
 * @author 
 */
public class RoleMenuPo implements Serializable {
    private Long id;

    /**
     * 角色id
     */
    private Long roleid;

    /**
     * 菜单id
     */
    private Long menuid;

    private String creator;

    private Date createdate;

    /**
     * 是否是叶子节点
     */
    private byte[] isleaf;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public byte[] getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(byte[] isleaf) {
        this.isleaf = isleaf;
    }
}