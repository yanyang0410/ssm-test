package com.test.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.test.ssm.domain.Orders;
import com.test.ssm.service.IOrdersService;
import com.test.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName: OrdersController
 * @Description: 订单信息控制器
 * @Author: francis
 * @Date: 2019-05-26 00:38
 * @Version: 1.0
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService iOrdersService;

    /**
     * 功能描述: 〈查询所有订单信息-未分页〉
     *
     * @param
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: francis
     * @date: 2019-05-26 13:48
     */
   /* @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = iOrdersService.findAll();
        // 将查询出来的数据，放入指定显示内容id中
        modelAndView.addObject("ordersList", ordersList);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }*/

    /**
     * 功能描述: 〈查询所有订单信息〉
     * @param
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: francis
     * @date: 2019-05-26 00:41
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = iOrdersService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        // 指定页面显示名称
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    /**
     * 功能描述: 〈查询订单详细信息〉
     * @param id
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: francis
     * @date: 2019-05-26 16:10
     */
    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = iOrdersService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

}