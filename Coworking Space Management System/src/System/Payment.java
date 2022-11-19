package System;

import java.time.*;

public class Payment {
	private double amount;
	private LocalDateTime time;
	private String description;
	
//	private LocalTime paidTime;
//	private boolean isPaid;
	
	public Payment(double amount, String description) {
		this.amount = amount;
		this.time = LocalDateTime.now();
		this.description = description;
	}
}
