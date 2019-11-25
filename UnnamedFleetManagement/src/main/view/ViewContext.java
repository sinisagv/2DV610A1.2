package main.view;

import java.util.Scanner;

public class ViewContext {

	private IView view;

	public ViewContext(IView primaryView, Scanner input) {
		this.view = primaryView;
	}

	public void start() {
		view.show();
	}
	
	public void switchView(IView newView) {
		
	}
}
