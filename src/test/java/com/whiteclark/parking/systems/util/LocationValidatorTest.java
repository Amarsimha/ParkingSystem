package com.whiteclark.parking.systems.util;

import org.junit.Assert;
import org.junit.Test;

import com.whiteclark.parking.util.CarLocation;
import com.whiteclark.parking.util.LocationValidator;

public class LocationValidatorTest {

	@Test
	public void testInvalidXPosition() {
		CarLocation carLocation = new CarLocation(23,10);
		Assert.assertFalse(LocationValidator.isValidLocation(carLocation, 20, 20));
	}

	@Test
	public void testNegativeXPosition() {
		CarLocation carLocation = new CarLocation(-3,10);
		Assert.assertFalse(LocationValidator.isValidLocation(carLocation, 20, 20));
	}
	
	@Test
	public void testInvalidYPosition() {
		CarLocation carLocation = new CarLocation(23,10);
		Assert.assertFalse(LocationValidator.isValidLocation(carLocation, 20, 5));
	}

	@Test
	public void testNegativeYPosition() {
		CarLocation carLocation = new CarLocation(3,-10);
		Assert.assertFalse(LocationValidator.isValidLocation(carLocation, 20, 20));
	}

	@Test
	public void testValidXPosition() {
		CarLocation carLocation = new CarLocation(10,10);
		Assert.assertTrue(LocationValidator.isValidLocation(carLocation, 20, 20));
	}

}
