package main.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import main.service.DBServiceFactory;
import main.service.VehicleDBService;

public class AppMain {
	
	private ViewController viewController;
	private DBServiceFactory databaseFactory;

	public AppMain(ViewController viewController, DBServiceFactory databaseFactory) {
		this.viewController = viewController;
		this.databaseFactory = databaseFactory;
	}
	
	public void launch() {
		VehicleDBService vehicleDatabase;
		try {
			vehicleDatabase = databaseFactory.getVehicleDBService("");
		} catch(IOException | ParserConfigurationException | SAXException e) {
			System.err.print("Unable to connect to database. Please contact your SysAdmin");
		}
		System.out.println("Welcome to the main menu");
		
	}

}
