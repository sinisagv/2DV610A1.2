package main.model;

import java.util.ArrayList;

public class Fleet {
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public boolean addVehicle(Vehicle v) {
		return vehicles.add(v);
	}
	
	public boolean removeVehicle(Vehicle v) {
		return vehicles.remove(v);
	}
	
	public boolean editVehicle(Vehicle v) {
		for(Vehicle vehicle : vehicles) {
			if(vehicle.getID().equals(v.getID())) {
				return removeVehicle(vehicle) && addVehicle(v);
			}
		}
		return false;
	}
}
