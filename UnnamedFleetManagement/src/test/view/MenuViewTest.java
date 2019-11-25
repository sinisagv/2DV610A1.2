package test.view;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import main.view.IView;
import main.view.MenuView;

class MenuViewTest {

	@Test
	void should_show() {
		String testString = "TestMenu";
		IView SUT = new MenuView(testString);
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		SUT.show();
		assertEquals(testString + "\r\n", out.toString());
	}

}
