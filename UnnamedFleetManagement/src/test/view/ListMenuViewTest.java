package test.view;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import main.view.IView;
import main.view.ListMenuView;

class ListMenuViewTest {

	@Test
	void should_show_list_title() {
		String testString = "TestListMenu";
		IView SUT = new ListMenuView(testString, new ArrayList<String>());
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		SUT.show();
		String actual = out.toString().split("\n")[0];
		assertEquals(testString, actual);
	}

	@Test
	void should_show_list_items() {
		String testString = "TestListOptions";
		ArrayList<String> testArrayList = new ArrayList<String>();
		for (int i = 1; i < 100; i++) {
			testArrayList.add(testString + i);
		}
		IView SUT = new ListMenuView(testString, testArrayList);
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		SUT.show();
		String[] actual = out.toString().split("\n");
		assertEquals(testString, actual[0]);
		for (int i = 1; i < 100; i++) {
			assertEquals(testString + i, actual[i]);
		}

	}

}