package main.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MenuView implements IView {
	
	protected String menuTitle;
	private LinkedHashMap<String, Runnable> options = new LinkedHashMap<String, Runnable>();
	
	public MenuView(String menuTitle) {
		this.menuTitle = menuTitle;
	}
	
	@Override
	public void addOption(String optionName, Runnable action) {
		options.put(optionName, action);
	}

	@Override
	public void show() {
		StringBuilder sb = new StringBuilder(menuTitle + "\n");
		ArrayList<String> optionNames = new ArrayList<String>(options.keySet());
		int i = 1;
		for(String str : optionNames) {
			sb.append(i++ + ". " + str + "\n");
		}
		System.out.print(sb.toString());
	}

	@Override
	public Runnable executeOption(int selection) {
		List<Runnable> actions = new ArrayList<Runnable>(options.values());
		
		return actions.get(selection - 1);
	}

	@Override
	public int menuLength() {
		
		return options.size();
	}

}
