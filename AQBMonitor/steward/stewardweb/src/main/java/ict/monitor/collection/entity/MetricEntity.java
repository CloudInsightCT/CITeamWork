package ict.monitor.collection.entity;

import ict.monitor.collection.service.MetricStoreService;

public class MetricEntity extends BaseEntity {

	private String devID;
	private String tag;
	private double metric;
	private long timestamp;

	public MetricEntity() {
		super();
	}

	public MetricEntity(String agentID, String devID, String tag, double metric, long timestamp) {
		this.tag = tag;
		this.metric = metric;
		this.timestamp = timestamp;
		super.setAgentID(agentID);
		this.devID = devID;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public double getMetric() {
		return metric;
	}

	public void setMetric(double metric) {
		this.metric = metric;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getDevID() {
		return devID;
	}

	public void setDevID(String devID) {
		this.devID = devID;
	}

	@Override
	public void insertUpdate(MetricStoreService service) {
		service.insertUpdate(this);
	}

	@Override
	public String toString() {
		return "MetricEntity [devID=" + devID + ", tag=" + tag + ", metric=" + metric + ", timestamp=" + timestamp + ", getAgentID()=" + getAgentID() + "]";
	}
	
	
}
