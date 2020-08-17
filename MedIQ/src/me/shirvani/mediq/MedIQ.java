package me.shirvani.mediq;

import java.io.File;

import me.shirvani.mediq.datatype.medicalstandard.MedicalDatabaseManager;
import me.shirvani.mediq.datatype.medicalstandard.MedicalObject;

public class MedIQ {

	public static void main(String[] args) {
		File csv = new File("/Users/ebbinghaus-mac/Desktop/beanos.csv");
		MedicalObject obj = new MedicalObject(123, "beans1", "type2", "description3", "value4", new int[] {1});
		
		MedicalDatabaseManager.createCSVDatabase(csv);
		
		MedicalDatabaseManager manager = new MedicalDatabaseManager(csv);
		manager.appendMedicalObject(obj);
		
		System.out.println("poopface".substring(1, "poopface".length()-1));
		
		//System.out.println( MedicalDatabaseFormatter.converListtoCSVFormat("pee","poo","ann") );
		
	}
	
}
