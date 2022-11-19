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
}
