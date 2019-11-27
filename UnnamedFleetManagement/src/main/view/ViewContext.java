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

	public void showForm(FormView formView) {
		for(int i = 0; i < formView.size(); i++) {
			formView.show(i);
		}
		
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * }
	 */

}
