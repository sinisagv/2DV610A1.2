package main.view;

public interface IView {
	
	// every view will have a display and some options
	// this is an implementation of the state pattern where the state context is called View Context
	
	public void addOption(String optionName, Runnable action); // adds options to the view
	public void show();	// displays the view
	public void executeOption(int selection); // executes the option
	public int menuLength();
	
}
