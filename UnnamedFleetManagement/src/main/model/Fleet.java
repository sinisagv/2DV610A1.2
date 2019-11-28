package main.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Fleet implements Iterable<Vehicle>{
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public boolean addVehicle(Vehicle vehicle) {
		for(Vehicle v : vehicles) {
			if(v.getID().equals(vehicle.getID())) {
				return false;
			}
		}
		return vehicles.add(vehicle);
	}
	
	public boolean removeVehicle(Vehicle vehicle) {
		return vehicles.remove(vehicle);
	}
	
	public boolean editVehicle(Vehicle vehicle) {
		for(Vehicle v : vehicles) {
			if(vehicle.getID().equals(v.getID())) {
				removeVehicle(v);
				addVehicle(vehicle);
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		return this.vehicles.size();
	}

	@Override
	public Iterator<Vehicle> iterator() {
		return vehicles.iterator();
	}
}
