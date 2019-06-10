package com.test.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.test.ssm.domain.Role;
import com.test.ssm.domain.UserInfo;
import com.test.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName: UserController
 * @Description: 用户信息控制器
 * @Author: francis
 * @Date: 2019-05-30 22:03
 * @Version: 1.0
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 功能描述: 〈查询所有用户信息〉
     *
     * @param page
     * @param pageSize
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: francis
     * @date: 2019-06-02 14:57
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfos = iUserService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(userInfos);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    /**
     * 功能描述: 〈添加用户信息〉
     *
     * @param
     * @return: void
     * @author: francis
     * @date: 2019-06-02 14:57
     */
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        iUserService.save(userInfo);
        return "redirect:findAll.do";
    }

    /**
     * 功能描述: 〈用户详情信息〉
     *
     * @param id
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: francis
     * @date: 2019-06-02 16:29
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = iUserService.findById(id);
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    /**
     * 功能描述: 〈查询用户以及用户可以添加的角色〉
     *
     * @param
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: francis
     * @date: 2019-06-05 23:00
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String userId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        // 查找添加角色的用户
        UserInfo userInfo = iUserService.findById(userId);
        // 查找符合添加的角色
        List<Role> roles = iUserService.findOtherRoles(userId);
        modelAndView.addObject("user", userInfo);
        modelAndView.addObject("roleList", roles);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    /**
     * 功能描述: 〈给用户添加角色〉
     * @param userId
     * @param roleIds
     * @return: java.lang.String
     * @author: francis
     * @date: 2019-06-05 23:57
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) throws Exception {
        iUserService.addRoleToUser(userId, roleIds);
        return "redirect:findAll.do";
    }
}