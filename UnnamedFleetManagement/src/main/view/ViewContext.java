package main.view;

public class ViewContext {

	private IView view;

	public ViewContext(IView primaryView) {
		this.view = primaryView;
	}

	public void start() {
		view.show();
	}

}
