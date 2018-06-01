package com.yun.order.vo;

import com.yun.common.vo.BaseModel;

import java.math.BigDecimal;

/**
 * @author yzhang
 * @date 2018/5/27 16:20
 * @desc 用户信息表
 */
public class OrderDetailModel extends BaseModel{


    private Integer orderUuid;
    private Integer goodsUuid;
    private Integer orderNum;
    private BigDecimal price;
    private BigDecimal money;
    private BigDecimal saveMoney;

    public Integer getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(Integer orderUuid) {
        this.orderUuid = orderUuid;
    }

    public Integer getGoodsUuid() {
        return goodsUuid;
    }

    public void setGoodsUuid(Integer goodsUuid) {
        this.goodsUuid = goodsUuid;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(BigDecimal saveMoney) {
        this.saveMoney = saveMoney;
    }

    @Override
    public String toString() {
        return "OrderDetailModel{" +
                "orderUuid=" + orderUuid +
                ", goodsUuid=" + goodsUuid +
                ", orderNum=" + orderNum +
                ", price=" + price +
                ", money=" + money +
                ", saveMoney=" + saveMoney +
                '}';
    }
}
