package test.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Booking;
import main.model.Vehicle;

class BookingTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void addVehicleShouldReturnTrueWhenVehicleIsAdded() {
		Booking sut = new Booking();
		Vehicle mockVehicle = mock(Vehicle.class);
		assertTrue(sut.addVehicle(mockVehicle));
		assertFalse(sut.addVehicle(mockVehicle));
		assertEquals(sut.getVehicles().size(), 1);
	}

}
