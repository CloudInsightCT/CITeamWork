package ict.monitor.datamining;


import java.util.ArrayList;

public class RuleNode {
	ArrayList<String> pre;
	ArrayList<String> res;

	double support;
	double confidence;

	RuleNode() {
		pre = new ArrayList<String>();
		res = new ArrayList<String>();
	}

	public ArrayList<String> getPre() {
		return pre;
	}

	public void setPre(ArrayList<String> pre) {
		this.pre = pre;
	}

	public ArrayList<String> getRes() {
		return res;
	}

	public void setRes(ArrayList<String> res) {
		this.res = res;
	}

	public double getSupport() {
		return support;
	}

	public void setSupport(double support) {
		this.support = support;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

}
