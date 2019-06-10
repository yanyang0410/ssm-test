package com.test.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.test.ssm.domain.Permission;
import com.test.ssm.domain.Role;
import com.test.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName: RoleController
 * @Description: 角色信息控制器
 * @Author: francis
 * @Date: 2019-06-02 18:15
 * @Version: 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;

    /**
     * 功能描述: 〈查询所有角色信息〉
     *
     * @param page
     * @param pageSize
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: francis
     * @date: 2019-06-02 18:52
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = iRoleService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(roleList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    /**
     * 功能描述: 〈保存用户信息〉
     *
     * @param role
     * @return: java.lang.String
     * @author: francis
     * @date: 2019-06-02 18:54
     */
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        iRoleService.save(role);
        return "redirect:findAll.do";
    }

    /**
     * 功能描述: 〈查询角色以及角色可以添加的权限〉
     *
     * @param roleId
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: francis
     * @date: 2019-06-09 10:30
     */
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //查询当前角色
        Role role = iRoleService.findById(roleId);
        //查找符合角色添加的权限
        List<Permission> permissionList = iRoleService.findOtherPermission(roleId);
        modelAndView.addObject("role", role);
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    /**
     * 功能描述: 〈指定角色添加权限〉
     *
     * @param
     * @return: java.lang.String
     * @author: francis
     * @date: 2019-06-09 10:35
     */
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleId, @RequestParam(name = "ids", required = true) String[] permissionIds) throws Exception {
        iRoleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll.do";
    }

    /**
     * 功能描述: 〈角色详情信息〉
     * @param roleId
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: francis
     * @date: 2019-06-09 14:14
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Role role = iRoleService.findById(roleId);
        modelAndView.addObject("role", role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }

}