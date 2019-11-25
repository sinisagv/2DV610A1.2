package test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Driver;
import main.model.Qualification;
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
		assertTrue(sut.addShift(new TimeFrameStub(sdf.parse("20/11/2019 08:00"), sdf.parse("20/11/2019 17:00"))));
	}
	
	@Test
	void removeShiftShouldReturnTrue() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");
		TimeFrame tfs = new TimeFrame(sdf.parse("20/11/2019 08:00"), sdf.parse("20/11/2019 17:00"));
		sut.addShift(new TimeFrameStub(sdf.parse("20/11/2019 08:00"), sdf.parse("20/11/2019 17:00")));
		assertTrue(sut.removeShift(tfs));
		int expectedSize = 0;
		assertEquals(sut.getSchedule().size(), expectedSize);
	}
	
	@Test
	void addQualificationShouldReturnTrue() {
		assertTrue(sut.addQualification(Qualification.C));
		assertFalse(sut.addQualification(Qualification.C));
		assertTrue(sut.addQualification(Qualification.D));
		int expectedSize = 2;
		assertEquals(sut.getQualifications().size(), expectedSize);
	}
	
	@Test
	void removeQualificationsShouldReturnTrue() {
		sut.addQualification(Qualification.C);
		sut.addQualification(Qualification.D);
		assertTrue(sut.removeQualifivation(Qualification.D));
		assertFalse(sut.removeQualifivation(Qualification.D));
		assertFalse(sut.removeQualifivation(Qualification.C1));
		int expectedSize = 1;
		assertEquals(sut.getQualifications().size(), expectedSize);
	}

}

