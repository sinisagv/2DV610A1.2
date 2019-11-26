package main.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewContext {

	private Scanner input;

	public ViewContext(Scanner input) {
		this.input = input;
	}

	public void showView(IView view) { // we only want to throw Illegal Argument Exception so the controller can handle
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
		view.executeOption(selection);
	}

	/*
	 * public static void main(String[] args) { MenuView menu = new
	 * MenuView("Testmenu"); ViewContext vc = new ViewContext(menu, new
	 * Scanner(System.in));
	 * 
	 * menu.addOption("option 1", () -> vc.switchView(new MenuView("Option 1")));
	 * vc.start(); }
	 */
}
