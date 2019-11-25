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
		view.executeOption(selection);
	}
	
	public void switchView(IView newView) {
		this.view = newView;
		start();
	}
}
