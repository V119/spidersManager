package com.sicdlib.util.stockUtil;

public class Node {
	private String id;
	private String label;
	private double size;
	private Integer cluster;
	private String color;
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	

	public Integer getCluster() {
		return cluster;
	}

	public void setCluster(Integer cluster) {
		this.cluster = cluster;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", label=" + label + ", size=" + size + ", cluster=" + cluster + ", color=" + color
				+ "]";
	}

	

	
	
}
