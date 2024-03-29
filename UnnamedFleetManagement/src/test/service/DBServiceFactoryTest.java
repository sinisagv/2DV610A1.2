package test.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import main.service.DBServiceFactory;

class DBServiceFactoryTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void getVehicleDBServiceShouldReturnNotNull() throws ParserConfigurationException, SAXException, IOException {
		DBServiceFactory sut = new DBServiceFactory();

		assertNotNull(sut.getVehicleDBService("src/test/service/testFile.xml"));

		assertThrows(IOException.class, () -> {
			sut.getVehicleDBService("fsef352/532");
		});
	}

}
