package System;

import java.time.*;

public class Payment {
	private int amount;
	private LocalTime time;
//	private LocalTime paidTime;
//	private boolean isPaid;
	
	public Payment(int amount) {
		this.amount = amount;
		this.time = LocalTime.now();
//		this.isPaid = false;
	}
	
	public void pay() {
		
	}
}
