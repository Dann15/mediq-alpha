package me.shirvani.mediq.scheduler;

import java.util.Date;

public class MQScheduleItem {
	public boolean display;
	public String title;
	public String details;
	public String hiddenDetails;
	public Date dateTime = null; 
	
	public MQScheduleItem(Date dateTime, String title, String details, String hiddenDetails) {
		this.dateTime = dateTime;
		this.title = title;
		this.details = details;
		this.hiddenDetails = hiddenDetails;
	}
	
	public MQScheduleItem(String title, String details, String hiddenDetails) {
		this.title = title;
		this.details = details;
		this.hiddenDetails = hiddenDetails;
	}
	
}