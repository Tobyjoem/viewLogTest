package com.mullen.viewlogtest;

import java.util.ArrayList;

public class TimeStampLog {

	private ArrayList<ViewLog> sectionsWatched;
	
	public TimeStampLog() {
		sectionsWatched = new ArrayList<ViewLog>(); 
	}
	
	/**
	 * This function adds individual ViewLogs to the sectionsWatched ArrayList. If a new ViewLog overlaps
	 * or is one millisecond away from another ViewLog in the ArrayList, this function combines ViewLogs
	 * into one unique view.
	 * 
	 * @param view The ViewLog detailing the start and end times of the viewer's watching session
	 */
	public void addViewLog(ViewLog view) {
		//If the ArrayList is empty, then the new section is unique.
		if (sectionsWatched.isEmpty()) {
			sectionsWatched.add(view);
			return;
		}
		
		//If the new ViewLog ends before any other ViewLog starts, it is placed in the front of the ArrayList.
		if (view.getEndTime() <= sectionsWatched.get(0).getStartTime()) {
			sectionsWatched.add(0, view);
			combineTimes();
			return;
		}
		
		//If the new ViewLog starts after all other ViewLogs have ended, it is placed at the end of the ArrayList.
		if (view.getStartTime() >= sectionsWatched.get(sectionsWatched.size()-1).getEndTime()) {
			sectionsWatched.add(view);
			combineTimes();
			return;
		}
		
		//If the new ViewLog falls completely between two existing ViewLogs, the new ViewLog is placed between them.
		for (int i = 0; i < sectionsWatched.size(); i++) {
			if (view.getStartTime() > sectionsWatched.get(i).getEndTime() &&
				view.getEndTime() < sectionsWatched.get(i + 1).getStartTime()) {
				sectionsWatched.add(i+1, view);
				combineTimes();
				return;
			}
		}
		
		
		
		for (int i = 0; i < sectionsWatched.size(); i++) {
			if (view.getStartTime() < sectionsWatched.get(i).getEndTime() &&
					view.getEndTime() >= sectionsWatched.get(i).getEndTime()) {
				sectionsWatched.get(i).setEndTime(view.getEndTime());
				combineTimes();
			}
			
			if (view.getEndTime() > sectionsWatched.get(i).getStartTime() &&
					view.getStartTime() <= sectionsWatched.get(i).getStartTime()) {
				sectionsWatched.get(i).setStartTime(view.getStartTime());
				combineTimes();
			}
		}
	}
	
	/**
	 * This method combines sections in the sectionsWatched ArrayList that overlap
	 * or butt up against each other.
	 */
	public void combineTimes() {
		//If the sectionsWatched ArrayList is empty, the nothing happens.
		if (sectionsWatched.size() == 0) {return;}
		/*Iterates through the sectionsWatched ArrayList and combines overlapping
		 * and adjacent sections.
		 */
		for (int i = sectionsWatched.size() - 1; i > 0; i--) {
			if (sectionsWatched.get(i).getStartTime() - 1 <=
					sectionsWatched.get(i-1).getEndTime()) {
				sectionsWatched.get(i-1).setEndTime(sectionsWatched.get(i).getEndTime());
				sectionsWatched.remove(i);
			}
		}
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
