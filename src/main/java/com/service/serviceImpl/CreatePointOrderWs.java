package com.service.serviceImpl;

import com.model.po.*;
import com.utils.CsbUtil;
import com.utils.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/3/19.
 */
public class CreatePointOrderWs {
    private static final Logger log = LoggerFactory.getLogger(CreatePointOrderWs.class);

    private static final String WS_REQ_XML = "soap/CreatePointOrderReq.xml";
    private static String reqXml = "";
    static {
        reqXml = CsbUtil.loadWsXml(WS_REQ_XML);
    }



    /**
	 *
	 *  积分订单创建
	    测试地址：http://test.csb.sh.ctc.com:7805/openit/class_1?ServiceName=CreatePointOrder&ServiceVer=1.0&Consumer=
        仿真地址：http://10.7.18.12:7805/openit/class_1?ServiceName=CreatePointOrder&ServiceVer=1.0&Consumer=
        生产地址：http://csb.sh.ctc.com:7805/openit/class_1?ServiceName=CreatePointOrder&ServiceVer=1.0&Consumer=
	 *
	 */
    public static CreatePointOrderResp CreatePointOrder(CreatePointOrderReq req, String wsAddress){
        CreatePointOrderResp resp = null;
        try {
            if (req == null) {
                log.info("!!!ErrorWs, CreatePointOrderResp");
                return resp;
            }
            CsbHttpResp csbResp = CsbUtil.sendToCsbWs(reqXml, req, new CreatePointOrderResp(), wsAddress);
            if (csbResp.getRespObject() != null) {
                resp = (CreatePointOrderResp) csbResp.getRespObject();
            }
            log.debug("CreatePointOrderResp = " + JacksonUtil.objToJsonPretty(resp));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("CreatePointOrderResp, error, exception", e);
        }
        return resp;
    }



}
