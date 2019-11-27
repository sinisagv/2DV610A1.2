package main.view;

import java.util.List;

public class ListMenuView extends MenuView implements IView {

	private List<String> listItems;

	public ListMenuView(String listTitle, List<String> listItems) {
		super(listTitle);
		this.listItems = listItems;
	}

	@Override
	public void addOption(String optionName, Runnable action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		StringBuffer sb = new StringBuffer(this.menuTitle + "\n");
		for(String str : listItems) {
			sb.append(str + "\n");
		}
		System.out.print(sb.toString());
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
