package cn.com.cloudinsight.model;

public class Host {
   private Integer hostid;
   private Integer proxy_hostid;
   private String host;
   private Integer status;
   private Integer disable_util;
   private String error;
   private Integer available;
   private String name;
   private Integer lastacess;
public Integer getHostid() {
	return hostid;
}
public void setHostid(Integer hostid) {
	this.hostid = hostid;
}
public Integer getProxy_hostid() {
	return proxy_hostid;
}
public void setProxy_hostid(Integer proxy_hostid) {
	this.proxy_hostid = proxy_hostid;
}
public String getHost() {
	return host;
}
public void setHost(String host) {
	this.host = host;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public Integer getDisable_util() {
	return disable_util;
}
public void setDisable_util(Integer disable_util) {
	this.disable_util = disable_util;
}
public String getError() {
	return error;
}
public void setError(String error) {
	this.error = error;
}
public Integer getAvailable() {
	return available;
}
public void setAvailable(Integer available) {
	this.available = available;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getLastacess() {
	return lastacess;
}
public void setLastacess(Integer lastacess) {
	this.lastacess = lastacess;
}
   
}
