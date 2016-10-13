package ict.monitor.bean;

public class PinpointTarget {
	private String applicationName;
	private String serviceType;
	private String code;
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "PinpointTarget [applicationName=" + applicationName + ", serviceType=" + serviceType + ", code=" + code + "]";
	}
}
