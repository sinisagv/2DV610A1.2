package main.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewContext {

	private Scanner input;

	public ViewContext(Scanner input) {
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

	public static void main(String[] args) {
		ViewContext vc = new ViewContext(new Scanner(System.in));
		MenuView menu = new MenuView("TestMenu");
		menu.addOption("dont press this", () -> System.exit(0));
		vc.showView(menu);
	}

}
