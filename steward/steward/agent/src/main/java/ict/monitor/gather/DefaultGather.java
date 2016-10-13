package ict.monitor.gather;

import org.hyperic.sigar.Sigar;

import ict.monitor.common.ExceptionUtil;
import ict.monitor.gather.cpu.CPUGather;
import ict.monitor.gather.cpu.imp.SigarCPUGather;
import ict.monitor.gather.fs.FSGather;
import ict.monitor.gather.fs.imp.SigarFSGather;
import ict.monitor.gather.memory.MemmoryGather;
import ict.monitor.gather.memory.imp.SigarMemmoryGather;
import ict.monitor.gather.net.NetGather;
import ict.monitor.gather.net.imp.SigarNetGather;
import ict.monitor.gather.os.OSGather;
import ict.monitor.gather.os.imp.SigarOSGather;

public class DefaultGather implements MemmoryGather, CPUGather, NetGather, FSGather, OSGather {
	private MemmoryGather memmoryGather = null;
	private CPUGather cpuGather = null;
	private NetGather netGather = null;
	private FSGather fsGather = null;
	private OSGather osGather = null;
	private Sigar sigar = new Sigar();

	public void beforeGather() {
		try {
			fsGather = new SigarFSGather(sigar);
		} catch (Exception e) {
			ExceptionUtil.printStackTrace(e);
		}
		try {
			netGather = new SigarNetGather(sigar);
		} catch (Exception e) {
			ExceptionUtil.printStackTrace(e);
		}
		try {
			cpuGather = new SigarCPUGather(sigar);
		} catch (Exception e) {
			ExceptionUtil.printStackTrace(e);
		}
		try {
			memmoryGather = new SigarMemmoryGather(sigar);
		} catch (Exception e) {
			ExceptionUtil.printStackTrace(e);
		}
		try {
			osGather = new SigarOSGather(sigar);
		} catch (Exception e) {
			ExceptionUtil.printStackTrace(e);
		}
	}

	public void afterGather() {
		sigar.close();
	}

	@Override
	public String getDevName(int num) {
		if (fsGather != null) {
			return fsGather.getDevName(num);
		}
		return "";
	}

	@Override
	public String getDirName(int num) {
		if (fsGather != null) {
			return fsGather.getDirName(num);
		}
		return "";
	}

	@Override
	public String getSysTypeName(int num) {
		if (fsGather != null) {
			return fsGather.getSysTypeName(num);
		}
		return "";
	}

	@Override
	public String getTypeName(int num) {
		if (fsGather != null) {
			return fsGather.getTypeName(num);
		}
		return "";
	}

	@Override
	public long getTotal(int num) {
		if (fsGather != null) {
			return fsGather.getTotal(num);
		}
		return -1;
	}

	@Override
	public long getFree(int num) {

		if (fsGather != null) {
			return fsGather.getFree(num);
		}
		return -1;
	}

	@Override
	public long getAvail(int num) {

		if (fsGather != null) {
			return fsGather.getAvail(num);
		}
		return -1;
	}

	@Override
	public long getUsed(int num) {

		if (fsGather != null) {
			return fsGather.getUsed(num);
		}
		return -1;
	}

	@Override
	public double getUsePercent(int num) {

		if (fsGather != null) {
			return fsGather.getUsePercent(num);
		}
		return -1;
	}

	@Override
	public long getDiskReads(int num) {

		if (fsGather != null) {
			return fsGather.getDiskReads(num);
		}
		return -1;
	}

	@Override
	public long getDiskWrites(int num) {

		if (fsGather != null) {
			return fsGather.getDiskWrites(num);
		}
		return -1;
	}

	@Override
	public String getName(int num) {

		if (netGather != null) {
			return netGather.getName(num);
		}
		return "";
	}

	@Override
	public String getAddress(int num) {

		if (netGather != null) {
			return netGather.getAddress(num);
		}
		return "";
	}

	@Override
	public String getNetmask(int num) {

		if (netGather != null) {
			return netGather.getNetmask(num);
		}
		return "";
	}

	@Override
	public String getBroadcast(int num) {

		if (netGather != null) {
			return netGather.getBroadcast(num);
		}
		return "";
	}

	@Override
	public String getHwaddr(int num) {

		if (netGather != null) {
			return netGather.getHwaddr(num);
		}
		return "";
	}

	@Override
	public String getDescription(int num) {

		if (netGather != null) {
			return netGather.getDescription(num);
		}
		return "";
	}

	@Override
	public String getType(int num) {

		if (netGather != null) {
			return netGather.getType(num);
		}
		return "";
	}

	@Override
	public long getRxPackets(int num) {

		if (netGather != null) {
			return netGather.getRxPackets(num);
		}
		return -1;
	}

	@Override
	public long getTxPackets(int num) {

		if (netGather != null) {
			return netGather.getTxPackets(num);
		}
		return -1;
	}

	@Override
	public long getRxBytes(int num) {

		if (netGather != null) {
			return netGather.getRxBytes(num);
		}
		return -1;
	}

	@Override
	public long getTxBytes(int num) {

		if (netGather != null) {
			return netGather.getTxBytes(num);
		}
		return -1;
	}

	@Override
	public long getRxErrors(int num) {

		if (netGather != null) {
			return netGather.getRxErrors(num);
		}
		return -1;
	}

	@Override
	public long getTxErrors(int num) {

		if (netGather != null) {
			return netGather.getTxErrors(num);
		}
		return -1;
	}

	@Override
	public long getRxDropped(int num) {

		if (netGather != null) {
			return netGather.getRxDropped(num);
		}
		return -1;
	}

	@Override
	public long getTxDropped(int num) {

		if (netGather != null) {
			return netGather.getTxDropped(num);
		}
		return -1;
	}

	@Override
	public long getMhz(int num) {

		if (cpuGather != null) {
			return cpuGather.getMhz(num);
		}
		return -1;
	}

	@Override
	public String getVendor(int num) {

		if (cpuGather != null) {
			return cpuGather.getVendor(num);
		}
		return "";
	}

	@Override
	public String getModel(int num) {

		if (cpuGather != null) {
			return cpuGather.getModel(num);
		}
		return "";
	}

	@Override
	public long getCacheSize(int num) {

		if (cpuGather != null) {
			return cpuGather.getCacheSize(num);
		}
		return -1;
	}

	@Override
	public double getUser(int num) {

		if (cpuGather != null) {
			return cpuGather.getUser(num);
		}
		return -1;
	}

	@Override
	public double getSys(int num) {
		if (cpuGather != null) {
			return cpuGather.getSys(num);
		}
		return -1;
	}

	@Override
	public double getWait(int num) {

		if (cpuGather != null) {
			return cpuGather.getWait(num);
		}
		return -1;
	}

	@Override
	public double getNice(int num) {

		if (cpuGather != null) {
			return cpuGather.getNice(num);
		}
		return -1;
	}

	@Override
	public double getIdle(int num) {

		if (cpuGather != null) {
			return cpuGather.getIdle(num);
		}
		return -1;
	}

	@Override
	public double getCombined(int num) {

		if (cpuGather != null) {
			return cpuGather.getCombined(num);
		}
		return -1;
	}

	@Override
	public long getMemTotal() {

		if (memmoryGather != null) {
			return memmoryGather.getMemTotal();
		}
		return -1;
	}

	@Override
	public long getMemUsed() {

		if (memmoryGather != null) {
			return memmoryGather.getMemUsed();
		}
		return -1;
	}

	@Override
	public long getMemFree() {

		if (memmoryGather != null) {
			return memmoryGather.getMemFree();
		}
		return -1;
	}

	@Override
	public long getSwapTotal() {

		if (memmoryGather != null) {
			return memmoryGather.getSwapTotal();
		}
		return -1;
	}

	@Override
	public long getSwapUsed() {
		if (memmoryGather != null) {
			return memmoryGather.getSwapUsed();
		}
		return -1;
	}

	@Override
	public long getSwapFree() {

		if (memmoryGather != null) {
			return memmoryGather.getSwapFree();
		}
		return -1;
	}

	@Override
	public String getOS() {

		if (osGather != null) {
			return osGather.getOS();
		}
		return "";
	}

	@Override
	public String getOSArc() {

		if (osGather != null) {
			return osGather.getOSArc();
		}
		return "";
	}

	@Override
	public String getOSVersion() {

		if (osGather != null) {
			return osGather.getOSVersion();
		}
		return "";
	}

	@Override
	public String getOSIP() {

		if (osGather != null) {
			return osGather.getOSIP();
		}
		return "";
	}

	@Override
	public String getComputerName() {
		if (osGather != null) {
			return osGather.getComputerName();
		}
		return "";
	}

	@Override
	public String getHostName() {
		if (osGather != null) {
			return osGather.getHostName();
		}
		return "";
	}

	@Override
	public int getCPUNumber() {
		if (cpuGather != null) {
			return cpuGather.getCPUNumber();
		}
		return -1;
	}

	@Override
	public int getNetNumber() {

		if (netGather != null) {
			return netGather.getNetNumber();
		}
		return -1;
	}

	@Override
	public int getFSNumber() {
		if (fsGather != null) {
			return fsGather.getFSNumber();
		}
		return -1;
	}

}
