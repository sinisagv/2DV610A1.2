package test.view;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import main.view.IView;
import main.view.ViewContext;

class ViewContextTest {

	@Test
	void start_should_show_first_view() {
		IView mockedIView = mock(IView.class);
		ViewContext SUT = new ViewContext(mockedIView);
		SUT.start();
		verify(mockedIView, atLeastOnce()).show();
		
	}

}
