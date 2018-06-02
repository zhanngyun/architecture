package com.yun.customer.dao;

import com.yun.common.dao.BaseDAO;
import com.yun.customer.vo.CustomerModel;
import com.yun.customer.vo.CustomerQueryModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yzhang
 * @date 2018/5/27 16:30
 * @desc
 */
@Repository
public interface CustomerDAO extends BaseDAO<CustomerModel,CustomerQueryModel>{

    public CustomerModel getByCustomerId(@Param("customerId") String customerId);

}
