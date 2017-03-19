package com.model.po;

/**
 * Created by Administrator on 2017/3/19.
 */
public class CreatePointOrderResp {
//     <Sender>互联星空</Sender>
//      <Reciver>积分平台</Reciver>
//      <Total>2</Total >
//      <ProcessCode />
//      <Description>返回操作结果信息</Description>
//      <ActiveCode>0991</ActiveCode>

    private String sender;
    private String  reciver;
    private int  total;
    private String processCode;
    private String  description;
    private String activeCode;
    //系统错误编码
    private  String faultcode;
    //系统错误信息
    private String faultstring;
    //业务错误编码
    private String errCode;
    //业务错误信息
    private String errDesc;

    public String getFaultcode() {
        return faultcode;
    }

    public void setFaultcode(String faultcode) {
        this.faultcode = faultcode;
    }

    public String getFaultstring() {
        return faultstring;
    }

    public void setFaultstring(String faultstring) {
        this.faultstring = faultstring;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrDesc() {
        return errDesc;
    }

    public void setErrDesc(String errDesc) {
        this.errDesc = errDesc;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }
}
