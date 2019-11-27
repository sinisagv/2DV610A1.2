package main.view;

import java.util.InputMismatchException;
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
		while (!input.hasNextInt())
			// TODO add class for printing user errors
			input.next();
		selection = input.nextInt();
		return view.executeOption(selection);
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * }
	 */

}
