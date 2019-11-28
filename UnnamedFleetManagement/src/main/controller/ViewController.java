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
		while(true) {
		while (!input.hasNextInt()) {
			input.next();
			System.out.println("Please input an integer");
		}
		int selection = input.nextInt();
		try {
			return view.executeOption(selection);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Please input a valid option");
			continue;
		}
		}
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
