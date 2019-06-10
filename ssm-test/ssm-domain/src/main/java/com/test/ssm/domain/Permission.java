package com.test.ssm.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: Permission
 * @Description: 资源权限
 * @Author: francis
 * @Date: 2019-05-19 20:38
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键uuid
     */
    private String id;
    /**
     * 权限名
     */
    private String permissionName;
    /**
     * 资源路径
     */
    private String url;
    /**
     * 角色信息
     */
    private List<Role> roles;
}