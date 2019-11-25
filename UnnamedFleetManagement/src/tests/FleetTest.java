package tests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Bus;
import model.Fleet;

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

}
