package com.test.ssm.mapper;

import com.test.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: IPermissionMapper
 * @Description: 资源权限管理信息Mapper
 * @Author: francis
 * @Date: 2019-05-26 00:44
 * @Version: 1.0
 */
public interface IPermissionMapper {

    /**
     * 功能描述: 〈资源权限管理信息查询〉
     *
     * @param
     * @return: java.util.List<com.test.ssm.domain.Permission>
     * @author: francis
     * @date: 2019-06-02 19:42
     */
    @Select(value = "select * from PERMISSION")
    List<Permission> findAll();

    /**
     * 功能描述: 〈资源权限管理信息保存〉
     *
     * @param permission
     * @return: void
     * @author: francis
     * @date: 2019-06-02 19:44
     */
    @Insert(value = "insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);
    
    /**
     * 功能描述: 〈查询与role关联的所有的权限〉
     * @param id
     * @return: java.util.List<com.test.ssm.domain.Permission>
     * @author: francis
     * @date: 2019-06-09 11:13
     */
    @Select(value = "select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    List<Permission> findPermissionByRoleId(String id) throws Exception;

    /**
     * 功能描述: 〈权限详情信息〉
     * @param permissionId
     * @return: com.test.ssm.domain.Permission
     * @author: francis
     * @date: 2019-06-09 13:33
     */
    @Select(value = "select * from PERMISSION where ID = #{permissionId} ")
    Permission findById(String permissionId) throws Exception;

    /**
     * 功能描述: 〈删除指定权限〉
     * @param permissionId
     * @return: void
     * @author: francis
     * @date: 2019-06-09 13:34
     */
    @Delete(value = "delete from PERMISSION where ID = #{permissionId} ")
    void deleteById(String permissionId) throws Exception;

    /**
     * 功能描述: 〈根据权限id删除角色权限关联信息〉
     * @param permissionId
     * @return: void
     * @author: francis
     * @date: 2019-06-09 13:58
     */
    @Delete(value = "delete from ROLE_PERMISSION where PERMISSIONID = #{permissionId} ")
    void deleteRolePermission(String permissionId) throws Exception;
}