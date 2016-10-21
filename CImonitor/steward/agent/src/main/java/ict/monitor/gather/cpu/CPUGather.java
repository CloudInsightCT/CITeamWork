package ict.monitor.gather.cpu;

public interface CPUGather {
	
	int getCPUNumber();
	/**
	 * CPU的总量MHz
	 */
	long getMhz(int num);
	/**
	 * 获得CPU的卖主，如：Intel
	 */
	String getVendor(int num);
	/**
	 * 获得CPU的类别，如：Celeron
	 */
	String getModel(int num);
	/**
	 * 缓存数量
	 */
	long getCacheSize(int num);
	
	
	
	
	/**
	 * 用户使用率
	 */
	double getUser(int num);
	/**
	 * 系统使用率
	 */
	double getSys(int num);
	/**
	 * 当前等待率
	 */
	double getWait(int num);
	/**
	 * Nice
	 */
	double getNice(int num);
	/**
	 * 当前空闲率
	 */
	double getIdle(int num);
	/**
	 * 总的使用率
	 */
	double getCombined(int num);
}
