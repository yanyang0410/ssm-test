package com.test.ssm.service;

import com.test.ssm.domain.Product;

import java.util.List;

/**
 * @ClassName: IProductService
 * @Description: 产品信息Service
 * @Author: francis
 * @Date: 2019-05-19 22:00
 * @Version: 1.0
 */
public interface IProductService {
    /**
     * 功能描述: 〈查询所有产品信息〉
     *
     * @param
     * @param page
     * @param pageSize
     * @return: List<Product>
     * @author: francis
     * @date: 2019-05-19 21:56
     */
    List<Product> findAll(int page, int pageSize) throws Exception;

    /**
     * 功能描述: 〈保存产品〉
     * @param product
     * @return: void
     * @author: francis
     * @date: 2019-05-22 23:59
     */
    void save(Product product) throws Exception;
}
