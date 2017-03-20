package com.service.serviceImpl;

import com.model.po.CsbHttpResp;
import com.model.po.SearchRestPointsReq;
import com.model.po.SearchRestPointsResp;
import com.utils.CsbUtil;
import com.utils.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/17.
 */
public class SearchRestPointsWs {
    private static  final Logger log= LoggerFactory.getLogger(SearchRestPointsWs.class);

    private static final String WS_REQ_XML = "soap/SearchRestPointsReq.xml";

    private static String reqXml = "";

    static{
        reqXml = CsbUtil.loadWsXml(WS_REQ_XML);  //读取classpath下的xml文件内容，放在内存中
    }
    /**
     * 调用webservice查询用户积分余额
     *
     * 测试地址：http://test.csb.sh.ctc.com:7805/openit/class_1?ServiceName=SearchRestPoints&ServiceVer=1.0&Consumer=
     仿真地址：http://10.7.18.12:7805/openit/class_1?ServiceName=SearchRestPoints&ServiceVer=1.0&Consumer=
     生产地址：http://csb.sh.ctc.com:7805/openit/class_1?ServiceName=SearchRestPoints&ServiceVer=1.0&Consumer=
     * @param req
     * @param wsAddress
     * @return
     */
    public static SearchRestPointsResp searchRestPoints(SearchRestPointsReq req,String wsAddress){
        SearchRestPointsResp resp=null;
        try {
            if (req==null) {
                log.info("!!!ErrorWs, searchRestPoints");
                return resp;
            }
            CsbHttpResp csbResp = CsbUtil.sendToCsbWs(reqXml, req, new SearchRestPointsResp(), wsAddress);
            if (csbResp.getRespObject()!=null){
                resp=(SearchRestPointsResp)csbResp.getRespObject();
            }
            log.debug("SearchRestPointsResp = " + JacksonUtil.objToJsonPretty(resp));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("searchRestPoints, error, exception", e);
        }


        return resp;
    }

}
