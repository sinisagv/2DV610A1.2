package model;

import java.util.Date;

public class TimeFrame {
	private Date startDate;
	private Date endDate;
	
	
	public TimeFrame(Date date, Date date2) {
		this.startDate = date;
		this.endDate = date2;
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
<<<<<<< HEAD
		return !(this.startDate.after(frame.getEndDate()) || this.endDate.before(frame.startDate));
=======
		return false;
>>>>>>> parent of 5bf4de5... RED
	}
}
