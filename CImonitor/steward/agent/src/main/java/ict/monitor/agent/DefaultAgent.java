package ict.monitor.agent;

import java.util.Timer;

import ict.communication.Transmission;
import ict.communication.impl.TCPClient;
import ict.monitor.common.ExceptionUtil;

public class DefaultAgent {
	private AgentContext context = new AgentContext();
	private Transmission client;
	private Timer timer = new Timer();
	public DefaultAgent() {
		try {
			context.init();
			System.out.println(context.toString());
		} catch (Exception e) {
			ExceptionUtil.printStackTrace(e);
			System.exit(-1);
		}
		client = new TCPClient(context.getServerIP(),context.getServerPort());
	}
	public void start() {
		timer.schedule(new MonitorTask(client,context),5000,10 * 1000);
		timer.schedule(new InfoTask(client,context),5000,600 * 1000);
	}
	
	public void stop() {
		timer.cancel();
	}
}
