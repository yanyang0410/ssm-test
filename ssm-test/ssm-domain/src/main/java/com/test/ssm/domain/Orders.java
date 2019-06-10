package com.test.ssm.domain;

import com.test.ssm.utils.DateUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: Orders
 * @Description: 订单详情信息
 * @Author: francis
 * @Date: 2019-05-23 23:48
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键 UUID
     */
    private String id;
    /**
     * 订单编号
     */
    private String orderNum;
    /**
     * 下单时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date orderTime;
    /**
     * 下单时间类型转换
     */
    private String orderTimeStr;
    /**
     * 出行人数
     */
    private int peopleCount;
    /**
     * 订单描述(其它信息)
     */
    private String orderDesc;
    /**
     * 支付方式(0 支付宝 1 微信 2其它)
     */
    private int payType;
    /**
     * 支付方式类型转换
     */
    private String payTypeStr;
    /**
     * 订单状态(0 未支付 1 已支付)
     */
    private int orderStatus;
    /**
     * 订单状态类型转换
     */
    private String orderStatusStr;
    /**
     * 产品id 外键
     */
    private String productid;
    /**
     * 会员(联系人）id 外键
     */
    private String memberid;
    /**
     * 产品信息
     */
    private Product product;
    /**
     * 会员信息
     */
    private Member member;
    /**
     * 旅客信息
     */
    private List<Traveller> travellers;

    public String getOrderTimeStr() {
        if (orderTime != null) {
            orderTimeStr = DateUtils.date2String(orderTime, "yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    public String getPayTypeStr() {
        if (payType == 0) {
            payTypeStr = "支付宝";
        } else if (payType == 1) {
            payTypeStr = "微信";
        } else {
            payTypeStr = "其他";
        }
        return payTypeStr;
    }

    public String getOrderStatusStr() {
        if (orderStatus == 0) {
            orderStatusStr = "未支付";
        } else {
            orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }
}

