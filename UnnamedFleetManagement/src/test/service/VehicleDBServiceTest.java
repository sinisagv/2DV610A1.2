package test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Vehicle;
import service.VehicleDBService;

class VehicleDBServiceTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void addVehicleShouldReturnTrue() throws Exception {
		VehicleDBService sut = new VehicleDBService();
		assertTrue(sut.addVehicle(new Vehicle()));
		//assertEquals(sut.getFleet().size(), 1);
	}
	
	@Test
	void writeShouldReturnTrue() throws Exception {
		VehicleDBService sut = new VehicleDBService();
		assertTrue(sut.write());
	}

}
