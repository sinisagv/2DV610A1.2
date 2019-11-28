package main.view;

public interface IView {
	
	// every view will have a display and some options
	
	public void addOption(String optionName, Runnable action); // adds options to the view
	public void show();	// displays the view
	public Runnable executeOption(int selection); // returns the object that executes the option
	public int menuLength();
	
}
