package com.yun.customer.vo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author yzhang
 * @date 2018/5/27 16:20
 * @desc 用户信息表
 */
public class CustomerModel implements Serializable{

    private static final long serialVersionUID = -345887124864170203L;
    private Integer uuid;
    private String customerId;
    private String pwd;
    private String showName;
    private String trueName;
    private String registerTime;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerModel that = (CustomerModel) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "uuid=" + uuid +
                ", customerId='" + customerId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", showName='" + showName + '\'' +
                ", trueName='" + trueName + '\'' +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }
}
