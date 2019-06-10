package com.test.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.ssm.domain.Orders;
import com.test.ssm.mapper.IOrdersMapper;
import com.test.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: OrdersServieImpl
 * @Description: 订单Service实现
 * @Author: francis
 * @Date: 2019-05-26 00:42
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrdersServieImpl implements IOrdersService {

    @Autowired
    private IOrdersMapper iOrdersMapper;

    /**
     * 功能描述: 〈查询所有订单信息-未分页〉
     *
     * @param
     * @return: void
     * @author: francis
     * @date: 2019-05-26 13:49
     */
    @Override
    public List<Orders> findAll() throws Exception {
        return iOrdersMapper.findAll();
    }

    /**
     * 功能描述: 〈查询所有订单信息〉
     *
     * @param
     * @return: java.util.List<com.test.ssm.domain.Orders>
     * @author: francis
     * @date: 2019-05-26 00:46
     */
    @Override
    public List<Orders> findAll(int page, int pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return iOrdersMapper.findAll();
    }

    /**
     * 功能描述: 〈查询订单详细信息〉
     * @param id
     * @return: com.test.ssm.domain.Orders
     * @author: francis
     * @date: 2019-05-26 16:16
     */
    @Override
    public Orders findById(String id) throws Exception {
        return iOrdersMapper.findById(id);
    }
}