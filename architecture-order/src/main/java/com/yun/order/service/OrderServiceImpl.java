package com.yun.order.service;

import com.yun.common.service.BaseService;
import com.yun.order.dao.OrderDAO;
import com.yun.order.vo.OrderModel;
import com.yun.order.vo.OrderQueryModel;
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
public class OrderServiceImpl extends BaseService<OrderModel,OrderQueryModel> implements IOrderService {

    private OrderDAO orderDAO = null;

    @Autowired
    private void setOrderDAO(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
        super.setDao(orderDAO);
    }

}
