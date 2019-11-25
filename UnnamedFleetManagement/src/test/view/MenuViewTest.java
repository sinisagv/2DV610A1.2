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
		IView SUT = new MenuView("TestMenu");
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		SUT.show();
		assertEquals( "TestMenu\n", out.toString());
	}

}
