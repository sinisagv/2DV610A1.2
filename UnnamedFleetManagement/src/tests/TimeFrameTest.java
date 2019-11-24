package tests;

import static org.junit.Assert.assertFalse;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.TimeFrame;

class TimeFrameTest {

	TimeFrame sut = new TimeFrame();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

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

		assertFalse(sut.overlapsWith(new TimeFrame(sdf.parse("24/12/2019"), sdf.parse("27/12/2109"))));
	}

}
