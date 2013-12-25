import java.util.*;
import java.io.*;

public class ATMManager implements Serializable {

	private static final long serialVersionUID = 1L;
	public static void main(String args[]) throws BadDataException,IOException,FileNotFoundException
	{
      	ReadBA obj = new ReadBA();
      	
       	try{        		
      	BankAccount bAArray[] = obj.readBA("bankAccountFile");		

            List<BankAccount> aclist = new ArrayList<BankAccount>();
            Set<String> addset = new HashSet<String>();
            Set<String> repaddr = new HashSet<String>();
            Map<Long,BankAccount> accountmap = new HashMap<Long,BankAccount>();
            Map<ArrayList<Long>,String> finalmap = new HashMap<ArrayList<Long>,String>();

            for(BankAccount account : bAArray){
                accountmap.put(account.getAccountNo(),account);
                if(account.getBalance()>100000)
                   aclist.add(account);
                if(!addset.add(account.personal.address))
                	repaddr.add(account.personal.address);
            }

            for(String addr : addset){
                ArrayList<Long> acnoList = new ArrayList<Long>();
                for(BankAccount account : bAArray){
                    if(account.personal.address.equals(addr))
                       acnoList.add(account.getAccountNo());    
                }    
                finalmap.put(acnoList,addr);
            }
            
            System.out.println(finalmap);

   /*     		
        		PrintWriter outfile = new PrintWriter(new BufferedWriter(new FileWriter(new File("addressFile.txt"))));
                
        		for(int i=0;i<obj.num;i++)
                	outfile.println(bAArray[i].personal.address);
        		
        		outfile.close();
       */ 	}
        	catch (FileNotFoundException exception)
            {
               System.out.println("File not found.");
            }
            catch (BadDataException exception)
            {
               System.out.println("Bad data: " + exception.getMessage());
            }
            catch (IOException exception)
            {
               exception.printStackTrace();
            }
        	}
        	
/*        		
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter the account number");
                long acnum = scan.nextLong();
                String p = scan.nextLine();
                int index=-1;
                for(int i=0; i<1000; i++)
                   if (bAArray[i].getAccountNo()==acnum) index=i;
                
                if (index==-1) System.out.println("Account Number did not match");
                
                else if (bAArray[index].myVerifier.getPassword().compareTo(p)==0){
                     System.out.println("Verification successful");
                     bAArray[index].myVerifier.wrongtries=0;
                     }
                     else bAArray[index].myVerifier.wrongtries++;

                if(bAArray[index].myVerifier.wrongtries==3)
                bAArray[index].myVerifier.accountLock();
                
*/
}