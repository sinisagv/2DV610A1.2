package test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import main.controller.AppMain;
import main.service.DBServiceFactory;
import main.view.ViewContext;

class AppMainTest {

	@Test
	void launch_IOExceptionFromDBFactory_shouldAlertUser() {
		// set up output stream that we can monitor
		ByteArrayOutputStream testByteStream = new ByteArrayOutputStream();
		System.setErr(new PrintStream(testByteStream));

		// set up mock DBServiceFactory
		DBServiceFactory mockDBFac = mock(DBServiceFactory.class);
		try {
			doThrow(new IOException()).when(mockDBFac).getVehicleDBService(any());
		} catch (ParserConfigurationException | SAXException | IOException e) {
		}
		
		// set up SUT
		AppMain SUT = new AppMain(mock(ViewContext.class), mockDBFac);
		SUT.launch();
		
		String expected = "Unable to connect to database. Please contact your SysAdmin";
		
		// get actual
		String actual = testByteStream.toString();
		
		// assert actual = expected
		assertEquals(expected, actual);

	}

}
