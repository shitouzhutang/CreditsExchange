package com.utils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;


//ws返回的xml解析
public class CsbSaxReader<T> extends DefaultHandler {
	private static final Logger log = LoggerFactory.getLogger(CsbSaxReader.class);

	//key=xml节点属性名，val=java类属性名
	private HashMap<String, String> attrMap;
	private boolean isValid = false;
	private String currentAtrr;
	private boolean isDataName = false;
	private String dataName;
	private T t;

	//需要取的属性
	public CsbSaxReader(T t) throws Exception{
		this.t = t;
		Field[] fields = t.getClass().getDeclaredFields();
		attrMap =new  HashMap<String, String>(fields.length);
		for (Field f : fields) {
			if (f.isAnnotationPresent(CsbAttr.class)) {
				CsbAttr a = f.getAnnotation(CsbAttr.class);
				attrMap.put(a.name(), f.getName());
			}
		}
		if (attrMap.size()<1){
			throw new Exception("csb object error, no xml attr!");
		}

	}

	//获取解析后的对象
	public T getXmlObject() {
		return t;
	}


	//开始
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		
		if (attrMap.containsKey(localName)){
			isValid = true;
			//localName无前缀
			currentAtrr = localName;
		}
		else if (localName.equals("DataName")){
			//数组序列
			//<m:DataName>SerialNum</m:DataName><m:DataValue>63310986</m:DataValue>
			isDataName = true;
		}
		else if (localName.equals("DataValue")){
			if (dataName!=null&&dataName.length()>1){
				isValid = true;
				currentAtrr = dataName;
				dataName = "";
			}
		}
	}

	@Override
	public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException {
		isValid = false;
		isDataName = false;
		currentAtrr="";
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		if (isValid) {
			String attrVal = new String(ch, start, length);
			String javaAttrName = attrMap.get(currentAtrr);
			String setterName = "set"+StringUtils.capitalize(javaAttrName);
			String getterName = "get"+StringUtils.capitalize(javaAttrName);
			try {
				//设置值
				Method m =null;
				if ( currentAtrr!=null && ! currentAtrr.isEmpty()){
					m = (Method) t.getClass().getMethod(getterName); 
					String lastChunkAttrVal = (String) m.invoke(t);
					if (lastChunkAttrVal!=null) {
						attrVal = lastChunkAttrVal + attrVal;
					}
				}
				
				m = (Method) t.getClass().getMethod(setterName, String.class); 
				m.invoke(t, attrVal);
			} catch (NoSuchMethodException ex) {
				ex.printStackTrace();
				log.error("^^^CsbSaxReadertest.attrToObject(), NoSuchMethodException :"
						+ setterName);
			}	
			catch (Exception e) {
				log.error("CsbSaxReader.characters(), error, exception :" + e);
			}
		}
		else if(isDataName){
			dataName = new String(ch, start, length);
			if (!attrMap.containsKey(dataName)) {
				dataName = "";
			}
		}
	}
}
