package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Booking;
import main.model.Driver;
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
	
	@Test
	void removeVehicleShouldReturnTrueWhenVehicleIsRemoved() {
		Booking sut = new Booking();
		Vehicle mockVehicle = mock(Vehicle.class);
		sut.addVehicle(mockVehicle);
		assertTrue(sut.removeVehicle(mockVehicle));
		assertFalse(sut.removeVehicle(mockVehicle));
	}
	
	@Test
	void addDriverShouldReturnTrueWhenDriverIsAdded() {
		Booking sut = new Booking();
		Driver mockDriver = mock(Driver.class);
		when(mockDriver.equals(mockDriver)).thenReturn(true);
		assertTrue(sut.addDriver(mockDriver));
		assertFalse(sut.addDriver(mockDriver));
		assertEquals(sut.getDrivers().size(), 1);
	}
	
	@Test
	void removeDriverShouldReturnTrue() {
		Booking sut = new Booking();
		Driver mockDriver = mock(Driver.class);
		sut.addDriver(mockDriver);
		assertTrue(sut.removeDriver(mockDriver));
		assertFalse(sut.removeDriver(mockDriver));
	}

}
