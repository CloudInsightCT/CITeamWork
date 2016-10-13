package ict.monitor.gather.net.imp;

import java.util.ArrayList;

import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import ict.monitor.common.ExceptionUtil;
import ict.monitor.gather.net.NetGather;

public class SigarNetGather implements NetGather {
	private Sigar sigar = null;
	private ArrayList<String> ifNames = new ArrayList<>();

	public SigarNetGather(Sigar sigar) throws SigarException {
		this.sigar = sigar;
		String[] allifNames = this.sigar.getNetInterfaceList();
		for (String name : allifNames) {
			NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
			if (ifconfig.getAddress().equals("0.0.0.0")) {
				continue;
			}
			ifNames.add(name);
		}
	}

	@Override
	public String getName(int num) {
		if (validate(num)) {
			return ifNames.get(num);
		}
		return "";
	}

	private boolean validate(int num) {
		if (ifNames.size() <= num || num < 0) {
			return false;
		}
		return true;
	}

	@Override
	public String getAddress(int num) {
		try {
			if (validate(num)) {
				NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames.get(num));
				return ifconfig.getAddress();
			}
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return null;
	}

	@Override
	public String getNetmask(int num) {
		try {
			if (validate(num)) {
				NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames.get(num));
				return ifconfig.getNetmask();
			}
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return null;
	}

	@Override
	public String getBroadcast(int num) {
		try {
			if (validate(num)) {
				NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames.get(num));
				return ifconfig.getBroadcast();
			}
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return null;
	}

	@Override
	public String getHwaddr(int num) {
		try {
			if (validate(num)) {
				NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames.get(num));
				return ifconfig.getHwaddr();
			}
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return null;
	}

	@Override
	public String getDescription(int num) {
		try {
			if (validate(num)) {
				NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames.get(num));
				return ifconfig.getDescription();
			}
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return null;
	}

	@Override
	public String getType(int num) {
		try {
			if (validate(num)) {
				NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames.get(num));
				return ifconfig.getType();
			}
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return null;
	}

	@Override
	public long getRxPackets(int num) {
		try {
			if (validate(num)) {
				NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames.get(num));
				NetInterfaceStat ifstat = sigar.getNetInterfaceStat(ifNames.get(num));
				if ((ifconfig.getFlags() & 1L) <= 0L) {
					// System.out.println("!IFF_UP...skipping
					// getNetInterfaceStat");
					return -1;
				}
				return ifstat.getRxPackets();
			}
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return -1;
	}

	@Override
	public long getTxPackets(int num) {
		try {
			if (validate(num)) {
				NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames.get(num));
				NetInterfaceStat ifstat = sigar.getNetInterfaceStat(ifNames.get(num));
				if ((ifconfig.getFlags() & 1L) <= 0L) {
					// System.out.println("!IFF_UP...skipping
					// getNetInterfaceStat");
					return -1;
				}
				return ifstat.getTxPackets();
			}
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return -1;
	}

	@Override
	public long getRxBytes(int num) {
		try {
			if (validate(num)) {
				NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames.get(num));
				NetInterfaceStat ifstat = sigar.getNetInterfaceStat(ifNames.get(num));
				if ((ifconfig.getFlags() & 1L) <= 0L) {
					// System.out.println("!IFF_UP...skipping
					// getNetInterfaceStat");
					return -1;
				}
				return ifstat.getRxBytes();
			}
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return -1;
	}

	@Override
	public long getTxBytes(int num) {
		try {
			if (validate(num)) {
				NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames.get(num));
				NetInterfaceStat ifstat = sigar.getNetInterfaceStat(ifNames.get(num));
				if ((ifconfig.getFlags() & 1L) <= 0L) {
					// System.out.println("!IFF_UP...skipping
					// getNetInterfaceStat");
					return -1;
				}
				return ifstat.getTxBytes();
			}
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return -1;
	}

	@Override
	public long getRxErrors(int num) {
		try {
			if (validate(num)) {
				NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames.get(num));
				NetInterfaceStat ifstat = sigar.getNetInterfaceStat(ifNames.get(num));
				if ((ifconfig.getFlags() & 1L) <= 0L) {
					// System.out.println("!IFF_UP...skipping
					// getNetInterfaceStat");
					return -1;
				}
				return ifstat.getRxErrors();
			}
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return -1;
	}

	@Override
	public long getTxErrors(int num) {
		try {
			if (validate(num)) {
				NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames.get(num));
				NetInterfaceStat ifstat = sigar.getNetInterfaceStat(ifNames.get(num));
				if ((ifconfig.getFlags() & 1L) <= 0L) {
					// System.out.println("!IFF_UP...skipping
					// getNetInterfaceStat");
					return -1;
				}
				return ifstat.getTxErrors();
			}
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return -1;
	}

	@Override
	public long getRxDropped(int num) {
		try {
			if (validate(num)) {
				NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames.get(num));
				NetInterfaceStat ifstat = sigar.getNetInterfaceStat(ifNames.get(num));
				if ((ifconfig.getFlags() & 1L) <= 0L) {
					// System.out.println("!IFF_UP...skipping
					// getNetInterfaceStat");
					return -1;
				}
				return ifstat.getRxDropped();
			}
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return -1;
	}

	@Override
	public long getTxDropped(int num) {
		try {
			if (validate(num)) {
				NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames.get(num));
				NetInterfaceStat ifstat = sigar.getNetInterfaceStat(ifNames.get(num));
				if ((ifconfig.getFlags() & 1L) <= 0L) {
					// System.out.println("!IFF_UP...skipping
					// getNetInterfaceStat");
					return -1;
				}
				return ifstat.getTxDropped();
			}
		} catch (SigarException e) {
			ExceptionUtil.printStackTrace(e);
		}
		return -1;
	}

	@Override
	public int getNetNumber() {
		return ifNames.size();
	}

}
