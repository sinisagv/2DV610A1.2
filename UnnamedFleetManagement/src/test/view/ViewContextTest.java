package test.view;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.view.IView;
import main.view.ViewContext;

class ViewContextTest {

	@Test
	void start_should_show_first_view() {
		IView mockedIView = mock(IView.class);
		ViewContext SUT = new ViewContext(mockedIView, null);
		SUT.start();
		verify(mockedIView, atLeastOnce()).show();
	}
	
	@Test
	void should_change_views_on_input() {
		IView mockedIView = mock(IView.class);
		IView testView = mock(IView.class);
		
		Scanner sc = new Scanner("1"); // scanner that returns 1
		
		ViewContext SUT = new ViewContext(mockedIView, sc);
		mockedIView.addOption("testOption", () -> {
			SUT.switchView(testView);
		});
		verify(testView, times(1)).show(); // checks that show() is called on the first option of menu 1
		
	}

}
