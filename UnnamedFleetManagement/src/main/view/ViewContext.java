package main.view;

import java.util.List;
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
		while (!input.hasNextInt())
			// TODO add class for printing user errors
			input.next();
		int selection = input.nextInt();
		return view.executeOption(selection);
	}

	public List<String> showForm(FormView formView) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * }
	 */

}
