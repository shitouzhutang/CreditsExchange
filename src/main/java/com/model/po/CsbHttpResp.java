package com.model.po;

public class CsbHttpResp {
	private int respCode;
	private Object respObject;
	private String respHtml;
	
	public int getRespCode() {
		return respCode;
	}
	public void setRespCode(int respCode) {
		this.respCode = respCode;
	}
	public Object getRespObject() {
		return respObject;
	}
	public void setRespObject(Object respObject) {
		this.respObject = respObject;
	}
	public String getRespHtml() {
		return respHtml;
	}
	public void setRespHtml(String respHtml) {
		this.respHtml = respHtml;
	}
}

