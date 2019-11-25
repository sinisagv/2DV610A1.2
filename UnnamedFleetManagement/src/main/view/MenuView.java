package main.view;

public class MenuView implements IView {
	
	private String menuTitle;
	
	public MenuView(String menuTitle) {
		this.menuTitle = menuTitle;
	}
	
	@Override
	public void addOption(String optionName, Runnable action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		System.out.println(menuTitle);
	}

	@Override
	public boolean executeOption(int selection) {
		// TODO Auto-generated method stub
		return false;
	}

}
