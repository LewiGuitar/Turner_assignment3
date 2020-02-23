
public class SavingsAccountTest {
	
	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000);
		SavingsAccount saver2 = new SavingsAccount(3000);
		
		SavingsAccount.modifyInterestRate(.04);
		
		System.out.printf("\t\tsaver1\t\t\tsaver2");
		System.out.printf("%n\t\t--------------------------------%n");
		
		int i = 0;
		
		for(i = 0; i < 12; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			
			System.out.printf("%nMonth %d \t$%.2f\t\t$%.2f", i+1, saver1.getBalance(), saver2.getBalance());
		}
		
		SavingsAccount.modifyInterestRate(.05);
		
		System.out.printf("%n%n \t\t Annual Interest changed to 0.5");
		System.out.printf("%n\t\t--------------------------------%n");
		
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();		
		System.out.printf("%nMonth %d \t$%.2f\t\t$%.2f", i+1, saver1.getBalance(), saver2.getBalance());

		
	}
}
