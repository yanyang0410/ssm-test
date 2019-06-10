package com.test.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.ssm.domain.SysLog;
import com.test.ssm.mapper.ISysLogMapper;
import com.test.ssm.service.ISysLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: SysLogServiceImpl
 * @Description: AOP日志处理Servcice实现
 * @Author: francis
 * @Date: 2019-05-30 22:07
 * @Version: 1.0
 */
@Service("syslogServiceImpl")
@Transactional(rollbackFor = Exception.class)
public class SysLogServiceImpl implements ISysLogService {

    @Resource
    private ISysLogMapper sysLogMapper;

    /**
     * 功能描述: 〈查找所有AOP日志信息〉
     *
     * @param
     * @return: java.util.List<com.test.ssm.domain.SysLog>
     * @author: francis
     * @date: 2019-06-09 16:13
     */
    @Override
    public List<SysLog> findAll(int page, int pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return sysLogMapper.findAll();
    }

    /**
     * 功能描述: 〈AOP日志保存〉
     *
     * @param sysLog
     * @return: void
     * @author: francis
     * @date: 2019-06-09 17:39
     */
    @Override
    public void saveLog(SysLog sysLog) throws Exception {
        sysLogMapper.saveLog(sysLog);
    }
}
