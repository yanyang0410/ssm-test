package com.test.ssm.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: Traveller
 * @Description: 旅客详细信息
 * @Author: francis
 * @Date: 2019-05-23 23:50
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Traveller implements Serializable {

    private static final long serialVersionUID = 6644252989819982037L;
    /**
     * 主键 UUID
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 电话号码
     */
    private String phoneNum;
    /**
     * 证件类型 0身份证 1护照 2军官证
     */
    private int credentialsType;
    /**
     * 证件类型转换
     */
    private String credentialsTypeStr;
    /**
     * 证件号码
     */
    private String credentialsNum;
    /**
     * 旅客类型(人群) 0 成人 1 儿童
     */
    private int travellerType;
    /**
     * 旅客类型转换
     */
    private String travellerTypeStr;

    public String getCredentialsTypeStr() {
        if (credentialsType == 0) {
            credentialsTypeStr = "身份证";
        } else if (credentialsType == 1){
            credentialsTypeStr = "护照";
        }else {
            credentialsTypeStr = "军官证";
        }
        return credentialsTypeStr;
    }

    public String getTravellerTypeStr() {
        if (travellerType == 0){
            travellerTypeStr = "成年人";
        }else {
            travellerTypeStr = "未成年人";
        }
        return travellerTypeStr;
    }
}