package com.test.ssm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName: BCryptPasswordEncoderUtils
 * @Description: springSecurity密码加密工具类
 * @Author: francis
 * @Date: 2019-06-05 23:10
 * @Version: 1.0
 */
public class BCryptPasswordEncoderUtils {
    @Autowired
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    /**
     * 功能描述: 〈密码加密〉
     * @param password
     * @return: java.lang.String
     * @author: francis
     * @date: 2019-06-05 23:12
     */
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="admin";
        String pwd = encodePassword(password.trim());
        //$2a$10$tJHudmJh6MRPdiL7mv0yfe0nZJbDHuhl7sSTnqNC4DauMik9ppi4K
        //$2a$10$Ce8LB3jdYDZ2f6HB281zA.4eC7v6ziJdK8MMWg0Yu8ETMg5ToMpIe
        System.out.println(pwd.trim());
        System.out.print(pwd.length());
    }

}