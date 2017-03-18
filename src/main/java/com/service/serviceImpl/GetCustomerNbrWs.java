package com.service.serviceImpl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.po.CustomerNbr;
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
     * @param phone 设备编号（手机号码）
     * @return 客户编号
     */
    public static String getCustomerNbr(String phone){
        CustomerNbr customerNbr=null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse httpResp = null;
        String wsAddress="";
        try {

            //发送get请求
            HttpGet httpGet=new HttpGet(wsAddress);
            httpResp=httpclient.execute(httpGet);
            String respValue = EntityUtils.toString(httpResp.getEntity(),"utf-8");
            //服务器状态
            int status = httpResp.getStatusLine().getStatusCode();
            /**请求发送成功，并得到响应**/
            if (status == HttpStatus.SC_OK) {
                ObjectMapper mapper=new ObjectMapper();
                //反序列化
                customerNbr=mapper.readValue(respValue,CustomerNbr.class);
            }
            httpclient.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(httpResp);
        }
        return "11111";
    }



}
