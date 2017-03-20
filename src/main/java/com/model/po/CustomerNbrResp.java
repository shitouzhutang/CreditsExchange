package com.model.po;

import com.utils.CsbAttr;

/**
 * Created by Administrator on 2017/3/20.
 */
public class CustomerNbrResp {
    @CsbAttr(name="errCode")
    private String errCode;
    @CsbAttr(name="errMessage")
    private String errMessage;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
