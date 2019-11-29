package test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.CargoType;
import main.model.Vehicle;
import main.service.VehicleDBService;

class VehicleDBServiceTest {

	@BeforeEach
	void setUp() throws Exception {
		BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/test/service/testFile.xml"));
		writer.write("");
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + "<root></root>");
		VehicleDBService sut = new VehicleDBService("src/test/service/testFileWithVehicles.xml");
		Vehicle v = new Vehicle();
		v.setCapacity(new Random().nextInt(250) + 1);
		v.setVolume(new Random().nextInt(2000) + 1);
		v.setCargoType(CargoType.PASSENGERS);
		sut.addVehicle(v);
		writer.flush();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void addVehicleShouldReturnTrue() throws Exception {
		VehicleDBService sut = new VehicleDBService("src/test/service/testFile.xml");
		Vehicle v = new Vehicle();
		v.setCapacity(10);
		v.setCargoType(CargoType.PASSENGERS);
		v.setVolume(20);
		assertTrue(sut.addVehicle(v));
		assertEquals(sut.getFleet().size(), 1);
	}

	@Test
	void writeShouldReturnTrue() throws Exception {

		VehicleDBService sut = new VehicleDBService("src/test/service/testFile.xml");

		Vehicle v = new Vehicle();
		v.setCapacity(10);
		v.setCargoType(CargoType.PASSENGERS);
		v.setVolume(20);
		assertTrue(sut.write());
		
//		assertThrows(FileNotFoundException.class, () -> {
//			String path = "fbdsnkj";
//			VehicleDBService sut1 = new VehicleDBService(path);
//		});
	}

	@Test
	void removeVehicleShouldReturnTrue() throws Exception {
		VehicleDBService sut = new VehicleDBService("src/test/service/testFileWithVehicles.xml");
		Vehicle v = new Vehicle();
		v.setCapacity(50);
		v.setVolume(1000);
		v.setCargoType(CargoType.CARGO);
		sut.addVehicle(v);
		Vehicle v1 = new Vehicle();
		v1.setCapacity(150);
		v1.setVolume(2000);
		v1.setCargoType(CargoType.PASSENGERS);
		sut.addVehicle(v);
		sut.addVehicle(v1);
		assertTrue(sut.removeVehicle(v));
		assertFalse(sut.removeVehicle(v));
		assertTrue(sut.removeVehicle(v1));
		VehicleDBService sut1 = new VehicleDBService("src/test/service/testFile.xml");
		Vehicle v2 = new Vehicle();
		v2.setCapacity(10);
		v2.setCargoType(CargoType.PASSENGERS);
		v2.setVolume(200);
		assertFalse(sut1.removeVehicle(v2));
	}

}
