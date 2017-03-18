package com.service.serviceImpl;

import com.model.po.CsbHttpResp;
import com.model.po.QueryBillDetailReq;
import com.model.po.QueryBillDetailResp;
import com.utils.CsbUtil;
import com.utils.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


public class QueryBillDetailWs {
	private static final Logger log = LoggerFactory.getLogger(QueryBillDetailWs.class);
	
	private static final String WS_REQ_XML = "soap/QueryBillDetailReq.xml";
	private static String reqXml = "";
	static {
		reqXml = CsbUtil.loadWsXml(WS_REQ_XML);
	}
	
	/*
	 * 
	 * 测试地址：http://test.csb.sh.ctc.com:7805/openit/class_1?ServiceName=QueryBillDetail&ServiceVer=1.0&Consumer=
	 * 仿真地址：http://10.145.199.151:7805/openit/class_1?ServiceName=QueryBillDetail&ServiceVer=1.0&Consumer=
	 * 生产地址：http://csb.sh.ctc.com:7805/openit/class_1?ServiceName=QueryBillDetail&ServiceVer=1.0&Consumer=
	 * 
	 * 目前是fqz-CSB-SGW-CQD，据说以后会改成fqz-CSB-CQD
	 */
	public static QueryBillDetailResp queryBillDetail(QueryBillDetailReq req, String wsAddr) {
		QueryBillDetailResp resp = null;
		try {
			if (req == null) {
				log.info("!!!ErrorWs, queryBillDetail");
				return resp;
			}
			CsbHttpResp csbResp = CsbUtil.sendToCsbWs(reqXml, req, new QueryBillDetailResp(), wsAddr);
			if (csbResp.getRespObject() != null) {
				resp = (QueryBillDetailResp) csbResp.getRespObject();
			}
			
			log.debug("QueryBillDetailResp = " + JacksonUtil.objToJsonPretty(resp));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("queryBillDetail, error, exception", e);
		}
		return resp;
	}
	
	
}
