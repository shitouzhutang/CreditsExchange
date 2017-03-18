package com.model.vo;

/**
 * Created by Administrator on 2017/3/17.
 */
public class ExchangeVo {
    //客户编号
    private  String customNo;
    //设备编号  （手机号码）
    private String serialNo;
    //是否黑名单
    private  String  limitNo;
    //积分余额
    private String restPoints;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getLimitNo() {
        return limitNo;
    }

    public void setLimitNo(String limitNo) {
        this.limitNo = limitNo;
    }

    public String getCustomNo() {
        return customNo;
    }

    public void setCustomNo(String customNo) {
        this.customNo = customNo;
    }

    public String getRestPoints() {
        return restPoints;
    }

    public void setRestPoints(String restPoints) {
        this.restPoints = restPoints;
    }
}
