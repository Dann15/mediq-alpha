package me.shirvani.mediq.scheduler;

import java.util.ArrayList;

public class MQScheduleManager {

	// Names should be autogenned, DR NAME + DATE
	
	private static ArrayList<MQSchedule> registeredSchedules = new ArrayList<MQSchedule>();
	
	/**
	 * @param name Name of schedule
	 * @return if Schedule exists in registered schedule list
	 */
	public static boolean isScheduleRegistered(String name) {
		for(MQSchedule schedule : registeredSchedules) {
			if(schedule.getName() == name) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Remove schedule from registeredSchedule list.
	 * @param name Name of schedule
	 */
	public static void deregisterSchedule(String name) {
		if(!isScheduleRegistered(name)) return;
		
		ArrayList<MQSchedule> updatedSchedulesList = new ArrayList<MQSchedule>();
		for(MQSchedule schedule : registeredSchedules) {
			if(schedule.getName() != name) {
				updatedSchedulesList.add(schedule);
			}
		}
		
		registeredSchedules = updatedSchedulesList;
	}
	
	/**
	 * Add schedule to registeredSchedule list.
	 * @param schedule
	 */
	public static void registerSchedule(MQSchedule schedule) {
		registeredSchedules.add(schedule);
	}
	
	/**
	 * @return List of <code>MQSchedule</code>
	 */
	public static MQSchedule[] getRegisteredSchedules() {
		return (MQSchedule[]) registeredSchedules.toArray();
	}
	
}
