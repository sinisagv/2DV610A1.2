package test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Driver;
import main.model.Qualification;
import main.model.TimeFrame;

class DriverTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void addShiftShouldReturnTrueWhenNewShiftIsAdded() throws ParseException {
		Driver sut = new Driver();
		TimeFrame mockTF = mock(TimeFrame.class);
		TimeFrame testTF = mock(TimeFrame.class);
		when(mockTF.overlapsWith(testTF)).thenReturn(true);
		assertTrue(sut.addShift(mockTF));
		assertFalse(sut.addShift(testTF));
	}

	@Test
	void removeShiftShouldReturnTrue() throws ParseException {
		Driver sut = new Driver();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");
		TimeFrame tfs = new TimeFrame(sdf.parse("20/11/2019 08:00"), sdf.parse("20/11/2019 17:00"));
		sut.addShift(new TimeFrame(sdf.parse("20/11/2019 08:00"), sdf.parse("20/11/2019 17:00")));
		assertTrue(sut.removeShift(tfs));
		int expectedSize = 0;
		assertEquals(sut.getSchedule().size(), expectedSize);
		assertFalse(sut.removeShift(tfs));
	}

	@Test
	void addQualificationShouldReturnTrue() {
		Driver sut = new Driver();
		assertTrue(sut.addQualification(Qualification.C));
		assertFalse(sut.addQualification(Qualification.C));
		assertTrue(sut.addQualification(Qualification.D));
		int expectedSize = 2;
		assertEquals(sut.getQualifications().size(), expectedSize);
	}

	@Test
	void removeQualificationsShouldReturnTrue() {
		Driver sut = new Driver();
		sut.addQualification(Qualification.C);
		sut.addQualification(Qualification.D);
		assertTrue(sut.removeQualifivation(Qualification.D));
		assertFalse(sut.removeQualifivation(Qualification.D));
		assertFalse(sut.removeQualifivation(Qualification.C1));
		int expectedSize = 1;
		assertEquals(sut.getQualifications().size(), expectedSize);
	}

	@Test
	void isAvailableShouldReturnTrue() throws ParseException {
		Driver sut = new Driver();
		TimeFrame mockedTF = mock(TimeFrame.class);
		TimeFrame testFrame = mock(TimeFrame.class);
		sut.addShift(mockedTF);
		when(mockedTF.overlapsWith(testFrame)).thenReturn(false).thenReturn(true);
		assertEquals(sut.getSchedule().size(), 1);
		assertTrue(sut.isAvailable(testFrame));
		assertFalse(sut.isAvailable(testFrame));

	}
	
	@Test
	void equalsShouldReturnTrueIfIDsAreEqual() {
		Driver sut = new Driver();
		Driver testDriver = new Driver();
		sut.setID("1");
		testDriver.setID("1");
		assertTrue(sut.equals(testDriver));
	}

}
