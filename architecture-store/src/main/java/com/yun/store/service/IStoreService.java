package com.yun.store.service;

import com.yun.common.service.IBaseService;
import com.yun.store.vo.StoreModel;
import com.yun.store.vo.StoreQueryModel;

/**
 * @author yzhang
 * @date 2018/5/27 23:01
 * @desc
 */
public interface IStoreService extends IBaseService<StoreModel,StoreQueryModel> {


    public StoreModel getStoreByGoodsUuid(Integer goodsUuid);
}
