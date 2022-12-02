package System;

import java.util.ArrayList;

public class Wallet {
	private double balance;
	private ArrayList<Payment> paymentHistory;
	private Customer owner;
	
	public Wallet(Customer owner) {
		this.balance = 1000;
		this.owner = owner;
		this.paymentHistory = new ArrayList<Payment>();
		
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void topUp(double amount, String description) {
		this.balance += amount;
		ManagementPortal managementPortal = ManagementPortal.getInstance();
		Payment payment = new Payment(amount, description, this.owner);
		paymentHistory.add(payment);
		managementPortal.addPayment(payment);
	}
	
	public Payment pay(double amount, String description) { 
		if(amount <= balance ) {
			balance -= amount;
			ManagementPortal managementPortal = ManagementPortal.getInstance();
			Payment payment = new Payment(-amount, description, this.owner);
			paymentHistory.add(payment);
			managementPortal.addPayment(payment);
			System.out.print("Paid sucessfully.\n");
			return payment;
		}
		else {
			System.out.print("Insufficient balance. Payment failed.\n");
			return null;
		}
	}
	public String getInfo() {
		return "Wallet Balance: " + this.balance + "HKD.\n";
	}
	public void printPaymentHistory() {
		System.out.print("Here're all past payment record: ");
		for(Payment p:paymentHistory) {
			System.out.println("--------------------------");
			System.out.print(p.toString());
		}
	}
}
