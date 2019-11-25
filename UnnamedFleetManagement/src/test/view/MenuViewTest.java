package test.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import main.view.IView;
import main.view.MenuView;

class MenuViewTest {

	@Test
	void should_show_menuTitle() { 
		String testString = "TestMenu";
		IView SUT = new MenuView(testString);
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		SUT.show();
		assertEquals(testString, out.toString().split("\r")[0]);
	}
	
	@Test
	void should_execute_action() {
		IView SUT = new MenuView("test");
		Runnable mockRunnable = mock(Runnable.class);
		SUT.addOption("testOption", mockRunnable);
		SUT.executeOption(1);
		verify(mockRunnable).run();
	}
	// TODO check SUT.optionSize();

}
