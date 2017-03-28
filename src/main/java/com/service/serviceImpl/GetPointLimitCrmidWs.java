package com.service.serviceImpl;




import com.model.po.CsbHttpResp;
import com.model.po.GetPointLimitCrmidReq;
import com.model.po.GetPointLimitCrmidResp;
import com.model.po.QueryBillDetailResp;
import com.utils.CsbUtil;
import com.utils.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Created by Administrator on 2017/3/16.
 */
public class GetPointLimitCrmidWs {

    private static  final Logger log= LoggerFactory.getLogger(GetPointLimitCrmidWs.class);

    private static final String WS_REQ_XML = "soap/GetPointLimitCrmidReq.xml";

    private static String reqXml = "";

    static{
        reqXml = CsbUtil.loadWsXml(WS_REQ_XML);  //读取classpath下的xml文件内容，放在内存中
    }

    /**
     * 根据客户编号查询是否在积分兑换黑名单
     * 测试地址：http://test.csb.sh.ctc.com:7805/openit/class_1?ServiceName=GetPointLimitCrmid&ServiceVer=1.0&Consumer=
     仿真地址：http://10.7.18.12:7805/openit/class_1?ServiceName=GetPointLimitCrmid&ServiceVer=1.0&Consumer=
     生产地址：http://csb.sh.ctc.com:7805/openit/class_1?ServiceName=GetPointLimitCrmid&ServiceVer=1.0&Consumer=
     * @param req
     * @param wsAddress
     * @return
     */
    public static GetPointLimitCrmidResp GetPointLimitCrmid(GetPointLimitCrmidReq req,String wsAddress){
        GetPointLimitCrmidResp resp=new GetPointLimitCrmidResp();
        try {
            if (req==null) {
              log.info("!!!ErrorWs, GetPointLimitCrmid");
                return resp;
            }
            CsbHttpResp csbResp = CsbUtil.sendToCsbWs(reqXml, req, new GetPointLimitCrmidResp(), wsAddress);
            if (csbResp.getRespObject()!=null){
                resp=(GetPointLimitCrmidResp)csbResp.getRespObject();
            }
            log.debug("GetPointLimitCrmidResp = " + JacksonUtil.objToJsonPretty(resp));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("GetPointLimitCrmid, error, exception", e);
        }

        //返回0  是无兑换权限的客户， 返回1 是有兑换权限的客户
        return  resp;
    }




}
