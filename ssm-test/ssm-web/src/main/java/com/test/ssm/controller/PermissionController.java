package com.test.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.test.ssm.domain.Permission;
import com.test.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName: PermissionController
 * @Description: 资源权限管理控制器
 * @Author: francis
 * @Date: 2019-06-02 19:28
 * @Version: 1.0
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService iPermissionService;

    /**
     * 功能描述: 〈资源权限管理信息查询〉
     *
     * @param page
     * @param pageSize
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: francis
     * @date: 2019-06-02 19:32
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = iPermissionService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(permissionList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    /**
     * 功能描述: 〈资源权限管理信息保存〉
     *
     * @param permission
     * @return: java.lang.String
     * @author: francis
     * @date: 2019-06-02 19:34
     */
    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        iPermissionService.save(permission);
        return "redirect:findAll.do";
    }

    /**
     * 功能描述: 〈权限详情信息〉
     *
     * @param permissionId
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: francis
     * @date: 2019-06-09 13:31
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String permissionId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Permission permission = iPermissionService.findById(permissionId);
        modelAndView.addObject("permission", permission);
        modelAndView.setViewName("permission-show");
        return modelAndView;
    }

    /**
     * 功能描述: 〈删除指定权限信息〉
     *
     * @param permissionId
     * @return: java.lang.String
     * @author: francis
     * @date: 2019-06-09 13:36
     */
    @RequestMapping("/deleteById.do")
    public String deleteById(@RequestParam(name = "id", required = true) String permissionId) throws Exception {
        iPermissionService.deleteById(permissionId);
        return "redirect:findAll.do";
    }
}