package com.model.po;

import com.utils.CsbAttr;

/**
 * Created by Administrator on 2017/3/17.
 */
public class SearchRestPointsResp {
    //积分到期结束时间
    @CsbAttr(name = "deadline")
    private  String deadline;

    //错误信息
    @CsbAttr(name = "errorMsg")
    private  String errorMsg;
    //积分数额
    @CsbAttr(name = "points")
    private  String points;

    @CsbAttr(name = "ErrCode")
    private String errCode;

//    @CsbAttr(name = "ErrDesc")
//    private String errDesc;
//
//    @CsbAttr(name = "faultcode")
//    private String faultcode;
//
//    @CsbAttr(name = "faultstring")
//    private String faultstring;

//    public String getErrDesc() {
//        return errDesc;
//    }
//
//    public void setErrDesc(String errDesc) {
//        this.errDesc = errDesc;
//    }
//
//    public String getFaultcode() {
//        return faultcode;
//    }
//
//    public void setFaultcode(String faultcode) {
//        this.faultcode = faultcode;
//    }
//
//    public String getFaultstring() {
//        return faultstring;
//    }
//
//    public void setFaultstring(String faultstring) {
//        this.faultstring = faultstring;
//    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
