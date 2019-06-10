package com.test.ssm.mapper;

import com.test.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: IMemberMapper
 * @Description: 会员Mapper
 * @Author: francis
 * @Date: 2019-05-26 16:20
 * @Version: 1.0
 */
public interface IMemberMapper {

    /**
     * 功能描述: 〈根据产品id查询会员信息〉
     * @param id
     * @return: com.test.ssm.domain.Member
     * @author: francis
     * @date: 2019-05-26 16:21
     */
    @Select(value = "select * from member where id=#{id}")
    Member findById(String id) throws Exception;
}
