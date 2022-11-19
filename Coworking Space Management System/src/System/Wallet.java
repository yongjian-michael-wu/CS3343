package System;

import java.util.ArrayList;

public class Wallet {
	private double balance;
	private ArrayList<Payment> paymentHistory;
	
	public Wallet() {
		this.balance = 1000;
		this.paymentHistory = new ArrayList<Payment>();
	}
	
	public void topUp(double amount) {
		this.balance += amount;
	}
	
	public boolean pay(double amount, String description) {
		if(amount <= balance ) {
			paymentHistory.add(new Payment(amount, description));
			balance -= amount;
			System.out.println("Paid sucessfully.");
			return true;
		}
		else {
			System.out.println("Insufficient balance. Payment failed. ");
			return false;
		}
	}
	public String getInfo() {
		return "Wallet Balance: " + this.balance + "HKD;";
	}
}
