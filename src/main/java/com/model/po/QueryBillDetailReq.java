package com.model.po;


//import com.sanss.fqzdata.mod.FraudQueryTask;
import com.utils.CsbUtil;

public class QueryBillDetailReq {
	//ip=10.4.15.209
	private String requestTime;
	private String callNbr;
	private String startTime;
	private String endTime;
	private String pNum="1";//pageno用于翻页控制。每次返回1000条话单。
	
	/*
	 * 1、SCP指C网语音；SMSC 指C网短信；AAA指C网数据；ISMP指C网增值；RC指C网 其他（一般是月租等非使用费）
	 * 2、LOCAL指固网 市话；DISTANCE指固网 长话；VOICE指固网 声讯；WIDEBAND指固网宽带；OTHER指固网 其他（一般是月租等非使用费）" 
	 */
	private String busiType;

	
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	public String getCallNbr() {
		return callNbr;
	}
	public void setCallNbr(String callNbr) {
		this.callNbr = callNbr;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPNum() {
		return pNum;
	}
	public void setPNum(String pNum) {
		this.pNum = pNum;
	}
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

//	public static QueryBillDetailReq newFromTask(FraudQueryTask task , String busiType, String pNum){
	public static QueryBillDetailReq newFromTask(String busiType, String pNum){
		QueryBillDetailReq req =  new QueryBillDetailReq();
//		req.setCallNbr(task.getCalling());
		req.setRequestTime(CsbUtil.generateCsbRequestTime());
//		req.setStartTime(task.getCdrStartTime().substring(0,8));
//		req.setEndTime(task.getCdrEndTime().substring(0,8));
		req.setBusiType(busiType);
		req.setPNum(pNum);
		return req;
	}

}
