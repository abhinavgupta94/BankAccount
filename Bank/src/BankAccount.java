import java.io.*;

public class BankAccount implements ITRules,Comparable,Serializable{
	
	private static final long serialVersionUID = 1L;
	private double balance;
	private static final double MINBAL = 1000;
	private int trans;
	private static long startaccno = 180020131111L;
	private long accno;
	
	LastTransaction last = new LastTransaction();
	PersonalDetails personal = new PersonalDetails();
	Verifier myVerifier = new Verifier("abc123",0);
	
	public BankAccount(double initialBalance,String name,String address){
		balance = initialBalance;
		accno = startaccno++;
		personal.name = name;
		personal.address = address;
	}
	
	public void deposit(double amount){
		balance+=amount;
		trans++;
		last.lasttrans = "deposit";
	}
	
	public void withdraw(double amount){
		if(balance >= MINBAL+amount){
		balance-=amount;
		trans++;
		last.lasttrans = "withdraw";
		}
	}
	public double getBalance(){
		return balance;
	}
	
	public long getAccountNo(){
		return accno;
	}
	
	public int getTransactions(){
		return trans;
	}
	
	public void transfer(BankAccount acc1,double amount){
		double temp = balance;
		withdraw(amount);
		if(temp!=balance){
			acc1.deposit(amount);
			last.lasttrans = "transfer";
		}
	}
	
	public double calculateTax(double interest){
		double tax=0;
		
		if(interest > slab1 && interest <= slab2)	tax = 0.03*interest;
		else if(interest > slab2 && interest <= slab3)	tax = 0.04*interest;
		else if(interest > slab3 && interest <= slab4)	tax = 0.08*interest;
		else if(interest > slab4)	tax = 0.10*interest;
		return tax;
	}
	
	public int compare(Object obj){
		BankAccount other = (BankAccount) obj;
		if(balance > other.balance) return 1;
		else if(balance < other.balance) return -1;
		else return 0;
	}

	public String toString(){
		return "Account No. " + accno + " Name is " + personal.name + " Address is " + personal.address + " Last Transaction is " + last.lasttrans + " Balance is " + getBalance();
		
	}
}
