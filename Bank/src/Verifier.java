import java.io.*;
public class Verifier implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public String password;
	public int wrongtries;

	public Verifier(String pinput, int wtries){
        password = pinput;
        wrongtries = wtries;
	}
	
	public void accountLock(){
        System.out.println("Account is locked");
	}

}