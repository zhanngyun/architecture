package com.yun.goods.vo;

import com.yun.common.vo.BaseModel;

/**
 * @author yzhang
 * @date 2018/5/27 16:20
 * @desc 用户信息表
 */
public class GoodsModel extends BaseModel{


    private String name;
    private String imgPath;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GoodsModel{" +
                "name='" + name + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
