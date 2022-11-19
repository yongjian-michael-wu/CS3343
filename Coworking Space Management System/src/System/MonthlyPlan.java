package System;

public class MonthlyPlan extends UserPlan {
	private boolean recurring;
	private boolean isPrivate;
	
	public MonthlyPlan(boolean isPrivate) {
		super("Monthly", 100*(isPrivate?2:1));
		this.recurring = false;
	}
}
