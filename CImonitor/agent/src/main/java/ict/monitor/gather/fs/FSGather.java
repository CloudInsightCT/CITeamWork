package ict.monitor.gather.fs;

public interface FSGather {
	int getFSNumber();
	/**
	 * 盘符名称
	 */
	String getDevName(int num);

	/**
	 * 盘符路径
	 */
	String getDirName(int num);

	/**
	 * 盘符类型
	 */
	String getSysTypeName(int num);

	/**
	 * 盘符类型名
	 */
	String getTypeName(int num);

	/**
	 * 磁盘总大小
	 */
	long getTotal(int num);

	/**
	 * 磁盘剩余大小
	 */
	long getFree(int num);

	/**
	 * 磁盘可用大小
	 */
	long getAvail(int num);

	/**
	 * 已经使用量
	 */
	long getUsed(int num);

	/**
	 * 资源的利用率
	 */
	double getUsePercent(int num);

	/**
	 * 每秒读硬盘请求数
	 */
	long getDiskReads(int num);

	/**
	 * 每秒写硬盘请求数.
	 */
	long getDiskWrites(int num);
}
