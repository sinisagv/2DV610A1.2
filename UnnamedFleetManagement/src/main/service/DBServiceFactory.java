package main.service;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class DBServiceFactory {
	
	public VehicleDBService getVehicleDBService(String dbPath) throws ParserConfigurationException, SAXException, IOException {
		return new VehicleDBService(dbPath);
	}
}
