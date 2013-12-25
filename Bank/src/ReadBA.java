import java.io.*;

public class ReadBA implements Serializable{

	private static final long serialVersionUID = 1L;
	private BankAccount bank[];
	int num;
	CreateBA ba_obj = new CreateBA();
	
	public BankAccount[] readBA(String filename) throws BadDataException,FileNotFoundException,IOException{
		
		try{
        	ba_obj.readFile("bankAccountDetailsFile.txt");
        	ba_obj.setValue(filename);
        	
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			num = ois.readInt();
			bank = new BankAccount[num];
			
			for (int i=0; i<num; i++)
				bank[i] = (BankAccount)ois.readObject();
			
			ois.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return bank;
	}

}
