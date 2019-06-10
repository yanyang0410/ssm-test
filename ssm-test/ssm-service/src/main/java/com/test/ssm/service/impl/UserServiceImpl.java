package com.test.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.ssm.domain.Role;
import com.test.ssm.domain.UserInfo;
import com.test.ssm.mapper.IUserMapper;
import com.test.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description: 用户Servcice实现
 * @Author: francis
 * @Date: 2019-05-30 22:07
 * @Version: 1.0
 */
@Service("userServiceImpl")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper iUserDao;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 功能描述: 〈使用spring security登录拦截校验〉
     *
     * @param username
     * @return: org.springframework.security.core.userdetails.UserDetails
     * @author: francis
     * @date: 2019-06-02 22:02
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = iUserDao.findByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        //User user = new User(userInfo.getUsername(), userInfo.getPassword(), getAuthority(userInfo.getRoles()));
        return user;
    }

    /**
     * 功能描述: 〈查询所有用户〉
     *
     * @param page
     * @param pageSize
     * @return: java.util.List<com.test.ssm.domain.UserInfo>
     * @author: francis
     * @date: 2019-05-30 22:25
     */
    @Override
    public List<UserInfo> findAll(int page, int pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return iUserDao.findAll();
    }

    /**
     * 功能描述: 〈保存用户信息〉
     *
     * @param userInfo
     * @return: java.lang.String
     * @author: francis
     * @date: 2019-06-02 15:04
     */
    @Override
    public void save(UserInfo userInfo) throws Exception {
        // 使用spring security进行密码加密
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword().trim()));
        iUserDao.save(userInfo);
    }

    /**
     * 功能描述: 〈用户详情信息〉
     *
     * @param id
     * @return: com.test.ssm.domain.UserInfo
     * @author: francis
     * @date: 2019-06-02 16:32
     */
    @Override
    public UserInfo findById(String id) throws Exception {
        return iUserDao.findById(id);
    }

    /**
     * 功能描述: 〈查询用户以及用户可以添加的角色〉
     *
     * @param userId
     * @return: java.util.List<com.test.ssm.domain.Role>
     * @author: francis
     * @date: 2019-06-05 23:05
     */
    @Override
    public List<Role> findOtherRoles(String userId) throws Exception {
        return iUserDao.findOtherRoles(userId);
    }

    /**
     * 功能描述: 〈用户添加角色〉
     *
     * @param userId
     * @param roleIds
     * @return: void
     * @author: francis
     * @date: 2019-06-05 23:59
     */
    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {
        for (String roleId : roleIds) {
            iUserDao.addRoleToUser(userId, roleId);
        }
    }

    /**
     * 功能描述: 〈作用就是返回一个List集合，集合中装入的是角色描述〉
     *
     * @param roles
     * @return: java.util.List<org.springframework.security.core.authority.SimpleGrantedAuthority>
     * @author: francis
     * @date: 2019-06-04 23:07
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            String roleName = "ROLE_" + role.getRoleName();
            list.add(new SimpleGrantedAuthority(roleName));
        }
        return list;
    }
}