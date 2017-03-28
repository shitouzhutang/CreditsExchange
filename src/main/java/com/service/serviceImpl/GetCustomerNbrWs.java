package com.service.serviceImpl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.po.CustomerNbr;
import com.utils.JacksonUtil;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


/**
 * Created by Administrator on 2017/3/16.
 */
public class GetCustomerNbrWs {


    /**
     * 根据设备编号获取客户号
     服务测试地址	http://test.csb.sh.ctc.com:7080/openit/class_7/CustomerNbr/{SERIAL_NUM}?Consumer=
     服务仿真地址	http://10.7.18.12:7080/openit/class_7/CustomerNbr/{SERIAL_NUM}?Consumer=
     服务生产地址	http://csb.sh.ctc.com:10080/openit/class_7/CustomerNbr/{SERIAL_NUM}?Consumer=
     * @param phone 设备编号（手机号码）
     * @return 客户编号
     */
    public static String getCustomerNbr(String phone){
        //根据设备号查询客户
        StringBuilder sb=new StringBuilder();
        sb.append("http://10.145.205.53:7080/openit/class_7/CustomerNbr/");
        sb.append(phone);
        sb.append("?Consumer=ZZSLPT");
        String wsAddress = sb.toString();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse httpResp = null;
        String custNumber="";
        try {
            //发送get请求
            HttpGet httpGet = new HttpGet(wsAddress);
            httpResp = httpclient.execute(httpGet);
            String respHtml = EntityUtils.toString(httpResp.getEntity(),"utf-8");
            System.err.println(respHtml);
            CustomerNbr customerNbr=new CustomerNbr();
            customerNbr= JacksonUtil.jsonToObj(respHtml,CustomerNbr.class);
            if(customerNbr!=null&&customerNbr.getItems().size()>0){
                custNumber=customerNbr.getItems().get(0).getCust_number();
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(httpResp);
        }
        return custNumber;
    }



}
