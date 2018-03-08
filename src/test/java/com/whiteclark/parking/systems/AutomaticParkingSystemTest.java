package com.whiteclark.parking.systems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.whiteclark.parking.InvalidCommandException;

public class AutomaticParkingSystemTest {

	AutomaticParkingSystem aps;
	
	@Before
	public void setup() {
		aps = new AutomaticParkingSystem(15, 15);
	}
	
	@Test
	public void testInvalidInputNoManeuver() {
		try {
			aps.executeCommand("5,5:");
		} catch (Exception ice) {
			if(!(ice instanceof InvalidCommandException)) {
				Assert.fail();
			}
			Assert.assertEquals("Invalid input command", ice.getMessage());
		}
	}

	@Test
	public void testInvalidInputNoColon() {
		try {
			aps.executeCommand("5,5");
		} catch (Exception ice) {
			if(!(ice instanceof InvalidCommandException)) {
				Assert.fail();
			}
			Assert.assertEquals("Invalid input command", ice.getMessage());
		}
	}
	
	@Test
	public void testInvalidInputEmptyString() {
		try {
			aps.executeCommand("");
		} catch (Exception ice) {
			if(!(ice instanceof InvalidCommandException)) {
				Assert.fail();
			}
			Assert.assertEquals("Invalid input command", ice.getMessage());
		}
	}
	
	@Test
	public void testInvalidInputColon() {
		try {
			aps.executeCommand(":");
		} catch (Exception ice) {
			if(!(ice instanceof InvalidCommandException)) {
				Assert.fail();
			}
			Assert.assertEquals("Invalid input command", ice.getMessage());
		}
	}

	@Test
	public void testInvalidPosition() {
		try {
			aps.executeCommand("5:RFL");
		} catch (Exception ice) {
			if(!(ice instanceof InvalidCommandException)) {
				Assert.fail();
			}
			Assert.assertEquals("Invalid position command", ice.getMessage());
		}
	}

	@Test
	public void testInvalidInitialPosition() {
		try {
			aps.executeCommand("5,-5:RFRFRF");
		} catch (Exception ice) {
			if(!(ice instanceof InvalidCommandException)) {
				Assert.fail();
			}
			Assert.assertEquals("Invalid initial position", ice.getMessage());
		}
	}

	@Test
	public void testInvalidPositionNonInteger() {
		try {
			aps.executeCommand("A,5:RF");
		} catch (Exception ice) {
			if(!(ice instanceof InvalidCommandException)) {
				Assert.fail();
			}
			Assert.assertEquals("Invalid initial position", ice.getMessage());
		}
	}

	@Test
	public void testInvalidManeuver() {
		try {
			aps.executeCommand("5,5:RFRFE");
		} catch (Exception ice) {
			if(!(ice instanceof InvalidCommandException)) {
				Assert.fail();
			}
			Assert.assertEquals("Invalid maneuvering command", ice.getMessage());
		}
	}
	
	@Test
	public void testInvalidLocationReached() {
		try {
			aps.executeCommand("15,15:RF");
		} catch (Exception ice) {
			if(!(ice instanceof InvalidCommandException)) {
				Assert.fail();
			}
			Assert.assertEquals("Invalid location reached", ice.getMessage());
		}
	}

	@Test
	public void testManeuvering() throws Exception {
		String position;
		
		position = aps.executeCommand("5,6:F");
		Assert.assertEquals("6,6", position);
		
		position = aps.executeCommand("5,6:LLLF");
		Assert.assertEquals("5,7", position);
		
		position = aps.executeCommand("5,6:RRRF");
		Assert.assertEquals("5,5", position);

		position = aps.executeCommand("5,6:FFFFFFFFFFRRFFFFFFFFFF");
		Assert.assertEquals("5,6", position);
		
		position = aps.executeCommand("5,6:FFFFFFFFFFRFFFFFFFFF");
		Assert.assertEquals("15,15", position);
		
		position = aps.executeCommand("5,6:LFFFFFLFFFF");
		Assert.assertEquals("1,1", position);
	}
}
