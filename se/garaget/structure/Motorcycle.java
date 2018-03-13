package se.garaget.structure;

public class Motorcycle extends Vehicle {

	// Define unique property
	private int numberOfWheels;
	
	// Constructor
	public Motorcycle(VehicleType vehicleType, String registrationNumber, FuelType fuelType, int numberOfSeats, int numberOfWheels) {
		super(vehicleType, registrationNumber, fuelType, numberOfSeats);
		this.numberOfWheels = numberOfWheels;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	
	
	// Returns info about the Motorcycle,
	@Override
	public String toString() {
		return "Motorcycle : Registration number = " + getRegistrationNumber() + ", Fuel type = " + getFuelType() + ", Number of seats = " + getNumberOfSeats() + ", Number of wheels = " + getNumberOfWheels() + ".";
	}
	
}
