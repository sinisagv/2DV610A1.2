package test.view;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.view.IView;
import main.view.ViewContext;

class ViewContextTest {

	@Test
	void start_should_show_first_view() {
		IView mockedIView = mock(IView.class);
		when(mockedIView.executeOption(1)).thenReturn(true);
		ViewContext SUT = new ViewContext(mockedIView, new Scanner("1"));
		SUT.start();
		verify(mockedIView, atLeastOnce()).show();
	}

	@Test
	void should_switch_views() {
		IView mockedIView = mock(IView.class);
		IView testView = mock(IView.class);
		when(mockedIView.executeOption(1)).thenReturn(true);
		when(testView.executeOption(1)).thenReturn(true);

		ViewContext SUT = new ViewContext(mockedIView, new Scanner("1"));
		SUT.switchView(testView);
		verify(testView, times(1)).show(); // checks that show() is called on the first option of menu 1

	}

	@Test
	void should_call_execute_user_selection() { // should pass if it reads user input from scanner (in this case it will
												// always be 1 and call executeOption with that input)
		IView mockedIView = mock(IView.class);
		when(mockedIView.executeOption(1)).thenReturn(true);
		
		Scanner sc = new Scanner("1");

		ViewContext SUT = new ViewContext(mockedIView, sc);
		SUT.start();
		verify(mockedIView, times(1)).executeOption(1);
	}

	@Test
	void should_throw_exception_on_bad_input() {
		IView mockedIView = mock(IView.class);
		when(mockedIView.executeOption(-1)).thenReturn(false); // mocked IView will check if the input is in range (i.e.
																// return false)

		Scanner sc = new Scanner("-1");
		ViewContext SUT = new ViewContext(mockedIView, sc);
		assertThrows(IllegalArgumentException.class, () -> SUT.start());
	}

}
