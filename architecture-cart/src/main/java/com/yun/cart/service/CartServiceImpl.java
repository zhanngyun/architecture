package com.yun.cart.service;

import com.yun.cart.dao.CartDAO;
import com.yun.cart.vo.CartModel;
import com.yun.cart.vo.CartQueryModel;
import com.yun.common.service.BaseService;
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
public class CartServiceImpl extends BaseService<CartModel,CartQueryModel> implements ICartService {

    private CartDAO cartDAO = null;

    @Autowired
    private void setCartDAO(CartDAO cartDAO){
        this.cartDAO = cartDAO;
        super.setDao(cartDAO);
    }

}
