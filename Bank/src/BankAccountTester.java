
public class BankAccountTester {

	public static void main(String[] args) {
		
		SavingAccount acc1 = new SavingAccount(5000,"abhinav","ah2",3);
		FDAccount acc2 = new FDAccount(2000,"misra","ch2");

//		acc2.deposit(1000);
//		acc2.withdraw(500);
		acc2.transfer(acc1,1000);
		acc1.transfer(acc2,500);
		
		System.out.println(acc1);
		System.out.println(acc2);
	
	}

}
