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
	public boolean addVehicle(Vehicle v) {
		return false;
	}
	public boolean removeVehicle(Vehicle v) {
		return false;
	}
	public boolean addDriver(Driver d) {
		return false;
	}
	public boolean removeDriver(Driver d) {
		return false;
	}
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	
}
