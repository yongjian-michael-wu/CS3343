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
	public boolean consumeRemainHour(int amount ) {
		if(amount<this.remainHour) {
			this.remainHour -= amount;
			return true;
		}
		else {
			return false;
		}
	}
	public void addRemainHour(int amount) {
		this.remainHour+=amount;
	}
	public String getInfo() {
		return "User Plan: "+this.getType()+";\nRemain Hours: "+this.remainHour+".\n";
	}
}
