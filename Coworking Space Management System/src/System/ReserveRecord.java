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
	public ReserveRecord(UUID id, LocalDateTime startTime, LocalDateTime endTime, Payment payment, Customer customer, Space space) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.payment = payment;
		this.id = id;
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
	public double getPrice() {
		return this.payment.getAmount();
	}
	public UUID getId() {
		return this.id;
	}
	public Customer getCustomer() {
		return this.customer;
	}
	public String toString() {
		return "\nReservation id: " + this.id.toString()+";\n"
				+ "Start Time: " + this.startTime.toString()+";\n"
				+ "End Time: " + this.endTime.toString()+";\n"
				+ "Space type: "+this.space.getTypeName()+";\n"
				+ "Customer: "+this.customer.getUserName()+".\n"; 
	}
	// true when overlap happened
	public boolean checkOverlap(LocalDateTime startTime, LocalDateTime endTime) {
		return (((this.startTime.isBefore(startTime)||this.startTime.isEqual(startTime))&&this.endTime.isAfter(startTime))
				||(this.startTime.isBefore(endTime)&&(this.endTime.isAfter(endTime)||this.endTime.isEqual(endTime)))
				||((startTime.isBefore(this.startTime)||startTime.isEqual(this.startTime))&&endTime.isAfter(this.startTime))
				||(startTime.isBefore(this.endTime)&&(endTime.isAfter(this.endTime)||endTime.isAfter(this.endTime)))); 
	}
}
