package System;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReserveRecord {
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Payment payment;
	private UUID customerId;
	private UUID recordId;
	
	public ReserveRecord(LocalDateTime startTime, LocalDateTime endTime, Payment payment, UUID customerId) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.payment = payment;
		this.recordId = UUID.randomUUID();
		this.customerId = customerId;
	}

	public LocalDateTime getStartTime() {
		return this.startTime;
	}
	public LocalDateTime getEndTime() {
		return this.endTime;
	}
	
	
	public boolean checkOverlap(LocalDateTime startTime, LocalDateTime endTime) {
		return ((this.startTime.isBefore(startTime)&&this.endTime.isAfter(startTime))
				||(this.startTime.isBefore(endTime)&&this.endTime.isAfter(endTime))); 
	}
}
