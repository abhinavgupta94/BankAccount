import java.io.*;
import java.util.*;

public class CreateBA implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private BankAccount Ba[];
	private int numberOfValues;
	
	public void readFile(String filename) throws BadDataException,FileNotFoundException,IOException 
	{
		FileReader reader = new FileReader(filename);
	      try 
	      {
	         Scanner in = new Scanner(reader);
	         readData(in);
	      }
	      finally
	      {
	         reader.close();
	      } 
	}
	
	private void readData(Scanner in) throws BadDataException
	   {
	      if (!in.hasNextInt()) throw new BadDataException("Length expected");
	      numberOfValues = in.nextInt();
	      Ba = new BankAccount[numberOfValues];
	      for (int i = 0; i < numberOfValues; i++)
	         readValue(in, i);

	      if (in.hasNext()) throw new BadDataException("End of file expected");	      
	   }

	   private void readValue(Scanner in, int i) throws BadDataException
	   {
	      if (!in.hasNext()) throw new BadDataException("Data value expected");
	      String name = in.next();
	      String address = in.next();
	      double iniDep = in.nextDouble();
	      Ba[i] = new BankAccount(iniDep,name,address);
	   }
	   
	   public void setValue(String filename) throws FileNotFoundException,IOException{
			try{
				FileOutputStream fout = new FileOutputStream(filename);
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				oos.writeInt(numberOfValues);
				
				for (int i = 0; i < numberOfValues; i++)
					oos.writeObject(Ba[i]);
						
				oos.close();
				
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
	   }
}