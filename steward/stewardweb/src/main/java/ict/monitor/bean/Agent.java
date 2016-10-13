package ict.monitor.bean;

import ict.monitor.collection.entity.AgentInfoEntity;

public class Agent {
	private int userID;
	private String agentID;
	private AgentInfoEntity entity;
	private int type;
	
	public Agent(int userID, String agentID,int type) {
		this.userID = userID;
		this.agentID = agentID;
		this.type = type;
	}

	public Agent() {
		super();
	}

	public AgentInfoEntity getEntity() {
		return entity;
	}

	public void setEntity(AgentInfoEntity entity) {
		this.entity = entity;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Agent [userID=" + userID + ", agentID=" + agentID + ", entity=" + entity + ", type=" + type + "]";
	}
	
}
