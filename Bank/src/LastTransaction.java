import java.io.*;

public class LastTransaction implements Serializable{

	private static final long serialVersionUID = 1L;
	public String lasttrans;
	
	public LastTransaction(){}	
	public LastTransaction(String s){
		lasttrans = s;	
	}

}
