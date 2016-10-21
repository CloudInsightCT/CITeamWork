package ict.monitor.agent;

import java.util.ArrayList;
import java.util.TimerTask;

import ict.communication.Transmission;
import ict.monitor.collection.encode.Encode;
import ict.monitor.collection.encode.SimpleEncode;
import ict.monitor.common.Constant;
import ict.monitor.gather.DefaultGather;

public class InfoTask extends TimerTask {
	private Transmission client;
	private AgentContext context;
	private Encode encode = new SimpleEncode();
	private DefaultGather gather = new DefaultGather();

	public InfoTask(Transmission client, AgentContext context) {
		this.client = client;
		this.context = context;
	}
	@Override
	public void run() {
		gather.beforeGather();
		ArrayList<String> datas = new ArrayList<>();
		int cpuNumber = gather.getCPUNumber();
		for (int i = 0; i < cpuNumber; i++) {
			datas.add(metricBuild("CPU" + i, gather.getMhz(i), gather.getVendor(i), gather.getModel(i), gather.getCacheSize(i)));
		}
		int fsNumber = gather.getFSNumber();
		for (int i = 0; i < fsNumber; i++) {
			datas.add(metricBuild("FS" + i, gather.getTypeName(i), gather.getSysTypeName(i), gather.getDirName(i), gather.getDevName(i)));
		}
		int netNumber = gather.getNetNumber();
		for (int i = 0; i < netNumber; i++) {
			datas.add(metricBuild("NET" + i, gather.getName(i), gather.getAddress(i), gather.getNetmask(i), gather.getBroadcast(i), gather.getHwaddr(i), gather.getDescription(i), gather.getType(i)));
		}
		datas.add((String) encode.encode(Constant.AGENT_INFO, context.getId(), gather.getOS(),gather.getOSArc(),gather.getOSVersion(),gather.getOSIP(),gather.getComputerName(),gather.getHostName()));
		client.send(datas);
	}

	private String metricBuild(Object... objs) {
		String encodeStr = (String) encode.encode(Constant.INFO, context.getId(), objs);
		return encodeStr;
	}

}
