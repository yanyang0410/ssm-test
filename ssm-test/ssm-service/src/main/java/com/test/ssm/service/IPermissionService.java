package com.test.ssm.service;

import com.test.ssm.domain.Permission;

import java.util.List;

/**
 * @ClassName: IPermissionService
 * @Description: 资源权限管理信息Service
 * @Author: francis
 * @Date: 2019-05-19 22:00
 * @Version: 1.0
 */
public interface IPermissionService {

    /**
     * 功能描述: 〈资源权限管理信息查询〉
     * @param page
     * @param pageSize
     * @return: java.util.List<com.test.ssm.domain.Permission>
     * @author: francis
     * @date: 2019-06-02 19:36
     */
    List<Permission> findAll(int page, int pageSize) throws Exception;

    /**
     * 功能描述: 〈资源权限管理信息保存〉
     * @param permission
     * @return: void
     * @author: francis
     * @date: 2019-06-02 19:38
     */
    void save(Permission permission) throws Exception;

    /**
     * 功能描述: 〈权限详情信息〉
     * @param permissionId
     * @return: com.test.ssm.domain.Permission
     * @author: francis
     * @date: 2019-06-09 13:32
     */
    Permission findById(String permissionId) throws Exception;

    /**
     * 功能描述: 〈删除指定权限〉
     * @param permissionId
     * @return: void
     * @author: francis
     * @date: 2019-06-09 13:41
     */
    void deleteById(String permissionId) throws Exception;
}
