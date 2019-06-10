package com.test.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.test.ssm.domain.Product;
import com.test.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName: ProdcutController
 * @Description: 产品信息控制器
 * @Author: francis
 * @Date: 2019-05-19 23:09
 * @Version: 1.0
 */
@Controller
@RequestMapping("/product")
public class ProdcutController {

    @Autowired
    private IProductService productService;

    /**
     * 功能描述: 〈查询所有产品信息〉
     * @param
     * @return: org.springframework.web.servlet.ModelAndView
     * @author: francis
     * @date: 2019-05-22 23:39
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productServiceAll = productService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(productServiceAll);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    /**
     * 功能描述: 〈产品信息保存〉
     * @param product
     * @return: java.lang.String
     * @author: francis
     * @date: 2019-06-02 15:01
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }

}