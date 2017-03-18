package com.model.po;

/**
 * Created by Administrator on 2017/3/17.
 */
public class SearchRestPointsReq {
    //类别（1、设备号 2、客户号）
    private  String inputType;
    //客户号
    private  String crmId;
    //设备号
    private  String deviceId;
    //受理工号
    private  String csrId;
    //开始时间
    private  String startDate;
    //结束时间
    private  String endDate;
    //渠道
    private  String source;
    //接触流水号ID
    private  String contactID;

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getCrmId() {
        return crmId;
    }

    public void setCrmId(String crmId) {
        this.crmId = crmId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCsrId() {
        return csrId;
    }

    public void setCsrId(String csrId) {
        this.csrId = csrId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContactID() {
        return contactID;
    }

    public void setContactID(String contactID) {
        this.contactID = contactID;
    }
}
