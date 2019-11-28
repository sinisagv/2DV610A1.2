package test.controller;

import static org.mockito.Mockito.mock;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import main.service.VehicleDBService;
import main.view.ViewContext;

class AppMainTest {

	@Test
	void launch_badDBFilePath_shouldPropmtandQuit() {
		VehicleDBService mockServ = mock(VehicleDBService.class);
		DBServiceFactory mockServFac = mock(VehicleDBServiceFactory.class);
		when(mockServFac.getVehicleDBService(WRONG_FILE_PATH)).thenThrow(IOException.class);
		
		AppMain SUT = new AppMain(mock(ViewContext.class), mockServ);
		
	}
	
}
