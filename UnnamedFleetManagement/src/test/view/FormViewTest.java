package test.view;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import main.view.FormView;

class FormViewTest {

	@Test
	void should_return_correct_size() {
		FormView SUT = new FormView();
		assertEquals(0, SUT.size());
		for (int i = 1; i < 10; i++) {
			SUT.addPrompt("testPrompt");
			assertEquals(i, SUT.size());
		}
	}

	@Test
	void should_displayPrompt() {
		FormView SUT = new FormView();
		OutputStream testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		SUT.addPrompt("test");
		SUT.addPrompt("test1");
		SUT.addPrompt("test2");
		assertEquals("test", testOut.toString().split("\n")[0]);
		assertEquals("test1", testOut.toString().split("\n")[1]);
		assertEquals("test2", testOut.toString().split("\n")[2]);
	}

}
