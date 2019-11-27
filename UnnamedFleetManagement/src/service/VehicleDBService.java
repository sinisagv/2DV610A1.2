package service;

import org.json.*;

import main.model.Fleet;
import main.model.Vehicle;

public class VehicleDBService implements IDBService {
	
	Fleet vehicles = new Fleet();

	public void vehicleToJsonObject(Vehicle vehicle) {	

	}

	@Override
	public void write() {
		// TODO Auto-generated method stub

	}


	public Vehicle parseJsonVehicle(JSONObject jo) {
		return null;

	}

	@Override
	public void read() {
		// TODO Auto-generated method stub

	}
	
	public boolean addVehicle(Vehicle v) {
		return false;
	}
	
	public boolean removeVehicle(Vehicle v) {
		return false;
	}


}
