package com.test.ssm.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: Role
 * @Description: 角色表信息描述
 * @Author: francis
 * @Date: 2019-05-26 16:41
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键uuid
     */
    private String id;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDesc;
    /**
     * 资源权限
     */
    private List<Permission> permissions;
    /**
     * 用户信息
     */
    private List<UserInfo> users;
}