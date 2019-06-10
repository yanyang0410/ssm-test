package com.test.ssm.mapper;

import com.test.ssm.domain.Member;
import com.test.ssm.domain.Orders;
import com.test.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName: IOrdersMapper
 * @Description: 订单Mapper
 * @Author: francis
 * @Date: 2019-05-26 00:44
 * @Version: 1.0
 */
public interface IOrdersMapper {

    /**
     * 功能描述: 〈查询所有订单信息〉
     *
     * @param
     * @return: java.util.List<com.test.ssm.domain.Orders>
     * @author: francis
     * @date: 2019-05-26 00:45
     */
    @Select(value = "select * from orders")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.test.ssm.mapper.IProductMapper.findById")),
    })
    List<Orders> findAll() throws Exception;

    /**
     * 功能描述: 〈查询订单详细信息〉
     * @param id
     * @return: com.test.ssm.domain.Orders
     * @author: francis
     * @date: 2019-05-26 16:17
     */
    @Select(value = "select * from orders where id=#{ordersId}")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.test.ssm.mapper.IProductMapper.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "com.test.ssm.mapper.IMemberMapper.findById")),
            @Result(property = "travellers", column = "id", javaType = List.class, many = @Many(select = "com.test.ssm.mapper.ITravellerMapper.findByOrdersId"))
    })
    Orders findById(String id) throws Exception;
}