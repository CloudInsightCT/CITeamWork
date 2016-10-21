package ict.monitor.agent;

import java.util.ArrayList;
import java.util.TimerTask;

import ict.communication.Transmission;
import ict.monitor.collection.encode.Encode;
import ict.monitor.collection.encode.SimpleEncode;
import ict.monitor.common.Constant;
import ict.monitor.gather.DefaultGather;

public class MonitorTask extends TimerTask {
	private Transmission client;
	private AgentContext context;
	private Encode encode = new SimpleEncode();
	private DefaultGather gather = new DefaultGather();

	public MonitorTask(Transmission client, AgentContext context) {
		this.client = client;
		this.context = context;
	}

	@Override
	public void run() {
		gather.beforeGather();
		int cpuNumber = gather.getCPUNumber();
		ArrayList<String> datas = new ArrayList<>();
		for (int i = 0; i < cpuNumber; i++) {
			datas.add(metricBuild("CPU" + i, Constant.CPU_USER, gather.getUser(i)));
			datas.add(metricBuild("CPU" + i, Constant.CPU_SYS, gather.getSys(i)));
			datas.add(metricBuild("CPU" + i, Constant.CPU_WAIT, gather.getWait(i)));
			datas.add(metricBuild("CPU" + i, Constant.CPU_NICE, gather.getNice(i)));
			datas.add(metricBuild("CPU" + i, Constant.CPU_IDLE, gather.getIdle(i)));
			datas.add(metricBuild("CPU" + i, Constant.CPU_COMBINED, gather.getCombined(i)));
		}
		int netNumber = gather.getNetNumber();
		for (int i = 0; i < netNumber; i++) {
			datas.add(metricBuild("NET" + i, Constant.NET_RXP, gather.getRxPackets(i)));
			datas.add(metricBuild("NET" + i, Constant.NET_TXP, gather.getTxPackets(i)));
			datas.add(metricBuild("NET" + i, Constant.NET_RXB, gather.getRxBytes(i)));
			datas.add(metricBuild("NET" + i, Constant.NET_TXB, gather.getTxBytes(i)));
			datas.add(metricBuild("NET" + i, Constant.NET_RXE, gather.getRxErrors(i)));
			datas.add(metricBuild("NET" + i, Constant.NET_TXE, gather.getTxErrors(i)));
			datas.add(metricBuild("NET" + i, Constant.NET_RXD, gather.getRxDropped(i)));
			datas.add(metricBuild("NET" + i, Constant.NET_TXD, gather.getTxDropped(i)));

		}
		int fsNumber = gather.getFSNumber();
		for (int i = 0; i < fsNumber; i++) {
			datas.add(metricBuild("FS" + i, Constant.FS_TOTAL, gather.getTotal(i)));
			datas.add(metricBuild("FS" + i, Constant.FS_AVAIL, gather.getAvail(i)));
			datas.add(metricBuild("FS" + i, Constant.FS_USED, gather.getUsed(i)));
			datas.add(metricBuild("FS" + i, Constant.FS_FREE, gather.getFree(i)));
			datas.add(metricBuild("FS" + i, Constant.FS_USE_PERCENT, gather.getUsePercent(i)));
			datas.add(metricBuild("FS" + i, Constant.FS_DISK_READS, gather.getDiskReads(i)));
			datas.add(metricBuild("FS" + i, Constant.FS_DISK_WRITES, gather.getDiskWrites(i)));
		}

		datas.add(metricBuild("MEM", Constant.MEM_TOTAL, gather.getMemTotal()));
		datas.add(metricBuild("MEM", Constant.MEM_FREE, gather.getMemFree()));
		datas.add(metricBuild("MEM", Constant.MEM_USED, gather.getMemUsed()));
		datas.add(metricBuild("MEM", Constant.MEM_SFREE, gather.getSwapFree()));
		datas.add(metricBuild("MEM", Constant.MEM_STOTAL, gather.getSwapTotal()));
		datas.add(metricBuild("MEM", Constant.MEM_SUSED, gather.getSwapUsed()));
		client.send(datas);
	}

	private String metricBuild(Object... objs) {
		String encodeStr = (String) encode.encode(Constant.METRIC, context.getId(), objs, System.currentTimeMillis());
		return encodeStr;
	}
}
