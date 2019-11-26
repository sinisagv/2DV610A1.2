package test.view;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import main.view.IView;
import main.view.ListMenuView;

class ListMenuViewTest {

	@Test
	void should_show_list_title() {
		String testString = "TestListMenu";
		IView SUT = new ListMenuView(testString);
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		SUT.show();
		String actual =  out.toString().split("\n")[0];
		assertEquals(testString, actual);
	}

}
