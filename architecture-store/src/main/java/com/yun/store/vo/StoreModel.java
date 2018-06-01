package com.yun.store.vo;

import com.yun.common.vo.BaseModel;

/**
 * @author yzhang
 * @date 2018/5/27 16:20
 * @desc 用户信息表
 */
public class StoreModel extends BaseModel{


    private Integer goodsUuid;
    private Integer storeNum;

    public Integer getGoodsUuid() {
        return goodsUuid;
    }

    public void setGoodsUuid(Integer goodsUuid) {
        this.goodsUuid = goodsUuid;
    }

    public Integer getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(Integer storeNum) {
        this.storeNum = storeNum;
    }

    @Override
    public String toString() {
        return "StoreModel{" +
                "goodsUuid=" + goodsUuid +
                ", storeNum=" + storeNum +
                '}';
    }
}
