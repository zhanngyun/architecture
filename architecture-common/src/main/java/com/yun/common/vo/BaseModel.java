package com.yun.common.vo;

import com.yun.common.utils.pageUtils.Page;

import java.util.Objects;

/**
 * @author yzhang
 * @date 2018/5/27 21:17
 * @desc
 */
public class BaseModel {

    private Page page = new Page();


    private Integer uuid;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseModel that = (BaseModel) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
