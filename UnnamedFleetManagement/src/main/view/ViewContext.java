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
		
	}*/

}
