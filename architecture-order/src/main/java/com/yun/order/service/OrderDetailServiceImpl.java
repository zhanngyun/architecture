package com.yun.order.service;

import com.yun.common.service.BaseService;
import com.yun.order.dao.OrderDetailDAO;
import com.yun.order.vo.OrderDetailModel;
import com.yun.order.vo.OrderDetailQueryModel;
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
public class OrderDetailServiceImpl extends BaseService<OrderDetailModel,OrderDetailQueryModel> implements IOrderDetailService {

    private OrderDetailDAO orderDetailDAO = null;

    @Autowired
    private void setOrderDetailDAO(OrderDetailDAO orderDetailDAO){
        this.orderDetailDAO = orderDetailDAO;
        super.setDao(orderDetailDAO);
    }

}
