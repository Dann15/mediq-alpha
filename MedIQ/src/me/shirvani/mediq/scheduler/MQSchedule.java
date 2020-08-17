package me.shirvani.mediq.scheduler;

public class MQSchedule {
	private String name;
	
	public MQSchedule(String name) {
		this.name = name;
	}
	
	/**
	 * @return Name of schedule.
	 */
	public String getName() {
		return this.name;
	}
	
	public MQScheduleItem[] scheduleItems = {};
	
}
