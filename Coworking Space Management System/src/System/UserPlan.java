package System;

public class UserPlan {
	private String type;
	private int remainHour;
	
	public UserPlan(String type, int remainHour) {
		this.type = type;
		this.remainHour = remainHour;
	}
	
	public String getType() {
		return this.type;
	}
	
	
	public int getRemainHour() {
		return this.remainHour;
	}
	public void consumeRemainHour(int amount ) {
		if(amount<this.remainHour) {
			this.remainHour -= amount;
		}
		else {
			System.out.println("Insufficient remaining hours.");
		}
	}
	public String getInfo() {
		return "User Plan: "+this.getType()+";\nRemain Hours: "+this.remainHour+".\n";
	}
}
