package com.test.ssm.service;

import com.test.ssm.domain.Orders;

import java.util.List;

/**
 * @ClassName: IOrdersService
 * @Description: 订单Service
 * @Author: francis
 * @Date: 2019-05-26 00:42
 * @Version: 1.0
 */
public interface IOrdersService {

    /**
     * 功能描述: 〈查询所有订单信息-未分页〉
     * @param
     * @return: void
     * @author: francis
     * @date: 2019-05-26 13:48
     */
    List<Orders> findAll() throws Exception;

    /**
     * 功能描述: 〈查询所有订单信息〉
     * @param
     * @return: java.util.List<com.test.ssm.domain.Orders>
     * @author: francis
     * @date: 2019-05-26 00:46
     */
    List<Orders> findAll(int page,int pageSize) throws Exception;

    /**
     * 功能描述: 〈查询订单详细信息〉
     * @param id
     * @return: com.test.ssm.domain.Orders
     * @author: francis
     * @date: 2019-05-26 16:16
     */
    Orders findById(String id)throws Exception;
}
