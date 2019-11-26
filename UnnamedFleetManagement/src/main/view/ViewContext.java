package main.view;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ViewContext {

	private Scanner input;

	public ViewContext(Scanner input) {
		this.input = input;
	}

	public Runnable showView(IView view) { // we only want to throw Illegal Argument Exception so the controller can
											// handle
		// it
		view.show();
		int selection = -1;
		try {
			selection = input.nextInt();
		} catch (InputMismatchException e) {
			selection = -1;
		}
		if (selection < 1 || selection > view.menuLength()) {
			throw new IllegalArgumentException("Invalid Input");
		}
		return view.executeOption(selection);
	}

/*	public static void main(String[] args) {
		try {
			IView mockedView = new MenuView("Test1");
			IView mockedView2 = new MenuView("Test2");
			int testno = 1000000000;
			byte[] test = new byte[testno];
			for (int i = 0; i < testno; i++) {
				if (i % 2 == 0)
					test[i] = '1';
				else
					test[i] = '\r';
			}
			InputStream teststream = new ByteArrayInputStream(test);

			System.setIn(teststream);
			Scanner sc = new Scanner(System.in);
			ViewContext SUT = new ViewContext(sc);

			mockedView.addOption("test one", () -> SUT.showView(mockedView2));
			mockedView2.addOption("test two", () -> SUT.showView(mockedView));

			int i = 0;
			while (true) {
				SUT.showView(mockedView).run();
				System.out.println(i++);
			}
		} catch (NoSuchElementException e) {
			assertTrue(true);
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}*/

}
