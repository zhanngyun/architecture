package com.yun.common.service;

import com.yun.common.dao.BaseDAO;
import com.yun.common.utils.pageUtils.Page;
import com.yun.common.vo.BaseModel;

import java.util.List;

/**
 * @author yzhang
 * @date 2018/5/27 21:08
 * @desc
 */
public class BaseService<M, QM extends BaseModel> implements IBaseService<M, QM> {

    private BaseDAO dao = null;

    public void setDao(BaseDAO dao) {
        this.dao = dao;
    }

    @Override
    public Integer create(M cm) {
        return dao.create(cm);
    }

    @Override
    public void update(M cm) {
        dao.update(cm);
    }

    @Override
    public void delete(int uuid) {
        dao.delete(uuid);
    }

    @Override
    public M getByUuid(int uuid) {
        return (M) dao.getByUuid(uuid);
    }

    @Override
    public Page<M> getByConditionPage(QM cqm) {
        List list = dao.getByConditionPage(cqm);
        cqm.getPage().setResult(list);
        return cqm.getPage();
    }
}
