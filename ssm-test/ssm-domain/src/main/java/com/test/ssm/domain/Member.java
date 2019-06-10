package com.test.ssm.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: Member
 * @Description: 会员详细信息
 * @Author: francis
 * @Date: 2019-05-23 23:49
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Member implements Serializable {

    private static final long serialVersionUID = -8471685890947881106L;

    /**
     * 主键 UUID
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 手机号
     */
    private String phoneNum;
    /**
     * 邮箱
     */
    private String email;
}