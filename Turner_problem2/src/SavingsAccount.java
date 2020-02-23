
public class SavingsAccount {
	private static double annualInterestRate;
	private double savingsBalance;
	
	
	public SavingsAccount(double startingAmount) {
		this.savingsBalance = startingAmount;
	}
	
	public void calculateMonthlyInterest() {
		this.savingsBalance += this.savingsBalance * (annualInterestRate / (double) 12);
	}
	
	public static void modifyInterestRate(double newRate) {
		annualInterestRate = newRate;
	}
	
	public double getBalance() {
		double securityDummy = this.savingsBalance;
		return securityDummy;
	}
		
}
