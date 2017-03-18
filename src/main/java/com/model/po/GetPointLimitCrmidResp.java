package com.model.po;

import com.utils.CsbAttr;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2017/3/16.
 */
public class GetPointLimitCrmidResp {


    @CsbAttr(name = "getLimitCrmidReturn")
    private String getLimitCrmidReturn;

    @CsbAttr(name = "ErrCode")
    private String csbErrCode;

    @CsbAttr(name = "ErrDesc")
    private String csbErrDesc;

    @CsbAttr(name = "faultcode")
    private String sgwErrCode;

    @CsbAttr(name = "faultstring")
    private String sgwErrDesc;

    public String getErrCode() {
        String errCode = StringUtils.isEmpty(csbErrCode)? sgwErrCode : csbErrCode;
        return errCode;
    }

    public String getErrDesc() {
        String errDesc = StringUtils.isEmpty(csbErrDesc)? sgwErrDesc : csbErrDesc;
        return errDesc;
    }


    public String getGetLimitCrmidReturn() {
        return getLimitCrmidReturn;
    }

    public void setGetLimitCrmidReturn(String getLimitCrmidReturn) {
        this.getLimitCrmidReturn = getLimitCrmidReturn;
    }
    public String getCsbErrCode() {
        return csbErrCode;
    }

    public void setCsbErrCode(String csbErrCode) {
        this.csbErrCode = csbErrCode;
    }

    public String getCsbErrDesc() {
        return csbErrDesc;
    }

    public void setCsbErrDesc(String csbErrDesc) {
        this.csbErrDesc = csbErrDesc;
    }

    public String getSgwErrCode() {
        return sgwErrCode;
    }

    public void setSgwErrCode(String sgwErrCode) {
        this.sgwErrCode = sgwErrCode;
    }

    public String getSgwErrDesc() {
        return sgwErrDesc;
    }

    public void setSgwErrDesc(String sgwErrDesc) {
        this.sgwErrDesc = sgwErrDesc;
    }
}
