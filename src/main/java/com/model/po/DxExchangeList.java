package com.model.po;

public class DxExchangeList {
    private Integer id;

    private String time;

    private String serialNo;

    private String phone;

    private String equiNum;

    private String operator;

    private String resultCode;

    private String faultCode;

    private String faultString;

    private String errCode;

    private String errDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEquiNum() {
        return equiNum;
    }

    public void setEquiNum(String equiNum) {
        this.equiNum = equiNum == null ? null : equiNum.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode == null ? null : resultCode.trim();
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode == null ? null : faultCode.trim();
    }

    public String getFaultString() {
        return faultString;
    }

    public void setFaultString(String faultString) {
        this.faultString = faultString == null ? null : faultString.trim();
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode == null ? null : errCode.trim();
    }

    public String getErrDesc() {
        return errDesc;
    }

    public void setErrDesc(String errDesc) {
        this.errDesc = errDesc == null ? null : errDesc.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", time=").append(time);
        sb.append(", serialNo=").append(serialNo);
        sb.append(", phone=").append(phone);
        sb.append(", equiNum=").append(equiNum);
        sb.append(", operator=").append(operator);
        sb.append(", resultCode=").append(resultCode);
        sb.append(", faultCode=").append(faultCode);
        sb.append(", faultString=").append(faultString);
        sb.append(", errCode=").append(errCode);
        sb.append(", errDesc=").append(errDesc);
        sb.append("]");
        return sb.toString();
    }
}