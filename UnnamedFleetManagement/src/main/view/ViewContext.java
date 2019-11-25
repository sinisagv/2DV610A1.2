package main.view;

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
		int selection = input.nextInt();
		if(!view.executeOption(selection)) {
			throw new IllegalArgumentException("Input Invalid");
		}
	}
	
	public void switchView(IView newView) {
		this.view = newView;
		start();
	}
}
