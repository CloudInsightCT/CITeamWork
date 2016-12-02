package cn.com.cloudinsight.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiUtils {
  
	
	public static String getValue(String key){
		Properties pro=new Properties();
		InputStream in=new PropertiUtils().getClass().getResourceAsStream("/zabbix.properties");
		
		try {
			pro.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pro.getProperty(key);
		
		
	} 
}
