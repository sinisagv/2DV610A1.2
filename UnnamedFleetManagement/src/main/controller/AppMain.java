package main.controller;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import main.service.DBServiceFactory;
import main.service.VehicleDBService;
import main.view.MenuView;

public class AppMain {

	private ViewController viewController;
	private DBServiceFactory databaseFactory;
	private final String VEHICLE_DB_FILE_PATH = "src/main/service/vehicles.xml";

	public AppMain(ViewController viewController, DBServiceFactory databaseFactory) {
		this.viewController = viewController;
		this.databaseFactory = databaseFactory;
	}

	public void launch() {
		VehicleDBService vehicleDatabase = null;
		try {
			vehicleDatabase = databaseFactory.getVehicleDBService(VEHICLE_DB_FILE_PATH);
			MenuView mainMenu = new MenuView("Welcome to Unnamed Fleet Management Tool (name TBD)");
			MenuView fleetSummaryView = new MenuView(
					"Fleet Summary: " + vehicleDatabase.getFleet().size() + " vehicles registered.");
			fleetSummaryView.addOption("Back to main menu", () -> {
				viewController.showView(mainMenu).run();
			});

			mainMenu.addOption("Display Fleet Summary", () -> {
				viewController.showView(fleetSummaryView).run();
			});
			mainMenu.addOption("Quit", () -> System.exit(1));
			viewController.showView(mainMenu).run();
		} catch (IOException | ParserConfigurationException | SAXException e) {
			System.err.print("Unable to connect to database. Please contact your SysAdmin");
		}
		
	}

	public static void main(String[] args) {

		AppMain app = new AppMain(new ViewController(new Scanner(System.in)), new DBServiceFactory());
		app.launch();

	}

}
