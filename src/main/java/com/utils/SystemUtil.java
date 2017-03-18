package com.utils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemUtil {
	
	public static boolean isValidNumber(String strNum){
		if(strNum==null)return false;
		String reg = "^\\d{8,15}$";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(strNum);
		return matcher.find();
	} 
	
	public static boolean isMobile(String strNum){
		if(strNum==null)return false;
		String reg = "^0?1[3-8]\\d{9}$";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(strNum);
		return matcher.find();
	} 

	/**
	 * 
	 * @param strNum
	 * @return
	 */
	public static boolean isLocalFix(String strNum){
		if(strNum==null)return false;
		String reg = "^(2|3|4|5|6|8)\\d{7}$";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(strNum);
		return matcher.find();
	}
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("[-]", "");
	}
	public static void main(String[] args) {
		String no = "18017921576";
		System.out.println(isMobile(no));
	}
}
