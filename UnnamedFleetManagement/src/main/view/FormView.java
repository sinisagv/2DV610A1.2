package main.view;

import java.util.ArrayList;

public class FormView  {
	
	ArrayList<String> prompts = new ArrayList<String>();
	
	public void show(int promptIndex) {
		System.out.print(prompts.get(promptIndex) + "\n");
	}

	public void addPrompt(String prompt) {
		prompts.add(prompt);
	}

	public int size() {
		return prompts.size();
	}

}
