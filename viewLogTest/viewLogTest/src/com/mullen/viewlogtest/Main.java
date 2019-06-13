package com.mullen.viewlogtest;

public class Main {

	public static void main(String[] args) {
		TimeStampLog log = new TimeStampLog();
	
		int start;
		int end;
		
		for (String set: args) {
			String[] splitStrings = set.split(",");
			start = Integer.parseInt(splitStrings[0]);
			end = Integer.parseInt(splitStrings[1]);
			ViewLog viewLog = new ViewLog(start, end);
			log.addViewLog(viewLog);
		}
		
		System.out.print(log.toString());
	}	
}
