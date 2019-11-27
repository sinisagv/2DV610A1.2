package main.view;

import java.util.List;
import java.util.Scanner;

public class ViewContext {

	private Scanner input;

	public ViewContext(Scanner input) {
		this.input = input;
	}

	public Runnable showView(IView view) { 
		view.show();
		while (!input.hasNextInt())
			// TODO add class for printing user errors
			input.next();
		int selection = input.nextInt();
		return view.executeOption(selection);
	}

	public List<String> showForm(FormView formView) {
		for(int i = 0; i < formView.size(); i++) {
			formView.show(i);
		}
		return null;
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * }
	 */

}
