package me.shirvani.mediq.datatype.medicalstandard;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import me.shirvani.mediq.datainteract.DatabaseFormatter;
import me.shirvani.mediq.errorhandler.MQErrorHandler;

public class MedicalDatabaseManager {
	private File csv;
	public static String FORMATTED_CSV_STANDARD_HEADING = DatabaseFormatter.formatObjectListToCSVEntry(MedicalObject.variableNamesList);
	
	/**
	 * Create a CSV Database for MedIQ
	 * 
	 * i.e. createCSVDatabse(new File("~/Desktop/cheese.csv"));
	 * 
	 * @param csv proposed file destination (with name) of new csv database
	 * @return Original proposed file OR null if doesn't work
	 */
	public static File createCSVDatabase(File csv) {
		try { // create file & check if exists
			if (csv.exists() || !csv.createNewFile()) {
				new MQErrorHandler("Error Creating CSV Database, proposed file already exists.");
				return null;
			}
		} catch (Exception e) {
			new MQErrorHandler(e);
			return null;
		}
		
		try (PrintWriter wr = new PrintWriter(csv)){ // write to new file
			wr.write(FORMATTED_CSV_STANDARD_HEADING);
		} catch (Exception e) {
			new MQErrorHandler(e);
			return null;
		}
		
		return csv;
	}
	
	public MedicalDatabaseManager(File csvDatabase) {
		this.csv = csvDatabase;
		
		if(!csvDatabase.exists()) {
			new MQErrorHandler("Requested database does not exist.");
		}
		
	}
	
	/**
	 * Converts medical object into a valid CSV Entry
	 */
	public static String formatMedicalObjecttoCSVEntry(MedicalObject obj) {
		return DatabaseFormatter.formatObjectListToCSVEntry(obj.toArray());
	}
	
	/**
	 * Appends medical object to CSV
	 * @param obj Medical object to append
	 */
	public void appendMedicalObject(MedicalObject obj) {
		
		if(doesRIDExist(obj.RID)) {
			new MQErrorHandler("Another Medical Object with the same RID exists.");
			return;
		}
		
		try { // create new line in CSV file with formatted Medical Object contents
			Files.write(Paths.get(csv.getPath()), (DatabaseFormatter.CSV_NEWLINE+formatMedicalObjecttoCSVEntry(obj)).getBytes(), StandardOpenOption.APPEND);
		} catch (Exception e) {
			new MQErrorHandler(e);
		}
	}
	
	// TODO check if a medical object exists
	public boolean doesRIDExist(int RID) {
		
//		public String searchCsvLine(int searchColumnIndex, String searchString) throws IOException {
//		    String resultRow = null;
//		    BufferedReader br = new BufferedReader(new FileReader("somefile.csv"));
//		    String line;
//		    while ( (line = br.readLine()) != null ) {
//		        String[] values = line.split(",");
//		        if(values[searchColumnIndex].equals(searchString)) {
//		            resultRow = line;
//		            break;
//		        }
//		    }
//		    br.close();
//		    return resultRow;
//		}
		
		
		return false; // stub
	}
		
	// TODO remove medical object
	public void removeRID(int RID) {
		
		if(!doesRIDExist(RID)) {
			new MQErrorHandler("Requested Medical Object does not exist (as checked by RID)");
			return;
		}
		
		
	}
	
	
}
