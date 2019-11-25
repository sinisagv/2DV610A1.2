package main.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MenuView implements IView {
	
	private String menuTitle;
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
		StringBuilder sb = new StringBuilder(menuTitle + "\r\n");
		System.out.println(sb.toString());
		
	}

	@Override
	public void executeOption(int selection) {
		List<Runnable> actions = new ArrayList<Runnable>(options.values());
		actions.get(selection-1).run();
	}

	@Override
	public int optionSize() {
		
		return options.size();
	}

}
