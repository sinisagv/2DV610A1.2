package test.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.json.JSONObject;
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
	void parseJsonObjectShouldReturnAVehicle() {
		VehicleDBService mockedDB = mock(VehicleDBService.class);
		JSONObject jo = new JSONObject();
		assertTrue(mockedDB.parseJsonVehicle(jo) instanceof Vehicle);
		verify(mockedDB).read();
	}

}
