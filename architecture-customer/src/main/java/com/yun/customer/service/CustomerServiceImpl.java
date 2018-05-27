package com.yun.customer.service;

import com.yun.common.service.BaseService;
import com.yun.customer.dao.CustomerDAO;
import com.yun.customer.vo.CustomerModel;
import com.yun.customer.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yzhang
 * @date 2018/5/27 23:03
 * @desc
 */
@Service
@Transactional
public class CustomerServiceImpl extends BaseService<CustomerModel,CustomerQueryModel> implements ICustomerService {

    private CustomerDAO customerDAO = null;

    @Autowired
    private void setCustomerDAO(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
        super.setDao(customerDAO);
    }

}
