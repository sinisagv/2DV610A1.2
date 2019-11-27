package test.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.view.FormView;
import main.view.IView;
import main.view.ViewContext;

class ViewContextTest {

	@Test
	void start_should_show_first_view() {
		IView mockedIView = mock(IView.class);
		when(mockedIView.menuLength()).thenReturn(1);
		when(mockedIView.executeOption(1)).thenReturn(() -> {
		});
		ViewContext SUT = new ViewContext(new Scanner("1"));
		SUT.showView(mockedIView);
		verify(mockedIView).show();
	}

	@Test
	void should_switch_views() {
		IView mockedIView = mock(IView.class);
		IView testView = mock(IView.class);
		when(mockedIView.menuLength()).thenReturn(1);
		when(testView.menuLength()).thenReturn(1);
		when(mockedIView.executeOption(1)).thenReturn(() -> {
		});
		when(testView.executeOption(1)).thenReturn(() -> {
		});

		ViewContext SUT = new ViewContext(new Scanner("1"));
		SUT.showView(testView);
		verify(testView, times(1)).show(); // checks that show() is called on the first option of menu 1

	}

	@Test
	void should_call_execute_user_selection() { // should pass if it reads user input from scanner (in this case it will
												// always be 1 and call executeOption with that input)
		IView mockedIView = mock(IView.class);
		when(mockedIView.menuLength()).thenReturn(1);
		when(mockedIView.executeOption(1)).thenReturn(() -> {
		});

		Scanner sc = new Scanner("1");

		ViewContext SUT = new ViewContext(sc);
		SUT.showView(mockedIView);
		verify(mockedIView, times(1)).executeOption(1);
	}

	// Changed input to check if inputstream has int as the next token. no longer
	// throws exceptions
	/*
	 * @Test void should_throw_exception_on_bad_input() { IView mockedIView =
	 * mock(IView.class); when(mockedIView.menuLength()).thenReturn(1); // returns
	 * value of 1 for size when(mockedIView.executeOption(1)).thenReturn(() -> { });
	 * 
	 * Scanner sc = new Scanner("-1"); ViewContext SUT = new ViewContext(sc);
	 * assertThrows(IllegalArgumentException.class, () ->
	 * SUT.showView(mockedIView)); }
	 */

	@Test
	void should_catch_input_mismatch_exception() {
		IView mockedIView = mock(IView.class);
		when(mockedIView.executeOption(1)).thenReturn(() -> {
		});
		Scanner sc = new Scanner("n\n1");
		ViewContext SUT = new ViewContext(sc);
		try {
			// removed this assert since ViewContext.showView() can no longer throw exceptions
			//assertThrows(IllegalArgumentException.class, () -> SUT.showView(mockedIView));
			SUT.showView(mockedIView);
		} catch (InputMismatchException e) {
			fail("Unhandled InputMismatchException");
		}
	}
	
	@Test
	void should_show_form_view() {
		FormView mockedFormView = mock(FormView.class);
		when(mockedFormView.size()).thenReturn(3);
		ViewContext SUT = new ViewContext(new Scanner("test\ntest\ntest\n"));
		SUT.showForm(mockedFormView);
		verify(mockedFormView).show(0);
		verify(mockedFormView).show(1);
		verify(mockedFormView).show(2);
	}
	
	@Test
	void should_get_form_inputs() {
		FormView mockedFormView = mock(FormView.class);
		when(mockedFormView.size()).thenReturn(3);
		ViewContext SUT = new ViewContext(new Scanner("test0\ntest1\ntest2\n"));
		List<String> actual = SUT.showForm(mockedFormView);
		for(int i = 0; i < actual.size(); i++) {
			assertEquals("test" + i, actual.get(i));
		}
	}
	

}
