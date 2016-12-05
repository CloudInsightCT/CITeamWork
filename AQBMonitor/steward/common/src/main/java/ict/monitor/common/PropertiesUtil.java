package ict.monitor.common;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class PropertiesUtil {
	private Properties props;
	public PropertiesUtil() throws Exception {
		props = new Properties();
		String path = this.getClass().getResource("/").getPath()+"config.properties";
		InputStream in = new FileInputStream(path);
		props.load(in);
		in.close();
	}

	public String readStrValue(String key) throws IllegalArgumentException {
		String value = props.getProperty(key);
		if(StringUtils.isEmpty(value)) {
			throw new IllegalArgumentException();
		}
		return value;
	}
	
	public boolean readBooleanValue(String key) throws IllegalArgumentException {
		String value = props.getProperty(key);
		if(StringUtils.isEmpty(value)) {
			throw new IllegalArgumentException();
		}
		try {
			boolean b = Boolean.parseBoolean(value);
			return b;
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	public int readIntValue(String key) throws IllegalArgumentException {
		String value = props.getProperty(key);
		if(StringUtils.isEmpty(value)) {
			throw new IllegalArgumentException();
		}
		try {
			int intValue = Integer.parseInt(value);
			return intValue;
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
}
