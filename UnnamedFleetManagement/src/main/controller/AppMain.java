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
		VehicleDBService vehicleDatabase;
		try {
			vehicleDatabase = databaseFactory.getVehicleDBService(VEHICLE_DB_FILE_PATH);
		} catch(IOException | ParserConfigurationException | SAXException e) {
			System.err.print("Unable to connect to database. Please contact your SysAdmin");
			System.exit(0);
		}
		MenuView mainMenu = new MenuView("Welcome to Unnamed Fleet Management Tool (name TBD)");
		mainMenu.addOption("Quit", () -> System.exit(1));
		viewController.showView(mainMenu);
	}
	
	public static void main(String[] args) {
		
		AppMain app = new AppMain(new ViewController(new Scanner(System.in)), new DBServiceFactory());
		app.launch();
		
	}

}
