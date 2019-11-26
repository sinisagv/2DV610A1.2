package test.view;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.view.IView;
import main.view.ListMenuView;

class ListMenuViewTest {

	@Test
	void should_show_list_title() {
		String testString = "TestListMenu";
		IView SUT = new ListMenuView(testString, null);
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		SUT.show();
		String actual = out.toString().split("\n")[0];
		assertEquals(testString, actual);
	}

	@Test
	void should_show_list_of_items() {
		String expectedListContent = "ListContent";
		List<String> expectedList = new ArrayList<String>();

		for (int i = 0; i < 100; i++) {
			expectedList.add(expectedListContent);
		}

		IView SUT = new ListMenuView("TestMenu", expectedList);

		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		SUT.show();

		for (int i = 1; i < 101; i++) {
			String[] actual = out.toString().split("\n");
			assertEquals(expectedList.get(i), actual[i]);
		}

	}

}
