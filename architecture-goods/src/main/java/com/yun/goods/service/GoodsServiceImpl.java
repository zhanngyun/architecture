package com.yun.goods.service;

import com.yun.common.service.BaseService;
import com.yun.goods.dao.GoodsDAO;
import com.yun.goods.vo.GoodsModel;
import com.yun.goods.vo.GoodsQueryModel;
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
public class GoodsServiceImpl extends BaseService<GoodsModel,GoodsQueryModel> implements IGoodsService {

    private GoodsDAO goodsDAO = null;

    @Autowired
    private void setGoodsDAO(GoodsDAO goodsDAO){
        this.goodsDAO = goodsDAO;
        super.setDao(goodsDAO);
    }

}
