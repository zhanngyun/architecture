package com.yun.store.service;

import com.yun.common.service.BaseService;
import com.yun.store.dao.StoreDAO;
import com.yun.store.vo.StoreModel;
import com.yun.store.vo.StoreQueryModel;
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
public class StoreServiceImpl extends BaseService<StoreModel,StoreQueryModel> implements IStoreService {

    private StoreDAO storeDAO = null;

    @Autowired
    private void setStoreDAO(StoreDAO storeDAO){
        this.storeDAO = storeDAO;
        super.setDao(storeDAO);
    }

    @Override
    public StoreModel getStoreByGoodsUuid(Integer goodsUuid) {
        return storeDAO.getStoreByGoodsUuid(goodsUuid);
    }
}
