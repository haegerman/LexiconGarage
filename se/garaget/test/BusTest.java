package se.garaget.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import se.garaget.misc.CannotCreateVehicleException;
import se.garaget.structure.Bus;
import se.garaget.structure.FuelType;

public class BusTest {

	@Test
	public void testCreateBus() throws CannotCreateVehicleException {
		// Try to create a new 2 storey bus
//		Bus bus = new Bus(FuelType.petrol, 40, 20000, "BUS123", 2);
//		assertTrue(bus != null);
	}
	
	@Test
	public void testCreateFlatBus() throws CannotCreateVehicleException {
		// Try to create a new flat bus
//		Bus bus = new Bus(FuelType.petrol, 40, 20000, "BUS123", 0);
//		assertFalse(bus != null);
	}

}
