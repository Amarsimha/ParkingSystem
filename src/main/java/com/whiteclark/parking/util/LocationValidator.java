package com.whiteclark.parking.util;


public class LocationValidator {
	public static boolean isValidLocation(CarLocation carLocation, int gridXLimit, int gridYLimit) {
		int x = carLocation.getX();
		int y = carLocation.getY();
		
		if (x < 1 || x > gridXLimit || y < 1 || y > gridYLimit) {
			return false;
		}
		return true;
	}
}