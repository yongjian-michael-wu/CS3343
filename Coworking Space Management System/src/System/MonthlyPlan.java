package System;

public class MonthlyPlan extends UserPlan {
	private boolean recurring;
	private boolean isPrivate;
	
	public MonthlyPlan(int remainHour) {
		super("Monthly", remainHour);
		this.recurring = false;
	}
	@Override
	public String getInfo() {
		return "User Plan: "+this.getType()+";\nSpace Type: "
				+(this.isPrivate?"Private Slot.\n":"Common Slot.\n");
	}
	
	
}
