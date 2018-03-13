package se.garaget.structure;

public class Car extends Vehicle {

	private int vehicleLength;
	
	public Car(VehicleType vehicleType, String registrationNumber, FuelType fuelType, int numberOfSeats, int vehicleLength) {
		super(vehicleType, registrationNumber, fuelType, numberOfSeats);
		this.vehicleLength = vehicleLength;
	}
	
	@Override
	public String toString() {
		return "Car : Registration number = " + getRegistrationNumber() + ", Fuel type = " + getFuelType() + ", Number of seats = " + getNumberOfSeats() + ", Vehicle length = " + vehicleLength + ".";
	}
	
}
