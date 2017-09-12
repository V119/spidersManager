package com.sicdlib.util.stockUtil;

public class Links {
	private String sourceID;
	private String targetID;
	private Double label;
	private Integer weight;
	private double size;
	
	
	
	public String getSourceID() {
		return sourceID;
	}
	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}
	public String getTargetID() {
		return targetID;
	}
	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public Double getLabel() {
		return label;
	}
	public void setLabel(Double label) {
		this.label = label;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Links [sourceID=" + sourceID + ", targetID=" + targetID + ", label=" + label + ", weight=" + weight
				+ ", size=" + size + "]";
	}
	
}
