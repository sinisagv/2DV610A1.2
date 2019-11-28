package test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

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
	}

	@Test
	void writeShouldReturnTrue() throws Exception {
		VehicleDBService sut = new VehicleDBService("src/test/service/testFile.xml");
		Vehicle v = new Vehicle();
		File db = new File("src/test/service/testFile.xml");
		Scanner sc = new Scanner(db);
		int lines = 0;
		while (sc.hasNextLine()) {
			sc.nextLine();
			lines++;
		}
		v.setCapacity(10);
		v.setCargoType(CargoType.PASSENGERS);
		v.setVolume(20);
		assertTrue(sut.write());
		assertTrue(lines >= 1);
		sc.close();
	}
	
	@Test
	void removeVehicleShouldReturnTrue() throws Exception {
		VehicleDBService sut = new VehicleDBService("src/test/service/testFileWithVehicles.xml");
		Vehicle v = new Vehicle();
		v.setCapacity(50);
		v.setVolume(1000);
		v.setCargoType(CargoType.CARGO);
		sut.addVehicle(v);
		assertTrue(sut.removeVehicle(v));
		assertEquals(0, sut.getFleet().size());
		assertFalse(sut.removeVehicle(v));
		
	}

}
