package com.test.ssm.mapper;

import com.test.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: ISysLogMapper
 * @Description: AOP日志处理Mapper
 * @Author: francis
 * @Date: 2019-05-19 22:04
 * @Version: 1.0
 */
public interface ISysLogMapper {

    /**
     * 功能描述: 〈查找所有AOP日志信息〉
     *
     * @param
     * @return: java.util.List<com.test.ssm.domain.SysLog>
     * @author: francis
     * @date: 2019-06-09 16:14
     */
    @Select(value = "select * from SYSLOG ")
    List<SysLog> findAll() throws Exception;

    /**
     * 功能描述: 〈通过id查找AOP日志信息〉
     *
     * @param sysLogId
     * @return: com.test.ssm.domain.SysLog
     * @author: francis
     * @date: 2019-06-09 16:15
     */
    @Select(value = "select * from SYSLOG where ID = #{sysLogId} ")
    SysLog findById(String sysLogId) throws Exception;

    /**
     * 功能描述: 〈AOP日志保存〉
     *
     * @param sysLog
     * @return: void
     * @author: francis
     * @date: 2019-06-09 17:40
     */
    @Insert(value = "insert into SYSLOG (VISITTIME, USERNAME, IP, URL, EXECUTIONTIME, METHOD) values (#{visitTime},#{userName},#{ip},#{url},#{executionTime},#{method})")
    void saveLog(SysLog sysLog) throws Exception;
}