package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Bus;
import model.TimeFrame;

class BusTest {
	Bus sut = new Bus();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void addAunavailabiltyShouldReturnTrue() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		try {
			assertTrue(sut.addUnvailability(new TimeFrame(sdf.parse("17/11/2019"), sdf.parse("22/11/2019"))));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void isAvailableShouldReturnTrue() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		assertTrue(sut.isAvailable(new TimeFrameStub(sdf.parse("23/12/2019"), sdf.parse("24/01/2019"))));
	}

}
class TimeFrameStub extends TimeFrame{
	public TimeFrameStub(Date d1, Date d2) {
		this.setStartDate(d1);
		this.setEndDate(d2);
	}

	@Override
	public boolean overlapsWith(TimeFrame frame) {
		return false;
	}
}