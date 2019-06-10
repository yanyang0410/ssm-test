package com.test.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.test.ssm.domain.Product;
import com.test.ssm.mapper.IProductMapper;
import com.test.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: ProductServiceImpl
 * @Description: 产品信息实现
 * @Author: francis
 * @Date: 2019-05-19 22:14
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductMapper iProductMapper;

    @Override
    public List<Product> findAll(int page, int pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return iProductMapper.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        iProductMapper.save(product);
    }
}