package ict.monitor.common;

public class ExceptionUtil {
	public static boolean debug = true;
	public static void printStackTrace(Throwable e){
		if(debug){
			e.printStackTrace();
		} else {
			
		}
	}
}
