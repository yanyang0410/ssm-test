package com.test.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.test.ssm.mapper.IPermissionMapper;
import com.test.ssm.domain.Permission;
import com.test.ssm.service.IPermissionService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: PermissionServiceImpl
 * @Description: 资源权限管理信息实现
 * @Author: francis
 * @Date: 2019-05-19 22:14
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionMapper permissionMapper;

    /**
     * 功能描述: 〈资源管理信息查询〉
     * @param page
     * @param pageSize
     * @return: java.util.List<com.test.ssm.domain.Permission>
     * @author: francis
     * @date: 2019-06-02 19:40
     */
    @Override
    public List<Permission> findAll(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return permissionMapper.findAll();
    }

    /**
     * 功能描述: 〈资源管理信息保存〉
     * @param permission
     * @return: void
     * @author: francis
     * @date: 2019-06-02 19:41
     */
    @Override
    public void save(Permission permission) {
        permissionMapper.save(permission);
    }

    /**
     * 功能描述: 〈权限详情信息〉
     * @param permissionId
     * @return: com.test.ssm.domain.Permission
     * @author: francis
     * @date: 2019-06-09 13:32
     */
    @Override
    public Permission findById(String permissionId) throws Exception {
        return permissionMapper.findById(permissionId);
    }

    /**
     * 功能描述: 〈删除指定权限信息〉
     * @param permissionId
     * @return: void
     * @author: francis
     * @date: 2019-06-09 13:42
     */
    @Override
    public void deleteById(String permissionId) throws Exception {
        permissionMapper.deleteRolePermission(permissionId);
        permissionMapper.deleteById(permissionId);
    }
}
