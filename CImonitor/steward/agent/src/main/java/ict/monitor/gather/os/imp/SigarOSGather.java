package ict.monitor.gather.os.imp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Properties;

import org.hyperic.sigar.Sigar;

import ict.monitor.common.ExceptionUtil;
import ict.monitor.gather.os.OSGather;

public class SigarOSGather implements OSGather {
	private Properties props = System.getProperties();
	private Map<String, String> map = System.getenv();
	public SigarOSGather(Sigar sigar) {
	}

	@Override
	public String getOS() {
		return props.getProperty("os.name");
	}

	@Override
	public String getOSArc() {
		return props.getProperty("os.arch");
	}

	@Override
	public String getOSVersion() {
		return props.getProperty("os.version");
	}

	@Override
	public String getOSIP() {
		InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress();
			return ip;
		} catch (UnknownHostException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return "";
	}

	@Override
	public String getComputerName() {
		return map.get("COMPUTERNAME");
	}

	@Override
	public String getHostName() {
//		return map.get("USERDOMAIN");
		InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			return addr.getHostName();
		} catch (UnknownHostException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return "";
	}

}
