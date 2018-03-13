package se.garaget.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import se.garaget.structure.Bus;
import se.garaget.structure.Car;
import se.garaget.structure.FuelType;
import se.garaget.structure.Garage;
import se.garaget.structure.Motorcycle;
import se.garaget.structure.Vehicle;
import se.garaget.structure.VehicleType;



public class UI {

	Garage garage = new Garage();
//	private Vehicle vehicle;
	private int maxVehicles;
	ArrayList<Vehicle> inventory = new ArrayList<Vehicle>();

	public void welcome() {
		
		System.out.println("Welcome to Garage 1.0");
		System.out.println("---------------------");	
		garage();
		
	}
	
	public void garage() {
	
		System.out.println("\n1. List all parked vehicles");
		System.out.println("2. List all vehicle types");
		System.out.println("3. Park vehicle");
		System.out.println("4. Remove vehicle");	
		System.out.println("5. Set maximum garage capacity");
		System.out.println("6. Find vehicle");		
		System.out.println("7. Exit garage");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nPlease select a choice: ");
		while(!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("\nSelection not possible: Please select 1-7!");
            garage();
		}
		int choice = scanner.nextInt();
		
		if (choice == 0 || choice >= 8) {
			System.out.println("\nSelection not possible: Please select 1-7!");
			garage();
		}
		switch (choice) {
	        case 1:  listAllParkedVehicles();	
	        		break;
	        case 2:  listAllVehicleTypes();
	        		break;
	        case 3:  parkVehicle();
	        		break;
	        case 4:  removeVehicle();
	        		break;
	        case 5:  setMaximumGarageCapacity();	
	        		break;
	        case 6:  findVehicle();
	        		break;
	        case 7:  exit();
	        		break;
		}
		scanner.close();
	}
	
	public void listAllParkedVehicles() {
		System.out.println("\nALL PARKED VEHICLES");
		List<Vehicle> inventory = garage.getNumberOfVehicles();
		
		for (Vehicle v : inventory) {
			System.out.println(v.toString());
		}
		if (inventory.size() == 0) {
			System.out.println("Garage empty");
		}
		
		System.out.println("\n1. Main menu");
		System.out.println("2. Exit garage");
		Scanner scanner = new Scanner(System.in);
		while(!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("\nSelection not possible: Please select 1 or 2!");
			listAllParkedVehicles();
		}
		int choice = scanner.nextInt();
	
		if (choice == 1) {
			garage();
		} else if (choice == 2) {
			exit();
		} else {
            System.out.println("Selection not possible: Please select 1 or 2!");
            listAllParkedVehicles();
		}
		scanner.close();
	}
	
	public void listAllVehicleTypes() {
		System.out.println("\nVEHICLE TYPES");

		System.out.println(garage.numberOfVehicles() + " vehicles parked.");
		garage.listAllVehicleTypes();

		System.out.println("\n1. Main menu");
		System.out.println("2. Exit garage");
		Scanner scanner = new Scanner(System.in);
		while(!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("\nSelection not possible: Please select 1 or 2!");
			listAllVehicleTypes();
		}
		int choice = scanner.nextInt();
	
		if (choice == 1) {
			garage();
		} else if (choice == 2) {
			exit();
		} else {
            System.out.println("Selection not possible: Please select 1 or 2!");
            listAllVehicleTypes();
		}
		scanner.close();
	}
	
	public void parkVehicle() {
		System.out.println("\nPARK VEHICLE");
//		try {
			Scanner scanner = new Scanner(System.in);
	
			System.out.print("Enter vehicle type: ");
			String stringVehicleType = scanner.next();
	
			System.out.print("Enter registration number: ");
			String stringRegistrationNumber = scanner.next();
	
			System.out.print("Enter fuel type: ");
			String stringFuelType = scanner.next();
	
			System.out.print("Enter number of seats: ");
			String numberOfSeats = scanner.next();
			int intNumberOfSeats = Integer.parseInt(numberOfSeats);
	
			switch (stringVehicleType) {
			
				case "car": 
					System.out.print("Enter vehicle length: ");
					String vehicleLength = scanner.next();
					int intVehicleLength = Integer.parseInt(vehicleLength);
		
					Car car = new Car(convertStringVehicle(stringVehicleType), stringRegistrationNumber, convertStringFuel(stringFuelType), intNumberOfSeats, intVehicleLength);
					garage.parkVehicle(car);
					System.out.println("Vehicle added: CAR");
					break;
		
				case "motorcycle":
					System.out.print("Enter number of wheels: ");
					String numberOfWheels = scanner.next();
					int intNumberOfWheels = Integer.parseInt(numberOfWheels);
		
					Motorcycle motorcycle = new Motorcycle(convertStringVehicle(stringVehicleType), stringRegistrationNumber, convertStringFuel(stringFuelType), intNumberOfSeats, intNumberOfWheels);
					garage.parkVehicle(motorcycle);
					System.out.println("Vehicle added: MOTORCYCLE");
					break;
		
				case "bus":
					System.out.print("Enter number of storeys: ");
					String storeys = scanner.next();
					int intStoreys = Integer.parseInt(storeys);
		
					Bus bus = new Bus(convertStringVehicle(stringVehicleType), stringRegistrationNumber, convertStringFuel(stringFuelType), intNumberOfSeats, intStoreys);
					garage.parkVehicle(bus);
					System.out.println("Vehicle added: BUS");
					break;
					
				default:
					System.out.println("\nVehicle cannot be parked");
			}	
			System.out.println("\n1. Main Menu");
			System.out.println("2. Exit");

			while(!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("\nSelection not possible: Please select 1 or 2!");
				findVehicle();
			}
			int choice = scanner.nextInt();

			if (choice == 1) {
				garage();
			} else if (choice == 2) {
				exit();
			} else {
				System.out.println("Selection not possible: Please select 1 or 2!");
			}	
			scanner.close();				
	}
			


	private VehicleType convertStringVehicle(String stringVehicleType) {

		VehicleType vehicleType = null;
	
		switch (stringVehicleType) {
	
		case "car":
			vehicleType = VehicleType.CAR;
			break;
		case "motorcycle":
			vehicleType = VehicleType.MOTORCYCLE;
			break;
		case "bus":
			vehicleType = VehicleType.BUS;
			break;
		}
		return vehicleType;
	}
	
	
	private FuelType convertStringFuel(String stringFuelType) {

		FuelType fuelType = null;
	
		switch (stringFuelType) {
	
		case "electric":
			fuelType = FuelType.ELECTRIC;
			break;
		case "petrol":
			fuelType = FuelType.PETROL;
			break;
		case "diesel":
			fuelType = FuelType.DIESEL;
			break;
		case "hybrid":
			fuelType = FuelType.HYBRID;
			break;
		}
		return fuelType;
	}



	public void removeVehicle() {
		System.out.println("\nREMOVE VEHICLE");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter registration number: ");
		String regNo = scanner.next();
		System.out.println("Registration number: " + regNo);
		garage.checkOutVehicle(regNo);
		
		System.out.println("\n1. Main menu");
		System.out.println("2. Exit garage");
		
		while(!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("\nSelection not possible: Please select 1 or 2!");
			removeVehicle();
		}
		int choice = scanner.nextInt();
	
		if (choice == 1) {
			garage();
		} else if (choice == 2) {
			exit();
		} else {
            System.out.println("Selection not possible: Please select 1 or 2!");
            removeVehicle();
		}
		scanner.close();
	}
	
	public void setMaximumGarageCapacity() {
		System.out.println("\nMAXIMUM GARAGE CAPACITY");
		
		System.out.println("Garage contains: " + garage.numberOfVehicles() + " vehicles.");
		System.out.println("Garage has " + maxVehicles + " spaces available.");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Set garage capacity to: ");
		String garageCapacity = scanner.next();
//		System.out.println("Garage capacity set to: " + garageCapacity);
		int size = Integer.parseInt(garageCapacity);
		size = size - garage.numberOfVehicles();
		System.out.println("Available garage spaces: " + size);
		garage.setMaximumGarageCapacity(size);	
		
		System.out.println("\n1. Main menu");
		System.out.println("2. Exit garage");

		while(!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("\nSelection not possible: Please select 1 or 2!");
			setMaximumGarageCapacity();
		}
		int choice = scanner.nextInt();
	
		if (choice == 1) {
			garage();
		} else if (choice == 2) {
			exit();
		} else {
            System.out.println("Selection not possible: Please select 1 or 2!");
            setMaximumGarageCapacity();
		}
		scanner.close();
	}
	
	public void findVehicle() {
		System.out.println("\nFIND VEHICLE");
		
		System.out.print("Enter registration number: ");
		Scanner scanner = new Scanner(System.in);
		String regNo = scanner.next();
		System.out.println("Registration number " + regNo);
		garage.findVehicleByRegNo(regNo);

//		Vehicle vehicleFound = garage.findVehicleByRegNo(regNo);
//		System.out.println(foundVehicle.toString());
		
		
		while(!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("\nSelection not possible: Please select 1 or 2!");
		}
		int choice = scanner.nextInt();
	
		if (choice == 1) {
			garage();
		} else if (choice == 2) {
			exit();
		} else {
            System.out.println("Selection not possible: Please select 1 or 2!");
		}
		scanner.close();
	}
	
	public void exit() {
		System.out.println("Thanks for your visit. Welcome back!");
	}
	
}