package ict.monitor.collection.entity;

import ict.monitor.collection.service.MetricStoreService;

public class DevInfoEntity extends BaseEntity {
	private String devID;
	private String devInfo;
	
	public DevInfoEntity() {
		super();
	}
	public DevInfoEntity(String agentID,String devID, String devInfo) {
		this.devID = devID;
		this.devInfo = devInfo;
		setAgentID(agentID);
	}
	public String getDevID() {
		return devID;
	}
	public void setDevID(String devID) {
		this.devID = devID;
	}
	public String getDevInfo() {
		return devInfo;
	}
	public void setDevInfo(String devInfo) {
		this.devInfo = devInfo;
	}
	@Override
	public void insertUpdate(MetricStoreService service) {
		service.insertUpdate(this);
	}
}
