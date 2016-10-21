package ict.monitor.bean;

public class SlowCallData {
	private String startTime;
	private String rpc;
	private String elapsed;
	private String exceptionMessage;
	private String agentId;
	private String remoteAddr;
	private String transactionId;
	
	
	
	public SlowCallData() {
		super();
	}



	public String getStartTime() {
		return startTime;
	}



	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public String getRpc() {
		return rpc;
	}



	public void setRpc(String rpc) {
		this.rpc = rpc;
	}



	public String getElapsed() {
		return elapsed;
	}



	public void setElapsed(String elapsed) {
		this.elapsed = elapsed;
	}



	public String getExceptionMessage() {
		return exceptionMessage;
	}



	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}



	public String getAgentId() {
		return agentId;
	}



	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}



	public String getRemoteAddr() {
		return remoteAddr;
	}



	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}



	public String getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}



	@Override
	public String toString() {
		return "SlowCallData [startTime=" + startTime + ", rpc=" + rpc + ", elapsed=" + elapsed + ", exceptionMessage="
				+ exceptionMessage + ", agentId=" + agentId + ", remoteAddr=" + remoteAddr + ", transactionId="
				+ transactionId + "]";
	}



	public SlowCallData(String startTime, String rpc, String elapsed, String exceptionMessage, String agentId,
			String remoteAddr, String transactionId) {
		super();
		this.startTime = startTime;
		this.rpc = rpc;
		this.elapsed = elapsed;
		this.exceptionMessage = exceptionMessage;
		this.agentId = agentId;
		this.remoteAddr = remoteAddr;
		this.transactionId = transactionId;
	}





	
	
	

}
