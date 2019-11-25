package main.model;

import java.util.ArrayList;

public class Booking {
	private Client client;
	private TimeFrame timeFrame;
	private ArrayList<Vehicle> vehicles;
	private ArrayList<Driver> drivers;
	
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}
	public boolean addVehicle(Vehicle vehicle) {
		return false;
	}
	public boolean removeVehicle(Vehicle vehicle) {
		return false;
	}
	public boolean addDriver(Driver driver) {
		return false;
	}
	public boolean removeDriver(Driver driver) {
		return false;
	}
	public boolean addClient(Client client) {
		return false;
	}
	public boolean removeClient(Client client) {
		return false;
	}
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	
}
