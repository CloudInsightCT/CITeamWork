package cn.com.cloudinsight.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class StringUtils {
     
	public static String getDate(String c) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date=format.parse(c);
		Calendar ca=Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.DATE, 1);
		date=ca.getTime();
		String time=format.format(date);
		return time;
		
	}
	//小时
	public static String getPreDate(String c) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=format.parse(c);
		Calendar ca=Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.HOUR_OF_DAY, -1);
		date=ca.getTime();
		String time=format.format(date);
		System.out.println("time"+time);
		return time;
		
	}
	
	public static String getTime(Date c) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		//Date date=format.parse(c);
		Calendar ca=Calendar.getInstance();
		ca.setTime(c);
		ca.add(Calendar.DATE, 1);
		c=ca.getTime();
		String time=format.format(c);
		return time;		
	}
	
	
	public String getformatTime(Date c) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	
		String time=format.format(c);
		return time;
		
	}
	
	public String getformatDate(String c) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date=format.parse(c);
		String time=format.format(date);
		return time;
		
	}
	
	public static String getAddres(String str){
		String adress=str.split("-")[0];
		return adress;
		
	}
	  public static List<String> ping(String ipAddress) throws Exception {
	        String line = null;
	       List<String> list=new ArrayList<String>();
	        try {
	            Process pro = Runtime.getRuntime().exec("ping " + ipAddress);
	            BufferedReader buf = new BufferedReader(new InputStreamReader(
	                    pro.getInputStream(),"gbk"));
	            while ((line = buf.readLine()) != null){
	            	list.add(line);
	            //	HashMap<String, Object> map=new HashMap<String, Object>();
	         //   map.put("text", line);
	             //   map.put("text", line);
	             //   list.add(map);
	            //    System.out.println(line);
	            }
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        }
			return list;
	    }
	  
	  public static String getAlam_des(String str,String sm){
		  String s="{HOST.NAME}";
		  String st=str.replace(s, sm);
		 return st;
		  
	  }
	  
	 
	  
	 /**
	  * 获取地址 
	  * @param name
	  * @return
	  */
	  public static String getFormer(String name){
		String str=name.substring(0, name.indexOf(":"));
		return str;
		  
	  }
}
