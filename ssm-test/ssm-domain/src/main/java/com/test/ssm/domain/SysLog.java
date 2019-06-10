package com.test.ssm.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: SysLog
 * @Description: AOP日志信息
 * @Author: francis
 * @Date: 2019-05-26 16:41
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SysLog implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键 无意义uuid
     */
    private String id;
    /**
     * 访问时间
     */
    private Date visitTime;
    /**
     * 操作者用户名
     */
    private String userName;
    /**
     * 访问ip
     */
    private String ip;
    /**
     * 访问资源url
     */
    private String url;
    /**
     * 执行时长
     */
    private Long executionTime;
    /**
     * 访问方法
     */
    private String method;
}