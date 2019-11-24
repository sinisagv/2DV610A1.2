package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.TimeFrame;

class TimeFrameTest {

	TimeFrame sut = new TimeFrame();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	TimeFrame testFrame;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void overlapsWithShouldReturnFalse() throws ParseException {

		sut.setStartDate(sdf.parse("18/12/2019"));
		sut.setEndDate(sdf.parse("23/12/2019"));
		testFrame = new TimeFrame((sdf.parse("24/12/2019")), sdf.parse("27/12/2109"));
		boolean actual = sut.overlapsWith(testFrame);

		assertFalse(actual);
	}

	@Test
	void overlapsWithShouldReturnTrue() throws ParseException {
		sut.setStartDate(sdf.parse("18/12/2019"));
		sut.setEndDate(sdf.parse("23/12/2019"));
		testFrame = new TimeFrame(sdf.parse("22/12/2019"), sdf.parse("28/12/2109"));
		boolean actual = sut.overlapsWith(testFrame);
		
		assertTrue(actual);
	}
	
}
