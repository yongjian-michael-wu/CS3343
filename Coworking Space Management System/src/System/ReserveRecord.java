package System;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReserveRecord {
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Payment payment;
	private Customer customer;
	private Space space;
	private UUID id;
	
	
	public ReserveRecord(LocalDateTime startTime, LocalDateTime endTime, Payment payment, Customer customer, Space space) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.payment = payment;
		this.id = UUID.randomUUID();
		this.customer = customer;
		this.space = space;
	}

	public LocalDateTime getStartTime() {
		return this.startTime;
	}
	public LocalDateTime getEndTime() {
		return this.endTime;
	}
	public Space getSpace() {
		return this.space;
	}
	public UUID getId() {
		return this.id;
	}
	
	public boolean checkOverlap(LocalDateTime startTime, LocalDateTime endTime) {
		return ((this.startTime.isBefore(startTime)&&this.endTime.isAfter(startTime))
				||(this.startTime.isBefore(endTime)&&this.endTime.isAfter(endTime))); 
	}
}
