package com.test.ssm.mapper;

import com.test.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: IProductMapper
 * @Description: 产品信息Mapper
 * @Author: francis
 * @Date: 2019-05-19 22:04
 * @Version: 1.0
 */
public interface IProductMapper {

    /**
     * 功能描述: 〈查询所有产品信息〉
     * @param
     * @return: List<Product>
     * @author: francis
     * @date: 2019-05-19 22:10
     */
    @Select(value = "select * from Product")
    List<Product> findAll() throws Exception;

    /**
     * 功能描述: 〈保存产品信息〉
     * @param product
     * @return: void
     * @author: francis
     * @date: 2019-05-23 00:05
     */
    @Insert(value = "insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    /**
     * 功能描述: 〈根据产品id查询产品信息〉
     * @param id
     * @return: com.test.ssm.domain.Product
     * @author: francis
     * @date: 2019-05-26 13:21
     */
    @Select(value = "select * from product where id=#{id}")
    Product findById(String id) throws Exception;
}
