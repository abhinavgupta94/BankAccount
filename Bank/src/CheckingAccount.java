
public class CheckingAccount extends BankAccount{
	
	private static final long serialVersionUID = 1L;
	private int transactionCount;
    private static final int FREE_TRANSACTIONS = 3;
    private static final double TRANSACTION_FEE = 2.0;
     
	public CheckingAccount(double initialBalance,String name,String address)
	   {
	       super(initialBalance,name,address);
	       transactionCount = 0; 
	    }
	public void deposit(double amount) 
	    {  
		   transactionCount++;
	       super.deposit(amount); 
	    }
	    
	    public void withdraw(double amount) 
	    {  
	       transactionCount++;
	       super.withdraw(amount); 
	    }
	    public void deductFees()
	        {  
	           if (transactionCount > FREE_TRANSACTIONS)
	           {  
	              double fees = TRANSACTION_FEE *(transactionCount - FREE_TRANSACTIONS);
	              super.withdraw(fees);
	           }
	           transactionCount = 0;
	        }

}