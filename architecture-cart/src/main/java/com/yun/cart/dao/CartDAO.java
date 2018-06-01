package com.yun.cart.dao;

import com.yun.cart.vo.CartModel;
import com.yun.cart.vo.CartQueryModel;
import com.yun.common.dao.BaseDAO;
import org.springframework.stereotype.Repository;

/**
 * @author yzhang
 * @date 2018/5/27 16:30
 * @desc
 */
@Repository
public interface  CartDAO extends BaseDAO<CartModel,CartQueryModel>{

}
