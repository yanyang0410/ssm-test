package com.test.ssm.mapper;

import com.test.ssm.domain.Permission;
import com.test.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName: IRoleMapper
 * @Description: 角色表信息Mapper
 * @Author: francis
 * @Date: 2019-05-19 22:04
 * @Version: 1.0
 */
public interface IRoleMapper {

    /**
     * 功能描述: 〈根据用户id查询出所有对应的角色〉
     *
     * @param userId
     * @return: java.util.List<com.test.ssm.domain.Role>
     * @author: francis
     * @date: 2019-06-02 18:12
     */
    @Select(value = "select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = List.class, many = @Many(select = "com.test.ssm.mapper.IPermissionMapper.findPermissionByRoleId"))
    })
    List<Role> findRoleByUserId(String userId) throws Exception;

    /**
     * 功能描述: 〈查询所有角色信息〉
     *
     * @param
     * @return: java.util.List<com.test.ssm.domain.Role>
     * @author: francis
     * @date: 2019-06-02 18:48
     */
    @Select(value = "select * from ROLE")
    List<Role> findAll() throws Exception;

    /**
     * 功能描述: 〈保存角色信息〉
     *
     * @param role
     * @return: void
     * @author: francis
     * @date: 2019-06-02 18:58
     */
    @Insert(value = "insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    /**
     * 功能描述: 〈查询角色以及角色可以添加的权限〉
     *
     * @param roleId
     * @return: com.test.ssm.domain.Role
     * @author: francis
     * @date: 2019-06-09 10:54
     */
    @Select(value = "select * from ROLE where id = #{roleId} ")
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "permissions", property = "id", javaType = List.class, many = @Many(select = "com.test.ssm.mapper.IPermissionMapper.findPermissionByRoleId"))
    })
    Role findById(@Param("roleId") String roleId) throws Exception;

    /**
     * 功能描述: 〈查询角色以及角色可以添加的权限〉
     *
     * @param roleId
     * @return: java.util.List<com.test.ssm.domain.Permission>
     * @author: francis
     * @date: 2019-06-09 11:02
     */
    @Select(value = "select * from PERMISSION where id not in (select PERMISSIONID from ROLE_PERMISSION where ROLEID = #{roleId} )")
    List<Permission> findOtherPermission(String roleId) throws Exception;

    /**
     * 功能描述: 〈指定角色添加权限〉
     * @param roleId
     * @param permissionIds
     * @return: void
     * @author: francis
     * @date: 2019-06-09 11:24
     */
    @Insert(value = "insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionIds);

}