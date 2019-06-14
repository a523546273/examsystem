package com.exam.examsystem.service;

import com.exam.examsystem.dto.PageResult;
import com.exam.examsystem.po.RolePo;
import com.exam.examsystem.req.RoleRequest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: hongwei.wang
 * @create: 2019-06-14 09:59
 */
public interface RoleService {

    /**
     * 分页查询所有角色信息
     *
     * @param filter
     * @return
     */
    PageResult<RolePo> selectAllRole(RoleRequest filter);

    /**
     * 更新角色状态
     *
     * @param roleid
     * @param validity 1启用  0注销
     * @return
     * @throws Exception
     */
    @Transactional
    boolean updateStatus(Integer roleid, String validity) throws Exception;


    /**
     * 删除用户信息
     *
     * @param roleid 角色id
     * @throws Exception
     */
    @Transactional
    boolean removeRole(Integer roleid);
}
