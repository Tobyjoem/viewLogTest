package com.mullen.viewlogtest;

public class ViewLog {

	//Fields
	private int startTime;
	private int endTime;
	
	//Constructor
	public ViewLog(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	//Getters and Setters
	public int getStartTime() {
		return startTime;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	public int getRunTime() {
		return endTime-startTime;
	}
}
