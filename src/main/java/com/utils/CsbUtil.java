package com.utils;

import com.model.po.CsbHttpResp;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
//import java.nio.charset.StandardCharsets;


public class CsbUtil {
	private static final Logger log = LoggerFactory.getLogger(CsbUtil.class);
	
	public  static CsbHttpResp sendToCsbWs(String wsXml, Object objReq, Object objResp, String wsAddr)throws Exception{
		String message = replaceParameter(wsXml, objReq);
		log.debug("==CsbReqHtml = " + message);
		log.info("接口实际请求报文= " + message);
		CsbHttpResp resp = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();                                                 
        CloseableHttpResponse httpResp = null;                                                                           
        HttpPost httpPost = new HttpPost(wsAddr);                                                                       
        try {                                                                                                         
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000).build();
            httpPost.setConfig(requestConfig);                                                                         
            StringEntity strent = new StringEntity(message, "utf-8");
            httpPost.setEntity(strent);                                                                             
            httpPost.addHeader(HTTP.CONN_DIRECTIVE, "close");//客户端只请求一次
            httpPost.addHeader(HTTP.CONTENT_TYPE, "application/soap+xml");
            httpPost.addHeader(HTTP.EXPECT_CONTINUE, "false");
            log.debug("==============waiting for response=================");
            httpResp = httpclient.execute(httpPost);                                                                       
            int status = httpResp.getStatusLine().getStatusCode();
    		log.debug("status=" + status);
    		String respHtml = EntityUtils.toString(httpResp.getEntity(),"utf-8");
			System.err.println(respHtml);
			log.debug("**CsbRespBody = " + respHtml);
    		
    		resp = new CsbHttpResp();
    		resp.setRespCode(status);
    		resp.setRespHtml(respHtml);
    		if (status == HttpStatus.SC_OK) {
    			XMLReader parser = XMLReaderFactory.createXMLReader();
    			CsbSaxReader<Object> csbHandler = new CsbSaxReader<>(objResp);
    			parser.setContentHandler(csbHandler);
    			parser.parse(new InputSource(new ByteArrayInputStream(respHtml.getBytes("utf-8"))));
    			resp.setRespObject(csbHandler.getXmlObject());
    		}
    		httpPost.releaseConnection();    
    		httpclient.close();
        } catch (Exception e) {                                                                                       
            log.error("sendToCsbWs, error, exception", e);                                                                                     
        } finally {                                                                                                   
            IOUtils.closeQuietly(httpResp);                                                                                 
        }  
        return resp;
	}
	
	/**
	 * 读取classpath下的xml文件内容，放在内存中
	 * @param xmlFileName
	 * @return
	 */
	public static String loadWsXml(String xmlFileName) {
		FileInputStream ins = null;
		BufferedReader reader = null;
		String reqXml = null;
		try {
			URL classpath = Thread.currentThread().getContextClassLoader().getResource("");
			String cfgFilePath = classpath.getPath() + xmlFileName;

			ins = new FileInputStream(cfgFilePath);
			StringBuffer buffer = new StringBuffer();
			reader = new BufferedReader(new InputStreamReader(ins, "utf-8"));
			String line = reader.readLine();
			String lineSep = System.getProperty("line.separator");
			while (line != null) {
				buffer.append(line);
				buffer.append(lineSep);
				line = reader.readLine();
			}
			reqXml = buffer.toString();
			log.info("load xml, wsXml= " + reqXml);
		} catch (Exception e) {
			log.error("load xml, error, exception :" + e);
			e.printStackTrace();
		} finally {
			try {
				if (ins != null) {
					ins.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e2) {
			}
		}
		return reqXml;
	}
	
	/**
	 * 替换请求xml的相关参数，占位符：PARA+大写属性名
	 * @param wsXml - 原始xml
	 * @param object - 请求对象
	 * @return
	 * @throws Exception
	 */
	protected static String replaceParameter(String wsXml, Object object)throws Exception{
		Class<?> clz = object.getClass();  
        Field[] fields = clz.getDeclaredFields();  
        String xml= wsXml;
        String[] searchList =new String[fields.length];
        String[] replacementList =new String[fields.length];

        for (int i = 0; i < fields.length; i++) {
        	String fieldName = fields[i].getName();
        	try {
    			Method m = (Method) object.getClass().getMethod("get" + StringUtils.capitalize(fieldName));//StringUtils.capitalize首字母大写
                String val = (String) m.invoke(object);
                //xml文件中PARAxxx为替换占位符
                searchList[i]="PARA"+fieldName.toUpperCase();
                replacementList[i]=val;
			} catch (Exception e) {
				e.printStackTrace();
				log.error("-----WsXml.replaceParameter(), error, exception :" + e+", field="+fieldName);
			}
		}

        xml = StringUtils.replaceEach(xml, searchList, replacementList);
		
		return xml;
	}
	
	public static String generateCsbRequestTime(){
		return DateTimeUtil.getNowStr("yyyy-MM-dd HH:mm:ss.SSS");
	}
}
