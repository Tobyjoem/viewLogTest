package com.mullen.viewlogtest;

public class ViewLog implements Comparable<ViewLog>{

	//Fields
	private Integer startTime;
	private Integer endTime;
	
	//Constructor
	public ViewLog(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	//Getters and Setters
	public Integer getStartTime() {
		return startTime;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public Integer getEndTime() {
		return endTime;
	}
	
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	public int getRunTime() {
		return endTime-startTime;
	}
	
	@Override
	public int compareTo(ViewLog other) {
	     int result = this.getStartTime().compareTo(other.getStartTime());
	     if (result == 0) {
	          result = this.getEndTime().compareTo(other.getEndTime());
	     }
	     return result;
	}
}