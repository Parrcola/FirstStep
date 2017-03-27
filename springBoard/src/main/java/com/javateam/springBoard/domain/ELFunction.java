package com.javateam.springBoard.domain;

public class ELFunction {
	
	public static int abs(String str) {
		
		int result =0;
		
		Double temp = new Double(str);
		result = (int)Math.abs(temp);
		
		return result;
	}

}
