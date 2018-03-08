package com.whiteclark.parking.util;

public class CarLocation {

    int x;
    int y;

    public CarLocation(int x, int y) {
    	this.x = x;
    	this.y = y;
    }
    
    public CarLocation(CarLocation carPosition) {
    	this(carPosition.x, carPosition.y);
	}

	public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    
    public String toString() {
    	return String.format("%d,%d", x, y);
    }
}
