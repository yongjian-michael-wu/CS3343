package System;

public class MonthlyPlan extends UserPlan {
	private boolean isPrivate;
	
	public MonthlyPlan(boolean isPrivate) {
		super("Monthly", 0);
		this.isPrivate = isPrivate;
	}
	public MonthlyPlan(int remainHour, boolean isPrivate) {
		super("Monthly", remainHour);
		this.isPrivate = isPrivate;
	}
	@Override
	public String getInfo() {
		return "User Plan: "+this.getType()+";\nSpace Type: "
				+(this.isPrivate?"Private Slot.\n":"Common Slot.\n");
	}
	public boolean getPrivate() {
		return this.isPrivate;
	}
	
	
}
