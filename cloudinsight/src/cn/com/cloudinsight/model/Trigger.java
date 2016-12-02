package cn.com.cloudinsight.model;

public class Trigger {
   
	private Integer triggerid;
	private String expression;
	private String description;
	private Integer status;
	private Integer value;
	private Integer priority;
	private Integer lastchange;
	private Integer templateid;
	private Integer flags;
	private String formertime;
	public String getFormertime() {
		return formertime;
	}
	public void setFormertime(String formertime) {
		this.formertime = formertime;
	}
	public Integer getTriggerid() {
		return triggerid;
	}
	public void setTriggerid(Integer triggerid) {
		this.triggerid = triggerid;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getLastchange() {
		return lastchange;
	}
	public void setLastchange(Integer lastchange) {
		this.lastchange = lastchange;
	}
	public Integer getTemplateid() {
		return templateid;
	}
	public void setTemplateid(Integer templateid) {
		this.templateid = templateid;
	}
	public Integer getFlags() {
		return flags;
	}
	public void setFlags(Integer flags) {
		this.flags = flags;
	}
}
