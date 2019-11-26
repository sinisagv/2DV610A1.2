package main.model;

import java.util.ArrayList;

public class Driver {
	private String name;
	private ArrayList<Qualification> qualifications = new ArrayList<Qualification>();
	private ArrayList<TimeFrame> schedule = new ArrayList<TimeFrame>();
	private String ID;

	public Driver() {
		super();
	}

	public Driver(String ID, String name, ArrayList<Qualification> qualifications, ArrayList<TimeFrame> schedule) {
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

	public ArrayList<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(ArrayList<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	public ArrayList<TimeFrame> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<TimeFrame> schedule) {
		this.schedule = schedule;
	}

	public boolean addShift(TimeFrame shift) {
		for (TimeFrame tf : schedule) {
			if (tf.overlapsWith(shift)) {
				return false;
			}
		}
		return schedule.add(shift);
	}

	public boolean removeShift(TimeFrame shift) {
		for (TimeFrame tf : schedule) {
			if ((shift.getStartDate().equals(tf.getStartDate())) && (shift.getEndDate().equals(tf.getEndDate()))) {
				return schedule.remove(tf);
			}
		}
		return false;
	}

	public boolean addQualification(Qualification qualification) {
		for (Qualification q : qualifications) {
			if (q.equals(qualification)) {
				return false;
			}
		}
		return qualifications.add(qualification);
	}

	public boolean removeQualifivation(Qualification qualificaition) {
		for (Qualification q : qualifications) {
			if (q.equals(qualificaition)) {
				return qualifications.remove(q);
			}
		}
		return false;
	}

	public boolean isAvailable(TimeFrame frame) {
		for(TimeFrame tf : schedule) {
			if(tf.overlapsWith(frame)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean equals(Driver driver) {
		return false;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

}
