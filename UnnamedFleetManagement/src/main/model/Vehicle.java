package main.model;

import java.util.ArrayList;

public abstract class Vehicle {
	protected ArrayList<TimeFrame> schedule = new ArrayList<TimeFrame>();
	protected CargoType cargoType;
	protected int capacity;
	protected int volume;
	protected VehicleType type;
	protected String ID;
	
	public Vehicle() {
		super();
	}
	
	
	public Vehicle(ArrayList<TimeFrame> unavailability, CargoType cargoType, int capacity, int volume, VehicleType type, String ID) {
		super();
		this.schedule = unavailability;
		this.cargoType = cargoType;
		this.capacity = capacity;
		this.volume = volume;
		this.type = type;
		this.ID = ID;
	}



	public ArrayList<TimeFrame> getUnavailability() {
		return schedule;
	}
	public void setUnavailability(ArrayList<TimeFrame> unavailability) {
		this.schedule = unavailability;
	}
	public CargoType getCargoType() {
		return cargoType;
	}
	public void setCargoType(CargoType cargoType) {
		this.cargoType = cargoType;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public boolean isAvailable(TimeFrame frame) {
		for(TimeFrame tf : schedule) {
			if(frame.overlapsWith(tf)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean addUnvailability(TimeFrame frame) {
		for(TimeFrame tf : schedule) {
			if(frame.overlapsWith(tf)) {
				return false;
			}
		}
		return schedule.add(frame);
	}


	public VehicleType getType() {
		return type;
	}


	public void setType(VehicleType type) {
		this.type = type;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}
}
