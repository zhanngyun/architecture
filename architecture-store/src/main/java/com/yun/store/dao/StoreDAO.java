package com.yun.store.dao;

import com.yun.common.dao.BaseDAO;
import com.yun.store.vo.StoreModel;
import com.yun.store.vo.StoreQueryModel;
import org.springframework.stereotype.Repository;

/**
 * @author yzhang
 * @date 2018/5/27 16:30
 * @desc
 */
@Repository
public interface StoreDAO extends BaseDAO<StoreModel,StoreQueryModel>{

}
