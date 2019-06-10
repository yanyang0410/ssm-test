package com.test.ssm.mapper;

import com.test.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: ITravellerMapper
 * @Description: 旅客Mapper
 * @Author: francis
 * @Date: 2019-05-26 16:22
 * @Version: 1.0
 */
public interface ITravellerMapper {

    /**
     * 功能描述: 〈根据订单id查询旅客信息〉
     * @param ordersId
     * @return: java.util.List<com.test.ssm.domain.Traveller>
     * @author: francis
     * @date: 2019-05-26 16:23
     */
    @Select(value = "select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
