package ict.monitor.gather.memory.imp;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

import ict.monitor.common.ExceptionUtil;
import ict.monitor.gather.memory.MemmoryGather;

public class SigarMemmoryGather implements MemmoryGather {
	Sigar sigar = null;

	public SigarMemmoryGather(Sigar sigar) {
		this.sigar = sigar;
	}

	public long getMemTotal() {
		Mem mem = getMem();
		if (mem != null) {
			return mem.getTotal();
		}
		return -1;
	}

	public long getMemUsed() {
		Mem mem = getMem();
		if (mem != null) {
			return mem.getUsed();
		}
		return -1;
	}

	public long getMemFree() {
		Mem mem = getMem();
		if (mem != null) {
			return mem.getFree();
		}
		return -1;
	}

	public long getSwapTotal() {
		Swap swap = getSwap();
		if (swap != null) {
			return swap.getTotal();
		}
		return -1;
	}

	public long getSwapUsed() {
		Swap swap = getSwap();
		if (swap != null) {
			return swap.getUsed();
		}
		return -1;
	}

	public long getSwapFree() {
		Swap swap = getSwap();
		if (swap != null) {
			return swap.getFree();
		}
		return -1;
	}

	private Swap getSwap() {
		try {
			Swap swap = sigar.getSwap();
			return swap;
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return null;

	}

	private Mem getMem() {
		try {
			Mem mem = sigar.getMem();
			return mem;
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return null;
	}

	public void close() {
		sigar.close();
	}
}
