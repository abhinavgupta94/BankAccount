public class SavingAccount extends BankAccount{
	
	private static final long serialVersionUID = 1L;
	private double interestRate;
	
	public SavingAccount(double initialBalance,String name,String address,double rate){
		super(initialBalance,name,address);
		interestRate = rate;
	}
	
	public void addInterest(){
		double interest = getBalance()*interestRate/100;
		double taxDeducted = super.calculateTax(interest);
		super.deposit(interest-taxDeducted);
	}	
	
}
