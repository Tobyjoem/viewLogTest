package com.mullen.viewlogtest;

import java.util.ArrayList;
import java.util.Collections;

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
		for (ViewLog section : sectionsWatched) {
			if (view.getStartTime() >= section.getStartTime() && view.getEndTime() <= section.getEndTime()) {
				return;
			}
		}
		sectionsWatched.add(view);
		Collections.sort(sectionsWatched);
		combineTimes();
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
	public int getUVT() {
		int uvt = 0;
		for (ViewLog view : sectionsWatched) {
			uvt += (view.getEndTime() - view.getStartTime());
		}
		return uvt;
	}
	
	
	public ArrayList<ViewLog> getSectionsWatched() {
		return sectionsWatched;
	}

	@Override
	public String toString() {
		String results = "";
		
		for (ViewLog view : sectionsWatched) {
			results = results + view.getStartTime() + "-" + view.getEndTime() + ",";
		}
		
		results = results + "\n" + getUVT() + " milliseconds watched.";
		
		return results;
	}
}