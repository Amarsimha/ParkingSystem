package com.whiteclark.parking;

public class InvalidCommandException extends Exception {
	
	private static final long serialVersionUID = 3944978649123307297L;

	public InvalidCommandException(String message) {
		super(message);
	}

}
