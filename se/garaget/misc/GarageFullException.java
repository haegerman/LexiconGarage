package se.garaget.misc;

// Class that returns an exception if we try
// to add a vehicle to a full garage.

public class GarageFullException extends Exception {
	private static final long serialVersionUID = 7527462608086571309L;

	public GarageFullException() {
		super("Garage full.");
	}
}
