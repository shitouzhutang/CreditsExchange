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
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */

public class TestController {
    public static void main(String[] args) throws Exception {
        //根据设备号查询客户
//        StringBuilder sb=new StringBuilder();
//        sb.append("http://10.145.205.53:7080/openit/class_7/CustomerNbr/");
//        sb.append("0000398122");
//        sb.append("?Consumer=ZZSLPT");
//        String wsAddress = sb.toString();
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        CloseableHttpResponse httpResp = null;
//        try {
//            //发送get请求
//            HttpGet httpGet = new HttpGet(wsAddress);
//            httpResp = httpclient.execute(httpGet);
//            String respHtml = EntityUtils.toString(httpResp.getEntity(),"utf-8");
//            System.err.println(respHtml);
//            CustomerNbr customerNbr=new CustomerNbr();
//            customerNbr= JacksonUtil.jsonToObj(respHtml,CustomerNbr.class);
//            String custNumber="";
//            if(customerNbr!=null&&customerNbr.getItems().size()>0){
//                custNumber=customerNbr.getItems().get(0).getCust_number();
//            }
//            System.err.println(custNumber);
//            System.err.println("-------------------------------------------------------");
//            System.err.println(respHtml);
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

       // 积分余额查询
//        String wsAddress="http://10.145.205.53:7805/openit/class_1?ServiceName=SearchRestPoints&ServiceVer=1.0&Consumer=ZZSLPT";
//        SearchRestPointsResp resp=new SearchRestPointsResp();
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//       String date=simpleDateFormat.format(new Date()).toString();
//        SearchRestPointsReq req=new SearchRestPointsReq();
////      req.setCrmId("202123319237");
//        req.setCrmId("202134287980");
//        req.setEndDate(date);
//        req.setStartDate(date);
//        req.setSource("ZZSLPT");
//        resp= SearchRestPointsWs.searchRestPoints(req,wsAddress);
//        System.err.println(JacksonUtil.objToJsonPretty(resp));


        //积分订单创建
//     测试地址：http://10.145.205.53:7805/openit/class_1?ServiceName=CreatePointOrder&ServiceVer=1.0&Consumer=
//     仿真地址：http://10.7.18.12:7805/openit/class_1?ServiceName=CreatePointOrder&ServiceVer=1.0&Consumer=
//     生产地址：http://csb.sh.ctc.com:7805/openit/class_1?ServiceName=CreatePointOrder&ServiceVer=1.0&Consumer=
        CreatePointOrderReq req=new CreatePointOrderReq();
        String wsAddress="http://10.145.205.53:7805/openit/class_1?ServiceName=CreatePointOrder&ServiceVer=1.0&Consumer=网厅";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        req.setRequestTime(sdf.format(new Date()));
         req.setOrderTotal("2");
         req.setSender("积分平台");
         req.setReciver("XX配送商");
         req.setActiveCode("0991");
         req.setCrmId("202134287980");
         req.setAccount("zhangjiming");
         req.setAddress("北京西路819号");
         req.setBrand("1");
         req.setCardID("12345");
         req.setCustomerArea("金山");
         req.setCustomerName("张计明");
         req.setCustRemark("客户留言:sdfasfasf");
         req.setDeadLineDate("2009-03-16");
         req.setChannel("ZZSPT");
         req.setExpressValue("0");
         req.setFirstContact("mobile");
         req.setOrderType("2");
         req.setTotalScore("10000");
         req.setTelephone("18917880176");
         req.setEmail("aa@sohu.com");
         req.setPostCode("200120");


         req.setCardCode("JFPT20161222133100582085");
         req.setMoneyValue("0");
         req.setUseValue("0");
         req.setPayMethod("1");
         req.setOrganizeCode("sss");

         req.setGiftId1("H167201");
//         req.setGiftId2("H0002");
         req.setGiftName1("2G本地手机上网流量包");
//         req.setGiftName2("咖啡杯");
         req.setChangeNumber1("1");
//         req.setChangeNumber2("1");
         req.setScoreValue1("10000");
//         req.setScoreValue2("200");
         CreatePointOrderResp  resp= CreatePointOrderWs.CreatePointOrder(req,wsAddress);
         System.err.println(JacksonUtil.objToJsonPretty(resp));





    }


}
