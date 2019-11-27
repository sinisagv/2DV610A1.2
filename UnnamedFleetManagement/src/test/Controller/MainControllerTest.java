package test.Controller;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.Controller.MainController;
import main.view.IView;
import main.view.ViewContext;

class MainControllerTest {

	@Test
	void should_call_ViewContext_showMenu() {
		Runnable mockRunnable = mock(Runnable.class);
		ViewContext mockVC = mock(ViewContext.class);
		Scanner sc = new Scanner("1");
		when(mockVC.showView(mock(IView.class))).thenReturn(mockRunnable);
		MainController SUT = new MainController(sc);
		SUT.launch();
		verify(mockRunnable).run();
	}

}
