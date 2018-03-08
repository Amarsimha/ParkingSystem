package com.whiteclark.parking.systems;

import com.whiteclark.parking.CarParkingSystem;
import com.whiteclark.parking.InvalidCommandException;
import com.whiteclark.parking.util.CarDirection;
import com.whiteclark.parking.util.CarLocation;
import com.whiteclark.parking.util.LocationValidator;

public class AutomaticParkingSystem implements CarParkingSystem{

	private int gridX;
	private int gridY;
	
	private CarLocation carLocation;
	private CarDirection carDirection;

	private String maneuverCommands;

	public AutomaticParkingSystem(Integer gridX, Integer gridY) {
		this.gridX = gridX;
		this.gridY = gridY;
	}

	public String executeCommand(String input) throws Exception {
		validateAndPrepareInput(input);
		startManeuvering();
		return carLocation.toString();
	}
	
	private void validateAndPrepareInput(String input) throws Exception {
		String command[] = input.split(":");
		int initialX;
		int initialY;

		if (command.length != 2) {
			throw new InvalidCommandException("Invalid input command");
		}

		String positionXY[] = command[0].split(",");

		if (positionXY.length != 2) {
			throw new InvalidCommandException("Invalid position command");
		}

		try {
			initialX = Integer.parseInt(positionXY[0]);
			initialY = Integer.parseInt(positionXY[1]);
		} catch (NumberFormatException nfe) {
			throw new InvalidCommandException("Invalid initial position");
		}
		

		if(!LocationValidator.isValidLocation(new CarLocation(initialX, initialY), gridX, gridY)) {
			throw new InvalidCommandException("Invalid initial position");
		}

		this.carLocation = new CarLocation(initialX, initialY);
		this.carDirection = CarDirection.NORTH;
		this.maneuverCommands = command[1];
	}

	private void startManeuvering() throws Exception {
		int totalCommands = this.maneuverCommands.length();
		CarLocation changedLocation = new CarLocation(carLocation);

		for(int i = 0; i < totalCommands; i++) {
			switch(this.maneuverCommands.charAt(i)) {
			case 'L': 
				turnLeft();
				break;
			case 'R':
				turnRight();
				break;
			case 'F':
				changedLocation = moveForward(changedLocation);
				break;
			default:
				throw new InvalidCommandException("Invalid maneuvering command");
			}

			if(!LocationValidator.isValidLocation(changedLocation, gridX, gridY)) {
				throw new InvalidCommandException("Invalid location reached");
			}
		}
		this.carLocation = changedLocation;
	}

	private void turnLeft() {
		switch(carDirection) {
		case NORTH:
			carDirection = CarDirection.WEST;
			break;
		case WEST:
			carDirection = CarDirection.SOUTH;
			break;
		case SOUTH:
			carDirection = CarDirection.EAST;
			break;
		case EAST:
			carDirection = CarDirection.NORTH;
			break;
		}
	}

	private void turnRight() {
		switch(carDirection) {
		case NORTH:
			carDirection = CarDirection.EAST;
			break;
		case WEST:
			carDirection = CarDirection.NORTH;
			break;
		case SOUTH:
			carDirection = CarDirection.WEST;
			break;
		case EAST:
			carDirection = CarDirection.SOUTH;
			break;
		}
	}

	private CarLocation moveForward(CarLocation carLocation) {
		int x = carLocation.getX();
		int y = carLocation.getY();
		
		switch(carDirection) {
		case NORTH:
			x++;
			break;
		case SOUTH:
			x--;
			break;
		case EAST:
			y++;
			break;
		case WEST:
			y--;
			break;
		}
		
		return new CarLocation(x,y);
	}

}
