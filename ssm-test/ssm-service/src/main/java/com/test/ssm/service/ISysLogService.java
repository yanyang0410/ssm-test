package com.test.ssm.service;

import com.test.ssm.domain.SysLog;

import java.util.List;

/**
 * @ClassName: ISysLogService
 * @Description: AOP日志处理Service
 * @Author: francis
 * @Date: 2019-05-30 22:05
 * @Version: 1.0
 */
public interface ISysLogService {

    /**
     * 功能描述: 〈查找所有AOP日志信息〉
     * @param
     * @return: java.util.List<com.test.ssm.domain.SysLog>
     * @author: francis
     * @date: 2019-06-09 16:13
     */
    List<SysLog> findAll(int page, int pageSize) throws Exception;

    /**
     * 功能描述: 〈保存AOP日志信息〉
     * @param sysLog
     * @return: void
     * @author: francis
     * @date: 2019-06-09 18:07
     */
    void saveLog(SysLog sysLog) throws Exception;
}
