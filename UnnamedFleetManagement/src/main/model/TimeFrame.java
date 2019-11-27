package main.model;

import java.util.Date;

public class TimeFrame {
	private Date startDate;
	private Date endDate;

	public TimeFrame(Date d1, Date d2) {
		this.startDate = d1;
		this.endDate = d2;
	}

	public TimeFrame() {
		// TODO Auto-generated constructor stub
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public boolean overlapsWith(TimeFrame frame) {
		return !((this.startDate.after(frame.getEndDate()) || this.startDate.equals(frame.getEndDate()))
				|| (this.endDate.before(frame.getStartDate()) || this.endDate.equals(frame.getStartDate())));

	}
}
