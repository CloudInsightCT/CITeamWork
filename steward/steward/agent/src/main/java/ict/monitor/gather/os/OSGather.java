package ict.monitor.gather.os;

public interface OSGather {
	/**
	 * 操作系统的名称
	 */
	String getOS();
	/**
	 * 操作系统的构架
	 */
	String getOSArc();
	/**
	 * 操作系统的版本
	 */
	String getOSVersion();
	/**
	 * 操作系统的IP
	 */
	String getOSIP();
	/**
	 * 计算机名
	 */
	String getComputerName();
	/**
	 * 本地主机名
	 */
	String getHostName();
}
