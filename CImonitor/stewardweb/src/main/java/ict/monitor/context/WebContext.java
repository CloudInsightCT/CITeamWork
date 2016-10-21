package ict.monitor.context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ict.monitor.common.PropertiesUtil;
public class WebContext {
	private static Logger logger = LogManager.getLogger(WebContext.class.getName());
	public static String PINPOINT;
	public static int PORT;
	public static boolean DEBUG = true;
	public static String DEBUG_USERNAME;
	public static int DEBUG_USERID;
	
	public static void init() throws Exception {
		PropertiesUtil propertiesUtil = new PropertiesUtil();
		PINPOINT = propertiesUtil.readStrValue("pinpoint");
		PORT = propertiesUtil.readIntValue("port");
		
		try {
			DEBUG_USERID = propertiesUtil.readIntValue("debugUserID");
			DEBUG_USERNAME = propertiesUtil.readStrValue("debugUserName");
			DEBUG = propertiesUtil.readBooleanValue("debug");
		} catch (Exception e) {
			DEBUG = false;
		}
		logger.info("WebContext [PINPOINT=" + PINPOINT + ", PORT=" + PORT + ", DEBUG=" + DEBUG + "]");
	}
	
}
