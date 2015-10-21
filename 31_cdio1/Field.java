package game;

public class Field {

	//initialisering af variable
	private String name;
	public int value; 
	public int fieldNumber;

	
	//Setter således at vi kan sætte navn på felt
	public void setFieldName (String name) {
		this.name = name; 
	}
	//Setter således at vi kan sætte en værdi på feltet
	public void value (int value){
	this.value = value; 
	}
	//Getter således at vi kan få navnet på vores felt
	public String getName(){
		return name;
	}
	//Setter vores fieldnummer fra 0-11
	public Field(int fieldNumber){
		this.fieldNumber = fieldNumber;
	}
	//Getter således at vi kan indhente data om hvilket felt vi er på.
	public int getFieldNumber(){
		return fieldNumber;
	}
}
