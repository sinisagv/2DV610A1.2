package test.view;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.view.FormView;

class FormViewTest {

	@Test
	void should_return_correct_size() {
		FormView SUT = new FormView();
		assertEquals(0, SUT.size());
		for(int i = 1; i < 10; i++) {
			SUT.addPrompt("testPrompt");
			assertEquals(i, SUT.size());
		}
	}

}
