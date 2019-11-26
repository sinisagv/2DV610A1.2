package main.view;

public class ListMenuView implements IView {

	private String listTitle;

	public ListMenuView(String menuName) {
		this.listTitle = menuName;
	}

	@Override
	public void addOption(String optionName, Runnable action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(listTitle + "\n");
		System.out.println(sb.toString());
	}

	@Override
	public Runnable executeOption(int selection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int menuLength() {
		// TODO Auto-generated method stub
		return 0;
	}

}
