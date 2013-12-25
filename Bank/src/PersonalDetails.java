import java.io.*;

public class PersonalDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public String name,address;
	
	public PersonalDetails(){}
	public PersonalDetails(String nm,String add){
		name = nm;
		address = add;
	}

}
