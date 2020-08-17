package me.shirvani.mediq.errorhandler;

public class MQErrorHandler {

	public MQErrorHandler(String message) {
		// TODO broadcast error
		System.out.println(message);
	}
	
	public MQErrorHandler(Exception e) {
		// TODO broadcast error
		e.printStackTrace();
	}
	
}
