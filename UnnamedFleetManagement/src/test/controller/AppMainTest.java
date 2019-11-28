package test.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import main.controller.AppMain;
import main.service.DBServiceFactory;
import main.view.ViewContext;

class AppMainTest {

	@Test
	void launch_badDBFilePath_shouldThrowIOException() {
		DBServiceFactory mockServFac = mock(DBServiceFactory.class);
		try {
			when(mockServFac.getVehicleDBService(any())).thenThrow(IOException.class);
		} catch (Exception e) {
			
		} 
		
		AppMain SUT = new AppMain(mock(ViewContext.class), mockServFac);
		assertThrows(IOException.class, () -> SUT.launch());
		
	}
	
}
