package test.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.model.Bus;
import main.model.Fleet;
import main.model.Vehicle;


class FleetTest {
	
	Fleet sut = new Fleet();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void shouldReturnTrueWhenAddingVehicle() {
		assertTrue(sut.addVehicle(new Bus()));
	}
	
	@Test
	void shouldReturnTrueWhenRemovingExistingVehicle() {
		Vehicle b = new Bus();
		sut.addVehicle(b);
		assertTrue(sut.removeVehicle(b));
		assertFalse(sut.removeVehicle(new Bus()));
	}

}
