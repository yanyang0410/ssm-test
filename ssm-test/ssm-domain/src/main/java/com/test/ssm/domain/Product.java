package com.test.ssm.domain;

import com.test.ssm.utils.DateUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Product
 * @Description: 产品信息
 * @Author: francis
 * @Date: 2019-05-19 20:38
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = -7737367688397077566L;
    /**
     * 主键
     */
    private String id;
    /**
     * 编号 唯一
     */
    private String productNum;
    /**
     * 名称
     */
    private String productName;
    /**
     * 出发城市
     */
    private String cityName;
    /**
     * 出发时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date departureTime;
    /**
     * 出发时间映射
     */
    private String departureTimeStr;
    /**
     * 产品价格
     */
    private double productPrice;
    /**
     * 产品描述
     */
    private String productDesc;
    /**
     * 状态 0 关闭 1 开启
     */
    private Integer productStatus;
    /**
     * 产品信息状态映射
     */
    private String productStatusStr;

    public String getDepartureTimeStr() {
        if (departureTime != null) {
            departureTimeStr = DateUtils.date2String(departureTime, "yyyy-mm-dd hh:MM:ss");
        }
        return departureTimeStr;
    }

    public String getProductStatusStr() {
        if (productStatus != null) {
            if (productStatus == 0){
                productStatusStr = "关闭";
            }else {
                productStatusStr = "开启";
            }
        }
        return productStatusStr;
    }
}