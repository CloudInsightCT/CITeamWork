package ict.monitor.agent;

import ict.monitor.common.PropertiesUtil;

public class AgentContext {
	private String id;
	private String serverIP;
	private int serverPort;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void init() throws Exception {
		PropertiesUtil propertiesUtil = new PropertiesUtil();
		setServerIP(propertiesUtil.readStrValue("serverIP"));
		setServerPort(propertiesUtil.readIntValue("serverPort"));
		setId(propertiesUtil.readStrValue("id"));
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	@Override
	public String toString() {
		return "AgentContext [id=" + id + ", serverIP=" + serverIP + ", serverPort=" + serverPort + "]";
	}

}
