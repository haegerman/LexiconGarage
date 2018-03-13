package se.garaget.structure;

public abstract class Vehicle {

	// Define mandatory properties.
	// They are set in the instantiating subclasses.

	private VehicleType vehicleType;
	private FuelType fuelType;
	private int numberOfSeats;
	private String registrationNumber;

	public Vehicle(VehicleType vehicleType, String registrationNumber, FuelType fuelType, int numberOfSeats) {
		this.vehicleType = vehicleType;
		this.fuelType = fuelType;
		this.numberOfSeats = numberOfSeats;
		this.registrationNumber = registrationNumber;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
	public FuelType getFuelType() {
		return fuelType;
	}	
	
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	@Override
	public String toString() {
		return "Vehicle : " + registrationNumber + ".";
	}
	
	

}
