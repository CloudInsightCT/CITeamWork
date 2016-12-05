package ict.monitor.gather.fs.imp;

import java.util.ArrayList;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import ict.monitor.common.ExceptionUtil;
import ict.monitor.gather.fs.FSGather;

public class SigarFSGather implements FSGather {
	private Sigar sigar = null;
	private ArrayList<FileSystem> fslist = new ArrayList<>();

	public SigarFSGather(Sigar sigar) throws SigarException {
		this.sigar = sigar;
		FileSystem[] allList = this.sigar.getFileSystemList();
		for (FileSystem fileSystem : allList) {
			if(fileSystem.getType()==2){
				fslist.add(fileSystem);
			}
		}
	}

	private boolean validate(int num) {
		if (fslist.size() <= num || num < 0) {
			return false;
		}
		return true;
	}

	@Override
	public String getDevName(int num) {
		if (validate(num)) {
			FileSystem fs = fslist.get(num);
			return fs.getDevName();
		}
		return "";
	}

	@Override
	public String getDirName(int num) {
		if (validate(num)) {
			FileSystem fs = fslist.get(num);
			return fs.getDirName();
		}
		return "";
	}

	@Override
	public String getSysTypeName(int num) {
		if (validate(num)) {
			FileSystem fs = fslist.get(num);
			return fs.getSysTypeName();
		}
		return "";
	}

	@Override
	public String getTypeName(int num) {
		if (validate(num)) {
			FileSystem fs = fslist.get(num);
			return fs.getTypeName();
		}
		return "";
	}

	@Override
	public long getTotal(int num) {
		if (validate(num)) {
			FileSystem fs = fslist.get(num);
			FileSystemUsage usage;
			try {
				usage = sigar.getFileSystemUsage(fs.getDirName());
				return usage.getTotal();
			} catch (SigarException e) {
				ExceptionUtil.printStackTrace(e);
			}
		}
		return -1;
	}

	@Override
	public long getFree(int num) {
		if (validate(num)) {
			FileSystem fs = fslist.get(num);
			FileSystemUsage usage;
			try {
				usage = sigar.getFileSystemUsage(fs.getDirName());
				return usage.getFree();
			} catch (SigarException e) {
				ExceptionUtil.printStackTrace(e);
			}
		}
		return -1;
	}

	@Override
	public long getAvail(int num) {
		if (validate(num)) {
			FileSystem fs = fslist.get(num);
			FileSystemUsage usage;
			try {
				usage = sigar.getFileSystemUsage(fs.getDirName());
				return usage.getAvail();
			} catch (SigarException e) {
				ExceptionUtil.printStackTrace(e);
			}
		}
		return -1;
	}

	@Override
	public long getUsed(int num) {
		if (validate(num)) {
			FileSystem fs = fslist.get(num);
			FileSystemUsage usage;
			try {
				usage = sigar.getFileSystemUsage(fs.getDirName());
				return usage.getUsed();
			} catch (SigarException e) {
				ExceptionUtil.printStackTrace(e);
			}
		}
		return -1;
	}

	@Override
	public double getUsePercent(int num) {
		if (validate(num)) {
			FileSystem fs = fslist.get(num);
			FileSystemUsage usage;
			try {
				usage = sigar.getFileSystemUsage(fs.getDirName());
				return usage.getUsePercent();
			} catch (SigarException e) {
				ExceptionUtil.printStackTrace(e);
			}
		}
		return -1;
	}

	@Override
	public long getDiskReads(int num) {
		if (validate(num)) {
			FileSystem fs = fslist.get(num);
			FileSystemUsage usage;
			try {
				usage = sigar.getFileSystemUsage(fs.getDirName());
				return usage.getDiskReads();
			} catch (SigarException e) {
				ExceptionUtil.printStackTrace(e);
			}
		}
		return -1;
	}

	@Override
	public long getDiskWrites(int num) {
		if (validate(num)) {
			FileSystem fs = fslist.get(num);
			FileSystemUsage usage;
			try {
				usage = sigar.getFileSystemUsage(fs.getDirName());
				return usage.getDiskWrites();
			} catch (SigarException e) {
				ExceptionUtil.printStackTrace(e);
			}
		}
		return -1;
	}

	@Override
	public int getFSNumber() {
		return fslist.size();
	}

}
