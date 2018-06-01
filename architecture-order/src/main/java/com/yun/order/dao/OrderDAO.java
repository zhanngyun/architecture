package com.yun.order.dao;

import com.yun.common.dao.BaseDAO;
import com.yun.order.vo.OrderModel;
import com.yun.order.vo.OrderQueryModel;
import org.springframework.stereotype.Repository;

/**
 * @author yzhang
 * @date 2018/5/27 16:30
 * @desc
 */
@Repository
public interface OrderDAO extends BaseDAO<OrderModel,OrderQueryModel>{

}
