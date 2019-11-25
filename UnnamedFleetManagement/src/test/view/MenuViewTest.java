package test.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
		SUT.addOption("testOption", () -> {
			assertTrue(true);
		});
		SUT.executeOption(1);
		fail("Did not execute action");
	}

}
