package ict.monitor.collection.entity;

import ict.monitor.collection.service.MetricStoreService;

public abstract class BaseEntity {
	private String agentID;

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}

	public abstract void insertUpdate(MetricStoreService service);

	@Override
	public String toString() {
		return super.toString();
	}

}
