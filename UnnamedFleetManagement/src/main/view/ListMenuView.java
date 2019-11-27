package main.view;

import java.util.List;

public class ListMenuView extends MenuView implements IView {

	private List<String> listItems;

	public ListMenuView(String listTitle, List<String> listItems) {
		super(listTitle);
		this.listItems = listItems;
	}


	@Override
	public void show() {
		StringBuffer sb = new StringBuffer(this.menuTitle + "\n");
		for(String str : listItems) {
			sb.append(str + "\n");
		}
		System.out.print(sb.toString());
	}

	

}
