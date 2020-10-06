package com.galaxe.sonarQube.model;

import java.util.Date;


public class DateModel {
	
	private Date startDate;
	private Date endDate;
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "DateModel [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	public DateModel() {
		super();
	}
	public DateModel(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
}
