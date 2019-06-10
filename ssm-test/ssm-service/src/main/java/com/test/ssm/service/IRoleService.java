package com.test.ssm.service;

import com.test.ssm.domain.Permission;
import com.test.ssm.domain.Role;

import java.util.List;

/**
 * @ClassName: IRoleService
 * @Description: 角色表信息Service
 * @Author: francis
 * @Date: 2019-05-19 22:00
 * @Version: 1.0
 */
public interface IRoleService {

    /**
     * 功能描述: 〈查询全部角色信息〉
     *
     * @param page
     * @param pageSize
     * @return: java.util.List<com.test.ssm.domain.Role>
     * @author: francis
     * @date: 2019-06-02 18:45
     */
    List<Role> findAll(int page, int pageSize) throws Exception;

    /**
     * 功能描述: 〈保存角色信息〉
     *
     * @param role
     * @return: void
     * @author: francis
     * @date: 2019-06-02 19:06
     */
    void save(Role role) throws Exception;

    /**
     * 功能描述: 〈查询角色〉
     *
     * @param roleId
     * @return: com.test.ssm.domain.Role
     * @author: francis
     * @date: 2019-06-09 10:53
     */
    Role findById(String roleId) throws Exception;

    /**
     * 功能描述: 〈查询用户以及用户可以添加的角色〉
     *
     * @param roleId
     * @return: java.util.List<com.test.ssm.domain.Permission>
     * @author: francis
     * @date: 2019-06-09 11:00
     */
    List<Permission> findOtherPermission(String roleId) throws Exception;

    /**
     * 功能描述: 〈指定角色添加权限〉
     *
     * @param roleId
     * @param permissionIds
     * @return: void
     * @author: francis
     * @date: 2019-06-09 11:23
     */
    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
