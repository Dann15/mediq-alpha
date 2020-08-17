package me.shirvani.mediq.datatype.medicalstandard;

public class MedicalObject {
	
	public int RID;
	public String name;
	public String type;
	public String description;
	public Object value;
	public int[] parents;
	
	// THIS MUST BE IN THE SAME ORDER AS CONSTRUCTOR!!!!!!
	public static Object[] variableNamesList = {"RID","NAME","TYPE","DESCRIPTION","VALUE","PARENTS"}; 
	
	public MedicalObject(int RID, String name,
			String type,
			String description,
			Object value, 
			int... parents) { // parent int array, ints are for RIDS
		
		this.RID = RID;
		this.name = name;
		this.type = type;
		this.description = description;
		this.value = value;
		this.parents = parents;
		
	}
	
	/**
	 * 
	 * Converts Medical Object into array
	 * 
	 * i.e. ---> [1234,"patient name","description"....]
	 * 
	 * @return
	 */
	public Object[] toArray() {
		Object[] x = {RID,name,type,description,value,parents};
		return x;
	}
	
	
}
