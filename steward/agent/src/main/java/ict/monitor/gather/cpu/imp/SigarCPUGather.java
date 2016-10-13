package ict.monitor.gather.cpu.imp;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import ict.monitor.gather.cpu.CPUGather;

public class SigarCPUGather implements CPUGather {
	private Sigar sigar = null;
	private CpuInfo infos[] = null;
	private CpuPerc[] cpuList;

	public SigarCPUGather(Sigar sigar) throws SigarException {
		this.sigar = sigar;
		infos = this.sigar.getCpuInfoList();
		this.cpuList = sigar.getCpuPercList();
	}

	@Override
	public long getMhz(int num) {
		if (validate(num)) {
			return infos[num].getMhz();
		}
		return 0;
	}

	private boolean validate(int num) {
		if (infos.length <= num || num < 0) {
			return false;
		}
		return true;
	}

	@Override
	public String getVendor(int num) {
		if (validate(num)) {
			return infos[num].getVendor();
		}
		return "";
	}

	@Override
	public String getModel(int num) {
		if (validate(num)) {
			return infos[num].getModel();
		}
		return "";
	}

	@Override
	public long getCacheSize(int num) {
		if (validate(num)) {
			return infos[num].getCacheSize();
		}
		return -1;
	}

	@Override
	public double getUser(int num) {
		if (validate(num)) {
			double user = cpuList[num].getUser();
			return user;
		}
		return -1;
	}

	@Override
	public double getSys(int num) {
		if (validate(num)) {
			return cpuList[num].getSys();
		}
		return -1;
	}

	@Override
	public double getWait(int num) {
		if (validate(num)) {
			return cpuList[num].getWait();
		}
		return -1;
	}

	@Override
	public double getNice(int num) {
		if (validate(num)) {
			return cpuList[num].getNice();
		}
		return -1;
	}

	@Override
	public double getIdle(int num) {
		if (validate(num)) {
			return cpuList[num].getIdle();
		}
		return -1;
	}

	@Override
	public double getCombined(int num) {
		if (validate(num)) {
			return cpuList[num].getCombined();
		}
		return -1;
	}

	@Override
	public int getCPUNumber() {
		return infos.length;
	}

}
