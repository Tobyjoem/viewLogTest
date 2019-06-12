package com.mullen.viewlogtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeStampLogTest {

	/**
	 * Tests that new ViewLogs are placed in chronological order.
	 */
	@Test
	public void viewLogsPlacedInCorrectOrder() {
		TimeStampLog log = new TimeStampLog();
		
		ViewLog one = new ViewLog(846, 1952);
		ViewLog two = new ViewLog(2400, 2500);
		ViewLog three = new ViewLog(123, 795);
		ViewLog four = new ViewLog(2000, 2300);
		
		log.addViewLog(one);
		log.addViewLog(two);
		log.addViewLog(three);
		log.addViewLog(four);
		
		System.out.println(log.toString());
		assertEquals(log.getUVT(), 2178);
	}
	
	/**
	 * Tests that ViewLogs that are completely contained inside other ViewLogs are not recorded.
	 */
	@Test
	public void doNotAddDuplicateTimes() {
	    TimeStampLog log = new TimeStampLog();
	
	    ViewLog one = new ViewLog(1000, 2000);
	    ViewLog two = new ViewLog(3000, 4000);
	    
	    log.addViewLog(one);
	    log.addViewLog(two);
	    
	    //These ViewLogs should not be added.
	    ViewLog three = new ViewLog(1500, 1700);
	    ViewLog four = new ViewLog(3500, 4000);
	    
	    log.addViewLog(three);
	    log.addViewLog(four);
	    
	    assertEquals(log.getUVT(), 2000);
	}
	
	/**
	 * Tests that two ViewLogs that are one millisecond apart are combined into one.
	 */
	@Test
	public void adjacentCombination() {
		TimeStampLog log = new TimeStampLog();
		
		ViewLog one = new ViewLog(1000, 1999);
		ViewLog two = new ViewLog(2000, 3000);
		
		log.addViewLog(one);
		log.addViewLog(two);
		
		assertEquals(log.getUVT(), 2000);
	}
	
	/**
	 * Tests that overlapping ViewLogs are combined properly
	 */
	@Test
	public void overlappingCombination() {
		TimeStampLog log = new TimeStampLog();
		
		ViewLog one = new ViewLog(2000, 5000);
		ViewLog two = new ViewLog(3000, 7000);
		ViewLog three = new ViewLog(500, 2500);
		
		log.addViewLog(one);
		log.addViewLog(two);
		log.addViewLog(three);
		
		assertEquals(log.getUVT(), 6500);
	}
	
	/**
	 * Full test of all functionality
	 */
	@Test
	public void fullTest() {
		TimeStampLog log = new TimeStampLog();
		
		ViewLog one = new ViewLog(1000, 2000);
		ViewLog two = new ViewLog(1500, 1700);
		ViewLog three = new ViewLog(2001, 5000);
		ViewLog four = new ViewLog(500, 750);
		ViewLog five = new ViewLog(3500, 9000);
		ViewLog six = new ViewLog(15000, 98000);
		ViewLog seven = new ViewLog(10000, 11500);
		ViewLog eight = new ViewLog(9500, 9999);
		
		log.addViewLog(one);
		log.addViewLog(two);
		log.addViewLog(three);
		log.addViewLog(four);
		log.addViewLog(five);
		log.addViewLog(six);
		log.addViewLog(seven);
		log.addViewLog(eight);
		
		assertEquals(log.getUVT(), 93250);
	}
}
