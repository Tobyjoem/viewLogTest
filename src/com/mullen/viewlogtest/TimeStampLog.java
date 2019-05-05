package com.mullen.viewlogtest;

import java.util.ArrayList;

public class TimeStampLog {

	private ArrayList<ViewLog> sectionsWatched;
	
	public TimeStampLog() {
		sectionsWatched = new ArrayList<ViewLog>(); 
	}
	
	public void addViewLog(ViewLog view) {
		
	}
	
	/**
	 * This function calculates the total time of unique video watched.
	 * 
	 * @return The total time in milliseconds
	 */
	public int getTotalTimeWatched() {
		int totalTimeWatched = 0;
		for (ViewLog view : sectionsWatched) {
			totalTimeWatched += (view.getEndTime() - view.getStartTime());
		}
		return totalTimeWatched;
	}
	
	@Override
	public String toString() {
		String results = "";
		
		for (ViewLog view : sectionsWatched) {
			results = results + view.getStartTime() + "-" + view.getEndTime() + ",";
		}
		
		results = results + "\n" + getTotalTimeWatched() + " milliseconds watched.";
		
		return results;
	}
}
