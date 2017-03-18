package com.utils;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeUtil {
	private static final Logger log = LoggerFactory.getLogger(DateTimeUtil.class);
	
	public static String getNowStr(){
		return new DateTime().toString("yyyyMMddHHmmss");
	}
	public static String getNowStr(String pattern){
		if (pattern==null) {
			pattern="yyyyMMddHHmmss";
		}
		return new DateTime().toString(pattern);
	}
	public static long calcSeconds(String startTime , String endTime){
		DateTimeFormatter format = DateTimeFormat.forPattern("yyyyMMddHHmmss");  
		Duration d = new Duration(DateTime.parse(startTime, format), DateTime.parse(endTime, format));  
		return d.getStandardSeconds();
	}
	
	public static long calcDays(String startTime , String endTime){
		DateTimeFormatter format = DateTimeFormat.forPattern("yyyyMMddHHmmss");  
		Duration d = new Duration(DateTime.parse(startTime, format), DateTime.parse(endTime, format));  
		return d.getStandardDays();
	}
	
	/**
	 * return endTime = startTime + duration
	 * @param startTime yyyyMMddHHmmss
	 * @param duration
	 * @return
	 */
	public static String calcEndTime(String startTime , int duration) {
		String endTime = "";
		try {
			DateTimeFormatter format = DateTimeFormat.forPattern("yyyyMMddHHmmss");  
			endTime =  DateTime.parse(startTime, format).plusSeconds(duration).toString(format);
		} catch (Exception e) {
			log.error("calcEndTime, error, exception", e);
		}
		return endTime;
	}

}
