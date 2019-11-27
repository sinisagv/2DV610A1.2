package test.model;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Bus;
import main.model.TimeFrame;

class VehicleTest {
	Bus sut = new Bus();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void addAunavailabiltyShouldReturnTrue() throws ParseException {
		TimeFrame mockedTF = mock(TimeFrame.class);
		TimeFrame testTF = mock(TimeFrame.class);
		when(mockedTF.overlapsWith(testTF)).thenReturn(true);

		assertTrue(sut.addUnvailability(mockedTF));
		assertFalse(sut.addUnvailability(testTF));
	}

	@Test
	void isAvailableShouldReturnTrue() throws ParseException {
		TimeFrame mockedTF = mock(TimeFrame.class);
		TimeFrame testTF = mock(TimeFrame.class);
		sut.addUnvailability(mockedTF);
		when(mockedTF.overlapsWith(testTF)).thenReturn(false).thenReturn(true);
		assertTrue(sut.isAvailable(testTF));
		assertFalse(sut.isAvailable(testTF));
	}

}