package com.test.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.test.ssm.domain.SysLog;
import com.test.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName: SysLogController
 * @Description: AOP日志处理控制器
 * @Author: francis
 * @Date: 2019-06-09 16:09
 * @Version: 1.0
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    /**
     * 功能描述: 〈查找所有AOP日志信息〉
     *
     * @param
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: francis
     * @date: 2019-06-09 16:12
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(sysLogList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }

}