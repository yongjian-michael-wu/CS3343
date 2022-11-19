package System;

import java.time.*;
import java.util.UUID;

public class Payment {
	private double amount;
	private UUID id;
	private LocalDateTime time;
	private Customer owner;
	private String description;
	
//	private LocalTime paidTime;
//	private boolean isPaid;
	
	public Payment(double amount, String description, Customer owner) {
		this.amount = amount;
		this.id = UUID.randomUUID();
		this.owner = owner;
		this.time = LocalDateTime.now();
		this.description = description;
	}
	public String toString() {
		return "\nPayment id: " + this.id
				+";\nPaid Time: " + this.time.toString()
				+";\nAmount: " + this.amount
				+";\nDescription: "+this.description+".\n";
	}
}
