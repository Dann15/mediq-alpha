package me.shirvani.mediq.datainteract;

import me.shirvani.mediq.errorhandler.MQErrorHandler;

public class DatabaseFormatter {

	public static String CSV_SPACER = ",";
	public static String CSV_NEWLINE = "\n";
	public static String CSV_ARRAY_START = "{"; // start could equal end, doesn't actually matter. It just matters for detection of array
	public static String CSV_ARRAY_END = "}";
	public static String CSV_INTRAOBJECT_SEPERATOR = "|"; // seperates components within a csv object
	
	
	/**
	 * Formats object list into a string that can be directly written into a CSV file, where each object is a separate CSV Cell. 
	 * <br /><br />
	 * i.e. <code>new Object[] {"Name","Date","Age"}</code> becomes {@code "Name,Date,Age\n"}. <br />
	 * assuming {@code String CSV_SPACER = ","} and {@code String CSV_NEWLINE = "\n"} in this class ({@code DatabaseFormatter})
	 * 
	 * @param array List of objects to format
	 * @return Formatted String that can be directly inputted into CSV as a list of cells in a single CSV line
	 */
	public static String formatObjectListToCSVEntry(Object... array) {
		try {
			String x = "";
			int counter = 0;
			for (Object o : array) {
				if(counter != array.length-1) {
					x+=o.toString()+CSV_SPACER;
				} else {
					x+=o.toString()+CSV_NEWLINE;
				}
				counter++;
			}
			return x;
		} catch (Exception e) {
			new MQErrorHandler(e);
		}
		return null;
	}
	
	/**
	 * Formats object list into a string that can be directly written into a CSV file, where each object is a part of a single CSV cell. 
	 * <br /><br />
	 * i.e. <code>new Object[] {"Person1","Person2","Person3"}</code> becomes <code>"{Person1|Person2|Person3}"</code>. <br />
	 * assuming <code>String CSV_ARRAY_START = "{"</code> and <code>String CSV_ARRAY_END = "}"</code> and <code>String CSV_INTRAOBJECT_SEPERATOR = "|"</code> in this class ({@code DatabaseFormatter})
	 * 
	 * @param array List of objects to format
	 * @return Formatted String as a CSV Cell
	 */
	public static String formatObjectListToCSVCell(Object... array) {
		
		if(array.length == 0) return CSV_ARRAY_START+CSV_ARRAY_END;
		
		String x = CSV_ARRAY_START;
		int counter = 0;
		
		for(Object item : array) {
			
			if(counter==array.length-1) {
				x+=item.toString();
				break;
			}
			
			x+=item.toString()+CSV_INTRAOBJECT_SEPERATOR;
			counter++;
		}
		
		return x+CSV_ARRAY_END;
	}
	
	/**
	 * Checks if {@code csvCell} classifies as an array. 
	 * <br />
	 * Functions by checking to see if {@code csvCell} starts with {@code CSV_ARRAY_START} & {@code CSV_ARRAY_END}.
	 * 
	 * @param csvCell
	 * @return if CSV cell classifies as an array
	 */
	public static boolean isCSVCellArray(String csvCell) {
		return csvCell.startsWith(CSV_ARRAY_START) && csvCell.startsWith(CSV_ARRAY_END);
	}
	
	/**
	 * Formats CSV cell contents, assumes it is an array, and reconstructs the object that it used to be, as a string array 
	 * <br /><br />
	 * i.e. <code>"{Person1|Person2|Person3}"</code> becomes <code>new Object[] {"Person1","Person2","Person3"}</code>. <br />
	 * assuming <code>String CSV_ARRAY_START = "{"</code> and <code>String CSV_ARRAY_END = "}"</code> and <code>String CSV_INTRAOBJECT_SEPERATOR = "|"</code> in this class ({@code DatabaseFormatter})
	 * 
	 * @throws MQErrorHandler call if CSV Cell is not an array
	 * @param array List of objects to format
	 * @return Formatted String as a CSV Cell
	 */
	public static String[] formatCSVCellToObjectArray(String csvCell) {
		if(!isCSVCellArray(csvCell)) {
			new MQErrorHandler("Object '"+csvCell+"' is not a valid array.");
			return null;
		}
		
		String arrayContents = csvCell.substring(CSV_ARRAY_START.length(), csvCell.length()-CSV_ARRAY_END.length());
		
		if(arrayContents.length() == 0) return new String[] {};
		
		return arrayContents.split(CSV_INTRAOBJECT_SEPERATOR);
	}

	
}
