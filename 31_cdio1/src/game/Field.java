package game;

public class Field {

	
	private String name;
	public int value; 
	public int fieldNumber;

	public Field (String name) {
		this.name = name; 
	}
	public void value (int value){
	this.value = value; 
	}
	public String getName(){
		return name;
	}
	public Field(int fieldNumber){
		this.fieldNumber = fieldNumber;
	}
	public int getFieldNumber(){
		return fieldNumber;
	}
}
