package com.web.controller;

import com.model.po.*;
import com.service.serviceImpl.GetCustomerNbrWs;
import com.service.serviceImpl.GetPointLimitCrmidWs;
import com.service.serviceImpl.SearchRestPointsWs;
import com.utils.JacksonUtil;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/16.
 */

public class TestController {
    public static void main(String[] args) throws Exception {
        //根据设备号查询客户号

//        String serial_num="13800000000";
//        StringBuilder sb=new StringBuilder();
//        sb.append("http://test.csb.sh.ctc.com:7080/openit/class_7/CustomerNbr/");
//        sb.append(serial_num);
//        sb.append("?Consumer=ZZSLPT");
//        CustomerNbr customerNbr= GetCustomerNbrWs.getCustomerNbr(sb.toString());
//        System.err.println(customerNbr);

//        String wsAddress = "http://10.145.205.53:7080/openit/class_7/CustomerNbr/0000398122?Consumer=ZZSLPT";
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        CloseableHttpResponse httpResp = null;
//        try {
//            //发送get请求
//            HttpGet httpGet = new HttpGet(wsAddress);
//            httpResp = httpclient.execute(httpGet);
//            String respValue = EntityUtils.toString(httpResp.getEntity(),"utf-8");
//            System.err.println(respValue);
//        }catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            IOUtils.closeQuietly(httpResp);
//        }

        //查询积分黑名单
//        String wsAddress="http://10.145.205.53:7805/openit/class_1?ServiceName=GetPointLimitCrmid&ServiceVer=1.0&Consumer=ZZSLPT";
//        GetPointLimitCrmidResp resp= new GetPointLimitCrmidResp();
//        GetPointLimitCrmidReq req=new GetPointLimitCrmidReq();
//        req.setCrmId("202110249226");
//        resp= GetPointLimitCrmidWs.GetPointLimitCrmid(req,wsAddress);

       // System.err.println(JacksonUtil.objToJsonPretty(resp));

        //积分余额查询
        String wsAddress="http://10.145.205.53:7805/openit/class_1?ServiceName=SearchRestPoints&ServiceVer=1.0&Consumer=ZZSLPT";
        SearchRestPointsResp resp=new SearchRestPointsResp();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
       String date=simpleDateFormat.format(new Date()).toString();
        SearchRestPointsReq req=new SearchRestPointsReq();
        req.setCrmId("202123319237");
        req.setEndDate(date);
        req.setStartDate(date);
        req.setSource("ZZSLPT");
        resp= SearchRestPointsWs.searchRestPoints(req,wsAddress);
        System.err.println(JacksonUtil.objToJsonPretty(resp));

    }


}
