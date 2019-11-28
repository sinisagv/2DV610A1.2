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
	void getVehicleDBServiceShouldReturnNotNull() {
		DBServiceFactory sut = new DBServiceFactory();
		try {
			assertNotNull(sut.getVehicleDBService("src/test/service/testFile.xml"));
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThrows(IOException.class, () -> {
			sut.getVehicleDBService("fsef352/532");
		});
	}

}
