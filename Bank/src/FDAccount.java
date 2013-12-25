public class FDAccount extends BankAccount{
	
	private static final long serialVersionUID = 1L;
	private int count=0;
	
	public FDAccount(double initialBalance,String name,String address){
		super(initialBalance,name,address);
	}
	
	public void deposit(double amount){
		if(count<1) super.deposit(amount);
		else System.out.println("Cannot deposit again");
		count++;
	}
	
	public void withdraw(double amount){
		System.out.println("Withdrawal not allowed");
	}
	
	public void transfer(BankAccount obj,double amount){
		System.out.println("Transfer not allowed");
	}
	
	public void addInterest(int count){
		if(count<12){
			double interest = getBalance()*6/100;
			super.deposit(interest);
		}
		else if(count>=12 && count<=36){
			double interest = getBalance()*7/100;
			super.deposit(interest);
		}
		else if(count>36){
			double interest = getBalance()*8/100;
			super.deposit(interest);
		}
	}
}
