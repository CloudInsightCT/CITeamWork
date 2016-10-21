package ict.monitor.gather.net;

public interface NetGather {
	int getNetNumber();
	/**
	 * 网络设备名
	 */
	String getName(int num);
	/**
	 * IP地址
	 */
	String getAddress(int num);
	/**
	 * 子网掩码
	 */
	String getNetmask(int num);
	/**
	 * 网关广播地址
	 */
	String getBroadcast(int num);
	/**
	 * 网卡MAC地址
	 */
	String getHwaddr(int num);
	/**
	 * 网卡描述信息
	 */
	String getDescription(int num);
	/**
	 * 网卡类型
	 */
	String getType(int num);
	/**
	 * 接收的总包裹数
	 */
	long getRxPackets(int num);
	/**
	 * 发送的总包裹数
	 */
	long getTxPackets(int num);
	/**
	 * 接收到的总字节数
	 */
	long getRxBytes(int num);
	/**
	 * 发送的总字节数
	 */
	long getTxBytes(int num);
	/**
	 * 接收到的错误包数
	 */
	long getRxErrors(int num);
	/**
	 * 发送数据包时的错误数
	 */
	long getTxErrors(int num);
	/**
	 * 接收时丢弃的包数
	 */
	long getRxDropped(int num);
	/**
	 * 发送时丢弃的包数
	 */
	long getTxDropped(int num);
}
