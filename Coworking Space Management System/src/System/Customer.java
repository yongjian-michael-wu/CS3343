package System;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User {
	private String username;
	private String password;
	private Wallet wallet;
	private UserPlan plan;
	private ArrayList<ReserveRecord> reserveHistory;
	
	public Customer(String username, String password) {
		super();
		super.setRole(BasicPlanRole.getInstance());
		this.plan = new BasicPlan();
		this.username = username;
		this.password = password;
		this.wallet = new Wallet();
		this.reserveHistory = new ArrayList<ReserveRecord>();
	}

	public Wallet getWallet() {
		return this.wallet;
	}
	public String getUserName() {
		return this.username;
	}
	public UserPlan getPlan() {
		return this.plan;
	}

	public void convertUserPlan(String planName, int param) {
		if(planName.equals(this.plan.getType())) {
			System.out.println("Cannot change to the same plan.");
			return;
		}
		int remainHour = this.plan.getRemainHour();
		if(planName.equals("Basic")) {
			this.plan = new BasicPlan(remainHour);
			this.setRole(BasicPlanRole.getInstance());
			System.out.println("Convert to basic plan successfully.");
		}
		else if(planName.equals("Package")) {
			this.plan = new PackagePlan(param+remainHour);
			this.setRole(PackagePlanRole.getInstant());
			System.out.println("Convert to package plan successfully.");
		}
		else if(planName.equals("Monthly")) {
//			this.plan = new MonthlyPlan();
			System.out.println("Convert to monthly plan successfully.");
		}
	}
	
	@Override
	public String getInfo() {
		return "User ID: "+this.getId().toString()
				+";\nUser Name: "+this.getUserName()
				+";\nRole: "+this.getRole().toString()
				+";\n"+this.getPlan().getInfo()
				+this.getWallet().getInfo();
	}

	@Override
	public String getOpeningMessage() {
		return "\nHi dear "+this.getUserName()+", this is the management portal for our coworking space.\n"
				+ "Please type the abbreviation to select one of the following commands.\n"
				+ "Abbreviation:\t\tCommand:\n"
				+ "ChngPlan\tChange your current user plan;\n"
				+ "SignOut\t\tSign out;\n"
				+ "Info\t\tView your user information;\n"
				+ "Exit\t\tExit.\n";
	}
}
