package com.yun.common.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yzhang
 * @date 2018/5/27 21:03
 * @desc 基类
 */
public interface BaseDAO<M, QM> {

    Integer create(M cm);

    void update(M cm);

    void delete(@Param("uuid") int uuid);

    M getByUuid(@Param("uuid") int uuid);

    List<M> getByConditionPage(QM cqm);
}
