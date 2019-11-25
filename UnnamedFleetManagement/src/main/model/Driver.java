package main.model;

import java.util.ArrayList;

public class Driver {
	private String name;
	private ArrayList<Qualifications> qualifications = new ArrayList<Qualifications>();
	private ArrayList<TimeFrame> schedule = new ArrayList<TimeFrame>();

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
		for(TimeFrame tf: schedule) {
			if(shift.overlapsWith(tf)) {
				return false;
			}
		}
		return schedule.add(shift);
	}
	
	public boolean removeShift(TimeFrame shift) {
		return false;
	}
	
	public boolean addQualification(Qualifications q) {
		return false;
	}
	public boolean removeQualifivation(Qualifications q) {
		return false;
	}
	public boolean isAvailable(TimeFrame frame) {
		return false;
	}

}
