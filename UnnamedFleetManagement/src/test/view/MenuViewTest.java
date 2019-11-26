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
		String actual =  out.toString().split("\n")[0];
		assertEquals(testString, actual);
	}

	@Test
	void should_execute_action() {
		IView SUT = new MenuView("test");
		Runnable mockRunnable = mock(Runnable.class);
		SUT.addOption("testOption", mockRunnable);
		SUT.executeOption(1);
		verify(mockRunnable).run();
	}

	@Test
	void menuLength_should_return_number_of_options() {
		IView SUT = new MenuView("test");
		assertEquals(0, SUT.menuLength());
		SUT.addOption("testOption", () -> {
		});
		assertEquals("Size should be 1", 1, SUT.menuLength());
		for (int i = 0; i < 1000; i++) {
			SUT.addOption("testOption" + i, () -> {
			});
		}
		assertEquals("Size should be 1001", 1001, SUT.menuLength());
	}

	@Test
	void show_should_display_all_options() {
		String expectedOptionName = "TestOption";
		IView SUT = new MenuView("TestMenu");
		SUT.addOption(expectedOptionName, () -> {
		});
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		SUT.show();
		for (int i = 0; i < SUT.menuLength(); i++) {
			String actual = out.toString().split("\n")[i+1];
			assertEquals(((i+1) + ". " + expectedOptionName), actual);
		}
	}
}
