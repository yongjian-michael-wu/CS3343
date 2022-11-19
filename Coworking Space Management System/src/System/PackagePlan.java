package System;

public class PackagePlan extends UserPlan {
	private int totalHour;
	
	public PackagePlan(int totalHour) {
		super("Package", totalHour);
		this.totalHour = totalHour;
	}
}
