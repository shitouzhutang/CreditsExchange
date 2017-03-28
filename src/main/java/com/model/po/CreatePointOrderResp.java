package com.model.po;

import com.utils.CsbAttr;

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
    @CsbAttr(name="Sender")
    private String sender;
    @CsbAttr(name="Reciver")
    private String  reciver;
    @CsbAttr(name="OrderTotal")
    private int  total;
    @CsbAttr(name="MessageCode")
    private  String messageCode;
    @CsbAttr(name="ProcessCode")
    private String processCode;
    @CsbAttr(name="Description")
    private String  description;
    @CsbAttr(name="ActiveCode")
    private String activeCode;
    //系统错误编码
    @CsbAttr(name="faultcode")
    private  String faultcode;
    //系统错误信息
    @CsbAttr(name="faultstring")
    private String faultstring;
    //业务错误编码
    @CsbAttr(name="ErrCode")
    private String errCode;
    //业务错误信息
    @CsbAttr(name="ErrDesc")
    private String errDesc;
    @CsbAttr(name="OrderDetail")
    private String orderDetail;
    @CsbAttr(name="OrderLabel")
    private String orderLabel;

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getOrderLabel() {
        return orderLabel;
    }

    public void setOrderLabel(String orderLabel) {
        this.orderLabel = orderLabel;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

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
