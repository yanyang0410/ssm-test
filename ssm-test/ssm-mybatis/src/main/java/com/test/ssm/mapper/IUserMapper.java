package com.test.ssm.mapper;

import com.test.ssm.domain.Role;
import com.test.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName: IUserMapper
 * @Description: 用户Mapper
 * @Author: francis
 * @Date: 2019-05-30 22:11
 * @Version: 1.0
 */
public interface IUserMapper {

    /**
     * 功能描述: 〈查询所有用户信息〉
     *
     * @param
     * @return: java.util.List<com.test.ssm.domain.UserInfo>
     * @author: francis
     * @date: 2019-05-30 22:12
     */
    @Select(value = "select * from USERS")
    List<UserInfo> findAll() throws Exception;

    /**
     * 功能描述: 〈保存用户信息〉
     *
     * @param userInfo
     * @return: void
     * @author: francis
     * @date: 2019-06-02 15:05
     */
    @Insert(value = "insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    /**
     * 功能描述: 〈用户详情信息〉
     *
     * @param id
     * @return: com.test.ssm.domain.UserInfo
     * @author: francis
     * @date: 2019-06-02 16:33
     */
    @Select(value = "select * from users where id=#{id}")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"), @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"), @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"), @Result(column = "status", property = "status"),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "com.test.ssm.mapper.IRoleMapper.findRoleByUserId"))
    })
    UserInfo findById(String id) throws Exception;

    /**
     * 功能描述: 〈查询用户信息〉
     *
     * @param username
     * @return: com.test.ssm.domain.UserInfo
     * @author: francis
     * @date: 2019-06-02 23:12
     */
    @Select(value = "select * from users where username=#{username}")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "com.test.ssm.mapper.IRoleMapper.findRoleByUserId"))
    })
    UserInfo findByUserName(String username) throws Exception;

    /**
     * 功能描述: 〈查询用户以及用户可以添加的角色〉
     *
     * @param userId
     * @return: java.util.List<com.test.ssm.domain.Role>
     * @author: francis
     * @date: 2019-06-05 23:06
     */
    @Select(value = "select * from ROLE where id not in (select userid from USERS_ROLE where USERID = #{userId} )")
    List<Role> findOtherRoles(String userId);

    /**
     * 功能描述: 〈用户添加角色〉
     *
     * @param userId
     * @param roleId
     * @return: void
     * @author: francis
     * @date: 2019-06-06 00:00
     */
    @Insert(value = "insert into USERS_ROLE (USERID, ROLEID) values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}