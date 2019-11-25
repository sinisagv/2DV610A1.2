package main.model;

import java.util.ArrayList;

public class Fleet {
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public boolean addVehicle(Vehicle v) {
		return vehicles.add(v);
	}
	
	public boolean removeVehicle(Vehicle v) {
		return false;
	}
	
	public boolean editVehicle(Vehicle v) {
		return false;
	}
}
