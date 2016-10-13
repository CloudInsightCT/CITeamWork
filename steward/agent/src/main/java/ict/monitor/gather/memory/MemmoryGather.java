package ict.monitor.gather.memory;

import ict.monitor.gather.Gather;

public interface MemmoryGather extends Gather {
	/**
	 * 内存总量
	 * @return
	 */
	long getMemTotal();
	/**
	 * 当前内存使用量
	 * @return
	 */
	long getMemUsed();
	/**
	 * 当前内存剩余量
	 * @return
	 */
	long getMemFree();
	/**
	 * 交换区总量
	 * @return
	 */
	long getSwapTotal();
	/**
	 * 当前交换区使用量
	 * @return
	 */
	long getSwapUsed();
	/**
	 * 当前交换区剩余量
	 * @return
	 */
	long getSwapFree();
}
