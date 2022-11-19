package System;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReserveRecord {
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Payment payment;
	private UUID customerId;
	
	public ReserveRecord(LocalDateTime startTime, LocalDateTime endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public LocalDateTime getStartTime() {
		return this.startTime;
	}
}
