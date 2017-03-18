package com.model.po;

import com.utils.CsbAttr;
import org.apache.commons.lang3.StringUtils;


public class QueryBillDetailResp {
	@CsbAttr(name = "out")
	private String out;
	
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

	public String getOut() {
		return out;
	}

	public void setOut(String out) {
		this.out = out;
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
