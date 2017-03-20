package com.web.controller;

import com.model.po.*;
import com.service.serviceImpl.CreatePointOrderWs;
import com.service.serviceImpl.GetCustomerNbrWs;
import com.service.serviceImpl.GetPointLimitCrmidWs;
import com.service.serviceImpl.SearchRestPointsWs;
import com.utils.CsbSaxReader;
import com.utils.JacksonUtil;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/16.
 */

public class TestController {
    public static void main(String[] args) throws Exception {
        //根据设备号查询客户号
//        String serial_num="202110249226";
//        StringBuilder sb=new StringBuilder();
//        sb.append("http://test.csb.sh.ctc.com:7080/openit/class_7/CustomerNbr/");
//        sb.append(serial_num);
//        sb.append("?Consumer=ZZSLPT");
//       // CustomerNbr customerNbr= GetCustomerNbrWs.getCustomerNbr(sb.toString());
//        //System.err.println(customerNbr);
//
//        String wsAddress = "http://10.145.205.53:7080/openit/class_7/CustomerNbr/202110249226?Consumer=ZZSLPT";
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        CloseableHttpResponse httpResp = null;
//        CsbHttpResp resp = null;
//        CustomerNbrResp customerNbrResp=new CustomerNbrResp();
//        try {
//            //发送get请求
//            HttpGet httpGet = new HttpGet(wsAddress);
//            httpResp = httpclient.execute(httpGet);
//            String respHtml = EntityUtils.toString(httpResp.getEntity(),"utf-8");
//            System.err.println(respHtml);
//            System.err.println("-------------------------------------------------------");
//            int status = httpResp.getStatusLine().getStatusCode();
//            resp = new CsbHttpResp();
//            resp.setRespCode(status);
//            resp.setRespHtml(respHtml);
//            if (status == HttpStatus.SC_OK) {
//                XMLReader parser = XMLReaderFactory.createXMLReader();
//                CsbSaxReader<Object> csbHandler = new CsbSaxReader<>((Object)customerNbrResp);
//                parser.setContentHandler(csbHandler);
//                parser.parse(new InputSource(new ByteArrayInputStream(respHtml.getBytes("utf-8"))));
//                resp.setRespObject(csbHandler.getXmlObject());
//            }
//            CustomerNbrResp cusResp=new CustomerNbrResp ();
//            if(resp.getRespObject()!=null){
//                 cusResp= (CustomerNbrResp)resp.getRespObject();
//            }
//            System.err.println(respHtml);
//            System.err.println(JacksonUtil.objToJsonPretty(cusResp));
//            System.err.println(cusResp.getErrCode());
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
//
//        System.err.println(JacksonUtil.objToJsonPretty(resp));

        //积分余额查询
//        String wsAddress="http://10.145.205.53:7805/openit/class_1?ServiceName=SearchRestPoints&ServiceVer=1.0&Consumer=ZZSLPT";
//        SearchRestPointsResp resp=new SearchRestPointsResp();
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//       String date=simpleDateFormat.format(new Date()).toString();
//        SearchRestPointsReq req=new SearchRestPointsReq();
//        req.setCrmId("202123319237");
//        req.setEndDate(date);
//        req.setStartDate(date);
//        req.setSource("ZZSLPT");
//        resp= SearchRestPointsWs.searchRestPoints(req,wsAddress);
//        System.err.println(JacksonUtil.objToJsonPretty(resp));


        //积分订单创建
        //测试地址：http://test.csb.sh.ctc.com:7805/openit/class_1?ServiceName=CreatePointOrder&ServiceVer=1.0&Consumer=
        CreatePointOrderReq req=new CreatePointOrderReq();
        CreatePointOrderResp resp=new CreatePointOrderResp();
        String wsAddress="http://10.145.205.53:7805/openit/class_1?ServiceName=CreatePointOrder&ServiceVer=1.0&Consumer=ZZSLPT";
         req.setOrderTotal("2");
         req.setSender("积分平台");
         req.setReciver("XX配送商");
         req.setActiveCode("0991");
         req.setCrmId("202127544360");
         req.setAccount("zhangjiming");
         req.setAddress("北京西路819号");
         req.setBrand("1");
         req.setCardID("12345");
         req.setCustomerArea("金山");
         req.setCustomerName("张计明");
         req.setCustRemark("客户留言:sdfasfasf");
         req.setDeadLineDate("2009-03-16");
         req.setChannel("ZZSLPT");
         req.setExpressValue("250");
         req.setFirstContact("mobile");
         req.setOrderType("2");
         req.setTotalScore("6200");
         req.setTelephone("18917880176");
         req.setEmail("aa@sohu.com");
        resp= CreatePointOrderWs.CreatePointOrder(req,wsAddress);
        System.err.println(JacksonUtil.objToJsonPretty(resp));





    }


}
