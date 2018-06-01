package com.yun.cart.vo;

import com.yun.common.vo.BaseModel;

/**
 * @author yzhang
 * @date 2018/5/27 16:20
 * @desc 用户信息表
 */
public class CartModel extends BaseModel{


    private Integer customerUuid;
    private Integer goodsUuid;
    private Integer buyNum;



    public Integer getCustomerUuid() {
        return customerUuid;
    }

    public void setCustomerUuid(Integer customerUuid) {
        this.customerUuid = customerUuid;
    }

    public Integer getGoodsUuid() {
        return goodsUuid;
    }

    public void setGoodsUuid(Integer goodsUuid) {
        this.goodsUuid = goodsUuid;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }
}
