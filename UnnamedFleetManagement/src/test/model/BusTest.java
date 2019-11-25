package test.model;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Bus;
import main.model.TimeFrame;

class BusTest {
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		when(mockedTF.overlapsWith(new TimeFrame(sdf.parse("17/11/2019"), sdf.parse("22/11/2019")))).thenReturn(false)
				.thenReturn(true);
		try {
			assertTrue(sut.addUnvailability(new TimeFrame(sdf.parse("17/11/2019"), sdf.parse("22/11/2019"))));
			assertFalse(sut.addUnvailability(new TimeFrame(sdf.parse("17/11/2019"), sdf.parse("22/11/2019"))));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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