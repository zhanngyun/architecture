package com.yun.customer.dao;

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
public interface CustomerDAO {
    public void create(CustomerModel cm);
    public void update(CustomerModel cm);
    public void delete(@Param("uuid") int uuid);

    public CustomerModel getByUuid(@Param("uuid") int uuid);
    public List<CustomerModel> getByCondition(CustomerQueryModel cqm);
}
