package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Scanner;

public class BubbleGumMachineCLI {

    private static final String MAIN_MENU_OPTION_ADD_COINS = "Insert coins";
	private static final String MAIN_MENU_OPTION_TURN_HANDLE = "Turn Handle";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_ADD_COINS, MAIN_MENU_OPTION_TURN_HANDLE, MAIN_MENU_OPTION_EXIT};

	private Menu menu;

	public BubbleGumMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		Scanner userInput = new Scanner(System.in);
		boolean running = true;
		while (running) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_ADD_COINS)) {
				// add coins to machine
			} else if (choice.equals(MAIN_MENU_OPTION_TURN_HANDLE)) {
				// turn the handle
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				running = false;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);

		BubbleGumMachineCLI cli = new BubbleGumMachineCLI(menu);
		cli.run();
	}
}
