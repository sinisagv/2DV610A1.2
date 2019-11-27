package main.view;

import java.util.List;

public class ListMenuView implements IView {

	private String listTitle;
	private List<String> listItems;

	public ListMenuView(String listTitle, List<String> listItems) {
		this.listTitle = listTitle;
	}

	@Override
	public void addOption(String optionName, Runnable action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
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