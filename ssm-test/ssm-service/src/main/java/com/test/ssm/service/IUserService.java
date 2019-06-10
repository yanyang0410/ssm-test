package com.test.ssm.service;

import com.test.ssm.domain.Role;
import com.test.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.nio.file.Watchable;
import java.util.List;

/**
 * @ClassName: IUserService
 * @Description: 用户Service
 * @Author: francis
 * @Date: 2019-05-30 22:05
 * @Version: 1.0
 */
public interface IUserService extends UserDetailsService {

    /**
     * 功能描述: 〈查找所有用户〉
     * @param
     * @param page
     * @param pageSize
     * @return: List<UserInfo>
     * @author: francis
     * @date: 2019-05-30 22:06
     */
    List<UserInfo> findAll(int page, int pageSize) throws Exception;

    /**
     * 功能描述: 〈保存用户信息〉
     * @param
     * @return: java.lang.String
     * @author: francis
     * @date: 2019-06-02 15:03
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * 功能描述: 〈用户详情信息〉
     * @param id
     * @return: com.test.ssm.domain.UserInfo
     * @author: francis
     * @date: 2019-06-02 16:32
     */
    UserInfo findById(String id) throws Exception;

    /**
     * 功能描述: 〈查询用户以及用户可以添加的角色〉
     * @param userId
     * @return: java.util.List<com.test.ssm.domain.Role>
     * @author: francis
     * @date: 2019-06-05 23:05
     */
    List<Role> findOtherRoles(String userId) throws Exception;

    /**
     * 功能描述: 〈用户添加角色〉
     * @param userId
     * @param roleIds
     * @return: void
     * @author: francis
     * @date: 2019-06-05 23:59
     */
    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
