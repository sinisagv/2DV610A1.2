package model;

import java.util.ArrayList;

public abstract class Vehicle {
	private ArrayList<TimeFrame> unavailability = new ArrayList<TimeFrame>();
	private CargoType cargoType;
	private int capacity;
	private int volume;
	private VehicleType type;
	private String ID;
	
	public Vehicle() {
		super();
	}
	
	
	public Vehicle(ArrayList<TimeFrame> unavailability, CargoType cargoType, int capacity, int volume, VehicleType type) {
		super();
		this.unavailability = unavailability;
		this.cargoType = cargoType;
		this.capacity = capacity;
		this.volume = volume;
		this.setType(type);
	}



	public ArrayList<TimeFrame> getUnavailability() {
		return unavailability;
	}
	public void setUnavailability(ArrayList<TimeFrame> unavailability) {
		this.unavailability = unavailability;
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
		for(TimeFrame tf : unavailability) {
			if(frame.overlapsWith(tf)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean addUnvailability(TimeFrame frame) {
		return unavailability.add(frame);
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
