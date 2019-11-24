package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Bus;
import model.TimeFrame;

class BusTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void addAunavailabiltyShouldReturnTrue(Bus sut) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		try {
			assertTrue(sut.addUnvailability(new TimeFrame(sdf.parse("17/11/2019"), sdf.parse("22/11/2019"))));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
