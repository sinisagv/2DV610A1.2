package test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import main.controller.AppMain;
import main.controller.ViewController;
import main.service.DBServiceFactory;
import main.service.VehicleDBService;

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
		AppMain SUT = new AppMain(mock(ViewController.class), mockDBFac);
		SUT.launch();
		
		// set expected result
		String expected = "Unable to connect to database. Please contact your SysAdmin";
		
		// get actual result
		String actual = testByteStream.toString();
		
		// assert actual = expected
		assertEquals(expected, actual);
	}
	
	@Test
	void launch_DBFactoryThrowsNoExceptions_shouldShowMainMenu() {
		// set up output stream to monitor
		ByteArrayOutputStream testByteStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testByteStream));
		
		// set up mock DBFactory
		DBServiceFactory mockDBFactory = mock(DBServiceFactory.class);
		try {
			when(mockDBFactory.getVehicleDBService(any())).thenReturn(mock(VehicleDBService.class));
		} catch (ParserConfigurationException | SAXException | IOException e) {
		}
		
		// set up SUT
		AppMain SUT = new AppMain(mock(ViewController.class), mockDBFactory);
		SUT.launch();
		
		// get actual
		String actual = testByteStream.toString();
		
		assertNotEquals("", actual);
		
	}

}
