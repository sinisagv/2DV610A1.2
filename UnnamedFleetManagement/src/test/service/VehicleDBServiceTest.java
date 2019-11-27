package test.service;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Bus;
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
		assertTrue(sut.addVehicle(new Bus()));
		//assertEquals(sut.getFleet().size(), 1);
	}

}
