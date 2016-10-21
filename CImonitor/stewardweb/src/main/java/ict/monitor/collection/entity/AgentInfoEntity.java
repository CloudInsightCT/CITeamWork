package ict.monitor.collection.entity;

import ict.monitor.collection.service.MetricStoreService;

public class AgentInfoEntity extends BaseEntity {
	private String os;
	private String osArc;
	private String osVersion;
	private String ip;
	private String computerName;
	private String hostName;
	
	public AgentInfoEntity() {
	}
	
	public AgentInfoEntity(String agentID,String os, String osArc, String osVersion, String ip, String computerName, String hostName) {
		setAgentID(agentID);
		this.os = os;
		this.osArc = osArc;
		this.osVersion = osVersion;
		this.ip = ip;
		this.computerName = computerName;
		this.hostName = hostName;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getOsArc() {
		return osArc;
	}
	public void setOsArc(String osArc) {
		this.osArc = osArc;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	@Override
	public void insertUpdate(MetricStoreService service) {
		service.insertUpdate(this);
	}
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
}
