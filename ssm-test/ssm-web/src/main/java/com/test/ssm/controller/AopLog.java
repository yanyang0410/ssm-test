package com.test.ssm.controller;

import com.test.ssm.domain.SysLog;
import com.test.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName: AOPLogUtils
 * @Description: AOP日志工具类
 * @Author: francis
 * @Date: 2019-06-09 17:42
 * @Version: 1.0
 */
@Component
@Aspect
public class AopLog {

    @Autowired
    private ISysLogService logService;
    @Autowired
    private HttpServletRequest servletRequest;
    /**
     * 访问开始时间
     */
    private Date startTime;
    /**
     * 访问结束时间
     */
    private Long endTime;
    /**
     * 访问的类
     */
    private Class clazz;
    /**
     * 访问的方法
     */
    private Method method;


    /**
     * 功能描述: 〈AOP日志处理前〉
     *
     * @param point
     * @return: void
     * @author: francis
     * @date: 2019-06-09 17:49
     */
    @Before(value = "execution(* com.test.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint point) throws NoSuchMethodException {
        // 当前时间就是开始访问的时间
        startTime = new Date();
        // 具体要访问的类
        clazz = point.getTarget().getClass();
        // 获取访问的方法的名称
        String methodName = point.getSignature().getName();
        // 获取访问的方法的参数
        Object[] pointArgs = point.getArgs();
        // 获取具体执行的方法的Method对象
        if (pointArgs == null || pointArgs.length == 0) {
            // 只能获取无参数的方法
            method = clazz.getMethod(methodName);
        } else {
            Class[] classArgs = new Class[pointArgs.length];
            for (int i = 0; i < pointArgs.length; i++) {
                classArgs[i] = pointArgs[i].getClass();
            }
            method = clazz.getMethod(methodName, classArgs);
        }
    }

    /**
     * 功能描述: 〈AOP日志处理后〉
     *
     * @param point
     * @return: void
     * @author: francis
     * @date: 2019-06-09 17:50
     */
    @After(value = "execution(* com.test.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint point) throws Exception {
        endTime = System.currentTimeMillis();
        // 获取访问的时长
        long time = endTime - startTime.getTime();
        String url = "";
        //获取url
        if (clazz != null && method != null && (clazz != AopLog.class || clazz != SysLogController.class)) {
            //1.获取类上的@RequestMapping("/orders")
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();
                //2.获取方法上的@RequestMapping(xxx)
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                    //获取访问的ip
                    String ip = servletRequest.getRemoteAddr();
                    String localAddr = servletRequest.getLocalAddr();
                    //获取当前操作的用户 从上下文中获了当前登录的用户
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();
                    saveLog(time, url, ip, username);
                }
            }
        }
    }

    /**
     * 功能描述: 〈保存AOP日志信息〉
     *
     * @param time
     * @param url
     * @param ip
     * @param username
     * @return: void
     * @author: francis
     * @date: 2019-06-09 18:08
     */
    private void saveLog(long time, String url, String ip, String username) throws Exception {
        SysLog sysLog = new SysLog();
        sysLog.setExecutionTime(time);
        sysLog.setIp(ip);
        sysLog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());
        sysLog.setUrl(url);
        sysLog.setUserName(username);
        sysLog.setVisitTime(startTime);
        logService.saveLog(sysLog);
    }
}