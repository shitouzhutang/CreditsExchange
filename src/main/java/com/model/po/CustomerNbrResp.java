package com.model.po;

import com.utils.CsbAttr;

/**
 * Created by Administrator on 2017/3/20.
 */
public class CustomerNbrResp {
    @CsbAttr(name="errCode")
    private String err_code;
    @CsbAttr(name="errMessage")
    private String err_desc;
    @CsbAttr(name="custNumber")
    private String cust_number;

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_desc() {
        return err_desc;
    }

    public void setErr_desc(String err_desc) {
        this.err_desc = err_desc;
    }

    public String getCust_number() {
        return cust_number;
    }

    public void setCust_number(String cust_number) {
        this.cust_number = cust_number;
    }
}
