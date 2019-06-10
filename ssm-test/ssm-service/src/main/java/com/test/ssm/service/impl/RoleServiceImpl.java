package com.test.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.ssm.domain.Permission;
import com.test.ssm.domain.Role;
import com.test.ssm.mapper.IRoleMapper;
import com.test.ssm.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: RoleServiceImpl
 * @Description: 角色表信息实现
 * @Author: francis
 * @Date: 2019-05-19 22:14
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements IRoleService {

    @Resource
    private IRoleMapper roleMapper;

    /**
     * 功能描述: 〈查询全部角色信息〉
     *
     * @param page
     * @param pageSize
     * @return: java.util.List<com.test.ssm.domain.Role>
     * @author: francis
     * @date: 2019-06-02 18:45
     */
    @Override
    public List<Role> findAll(int page, int pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return roleMapper.findAll();
    }

    /**
     * 功能描述: 〈保存角色信息〉
     *
     * @param role
     * @return: void
     * @author: francis
     * @date: 2019-06-02 18:57
     */
    @Override
    public void save(Role role) throws Exception {
        roleMapper.save(role);
    }

    /**
     * 功能描述: 〈查询角色〉
     *
     * @param roleId
     * @return: com.test.ssm.domain.Role
     * @author: francis
     * @date: 2019-06-09 10:53
     */
    @Override
    public Role findById(String roleId) throws Exception {
        return roleMapper.findById(roleId);
    }

    /**
     * 功能描述: 〈查询角色以及角色可以添加的权限〉
     *
     * @param roleId
     * @return: java.util.List<com.test.ssm.domain.Permission>
     * @author: francis
     * @date: 2019-06-09 11:02
     */
    @Override
    public List<Permission> findOtherPermission(String roleId) throws Exception {
        return roleMapper.findOtherPermission(roleId);
    }

    /**
     * 功能描述: 〈指定角色添加权限〉
     *
     * @param roleId
     * @param permissionIds
     * @return: void
     * @author: francis
     * @date: 2019-06-09 11:23
     */
    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds) {
            roleMapper.addPermissionToRole(roleId, permissionId);
        }
    }
}
