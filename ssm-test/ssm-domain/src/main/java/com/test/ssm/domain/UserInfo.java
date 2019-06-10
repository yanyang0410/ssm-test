package com.test.ssm.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: UserInfo
 * @Description: 用户信息
 * @Author: francis
 * @Date: 2019-05-26 16:41
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -5379137121712452231L;

    /**
     * 主键uuid
     */
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 电话
     */
    private String phoneNum;
    /**
     * 状态0 未开启 1 开启
     */
    private int status;
    /**
     * 状态类型转换
     */
    private String statusStr;
    /**
     * 角色信息
     */
    private List<Role> roles;

    public String getStatusStr() {
        if (status == 0) {
            statusStr = "未开启";
        }else {
            statusStr = "开启";
        }
        return statusStr;
    }
}