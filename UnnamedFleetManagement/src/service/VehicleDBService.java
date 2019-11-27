package service;

import java.util.UUID;

import org.w3c.dom.Document;

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
	public boolean write() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean addVehicle(Vehicle vehicle) {
		if (vehicle.getID() == null || vehicle.getID() == "") {
			vehicle.setID(generateID());
		}
		
		return vehicles.addVehicle(vehicle) && write();
	}
	
	private String generateID() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString();
	}

	public boolean removeVehicle(Vehicle vehicle) {
		return false;
	}
	
	public Fleet getFleet() {
		return this.vehicles;
	}
	
	

}
