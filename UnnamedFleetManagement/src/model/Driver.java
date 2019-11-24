package model;

import java.util.ArrayList;

public class Driver {
	private String name;
	private ArrayList<Qualifications> qualifications;
	private ArrayList<TimeFrame> schedule;

	public Driver() {
		super();
	}

	public Driver(String name, ArrayList<Qualifications> qualifications, ArrayList<TimeFrame> schedule) {
		super();
		this.name = name;
		this.qualifications = qualifications;
		this.schedule = schedule;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Qualifications> getQualifications() {
		return qualifications;
	}

	public void setQualifications(ArrayList<Qualifications> qualifications) {
		this.qualifications = qualifications;
	}

	public ArrayList<TimeFrame> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<TimeFrame> schedule) {
		this.schedule = schedule;
	}
	
	public boolean addShift(TimeFrame shift) {
		return false;
	}
	
	public boolean removeShift(TimeFrame shift) {
		return false;
	}
	
	public boolean addQualifications(TimeFrame shift) {
		return false;
	}
	public boolean removeQualifivation(TimeFrame shift) {
		return false;
	}
	public boolean isAvailable(TimeFrame frame) {
		return false;
	}

}
