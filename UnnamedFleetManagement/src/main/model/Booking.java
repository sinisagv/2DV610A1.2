package main.model;

import java.util.ArrayList;

public class Booking {
	private Client client;
	private TimeFrame timeFrame;
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private ArrayList<Driver> drivers = new ArrayList<Driver>();

	public ArrayList<Driver> getDrivers() {
		return drivers;
	}

	public boolean addVehicle(Vehicle vehicle) {
		for (Vehicle v : vehicles) {
			if (v.equals(vehicle)) {
				return false;
			}
		}
		return vehicles.add(vehicle);
	}

	public boolean removeVehicle(Vehicle vehicle) {
		return vehicles.remove(vehicle);
	}

	public boolean addDriver(Driver driver) {
		for(Driver d : drivers) {
			if(d.equals(driver)) {
				return false;
			}
		}
		return drivers.add(driver);
	}

	public boolean removeDriver(Driver driver) {
		return false;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return this.client;
	}

	public boolean removeClient(Client client) {
		return false;
	}

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

}
