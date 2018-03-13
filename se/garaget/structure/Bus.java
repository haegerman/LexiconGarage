package se.garaget.structure;

public class Bus extends Vehicle {

	private int storeys;

	public Bus(VehicleType vehicleType, String registrationNumber, FuelType fuelType, int numberOfSeats, int storeys) {
		super(vehicleType, registrationNumber, fuelType, numberOfSeats);
		this.storeys = storeys;
	}

	
	public int getStoreys() {
		return storeys;
	}

	@Override
	public String toString() {
		return "Bus : Registration number = " + getRegistrationNumber() + ", Fuel type = " + getFuelType() + ", Number of seats = " + getNumberOfSeats() + ", Number of storeys = " + getStoreys() + ".";
	}

}
