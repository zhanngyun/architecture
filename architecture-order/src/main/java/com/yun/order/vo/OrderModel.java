package com.yun.order.vo;

import com.yun.common.vo.BaseModel;

import java.math.BigDecimal;

/**
 * @author yzhang
 * @date 2018/5/27 16:20
 * @desc 用户信息表
 */
public class OrderModel extends BaseModel{


    private Integer customerUuid;
    private String orderTime;
    private BigDecimal totalMoney;
    private BigDecimal saveMoney;
    private String state;

    public Integer getCustomerUuid() {
        return customerUuid;
    }

    public void setCustomerUuid(Integer customerUuid) {
        this.customerUuid = customerUuid;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public BigDecimal getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(BigDecimal saveMoney) {
        this.saveMoney = saveMoney;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "customerUuid=" + customerUuid +
                ", orderTime='" + orderTime + '\'' +
                ", totalMoney=" + totalMoney +
                ", saveMoney=" + saveMoney +
                ", state='" + state + '\'' +
                '}';
    }
}
