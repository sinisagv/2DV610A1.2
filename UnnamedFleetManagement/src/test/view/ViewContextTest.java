package test.view;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.view.IView;
import main.view.MenuView;
import main.view.ViewContext;

class ViewContextTest {

	@Test
	void start_should_show_first_view() {
		IView mockedIView = mock(IView.class);
		when(mockedIView.menuLength()).thenReturn(1);
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

		ViewContext SUT = new ViewContext(new Scanner("1"));
		SUT.showView(testView);
		verify(testView, times(1)).show(); // checks that show() is called on the first option of menu 1

	}

	@Test
	void should_call_execute_user_selection() { // should pass if it reads user input from scanner (in this case it will
												// always be 1 and call executeOption with that input)
		IView mockedIView = mock(IView.class);
		when(mockedIView.menuLength()).thenReturn(1);

		Scanner sc = new Scanner("1");

		ViewContext SUT = new ViewContext( sc);
		SUT.showView(mockedIView);
		verify(mockedIView, times(1)).executeOption(1);
	}

	@Test
	void should_throw_exception_on_bad_input() {
		IView mockedIView = mock(IView.class);
		when(mockedIView.menuLength()).thenReturn(1); // returns value of 1 for size

		Scanner sc = new Scanner("-1");
		ViewContext SUT = new ViewContext( sc);
		assertThrows(IllegalArgumentException.class, () -> SUT.showView(mockedIView));
	}

	@Test
	void should_catch_input_mismatch_exception() {
		IView mockedIView = mock(IView.class);
		Scanner sc = new Scanner("n\n1");
		ViewContext SUT = new ViewContext(sc);
		try {
			assertThrows(IllegalArgumentException.class, () -> SUT.showView(mockedIView));
		} catch (InputMismatchException e) {
			fail("Unhandled InputMismatchException");
		}
	}

	
}
