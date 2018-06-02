package com.yun.common.service;

import com.yun.common.utils.pageUtils.Page;
import com.yun.common.vo.BaseModel;
import org.apache.ibatis.annotations.Param;

/**
 * @author yzhang
 * @date 2018/5/27 21:06
 * @desc
 */
public interface IBaseService<M, QM extends BaseModel> {
    Integer create(M cm);

    void update(M cm);

    void delete(@Param("uuid") int uuid);

    M getByUuid(@Param("uuid") int uuid);

    Page<M> getByConditionPage(QM cqm);
}
