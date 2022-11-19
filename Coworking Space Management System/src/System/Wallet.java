package System;

public class Wallet {
	private double balance;
	
	public Wallet() {
		this.balance = 1000;
	}
	
	public void topUp(double amount) {
		this.balance += amount;
	}
	
	public boolean pay(double amount) {
		if(amount <= balance ) {
			balance -= amount;
			System.out.println("Paid sucessfully.");
			return true;
		}
		else {
			System.out.println("Insufficient balance. Payment failed. ");
			return false;
		}
	}
}
