package service;

import java.io.File;
import java.lang.reflect.Member;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import main.model.Fleet;
import main.model.Vehicle;

public class VehicleDBService implements IDBService {

	private String dbPath = "";
	private Document dataDoc;
	private Fleet vehicles = new Fleet();

	public VehicleDBService() throws Exception {

	}

	@Override
	public void read() {
		// TODO Auto-generated method stub

	}

	@Override
	public void write() {
		// TODO Auto-generated method stub

	}
	
	public boolean addVehicle(Vehicle vehicle) {
		if (vehicle.getID() == null || vehicle.getID() == "") {
			vehicle.setID("0");
		}
		write();
		return vehicles.addVehicle(vehicle);
	}
	
	public boolean removeVehicle(Vehicle vehicle) {
		return false;
	}
	
	public Fleet getFleet() {
		return this.vehicles;
	}

}
