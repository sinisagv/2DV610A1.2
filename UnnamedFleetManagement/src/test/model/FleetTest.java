package test.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.model.Bus;
import main.model.Fleet;
import main.model.Lorry;
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
	void shouldReturnTrueWhenRemovingExistingVehicleOrFalseWhenVehicleDoesntExist() {
		Vehicle b = new Bus();
		sut.addVehicle(b);
		assertTrue(sut.removeVehicle(b));
		assertFalse(sut.removeVehicle(new Bus()));
	}
	
	@Test
	void shouldReturnTrueWhenVehicleIsEdited() {
		Vehicle bus = new Bus();
		bus.setID("1");
		bus.setCapacity(50);
		bus.setVolume(2000);
		sut.addVehicle(bus);
		Vehicle lorry = new Lorry();
		lorry.setID("2");
		sut.addVehicle(lorry);
		bus.setCapacity(60);
		assertTrue(sut.editVehicle(bus));
		assertFalse(sut.editVehicle(new Lorry()));
	}

}
