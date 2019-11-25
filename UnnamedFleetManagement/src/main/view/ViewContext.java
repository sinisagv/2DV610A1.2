package main.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewContext {

	private IView view;
	private Scanner input;

	public ViewContext(IView primaryView, Scanner input) {
		this.view = primaryView;
		this.input = input;
	}

	public void start() {
		view.show();
		int selection = -1;
			try {
				selection = input.nextInt();
			} catch (InputMismatchException e) {
				
			}
		if (selection < 1 || selection > view.optionSize())
			throw new IllegalArgumentException("Invalid Input");
		view.executeOption(selection);
	}

	public void switchView(IView newView) {
		this.view = newView;
		start();
	}
}
