package main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.view.FormView;
import main.view.IView;

public class ViewController {

	private Scanner input;

	public ViewController(Scanner input) {
		this.input = input;
	}

	public Runnable showView(IView view) {
		view.show();
		while (!input.hasNextInt()) {
			input.next();
		}
		int selection = input.nextInt();
		return view.executeOption(selection);
	}

	public List<String> showForm(FormView formView) {
		ArrayList<String> out = new ArrayList<String>();
		for (int i = 0; i < formView.size(); i++) {
			formView.show(i);
			out.add(input.nextLine());
		}
		return out;
	}

}
