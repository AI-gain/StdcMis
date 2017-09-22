package com.dbEntity;

public class DrawData {
	
	private String name;
	private Integer count;
	
	
	
	public DrawData(String name, Integer count) {
		super();
		this.name = name;
		this.count = count;
	}
	
	
	public DrawData() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
