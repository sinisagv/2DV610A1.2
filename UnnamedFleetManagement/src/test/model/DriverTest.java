package test.model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Driver;
import main.model.TimeFrame;

class DriverTest {
	
	Driver sut = new Driver();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void addShiftShouldReturnTrueWhenNewShiftIsAdded() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");
		assertTrue(sut.addShift(new TimeFrame(sdf.parse("20/11/2019 08:00"), sdf.parse("20/11/2019 17:00"))));
	}

}
